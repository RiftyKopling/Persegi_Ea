package mainapp;

public class Persegi extends BangunDatar { // Inheritence

    protected double sisi;

    public Persegi(double sisi) throws IllegalArgumentException {
        setSisi(sisi);
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
    }

    public void setSisi(double sisi) {
        if (sisi <= 0) {
            throw new IllegalArgumentException("Sisi harus > 0");
        }
        this.sisi = sisi;
    }

    public double getSisi() { // Encapsulation
        return sisi;
    }

    @Override
    public double hitungLuas() {
        return sisi * sisi;
    }

    @Override
    public double hitungKeliling() {
        return 4 * sisi;
    }

    // 🔥 OVERLOADING
    public double hitungLuas(double sisiBaru) {
        return sisiBaru * sisiBaru;
    }

    public double hitungKeliling(double sisiBaru) {
        return 4 * sisiBaru;
    }
}