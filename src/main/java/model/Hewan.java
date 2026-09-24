/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class Hewan {
    
    //Atribut
    private int id;
    private String nama;
    private String jenis;
    private int umur;
    private String habitat;
    private PerawatanHewan perawatan;
    
    //Constructor
    public Hewan(int id, String nama, String jenis, int umur, String habitat, PerawatanHewan perawatan) {
        setId(id);
        setNama(nama);
        setJenis(jenis);
        setUmur(umur);
        setHabitat(habitat);
        setPerawatan(perawatan);
    }
    
    //Getter dan Setter
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        if (id < 0){
            throw new IllegalArgumentException("ID Hewan tidak boleh negatif!");
        }
        this.id = id;
    }
    
    public String getNama() {
        return nama;
    }
    
    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()){
            throw new IllegalArgumentException("Nama Hewan tidak boleh kosong!");
        }
        this.nama = nama.trim();
    }

    public String getJenis() {
        return jenis;
    }
   
    public void setJenis(String jenis) {
        if (jenis == null || jenis.trim().isEmpty()){
            throw new IllegalArgumentException("Jenis Hewan tidak boleh kosong!");
        }
        this.jenis = jenis.trim();
    }
    
    public int getUmur() {
        return umur;
    }
        
    public void setUmur(int umur) {
        if (umur < 0){
            throw new IllegalArgumentException("Umur Hewan tidak boleh negatif!");
        }
        this.umur = umur;
    }
    
    public String getHabitat() {
        return habitat;
    }
    
    public void setHabitat(String habitat) {
        if (habitat == null || habitat.trim().isEmpty()){
            throw new IllegalArgumentException("Habitat Hewan tidak boleh kosong!");
        }
        this.habitat = habitat.trim();
    }
    
    public PerawatanHewan getPerawatan() {
        return perawatan;
    }
    
    public void setPerawatan(PerawatanHewan perawatan) {
        if (perawatan == null){
            throw new IllegalArgumentException("Data Perawatan tidak boleh kosong!");
        }
        this.perawatan = perawatan;
    }
    
    public String getLabel() {
        return null;
    }
    
    public void setNilai(double nilai) {
    }
    
    public void tampilkanInfoLengkap() {
        System.out.println("Id : " + id);
        System.out.println("Nama : " + nama);
        System.out.println("Jenis : " + jenis);
        System.out.println("Umur : " + umur);
        System.out.println("Habitat : " + habitat);
        System.out.println("Perawatan : " + perawatan.getJenisPerawatan() + "(" + perawatan.getTanggal() + ")");
    }
    
}
