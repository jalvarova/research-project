package walavo.ks8.cloud.util;

import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;
import java.util.UUID;

public final class NoteUtil {

    public static boolean actionPublishImage(String publish) {
        return Objects.nonNull(publish) && publish.equals("Publish");
    }

    public static boolean actionUploadImage(String upload) {
        return Objects.nonNull(upload) && upload.equals("Upload");
    }

    public static boolean validFileNotNull(MultipartFile file) {
        return Objects.nonNull(file) && file.getOriginalFilename() != null
                && !file.getOriginalFilename().isEmpty();
    }
    public static String buildFileId(MultipartFile file){
        return UUID.randomUUID() + "." + file.getOriginalFilename().split("\\.")[0];
    }
}
