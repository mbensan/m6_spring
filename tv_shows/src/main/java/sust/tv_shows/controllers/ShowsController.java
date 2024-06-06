package sust.tv_shows.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sust.tv_shows.models.Show;
import sust.tv_shows.models.ShowRepository;

@Controller
public class ShowsController {

  @Autowired
  ShowRepository repo;

  @GetMapping("/shows")
  public ModelAndView showsScreen() {
    ModelAndView vista = new ModelAndView("shows.html");
    List<Show> shows = repo.findAll();
    vista.addObject("shows", shows);
    return vista;
  }

  @GetMapping("/shows/new")
  public ModelAndView createShowsScreen() {
    ModelAndView vista = new ModelAndView("new_show.html");
    return vista;
  }

  @PostMapping(value = "/shows/create")
  public String createShow(@RequestParam String title, @RequestParam String release_date,
      @RequestParam String network, @RequestParam String description) {
    Show s = new Show();
    s.setTitle(title);
    s.setRelease_date(release_date);
    s.setNetwork(network);
    s.setDescription(description);
    repo.save(s);
    return "redirect:/shows";
  }
}
