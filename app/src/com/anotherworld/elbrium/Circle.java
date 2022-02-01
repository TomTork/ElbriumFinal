package com.anotherworld.elbrium;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Circle {
    // класс требует изменений
    public Circle(Point2D pos, float R){
        this.pos=new Point2D(pos);
        this.R=R;
    }

    float R;
    public Point2D pos;

    //лежит ли что-то в круге
    public boolean isContains(Point2D point){
        float dx=pos.getX()-point.getX();
        float dy=pos.getY()-point.getY();
        return dx*dx+dy*dy<=R*R;
    }

    public boolean isContains(float x, float y){
        float dx=pos.getX()-x;
        float dy=pos.getY()-y;
        return dx*dx+dy*dy<=R*R;
    }

    //пересекаются ли
    public boolean Overlaps(Circle c){
        float dx=pos.getX()-c.pos.getX();
        float dy =pos.getY()-c.pos.getY();
        float dist=dx*dx+dy*dy;
        float sumR=c.R+R;
        return dist<sumR*sumR;
        //true если пересекаются
    }

    public void add(float x, float y){
        pos.add(x,y);
    }

    public void debug(SpriteBatch batch, float R){
        batch.draw(Main.circle,pos.getX()-R,pos.getY()-R,2*R,2*R);
    }

}
