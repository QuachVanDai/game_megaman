package gameObject;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import effect.animation;
import effect.cacheDataLoader;


public class blueFire  extends bullet{
	
    private animation forwardBulletAnim, backBulletAnim;
    
    public blueFire(float x, float y, gameWorld gameWorld) {
        super(x, y, 60, 30, 1.0f, 10, gameWorld);
        forwardBulletAnim = cacheDataLoader.getInstance().getAnimation("bluefire");
        backBulletAnim =    cacheDataLoader.getInstance().getAnimation("bluefire");
        backBulletAnim.flipAllImage();
    }

    
    
    @Override
    public Rectangle getBoundForCollisionWithEnemy() {
        // TODO Auto-generated method stub
        return getBoundForCollisionWithMap();
    }

    @Override
    public void draw(Graphics2D g2) {
            // TODO Auto-generated method stub
        if(getSpeedX() > 0){
            if(!forwardBulletAnim.isIgnoreFrame(0) && forwardBulletAnim.getCurrentFrame() == 3){
                forwardBulletAnim.setIgnoreFrame(0);
                forwardBulletAnim.setIgnoreFrame(1);
                forwardBulletAnim.setIgnoreFrame(2);
            }
                
            forwardBulletAnim.Update(System.nanoTime());
            forwardBulletAnim.draw((int) (getPosX() - getG_world().camera.getPosX()), (int) getPosY() - (int) getG_world().camera.getPosY(), g2);
        }else{
            if(!backBulletAnim.isIgnoreFrame(0) && backBulletAnim.getCurrentFrame() == 3){
                backBulletAnim.setIgnoreFrame(0);
                backBulletAnim.setIgnoreFrame(1);
                backBulletAnim.setIgnoreFrame(2);
            }
            backBulletAnim.Update(System.nanoTime());
            backBulletAnim.draw((int) (getPosX() - getG_world().camera.getPosX()), (int) getPosY() - (int) getG_world().camera.getPosY(), g2);
        }
        //drawBoundForCollisionWithEnemy(g2);
    }

    @Override
    public void update() {
            // TODO Auto-generated method stub
        if(forwardBulletAnim.isIgnoreFrame(0) || backBulletAnim.isIgnoreFrame(0))
            setPosX(getPosX() + getSpeedX());
//        particularObject object = getG_world().particularObjectManager.getCollisionWidthEnemyObject(this);
//        if(object!=null && object.getState() == ALIVE){
//            setBlood(0);
//            object.setBlood(object.getBlood() - getDamage());
//            object.setState(BEHURT);
//            System.out.println("Bullet set behurt for enemy");
//        }
    }

    @Override
    public void attack() {}

}
