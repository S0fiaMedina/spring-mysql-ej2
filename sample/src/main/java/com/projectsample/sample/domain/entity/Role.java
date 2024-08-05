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

@Entity
@Table( name = "role")
public class Role {
    
    // el id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "role_id")
    private Long roleId;

    // basicamente el rol va a ser un enum tipo string 
    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false, unique = true)
    private RoleEnum roleEnum;

    // tabla intermedia de roles y permisos
    @ManyToMany
    @JoinTable(
        name = "role_permission",
        joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"),
        inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "permissionId")
    )
    private Set<Permission> permissions;



   Audit audit = new Audit();


    @PrePersist
    public  void prePersist(){
        this.audit.prePersistAudit();
    }


    @PreUpdate void preUpdate(){
        this.audit.preUpdateAudit();
    }


    public Long getRoleId() {
        return roleId;
    }


    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }


    public RoleEnum getName() {
        return roleEnum;
    }


    public void setName(RoleEnum roleEnum) {
        this.roleEnum = roleEnum;
    }


    public Set<Permission> getPermissions() {
        return permissions;
    }


    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }


    public Audit getAudit() {
        return audit;
    }


    public void setAudit(Audit audit) {
        this.audit = audit;
    }


    public RoleEnum getRoleEnum() {
        return roleEnum;
    }


    public void setRoleEnum(RoleEnum roleEnum) {
        this.roleEnum = roleEnum;
    }

}
