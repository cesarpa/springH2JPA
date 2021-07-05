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

    @RequestMapping("/aliens")
    @ResponseBody
    public String getAliens() {
        return alienRepository.findAll().toString();
    }

    @RequestMapping("/alien/{id}")
    @ResponseBody
    public String getAlienByPath(@PathVariable("id") Integer id ) {
        return alienRepository.findById(id).orElse(new Alien()).toString();
    }
}
