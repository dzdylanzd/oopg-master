package schaakSpel;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.sound.Sound;

public class Pion extends schaakstuk {
	
		private boolean verplaatst = false;	

	public Pion(schaakSpel world,String text, Sound pickupSound, Sound putdownSound) {
		super(new Sprite("src/main/java/schaakSpel/media/" + text + "Pawn.png"),pickupSound,putdownSound);
		ZofW = text;
		this.world = world;
		
	}
	


	
	@Override
	protected void maakPlekken() {
		float x = getX()-15;
		float y = getY()-15;
		int realX = (int) getX();
		int realY = (int) getY();
		int tileSize = 80;
		
		mogenlijkePlek plekZelf = new mogenlijkePlek(world);
		plekken.add(plekZelf);	
		world.addGameObject(plekZelf,x,y);
		
		if(ZofW == schaakstuk.WIT) {
		if(!verplaatst) {
			if(x < 800-tileSize && x > tileSize && y+tileSize*-2 < 800-tileSize && y+tileSize*-2 > tileSize  ) {
		mogenlijkePlek plek = new mogenlijkePlek(world);
		plekken.add(plek);	
		world.addGameObject(plek,x,y+tileSize*-2);
		verplaatst = true;
			}
		} else if(verplaatst) {
			if(x < 800-tileSize && x > tileSize && y+tileSize*-1 < 800-tileSize && y+tileSize*-1 > tileSize && !schaakbord.IsHierSchaakstuk(realX,realY-tileSize) ) {
		mogenlijkePlek plek = new mogenlijkePlek(world);
		plekken.add(plek);	
		world.addGameObject(plek,x,y+tileSize*-1);
			}
		}
		if(schaakbord.IsHierSchaakstuk(realX-tileSize,realY-tileSize)&& ZofW != schaakbord.WelkeKleur(realX-tileSize,realY-tileSize)){
			mogenlijkePlek plek = new mogenlijkePlek(world);
			plekken.add(plek);	
			world.addGameObject(plek,x-tileSize,y-tileSize);
		}
		if(schaakbord.IsHierSchaakstuk(realX+tileSize,realY-tileSize) && ZofW != schaakbord.WelkeKleur(realX+tileSize,realY-tileSize)){
			mogenlijkePlek plek = new mogenlijkePlek(world);
			plekken.add(plek);	
			world.addGameObject(plek,x+tileSize,y-tileSize);
		}
		}
		else if(ZofW == schaakstuk.ZWART) {
			if(!verplaatst) {
				if(x < 800-tileSize && x > tileSize && y+tileSize*2 < 800-tileSize && y+tileSize*2 > tileSize  ) {
			mogenlijkePlek plek = new mogenlijkePlek(world);
			plekken.add(plek);	
			world.addGameObject(plek,x,y+tileSize*2);
			verplaatst = true;
				}
			} else if(verplaatst) {
				if(x < 800-tileSize && x > tileSize && y+tileSize*1 < 800-tileSize && y+tileSize*1 > tileSize && !schaakbord.IsHierSchaakstuk(realX,realY-tileSize)  ) {
			mogenlijkePlek plek = new mogenlijkePlek(world);
			plekken.add(plek);	
			world.addGameObject(plek,x,y+tileSize*1);
				}
			}
			if(schaakbord.IsHierSchaakstuk(realX-tileSize,realY+tileSize) && ZofW != schaakbord.WelkeKleur(realX-tileSize,realY+tileSize)){
				mogenlijkePlek plek = new mogenlijkePlek(world);
				plekken.add(plek);	
				world.addGameObject(plek,x-tileSize,y+tileSize);
			}
			if(schaakbord.IsHierSchaakstuk(realX+tileSize,realY+tileSize)  && ZofW != schaakbord.WelkeKleur(realX+tileSize,realY+tileSize)){
				mogenlijkePlek plek = new mogenlijkePlek(world);
				plekken.add(plek);	
				world.addGameObject(plek,x+tileSize,y+tileSize);
			}
			}

	}

}
