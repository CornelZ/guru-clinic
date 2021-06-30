package ro.iss.guruclinic.model;

public class Specialty extends BaseEntity {

  private static final long serialVersionUID = 5761201713153095445L;

  private String description;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }
}
