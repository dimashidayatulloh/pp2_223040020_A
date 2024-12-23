import view.MahasiswaView;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            MahasiswaView view = new MahasiswaView();
            view.setVisible(true);
        });
    }
}