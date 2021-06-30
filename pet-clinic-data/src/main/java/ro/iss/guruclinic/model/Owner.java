package ro.iss.guruclinic.model;

import java.util.Set;

public class Owner extends Person {

  private static final long serialVersionUID = -5516376692037035026L;

  private Set<Pet> pets;

  public Set<Pet> getPets() {
    return pets;
  }

  public void setPets(Set<Pet> pets) {
    this.pets = pets;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }
}
