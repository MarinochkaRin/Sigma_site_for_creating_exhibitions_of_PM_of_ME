package com.mryndina.exhibitions.service.utility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileWrapper {
    private List<MultipartFile> filename = new ArrayList<>();
    public void addFile (MultipartFile file){filename.add(file);};

}
