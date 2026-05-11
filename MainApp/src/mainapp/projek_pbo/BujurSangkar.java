package mainapp.projek_pbo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BujurSangkar extends Persegi {

    private double tinggi;
    private double volume;
    private double luasPermukaan;

    public BujurSangkar() {
        super(0);
        this.tinggi = 0;
        this.volume = 0;
        this.luasPermukaan = 0;
    }
    
    public BujurSangkar(double sisi, double tinggi) {
        super(sisi);
        this.tinggi = tinggi;
        this.volume = hitungVolume();
        this.luasPermukaan = hitungLuasPermukaan();
    }
    
    public double hitungVolume() {
        volume = super.hitungLuas() * tinggi;
        return volume;
    }

    public double hitungLuasPermukaan() {
        luasPermukaan = 2 * super.hitungLuas() + super.hitungKeliling() * tinggi;
        return luasPermukaan;
    }

    public double hitungVolume(double sisiBaru, double tinggiBaru) {
        volume = super.hitungLuas(sisiBaru) * tinggiBaru;
        return volume;
    }

    public double hitungLuasPermukaan(double sisiBaru, double tinggiBaru) {
        luasPermukaan = 2 * super.hitungLuas(sisiBaru)
                + super.hitungKeliling(sisiBaru) * tinggiBaru;
        return luasPermukaan;
    }

    public void prosesInputDanValidasi() {

        Scanner inp = new Scanner(System.in);

        while (true) {
            System.out.print("\nApakah ingin mengubah nilai prisma? (Y/N): ");
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

                        System.out.print("Masukkan tinggi baru: ");
                        double newTinggi = inp.nextDouble();
                        inp.nextLine();

                        if (newTinggi <= 0) {
                            System.out.println("Tinggi harus lebih dari 0");
                            continue;
                        }

                        // update nilai
                        super.setSisi(newSisi);
                        this.tinggi = newTinggi;

                        volume = hitungVolume();
                        luasPermukaan = hitungLuasPermukaan();

                        System.out.printf("\nVolume Prisma Persegi: %.2f\n", volume);
                        System.out.printf("Luas Permukaan Prisma Persegi: %.2f\n", luasPermukaan);

                        break;

                    } catch (InputMismatchException e) {
                        System.out.println("Input harus angka!");
                        inp.nextLine();
                    }
                }

                break;

            } else if (jawab.equalsIgnoreCase("N")) {

                volume = hitungVolume();
                luasPermukaan = hitungLuasPermukaan();

                break;

            } else {
                System.out.println("Jawaban hanya boleh Y atau N");
            }
        }
    }
    
    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }

    public double getTinggi() {
        return tinggi;
    }

    public double getVolume() {
        return volume;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }
}