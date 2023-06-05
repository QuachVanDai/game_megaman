package gameObject;

public abstract class gameObject {
	private float posX;
	private float posY;
	private gameWorld g_world;
	
	public abstract void update();
	public gameObject(float posX, float posY, gameWorld g_world) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.g_world = g_world;
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
	public gameWorld getG_world() {
		return g_world;
	}
	public void setG_world(gameWorld g_world) {
		this.g_world = g_world;
	}
	
	
}
