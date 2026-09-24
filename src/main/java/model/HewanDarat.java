/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class HewanDarat extends Hewan{
    private double kecepatanLariKmJam;
    
    public HewanDarat(int id, String nama, String jenis, int umur, String habitat, PerawatanHewan perawatan, double kecepatanLariKmJam) {
        super(id, nama, jenis, umur, habitat, perawatan);
        setKecepatanLariKmJam(kecepatanLariKmJam);
    }
    
    public double getKecepatanLariKmJam() {
        return kecepatanLariKmJam;
    }
     
    public void setKecepatanLariKmJam(double kecepatanLariKmJam) {
        if (kecepatanLariKmJam < 0) {
            throw new IllegalArgumentException("Kecepatan lari tidak boleh negatif.");
        }
        this.kecepatanLariKmJam = kecepatanLariKmJam;
    }
    
    @Override
    public void tampilkanInfoLengkap() {
        super.tampilkanInfoLengkap();
        System.out.println("Info Tambahan : Hewan darat, kecepatan lari sekitar " + kecepatanLariKmJam + " km/jam");
    }

    
    @Override
    public String getLabel() {
        return "kecepatan lari (km/jam)";
    }
 
    @Override
    public void setNilai(double nilai) {
        setKecepatanLariKmJam(nilai);
    }
}
