package gameObject;

import java.awt.Graphics2D;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class particularObjectManager {
	 protected List<particularObject> particularObjects;

	    private gameWorld gameWorld;
	    
	    public particularObjectManager(gameWorld gameWorld){
	        
	        particularObjects = Collections.synchronizedList(new LinkedList<particularObject>());
	        this.gameWorld = gameWorld;
	        
	    }
	    
	    public gameWorld  getGameWorld(){
	        return gameWorld;
	    }
	    
	    public void addObject(particularObject particularObject){
	        
	        
	        synchronized(particularObjects){
	            particularObjects.add(particularObject);
	        }
	        
	    }
	    
	    public void RemoveObject(particularObject particularObject){
	        synchronized(particularObjects){
	        
	            for(int id = 0; id < particularObjects.size(); id++){
	                
	                particularObject object = particularObjects.get(id);
	                if(object == particularObject)
	                    particularObjects.remove(id);

	            }
	        }
	    }
	    
	    public particularObject getCollisionWidthEnemyObject(particularObject object){
	        synchronized(particularObjects){
	            for(int id = 0; id < particularObjects.size(); id++){
	                
	                particularObject objectInList = particularObjects.get(id);

	                if(object.getTeamType() != objectInList.getTeamType() && 
	                        object.getBoundForCollisionWithEnemy().intersects(objectInList.getBoundForCollisionWithEnemy())){
	                    return objectInList;
	                }
	            }
	        }
	        return null;
	    }
	    
	    public void UpdateObjects(){
	        
	        synchronized(particularObjects){
	            for(int id = 0; id < particularObjects.size(); id++){
	                
	                particularObject object = particularObjects.get(id);
	                
	                
	                if(!object.isObjectOutOfCameraView()) object.update();
	                
	                if(object.getState() == particularObject.DEATH){
	                    particularObjects.remove(id);
	                }
	            }
	        }

	        //System.out.println("Camerawidth  = "+camera.getWidth());
	        
	    }
	    
	    public void draw(Graphics2D g2){
	        synchronized(particularObjects){
	            for(particularObject object: particularObjects)
	                if(!object.isObjectOutOfCameraView()) object.draw(g2);
	        }
	    }
		
}
