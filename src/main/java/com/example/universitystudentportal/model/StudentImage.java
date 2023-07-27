package com.example.universitystudentportal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "image_Data")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentImage extends BaseID implements Serializable {

    private String name;
    private String type;
    @Lob
    @Column(name = "imagedata",length = 1000)
    private byte[] imageData;
}
