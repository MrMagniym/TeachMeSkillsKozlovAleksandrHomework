package Lessons.Lesson8;

import java.io.Serializable;

public class Stats implements Serializable {

    public int hp;
    public int damage;

    public Stats(int hp, int damage){
        this.hp = hp;
        this.damage = damage;
    }

}
