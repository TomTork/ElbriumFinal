package com.anotherworld.elbrium;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

//import pl.mk5.gdx.fireapp.GdxFIRDatabase;

public class Bullet extends Actor {

    public boolean isOut;
    int count; // индекс объекта
    private BulletMessage message;


    public Bullet(Texture img, Point2D position, float Speed, float R, Point2D direction) {
        super(img, position, Speed, R);
        this.direction=new Point2D(direction);
        message = new BulletMessage(Main.getter_setter.get_Attack(),0,0,Main.getter_setter.get_Nickname());
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(img,position.getX()-R,position.getY()-R,R*2,R*2);
        bounds.debug(batch,R);
    }

    @Override
    public void update() {
        position.add(direction.getX()* speed,direction.getY()* speed);
        bounds.pos.setPoint(position);
        //Gdx.app.log("bullet_position", position.toString());
        message.x=position.getX();
        message.y=position.getY();
        //GdxFIRDatabase.instance().inReference("Bullet"+count).setValue(new BulletMessage(Main.getter_setter.attack,position.getX(),position.getY()));
        isOut = (position.getX()+R<0 || position.getY()-R> Main.BACKGROUND_HEIGHT
                || position.getX()-R>Main.BACKGROUND_WIDTH || position.getY()+R<0);
        //FirebaseDatabase.getInstance().getReference("LibGDX").child("bullet_"+Main.getter_setter.get_Nickname()+count).setValue(message.toString());
        //GdxFIRDatabase.inst().inReference("bullet_"+Main.getter_setter.get_Nickname()+count).setValue(message.toString());      //Создает путь "bullet_"+Main.getter_setter.get_Nickname()+count и ставит message <BulletMessage>?
        //if (isOut)FirebaseDatabase.getInstance().getReference("LibGDX").child("bullet_"+Main.getter_setter.get_Nickname()+count).removeValue();
        //if(isOut)GdxFIRDatabase.inst().inReference("bullet_"+Main.getter_setter.get_Nickname()+count).removeValue();            //Удаляет при выходе пользователя -> почему не onDestroy()? или onPause()?

    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

}
