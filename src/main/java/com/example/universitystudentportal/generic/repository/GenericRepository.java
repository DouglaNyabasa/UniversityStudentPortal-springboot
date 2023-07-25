package com.example.universitystudentportal.generic.repository;

import com.example.universitystudentportal.model.BaseID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 *
 * @author Douglas Nybasa
 * created on 7/20/2023
 */
public interface GenericRepository <T extends BaseID> extends JpaRepository<T,Long> {



}
