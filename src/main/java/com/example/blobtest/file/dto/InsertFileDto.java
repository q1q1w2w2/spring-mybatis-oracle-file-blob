package com.example.blobtest.file.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
public class InsertFileDto {

    private String fileName;

    private List<MultipartFile> files;

//    private byte[] fileData;

}
