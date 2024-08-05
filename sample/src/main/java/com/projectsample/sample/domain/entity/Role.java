package com.projectsample.sample.domain.entity;


import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table( name = "role")
public class Role {
    
    // el id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "role_id")
    private Long roleId;

    // basicamente el rol va a ser un enum tipo string 
    
    @Column(name = "name", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private RoleEnum name;

    // tabla intermedia de roles y permisos
    @ManyToMany
    @JoinTable(
        name = "role_permission",
        joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"),
        inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "permissionId")
    )
    private Set<Permission> permissions;



   private final Audit audit = new Audit();


    @PrePersist
    public  void prePersist(){
        this.audit.prePersistAudit();
    }


    @PreUpdate void preUpdate(){
        this.audit.preUpdateAudit();
    }


   
}
