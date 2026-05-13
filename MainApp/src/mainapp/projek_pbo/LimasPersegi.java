package mainapp.projek_pbo;

import mainapp.Handling.InvalidDimensionException;

public class LimasPersegi extends BangunRuang {
    private double tinggi;
    // 3D object shouldn't extend from 2d object, only has the object of 2d
    // as the base
    private Persegi base;

    public LimasPersegi() {
        this.base = new Persegi();
        this.tinggi = 1;
    }
    
    public LimasPersegi(double sisi, double tinggi) throws InvalidDimensionException {
        this.base = new Persegi();
        this.base.setSisi(sisi);
        this.setTinggi(tinggi);
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