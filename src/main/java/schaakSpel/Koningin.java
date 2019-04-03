package schaakSpel;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.sound.Sound;

public class Koningin extends schaakstuk {	

	/** de constructor van koningin
	 * @param world geeft de main methode mee
	 * @param text geeft de kleur mee
	 * @param pickupSound geeft het pickupSound mee 
	 * @param putdownSound geeft het pickdownSound mee
	 */
	public Koningin(schaakSpel world,String text, Sound pickupSound, Sound putdownSound) {
		super(new Sprite("src/main/java/schaakSpel/media/" + text + "Queen.png"),pickupSound,putdownSound);
		this.world = world;
		ZofW = text;
		
	}

	/** hiermee maken we de sugestie velden van koningin
	 * @see schaakSpel.schaakstuk#maakPlekken()
	 */
	@Override
	protected void maakPlekken() {
		float x = getX()-15;
		float y = getY()-15;
		float tileSize = 80;
		int mapSize = 800;
		int directionX[] = {-1,1,0,0,-1,1,-1,1};
		int directionY[] = {0,0,1,-1,-1,-1,1,1};
		
		mogenlijkePlek plekZelf = new mogenlijkePlek(world);
		plekken.add(plekZelf);	
		world.addGameObject(plekZelf,x,y);
		
		for(int j=0;j<directionX.length;j++) {
		for(int i=1; i < 8; i++) {
			int directionX1 = directionX[j]*i;
			int directionY1 = directionY[j]*i;
			int intx = (int) (getX() + tileSize*directionX1) ;
			int inty = (int) (getY() + tileSize*directionY1);
			if(x+tileSize*directionX1 < mapSize-tileSize && x+tileSize*directionX1 > tileSize && y+tileSize*directionY1 < 800-tileSize && y+tileSize*directionY1 > tileSize && ZofW != schaakbord.WelkeKleur(intx,inty)  ) {
					
				
		mogenlijkePlek plek = new mogenlijkePlek(world);
		plekken.add(plek);	
		world.addGameObject(plek,x+tileSize*directionX1,y+tileSize*directionY1);
				
		
		
			}
			if(schaakbord.IsHierSchaakstuk(intx,inty)){
				i = 8;
				
			}
		}
		}
		
	}

	
}
