package sust.el_muro.controllers;

import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sust.el_muro.models.MessageRepository;

@Controller
public class MuroController {

  @Autowired
  MessageRepository messageRepo;

  @GetMapping("/")
  public ModelAndView muroScreen() {
    ModelAndView vista = new ModelAndView("muro.html");

    return vista;
  }

}
