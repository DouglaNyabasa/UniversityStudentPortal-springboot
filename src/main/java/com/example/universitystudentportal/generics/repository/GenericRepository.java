package com.example.universitystudentportal.generics.repository;

import com.example.universitystudentportal.model.BaseID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Douglas Nybasa
 * created on 7/20/2023
 */
public interface GenericRepository <T extends BaseID> extends JpaRepository<T,Long> {



//T findByUsername(String firstName);


}
