package schaakSpel;

import java.util.ArrayList;
import Pion;

public class schaakbord {
	
	private int tileLength = 80;
	
	ArrayList<schaakstuk> schaakstukken = new ArrayList<schaakstuk>();
	private schaakSpel world;
	
	schaakbord(schaakSpel world){
		
		this.world = world;
		
	}
	
	public void startGame() {
		pionnen();
		 torens();
		 paarden();
		 lopers();
		 koningEnKonining();
		
	}
	
	public void pionnen() {
		for(int i=0; i<8; i++) {
			schaakstuk pion = new Pion(world,schaakstuk.ZWART);
			schaakstukken.add(pion);
	        world.addGameObject(pion, tileLength*(i+1), 2*tileLength);
		}
		for(int i=0; i<8; i++) {
			schaakstuk pion = new Pion(world,schaakstuk.WIT);
			schaakstukken.add(pion);
	        world.addGameObject(pion, tileLength*(i+1), 7*tileLength);
		}
	}
	
	public void torens() {
		schaakstuk torenL = new Toren(world,schaakstuk.ZWART);
		schaakstukken.add(torenL);
		world.addGameObject(torenL, tileLength*1, 1*tileLength);
		schaakstuk torenR = new Toren(world,schaakstuk.ZWART);
		schaakstukken.add(torenR);
		world.addGameObject(torenR, tileLength*8, 1*tileLength);
		torenL = new Toren(world,schaakstuk.WIT);
		schaakstukken.add(torenL);
		world.addGameObject(torenL, tileLength*1, 8*tileLength);
	 torenR = new Toren(world,schaakstuk.WIT);
		schaakstukken.add(torenR);
		world.addGameObject(torenR, tileLength*8, 8*tileLength);
	}
	
	public void paarden() {
		schaakstuk paardL = new Paard(world,schaakstuk.ZWART);
		schaakstukken.add(paardL);
		world.addGameObject(paardL, tileLength*2, 1*tileLength);
		schaakstuk paardR = new Paard(world,schaakstuk.ZWART);
		schaakstukken.add(paardR);
		world.addGameObject(paardR, tileLength*7, 1*tileLength);
		paardL = new Paard(world,schaakstuk.WIT);
		schaakstukken.add(paardL);
		world.addGameObject(paardL, tileLength*2, 8*tileLength);
	 paardR = new Paard(world,schaakstuk.WIT);
		schaakstukken.add(paardR);
		world.addGameObject(paardR, tileLength*7, 8*tileLength);
	}
	
	public void lopers() {
		schaakstuk loperL = new Loper(world,schaakstuk.ZWART);
		schaakstukken.add(loperL);
		world.addGameObject(loperL, tileLength*3, 1*tileLength);
		schaakstuk loperR = new Loper(world,schaakstuk.ZWART);
		schaakstukken.add(loperR);
		world.addGameObject(loperR, tileLength*6, 1*tileLength);
		loperL = new Loper(world,schaakstuk.WIT);
		schaakstukken.add(loperL);
		world.addGameObject(loperL, tileLength*3, 8*tileLength);
	 loperR = new Loper(world,schaakstuk.WIT);
		schaakstukken.add(loperR);
		world.addGameObject(loperR, tileLength*6, 8*tileLength);
	}
	
	public void koningEnKonining() {
		schaakstuk koning = new Koning(world,schaakstuk.ZWART);
		schaakstukken.add(koning);
		world.addGameObject(koning, tileLength*5, 1*tileLength);
		schaakstuk koningin = new Koningin(world,schaakstuk.ZWART);
		schaakstukken.add(koningin);
		world.addGameObject(koningin, tileLength*4, 1*tileLength);
		koning = new Koning(world,schaakstuk.WIT);
		schaakstukken.add(koning);
		world.addGameObject(koning, tileLength*5, 8*tileLength);
		koningin = new Koningin(world,schaakstuk.WIT);
		schaakstukken.add(koningin);
		world.addGameObject(koningin, tileLength*4, 8*tileLength);
		
	}


}

