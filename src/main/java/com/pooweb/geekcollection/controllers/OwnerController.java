package com.pooweb.geekcollection.controllers;
import com.pooweb.geekcollection.dto.RequisicaoOwner;
import com.pooweb.geekcollection.models.Owner;
import com.pooweb.geekcollection.repositories.OwnerRepository;
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
public class OwnerController {

    @Autowired
    private OwnerRepository ownerRepository;

    @GetMapping("/owners")
    public ModelAndView index(){
        List<Owner> owners = this.ownerRepository.findAll();
        ModelAndView mv = new ModelAndView("owners/index");
        mv.addObject("owners", owners);
        return mv;
    }

    @GetMapping("/owners/new")
    public ModelAndView nnew(){
        ModelAndView mv = new ModelAndView("owners/new");
        return mv;
    }

    @PostMapping("/owners")
    public String create(@Valid RequisicaoOwner requisicao){
        Owner owner = requisicao.toOwner();
        this.ownerRepository.save(owner);

        return "redirect:/owners";
    }

    @GetMapping("/owners/{id}")
    public ModelAndView show(@PathVariable Long id){
        Optional<Owner> optional = this.ownerRepository.findById(id);

        if (optional.isPresent()){
            Owner owner = optional.get();

            ModelAndView mv = new ModelAndView("owners/show");
            mv.addObject("owner", owner);

            return mv;
        }
        else {
            return new ModelAndView("redirect:/owners");
        }
    }


    @GetMapping("/owners/{id}/edit")
    public ModelAndView edit(@PathVariable Long id, RequisicaoOwner requisicao){
        Optional<Owner> optional = this.ownerRepository.findById(id);
        if(optional.isPresent()){
            ModelAndView mv = new ModelAndView("owners/edit");
            mv.addObject("ownerId", id);
            return mv;
        }else{
            System.out.println("Noa achou o professor!!!! "+ id  + "AAAAAAA");
            return new ModelAndView("redirect:/owners");
        }
    }

    @PostMapping("/owners/{id}/update")
    public ModelAndView update(@PathVariable Long id, @Valid RequisicaoOwner requisicao) {
        Optional<Owner> optional = this.ownerRepository.findById(id);
        if (optional.isPresent()) {
            Owner owner = requisicao.toOwner(optional.get());
            this.ownerRepository.save(owner);

            return new ModelAndView("redirect:/owners");
        } else {
            System.out.println("Não encontrou o Action Figure com ID: " + id);
            return new ModelAndView("redirect:/owners");
        }
    }

    @GetMapping("/owners/{id}/delete")
    public String delete(@PathVariable Long id){
        this.ownerRepository.deleteById(id);
        return "redirect:/owners";
    }

}
