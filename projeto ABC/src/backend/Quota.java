/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.time.LocalDate;

/**
 *
 * @author 
 */
public class Quota {
    private int id_quota;
    private String username;
    private String estado;
    private LocalDate data;

    public Quota(int id, String user, String pagou, LocalDate data){
        this.id_quota=id;
        this.username=user;
        this.estado=pagou;
        this.data= data;
    }
    
    public Quota(String user, String pagou, LocalDate data){
        ///this.id_quota=id;
        this.username=user;
        this.estado=pagou;
        this.data= data;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId_quota() {
        return id_quota;
    }

    public void setId_quota(int id_quota) {
        this.id_quota = id_quota;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Quota{" + "username=" + username + ", pagou=" + estado + ", data_pagamento=" + data + '}';
    }
    
    
    
}
