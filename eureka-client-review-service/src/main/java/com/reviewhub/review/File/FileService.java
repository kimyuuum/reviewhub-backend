package com.reviewhub.review.File;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

    private final FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    List<File> findFiles(Long postIdx) {
        return fileRepository.findByPostIdx(postIdx);
    }

    File create(FileDto.Request dto) {
        return fileRepository.save(dto.toEntity());
    }

}
