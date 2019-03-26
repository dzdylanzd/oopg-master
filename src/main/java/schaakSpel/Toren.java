package schaakSpel;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.sound.Sound;

public class Toren extends schaakstuk {

	public Toren(schaakSpel world,String text, Sound pickupSound, Sound putdownSound) {
		super(new Sprite("src/main/java/schaakSpel/media/" + text + "Rook.png"),pickupSound,putdownSound);
		this.world = world;
	}

	@Override
	protected void maakPlekken() {
		float x = getX()-15;
		float y = getY()-15;
		float tileSize = 80;
		float X[] = {-1,-2,-3,-4,-5,-6,-7,1,2,3,4,5,6,7,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		float Y[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,-2,-3,-4,-5,-6,-7,1,2,3,4,5,6,7};
		
		for(int i=0; i < X.length; i++) {
			if(x+tileSize*X[i] < 800-tileSize && x+tileSize*X[i] > tileSize && y+tileSize*Y[i] < 800-tileSize && y+tileSize*Y[i] > tileSize  ) {
		mogenlijkePlek plek = new mogenlijkePlek(world);
		plekken.add(plek);	
		world.addGameObject(plek,x+tileSize*X[i],y+tileSize*Y[i]);
			}
		}
	}

	
}
