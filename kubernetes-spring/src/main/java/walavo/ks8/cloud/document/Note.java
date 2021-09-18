package walavo.ks8.cloud.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "notes")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Note {
    @Id
    private String id;
    private String fileId;
    private String fileName;
    private String description;
    @JsonFormat(pattern = "E, dd MMM yyyy HH:mm:ss")
    private LocalDateTime date;
    @JsonFormat(pattern = "E, dd MMM yyyy HH:mm:ss")
    private LocalDateTime dateUpdate;
    private boolean status;

}