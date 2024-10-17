import javax.swing.*;
import java.awt.event.*;
import java.util.Date;

public class PendaftaranNasabahBank extends JFrame {
    private boolean checkBoxSelected;

    public PendaftaranNasabahBank() {
        this.checkBoxSelected = false;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem resetItem = new JMenuItem("Reset");
        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(resetItem);
        menu.add(exitItem);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        // Input nama
        JLabel labelInput = new JLabel("Input Nama:");
        labelInput.setBounds(15, 10, 350, 30);

        JTextField textField = new JTextField();
        textField.setBounds(15, 40, 350, 30);

        // Input No HP
        JLabel labelInput1 = new JLabel("Nomor HP:");
        labelInput1.setBounds(15, 70, 350, 30);

        JTextField textField1 = new JTextField();
        textField1.setBounds(15, 100, 350, 30);

        // Pilihan Jenis Kelamin
        JLabel labelRadio = new JLabel("Jenis Kelamin:");
        labelRadio.setBounds(15, 130, 350, 30);

        JRadioButton radioButton1 = new JRadioButton("Laki-laki", true);
        radioButton1.setBounds(15, 160, 150, 30);

        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(180, 160, 150, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        // Checkbox WNA
        JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
        checkBox.setBounds(15, 190, 350, 30);

        // Input jenis tabungan
        JLabel labelTabungan = new JLabel("Jenis Tabungan:");
        labelTabungan.setBounds(15, 230, 350, 30);

        String[] opsiTabungan = {"Tabungan Konvensional", "Tabungan Anak", "Tabungan Haji", "Tabungan Giro"};
        JList<String> listTabungan = new JList<>(opsiTabungan);
        listTabungan.setBounds(15, 260, 350, 80);
        listTabungan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Input frekuensi transaksi per bulan
        JLabel labelTransaksi = new JLabel("Frekuensi Transaksi per Bulan:");
        labelTransaksi.setBounds(15, 290, 350, 30);

        SpinnerModel transaksiModel = new SpinnerNumberModel(1, 1, 100, 1);
        JSpinner spinnerTransaksi = new JSpinner(transaksiModel);
        spinnerTransaksi.setBounds(15, 360, 100, 30);

        // Input tanggal lahir
        JLabel labelTanggalLahir = new JLabel("Tanggal Lahir:");
        labelTanggalLahir.setBounds(15, 390, 350, 30);

        SpinnerModel dateModel = new SpinnerDateModel();
        JSpinner spinnerTanggalLahir = new JSpinner(dateModel);
        spinnerTanggalLahir.setBounds(15, 420, 150, 30);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinnerTanggalLahir, "dd/MM/yyyy");
        spinnerTanggalLahir.setEditor(dateEditor);

        // Input password dan confirm password
        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(15, 450, 350, 30);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(15, 480, 350, 30);

        JLabel labelConfirmPassword = new JLabel("Confirm Password:");
        labelConfirmPassword.setBounds(15, 510, 350, 30);

        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(15, 540, 350, 30);

        // Button
        JButton button = new JButton("Simpan");
        button.setBounds(15, 580, 350, 40);

        // Text Area
        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(15, 630, 350, 150);
        txtOutput.setEditable(false);

        // Checbox Listener
        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                checkBoxSelected = e.getStateChange() == 1;
            }
        });

        // Btn Listener
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jenisKelamin = radioButton1.isSelected() ? radioButton1.getText() : radioButton2.getText();
                String wna = checkBoxSelected ? "Ya" : "Bukan";

                String nama = textField.getText();
                String telepon = textField1.getText();
                String tabungan = listTabungan.getSelectedValue();
                int transaksi = (Integer) spinnerTransaksi.getValue();
                Date tanggalLahir = (Date) spinnerTanggalLahir.getValue();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                txtOutput.setText("");
                txtOutput.append("Nama:     " + nama + "\n");
                txtOutput.append("Nomor HP:    " + telepon + "\n");
                txtOutput.append("Jenis Kelamin:    " + jenisKelamin + "\n");
                txtOutput.append("WNA:     " + wna + "\n");
                txtOutput.append("Jenis Tabungan:     " + tabungan + "\n");
                txtOutput.append("Frekuensi Transaksi:     " + transaksi + "\n");
                txtOutput.append("Tanggal Lahir:     " + dateEditor.getFormat().format(tanggalLahir) + "\n");

                if (password.equals(confirmPassword)) {
                    txtOutput.append("Password Status: Cocok\n");
                } else {
                    txtOutput.append("Password Status: Tidak Cocok\n");
                }

                txtOutput.append("======================================================================\n");
            }
        });

        // Reset btn listener
        resetItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                textField1.setText("");
                passwordField.setText("");
                confirmPasswordField.setText("");
                listTabungan.clearSelection();
                spinnerTransaksi.setValue(1);
                spinnerTanggalLahir.setValue(new Date());
                txtOutput.setText("");
            }
        });

        // Exit btn listener
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        this.add(button);
        this.add(textField);
        this.add(textField1);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(checkBox);
        this.add(labelInput);
        this.add(labelInput1);
        this.add(txtOutput);
        this.add(labelTabungan);
        this.add(listTabungan);
        this.add(labelTransaksi);
        this.add(spinnerTransaksi);
        this.add(labelTanggalLahir);
        this.add(spinnerTanggalLahir);
        this.add(labelPassword);
        this.add(passwordField);
        this.add(labelConfirmPassword);
        this.add(confirmPasswordField);

        // ukuran GUI
        this.setSize(400, 900);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PendaftaranNasabahBank b = new PendaftaranNasabahBank();
                b.setVisible(true);
            }
        });
    }
}
