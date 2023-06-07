package gameObject;

import java.awt.Graphics2D;
public abstract class bullet extends particularObject {

    public bullet(float x, float y, float width, float height, float mass, int damage, gameWorld gameWorld) {
            super(x, y, width, height, mass, 1, gameWorld);
            setDamage(damage);
    }
    
    public abstract void draw(Graphics2D g2d);

    public void update(){
        super.update();
        setPosX(getPosX() + getSpeedX());
        setPosY(getPosY() + getSpeedY());
//       particularObject object = getG_world().particularObjectManager.getCollisionWidthEnemyObject(this);
//        if(object!=null && object.getState() == ALIVE){
//            setBlood(0);
//            object.beHurt(getDamage());
//            System.out.println("Bullet set behurt for enemy");
//        }
    }
}
