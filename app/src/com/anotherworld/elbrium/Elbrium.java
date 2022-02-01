package com.anotherworld.elbrium;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.google.firebase.database.FirebaseDatabase;

//import pl.mk5.gdx.fireapp.GdxFIRDatabase;

public class Elbrium extends Actor {
    private final int startHealth;
    private int health;
    private int score;
    private int rank;
    public boolean isOut;
    private int count, switchReg;
    public Texture damaged_txr;
    private float deltaSpeed;
    public final float logOutSec=0.5f;
    public float counter=logOutSec;
    private final float player_damage;
    private float damage;
    private TextureRegion damageRegion,region;
    private final Animation animation;
    private int textureCase;
    private ElbriumMessage message;
    public static boolean sniffer = !GameSc.playerIsSpawner;

    public float getDamage() {
        return damage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
        message.count=count;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void damaged(Bullet b, int count){
        boolean isDamaged = true;
        //timeCheck();
        counter=logOutSec;
        img=damaged_txr;

        health-=player_damage;
        if(health>0&&health<=startHealth/5)textureCase=5;
        else if(health>startHealth/5&&health<=startHealth*2/5)textureCase=4;
        else if(health>startHealth*2/5&&health<=startHealth*3/5)textureCase=3;
        else if(health>startHealth*3/5&&health<=startHealth*4/5)textureCase=2;
        else textureCase=1;

        speed +=deltaSpeed;
        // //
        direction.setPoint(b.direction.getX(),b.direction.getY());
        if(health<=0){
            //textureCase=0;
            GameSc.player.getter_setter.add_elbrium(score);
            //GameSc.ore.removeIndex(count);
            FirebaseDatabase.getInstance().getReference("LibGDX").child("ore"+count).removeValue();
            //GdxFIRDatabase.inst().inReference("ore"+count).removeValue();                       //Удаляет значение по пути "ore"+count
            //Gdx.app.debug("Elbrium #"+count, "dead");
        }
        if(sniffer){message.hp=health;message.dir_x=direction.getX();message.dir_y=direction.getY();}
        if (sniffer)FirebaseDatabase.getInstance().getReference("LibGDX").child("ore"+GameSc.ore.indexOf(this,true)).setValue(message.toString());
        //if(sniffer)GdxFIRDatabase.inst().inReference("ore"+GameSc.ore.indexOf(this,true)).setValue(message.toString());      //Ставит message <ElbriumMessage>

    }

    public Elbrium(Texture img, Point2D position, int rank) {
        // конструктор для игрока-спавнера
        super(img, position);
        message=new ElbriumMessage(0,0,0,0,0,rank,GameSc.ore.indexOf(this,true));
        counter=-1;
        textureCase=1;
        player_damage=GameSc.player.damage;
        //region=new TextureRegion(Main.elbrium,);
        animation=new Animation(new TextureRegion(Main.elbriumCrash),4,4,1);

        switch (rank){
            case -1: health=10;score=100;R=Main.WIDTH/50f;
                speed =0.8f;deltaSpeed=0.001f;damage=50;break;
            case 0: health=100;score=50;R= Main.WIDTH/50f;
                speed =0.1f;deltaSpeed=0.01f;damage=5;break;
            case 1: health=30;score=50;R=Main.WIDTH/50f;
                speed =0.5f;deltaSpeed=0.01f;damage=5;break;
            case 2: health=50;score=80;R= Main.WIDTH/35f;
                speed =0.3f;deltaSpeed=0.0015f;damage=20;break;
            case 3: health=120;score=150;R= Main.WIDTH/25f;
                speed =0.015f;deltaSpeed=0.001f;damage=35;break;
        }


        startHealth=health;
        bounds = new Circle(position,R);
        setPosition();
    }

    public Elbrium(Texture img, ElbriumMessage em) {
        super(img, new Point2D(em.x, em.y));
        this.direction=new Point2D(em.dir_x, em.dir_y);
        counter=-1;
        this.rank=em.rank;
        message=new ElbriumMessage(em);
        health= message.hp;
        textureCase=1;
        player_damage=GameSc.player.damage;
        //region=new TextureRegion(Main.elbrium,);
        animation=new Animation(new TextureRegion(Main.elbriumCrash),4,4,1);

        switch (rank){
            case -1: score=100;R=Main.WIDTH/50f;
                speed =0.8f;deltaSpeed=0.001f;damage=50;break;
            case 0: score=5;R= Main.WIDTH/50f;
                speed =0.1f;deltaSpeed=0.01f;damage=5;break;
            case 1: score=5;R=Main.WIDTH/50f;
                speed =0.5f;deltaSpeed=0.01f;damage=5;break;
            case 2: score=8;R= Main.WIDTH/35f;
                speed =0.3f;deltaSpeed=0.0015f;damage=20;break;
            case 3: score=15;R= Main.WIDTH/25f;
                speed =0.015f;deltaSpeed=0.001f;damage=35;break;
        }


        startHealth=health;
        bounds = new Circle(position,R);
    }

    public void setPosition(){
        direction.setX((float) Math.cos(Math.toRadians(Math.random()*360)));
        direction.setY((float) Math.sin(Math.toRadians(Math.random()*360)));
        message.dir_x=direction.getX();
        message.dir_y=direction.getY();
    }

    @Override
    public void draw(SpriteBatch batch) {
        if(health>0)batch.draw(thisTexture(),position.getX()-R,position.getY()-R,R*2,R*2);
        else batch.draw(animation.getFrame(),position.getX()-R,position.getY()-R,R*2,R*2);
    }

    @Override
    public void update() {
        // вылетел за карту? удаляем

        // 0 - spawner
        // 1 - player
        if (GameSc.playerIsSpawner)
        {
            animationUpdate();
            position.add(direction.getX() * speed, direction.getY() * speed);
            bounds.pos.setPoint(position);
            isOut = (position.getX() + R < 0 || position.getY() - R > Main.BACKGROUND_HEIGHT
                    || position.getX() - R > Main.BACKGROUND_WIDTH || position.getY() + R < 0);
            if (GameSc.playerIsSpawner) {
                message.x = position.getX();
                message.y = position.getY();
                message.hp = getHealth();
                FirebaseDatabase.getInstance().getReference("LibGDX").child("ore" + count).setValue(message.toString());
                //GdxFIRDatabase.inst().inReference("ore" + count).setValue(message.toString());              //То же что и было. Почему-то не в методе
            }
        }
        else {
            if (health <= 0) animation.update(0.1f);
            if (animation.isDone()) GameSc.ore.removeValue(this, true);
        }

    }

    public void snifferUpdate(ElbriumMessage em){
        position.setPoint(em.x,em.y);
        bounds.pos.setPoint(position);
        health=em.hp;
    }

    public void animationUpdate(){
        if (health <= 0) animation.update(0.1f);
        if (animation.isDone()) GameSc.ore.removeValue(this, true);
    }

    private Texture thisTexture(){
        switch (textureCase){
            case 0: animation.getFrame();
            case 1:return Main.ore1;
            case 2:return Main.ore2;
            case 3:return Main.ore3;
            case 4:return Main.ore4;
            case 5:return Main.ore5;
        }
        return Main.err;
    }


}
