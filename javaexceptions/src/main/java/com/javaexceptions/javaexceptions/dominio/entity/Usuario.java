package com.javaexceptions.javaexceptions.dominio.entity;

public class Usuario {
    private Long id;
    private String name;
    private String lastName;

    private Rol rol;

    public Usuario() {
    }

    public Usuario(Long id, String name, String lastName, Rol rol) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    

}
