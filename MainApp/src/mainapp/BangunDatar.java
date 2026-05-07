package mainapp;

public abstract class BangunDatar implements BendaGeometri { // Abstraction
    protected double luas; // Enkapsulation
    protected double keliling;

    public BangunDatar() {}

    @Override
    public abstract double hitungLuas();

    @Override
    public abstract double hitungKeliling();
}