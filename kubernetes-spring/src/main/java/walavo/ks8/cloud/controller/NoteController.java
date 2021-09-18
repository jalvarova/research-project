package walavo.ks8.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import walavo.ks8.cloud.client.MinioConnect;
import walavo.ks8.cloud.document.Note;
import walavo.ks8.cloud.properties.NoteProperties;
import walavo.ks8.cloud.repository.NoteRepository;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static walavo.ks8.cloud.util.NoteUtil.*;

@Slf4j
@Controller
public class NoteController {

    @Autowired
    private NoteProperties properties;

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private MinioConnect minioConnect;

    private final Parser parser = Parser.builder().build();
    private final HtmlRenderer renderer = HtmlRenderer.builder().build();

    @GetMapping("/")
    public String index(Model model) {
        getAllNotes(model);
        return "index";
    }

    @GetMapping(value = "/img/{name}", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody
    byte[] getImageByName(@PathVariable String name) throws Exception {
        InputStream imageStream = minioConnect.getInstance().getObject(properties.getMinioBucket(), name);
        return IOUtils.toByteArray(imageStream);
    }

    @PostMapping("/note")
    public String saveNotes(@RequestParam("image") MultipartFile file,
                            @RequestParam String description,
                            @RequestParam String filename,
                            @RequestParam(required = false) String publish,
                            @RequestParam(required = false) String upload,
                            Model model) throws Exception {

        String fileId = buildFileId(file);

        if (actionPublishImage(publish)) {
            saveNote(fileId, filename, description, model);
            getAllNotes(model);
            return "redirect:/";
        }
        if (actionUploadImage(upload)) {
            if (validFileNotNull(file)) {
                uploadImage(file, fileId, description, model);
            }
            getAllNotes(model);
            return "index";
        }
        // After save fetch all notes again
        return "index";
    }

    private void uploadImage(MultipartFile file, String fileId, String description, Model model) throws Exception {
        minioConnect.getInstance().putObject(properties.getMinioBucket(), fileId, file.getInputStream(),
                file.getSize(), null, null, file.getContentType());
        model.addAttribute("description",
                description + " ![](/img/" + fileId + ")");
    }

    private void getAllNotes(Model model) {
        List<Note> notes = noteRepository.findAll();
        Collections.reverse(notes);
        model.addAttribute("notes", notes);
    }

    private void saveNote(String fileId, String filename, String description, Model model) {
        if (description != null && !description.trim().isEmpty()) {
            Node document = parser.parse(description.trim());
            String html = renderer.render(document);
            noteRepository.save(Note
                    .builder()
                    .id(null)
                    .fileId(fileId)
                    .fileName(filename)
                    .description(html)
                    .date(LocalDateTime.now())
                    .status(true)
                    .build());
            //After publish you need to clean up the textarea
            model.addAttribute("description", "");
        }
    }
}
