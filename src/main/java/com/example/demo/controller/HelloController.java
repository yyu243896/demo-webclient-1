package com.example.demo.controller;

import com.example.demo.service.BoardService;
import com.example.demo.service.BoardVo;
import com.example.demo.service.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private BoardService boardService;


    @GetMapping("/hello")
    public List<BoardVo> hello() {
        return boardService.getList();
    }


    @GetMapping("/cmt/{brdId}")
    public List<CommentVo> cmt(@PathVariable(value = "brdId") long brdId) {
        return boardService.getComments(brdId);
    }

}
