package com.reviewhub.board;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {

    Board findByIdx(Long idx);

}
