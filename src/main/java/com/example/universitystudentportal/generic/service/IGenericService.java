package com.example.universitystudentportal.generic.service;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 *
 * @author Douglas Nybasa
 * created on 7/20/2023
 */
public interface IGenericService<T, K>  {

    ResponseEntity<Page<T>>findAll(int page, int size);

    ResponseEntity<T> findById(Long id);

    ResponseEntity<Object> save(T entity);

    ResponseEntity<Void> deleteById(K k);

    ResponseEntity<T> update(T entity,K k);

}
