package ro.iss.guruclinic.model;

import java.util.Set;

public class Owner extends Person {

  private static final long serialVersionUID = -5516376692037035026L;

  private Set<Pet> pets;

  /** @return the pets */
  public Set<Pet> getPets() {
    return pets;
  }

  /** @param pets the pets to set */
  public void setPets(Set<Pet> pets) {
    this.pets = pets;
  }

  /** @return the serialversionuid */
  public static long getSerialversionuid() {
    return serialVersionUID;
  }
}
