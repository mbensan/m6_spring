package sust.demo.controllers;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RuteoController {
  // Acá comenzamos a trabaja
  @RequestMapping(value = "/blogs", method = RequestMethod.GET)
  @ResponseBody
  public String index() {
    return "<h2>placeholder para luego mostrar una lista de todos los blogs</h2>";
  }

  @RequestMapping(value = "/blogs/new", method = RequestMethod.GET)
  @ResponseBody
  public String New() {
    return "<h2>placeholder para mostrar un nuevo formulario para crear un nuevo blog</h2>";
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String root() {
    return "redirect:/blogs";
  }

  @RequestMapping(value = "/blogs/create", method = RequestMethod.GET)
  public String create() {
    return "redirect:/";
  }

  @RequestMapping(value = "/blogs/{number}", method = RequestMethod.GET)
  @ResponseBody
  public String show(@PathVariable int number) {
    return "<h2>Mostrando el blog número %s</h2>".formatted(number);
  }

  @RequestMapping(value = "/blogs/{number}/edit", method = RequestMethod.GET)
  @ResponseBody
  public String edit(@PathVariable int number) {
    return "<h2>Editando el blog número %s</h2>".formatted(number);
  }

  @RequestMapping(value = "/blogs/json", method = RequestMethod.GET)
  @ResponseBody
  public Object jsonResponse() {
    HashMap<String, String> respuesta = new HashMap<String, String>();
    respuesta.put("blog 1", "Zapallos del Mundo");
    respuesta.put("blog 2", "Tipos de Pokemon");
    respuesta.put("blog 3", "Fizzbuzz");
    return respuesta;
  }
}
