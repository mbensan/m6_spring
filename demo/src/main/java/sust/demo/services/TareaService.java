package sust.demo.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.springframework.stereotype.Service;

import sust.demo.models.Tarea;

@Service
public class TareaService implements ITareaService {
  ArrayList<Tarea> tareas;

  public TareaService() {
    this.tareas = new ArrayList<Tarea>(Arrays.asList(
        new Tarea(1, "Hacer la cama", false, new Date()),
        new Tarea(2, "Pasear al perro", true, new Date())));
  }

  public void chequear(int id) {
    for (Tarea t : tareas) {
      if (t.getId() == id) {
        t.setCompletada(true);
        break;
      }
    }
  }

  public void eliminar(int id) {
    for (Tarea t : tareas) {
      if (t.getId() == id) {
        tareas.remove(t);
        break;
      }
    }
  }

  public void agregar(String texto) {
    // 1. Calculamos el ID del último elemento de la lista
    Tarea ultima = tareas.get(tareas.size() - 1);
    int nuevo_id = ultima.getId() + 1;
    // 2. Agregamos la nueva tarea
    tareas.add(
        new Tarea(nuevo_id, texto, false, new Date()));
  }

  public ArrayList<Tarea> getAll() {
    return this.tareas;
  }

}
