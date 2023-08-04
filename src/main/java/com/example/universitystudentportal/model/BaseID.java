package com.example.universitystudentportal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;


/**
 *
 * @author Douglas Nybasa
 * created on 7/20/2023
 */
@Data
@MappedSuperclass
@EqualsAndHashCode
public abstract class  BaseID {



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    @JsonIgnore
    private Instant createdDate = Instant.now();

    @LastModifiedDate
    @JsonIgnore
    @Column(name = "last_modified_date")
    private Instant updatedDate = Instant.now();


}
