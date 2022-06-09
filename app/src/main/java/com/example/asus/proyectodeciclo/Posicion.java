package com.example.asus.proyectodeciclo;

public class Posicion {

    private String NM;
    private Integer PJ;
    private Integer PG;
    private Integer PE;
    private Integer PP;
    private Integer GF;
    private Integer GC;
    private Integer DG;
    private Integer PT;

    public Posicion(String NM, Integer PJ, Integer PG, Integer PE, Integer PP, Integer GF, Integer GC, Integer DG, Integer PT) {
        this.NM = NM;
        this.PJ = PJ;
        this.PG = PG;
        this.PE = PE;
        this.PP = PP;
        this.GF = GF;
        this.GC = GC;
        this.DG = DG;
        this.PT = PT;

    }

    public String getNM() {
        return NM;
    }

    public void setNM(String NM) {
        this.NM = NM;
    }

    public Integer getPJ() {
        return PJ;
    }

    public void setPJ(Integer PJ) {
        this.PJ = PJ;
    }

    public Integer getPG() {
        return PG;
    }

    public void setPG(Integer PG) {
        this.PG = PG;
    }

    public Integer getPE() {
        return PE;
    }

    public void setPE(Integer PE) {
        this.PE = PE;
    }

    public Integer getPP() {
        return PP;
    }

    public void setPP(Integer PP) {
        this.PP = PP;
    }

    public Integer getGF() {
        return GF;
    }

    public void setGF(Integer GF) {
        this.GF = GF;
    }

    public Integer getGC() {
        return GC;
    }

    public void setGC(Integer GC) {
        this.GC = GC;
    }

    public Integer getDG() {
        return DG;
    }

    public void setDG(Integer DG) {
        this.DG = DG;
    }

    public Integer getPT() {
        return PT;
    }

    public void setPT(Integer PT) {
        this.PT = PT;
    }
}
