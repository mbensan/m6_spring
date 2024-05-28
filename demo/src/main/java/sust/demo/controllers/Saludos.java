package sust.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Saludos {

  @RequestMapping(value = "/hola", method = RequestMethod.GET)
  @ResponseBody
  public String hola() {
    return "<h2>hola a todos y todas</h2>";
  }

  // contenido dinámico en el PATH
  @RequestMapping(value = "/hola2/{nombre}", method = RequestMethod.GET)
  @ResponseBody
  public String hola2(@PathVariable String nombre) {
    return "<h2>Hola %s</h2>".formatted(nombre);
  }

  // contenido dinámico en los parámetro de la URI
  @RequestMapping(value = "/tablero", method = RequestMethod.GET)
  @ResponseBody
  public String tablero(@RequestParam int alto, @RequestParam int ancho) {
    String celdas = "";
    for (int i = 1; i <= alto; i++) {
      celdas += "<div class=\"row\">";
      for (int j = 1; j <= ancho; j++) {
        celdas += "<div>Fila %s, Columna %s</div>".formatted(i, j);
      }
      celdas += "</div>";
    }
    // <div>Fila 2, Columna 5</div>
    return celdas;
  }

}
