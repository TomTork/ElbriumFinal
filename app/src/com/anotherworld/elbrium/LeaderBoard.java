package com.anotherworld.elbrium;

public class LeaderBoard { // Класс-конструктор для TableLeader
    public String nickname;
    public double elbrium;

    public LeaderBoard(String nickname,double elbrium){
        this.nickname = nickname;
        this.elbrium = elbrium;
    }
    public LeaderBoard(){}
    public String getNickname() {
        return nickname;
    }
    public double getElbrium() {
        return elbrium;
    }
}