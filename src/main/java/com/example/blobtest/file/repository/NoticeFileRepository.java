package com.example.blobtest.file.repository;

import com.example.blobtest.file.entity.NoticeFile;

import java.util.List;

public interface NoticeFileRepository {

    int insertNoticeFile(NoticeFile noticeFile);

    List<NoticeFile> findAllNoticeFile();

    NoticeFile findNoticeFileById(Long fileId);
}
