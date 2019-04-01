package schaakSpel;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.sound.Sound;


public class Koning extends schaakstuk {
	private Sound gewonnenSound;
	public Koning(schaakSpel world,String text, Sound pickupSound, Sound putdownSound, Sound gewonnenSound) {
		super(new Sprite("src/main/java/schaakSpel/media/" + text + "King.png"),pickupSound,putdownSound);
		this.gewonnenSound=gewonnenSound;
		this.world = world;
		ZofW = text;
	}

	@Override
	protected void maakPlekken() {
		float x = getX()-15;
		float y = getY()-15;
		float tileSize = 80;
		float X[] = {-1,1,0,0,-1,1,1,-1};
		float Y[] = {0,0,-1,1,-1,1,-1,1};
		
		
		mogenlijkePlek plekZelf = new mogenlijkePlek(world);
		plekken.add(plekZelf);	
		world.addGameObject(plekZelf,x,y);
		
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
	@Override
	public void keyPressed(int keyCode, char key) {
		
		if(selected==true) {
		if(key=='d') {
	    gewonnenSound.rewind();	
		gewonnenSound.play();	
		world.deleteGameObject(this);
		schaakbord.restart();
		System.out.print(ZofW);
		System.out.println(" heeft gewonnen");
		
		for(mogenlijkePlek plek: plekken ) {
			world.deleteGameObject(plek);
		}
	}
	}
		if(key=='o') {
			cheater = true;	
			}
	}
}
