package com.mryndina.exhibitions.config.storage;

import com.mryndina.exhibitions.util.files.S3Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.Map;

@Configuration
public class StorageConfiguration {

    @Bean
    public S3Service imageFileClient(
            @Value("${app.file.s3.endpoint}") String endpoint,
            @Value("${app.file.s3.region}") String region,
            @Value("${app.file.s3.bucket}") String bucket
    ){
        return new S3Service(Map.of(
                "endpoint", endpoint,
                "region", region,
                "bucket", bucket
        ));
    }

}
