package sust.el_muro.controllers;

import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import sust.el_muro.models.MessageRepository;
import sust.el_muro.models.User;

@Controller
public class MuroController {

  @Autowired
  MessageRepository messageRepo;

  @GetMapping("/logout")
  public String logout(HttpSession session) {
    session.setAttribute("user", null);
    return "redirect:/login";
  }

  @GetMapping("/")
  public Object muroScreen(HttpSession session) {
    ModelAndView vista = new ModelAndView("muro.html");
    // 1. Nos traemos el usuario de la sesión
    User u = (User) session.getAttribute("user");
    if (u == null) {
      // si el usuario es null, significa que no está logueado
      return "redirect:/login";
    }

    return vista;
  }

}
