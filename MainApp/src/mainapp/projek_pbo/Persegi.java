package mainapp.projek_pbo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Persegi extends BangunDatar {

    protected double sisi;
    protected double luas;
    protected double keliling;

    // Overloading Implementation
    public Persegi() {
        setSisi(0);
        this.luas = 0;
        this.keliling = 0;
    }

    public Persegi(double sisi) {
        setSisi(sisi);
        this.luas = hitungLuas();
        this.keliling = hitungKeliling();
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
        luas = sisi * sisi;
        return luas;
    }

    @Override
    public double hitungKeliling() {
        keliling = 4 * sisi;
        return keliling;
    }

    public double hitungLuas(double sisiBaru) {
        return sisiBaru * sisiBaru;
    }

    public double hitungKeliling(double sisiBaru) {
        return 4 * sisiBaru;
    }

    public void prosesInputDanValidasi() {

        Scanner inp = new Scanner(System.in);

        while (true) {
            System.out.print("\nApakah ingin mengubah nilai sisi persegi? (Y/N): ");
            String jawab = inp.nextLine();

            if (jawab.equalsIgnoreCase("Y")) {

                while (true) {
                    try {
                        System.out.print("Masukkan sisi baru: ");
                        double newSisi = inp.nextDouble();
                        inp.nextLine();

                        if (newSisi <= 0) {
                            System.out.println("Sisi harus lebih dari 0");
                            continue;
                        }

                        sisi = newSisi;
                        luas = hitungLuas(newSisi);
                        keliling = hitungKeliling(newSisi);

                        System.out.printf("\nLuas Persegi: %.2f\n", luas);
                        System.out.printf("Keliling Persegi: %.2f\n", keliling);

                        break;

                    } catch (InputMismatchException e) {
                        System.out.println("Input harus angka!");
                        inp.nextLine();
                    }
                }

                break;

            } else if (jawab.equalsIgnoreCase("N")) {

                luas = hitungLuas();
                keliling = hitungKeliling();

                break;

            } else {
                System.out.println("Jawaban hanya boleh Y atau N");
            }
        }
    }

    public double getLuas() {
        return luas;
    }

    public double getKeliling() {
        return keliling;
    }
}