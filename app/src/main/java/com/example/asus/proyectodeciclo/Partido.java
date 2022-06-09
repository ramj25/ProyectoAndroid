package com.example.asus.proyectodeciclo;


import java.io.Serializable;

/*the partido class*/
public class Partido implements Serializable{

    private int id;
    private String detalles;
    private String equipo1;
    private String equipo2;
    private Integer goles1;
    private Integer goles2;

    public Partido(int id, String detalles, String equipo1, String equipo2, Integer goles1, Integer goles2){

        this.id=id;
        this.detalles=detalles;
        this.equipo1=equipo1;
        this.equipo2=equipo2;
        this.goles1=goles1;
        this.goles2=goles2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    public Integer getGoles1() {
        return goles1;
    }

    public void setGoles1(Integer goles1) {
        this.goles1 = goles1;
    }

    public Integer getGoles2() {
        return goles2;
    }

    public void setGoles2(Integer goles2) {
        this.goles2 = goles2;
    }
}
