package sust.demo.controllers;

import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sust.demo.models.Tarea;
import sust.demo.services.ITareaService;
import sust.demo.services.TareaService;

@Controller
public class TareasController {

  @Autowired
  ITareaService service;

  // @RequestMapping(value="/tareas", method=RequestMethod.GET)
  @GetMapping(value = "/tareas")
  public ModelAndView paginaTareas() {
    System.out.println(service.getAll());
    // 1. Creo un objeto del tipo ModelAndView
    ModelAndView vista = new ModelAndView("tareas");
    // 2. Le agrego contenido dinámico
    vista.addObject("titulo", "Mi lista de tareas pendientes");
    vista.addObject("tareas", service.getAll());
    // 3. Retorno el objeto creado
    return vista;
  }

  @GetMapping(value = "/tareas/check/{id}")
  public String chequearTarea(@PathVariable("id") int id) {
    service.chequear(id);

    return "redirect:/tareas";
  }

  @GetMapping(value = "/tareas/delete/{id}")
  public String borrarTarea(@PathVariable("id") int id) {
    service.eliminar(id);
    return "redirect:/tareas";
  }

  @PostMapping(value = "/tareas")
  public String agregarTarea(@RequestParam String texto) {
    // 1. Le pedimos al servicio que agregue la nueva tarea
    service.agregar(texto);
    // 2. Redirigimos a la ruta GET /tareas
    return "redirect:/tareas";
  }

  public void saludar(boolean am) {
    // String saludo;
    // if (am) {
    // saludo = "Buenos Dias";
    // } else {
    // saludo = "Buenas Tardes";
    // }
    String saludo = am ? "Buenos Dias" : "Buenas Tardes";
  }
}
