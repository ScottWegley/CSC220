package FinalProject;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.*;

public class Client {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rock-Paper-Scissors Client");
        JPanel panel = new JPanel();
        JMenuBar mb = new JMenuBar();
        mb.add(new JMenu("Disconnected"));
        mb.add(new JMenu("PLAYER ?"));
        mb.add(new JMenu("Score: 0"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JLabel lblSSID = new JLabel("Input Session ID:");
        JTextField inputSSID = new JTextField(6);
        JButton btnConnect = new JButton("Connect");
        panel.add(lblSSID);
        panel.add(inputSSID);
        panel.add(btnConnect);

        JButton btnRock = new JButton("Rock");
        JButton btnScissors = new JButton("Scissors");
        JButton btnPaper = new JButton("Paper");

        btnRock.setEnabled(false);
        btnScissors.setEnabled(false);
        btnPaper.setEnabled(false);

        frame.getContentPane().add(BorderLayout.LINE_START, btnRock);
        frame.getContentPane().add(BorderLayout.CENTER, btnPaper);
        frame.getContentPane().add(BorderLayout.LINE_END, btnScissors);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.setVisible(true);

        btnConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (inputSSID.getText().length() != 6) {
                    JOptionPane.showMessageDialog(btnConnect, "Please Submit a 6 Character ID", "Invalid ID Length",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                        Socket socket = new Socket("localhost", 8000);
                        btnConnect.setEnabled(false);
                        inputSSID.setEditable(false);
                        ((JMenu) mb.getComponent(0)).setText("Connected");
                        JOptionPane.showMessageDialog(btnConnect, "Connected to server!", null,
                                JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
}