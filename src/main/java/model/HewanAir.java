/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class HewanAir extends Hewan{
    private double kedalamanRenangMeter;
    
    public HewanAir(int id, String nama, String jenis, int umur, String habitat, PerawatanHewan perawatan, double kedalamanRenangMeter) {
        super(id, nama, jenis, umur, habitat, perawatan);
        setKedalamanRenangMeter(kedalamanRenangMeter);
    }
    
    public double getKedalamanRenangMeter() {
        return kedalamanRenangMeter;
    }
 
    public void setKedalamanRenangMeter(double kedalamanRenangMeter) {
        if (kedalamanRenangMeter < 0) {
            throw new IllegalArgumentException("Kedalaman renang tidak boleh negatif.");
        }
        this.kedalamanRenangMeter = kedalamanRenangMeter;
    }
    
    @Override
    public void tampilkanInfoLengkap() {
        super.tampilkanInfoLengkap();
        System.out.println("Info Tambahan : Hewan air, mampu berenang hingga kedalaman " + kedalamanRenangMeter + " meter");
    }
    
    @Override
    public String getLabel() {
        return "kedalaman renang (meter)";
    }
 
    @Override
    public void setNilai(double nilai) {
        setKedalamanRenangMeter(nilai);
    }
}
