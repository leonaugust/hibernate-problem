package com.example.hibernateproblem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.content.commons.annotations.ContentId;
import org.springframework.content.commons.annotations.ContentLength;
import org.springframework.content.commons.annotations.MimeType;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  @ContentId
  private String contentId;

  @ContentLength
  private Long contentLength = 0L;

  @MimeType
  private String mimeType = "text/plain";

  public Product(String name) {
    this.name = name;
  }

}
