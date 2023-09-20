package com.gold.start.chat.service;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClientGUI extends JFrame {
    private Socket socket;
    private PrintWriter writer;
    private JTextField messageField;
    private JTextArea chatArea;

    public ChatClientGUI(Socket socket) {
        this.socket = socket;
        setTitle("Chat Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

        messageField = new JTextField();
        messageField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = messageField.getText();
                sendMessage(message);
                messageField.setText("");
            }
        });
        add(messageField, BorderLayout.SOUTH);

        setVisible(true);

        try {
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void sendMessage(String message) {
        if (writer != null) {
            writer.println(message);
            appendMessage("나: " + message); // 보낸 메시지를 화면에 표시
        }
    }

    public void appendMessage(String message) {
        chatArea.append(message + "\n");
    }

    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 7541;

        try {
            Socket socket = new Socket(serverAddress, serverPort);
            System.out.println("서버에 연결되었습니다.");

            ChatClientGUI clientGUI = new ChatClientGUI(socket);

            // 서버에서 클라이언트로 메시지를 받는 스레드 시작
            ClientReceiver clientReceiver = new ClientReceiver(socket, clientGUI);
            clientReceiver.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


//    위 코드에서 sendMessage 메소드에서 보낸 메시지를 화면에 표시하도록 수정했습니다. 클라이언트가 메시지를 보낼 때 appendMessage 메소드를 호출하여 보낸 메시지를 화면에 표시합니다.
//
//        따라서 1번 클라이언트와 2번 클라이언트가 각각 메시지를 보내면 그 메시지가 서로의 화면에 표시되어야 합니다. 이렇게 하면 대화 내용이 함께 보여지게 됩니다.


/* 메시지 확인 불가
public class ChatClientGUI extends JFrame {
    private Socket socket;
    private PrintWriter writer;
    private JTextField messageField;
    private JTextArea chatArea;

    public ChatClientGUI(Socket socket) {
        this.socket = socket;
        setTitle("Chat Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

        messageField = new JTextField();
        messageField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = messageField.getText();
                sendMessage(message);
                messageField.setText("");
            }
        });
        add(messageField, BorderLayout.SOUTH);

        setVisible(true);

        try {
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void sendMessage(String message) {
        if (writer != null) {
            writer.println(message);
        }
    }

    public void appendMessage(String message) {
        chatArea.append(message + "\n");
    }

    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 7541;

        try {
            Socket socket = new Socket(serverAddress, serverPort);
            System.out.println("서버에 연결되었습니다.");

            ChatClientGUI clientGUI = new ChatClientGUI(socket);

            // 서버에서 클라이언트로 메시지를 받는 스레드 시작
            ClientReceiver clientReceiver = new ClientReceiver(socket, clientGUI);
            clientReceiver.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

*/
