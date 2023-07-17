package com.pooweb.geekcollection.controllers;

import com.pooweb.geekcollection.dto.RequisicaoActionFigure;
import com.pooweb.geekcollection.models.ActionFigure;
import com.pooweb.geekcollection.repositories.ActionFigureRepository;
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
public class ActionFigureController {

    @Autowired
    private ActionFigureRepository actionFigureRepository;

    @GetMapping("/actionfigures")
    public ModelAndView index(){
        List<ActionFigure> actionfigures = this.actionFigureRepository.findAll();
        ModelAndView mv = new ModelAndView("actionfigures/index");
        mv.addObject("actionfigures", actionfigures);
        return mv;
    }

    @GetMapping("/actionfigures/new")
    public ModelAndView nnew(){
        ModelAndView mv = new ModelAndView("actionfigures/new");
        return mv;
    }

    @PostMapping("/actionfigures")
    public String create(@Valid RequisicaoActionFigure requisicao){
            ActionFigure actionfigure = requisicao.toActionFigure();
            this.actionFigureRepository.save(actionfigure);

            return "redirect:/actionfigures";
    }

    @GetMapping("/actionfigures/{id}")
    public ModelAndView show(@PathVariable Long id){
        Optional<ActionFigure> optional = this.actionFigureRepository.findById(id);

        if (optional.isPresent()){
            ActionFigure actionfigure = optional.get();

            ModelAndView mv = new ModelAndView("actionfigures/show");
            mv.addObject("actionfigure", actionfigure);

            return mv;
        }
        else {
            return new ModelAndView("redirect:/actionfigures");
        }
    }


    @GetMapping("/actionfigures/{id}/edit")
    public ModelAndView edit(@PathVariable Long id, RequisicaoActionFigure requisicao){
        Optional<ActionFigure> optional = this.actionFigureRepository.findById(id);
        if(optional.isPresent()){
           ModelAndView mv = new ModelAndView("actionfigures/edit");
            mv.addObject("actionfigureId", id);
           return mv;
        }else{
            System.out.println("Noa achou o professor!!!! "+ id  + "AAAAAAA");
            return new ModelAndView("redirect:/actionfigures");
        }
    }

    @PostMapping("/actionfigures/{id}/update")
    public ModelAndView update(@PathVariable Long id, @Valid RequisicaoActionFigure requisicao) {
        Optional<ActionFigure> optional = this.actionFigureRepository.findById(id);
        if (optional.isPresent()) {
            ActionFigure actionFigure = requisicao.toActionFigure(optional.get());
            this.actionFigureRepository.save(actionFigure);

            return new ModelAndView("redirect:/actionfigures");
        } else {
            System.out.println("Não encontrou o Action Figure com ID: " + id);
            return new ModelAndView("redirect:/actionfigures");
        }
    }

    @GetMapping("/actionfigures/{id}/delete")
    public String delete(@PathVariable Long id){
        this.actionFigureRepository.deleteById(id);
        return "redirect:/actionfigures";
    }

}
