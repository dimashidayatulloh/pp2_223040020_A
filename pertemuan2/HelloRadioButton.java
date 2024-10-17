import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class HelloRadioButton extends JFrame {

    public HelloRadioButton() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelInput = new JLabel("Input Nama:");
        labelInput.setBounds(15,40,350,10);

        JTextField textField = new JTextField();
        textField.setBounds(15,60,350,30);

        JLabel labelRadio = new JLabel("Jenis Member:");
        labelRadio.setBounds(15,100,350,10);

        JRadioButton radioButton1 = new JRadioButton("Silver", true);
        radioButton1.setBounds(15,115,350,30);

        JRadioButton radioButton2 = new JRadioButton("Gold", true);
        radioButton2.setBounds(15,145,350,30);

        JRadioButton radioButton3 = new JRadioButton("Platinum", true);
        radioButton3.setBounds(15,175,350,30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);
        bg.add(radioButton3);

        JButton button = new JButton("Simpan");
        button.setBounds(15,205,350,40);

        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(15,250,350,100);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jenisMember = "";
                
                if (radioButton1.isSelected()){
                    jenisMember = radioButton1.getText();
                }
                if (radioButton2.isSelected()){
                    jenisMember = radioButton2.getText();
                }
                if (radioButton3.isSelected()){
                    jenisMember = radioButton3.getText();
                }

                String nama = textField.getText();
                txtOutput.append("Nama:     " + nama + "\n");
                txtOutput.append("Anda adalah member " + jenisMember + "\n");
                textField.setText("");
            }
        });

        this.add(button);
        this.add(textField);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(radioButton3);
        this.add(labelInput);
        this.add(txtOutput);

        this.setSize(400,500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                HelloRadioButton b = new HelloRadioButton();
                b.setVisible(true);
            }
        });
    }
}
