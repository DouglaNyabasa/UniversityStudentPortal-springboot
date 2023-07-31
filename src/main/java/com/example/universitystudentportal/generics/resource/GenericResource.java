package com.example.universitystudentportal.generics.resource;

import com.example.universitystudentportal.generics.dto.GenericDTO;
import com.example.universitystudentportal.generics.repository.GenericRepository;
import com.example.universitystudentportal.generics.service.GenericService;
import com.example.universitystudentportal.model.BaseID;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
public abstract class GenericResource<T extends BaseID, ID extends Long, DTO extends GenericDTO, R extends GenericRepository<T>, S extends GenericService<T,ID,DTO>> implements IGenericResource<T,ID> {

    protected S service;
    @PostMapping("/")
    @Operation(
            tags = {"ALL ENDPOINTS"},
            summary = "create Entity",
            description = "This end point create and persist the Entity to its respective Database",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "ENTER THE REQUIRED DETAILS TO CREATE AND SAVE THE ENTITY"),
            parameters = {@Parameter(name = "")}
    )
    public ResponseEntity<T> create(@RequestBody T t) {
        ResponseEntity response = new ResponseEntity<>(HttpStatus.CREATED);
        try {
            response = service.save(t);
        } catch (Exception e) {
            log.error("Error creating data  {}", e.getMessage());
            e.printStackTrace();
        }
        return response;
    }



    @Override
    @GetMapping("/")
    @Operation(
            tags = {"ALL ENDPOINTS"}
    )
    public ResponseEntity<Page<T>> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return service.findAll(page, size);
    }


    @Override
    @DeleteMapping("/{id}")
    @Operation(
            tags = {"ALL ENDPOINTS"}
    )
    public ResponseEntity<T> deleteById(@PathVariable("id") ID id) {
       service.deleteById(id);
        return null;

    }

//    @PutMapping("/")
//    @Operation(
//            tags = {"ALL ENDPOINTS"}
//    )
//    public ResponseEntity<T> update(@RequestBody T t, ID id) {
//        return service.update();
//    }

    @Override
    @Operation(
            tags = {"ALL ENDPOINTS"}
    )
    public ResponseEntity<T> findByID(@PathVariable("id") ID id) {
        return  service.findById(id);
    }


}
