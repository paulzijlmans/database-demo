package nl.paulzijlmans.database.databasedemo.springdata;

import nl.paulzijlmans.database.databasedemo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonSpringDataRepository extends JpaRepository<Person, Integer> {}
