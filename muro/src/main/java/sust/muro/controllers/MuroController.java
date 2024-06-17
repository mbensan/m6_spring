package sust.muro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import sust.muro.models.MessageRepository;
import sust.muro.models.Message;
import sust.muro.models.User;

@Controller
public class MuroController {

  @Autowired
  MessageRepository messageRepo;

  @GetMapping("/")
  public Object home(HttpSession session) {
    if (session.getAttribute("user") == null) {
      return "redirect:/login";
    }

    ModelAndView vista = new ModelAndView("muro.html");
    return vista;
  }

  @PostMapping("/messages")
  public String addMessage(@RequestParam String message, RedirectAttributes redAt, HttpSession session) {
    User yo = (User) session.getAttribute("user");

    Message m = new Message();
    m.setMessage(message);
    m.setUser(yo);

    messageRepo.save(m);

    redAt.addFlashAttribute("bien", "Mensaje Agregado con éxito");

    return "redirect:/";
  }

}
