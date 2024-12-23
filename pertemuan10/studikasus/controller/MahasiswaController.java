package controller;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import java.util.List;

import model.Mahasiswa;
import model.MahasiswaMapper;

public class MahasiswaController {

    private SqlSessionFactory sqlSessionFactory;

    public MahasiswaController() {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Mahasiswa> getAllMahasiswa() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            MahasiswaMapper mapper = session.getMapper(MahasiswaMapper.class);
            return mapper.getAllMahasiswa();
        }
    }

    public Mahasiswa getMahasiswaById(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            MahasiswaMapper mapper = session.getMapper(MahasiswaMapper.class);
            return mapper.getMahasiswaById(id);
        }
    }

    public void insertMahasiswa(Mahasiswa mahasiswa) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            MahasiswaMapper mapper = session.getMapper(MahasiswaMapper.class);
            mapper.insertMahasiswa(mahasiswa);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Gagal menambahkan mahasiswa: " + e.getMessage());
        }
    }

    public void updateMahasiswa(Mahasiswa mahasiswa) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            MahasiswaMapper mapper = session.getMapper(MahasiswaMapper.class);
            mapper.updateMahasiswa(mahasiswa);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Gagal memperbarui mahasiswa: " + e.getMessage());
        }
    }

    public void deleteMahasiswa(int idMahasiswa) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            MahasiswaMapper mapper = session.getMapper(MahasiswaMapper.class);
            mapper.deleteMahasiswa(idMahasiswa);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Gagal menghapus mahasiswa: " + e.getMessage());
        }
    }

}
