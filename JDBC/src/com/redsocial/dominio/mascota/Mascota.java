package com.redsocial.dominio.mascota;

public class Mascota {

    private int id;
    private String apodo;
    private String raza;
    private int idUsuario;

    public Mascota(int id, String apodo, String raza, int idUsuario) {
        this.id = id;
        this.apodo = apodo;
        this.raza = raza;
        this.idUsuario = idUsuario;
    }

    public Mascota() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Mascota{" + "id=" + id + ", apodo=" + apodo + ", raza=" + raza + ", idUsuario=" + idUsuario + '}';
    }

}
