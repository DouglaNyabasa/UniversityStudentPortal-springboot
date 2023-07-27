//package com.example.universitystudentportal.generic.controller;
//
//import com.example.universitystudentportal.generic.service.GenericService;
//import com.example.universitystudentportal.model.BaseID;
//import org.springframework.data.domain.Page;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.RequestBody;
//
//
//public class GenericController <T extends BaseID,ID extends Long> implements IGenericController<T, ID> {
//
//
//
//    GenericService<T,ID> service;
//    public GenericController(GenericService<T,ID> service) {
//        this.service = service;
//    }
//
//
//    @Override
//    public ResponseEntity<T> create(@RequestBody @Validated T t) {
//        return service.save(t);
//    }
//
//    @Override
//    public ResponseEntity<Page<T>> getAll(int page, int size) {
//        return null;
//    }
//
//    @Override
//    public ResponseEntity<T> deleteById(ID id) {
//        return null;
//    }
//
//    @Override
//    public ResponseEntity<T> update(T t, ID id) {
//        return null;
//    }
//
//    @Override
//    public ResponseEntity<T> find(ID id) {
//        return null;
//    }
//}
