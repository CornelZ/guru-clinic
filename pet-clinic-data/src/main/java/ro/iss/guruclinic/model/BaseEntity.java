package ro.iss.guruclinic.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {

  private static final long serialVersionUID = -5218545430175236021L;
  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
