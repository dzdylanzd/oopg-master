package schaakSpel;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.sound.Sound;

public class Pion extends schaakstuk {
	
	private String ZW;
	private boolean verplaatst = false;	

	public Pion(schaakSpel world,String text, Sound pickupSound, Sound putdownSound) {
		super(new Sprite("src/main/java/schaakSpel/media/" + text + "Pawn.png"),pickupSound,putdownSound);
		this.ZW = text;
		this.world = world;
	}
	


	
	@Override
	protected void maakPlekken() {
		float x = getX()-15;
		float y = getY()-15;
		float tileSize = 80;
		
		if(ZW == schaakstuk.WIT) {
		if(!verplaatst) {
			if(x < 800-tileSize && x > tileSize && y+tileSize*-2 < 800-tileSize && y+tileSize*-2 > tileSize  ) {
		mogenlijkePlek plek = new mogenlijkePlek(world);
		plekken.add(plek);	
		world.addGameObject(plek,x,y+tileSize*-2);
		verplaatst = true;
			}
		} else if(verplaatst) {
			if(x < 800-tileSize && x > tileSize && y+tileSize*-1 < 800-tileSize && y+tileSize*-1 > tileSize  ) {
		mogenlijkePlek plek = new mogenlijkePlek(world);
		plekken.add(plek);	
		world.addGameObject(plek,x,y+tileSize*-1);
			}
		}
		}
		else if(ZW == schaakstuk.ZWART) {
			if(!verplaatst) {
				if(x < 800-tileSize && x > tileSize && y+tileSize*2 < 800-tileSize && y+tileSize*2 > tileSize  ) {
			mogenlijkePlek plek = new mogenlijkePlek(world);
			plekken.add(plek);	
			world.addGameObject(plek,x,y+tileSize*2);
			verplaatst = true;
				}
			} else if(verplaatst) {
				if(x < 800-tileSize && x > tileSize && y+tileSize*1 < 800-tileSize && y+tileSize*1 > tileSize  ) {
			mogenlijkePlek plek = new mogenlijkePlek(world);
			plekken.add(plek);	
			world.addGameObject(plek,x,y+tileSize*1);
				}
			}
			}

	}

}
