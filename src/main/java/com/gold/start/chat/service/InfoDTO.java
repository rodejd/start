package com.gold.start.chat.service;

import java.io.Serializable;

public class InfoDTO implements Serializable {

    enum Info {
        JOIN, EXIT, SEND
    }

    private String nickName;
    private String message;
    private Info command;

    public String getNickName(){
        return nickName;
    }
    public Info getCommand(){
        return command;
    }
    public String getMessage(){
        return message;
    }
    public void setNickName(String nickName){
        this.nickName= nickName;
    }
    public void setCommand(Info command){
        this.command= command;
    }
    public void setMessage(String message){
        this.message= message;
    }
}
