package view;

import controller.MahasiswaController;
import model.Mahasiswa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MahasiswaView extends JFrame {
    private final MahasiswaController controller;
    private final DefaultTableModel tableModel;
    private final JTable table;
    private final JTextField txtId, txtNama, txtTanggalLahir, txtJurusan, txtIpk;
    private final SimpleDateFormat dateFormat;

    public MahasiswaView() {
        controller = new MahasiswaController();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        setTitle("CRUD Mahasiswa");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel Utama
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Tabel
        tableModel = new DefaultTableModel(new String[]{"ID", "Nama", "Tanggal Lahir", "Jurusan", "IPK"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Panel Form
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        txtId = new JTextField();
        txtNama = new JTextField();
        txtTanggalLahir = new JTextField();
        txtJurusan = new JTextField();
        txtIpk = new JTextField();

        formPanel.add(new JLabel("ID (Auto-Increment)"));
        formPanel.add(txtId);
        txtId.setEditable(false);

        formPanel.add(new JLabel("Nama"));
        formPanel.add(txtNama);

        formPanel.add(new JLabel("Tanggal Lahir (yyyy-MM-dd)"));
        formPanel.add(txtTanggalLahir);

        formPanel.add(new JLabel("Jurusan"));
        formPanel.add(txtJurusan);

        formPanel.add(new JLabel("IPK"));
        formPanel.add(txtIpk);

        // Panel Tombol
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnAdd = new JButton("Tambah");
        JButton btnUpdate = new JButton("Update");
        JButton btnDelete = new JButton("Hapus");
        JButton btnClear = new JButton("Bersihkan");
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnClear);

        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        // Event Handling
        btnAdd.addActionListener(e -> tambahMahasiswa());
        btnUpdate.addActionListener(e -> updateMahasiswa());
        btnDelete.addActionListener(e -> hapusMahasiswa());
        btnClear.addActionListener(e -> clearForm());
        table.getSelectionModel().addListSelectionListener(e -> isiFormDariTabel());

        // Load Data
        loadTableData();
    }

    private void loadTableData() {
        tableModel.setRowCount(0);
        List<Mahasiswa> mahasiswaList = controller.getAllMahasiswa();
        for (Mahasiswa m : mahasiswaList) {
            tableModel.addRow(new Object[]{
                m.getIdMahasiswa(),
                m.getNama(),
                dateFormat.format(m.getTanggalLahir()),
                m.getJurusan(),
                m.getIpk()
            });
        }
    }

    private void tambahMahasiswa() {
        try {
            String nama = txtNama.getText();
            Date tanggalLahir = dateFormat.parse(txtTanggalLahir.getText());
            String jurusan = txtJurusan.getText();
            double ipk = Double.parseDouble(txtIpk.getText());

            Mahasiswa mahasiswa = new Mahasiswa(0, nama, tanggalLahir, jurusan, ipk);
            controller.insertMahasiswa(mahasiswa);
            JOptionPane.showMessageDialog(this, "Mahasiswa berhasil ditambahkan!");
            clearForm();
            loadTableData();
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Format tanggal tidak valid! Gunakan yyyy-MM-dd.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal menambahkan data: " + e.getMessage());
        }
    }

    private void updateMahasiswa() {
        try {
            int id = Integer.parseInt(txtId.getText());
            String nama = txtNama.getText();
            Date tanggalLahir = dateFormat.parse(txtTanggalLahir.getText());
            String jurusan = txtJurusan.getText();
            double ipk = Double.parseDouble(txtIpk.getText());

            Mahasiswa mahasiswa = new Mahasiswa(id, nama, tanggalLahir, jurusan, ipk);
            controller.updateMahasiswa(mahasiswa);
            JOptionPane.showMessageDialog(this, "Mahasiswa berhasil diperbarui!");
            clearForm();
            loadTableData();
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Format tanggal tidak valid! Gunakan yyyy-MM-dd.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal memperbarui data: " + e.getMessage());
        }
    }

    private void hapusMahasiswa() {
        try {
            int id = Integer.parseInt(txtId.getText());
            controller.deleteMahasiswa(id);
            JOptionPane.showMessageDialog(this, "Mahasiswa berhasil dihapus!");
            clearForm();
            loadTableData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage());
        }
    }

    private void clearForm() {
        txtId.setText("");
        txtNama.setText("");
        txtTanggalLahir.setText("");
        txtJurusan.setText("");
        txtIpk.setText("");
        table.clearSelection();
    }

    private void isiFormDariTabel() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            txtId.setText(tableModel.getValueAt(selectedRow, 0).toString());
            txtNama.setText(tableModel.getValueAt(selectedRow, 1).toString());
            txtTanggalLahir.setText(tableModel.getValueAt(selectedRow, 2).toString());
            txtJurusan.setText(tableModel.getValueAt(selectedRow, 3).toString());
            txtIpk.setText(tableModel.getValueAt(selectedRow, 4).toString());
        }
    }
}