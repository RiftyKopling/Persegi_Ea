package mainapp.projek_pbo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LimasPersegi extends BangunRuang {
    private double tinggi;
    // 3D object shouldn't extend from 2d object, only has the object of 2d
    // as the base
    private Persegi base;

    public LimasPersegi(){
        this.base = new Persegi(0);
        this.tinggi = 0;
    }
    
    public LimasPersegi(double sisi, double tinggi) {
        this.base = new Persegi(sisi);
        this.tinggi = tinggi;
    }

    public double hitungVolume() {
        double volume = (1.0 / 3.0) * base.hitungLuas() * tinggi;
        return volume;
    }

    public double hitungLuasPermukaan() {
        double sisi = base.getSisi();
        double tinggiSegitiga = Math.sqrt(Math.pow((sisi / 2), 2) + Math.pow(tinggi, 2));
        double luasSegitiga = 0.5 * sisi * tinggiSegitiga;

        double luasPermukaan = base.hitungLuas() + (4 * luasSegitiga);
        return luasPermukaan;
    }

    public double hitungVolume(double sisiBaru, double tinggiBaru) {
        double volume = (1.0 / 3.0) * base.hitungLuas(sisiBaru) * tinggiBaru;
        return volume;
    }

    public double hitungLuasPermukaan(double sisiBaru, double tinggiBaru) {
        double tinggiSegitiga = Math.sqrt(Math.pow((sisiBaru / 2), 2) + Math.pow(tinggiBaru, 2));
        double luasSegitiga = 0.5 * sisiBaru * tinggiSegitiga;

        double luasPermukaan = base.hitungLuas(sisiBaru) + (4 * luasSegitiga);
        return luasPermukaan;
    }
    
    public double hitungLuasAlas(){
        return this.base.hitungLuas();
    }
    
    public double hitungLuasAlas(double sisiBaru) {
        return this.base.hitungLuas(sisiBaru);
    }
    
    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }
    
    public void setSisi(double sisi) {
        this.base.setSisi(sisi);
    }

    public double getTinggi() {
        return tinggi;
    }
    
    @Override
    public String getNamaBangun() {
        return "Limas Persegi";
    }

    @Override
    public String info() {
        return String.format(
            "Nama Bangun      : %s\n" +
            "Volume           : %.2f cm³\n" +
            "Luas Permukaan   : %.2f cm²\n" +
            "Luas Alas        : %.2f cm²",
            this.getNamaBangun(),
            this.hitungVolume(),
            this.hitungLuasPermukaan(),
            this.base.hitungLuas()
        );
    }
        
    @Override
    public String infoSingleLine() {
        return String.format("Nama: %s | Vol: %.2f cm³ | LP: %.2f cm² | LA: %.2f cm²", getNamaBangun(), hitungVolume(), hitungLuasPermukaan(), base.hitungLuas());
    }
}