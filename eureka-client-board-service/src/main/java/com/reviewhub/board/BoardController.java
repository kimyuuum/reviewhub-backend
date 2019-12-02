package com.reviewhub.board;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("")
    public BoardDto.Response create(@RequestBody BoardDto.Request dto){
        return new BoardDto.Response(boardService.create(dto));
    }

    @GetMapping("")
    public List<BoardDto.Response> findAllBoard(){
        return boardService.findAllBoard()
                .stream()
                .map(BoardDto.Response::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{idx}")
    public BoardDto.Response findBoard(@PathVariable Long idx){
        return new BoardDto.Response(boardService.findBoard(idx));
    }

}
