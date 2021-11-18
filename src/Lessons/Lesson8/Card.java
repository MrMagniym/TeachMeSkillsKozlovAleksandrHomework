package Lessons.Lesson8;

import java.io.Serializable;

public class Card implements Serializable {

    public String serializedObjectName;
    public String whyDoYouSerializeMe;
    public int hp;
    public int damage;

    public Card(String serializingObjectName, String whyDoYouSerializeMe, Stats stats){
        this.serializedObjectName = serializingObjectName;
        this.whyDoYouSerializeMe = whyDoYouSerializeMe;
        this.hp = stats.hp;
        this.damage = stats.damage;
    }

    public Card(){

    }

}
