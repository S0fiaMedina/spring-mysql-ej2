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

// tabla de usuarios en la base de datos

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
    @ManyToMany( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "account_role",
        joinColumns = @JoinColumn ( name = "account_id" ,referencedColumnName = "account_id"),
        inverseJoinColumns = @JoinColumn ( name = "role_id", referencedColumnName = "role_id")
    )
    private Set<Role> roles;

    


    public Account() {
    }

    // Audit -> COntiene el "created_at" y el "updated_at"
    @Embedded
    Audit audit = new Audit();

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

    public Long getAcccountId() {
        return acccountId;
    }

    public void setAcccountId(Long acccountId) {
        this.acccountId = acccountId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    


}
