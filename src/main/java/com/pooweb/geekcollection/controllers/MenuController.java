package com.pooweb.geekcollection.controllers;

import com.pooweb.geekcollection.models.ActionFigure;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class MenuController {
    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
}
