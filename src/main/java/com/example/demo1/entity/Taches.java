package com.example.demo1.entity;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.Objects;

public class Taches {
    private String id;
    private  String libelle;
    private String description;
    private int idEmp;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Taches taches = (Taches) o;
        return Objects.equals(id, taches.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }
    public  Taches (){
        super();
    }
    public Taches(String id, String libelle, String description, int idEmp){
        this.id=id;
        this.libelle=libelle;
        this.description=description;
        this.idEmp=idEmp;
    }

}
