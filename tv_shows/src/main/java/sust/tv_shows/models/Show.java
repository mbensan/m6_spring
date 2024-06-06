package sust.tv_shows.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "shows")
public class Show {
  @Id
  @GeneratedValue
  long id;

  @Column(nullable = false)
  String title;

  @Column(nullable = false)
  String release_date;

  @Column(nullable = false)
  String network;

  @Column
  String description;
}
