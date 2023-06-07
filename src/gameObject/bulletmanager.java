package gameObject;


public class bulletmanager extends particularObjectManager {

    public bulletmanager(gameWorld gameWorld) {
        super(gameWorld);
    }

    @Override
    public void UpdateObjects() {
        super.UpdateObjects(); 
        synchronized(particularObjects){
            for(int id = 0; id < particularObjects.size(); id++){
                
                particularObject object = particularObjects.get(id);
                
                if(object.isObjectOutOfCameraView() || object.getState() == particularObject.DEATH){
                    particularObjects.remove(id);
                    //System.out.println("Remove");
                }
            }
        }
    }
    

}
