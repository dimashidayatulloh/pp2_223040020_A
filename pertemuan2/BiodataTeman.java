import javax.swing.*;
import java.awt.event.*;

public class BiodataTeman extends JFrame {
    private boolean checkBoxSelected;

    public BiodataTeman() {
        this.checkBoxSelected = false;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelInput = new JLabel("Input Nama:");
        labelInput.setBounds(15,40,350,30);

        JTextField textField = new JTextField();
        textField.setBounds(15,70,350,30);

        JLabel labelInput1 = new JLabel("Nomor HP:");
        labelInput1.setBounds(15,100,350,30);

        JTextField textField1 = new JTextField();
        textField1.setBounds(15,130,350,30);

        JLabel labelRadio = new JLabel("Jenis Kelamin:");
        labelRadio.setBounds(15,160,350,30);

        JRadioButton radioButton1 = new JRadioButton("Laki-laki", true);
        radioButton1.setBounds(15,190,350,30);

        JRadioButton radioButton2 = new JRadioButton("Perempuan", true);
        radioButton2.setBounds(15,220,350,30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
        checkBox.setBounds(15,250,350,30);

        JButton button = new JButton("Simpan");
        button.setBounds(15,290,350,40);

        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(15,340,350,100);

        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                checkBoxSelected = e.getStateChange()==1;
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jenisKelamin = "";
                String wna = "";
                if (checkBoxSelected) {
                    wna = "Ya";
                } else {
                    wna = "Bukan";
                }
                
                if (radioButton1.isSelected()){
                    jenisKelamin = radioButton1.getText();
                }
                if (radioButton2.isSelected()){
                    jenisKelamin = radioButton2.getText();
                }

                String nama = textField.getText();
                String telepon = textField1.getText();
                txtOutput.append("Nama:     " + nama + "\n");
                txtOutput.append("Nomor HP:    " + telepon + "\n");
                txtOutput.append("Jenis Kelamin:    " + jenisKelamin + "\n");
                txtOutput.append("WNA:     " + wna + "\n");
                txtOutput.append("======================================================================");
                textField.setText("");
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

        this.setSize(400,500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BiodataTeman b = new BiodataTeman();
                b.setVisible(true);
            }
        });
    }
}
