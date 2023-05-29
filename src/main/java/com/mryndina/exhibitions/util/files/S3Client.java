package com.mryndina.exhibitions.util.files;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Slf4j
public class S3Client {

    AmazonS3 amazonS3;
    String bucket;

    public S3Client(Map<String, String> configuration) {
        String region = configuration.get("region");
        String endpoint = configuration.get("endpoint");
        this.bucket = configuration.get("bucket");
        this.amazonS3 = AmazonS3ClientBuilder.standard()
                .withPathStyleAccessEnabled(true)
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpoint, region))
                .build();
    }

    @SneakyThrows
    public void putFile(String filename, String path, MultipartFile file) {
        log.info("Put file '{}'", filename);
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());
        amazonS3.putObject(bucket, String.format("%s/%s", path, filename), file.getInputStream(), metadata);
    }

    public File getFile(String filename, String path) {
        log.info("Get file '{}'", filename);
        S3Object s3Object = amazonS3.getObject(bucket, String.format("%s/%s", path, filename));
        ObjectMetadata objectMetadata = s3Object.getObjectMetadata();
        return File.builder()
                .name(filename)
                .content(s3Object.getObjectContent())
                .size(objectMetadata.getContentLength())
                .build();
    }

}
