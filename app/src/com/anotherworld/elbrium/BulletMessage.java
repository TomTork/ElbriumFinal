package com.anotherworld.elbrium;

public class BulletMessage {

    // см Message

    public double damage;
    public float x;
    public float y;
    public String nick;

    public BulletMessage(double damage, float x, float y,String nick) {
        this.damage = damage;
        this.x = x;
        this.y = y;
        this.nick=nick;
    }

    @Override
    public String toString(){
        return "\"damage\":" + damage + "," +
                "\"x\":" + x  + "," +
                "\"y\":" + y  + "," +
                "\"nick\":" + nick + "}";

    }
}
