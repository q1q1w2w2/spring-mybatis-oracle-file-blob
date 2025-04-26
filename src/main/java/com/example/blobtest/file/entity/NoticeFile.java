package com.example.blobtest.file.entity;

import com.example.blobtest.file.dto.InsertFileDto;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class NoticeFile {

    private Long fileId;

    private String fileName;

    private byte[] fileData;

    private LocalDateTime regDt;

//    public static NoticeFile from(InsertFileDto dto) {
//        return NoticeFile.builder()
//                .fileName(dto.getFileName())
//                .fileData(dto.getFileData())
//                .regDt(LocalDateTime.now())
//                .build();
//    }

}
