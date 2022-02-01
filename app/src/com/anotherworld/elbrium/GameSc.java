package com.anotherworld.elbrium;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.google.gson.Gson;

//import com.


import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GameSc implements Screen {
    public static Joystick fireJoy;
    public static MotionJoystick joy;
    public static Player player;
    Sprite sprite=new Sprite(Main.background);
    public static OrthographicCamera camera;
    static Point2D realTimeCoords=new Point2D(0,0);

    public static Array<Bullet> bullets;
    public static Array<Elbrium> ore;
    private static Spawner spawner;
    private static Gson gson;
    public static final float SIZE_COEF=1;
    private final Multiplayer multiplayer;
    public static boolean batchDraw;

    private final Animation cometAnimation;
    private float cometPosX=100;
    private float cometPosY=1000;
    public static boolean playerIsSpawner;
    private static ArrayList<Elbrium> snifferOre;


    Buttons chat_button,back_button;
    BulletGenerator bullgen;
    float deathScAlpha=0;

    //PlayerDataCreator playerData;

    private final int joyX=(Main.HEIGHT/3)/2+(Main.HEIGHT/3)/4;
    private final int joyY=(Main.HEIGHT/3)/2+(Main.HEIGHT/3)/4;
    private final int joySize = Main.HEIGHT/3;

    private static final int entityRad = Main.HEIGHT/15;

    private static final int entityX=Main.BACKGROUND_WIDTH/2;
    private static final int entityY=Main.BACKGROUND_HEIGHT/2;

    public static final float player_x=Main.WIDTH/2f-entityRad;
    public static final float player_y=Main.HEIGHT/2f-entityRad;

    //<!!! --->

    String online_players;
    static GetterANDSetterFileC getter_setter;


    // ресурсы подгружаются с класса Main

    Main main;
    public DatabaseHelper databaseHelper;

    public GameSc(Main main){
        this.main=main;
        cometAnimation=new Animation(new TextureRegion(Main.comet_fr1),4,4,3);
        spawner=new Spawner();
        gson=new Gson();



        loadActors();

        multiplayer=new Multiplayer();
        databaseHelper=new DatabaseHelper();
        getter_setter=new GetterANDSetterFileC();
        //databaseHelper.setNickname(player.nickname);
        //databaseHelper.entryNotify();
        camera=new OrthographicCamera(Main.WIDTH/SIZE_COEF,Main.HEIGHT/SIZE_COEF);
        databaseHelper.readString(0);

        // databaseHelper.acceptString("online");
        // //      if(databaseHelper.readString()==null || databaseHelper.readString().length() == 0)databaseHelper.sendToFirebase("online",getter_setter.get_Nickname());
        //   else databaseHelper.sendToFirebase("online",databaseHelper.readString()+";"+getter_setter.get_Nickname());
        //return str == null || str.length() == 0;

        //camera=new OrthographicCamera(Main.WIDTH*3f,Main.HEIGHT*3f);
    }

    @Override
    public void render(float delta) {
        GameUpdate();
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Main.batch.setProjectionMatrix(camera.combined);
        camera.update();
        Main.batch.begin();

//        if(multiplayer.isSomeoneIN())multiplayer.draw(Main.batch);
        Main.batch.draw(Main.background,0,0);
        Main.batch.draw(cometAnimation.getFrame(),cometPosX,cometPosY);
        //bulletsMonitoring(Main.batch);


        //multiplayerRENDER();
        multiplayer.draw(Main.batch);
        backRender(Main.batch);
        player.draw(Main.batch);

        //player.send_in_ONLINE.debug(Main.batch);
        //player.bounds.debug(Main.batch,player.R);
        //player.bounds.pos.debug(Main.batch);
        // сплюсовать радиусы для отображения игрока ровно в центре
        // руда - batch



        Main.batch.end();

        Main.frontBatch.begin();
        buttonsLogic(Main.frontBatch);
        Main.frontBatch.setColor(1,1,1,1);
        frontRender(Main.frontBatch);
        Main.frontBatch.end();


        if(player.getHealth()<=0)death();
    }



    public void GameUpdate(){
        cometPosX+=1;

        //if(cometAnimation.isDone()){cometAnimation.setNewTextureReg(getCometRegion());}
        cometAnimation.update(0.1f);
        //player.setDirection(joy.getDir());

        player.update();
        bullgen.update(fireJoy);
        for(Bullet b : bullets){b.update();b.setCount(bullets.indexOf(b,true));if(b.isOut)bullets.removeValue(b,true);}

        if(!playerIsSpawner)snifferUpdate();
        else for(Elbrium e : ore){e.update();e.setCount(ore.indexOf(e,true));if(e.isOut)ore.removeValue(e,true);}

        collision();
        ore_player_collision();
    }

    public void frontRender(SpriteBatch frontBatch){
        joy.draw(frontBatch);
        fireJoy.draw(frontBatch);
    }

    public void playerRender(int case_){
        switch(case_){
            case 1:
                Main.playerBatch.begin();
                Main.playerBatch.draw(player.img, player_x, player_y, 100, 100);
                Main.playerBatch.end();
                break;
            case 0:
                Main.batch.draw(Main.getPlayer(), player_x, player_y, 100, 100);
                break;
        }
    }

    public void backRender(SpriteBatch batch){
        for(int i=0;i<bullets.size;i++)bullets.get(i).draw(batch);
        for(int i=0;i<ore.size;i++)ore.get(i).draw(batch);
//        multiplayer.draw(batch);

    }

    public void loadActors(){
        chat_button=new Buttons(true,Main.chat_button_un,Main.chat_button,joySize*1.1f,joySize*1.1f/2,
                Main.WIDTH-joySize*1.1f-joySize*1.1f/2*0.2f,Main.HEIGHT-joySize*1.1f/2*1.2f);
        back_button = new Buttons(true,Main.back_button_un,Main.back_button,joySize*1.1f,joySize*1.1f/2,
                joySize*1.1f/2*0.2f,Main.HEIGHT-joySize*1.1f/2*1.2f);


        player =new Player(Main.getPlayer(),new Point2D(entityX,entityY),5,entityRad,100);
        //getter.setPlayer(player);
        joy=new MotionJoystick(Main.circle,Main.stickImg,new Point2D(joyX,joyY),joySize,player);

        ore=new Array<>();
        bullgen=new BulletGenerator();

        fireJoy=new Joystick(Main.circle,Main.stickImg,new Point2D(Main.WIDTH-joyX,joyY),joySize);

        bullets=new Array<>();
        //if(!multiplayer.isSomeoneIN()

    }

    public void multitouch(float x,float y,boolean isDownTouch, int pointer){
        //isDownTouch true при нажатии
        for(int i=0;i<5;i++){
            joy.update(x,y,isDownTouch,pointer);
            fireJoy.update(x,y,isDownTouch,pointer);
            chat_button.action(x,y,isDownTouch,pointer);
            back_button.action(x,y,isDownTouch,pointer);
        }
    }

    //public static int getJoyX() {return joyX;}

    //public static int getJoyY() {return joyY;}

    public static void setPos(float x, float y){
        realTimeCoords.setPoint(x,y);
    }

    public static Point2D getPos(){
        return realTimeCoords;
    }

    public void collision(){
        for(Bullet bullet : bullets)
            for(Elbrium elbrium : ore)
                if(bullet.bounds.Overlaps(elbrium.bounds)){
                    elbrium.damaged(bullet,ore.indexOf(elbrium,true));
                    bullets.removeValue(bullet,true);
                    //Gdx.app.log("collision",j+"");
                }
                else elbrium.counter=elbrium.logOutSec;
    }

    public void ore_player_collision(){
        for(Elbrium elbrium : ore)
            if(elbrium.bounds.Overlaps(player.bounds)){

            }


        // //
        /*player.changeHealth(-elbrium.getDamage());
        player.changeSpeed(-0.1f);
        if(player.direction.getX()!=0&&player.direction.getY()!=0)elbrium.direction.setPoint(player.direction);
        else elbrium.direction.reverse();
        elbrium.changeHealth(-getter_setter.get_Protection());
        Gdx.app.error("player health",player.getHealth()+"");*/
        // //
        //else joy.oreOverlaps=false;
    }


    public void death(){
        final Timer timer=new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                player.changeHealth(10000);
                        /*if(deathScAlpha<1){deathScAlpha+=0.1f;
                            Main.hudBatch.setColor(0,0,0,deathScAlpha);}*/
                //else timer.cancel();
                Main.hudBatch.begin();
                Main.hudBatch.draw(Main.debugBG,Main.WIDTH/2f,Main.HEIGHT/2f);
                Main.hudBatch.end();


                //else sprite.getTexture().dispose();
            }
        };
        timer.scheduleAtFixedRate(task,0,60);
    }

    private void buttonsLogic(SpriteBatch btch){
        chat_button.draw(btch);
        if(chat_button.isTouch()){getter_setter.set_StartChat(1);databaseHelper.logOut();}
        back_button.draw(btch);
        if(back_button.isTouch())databaseHelper.logOut();
    }

    public static TextureRegion getCometRegion(Animation animation){
        //Gdx.app.error("switch",animation.getSceneCount()+"");
        switch (animation.getSceneCount()){
            case 1: return new TextureRegion(Main.comet_fr1);
            case 2: return new TextureRegion(Main.comet_fr2);
            case 3: return new TextureRegion(Main.comet_fr3);
        }
        return new TextureRegion(Main.err);
    }




    public static void spawnerLogic(){
        // вызывается если playerIsSpawner

        spawner.start();
    }

    public void snifferUpdate(){
        for(Elbrium e : ore){
            e.animationUpdate();
            e.setCount(ore.indexOf(e,true));}
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputProcessor() {
            @Override
            public boolean keyDown(int keycode) {
                return false;
            }

            @Override
            public boolean keyUp(int keycode) {
                return false;
            }

            @Override
            public boolean keyTyped(char character) {
                return false;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                //pointer - номер нажатия (0,1,...)
                screenY=Main.HEIGHT-screenY;
                setPos(screenX,screenY);
                Gdx.app.debug("pointer",pointer+" <-");
                multitouch((int)screenX,(int)screenY,true,pointer);
                return false;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                screenY=Main.HEIGHT-screenY;
                multitouch((int)screenX,(int)screenY,false,pointer);
                return false;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                screenY=Main.HEIGHT-screenY;
                setPos(screenX,screenY);
                multitouch((int)screenX,(int)screenY,true,pointer);
                return false;
            }

            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                return false;
            }

            @Override
            public boolean scrolled(float amountX, float amountY) {
                return false;
            }
        });
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        sprite.getTexture().dispose();
    }

}
