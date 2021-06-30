package ro.iss.guruclinic.model;

public class PetType extends BaseEntity {

  private static final long serialVersionUID = -27145277850386722L;
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }
}
