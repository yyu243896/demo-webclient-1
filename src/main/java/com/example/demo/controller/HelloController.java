package com.example.demo.controller;

import com.example.demo.service.BoardService;
import com.example.demo.service.CommentVo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5500", methods = {RequestMethod.GET, RequestMethod.POST})
public class HelloController {

    @Autowired
    private BoardService boardService;

    private String passphrase = "key...변경";

    @GetMapping("/hello")
    public ModelAndView hello(HttpServletRequest request) {

        //     String p1 = request.getParameter("p1");
        //     p1 = (p1 == null) ? "1" : p1;
        //     System.out.println("p1 = " + AesCryptUtil.decryptAES(p1, passphrase));

        ModelAndView mv = new ModelAndView();
        mv.addObject("hello", boardService.getList());
        mv.setViewName("hello");
        return mv;
    }

    @GetMapping("/hello1")
    public Object hello1(HttpServletRequest request) {
        return boardService.getList();
    }


    @GetMapping("/cmt/{brdId}")
    public List<CommentVo> cmt(@PathVariable(value = "brdId") long brdId) {
        return boardService.getComments(brdId);
    }

}
