package com.example.asus.proyectodeciclo;

public class Equipo {

    private String id;
    private String nombre;
    private String perfil;
    private String grupo;
    private String ranking;
    private String apariciones;

    public Equipo(String id, String nombre, String perfil, String grupo, String ranking, String apariciones){

        this.id=id;
        this.nombre=nombre;
        this.perfil=perfil;
        this.grupo=grupo;
        this.ranking=ranking;
        this.apariciones=apariciones;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public String getApariciones() {
        return apariciones;
    }

    public void setApariciones(String apariciones) {
        this.apariciones = apariciones;
    }

}
