package com.example.universitystudentportal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Douglas Nybasa
 * created on 7/20/2023
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "module_table")
public class Module extends BaseID{

    private String moduleName;

    private Integer moduleMark;
}
