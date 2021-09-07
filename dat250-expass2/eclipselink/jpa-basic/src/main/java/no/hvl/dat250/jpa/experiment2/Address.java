package no.hvl.dat250.jpa.experiment2;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
public class Address {  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String street;
  private int number;

  @ManyToMany
  private List<Person> inhabitants;
}
