import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class BiodataTemanV2 extends JFrame {
    private boolean checkBoxSelected;

    public BiodataTemanV2() {
        this.checkBoxSelected = false;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menggunakan GridBagLayout
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Margin antar elemen

        // Label Form Biodata (di atas, di tengah)
        JLabel labelInput2 = new JLabel("Form Biodata", JLabel.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;  // Label ini melebar ke 4 kolom
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(labelInput2, gbc);

        // Reset pengaturan gridwidth untuk elemen selanjutnya
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        // Label Nama (Kolom Kiri)
        gbc.gridx = 1;
        gbc.gridy = 1;
        JLabel labelInput = new JLabel("Nama:");
        this.add(labelInput, gbc);

        // TextField Nama (Kolom Kiri)
        gbc.gridx = 1;
        gbc.gridy = 2;
        JTextField textField = new JTextField(15);
        this.add(textField, gbc);

        // Label Jenis Kelamin (Kolom Kanan)
        gbc.gridx = 2;
        gbc.gridy = 1;
        JLabel labelRadio = new JLabel("Jenis Kelamin:");
        this.add(labelRadio, gbc);

        // RadioButton Laki-Laki (Kolom Kanan)
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        JRadioButton radioButton1 = new JRadioButton("Laki-laki", true);
        this.add(radioButton1, gbc);

        // Label Nomor HP (Kolom Kiri)
        gbc.gridx = 1;
        gbc.gridy = 3;
        JLabel labelInput1 = new JLabel("Nomor HP:");
        this.add(labelInput1, gbc);

        // TextField Nomor HP (Kolom Kiri)
        gbc.gridx = 1;
        gbc.gridy = 4;
        JTextField textField1 = new JTextField(15);
        this.add(textField1, gbc);

        // RadioButton Perempuan (Kolom Kanan)
        gbc.gridx = 2;
        gbc.gridy = 3;
        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        this.add(radioButton2, gbc);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        // Checkbox Warga Negara Asing (Kolom Kanan)
        gbc.gridx = 2;
        gbc.gridy = 4;
        JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
        this.add(checkBox, gbc);

        // Tombol Simpan
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton button = new JButton("Simpan");
        this.add(button, gbc);

        // TextArea untuk Output
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        JTextArea txtOutput = new JTextArea(10, 30);
        txtOutput.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtOutput);
        this.add(scrollPane, gbc);

        // ActionListener untuk Checkbox
        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                checkBoxSelected = e.getStateChange() == 1;
            }
        });

        // ActionListener untuk Tombol Simpan
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jenisKelamin = radioButton1.isSelected() ? "Laki-laki" : "Perempuan";
                String wna = checkBoxSelected ? "Ya" : "Bukan";

                String nama = textField.getText();
                String telepon = textField1.getText();

                txtOutput.append("Nama: " + nama + "\n");
                txtOutput.append("Nomor HP: " + telepon + "\n");
                txtOutput.append("Jenis Kelamin: " + jenisKelamin + "\n");
                txtOutput.append("WNA: " + wna + "\n");
                txtOutput.append("========================================\n");

                // Reset input setelah klik simpan
                textField.setText("");
                textField1.setText("");
            }
        });

        this.setSize(600, 400);
        this.setLocationRelativeTo(null); // Agar jendela berada di tengah layar
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BiodataTemanV2 b = new BiodataTemanV2();
                b.setVisible(true);
            }
        });
    }
}
