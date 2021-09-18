package walavo.ks8.cloud.properties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "knote")
public class NoteProperties {

    @Value("${minio.host:localhost}")
    private String minioHost;

    @Value("${minio.bucket:data}")
    private String minioBucket;

    @Value("${minio.secured:false}")
    private boolean isSecured;

    @Value("${minio.bucket.port:9000}")
    private int port;

    @Value("${minio.access.key:minioadmin}")
    private String minioAccessKey;

    @Value("${minio.secret.key:minioadmin}")
    private String minioSecretKey;

    @Value("${minio.useSSL:false}")
    private boolean minioUseSSL;

    @Value("${minio.reconnect.enabled:true}")
    private boolean minioReconnectEnabled;


}