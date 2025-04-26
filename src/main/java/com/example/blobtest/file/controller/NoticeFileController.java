package com.example.blobtest.file.controller;

import com.example.blobtest.file.dto.InsertFileDto;
import com.example.blobtest.file.entity.NoticeFile;
import com.example.blobtest.file.service.NoticeFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static org.springframework.http.HttpHeaders.*;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.*;

@Controller
@RequiredArgsConstructor
public class NoticeFileController {

    private final NoticeFileService noticeFileService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/list")
    public ResponseEntity<List<NoticeFile>> findAll() {
        return ResponseEntity.ok(noticeFileService.findAll());
    }

    @PostMapping("/insert")
    public ResponseEntity<Object> insertFile(@ModelAttribute InsertFileDto fileDto) throws IOException {
        noticeFileService.insertFile(fileDto);
        return ResponseEntity.status(CREATED).body(null);
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long fileId) {
        NoticeFile file = noticeFileService.getFileById(fileId);

        return ResponseEntity.ok()
                .header(CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
                .contentType(APPLICATION_OCTET_STREAM)
                .body(file.getFileData());
    }
}
