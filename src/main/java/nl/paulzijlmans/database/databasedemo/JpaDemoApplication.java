package nl.paulzijlmans.database.databasedemo;

import nl.paulzijlmans.database.databasedemo.entity.Person;
import nl.paulzijlmans.database.databasedemo.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired PersonJpaRepository repository;

  public static void main(String[] args) {
    SpringApplication.run(JpaDemoApplication.class, args);
  }

  @Override
  public void run(String... args) {
    logger.info("All users -> {}", repository.findAll());
    logger.info("User id 10001 -> {}", repository.findById(10001));
    logger.info("Inserting -> {}", repository.insert(new Person("Tara", "Berlin", new Date())));
    logger.info(
        "Updating 10003 -> {}",
        repository.update(new Person(10003, "Pieter", "Utrecht", new Date())));

    logger.info("Deleting 10002");
    repository.deleteById(10002);
    logger.info("All users -> {}", repository.findAll());
  }
}
