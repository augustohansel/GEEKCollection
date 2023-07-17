package com.pooweb.geekcollection.controllers;

import com.pooweb.geekcollection.dto.RequisicaoActionFigure;
import com.pooweb.geekcollection.dto.RequisicaoPoster;
import com.pooweb.geekcollection.models.Poster;
import com.pooweb.geekcollection.repositories.ActionFigureRepository;
import com.pooweb.geekcollection.repositories.PosterRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class PosterController {

    @Autowired
    private PosterRepository posterRepository;

    @GetMapping("/posters")
    public ModelAndView index(){
        List<Poster> posters = this.posterRepository.findAll();
        ModelAndView mv = new ModelAndView("posters/index");
        mv.addObject("posters", posters);
        return mv;
    }

    @GetMapping("/posters/new")
    public ModelAndView nnew(){
        ModelAndView mv = new ModelAndView("posters/new");
        return mv;
    }

    @PostMapping("/posters")
    public String create(@Valid RequisicaoPoster requisicao){
        Poster poster = requisicao.toPoster();
        this.posterRepository.save(poster);

        return "redirect:/posters";
    }

    @GetMapping("/posters/{id}")
    public ModelAndView show(@PathVariable Long id){
        Optional<Poster> optional = this.posterRepository.findById(id);

        if (optional.isPresent()){
            Poster poster = optional.get();

            ModelAndView mv = new ModelAndView("posters/show");
            mv.addObject("poster", poster);

            return mv;
        }
        else {
            return new ModelAndView("redirect:/posters");
        }
    }


    @GetMapping("/posters/{id}/edit")
    public ModelAndView edit(@PathVariable Long id, RequisicaoPoster requisicao){
        Optional<Poster> optional = this.posterRepository.findById(id);
        if(optional.isPresent()){
            ModelAndView mv = new ModelAndView("posters/edit");
            mv.addObject("posterId", id);
            return mv;
        }else{
            System.out.println("Noa achou o professor!!!! "+ id  + "AAAAAAA");
            return new ModelAndView("redirect:/posters");
        }
    }

    @PostMapping("/posters/{id}/update")
    public ModelAndView update(@PathVariable Long id, @Valid RequisicaoPoster requisicao) {
        Optional<Poster> optional = this.posterRepository.findById(id);
        if (optional.isPresent()) {
            Poster poster = requisicao.toPoster(optional.get());
            this.posterRepository.save(poster);

            return new ModelAndView("redirect:/posters");
        } else {
            System.out.println("Não encontrou o Action Figure com ID: " + id);
            return new ModelAndView("redirect:/posters");
        }
    }

    @GetMapping("/posters/{id}/delete")
    public String delete(@PathVariable Long id){
        this.posterRepository.deleteById(id);
        return "redirect:/posters";
    }

}
