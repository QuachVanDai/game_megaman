package gameObject;

import java.awt.Rectangle;

public abstract class human extends particularObject {

	private boolean isJumping;
	private boolean isDicking;

	private boolean isLanding;

	public human(float x, float y, float width, float height, float mass, int blood, gameWorld gameWorld) {
		super(x, y, width, height, mass, blood, gameWorld);
		setState(ALIVE);
	}

	public abstract void run();

	public abstract void jump();

	public abstract void dick();

	public abstract void standUp();

	public abstract void stopRun();

	public boolean getIsJumping() {
		return isJumping;
	}

	public void setIsLanding(boolean b) {
		isLanding = b;
	}

	public boolean getIsLanding() {
		return isLanding;
	}

	public void setIsJumping(boolean isJumping) {
		this.isJumping = isJumping;
	}

	public boolean getIsDicking() {
		return isDicking;
	}

	public void setIsDicking(boolean isDicking) {
		this.isDicking = isDicking;
	}

	@Override
	public void update() {

		super.update();

		if (getState() == ALIVE || getState() == NOBEHURT) {

			if (!isLanding) {

				setPosX(getPosX() + getSpeedX());
				
				  if(getDirection() == LEFT_DIR &&
				  getG_world().phy.haveCollisionWithLeftWall(
				  getBoundForCollisionWithMap())!=null){
				  
				  Rectangle rectLeftWall =
						  getG_world().phy.haveCollisionWithLeftWall(
				  getBoundForCollisionWithMap()); setPosX(rectLeftWall.x + rectLeftWall.width +
				  getWidth()/2);
				  
				  } if(getDirection() == RIGHT_DIR &&
						  getG_world().phy.haveCollisionWithRightWall(
				  getBoundForCollisionWithMap())!=null){
				  
				  Rectangle rectRightWall =
				  getG_world().phy.haveCollisionWithRightWall(
				  getBoundForCollisionWithMap()); setPosX(rectRightWall.x - getWidth()/2);
				  
				  }
				 

				/**
				 * Codes below check the posY of megaMan
				 */
				// plus (+2) because we must check below the character when he's speedY = 0

				Rectangle boundForCollisionWithMapFuture = getBoundForCollisionWithMap();
				boundForCollisionWithMapFuture.y += (getSpeedY() != 0 ? getSpeedY() : 2);
				 Rectangle rectLand =
				 getG_world().phy.haveCollisionWithLand(boundForCollisionWithMapFuture);

                Rectangle rectTop = getG_world().phy.haveCollisionWithTop(boundForCollisionWithMapFuture);
               
                if(rectTop !=null){
                    
                    setSpeedY(0);
                    setPosY(rectTop.y + getG_world().phy.getTileSize() + getHeight()/2);
                    
                }else if(rectLand != null){
                    setIsJumping(false);
                    if(getSpeedY() > 0) setIsLanding(true);
                    setSpeedY(0);
                    setPosY(rectLand.y - getHeight()/2 - 1);
                }else{
                    setIsJumping(true);
                    setSpeedY(getSpeedY() + getMass());
                    setPosY(getPosY() + getSpeedY());
                }
			}
		}
	}
}
