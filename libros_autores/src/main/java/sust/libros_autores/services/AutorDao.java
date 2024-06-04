package sust.libros_autores.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import sust.libros_autores.models.Autor;

@Component
public class AutorDao {

  @Autowired
  JdbcTemplate tpl;

  public List<Autor> getAll() {
    return tpl.query("select * from autores", new AutorMapper());
  }

}
