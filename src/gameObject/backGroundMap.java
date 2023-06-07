package gameObject;

import java.awt.Color;
import java.awt.Graphics2D;

import effect.cacheDataLoader;
import user_interface.gameFrame;



public class backGroundMap extends gameObject {

    public int[][] map;
    private int tileSize;
    
    public backGroundMap(float x, float y, gameWorld gameWorld) {
        super(x, y, gameWorld);
        map = cacheDataLoader.getInstance().getBackgroundMap();
        tileSize = 30;
    }

    @Override
    public void update() {}
    
    public void draw(Graphics2D g2){
        
        camera camera = getG_world().camera;
        
        g2.setColor(Color.RED);
        for(int i = 0;i< map.length;i++)
            for(int j = 0;j<map[0].length;j++)
                if(map[i][j]!=0 && j*tileSize - camera.getPosX() > -30 && j*tileSize - camera.getPosX() < gameFrame.SCREEN_WIDTH
                        && i*tileSize - camera.getPosY() > -30 && i*tileSize - camera.getPosY() < gameFrame.SCREEN_HEIGHT){ 
                    g2.drawImage(cacheDataLoader.getInstance().getFrameImage("tiled"+map[i][j]).getImage(), (int) getPosX() + j*tileSize - (int) camera.getPosX(), 
                        (int) getPosY() + i*tileSize - (int) camera.getPosY(), null);
                }
        
    }

}
