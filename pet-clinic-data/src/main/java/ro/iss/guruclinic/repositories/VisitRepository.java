package ro.iss.guruclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ro.iss.guruclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {}
