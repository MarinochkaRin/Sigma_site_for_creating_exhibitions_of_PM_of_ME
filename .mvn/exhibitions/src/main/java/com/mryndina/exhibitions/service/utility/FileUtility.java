package com.mryndina.exhibitions.service.utility;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileUtility {
    public static String saveFile(MultipartFile file, String uploadDir) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path uploadPath = Path.of(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException e) {
            throw new IOException("Failed to save file: " + fileName, e);
        }
    }
}
