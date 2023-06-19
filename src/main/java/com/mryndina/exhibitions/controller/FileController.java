package com.mryndina.exhibitions.controller;

import com.amazonaws.util.IOUtils;
/*import com.mryndina.exhibitions.service.FileService;*/
import com.mryndina.exhibitions.service.UserService;
import com.mryndina.exhibitions.util.files.File;
import com.mryndina.exhibitions.util.files.S3Service;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;

public class FileController {
/*    private FileService fileService;*/
    private UserService userService;
 private S3Service s3Service;

/*    @SneakyThrows
    @GetMapping("/{photoId}")

    public void sshowProductImage(Principal principal, HttpServletResponse response, @PathVariable String photoID) {

        response.setContentType("image/png");
        OutputStream outputStream = response.getOutputStream();
        String fileName = photoID;
        if(userService.findByUsername(principal.getName()).getPhotoId() != null)  {
            if (s3Service.getAmazonS3().doesObjectExist(s3Service.getBucketName(), fileName)) {
                InputStream inputStream = s3Service.getImage(fileName).getObjectContent();
                IOUtils.copy(inputStream, outputStream);
                outputStream.flush();
            }
        }
    }*/
  /*  public void showProductImage(Principal principal, @PathVariable("photoId") String imageId,
                                 HttpServletResponse response) {

        File image = s3Service.resolveFile(imageId, principal.getName() );
        response.setContentType("image/jpeg");
        IOUtils.copy(image.getContent(), response.getOutputStream());
    }*/



}
