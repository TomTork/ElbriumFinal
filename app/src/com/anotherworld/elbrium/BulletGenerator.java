package com.anotherworld.elbrium;


import java.util.Timer;
import java.util.TimerTask;


public class BulletGenerator {
    boolean isFire;
    boolean isTime=true;
    Timer timer;
    private static final int Sec=1;
    private float counter=Sec;
    private TimerTask task;

    public BulletGenerator(){
        timer=new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                if(counter==0){
                    isTime=true;
                }
                else counter--;
            }
        };
        timer.scheduleAtFixedRate(task,0,250);
    }

    public void update(Joystick joy){
        isFire= joy.getDir().getX() != 0 || joy.getDir().getY() != 0;
        if(isFire && isTime) {
            GameSc.bullets.add(new Bullet(Main.bullet, new Point2D(GameSc.player.bounds.pos), 18, GameSc.player.R/5, joy.getDir()));
            isTime=false;
            counter=Sec;
            //Gdx.app.error("isTime",isTime+"");
        }
    }
}
