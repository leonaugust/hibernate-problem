package com.example.hibernateproblem;

import com.example.hibernateproblem.model.Product;
import com.example.hibernateproblem.repository.ProductImageStore;
import com.example.hibernateproblem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
@EnableJpaRepositories
public class HibernateProblemApplication {

  @Autowired
  private ProductRepository repository;

  public static void main(String[] args) {
    SpringApplication.run(HibernateProblemApplication.class, args);
  }

  @GetMapping("/")
  public String getAll(Model model) {
    model.addAttribute("products", repository.findAll());
    return "products";
  }

  @Bean
  public CommandLineRunner uploadImages(ProductRepository repository,
      ProductImageStore store) {
    return (args) -> {
      Product chicken = new Product("Chicken");
      store.setContent(chicken, this.getClass().getResourceAsStream("/img/chicken.jpg"));
      repository.save(chicken);

      Product goose = new Product("Goose");
      store.setContent(goose, this.getClass().getResourceAsStream("/img/goose.jpg"));
      repository.save(goose);
    };
  }

}
