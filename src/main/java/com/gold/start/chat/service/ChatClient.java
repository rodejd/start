package com.gold.start.chat.service;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

@Component
public class ChatClient {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // 서버의 IP 주소 입력
        int serverPort = 7541; // 서버의 포트 번호 입력

        try {
            Socket socket = new Socket(serverAddress, serverPort);
            System.out.println("서버에 연결되었습니다.");

            // 클라이언트에서 서버로 메시지를 보내는 스레드 시작
            ClientSender clientSender = new ClientSender(socket);
            clientSender.start();

            ChatClientGUI clientGUI = new ChatClientGUI(socket);
            // 서버에서 클라이언트로 메시지를 받는 스레드 시작
            ClientReceiver clientReceiver = new ClientReceiver(socket, clientGUI);
            clientReceiver.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientSender extends Thread {
    private Socket socket;
    private PrintWriter writer;

    public ClientSender(Socket socket) {
        this.socket = socket;
        try {
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                String message = scanner.nextLine();
                writer.println(message);
            }
        } finally {
            scanner.close();
        }
    }
}

class ClientReceiver extends Thread {
    private Socket socket;
    private ChatClientGUI clientGUI;

    public ClientReceiver(Socket socket, ChatClientGUI clientGUI) {
        this.socket = socket;
        this.clientGUI = clientGUI;
    }

    public void run() {
        try {
            while (true) {
                String message = new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine();
                if (message != null) {
                    clientGUI.appendMessage("서버로부터 수신: " + message);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

