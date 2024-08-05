package com.projectsample.sample.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name =  "permission")
public class Permission {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  permissionId;

    private String name;


    
    
}
