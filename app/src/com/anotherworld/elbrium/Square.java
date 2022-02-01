package com.anotherworld.elbrium;

import com.badlogic.gdx.graphics.Texture;


import java.util.Timer;
import java.util.TimerTask;

public class Square {
    private Texture img;
    public int a;
    public Point2D pos;
    public int textureCount; // от 1 до 2 //
    public float thickness;
    private Timer timer;
    private TimerTask task;
    private int counter;
    private boolean switched;

    public Square(int a, int coefficientStrokeThickness) {
        this.a = a;
        pos = new Point2D(0,0);
        img = Main.square1;
        thickness=(float) a/coefficientStrokeThickness;
    }

    public Square(Square sq) {
        this.a = sq.a;
        pos = sq.pos.clone();
        img = Main.square1;
        thickness=sq.thickness;
    }

    public Point2D getCenter(){
        return new Point2D((float)a/2,(float)a/2);
    }

    public Point2D getRelativeCenter(){
        return new Point2D(Main.BACKGROUND_WIDTH+(float)a/2,Main.BACKGROUND_HEIGHT+(float)a/2);
    }

    public Point2D getPos() {
        return pos;
    }

    public void updateOX(){
        pos.add(new Point2D(a,0));
    }

    public void updatePOS(){
        pos.add(new Point2D(a,a));
    }

    public boolean isInside(Point2D pos){
        return (pos.getX()<this.pos.getX()+a &&
                pos.getX() > this.pos.getX() &&
                pos.getY() < this.pos.getY()+a &&
                pos.getY() > this.pos.getY());
    }

    public Texture getImg() {
        return img;
    }

    public void setImg(Texture img) {
        this.img = img;
    }

    public void imgSwitch(final int seconds, final Texture firstImg,final Texture secondImg){
        timer=new Timer();
        counter=seconds;
        task = new TimerTask() {
            @Override
            public void run() {
                if(counter==0){
                    if(switched){setImg(secondImg);switched=false;}
                    else {setImg(firstImg);switched=true;}
                    counter=seconds;
                }
                else counter--;
            }
        };
        timer.scheduleAtFixedRate(task,0,(long)1000*seconds);
    }

    public Square clone(){
        return new Square(this);
    }
}
