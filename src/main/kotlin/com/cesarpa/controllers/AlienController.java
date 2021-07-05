package com.cesarpa.controllers;

import com.cesarpa.models.Alien;
import com.cesarpa.repositories.AlienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@Controller
public class AlienController {

    @Autowired
    AlienRepository alienRepository;

    @RequestMapping("/")
    public String home() {
        return "home.jsp";
    }

    @RequestMapping("/addAlien")
    public String addAlien(Alien alien) {
        alienRepository.save(alien);
        return "home.jsp";
    }

    @RequestMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam Integer id) {
        ModelAndView mv = new ModelAndView("showAlien.jsp");
        mv.addObject(alienRepository.findById(id).orElse(new Alien()));

        /*
        System.out.println(alienRepository.findByName("cesarpa"));
        System.out.println(alienRepository.findByIdGreaterThan(100));
        System.out.println(alienRepository.findByTechSorted("java"));
         */

        return mv;
    }

    @RequestMapping(path = "/aliens", produces = {"application/json", "application/xml"})
    @ResponseBody
    public List<Alien> getAliens() {
        return alienRepository.findAll();
    }

    @RequestMapping("/alien/{id}")
    @ResponseBody
    public Optional<Alien> getAlienByPath(@PathVariable("id") Integer id) {
        return alienRepository.findById(id);
    }
}
