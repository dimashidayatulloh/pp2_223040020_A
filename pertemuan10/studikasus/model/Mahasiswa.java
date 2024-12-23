package model;

import java.util.Date;

public class Mahasiswa {
    private int idMahasiswa;
    private String nama;
    private Date tanggalLahir;
    private String jurusan;
    private double ipk;

    // Constructor
    public Mahasiswa(int idMahasiswa, String nama, Date tanggalLahir, String jurusan, double ipk) {
        this.idMahasiswa = idMahasiswa;
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.jurusan = jurusan;
        this.ipk = ipk;
    }

    // Getter dan Setter
        public int getIdMahasiswa() {
        return idMahasiswa;
    }

    public void setIdMahasiswa(int idMahasiswa) {    
        this.idMahasiswa = idMahasiswa;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public double getIpk() {
        return ipk;
    }

    public void setIpk(double ipk) {
        this.ipk = ipk;
    }
}
