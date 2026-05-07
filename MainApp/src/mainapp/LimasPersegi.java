package mainapp;

public class LimasPersegi extends Persegi {

    private double tinggi;

    public LimasPersegi(double sisi, double tinggi) {
        super(sisi);
        setTinggi(tinggi);
    }

    public void setTinggi(double tinggi) {
        if (tinggi <= 0) {
            throw new IllegalArgumentException("Tinggi harus > 0");
        }
        this.tinggi = tinggi;
    }

    public double getTinggi() {
        return tinggi;
    }

    @Override
    public double hitungLuas() {
        double alas = getSisi() * getSisi();
        double sisiTegak = 4 * (0.5 * getSisi() * tinggi);
        return alas + sisiTegak;
    }

    public double hitungVolume() {
        return (1.0/3) * getSisi() * getSisi() * tinggi;
    }
}