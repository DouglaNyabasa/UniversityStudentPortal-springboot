package com.example.universitystudentportal.generics.service;
import com.example.universitystudentportal.model.BaseID;
import com.sun.mail.imap.protocol.ID;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Douglas Nybasa
 * created on 7/20/2023
 */
public interface IGenericService<T, K> {

    ResponseEntity<Page<T>>findAll(int page, int size);


    ResponseEntity<T> update(T t, K id);

    ResponseEntity<T> findById(Long id);

    ResponseEntity<Object> save(T entity);

    ResponseEntity<Void> deleteById(K k);

}
