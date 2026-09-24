/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class PerawatanHewan {
    
    //Atribut
    private int idPerawatan;
    private String jenisPerawatan;
    private String tanggal;
    
    //Constructor
    public PerawatanHewan(int idPerawatan, String jenisPerawatan, String tanggal) {
        setIdPerawatan(idPerawatan);
        setJenisPerawatan(jenisPerawatan);
        setTanggal(tanggal);
    }
    
    //Getter dan Setter
    public int getIdPerawatan() {
        return idPerawatan;
    }
    
    public void setIdPerawatan(int idPerawatan) {
        if (idPerawatan < 0){
            throw new IllegalArgumentException("ID Perawatan tidak boleh negatif!");
        }
        this.idPerawatan = idPerawatan; 
    }
    
    public String getJenisPerawatan() {
        return jenisPerawatan;
    }
    
    public void setJenisPerawatan(String jenisPerawatan) {
         if (jenisPerawatan == null || jenisPerawatan.trim().isEmpty()){
            throw new IllegalArgumentException("Data Perawatan tidak boleh kosong!");
        }
        this.jenisPerawatan = jenisPerawatan.trim();
    }
    
    public String getTanggal() {
        return tanggal;
    }
    
    public void setTanggal(String tanggal) {
        if (tanggal == null || !tanggal.trim().matches("\\d{2}-\\d{2}-\\d{4}")){
            throw new IllegalArgumentException("Format tanggal harus dd-mm-yyyy, contoh 02-06-2026");
        }
        this.tanggal = tanggal.trim();
    }
    
}
