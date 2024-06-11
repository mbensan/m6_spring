package sust.el_muro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MuroController {

  @GetMapping("/")
  public ModelAndView muroScreen() {
    ModelAndView vista = new ModelAndView("muro.html");

    return vista;
  }

}
