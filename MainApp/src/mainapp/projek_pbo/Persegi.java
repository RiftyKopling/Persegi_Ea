package mainapp.projek_pbo;

import mainapp.Handling.InvalidDimensionException;

public class Persegi extends BangunDatar {
    // Luas and Keliling shouldn't be an variable in object sudden change
    // on sisi might broke the other variable, so is dependant to sisi
    // all the variable inside shouldn't be accessible by other class
    // only accessible by setter and getter
    private double sisi;

    public Persegi() {
        this.sisi = 1;
    }

    public Persegi(double sisi) throws InvalidDimensionException {
        setSisi(sisi);
    }

    public void setSisi(double sisi) throws InvalidDimensionException {
        if (sisi <= 0) {
            throw new InvalidDimensionException("Sisi harus lebih dari 0");
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
            "Luas: %.2f cm², " +
            "Keliling: %.2f cm, " +
            this.getNamaBangun(),
            this.hitungLuas(),
            this.hitungKeliling()
        );
    }
}