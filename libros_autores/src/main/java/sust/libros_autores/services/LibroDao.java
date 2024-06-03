package sust.libros_autores.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sust.libros_autores.models.Libro;

@Component
public class LibroDao {

  @Autowired
  JdbcTemplate tpl;

  public ArrayList<Libro> getAll() throws SQLException {
    // 1. Pedimos una conexión al objeto JdbcTemplate
    Connection conn = tpl.getDataSource().getConnection();
    // 2. Creamos una consulta y la ejecutamos
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("select * from libros");
    // 3. Creamos una lista de libros vacía
    ArrayList<Libro> libros = new ArrayList<Libro>();
    // 4. Vamos llenando la lista con los registros de la respuesta SQL
    while (rs.next()) {
      libros.add(new Libro(
          rs.getInt("id"),
          rs.getString("titulo"),
          rs.getString("descripcion")));
    }
    return libros;
  }

  public void create(String titulo, String descripcion) {
    String consulta = "insert into libros (titulo, descripcion) values (?, ?)";
    tpl.update(consulta, titulo, descripcion);
  }
}
