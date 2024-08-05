package com.example.demo.controller;

import com.example.demo.service.BoardService;
import com.example.demo.service.CommentVo;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private BoardService boardService;


    @GetMapping("/hello")
    public ModelAndView hello(HttpServletRequest request) {
    	ModelAndView mv = new ModelAndView();
        mv.addObject("hello", boardService.getList());
        mv.setViewName("hello");
        return mv;
    }


    @GetMapping("/cmt/{brdId}")
    public List<CommentVo> cmt(@PathVariable(value = "brdId") long brdId) {
        return boardService.getComments(brdId);
    }

}
