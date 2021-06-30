package ro.iss.guruclinic.model;

import java.time.LocalDate;

public class Visit extends BaseEntity {

  private static final long serialVersionUID = 449053851601364439L;

  private LocalDate date;
  private String description;
  private Pet pet;

  /** @return the date */
  public LocalDate getDate() {
    return date;
  }
  /** @param date the date to set */
  public void setDate(LocalDate date) {
    this.date = date;
  }
  /** @return the description */
  public String getDescription() {
    return description;
  }
  /** @param description the description to set */
  public void setDescription(String description) {
    this.description = description;
  }
  /** @return the pet */
  public Pet getPet() {
    return pet;
  }
  /** @param pet the pet to set */
  public void setPet(Pet pet) {
    this.pet = pet;
  }
  /** @return the serialversionuid */
  public static long getSerialversionuid() {
    return serialVersionUID;
  }
}
