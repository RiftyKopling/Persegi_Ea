package mainapp;

public class BujurSangkar extends Persegi {

    public BujurSangkar(double sisi) {
        super(sisi);
    }

    @Override
    public double hitungLuas() {
        return super.getSisi() * super.getSisi();
    }

    @Override
    public double hitungKeliling() {
        return 4 * super.getSisi();
    }
}