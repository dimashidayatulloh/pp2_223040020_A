package model;

import java.util.List;
import org.apache.ibatis.annotations.*;

public interface MahasiswaMapper {

    // CREATE: Menambahkan data baru ke tabel mahasiswa
    @Insert("INSERT INTO mahasiswa (idMahasiswa, nama, tanggalLahir, jurusan, ipk) VALUES (#{idMahasiswa}, #{nama}, #{tanggalLahir}, #{jurusan}, #{ipk})")
    void insertMahasiswa(Mahasiswa mahasiswa);

    // READ: Mengambil semua data dari tabel mahasiswa
    @Select("SELECT * FROM mahasiswa")
    List<Mahasiswa> getAllMahasiswa();

    // READ: Mengambil data mahasiswa berdasarkan ID
    @Select("SELECT * FROM mahasiswa WHERE idMahasiswa = #{idMahasiswa}")
    Mahasiswa getMahasiswaById(@Param("idMahasiswa") int idMahasiswa);

    // UPDATE: Memperbarui data mahasiswa berdasarkan ID
    @Update("UPDATE mahasiswa SET nama = #{nama}, tanggalLahir = #{tanggalLahir}, jurusan = #{jurusan}, ipk = #{ipk} WHERE idMahasiswa = #{idMahasiswa}")
    void updateMahasiswa(Mahasiswa mahasiswa);

    // DELETE: Menghapus data mahasiswa berdasarkan ID
    @Delete("DELETE FROM mahasiswa WHERE idMahasiswa = #{idMahasiswa}")
    void deleteMahasiswa(@Param("idMahasiswa") int idMahasiswa);
}