package com.anotherworld.elbrium;

public class MessageC {



    public String texture;
    public float x;
    public float y;
    public double attack;
    public float health;
    public float protect;
    public String nick;

    public MessageC(String texture, float x, float y, double attack, float health, float protect, String nick) {

        // Message классы сделаны для передачи необходимых значений другим игрокам через бд

        this.texture = texture;
        this.x = x;
        this.y = y;
        this.attack = attack;
        this.health = health;
        this.protect = protect;
        this.nick=nick;
    }

    public void setAttack(float attack) {
        this.attack = attack;
    }

    public void setProtect(float protect) {
        this.protect = protect;
    }

    @Override
    public String toString() {
        /* в бд отправляется не объект, а следующая Json строка. библиотека gdx-fireapp (в отличии от самих строк) не принимает объекты, говоря, что
        их не существует. преобразуется через Gson */
        return
                "\"texture\":" + texture  + "," +
                "\"x\":" + x  + "," +
                "\"y\":" + y  + "," +
                "\"attack\":\"" + attack + "\"," +
                "\"health\":" + health  + "," +
                "\"protect\":" + protect  + "," +
                        "\"nick\":" + nick  +

                        "}";
    }
}
