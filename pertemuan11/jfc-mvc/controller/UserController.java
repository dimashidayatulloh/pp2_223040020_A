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

        // Register listeners
        this.view.addAddUserListener(new AddUserListener());
        this.view.addAddRefreshListener(new RefreshListener());  // Correct listener registration
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

    class RefreshListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            List<User> users = mapper.getAllUsers();
            String[] userArray = users.stream()
                    .map(u -> u.getName() + " (" + u.getEmail() + ")")  // Corrected reference to u.getName()
                    .toArray(String[]::new);
            view.setUserList(userArray);
        }
    }
}
