package schaakSpel;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.sound.Sound;


public class Koning extends schaakstuk {
	
	public Koning(schaakSpel world,String text, Sound pickupSound, Sound putdownSound) {
		super(new Sprite("src/main/java/schaakSpel/media/" + text + "King.png"),pickupSound,putdownSound);
		this.world = world;
		ZofW = text;
	}

	@Override
	protected void maakPlekken() {
		float x = getX()-15;
		float y = getY()-15;
		float tileSize = 80;
		float X[] = {-1,1,0,0};
		float Y[] = {0,0,-1,1};
		
		for(int i=0; i < X.length; i++) {
			int intx = (int) (getX() + tileSize*X[i]) ;
			int inty = (int) (getY() + tileSize*Y[i]);
			if(x+tileSize*X[i] < 800-tileSize && x+tileSize*X[i] > tileSize && y+tileSize*Y[i] < 800-tileSize && y+tileSize*Y[i] > tileSize  && ZofW != schaakbord.WelkeKleur(intx,inty)  ) {
		mogenlijkePlek plek = new mogenlijkePlek(world);
		plekken.add(plek);	
		world.addGameObject(plek,x+tileSize*X[i],y+tileSize*Y[i]);
			}
		}
	}
	
	
}
