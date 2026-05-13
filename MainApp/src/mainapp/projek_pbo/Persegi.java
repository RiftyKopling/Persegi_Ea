package mainapp.projek_pbo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Persegi extends BangunDatar {
    // Luas and Keliling shouldn't be an variable in object sudden change
    // on sisi might broke the other variable, so is dependant to sisi
    // all the variable inside shouldn't be accessible by other class
    // only accessible by setter and getter
    private double sisi;

    // Overloading Implementation
    public Persegi() {
        setSisi(0);
    }

    public Persegi(double sisi) {
        setSisi(sisi);
    }

    public void setSisi(double sisi) {
        if (sisi < 0) {
            throw new IllegalArgumentException("Sisi harus > 0");
        }
        this.sisi = sisi;
    }

    public double getSisi() {
        return sisi;
    }

    @Override
    public double hitungLuas() {
        return this.sisi * this.sisi;
    }

    @Override
    public double hitungKeliling() {
        return 4 * this.sisi;
    }

    public double hitungLuas(double sisiBaru) {
        return sisiBaru * sisiBaru;
    }

    public double hitungKeliling(double sisiBaru) {
        return 4 * sisiBaru;
    }

    // Input Output shouldn't be handle by geometri class and should handle by
    // other class that declare the class object
    
    @Override
    public String getNamaBangun() {
        return "Persegi";
    }

    @Override
    public String info() {
        return String.format(
            "Nama Bangun      : %s\n" +
            "Luas             : %.2f cm³\n" +
            "Keliling         : %.2f cm²\n" +
            this.getNamaBangun(),
            this.hitungLuas(),
            this.hitungKeliling()
        );
    }
        
    @Override
    public String infoSingleLine() {
        return String.format(
            "Nama Bangun: %s, " +
            "Luas: %.2f cm³, " +
            "Keliling: %.2f cm², " +
            this.getNamaBangun(),
            this.hitungLuas(),
            this.hitungKeliling()
        );
    }
}