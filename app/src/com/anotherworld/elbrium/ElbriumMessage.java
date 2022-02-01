package com.anotherworld.elbrium;

public class ElbriumMessage {

    // см Message

    public float x;
    public float y;
    public float dir_x;
    public float dir_y;
    public int hp;
    public int rank;
    public int count;

    public ElbriumMessage(float x, float y, float dir_x, float dir_y, int hp, int rank, int count) {
        this.x = x;
        this.y = y;
        this.dir_x = dir_x;
        this.dir_y = dir_y;
        this.hp = hp;
        this.rank = rank;
        this.count=count;
    }

    public ElbriumMessage(ElbriumMessage em){
        x=em.x;
        y=em.y;
        dir_x=em.dir_x;
        dir_y=em.dir_y;
        hp=em.hp;
        rank=em.rank;
        count=em.count;
    }

    @Override
    public String toString() {
        return "\"x\":" + x  + "," +
                "\"y\":" + y  + "," +
                "\"dir_x\":\"" + dir_x + "\"," +
                "\"dir_y\":" + dir_y  + "," +
                "\"hp\":" + hp  + "," +
                "\"rank\":" + rank  + "," +
                "\"count\":" + count + "}";
    }
}
