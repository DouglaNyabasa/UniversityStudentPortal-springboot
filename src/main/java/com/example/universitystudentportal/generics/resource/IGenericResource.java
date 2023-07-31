package com.example.universitystudentportal.generics.resource;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface IGenericResource<T,ID extends Long> {

    ResponseEntity<T> create(T t);
    ResponseEntity<Page<T>> getAll(int page, int size);
    ResponseEntity<T> deleteById(ID id);
    ResponseEntity<T> update(T t,ID id);
    ResponseEntity<T> findByID(ID id);
}
