package com.gold.start.chat.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

@Service
public class ChatService {



    public void clientSockect(){

        Socket socket = null;
        BufferedReader in = null;
        BufferedWriter out = null;
        Scanner sc = new Scanner(System.in);

        try {
            // 1. 클라이언트 소켓 생성 및 서버 접속
            Socket clientSocket = new Socket("localhost", 9999);

            // 2. 네트워크 입출력 스트림 생성
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            // 3. 서버로 데이터 전송 (클라이언트->서버)
            while(true) {
                System.out.print("보내기 >> ");
                String outMsg = sc.nextLine();

                if(outMsg.equalsIgnoreCase("bye")) {
                    out.write(outMsg + "\n");
                    out.flush();
                    break;
                }

                // 정상 메시지의 경우
                out.write(outMsg + "\n");
                out.flush();

                // 4. 서버로부터 데이터 수신 (서버->클라이언트)
                String inMsg = in.readLine();
                System.out.println("서버 >> " + inMsg);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5. 접속 종료

            try {
                sc.close();
                out.close();
                in.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }


    public void serverSocket(){
        ServerSocket serverSocket = null;
        Socket socket = null;
        BufferedReader in = null;
        BufferedWriter out = null;
        Scanner sc = new Scanner(System.in);

        try {

            // 1. 서버 소켓 생성
            serverSocket = new ServerSocket(9999);

            // 2. 연결 대기
            System.out.println("연결 대기중...");

            socket = serverSocket.accept();
            System.out.println("연결 되었습니다.");

            // 3. 네트워크 입출력 스트림 생성
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // 4. 클라이언트로부터 데이터 수신 (서버<-클라이언트)
            while(true) {
                String inMsg = in.readLine();
                if(inMsg.equalsIgnoreCase("bye")) {
                    System.out.println("클라이언트가 나갔습니다.");
                    break;
                }

                // 정상 메시지의 경우
                System.out.println("클라이언트 > " + inMsg);

                // 5. 클라이언트로 데이터 전송 (서버->클라이언트)
                System.out.print("보내기 >> ");
                String outMsg = sc.nextLine();
                out.write(outMsg + "\n");
                out.flush();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 6. 접속 종료
            try {
                sc.close();
                out.close();
                in.close();
                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }













}
