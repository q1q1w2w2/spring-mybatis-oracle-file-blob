package com.example.blobtest.file.service;

import com.example.blobtest.file.dto.InsertFileDto;
import com.example.blobtest.file.entity.NoticeFile;
import com.example.blobtest.file.repository.NoticeFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeFileService {

    private final NoticeFileRepository noticeFileRepository;

    public void insertFile(InsertFileDto fileDto) throws IOException {
        List<MultipartFile> files = fileDto.getFiles();

        for (MultipartFile file : files) {
            NoticeFile noticeFile = NoticeFile.builder()
                    .fileName(file.getOriginalFilename())
                    .fileData(file.getBytes())
                    .regDt(LocalDateTime.now())
                    .build();

            noticeFileRepository.insertNoticeFile(noticeFile);
        }
    }

    public List<NoticeFile> findAll() {
        return noticeFileRepository.findAllNoticeFile();
    }

    public NoticeFile getFileById(Long fileId) {
        return noticeFileRepository.findNoticeFileById(fileId);
    }
}
