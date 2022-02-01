package com.anotherworld.elbrium;

import com.badlogic.gdx.Gdx;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Spawner extends TimerTask {
    private int rank;
    private ElbriumMessage message;

    public Spawner() {
        // объект вызывается при условии spawner (см PlayerAction)
    }

    @Override
    public void run() {
        if (GameSc.ore.size < 15) spawnOre();
    }

    public void start() {
        TimerTask timerTask = new Spawner();
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 30 * 1000); // переодичность спавна Эльбриума - 30 секунд
    }

    private void spawnOre() {

        rank = +(int) (Math.random() * 3);
        Elbrium elbrium = new Elbrium(Main.actor, new Point2D((float) Math.random() * Main.BACKGROUND_WIDTH / 1.3f,
                (float) Math.random() * Main.BACKGROUND_HEIGHT / 1.3f), rank);
        GameSc.ore.add(elbrium);
    }

    public void setRank(int rank) {
        this.rank = rank;
    }


}
