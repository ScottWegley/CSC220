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

    @Override
    public void run() {
        try {
            active = true;
            ServerSocket serverSocket = new ServerSocket(8000);
            Console.log("Listening for Connections on " + serverSocket.getLocalPort());
            while (active) {
                Socket incoming = serverSocket.accept();
                String ssID = new DataInputStream(incoming.getInputStream()).readUTF();
                Console.log("New Connection with SSID(" + ssID + ") and IP address "
                        + incoming.getInetAddress().getHostAddress());
                if (socketMap.get(ssID) == null) {
                    socketMap.put(ssID, incoming);
                } else {
                    new SessionHandler(socketMap.get(ssID), incoming, ssID).start();
                    socketMap.remove(ssID);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class SessionHandler extends Thread {
    DataInputStream fromPlayer1;
    DataInputStream fromPlayer2;
    DataOutputStream toPlayer1;
    DataOutputStream toPlayer2;

    String ssID;
    Socket player1;
    Socket player2;
    int victories = 0;
    int[] scores = { 0, 0 };

    public SessionHandler(Socket _player1, Socket _player2, String _ssID) {
        this.ssID = _ssID;
        this.player1 = _player1;
        this.player2 = _player2;
        try {
            fromPlayer1 = new DataInputStream(this.player1.getInputStream());
            fromPlayer2 = new DataInputStream(this.player2.getInputStream());
            toPlayer1 = new DataOutputStream(this.player1.getOutputStream());
            toPlayer2 = new DataOutputStream(this.player2.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        try {
            Console.log(
                "Starting a session with SSID(" + ssID + ") between IPS "
                        + this.player1.getInetAddress().getHostAddress()
                        + " and " + this.player2.getInetAddress().getHostAddress());
            toPlayer1.writeInt(1);
            toPlayer2.writeInt(2);
            toPlayer1.writeBoolean(true);
            while (scores[0] < 3 && scores[1] < 3) {
                int p1move = fromPlayer1.readInt();
                toPlayer2.writeBoolean(true);
                int p2move = fromPlayer2.readInt();
                Console.log("Player 1 move is " + RPS_MOVE.values()[p1move] + " and Player 2 move is "
                        + RPS_MOVE.values()[p2move]);
                toPlayer1.writeInt(RPS_MOVE.values()[p1move].fight(RPS_MOVE.values()[p2move]).ordinal());
                toPlayer2.writeInt(RPS_MOVE.values()[p2move].fight(RPS_MOVE.values()[p1move]).ordinal());
                switch (RPS_MOVE.values()[p1move].fight(RPS_MOVE.values()[p2move])) {
                    default:
                        Console.log("SSID(" + ssID + ") Drawn.  The score is " + scores[0] + "-" + scores[1]);
                        break;
                    case VICTORY:
                        victories += 1;
                        scores[0] += 1;
                        Console.log("SSID(" + ssID + ") Player 1 wins.  The score is " + scores[0] + "-" + scores[1]);
                        break;
                    case DEFEAT:
                        victories += 1;
                        scores[1] += 1;
                        Console.log("SSID(" + ssID + ") Player 2 wins.  The score is " + scores[0] + "-" + scores[1]);
                        break;
                }
                if (!(scores[0] == 3 || scores[1] == 3)) {
                    toPlayer1.writeBoolean(true);
                } else {
                    Console.log("SSID(" + ssID + ") has an overall " + (scores[0] == 3? "Player 1 " : "Player 2 ") + "victory!");
                    //DATABASE SHIT GOES HERE
                    if(fromPlayer1.readBoolean() && fromPlayer2.readBoolean()){
                        Console.log("SSID(" + ssID + ") is playing again.");
                        toPlayer1.writeBoolean(true);
                        toPlayer2.writeBoolean(true);
                        scores[0] = 0;
                        scores[1] = 0;
                        toPlayer1.writeBoolean(true);
                    } else {
                        toPlayer1.writeBoolean(false);
                        toPlayer2.writeBoolean(false);
                        Console.log("SSID(" + ssID + ") Terminated");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}