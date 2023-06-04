package gameObject;

import java.awt.Color;
import java.awt.Graphics2D;

public class megaman {
	private float posX;
	private float posY;
	private float width;
	private float hight;
	private float mass;
	private float speedX;
	private float speedY;
	private int direction;
	
	public static int dir_Left;
	public static int dir_Right;

	
	
	public megaman(float posX, float posY, float width, float hight, float mass) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.hight = hight;
		this.mass = mass;
	}
	public void update()
	{
		setPosX(getPosX() + speedX);
	}
	public void draw(Graphics2D g) {
		g.setColor(Color.white);
		g.fillRect((int )posX, (int )posY,(int )width,(int )hight);
	}
	public float getSpeedX() {
		return speedX;
	}

	public void setSpeedX(float speedX) {
		this.speedX = speedX;
	}

	public float getSpeedY() {
		return speedY;
	}

	public void setSpeedY(float speedY) {
		this.speedY = speedY;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public float getPosX() {
		return posX;
	}
	public void setPosX(float posX) {
		this.posX = posX;
	}
	public float getPosY() {
		return posY;
	}
	public void setPosY(float posY) {
		this.posY = posY;
	}
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	public float getHight() {
		return hight;
	}
	public void setHight(float hight) {
		this.hight = hight;
	}
	public float getMass() {
		return mass;
	}
	public void setMass(float mass) {
		this.mass = mass;
	}
	
	
}
