package com.anotherworld.elbrium;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Joystick {
    private final Texture circleImg, stickImg;
    public Circle circleBounds, stickBounds;
    public float rcircle, rstick;
    public Point2D direction;
    private int pointer = -1;
    private float length;
    private float dx;
    private float dy;
    public float dist;

    public Joystick(Texture cimg, Texture simg, Point2D point, float size) {
        circleImg = cimg;
        stickImg = simg;
        rcircle = size / 2;
        rstick = rcircle / 2;
        circleBounds = new Circle(point, rcircle);
        stickBounds = new Circle(point, rstick);
        direction = new Point2D(0, 0);
    }

    public void draw(SpriteBatch batch){
        batch.draw(circleImg,circleBounds.pos.getX()-rcircle,circleBounds.pos.getY()-rcircle,rcircle*2,rcircle*2);
        batch.draw(stickImg,stickBounds.pos.getX()-rstick,stickBounds.pos.getY()-rstick,rstick*2,rstick*2);
    }

    public Point2D getDir() {
        return direction;
    }

    public void update(float x, float y, boolean isDownTouch, int pointer){
        if(pointer==this.pointer) {
            dx = circleBounds.pos.getX() - x;
            dy = circleBounds.pos.getY() - y;
        }
        length = (float) Math.sqrt(dx * dx + dy * dy);
        if(isDownTouch&&circleBounds.isContains(x,y)&&this.pointer==-1)this.pointer=pointer;
        if(circleBounds.Overlaps(stickBounds)&&isDownTouch&&this.pointer==pointer)atControl(x,y);
        if(!circleBounds.isContains(stickBounds.pos)){
            stickBounds.pos.setX(-rcircle/ length * dx +circleBounds.pos.getX());
            stickBounds.pos.setY(-rcircle/ length * dy +circleBounds.pos.getY());
        }
        if(!isDownTouch&&pointer==this.pointer){
            returnStick();
        }

    }

    public void atControl(float x, float y){
        stickBounds.pos.setPoint(x,y);
        float dx = circleBounds.pos.getX() - x;
        float dy = circleBounds.pos.getY() - y;
        float dist = (float) Math.sqrt(dx * dx + dy * dy);
        this.dist=dist;
        // проекции - косинус и синус
        if(dist!=0)direction.setPoint(-(dx / dist), -(dy / dist));
    }

    public void returnStick(){
        direction.setPoint(0,0);
        stickBounds.pos.setPoint(circleBounds.pos);
        pointer=-1;
    }

    public int getPointer() {
        return pointer;
    }
}