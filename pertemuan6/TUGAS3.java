package pertemuan6;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class TUGAS3 extends JFrame {
    private boolean isAdmin = false;
    private JButton button;

    public TUGAS3() {
        this.setTitle("Aplikasi Daftar Mahasiswa");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menuUser = new JMenu("User");

        JMenuItem menuItemAdmin = new JMenuItem("Admin");
        JMenuItem menuItemUser = new JMenuItem("User");

        // Action Admin
        menuItemAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isAdmin = true;
                button.setEnabled(true);
                JOptionPane.showMessageDialog(null, "Anda masuk sebagai Admin.");
            }
        });

        // Action User
        menuItemUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isAdmin = false;
                button.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Anda masuk sebagai User.");
            }
        });

        menuUser.add(menuItemAdmin);
        menuUser.add(menuItemUser);
        menuBar.add(menuUser);
        this.setJMenuBar(menuBar);

        // Form
        JLabel labelInput2 = new JLabel("Form Mahasiswa", JLabel.CENTER);
        labelInput2.setBounds(0,0,350,30);

        JLabel labelInput = new JLabel("NIM:");
        labelInput.setBounds(15,40,350,30);
        JTextField textField = new JTextField();
        textField.setBounds(15,70,350,30);

        JLabel labelInput1 = new JLabel("Nama:");
        labelInput1.setBounds(15,100,350,30);
        JTextField textField1 = new JTextField();
        textField1.setBounds(15,130,350,30);

        JLabel labelRadio = new JLabel("Jenis Kelamin:");
        labelRadio.setBounds(15,160,350,30);
        JRadioButton radioButton1 = new JRadioButton("Laki-laki", true);
        radioButton1.setBounds(15,190,350,30);
        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(15,220,350,30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        String[] options = { "Teknik Informatika", "Teknik Lingkungan", "Teknik Mesin", "Teknik Industri" };
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setBounds(15,250,350,30);

        button = new JButton("Simpan");
        button.setBounds(15,290,350,40);
        button.setEnabled(false);

        // Table
        String[] columnNames = { "NIM", "Nama", "Jurusan", "Jenis Kelamin" };
        Object[][] data = {
                { 223040020, "Dimas", "Teknik Informatika", "Laki-laki" },
                { 223040022, "Fadhlul", "Teknik Informatika", "Laki-laki" },
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(15,340,350,100);

        // Button action admin
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isAdmin) {
                    String nim = textField.getText();
                    String nama = textField1.getText();
                    String jurusan = (String) comboBox.getSelectedItem();
                    String jenisKelamin = radioButton1.isSelected() ? radioButton1.getText() :
                            radioButton2.isSelected() ? radioButton2.getText() : "";

                    model.addRow(new Object[]{nim, nama, jurusan, jenisKelamin});

                    textField.setText("");
                    textField1.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Anda tidak memiliki akses untuk menambahkan data.");
                }
            }
        });

        this.add(button);
        this.add(textField);
        this.add(textField1);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(comboBox);
        this.add(labelInput);
        this.add(labelInput1);
        this.add(labelInput2);
        this.add(scrollPane);

        this.setSize(400,500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TUGAS3 b = new TUGAS3();
                b.setVisible(true);
            }
        });
    }
}
