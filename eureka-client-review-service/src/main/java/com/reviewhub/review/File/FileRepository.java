package com.reviewhub.review.File;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<File,Long> {

    List<File> findByPostIdx(Long postIdx);

}
