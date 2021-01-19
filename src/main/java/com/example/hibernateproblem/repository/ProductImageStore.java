package com.example.hibernateproblem.repository;

import com.example.hibernateproblem.model.Product;
import org.springframework.content.commons.repository.ContentStore;
import org.springframework.content.rest.StoreRestResource;
import org.springframework.stereotype.Repository;

@StoreRestResource(path = "data")
@Repository
public interface ProductImageStore extends ContentStore<Product, String> {
}