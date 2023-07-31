package com.example.universitystudentportal.generics.service;

import com.example.universitystudentportal.generics.dto.GenericDTO;
import com.example.universitystudentportal.generics.mapper.EntityMapper;
import com.example.universitystudentportal.model.BaseID;
import com.example.universitystudentportal.generics.repository.GenericRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;




/**
 *
 * @author Douglas Nybasa
 * created on 7/20/2023
 */

public abstract class GenericService <T extends BaseID, ID extends Long, DTO extends GenericDTO> implements IGenericService<T, ID>{

    private final GenericRepository<T> repository;
    private final Logger logger = LoggerFactory.getLogger(GenericService.class);

    protected GenericService(GenericRepository<T> repository) {
        this.repository = repository;
    }

       @Override
    public ResponseEntity<Object> save(T entity) {
        T savedEntity = repository.save(entity);
           logger.info("Saving entity {}", entity);
           return   ResponseEntity.status(HttpStatus.CREATED).body("Entity successfully created" + savedEntity);

    }
    @Override
    public ResponseEntity<Page<T>> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<T> result = repository.findAll(pageable);
        if (result.isEmpty()) {
            logger.info("No entities found");
            return ResponseEntity.noContent().build();
        } else {
            logger.info("Retrieved {} entities", result.getTotalElements());
            return ResponseEntity.ok(result);
        }
    }
        @Override
    public ResponseEntity<Void> deleteById(ID id) {
            logger.info("Deleting entity by id {}", id);
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }

//    @Override
//    public ResponseEntity<Object> update(T entityToUpdate) {
//        // TODO Auto-generated method stub
//        System.out.println("entityToUpdate = " + entityToUpdate);
//        boolean found = repository.findById(entityToUpdate.getId()).isPresent();
//        if (!found)
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("FAILED TO UPDATE");
//        DTO dto = mapper.toDto(entityToUpdate);
//        T update = mapper.partialUpdate(entityToUpdate, dto);
//        System.out.println("update = " + update);
//        repository.save(update);
//        return  ResponseEntity.status(HttpStatus.OK).body("entity successfully updated");
//
//    }
    @Override
    public ResponseEntity<T> update(T t, ID id) {
            return repository.findById(id).map(existingT -> {
                BeanUtils.copyProperties(t, existingT);
                T updatedT = repository.save(existingT);
                logger.info("Entity with ID {} was updated.", id);
                return ResponseEntity.ok(updatedT);
            }).orElseGet(() -> {
                logger.warn("Entity with ID {} was not found.", id);
                return ResponseEntity.notFound().build();
            });
    }


    @Override
    public ResponseEntity<T> findById(Long id) {
        logger.info("Finding entity by id {}", id);
        Optional<T> optionalEntity = repository.findById(id);
        return optionalEntity.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //    @Override
    //    public ResponseEntity<Object> update(T entityToUpdate) {
    //        // TODO Auto-generated method stub
    //        System.out.println("entityToUpdate = " + entityToUpdate);
    //        boolean found = repository.findById(entityToUpdate.getId()).isPresent();
    //        if (!found)
    //            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("FAILED TO UPDATE");
    //        DTO dto = mapper.toDto(entityToUpdate);
    //        T update = mapper.partialUpdate(entityToUpdate, dto);
    //        System.out.println("update = " + update);
    //        repository.save(update);
    //        return  ResponseEntity.status(HttpStatus.OK).body("entity successfully updated");
    //
    //    }

//    @Override
//    public ResponseEntity<Object> findByName(String name) {
//        T data = repository.findByName(name);
//        if (data == null)
//            return  ResponseEntity.ok().body("Entity was not found." );
//        logger.warn("Entity with name {} was found.", name);
//        return ResponseEntity.ok().body(name);
//
//    }
}
