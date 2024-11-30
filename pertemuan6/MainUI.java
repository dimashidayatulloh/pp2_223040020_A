package pertemuan6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainUI extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public MainUI() {
        setTitle("Antarmuka Pengguna Utama");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        // Set up CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Menambahkan panel-panel yang akan digunakan sebagai "antarmuka lain"
        mainPanel.add(adminPanel(), "Admin");
        mainPanel.add(UserPanel(), "User");

        // Tambahkan panel utama yang berisi CardLayout ke JFrame
        add(mainPanel);

        // Membuat JMenuBar dan item-item menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menuNavigate = new JMenu("Pengguna");

        JMenuItem menuItemHome = new JMenuItem("Admin");
        JMenuItem menuItemProfile = new JMenuItem("User");

        // Tambahkan action listener ke setiap item menu
        menuItemHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Admin");
            }
        });

        menuItemProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "User");
            }
        });

        // Tambahkan item ke menu navigasi
        menuNavigate.add(menuItemHome);
        menuNavigate.add(menuItemProfile);

        // Tambahkan menu ke menu bar
        menuBar.add(menuNavigate);

        // Set menu bar ke frame
        setJMenuBar(menuBar);

        setVisible(true);
    }

    // Panel untuk Admin
    private JPanel adminPanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Selamat Datang di Halaman Admin"));

        return panel;
    }

    // Panel untuk User
    private JPanel UserPanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Ini adalah Halaman User"));

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainUI());
    }
}

