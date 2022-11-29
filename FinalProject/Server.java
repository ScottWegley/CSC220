package FinalProject;

import java.awt.Color;
import java.awt.Dimension;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.text.DefaultCaret;

public class Server {
    static JFrame frame;
    static JPanel panel;
    static JTextArea console;
    static JScrollPane consolePane;

    public static void main(String[] args) {
        frame = new JFrame("Server");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        panel = new JPanel();
        panel.setBackground(Color.black);

        consolePane = new JScrollPane(Console.generateConsole());
        consolePane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        consolePane.setBorder(null);
        consolePane.setPreferredSize(new Dimension(765, 400));
        panel.add(consolePane);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
        Console.log("testing");
    }
}

class Console {
    static JTextArea console;

    public static JTextArea generateConsole() {
        console = new JTextArea();
        console.setLineWrap(true);
        console.setEditable(false);
        console.setBackground(Color.black);
        console.setForeground(Color.white);
        DefaultCaret caret = (DefaultCaret)console.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        return console;
    }

    public static void log(String in) {
        console.append(LocalTime.now() + ": " + in + "\n");
    }

    public static void clear() {
        console.setText("");
    }
}

class ConnectionManager extends Thread {
    static HashMap<String, Socket> socketMap = new HashMap<String, Socket>();

    private static boolean active = false;

    public static synchronized void deactivate() {
        active = false;
    }

}

