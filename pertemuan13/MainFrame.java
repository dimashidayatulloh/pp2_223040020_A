
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Contoh Konkurensi di Swing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);
            frame.setLayout(new BorderLayout());

            // label untuk status
            JLabel statusLabel = new JLabel("Tekan tombol untuk mulai tugas berat", JLabel.CENTER);

            // tombol untuk mulai proses
            JButton startButton = new JButton("Mulai");

            // Progress bar
            JProgressBar progressBar = new JProgressBar(0, 60);
            progressBar.setValue(0);
            progressBar.setStringPainted(true);

            // tambahkan komponen ke frame
            frame.add(statusLabel, BorderLayout.NORTH);
            frame.add(progressBar, BorderLayout.CENTER);
            frame.add(startButton, BorderLayout.SOUTH);

            // tombol aksi
            startButton.addActionListener(e -> {
                startButton.setEnabled(false);
                statusLabel.setText("Proses berjalan...");

                // buat SwingWorker untuk menangani tugas berat
                SwingWorker<Void, Integer> worker = new SwingWorker<>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        for (int i = 0; i <= 60; i++) {
                            Thread.sleep(50);
                            publish(i);

                        }
                        return null;
                    }

                    @Override
                    protected void process(List<Integer> chunks) {
                        // int Perbarui progress bar
                        int latestProgress = chunks.get(chunks.size() - 1);
                        progressBar.setValue(latestProgress);
                    }

                    @Override
                    protected void done() {
                        // aksi setelah tugas selesai
                        startButton.setEnabled(true);
                        statusLabel.setText("Proses Selesai!");
                    }
                };
                
                // jalankan SwingWorker
                worker.execute();
            });
        
        // tampilkan frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        });
    }
}