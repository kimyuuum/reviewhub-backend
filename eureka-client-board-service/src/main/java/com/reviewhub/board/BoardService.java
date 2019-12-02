package com.reviewhub.board;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<Board> findAllBoard(){
        return boardRepository.findAll();
    }

    public Board findBoard(Long idx){
        return boardRepository.findByIdx(idx);
    }

    public Board create(BoardDto.Request dto){
        return boardRepository.save(dto.toEntity());
    }

}
