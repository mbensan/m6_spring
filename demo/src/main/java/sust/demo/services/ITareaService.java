package sust.demo.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import sust.demo.models.Tarea;

@Service
public interface ITareaService {
  public ArrayList<Tarea> getAll();

  public void chequear(int id);

  public void agregar(String texto);

  public void eliminar(int id);
}
