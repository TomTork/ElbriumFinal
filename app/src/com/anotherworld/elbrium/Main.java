package com.anotherworld.elbrium;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.LifecycleListener;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


//import Online.Getter;
//import pl.mk5.gdx.fireapp.GdxFIRApp;
//import pl.mk5.gdx.fireapp.GdxFIRDatabase;


public class Main extends Game {
	public static SpriteBatch batch,frontBatch,
			playerBatch, hudBatch,
			baseBatch,baseBatchBackground;

	public static int WIDTH,HEIGHT;
	public static int BACKGROUND_WIDTH;
	public static int BACKGROUND_HEIGHT;

	public static Texture circle,stickImg,background,actor,damaged_txr,elbrium,elbriumCrash;
	public static Texture img;
	public static Texture err;
	public static Texture ore1,ore2,ore3,ore4,ore5;
	public static Texture player1, player2, player3, player4, player5;
	public static Texture chat_button,chat_button_un;
	public static Texture comet_fr1,comet_fr2,comet_fr3;
	public static Texture bullet,base;
	public static Texture back_button_un, back_button;
	public static Texture square1,square2;
	public static Texture debugBG;
	public static Texture un_testButtonTX,p_testButtonTX;
	public static Texture bLeft,bUp,bRight,bDown;
	public static Texture bLeft_un,bUp_un,bRight_un,bDown_un;

	public static GameSc gameSc;
	public static GetterANDSetterFileC getter_setter;
	Multiplayer mp;

	@Override
	public void create () {
		//GdxFIRApp.inst().configure();																//? Не понятно зачем это было сделано, вероятно это нужно при первом запуске
		loadBatches();
		WIDTH= Gdx.graphics.getWidth();
		HEIGHT=Gdx.graphics.getHeight();

		baseBatch = new SpriteBatch();
		baseBatchBackground = new SpriteBatch();

		base = new Texture("base.png");
		err=new Texture("error.png");

		square1 = new Texture("square1.png");
		square2 = new Texture("square2.png");

		debugBG=new Texture("dbg.png");
		circle=new Texture("circle.png");
		stickImg=new Texture("stick.png");
		actor=new Texture("actor.png");
		background=new Texture("haha.png");

		// 5000x5000
		BACKGROUND_WIDTH=background.getWidth();
		BACKGROUND_HEIGHT=background.getHeight();

		damaged_txr=new Texture("dameged_txr_elbrium.png");
		un_testButtonTX=new Texture("test_button_un_pressed.png");
		p_testButtonTX=new Texture("test_button_pressed.png");
		//deathScdeathSc=new Texture("deathSc.jpg");
		elbrium=new Texture("ore.png");
		getter_setter=new GetterANDSetterFileC();
		loadElbriumTextures();
		loadPlayerTextures();
		loadButtonTextures();
		loadCometTextures();

		gameSc=new GameSc(this);
		monitoring();
		setScreen(gameSc);
	}


	@Override
	public void dispose () {
		//batch.dispose();
		frontBatch.dispose();
		//playerBatch.dispose();
		circle.dispose();
		stickImg.dispose();
		actor.dispose();
		background.dispose();
		un_testButtonTX.dispose();
		p_testButtonTX.dispose();
	}

	// monitoring() - для удобства

	public void monitoring(){
		Gdx.app.addLifecycleListener(new LifecycleListener() {
			@Override
			public void pause() {
				//GameSc.player.stopAfkTimer();
			}

			@Override
			public void resume() {
				//GameSc.player.timeCheck();
			}

			@Override
			public void dispose() {
				//db.logOut();
			}
		});
	}

	private void loadBatches(){
		batch=new SpriteBatch();
		frontBatch=new SpriteBatch();
		playerBatch=new SpriteBatch();
		hudBatch=new SpriteBatch();
	}

	private void loadElbriumTextures(){
		ore1=new Texture(Gdx.files.internal("elbrium/ore1.png"));
		ore2=new Texture(Gdx.files.internal("elbrium/ore2.png"));
		ore3=new Texture(Gdx.files.internal("elbrium/ore3.png"));
		ore4=new Texture(Gdx.files.internal("elbrium/ore4.png"));
		ore5=new Texture(Gdx.files.internal("elbrium/ore5.png"));
		elbriumCrash=new Texture("elbrium/orecrash.png");
	}

	private void loadPlayerTextures(){
		bullet=new Texture("bullet.png");
		player1=new Texture("players/player1.png");
		player2=new Texture("players/player2.png");
		player3=new Texture("players/player3.png");
		player4=new Texture("players/player4.png");
		player5=new Texture("players/player5.png");
	}

	private void loadButtonTextures(){
		chat_button = new Texture("buttons/chatb/chatb.png");
		chat_button_un=new Texture("buttons/chatb/chatbun.png");

		back_button=new Texture("buttons/backb/backbutton.png");
		back_button_un=new Texture("buttons/backb/backbuttonun.png");

		bLeft_un=new Texture("buttons/arrowsb/bleftun.png");
		bUp_un=new Texture("buttons/arrowsb/bupun.png");
		bRight_un=new Texture("buttons/arrowsb/brightun.png");
		bDown_un=new Texture("buttons/arrowsb/bdownun.png");

		bLeft=new Texture("buttons/arrowsb/bleft.png");
		bUp=new Texture("buttons/arrowsb/bup.png");
		bRight=new Texture("buttons/arrowsb/bright.png");
		bDown=new Texture("buttons/arrowsb/bdown.png");
	}

	private void loadCometTextures(){
		comet_fr1=new Texture("cometa/frame1.png");
		comet_fr2=new Texture("cometa/frame2.png");
		comet_fr3=new Texture("cometa/frame3.png");
	}

	public static Texture getPlayer(){
		GetterANDSetterFileC getter_setter = new GetterANDSetterFileC();

		if(getter_setter.get_Appearance()<1||getter_setter.get_Appearance()>5)
			getter_setter.set_Appearance(1);

		switch (getter_setter.get_Appearance()){
			case 1: return player1;
			case 2: return player2;
			case 3: return player3;
			case 4: return player4;
			case 5: return player5;
		}
		return player1;
	}

	public static Texture getPlayer(String s){

		switch (Integer.parseInt(s)){
			case 1: return player1;
			case 2: return player2;
			case 3: return player3;
			case 4: return player4;
			case 5: return player5;
		}
		return player1;
	}

}
