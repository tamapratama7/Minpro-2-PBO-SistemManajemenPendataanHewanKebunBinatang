/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author ASUS
 */

import java.util.Scanner;
import model.Hewan;
import model.HewanAir;
import model.HewanDarat;
import model.PerawatanHewan;
import service.PengelolaHewan;
import service.Validator;

public class Main {
    
    private static int bacaInt(Scanner input, String prompt){
        while (true){
            System.out.print(prompt);
            String baris = input.nextLine().trim();
            if (Validator.validasiAngka(baris)){
                return Integer.parseInt(baris);
            }
            System.out.println("Input harus berupa angka, COBA LAGI!!");
        }
    }
    
    private static String bacaString(Scanner input, String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }
    
    private static double bacaDouble(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            String baris = input.nextLine().trim();
            if (Validator.cekDesimal(baris)) {
                return Double.parseDouble(baris);
            }
            System.out.println("Input harus berupa angka (boleh desimal), coba lagi.");
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PengelolaHewan pengelola = new PengelolaHewan();

        int pilihan;

        do {
            System.out.println("\n=========================================");
            System.out.println("  SISTEM PENDATAAN HEWAN KEBUN BINATANG  ");
            System.out.println("=========================================");
            System.out.println("1. Tambah Data Hewan");
            System.out.println("2. Lihat Data Hewan");
            System.out.println("3. Ubah Data Hewan");
            System.out.println("4. Hapus Data Hewan");
            System.out.println("5. Keluar");
            System.out.println("==========================================");
            pilihan = bacaInt(input, "Pilih menu: ");

            switch (pilihan) {
                case 1:
                    System.out.println("\n=== TAMBAH DATA HEWAN ===");

                    int idBaru = bacaInt(input, "Masukkan ID hewan: ");
                    
                    if (pengelola.cekId(idBaru)){
                        System.out.println("\nID hewan sudah dipakai!!");
                        break;
                    }
                    
                    String namaBaru = bacaString(input, "Masukkan nama hewan: ");
                    String jenisBaru = bacaString(input, "Masukkan jenis hewan: ");
                    int umurBaru = bacaInt(input, "Masukkan umur hewan: ");
                    String habitatBaru = bacaString(input, "Masukkan habitat hewan: ");
                    
                    System.out.println("\nKategori hewan:");
                    System.out.println("1. Hewan Darat");
                    System.out.println("2. Hewan Air");
                    int kategoriBaru = bacaInt(input, "Pilih kategori (1/2): ");
                    
                    if (kategoriBaru != 1 && kategoriBaru != 2) {
                        System.out.println("\nKategori tidak dikenali.");
                        break;
                    }
 
                    double kecepatanLariBaru = 0;
                    double kedalamanRenangBaru = 0;
                    
                    if (kategoriBaru == 1) {
                        kecepatanLariBaru = bacaDouble(input, "Masukkan kecepatan lari (km/jam): ");
                    } else {
                        kedalamanRenangBaru = bacaDouble(input, "Masukkan kedalaman renang maksimal (meter): ");
                    }
                    
                    System.out.println("\n=== DATA PERAWATAN ===");
                    
                    int idPerawatanBaru = bacaInt(input, "Masukkan ID perawatan: ");
                    
                    if (pengelola.cekIdPerawatan(idPerawatanBaru)) {
                        System.out.println("\nID perawatan sudah dipakai");
                        break;
                    }
                    
                    String jenisPerawatanBaru = bacaString(input, "Masukkan jenis perawatan: ");
                    String tanggalBaru = bacaString(input, "Masukkan tanggal perawatan (dd-mm-yyyy): ");
 
                    try {
                        Validator.cekTanggal(tanggalBaru);
 
                        PerawatanHewan perawatanBaru = new PerawatanHewan(
                                idPerawatanBaru,
                                jenisPerawatanBaru,
                                tanggalBaru
                        );
                        
                        Hewan hewanBaru;
                        if (kategoriBaru == 1) {
                            hewanBaru = new HewanDarat(
                                    idBaru, namaBaru, jenisBaru, umurBaru, habitatBaru,
                                    perawatanBaru, kecepatanLariBaru
                            );
                        } else {
                            hewanBaru = new HewanAir(
                                    idBaru, namaBaru, jenisBaru, umurBaru, habitatBaru,
                                    perawatanBaru, kedalamanRenangBaru
                            );
                        }
                        
                        if (pengelola.tambahHewan(hewanBaru)) {
                            System.out.println("\nData hewan dan perawatan berhasil ditambahkan!");
                        } else {
                            System.out.println("\nGagal menambahkan, ID hewan sudah dipakai.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("\nData tidak valid: " + e.getMessage());
                    }
 
                    break;
                    
                case 2:
                    System.out.println("\n=== DATA HEWAN ===");
 
                    if (pengelola.getDaftarHewan().isEmpty()) {
                        System.out.println("Belum ada data hewan.");
 
                    } else {
 
                        for (Hewan dataHewan : pengelola.getDaftarHewan()) {
 
                            System.out.println("\n--------------------------");
                            dataHewan.tampilkanInfoLengkap();
                            System.out.println("--------------------------");
                        }
                    }
 
                    break;

                case 3:
                    System.out.println("\n=== UBAH DATA HEWAN ===");

                    int idUbah = bacaInt(input, "Masukkan ID hewan yang ingin diubah: ");

                    if (!pengelola.cekId(idUbah)) {
                        System.out.println("\nID hewan tidak ditemukan.");
                        break;
                    }
                    
                    Hewan hewanLama = pengelola.cariHewanBerdasarkanId(idUbah);
                    
                    String namaUbah = bacaString(input, "Masukkan nama hewan baru: ");
                    String jenisUbah = bacaString(input, "Masukkan jenis hewan baru: ");
                    int umurUbah = bacaInt(input, "Masukkan umur hewan baru: ");
                    String habitatUbah = bacaString(input, "Masukkan habitat hewan baru: ");
                    
                    double nilaiAtributKhususUbah = 0;
                    String labelAtributKhusus = hewanLama.getLabel();
                    
                    if (labelAtributKhusus != null) {
                        nilaiAtributKhususUbah = bacaDouble(input, "Masukkan " + labelAtributKhusus + " baru: ");
                    }
                    
                    System.out.println("\n=== DATA PERAWATAN BARU ===");
 
                    int idPerawatanUbah = bacaInt(input, "Masukkan ID perawatan baru: ");
                    
                    if (pengelola.cekIdPerawatan(idPerawatanUbah, idUbah)){
                        System.out.println("\nID Perawatan sudah dipakai");
                    }
                    
                    String jenisPerawatanUbah = bacaString(input, "Masukkan jenis perawatan baru: ");
                    String tanggalUbah = bacaString(input, "Masukkan tanggal perawatan baru (dd-mm-yyyy): ");
                    
                    try {
                        Validator.cekTanggal(tanggalUbah);
 
                        PerawatanHewan perawatanUbah = new PerawatanHewan(
                                idPerawatanUbah,
                                jenisPerawatanUbah,
                                tanggalUbah
                        );
 
                        boolean berhasilUbah = pengelola.ubahHewan(
                                idUbah,
                                namaUbah,
                                jenisUbah,
                                umurUbah,
                                habitatUbah,
                                perawatanUbah
                        );
 
                        if (berhasilUbah) {
                            if (labelAtributKhusus != null) {
                                hewanLama.setNilai(nilaiAtributKhususUbah);
                            }
                            System.out.println("\nData hewan berhasil diubah!");
                        } else {
                            System.out.println("\nID hewan tidak ditemukan.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("\nData tidak valid: " + e.getMessage());
                    }
 
                    break;

                case 4:
                    System.out.println("\n=== HAPUS DATA HEWAN ===");

                    int idHapus = bacaInt(input, "Masukkan ID hewan yang ingin dihapus: ");
 
                    boolean berhasilHapus = pengelola.hapusHewan(idHapus);
 
                    if (berhasilHapus) {
                        System.out.println("\nData hewan berhasil dihapus!");
                    } else {
                        System.out.println("\nID hewan tidak ditemukan.");
                    }
 
                    break;

                case 5:
                    System.out.println("\nProgram selesai. Terima kasih!");
                    break;

                default:
                    System.out.println("\nPilihan menu tidak tersedia.");
                    break;
            }

        } while (pilihan != 5);

        input.close();
    }
}
