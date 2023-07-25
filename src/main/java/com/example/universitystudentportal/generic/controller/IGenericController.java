package com.example.universitystudentportal.generic.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface IGenericController<T,ID extends String> {

    ResponseEntity<T> create(T t);
    ResponseEntity<Page<T>> getAll(int page, int size);
    ResponseEntity<T> deleteById(ID id);
    ResponseEntity<T> update(T t,ID id);
    ResponseEntity<T> find(ID id);
}
