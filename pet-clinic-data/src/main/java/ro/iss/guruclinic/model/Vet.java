package ro.iss.guruclinic.model;

import java.util.Set;

public class Vet extends Person {

  private static final long serialVersionUID = 7580676660170918647L;

  private Set<Specialty> specialties;

  public Set<Specialty> getSpecialties() {
    return specialties;
  }

  public void setSpecialties(Set<Specialty> specialties) {
    this.specialties = specialties;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }
}
