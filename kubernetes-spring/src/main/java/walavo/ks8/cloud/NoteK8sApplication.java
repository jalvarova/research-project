package walavo.ks8.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import walavo.ks8.cloud.properties.NoteProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = NoteProperties.class)
public class NoteK8sApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoteK8sApplication.class, args);
    }

}
