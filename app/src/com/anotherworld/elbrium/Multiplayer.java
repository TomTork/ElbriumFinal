package com.anotherworld.elbrium;

import android.util.Log;

import androidx.annotation.NonNull;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

//import pl.mk5.gdx.fireapp.GdxFIRDatabase;
//import pl.mk5.gdx.fireapp.functional.Consumer;

public class Multiplayer {
    public ArrayList<MessageC> players;
    DatabaseHelper databaseHelper;
    String valueOf_online;
    static GetterANDSetterFileC gs;
    public static ArrayList<String> meta_players;
    public static ArrayList<Player> real_players;
    public Circle bounds, bulletBounds;
    static ArrayList<Elbrium> ore;
    private PlayerAction playerAction;
    private ArrayList<BulletMessage> bullets;
    Gson gson;


    public Multiplayer(){
        meta_players=new ArrayList<>();
        real_players=new ArrayList<>();
        databaseHelper=new DatabaseHelper();
        players=new ArrayList<>();
        bullets=new ArrayList<>();
        gs=new GetterANDSetterFileC();
        gson=new Gson();
        ore=new ArrayList<>();
        playerAction=new PlayerAction();
        bounds = new Circle(new Point2D(0,0),GameSc.player.R);
        bulletBounds=new Circle(new Point2D(0,0),GameSc.player.R/5);
        startListener();
    }



    public boolean isSomeoneIN(){
        return !players.isEmpty();
    }

    public Point2D getCoords(String ref){
        if(meta_players.contains(ref)){
            //Gdx.app.debug("MP","index of "+ref+": "+players.get(meta_players.indexOf(ref)));
            return new Point2D(players.get(meta_players.indexOf(ref)).x,players.get(meta_players.indexOf(ref)).y);}
        return new Point2D(-300,-300);
    }

    public Circle getBounds(){
        return bounds;
    }

    public void update(){

    }

    public void draw(SpriteBatch batch){
        for(MessageC m : players){

            bounds.pos.setPoint(m.x-GameSc.player.R,m.y-GameSc.player.R);
            batch.draw(Main.getPlayer(m.texture),bounds.pos.getX()-GameSc.player.R,bounds.pos.getY()-GameSc.player.R, GameSc.player.R*2,2*GameSc.player.R);

        }
        for(BulletMessage bm : bullets){
            bulletBounds.pos.setPoint(bm.x,bm.y);
            batch.draw(Main.bullet,bm.x-GameSc.player.R/5,bm.y-GameSc.player.R/5,GameSc.player.R/5*2,GameSc.player.R/5*2);
        }
    }

    public ArrayList<MessageC> getPlayers(){
        return players;
    }

    private void startListener(){
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tmp(String.valueOf(dataSnapshot.getValue(String.class)));                                       //Maybe this do not working
                //Post post = dataSnapshot.getValue(Post.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        };
        FirebaseDatabase.getInstance().getReference("LibGDX").child("online").addValueEventListener(postListener);
        //-------------------------------------

//        GdxFIRDatabase.instance().inReference("online").onDataChange(String.class).thenListener(new Consumer<String>() {                        //onDataChange!!!!
//            @Override
//            public void accept(String s) {
//                tmp(s);
//            }
//        });
    }

    private void tmp(String s){
        valueOf_online=s;
        if(!s.replace(gs.get_Nickname(),"").equals("")){
        meta_players.clear();
        players.clear();
        meta_players.addAll(Arrays.asList(valueOf_online.split(";")));

        FirebaseDatabase.getInstance().getReference("LibGDX").child("Spawner").setValue(meta_players.get(0));
        //GdxFIRDatabase.inst().inReference("Spawner").setValue(meta_players.get(0));                                                             //Ставит значение
        playerAction.update(meta_players.get(0).equals(gs.get_Nickname()));
        meta_players.remove(gs.get_Nickname());


        for(String ref : meta_players){createPlayers(ref);createBullets(ref);}

        }

    }

    private void createPlayers(final String ref){
//        ValueEventListener postListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                tmp2(ref,String.valueOf(dataSnapshot.getValue(String.class)));                                       //Maybe this do not working
//                //Log.d("QQQQQ-Multi-createPlay",String.valueOf(dataSnapshot.getValue(String.class)));
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {}
//        };
//        FirebaseDatabase.getInstance().getReference("LibGDX").child(ref).addValueEventListener(postListener);
        //-------------------------------

//        GdxFIRDatabase.instance().inReference(ref).onDataChange(String.class).thenListener(new Consumer<String>() {                                 //onDataChange!!!!!!
//            @Override
//            public void accept(String s) {
//                  tmp2(ref,s);
//            }
//        });
    }

    private void tmp2(String ref,String s){
        boolean flag=false;
        for(MessageC m : players){
            if (m.nick.equals(ref)) {
                flag = true;
                m.x=gson.fromJson("{"+s,MessageC.class).x;
                m.y=gson.fromJson("{"+s,MessageC.class).y;
                break;
            }
        }
        if(!flag)players.add(gson.fromJson("{"+s,MessageC.class));

    }

    public static boolean condition_spawnerOnDisconnect(){
        if(Main.gameSc!=null)
            return meta_players.isEmpty();
        else return false;
    }

    private void createBullets(final String ref){
        for(int i=0;i<25;i++){
//            ValueEventListener postListener = new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                                                           //Maybe this do not working
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError error) {}
//            };
//            FirebaseDatabase.getInstance().getReference("LibGDX").child("bullet_"+ref+i).addValueEventListener(postListener);


//            GdxFIRDatabase.inst().inReference("bullet_"+ref+i).onDataChange(String.class).thenListener(new Consumer<String>() {                 //onDataChange!!!!
//                @Override
//                public void accept(String s) {
//                    //if(s!=null)tmp3(ref,s);
//                }
//            });
        }
    }

    private void tmp3(String ref, String s){
        boolean flag=false;
        for(BulletMessage bm : bullets){
            if (bm.nick.equals(ref)) {
                flag = true;
                break;
            }
        }
    }
}
