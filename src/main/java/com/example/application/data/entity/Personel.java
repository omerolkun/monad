package com.example.application.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "personel")
public class Personel {
    @Id
    private int TCKNO;
    private String Ad;
    private String Soyad;


    public Personel(){}

    public Personel(int TCKNO, String Ad, String Soyad){
        this.TCKNO = TCKNO;
        this.Ad = Ad;
        this.Soyad = Soyad;
    }


    public int getTCKNO() {
        return TCKNO;
    }

    public void setTCKNO(int TCKNO) {
        this.TCKNO = TCKNO;
    }

    public String getAd() {
        return Ad;
    }

    public void setAd(String ad) {
        Ad = ad;
    }

    public String getSoyad() {
        return Soyad;
    }

    public void setSoyad(String soyad) {
        Soyad = soyad;
    }
}
