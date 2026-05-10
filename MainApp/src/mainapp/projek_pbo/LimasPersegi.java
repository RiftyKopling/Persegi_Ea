package mainapp.projek_pbo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LimasPersegi extends Persegi {


    private double tinggi;
    private double volume;
    private double luasPermukaan;

    public LimasPersegi(){
        super(0);
        this.tinggi = 0;
    }
    
    public LimasPersegi(double sisi, double tinggi) {
        super(sisi);
        this.tinggi = tinggi;
    }

    public double hitungVolume() {
        volume = (1.0 / 3.0) * super.hitungLuas() * tinggi;
        return volume;
    }

    public double hitungLuasPermukaan() {
        double sisi = super.getSisi();
        double tinggiSegitiga = Math.sqrt(Math.pow((sisi / 2), 2) + Math.pow(tinggi, 2));
        double luasSegitiga = 0.5 * sisi * tinggiSegitiga;

        luasPermukaan = super.hitungLuas() + (4 * luasSegitiga);
        return luasPermukaan;
    }

    public double hitungVolume(double sisiBaru, double tinggiBaru) {
        volume = (1.0 / 3.0) * super.hitungLuas(sisiBaru) * tinggiBaru;
        return volume;
    }

    public double hitungLuasPermukaan(double sisiBaru, double tinggiBaru) {
        double tinggiSegitiga = Math.sqrt(Math.pow((sisiBaru / 2), 2) + Math.pow(tinggiBaru, 2));
        double luasSegitiga = 0.5 * sisiBaru * tinggiSegitiga;

        luasPermukaan = super.hitungLuas(sisiBaru) + (4 * luasSegitiga);
        return luasPermukaan;
    }

    public void prosesInputDanValidasi() {

        Scanner inp = new Scanner(System.in);

        while (true) {
            System.out.print("\nApakah ingin mengubah nilai limas? (Y/N): ");
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

                        volume = hitungVolume(newSisi, newTinggi);
                        luasPermukaan = hitungLuasPermukaan(newSisi, newTinggi);

                        System.out.printf("\nVolume Limas: %.2f\n", volume);
                        System.out.printf("Luas Permukaan Limas: %.2f\n", luasPermukaan);

                        break;

                    } catch (InputMismatchException e) {
                        System.out.println("Input harus angka!");
                        inp.nextLine();
                    }
                }

                break;

            } else if (jawab.equalsIgnoreCase("N")) {
                break;
            } else {
                System.out.println("Input harus Y atau N");
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