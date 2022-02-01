package com.anotherworld.elbrium;

import com.badlogic.gdx.graphics.Texture;

public abstract class Actor extends GraphicsObj {

    // объекты игры имеют форму круга, пояснять поля, думаю, не стоит

    public Point2D position;
    public float speed,R;
    public Circle bounds;
    public Point2D direction;

    public Actor(Texture img, Point2D position, float speed, float R) {
        super(img);
        this.position=new Point2D(position);
        this.speed =speed;
        this.R=R;
        bounds = new Circle(position,R);
        direction=new Point2D(0,0);
    }

    public Actor(Texture img, Point2D position) {
        super(img);
        this.position=new Point2D(position);
        direction=new Point2D(0,0);
    }


    public void setDirection(Point2D dir){
        direction=dir;
    }
}
