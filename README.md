# Minpro-2-PBO-SistemManajemenPendataanHewanKebunBinatang  
Nama  : Noor Hamsyah Pratama  
NIM  : 2509116046  
Kelas  : B'2025  

## 1. Deskripsi Singkat Program  
Program ini adalah aplikasi untuk mengelola data hewan di sebuah kebun binatang. Setiap hewan memiliki data umum (ID, nama, jenis, umur, habitat) dan data perawatan (jenis perawatan & tanggal), serta dikategorikan menjadi dua jenis: Hewan Darat (punya atribut kecepatan lari) dan Hewan Air (punya atribut kedalaman renang). Program menyediakan operasi CRUD lengkap: Tambah, Lihat, Ubah, dan Hapus data hewan, lengkap dengan validasi input di setiap tahap.

## 2. Penjelasan Alur Program  
Berikut adalah alur dari program:

(1) **Tambah Data Hewan**  
<p align="center">
  <img width="491" height="652" alt="image" src="https://github.com/user-attachments/assets/7bcb907c-779e-40d1-919a-a959a9e38010" />
</p>  

ID hewan dicek dulu keunikannya sebelum lanjut ke input data umum (nama, jenis, umur, habitat). Pengguna kemudian memilih kategori antara Hewan Darat atau Hewan Air, yang menentukan atribut khusus apa yang ditanyakan selanjutnya (kecepatan lari / kedalaman renang). Terakhir, data perawatan diminta, dengan ID perawatan dicek unik dan tanggal divalidasi lewat `Validator.cekTanggal()` supaya tidak boleh di masa depan. Kalau semua lolos, objek HewanDarat/HewanAir baru dibuat dan disimpan.

(2) **Lihat Data Hewan**  
<p align="center">  
  <img width="601" height="980" alt="Screenshot 2026-09-24 214521" src="https://github.com/user-attachments/assets/2c24b60b-80e8-4d86-8ce7-bc25dbd0176a" />
</p>  

Program akan menampilkan semua data hewan satu per satu dengan memanggil method `tampilkanInfoLengkap()` pada setiap hewan di dalam daftar. Karena HewanDarat dan HewanAir masing-masing punya versi method ini sendiri. Tampilan yang muncul otomatis beda sesuai jenis hewannya, kalau Hewan Darat yang muncul info kecepatan lari, kalau Hewan Air yang muncul info kedalaman renang.

(3)**Ubah Data Hewan**  
<p align="center">
  <img width="498" height="478" alt="image" src="https://github.com/user-attachments/assets/0092b94c-d296-4f03-a90d-980c27b983f1" />
</p>  

Setelah ID hewan diverifikasi ada, objek lama diambil lewat `cariHewanBerdasarkanId()` untuk dua keperluan, yaitu menampung data umum yang baru dan mendeteksi label atribut khusus lewat `getLabel()`, sehingga program tahu harus menanyakan "kecepatan lari" atau "kedalaman renang" sesuai jenis hewannya secara otomatis. Data perawatan baru juga diminta, dengan pengecekan ID perawatan yang mengecualikan data milik hewan itu sendiri. Perubahan disimpan lewat `ubahHewan()` untuk data umum dan `setNilai()` untuk atribut khusus.

(4)**Hapus Data Hewan**  
<p align="center">
  <img width="357" height="300" alt="Screenshot 2026-09-24 220429" src="https://github.com/user-attachments/assets/d42e9d9e-d3e9-4daa-ac9c-d20fe85f013b" />
</p>   

Input ID langsung diteruskan ke `hapusHewan()`, yang menangani sendiri pencarian sekaligus penghapusan objek dari daftarHewan. Kalau ID tidak ditemukan, method ini mengembalikan false dan pesan error ditampilkan.

(5)**Keluar**  
<p align="center">
  <img width="591" height="282" alt="image" src="https://github.com/user-attachments/assets/ff6ecaef-bcaf-4d0a-9d06-a05d99a53bf3" />
</p>   

Perulangan do-while berhenti, `input.close()` dipanggil, program selesai.

## 3. Penjelasan Penerapan Encapsulation dan Inheritance

### Encapsulation
Seluruh atribut di package `model` (`Hewan`, `HewanDarat`, `HewanAir`, `PerawatanHewan`) disembunyikan dengan modifier `private`, sehingga tidak bisa diakses langsung dari luar class, satu-satunya jalan masuk adalah lewat getter dan setter `public` yang disediakan.

Setiap setter juga dibekali validasi sendiri, bukan sekadar menyimpan nilai mentah. Contoh di `Hewan.setNama()`:  
<p align="center">
  <img width="796" height="232" alt="Screenshot 2026-09-24 221239" src="https://github.com/user-attachments/assets/c3a5d24c-ea8a-487e-8798-199d65c5935a" />
</p>   


Penerapan lain dari encapsulation terlihat dari method yang sengaja dibatasi aksesnya:  
- `cariHewan()` di `PengelolaHewan` dibuat `private` karena hanya dipakai secara internal oleh `ubahHewan()` dan `hapusHewan()`, tidak perlu diekspos ke luar.
  <p align="center">
    <img width="356" height="180" alt="Screenshot 2026-09-24 221704" src="https://github.com/user-attachments/assets/7de4d523-86e7-4221-ade5-725cbbf1e2c5" />
  </p>  
- Constructor `Validator()` juga `private` karena class ini murni kumpulan method `static` yang memang tidak boleh diinstansiasi sama sekali.
  <p align="center">
    <img width="286" height="76" alt="image" src="https://github.com/user-attachments/assets/ba09a452-68d5-41d4-ac2d-ed61d941f271" />
  </p>    

### Inheritance  

`Hewan` bertindak sebagai **superclass** yang mewariskan atribut umum (id, nama, jenis, umur, habitat, perawatan) ke dua **subclass** (HewanDarat dan HewanAir):
<p align="center">
  <img width="411" height="27" alt="image" src="https://github.com/user-attachments/assets/bcfb3c1e-2e08-4962-98f9-44f7ac20bc39" />
  <img width="371" height="27" alt="image" src="https://github.com/user-attachments/assets/92865f54-f77d-4a61-8831-c11e653ce0d7" />
</p>  

Kedua subclass ini tidak mengulang penulisan atribut umum dari nol, constructor-nya cukup memanggil `super(...)` untuk mengisi bagian yang sudah diwariskan, baru kemudian mengisi atribut khususnya sendiri. Contoh di `HewanDarat`:  
<p align="center">
  <img width="1336" height="95" alt="image" src="https://github.com/user-attachments/assets/df332999-007e-4ee4-887e-bc67f98927bc" />
</p>   

## 4. Penjelasan Letak Penerapan Nilai Tambah

### Struktur MVC  
Program dipecah ke dalam tiga package:  
<p align="center">
  <img width="358" height="272" alt="Screenshot 2026-09-24 223144" src="https://github.com/user-attachments/assets/229a45f6-8ac6-4878-9f75-c569c91070ea" />
</p>  

- **Model** (`model`) berisi struktur data beserta validasi dasar per-objek saja, seperti nama tidak boleh kosong atau umur tidak boleh negatif. Package ini sama sekali tidak tahu-menahu soal tampilan atau alur menu.
- **Controller** (`service`) dipegang oleh dua class: `PengelolaHewan` menyimpan `ArrayList<Hewan>` dan menjalankan seluruh operasi CRUD, sedangkan `Validator` menangani validasi yang butuh melihat seluruh data sekaligus, bukan cuma satu objek, seperti cek ID unik, cek ID perawatan unik, cek tanggal tidak boleh di masa depan, dan cek format input angka.
- **View** (`view`) diwakili oleh `Main.java`, yang menangani seluruh interaksi dengan pengguna: menampilkan menu, membaca input, dan menampilkan hasil.

### Polymorphism  
**Method Overriding**: `tampilkanInfoLengkap()` dideklarasikan di `Hewan` untuk mencetak field umum. `HewanDarat` dan `HewanAir` masing-masing meng-override method ini, yaitu dengan memanggil `super.tampilkanInfoLengkap()` dulu untuk bagian umum, lalu menambahkan baris info sesuai kategorinya masing-masing:

**Superclass** Hewan:
<p align="center">
  <img width="1102" height="187" alt="image" src="https://github.com/user-attachments/assets/795a4262-4870-49a1-b914-95700ae83c3a" />
</p>   

**Subclass** HewanDarat dan HewanAir:
<p align="center">
  <img width="1131" height="115" alt="image" src="https://github.com/user-attachments/assets/f7a29b48-dc92-4ea0-b1e1-b1de04072f86" />
  <img width="1227" height="122" alt="image" src="https://github.com/user-attachments/assets/cccb3d1f-2a50-43f0-a468-aa874f3b7b93" />
</p> 

**Method Overloading**: `cekIdPerawatan()` di `Validator` memiliki dua versi dengan jumlah parameter berbeda:  
<p align="center"  
  <img width="1128" height="337" alt="image" src="https://github.com/user-attachments/assets/9ffd74f1-f64c-4938-bf51-4861cc512606" />
</p>  

Versi 2 parameter sebenarnya cuma memanggil versi 3 parameter dengan nilai `idHewanDikecualikan` diisi `-1`. Nilai `-1` dipilih karena ID hewan asli tidak mungkin negatif, sehingga tidak ada hewan yang benar-benar terkecualikan, semua hewan tetap dicek satu per satu. Dengan begitu, logika pengecekan cukup ditulis sekali saja di versi 3 parameter, sementara versi 2 parameter tinggal numpang ke sana.

Kedua versi ini benar-benar dipanggil terpisah di `Main.java`, versi 2 parameter dipakai di menu Tambah, versi 3 parameter dipakai di menu Ubah.
