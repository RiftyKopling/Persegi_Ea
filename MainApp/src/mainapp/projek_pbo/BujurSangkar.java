package mainapp.projek_pbo;

import java.util.InputMismatchException;
import java.util.Scanner;
import mainapp.Handling.InvalidDimensionException;

public class BujurSangkar extends BangunRuang {
    private double tinggi;
    // 3D object shouldn't extend from 2d object, only has the object of 2d
    // as the base
    private Persegi base;

    public BujurSangkar() {
        this.base = new Persegi();
        this.tinggi = 1;
    }
    
    public BujurSangkar(double sisi, double tinggi) throws InvalidDimensionException {
        this.base = new Persegi();
        this.base.setSisi(sisi);
        this.setTinggi(tinggi);
    }
    
    public double hitungVolume() {
        double volume = base.hitungLuas() * tinggi;
        return volume;
    }

    public double hitungLuasPermukaan() {
        double luasPermukaan = 2 * base.hitungLuas() + base.hitungKeliling() * tinggi;
        return luasPermukaan;
    }

    public double hitungVolume(double sisiBaru, double tinggiBaru) {
        double volume = base.hitungLuas(sisiBaru) * tinggiBaru;
        return volume;
    }

    public double hitungLuasPermukaan(double sisiBaru, double tinggiBaru) {
        double luasPermukaan = 2 * base.hitungLuas(sisiBaru)
                + base.hitungKeliling(sisiBaru) * tinggiBaru;
        return luasPermukaan;
    }
    
    public void setTinggi(double tinggi) throws InvalidDimensionException {
        if (tinggi <= 0) {
            throw new InvalidDimensionException("Tinggi harus lebih dari 0");
        }
        this.tinggi = tinggi;
    }
    
    public void setSisi(double sisi) throws InvalidDimensionException {
        if (sisi <= 0) {
            throw new InvalidDimensionException("Sisi harus lebih dari 0");
        }
        this.base.setSisi(sisi);
    }

    public double getTinggi() {
        return tinggi;
    }
    @Override
    public String getNamaBangun() {
        return "Bujur Sangkar";
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