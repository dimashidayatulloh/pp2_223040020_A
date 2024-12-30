package controller;

import model.*;
import view.UserView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UserController {

    private UserView view;
    private UserMapper mapper;

    public UserController(UserView view, UserMapper mapper) {
        this.view = view;
        this.mapper = mapper;
        this.view.addAddRefreshListener(new RefreshListener());
        this.view.addAddUserListener(new AddUserListener());
    }

    class RefreshListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            view.setStatusMessage("Memuat daftar pengguna...");
            view.clearUserList();

            // Menggunakan SwingWorker untuk memuat data dengan konkurensi
            SwingWorker<Void, User> worker = new SwingWorker<>() {
                @Override
                protected Void doInBackground() throws Exception {
                    List<User> users = mapper.getAllUsers();

                    // Simulasi proses pemuatan data
                    for (User user : users) {
                        Thread.sleep(10);
                        publish(user);
                    }
                    return null;
                }

                @Override
                protected void process(List<User> chunks) {
                    for (User user : chunks) {
                        view.addUserToList(user.getName() + " (" + user.getEmail() + ")");
                    }
                }

                @Override
                protected void done() {
                    view.setStatusMessage("Selesai memuat data pengguna.");
                }
            };

            worker.execute();
        }
    }

    class AddUserListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String name = view.getNameInput();
            String email = view.getEmailInput();
            if (!name.isEmpty() && !email.isEmpty()) {
                User user = new User();
                user.setName(name);
                user.setEmail(email);

                mapper.insertUser(user);

                JOptionPane.showMessageDialog(view, "User Added Successfully!");
            } else {
                JOptionPane.showMessageDialog(view, "Please fill in all fields.");
            }
        }
    }
}
