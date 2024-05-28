package sust.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TareasController {

  // @RequestMapping(value="/tareas", method=RequestMethod.GET)
  @GetMapping(value = "/tareas")
  public ModelAndView paginaTareas() {
    // 1. Creo un objeto del tipo ModelAndView
    ModelAndView vista = new ModelAndView("tareas");
    // 2. Le agrego contenido dinámico
    vista.addObject("titulo", "Mi lista de tareas pendientes");
    // 3. Retorno el objeto creado
    return vista;
  }
}
