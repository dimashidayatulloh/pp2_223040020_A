import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowListenerExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("WindowListener Example");

        JLabel label = new JLabel("Lakukan operasi pada jendela.");
        label.setBounds(50,50,300,30);

        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                label.setText("Window Opened.");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                label.setText("Window Closing.");
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("Window Closed.");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                label.setText("Window Minimized.");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                label.setText("Window Restored.");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                label.setText("Window Activated.");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                label.setText("Window Deactivated.");
            }
        });

        frame.add(label);

        frame.setSize(400,200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
