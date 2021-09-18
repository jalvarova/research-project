package walavo.ks8.cloud.client;

import io.minio.MinioClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import walavo.ks8.cloud.properties.NoteProperties;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class MinioConnect {

    @Autowired
    private NoteProperties properties;

    private static final List<String> schemasHttp = Arrays.asList("https://", "http://");

    private static final String TWO_POINTS = ":";

    public MinioClient getInstance() throws InterruptedException {
        return initMinio();
    }

    private MinioClient initMinio() throws InterruptedException {
        boolean success = false;
        MinioClient minioClient = null;
        while (!success) {
            try {
                minioClient = new MinioClient(
                        hostBucket(properties.isSecured()),
                        properties.getMinioAccessKey(),
                        properties.getMinioSecretKey(),
                        properties.isSecured());
                // Check if the bucket already exists.
                boolean isExist = minioClient.bucketExists(properties.getMinioBucket());
                if (isExist) {
                    log.info("> Bucket already exists.");
                } else {
                    minioClient.makeBucket(properties.getMinioBucket());
                }
                success = true;
            } catch (Exception e) {
                e.printStackTrace();
                log.info("> Minio Reconnect: " + properties.isMinioReconnectEnabled());
                if (properties.isMinioReconnectEnabled()) {
                    Thread.sleep(5000);
                } else {
                    success = true;

                }
            }
        }
        log.info("> Minio initialized!");
        return minioClient;
    }

    private String hostBucket(boolean isSecured) {
        String hostBucket;
        if (isSecured) {
            hostBucket = schemasHttp.get(0) + properties.getMinioHost() + TWO_POINTS + properties.getPort();
        } else {
            hostBucket = schemasHttp.get(1) + properties.getMinioHost() + TWO_POINTS + properties.getPort();
        }
        return hostBucket;
    }
}
