package com.reviewhub.review.File;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = {"http://localhost:8080"})
@RequestMapping("/file")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/{postIdx}")
    public List<FileDto.Response> findAllFiles(@PathVariable Long postIdx) {
        return fileService.findFiles(postIdx)
                .stream()
                .map(FileDto.Response::new)
                .collect(Collectors.toList());
    }

    @PostMapping("")
    public FileDto.Response createFile(@RequestBody FileDto.Request request){
        return new FileDto.Response(fileService.create(request));
    }


}
