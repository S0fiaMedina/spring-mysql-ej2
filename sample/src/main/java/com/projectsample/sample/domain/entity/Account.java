package com.projectsample.sample.domain.entity;


import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

// tabla de usuarios en la base de datos

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table (name = "account")
public class Account {

    // id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "account_id")
    private Long acccountId;

    // email
    private String email;

    // contraseña
    private String password; // ESTO SE DEBE ENCRIPTAR

    // cuenta activa?
    private Boolean isActive;

    // roles de un usuario (basicamente se le dice a la base de datos que cargue de primero)
    @ManyToMany( fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "account_role",
        joinColumns = @JoinColumn ( name = "account_id" ,referencedColumnName = "account_id"),
        inverseJoinColumns = @JoinColumn ( name = "role_id", referencedColumnName = "role_id")
    )
    private Set<Role> roles;


    // Audit -> COntiene el "created_at" y el "updated_at"
    @Embedded
    private final Audit audit = new Audit();

    // llena el campo created_at cuando se crea el objeto de ACCOUNT (llama al metodo de audit)
    @PrePersist
    public void prePersist() {
        audit.prePersistAudit();
    }

    // llena el campo created_at cuando se actualiza el objeto de ACCOUNT (llama al metodo de audit)
    @PreUpdate
    public void preUpdate() {
        audit.preUpdateAudit();
    }

}
