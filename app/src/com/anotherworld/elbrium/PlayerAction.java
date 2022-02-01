package com.anotherworld.elbrium;



public class PlayerAction {
    // два условия
    /* 1 - spawner - игрок находится первым в поле "online" и создает руду, параметры которой обновляются в бд и заносятся в
    массив GameSc.ore (GameSc.spawnerLogic()) */
    // 2 - player - игрок не является первым, принимает координаты и передает объекты в массив GameSc.ore (GameSc.spawnerSniffer())
    public boolean first_in_list;
    private boolean point_of_no_return;
    private boolean sniffer_called;

    public PlayerAction() {
    }

    private void conditions() {
        if (first_in_list) {
            // spawner
            // точка невозврата - условие выполняется до выхода из игры
            point_of_no_return = true;
            GameSc.spawnerLogic();
        } else if (!sniffer_called){
            // player
            // может перейти в first_in_list
            sniffer_called=true;
           //GameSc.spawnerSniffer();
            GameSc.spawnerLogic();
        }
    }

    public void update(boolean first_in_list) {
        this.first_in_list = first_in_list;
        if (!point_of_no_return) conditions();
        GameSc.playerIsSpawner = first_in_list;
    }


}
