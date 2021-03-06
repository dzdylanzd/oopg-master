package schaakSpel;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.sound.Sound;

public class Paard extends schaakstuk {	
	
	/** de constructor van Paard
	 * @param world geeft de main methode mee
	 * @param text geeft de kleur mee
	 * @param pickupSound geeft het pickupSound mee 
	 * @param putdownSound geeft het pickdownSound mee
	 */
	public Paard(schaakSpel world,String text, Sound pickupSound, Sound putdownSound) {
		super(new Sprite("src/main/java/schaakSpel/media/" + text + "Knight.png"),pickupSound,putdownSound);
		this.world = world;		
		ZofW = text;
	}
	
	
	
	/** hiermee maken we de suggestie velden van het Paard
	 * @see schaakSpel.schaakstuk#maakPlekken()
	 */
	@Override
	protected void maakPlekken() {
		float x = getX()-15;
		float y = getY()-15;
		float tileSize = 80;
		float X[] = {-2,-2,-1,1,2,2,-1,1};
		float Y[] = {-1,1,2,2,-1,1,-2,-2};
		
		mogenlijkePlek plekZelf = new mogenlijkePlek(world);
		plekken.add(plekZelf);	
		world.addGameObject(plekZelf,x,y);
		
		for(int i=0; i < X.length; i++) {
			int intx = (int) (getX() + tileSize*X[i]) ;
			int inty = (int) (getY() + tileSize*Y[i]);
			if(x+tileSize*X[i] < 800-tileSize && x+tileSize*X[i] > tileSize && y+tileSize*Y[i] < 800-tileSize && y+tileSize*Y[i] > tileSize && ZofW != schaakbord.WelkeKleur(intx,inty)  ) {
		mogenlijkePlek plek = new mogenlijkePlek(world);
		plekken.add(plek);	
		world.addGameObject(plek,x+tileSize*X[i],y+tileSize*Y[i]);
			}
		}
	}
	

}
