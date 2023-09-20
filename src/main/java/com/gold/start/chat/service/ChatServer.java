package com.gold.start.chat.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) {
        int port = 7541; // 사용할 포트 번호
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("채팅 서버가 시작되었습니다. 포트 번호: " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept(); // 클라이언트 연결 대기
                System.out.println("클라이언트가 연결되었습니다.");

                // 클라이언트와 통신을 담당할 스레드 생성 및 시작
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try {
            // 클라이언트와 통신할 입출력 스트림 생성
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            String message;

            // 클라이언트로부터 메시지 수신 및 전송
            while ((message = reader.readLine()) != null) {
                System.out.println("클라이언트로부터 수신: " + message);
                // 수신한 메시지를 모든 클라이언트에게 브로드캐스트
                broadcastMessage(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void broadcastMessage(String message) {
        // TODO: 클라이언트에게 메시지를 브로드캐스트하는 로직을 구현합니다.
        // 모든 연결된 클라이언트에게 메시지를 전송하는 코드를 작성해야 합니다.
        // 이 부분은 클라이언트 목록을 관리하고 각 클라이언트에게 메시지를 전송하는 방식으로 구현할 수 있습니다.
    }
}
