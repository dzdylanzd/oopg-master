package schaakSpel;

import java.util.ArrayList;
import nl.han.ica.oopg.sound.Sound;

public class schaakbord  {	
	
	private static int tileLength = 80;	
	static ArrayList<schaakstuk> schaakstukken = new ArrayList<schaakstuk>();
	static ArrayList<Klok> Klokken = new ArrayList<Klok>();
	private static schaakSpel world;
	private static Sound pickupSound;
	private static Sound putdownSound;
	private static Sound gewonnenSound;
	
	public schaakbord(schaakSpel world, Sound pickupSound, Sound putdownSound, Sound gewonnenSound){
		this.pickupSound=pickupSound;
		this.putdownSound=putdownSound;
		this.gewonnenSound=gewonnenSound;
		this.world = world;		
	}
	
	public static void startGame() {
		lopers();
		pionnen();
		 torens();
		 paarden();
		 koningEnKonining();
		 klokken() ;

		
	}
	
	public static void restart() {
		
			world.deleteAllGameOBjects();
			startGame();
		
	}
	
	private static void pionnen() {
		for(int i=0; i<8; i++) {
			schaakstuk pion = new Pion(world,schaakstuk.ZWART,pickupSound,putdownSound);
			schaakstukken.add(pion);
	        world.addGameObject(pion, tileLength*(i+1), 2*tileLength);
		}
		for(int i=0; i<8; i++) {
			schaakstuk pion = new Pion(world,schaakstuk.WIT,pickupSound,putdownSound);
			schaakstukken.add(pion);
	        world.addGameObject(pion, tileLength*(i+1), 7*tileLength);
		}
	}
	
	private static void torens() {
		schaakstuk torenL = new Toren(world,schaakstuk.ZWART,pickupSound,putdownSound);
		schaakstukken.add(torenL);
		world.addGameObject(torenL, tileLength*1, 1*tileLength);
		schaakstuk torenR = new Toren(world,schaakstuk.ZWART,pickupSound,putdownSound);
		schaakstukken.add(torenR);
		world.addGameObject(torenR, tileLength*8, 1*tileLength);
		torenL = new Toren(world,schaakstuk.WIT,pickupSound,putdownSound);
		schaakstukken.add(torenL);
		world.addGameObject(torenL, tileLength*1, 8*tileLength);
	 torenR = new Toren(world,schaakstuk.WIT,pickupSound,putdownSound);
		schaakstukken.add(torenR);
		world.addGameObject(torenR, tileLength*8, 8*tileLength);
	}
	
	private static void paarden() {
		schaakstuk paardL = new Paard(world,schaakstuk.ZWART,pickupSound,putdownSound);
		schaakstukken.add(paardL);
		world.addGameObject(paardL, tileLength*2, 1*tileLength);
		schaakstuk paardR = new Paard(world,schaakstuk.ZWART,pickupSound,putdownSound);
		schaakstukken.add(paardR);
		world.addGameObject(paardR, tileLength*7, 1*tileLength);
		paardL = new Paard(world,schaakstuk.WIT,pickupSound,putdownSound);
		schaakstukken.add(paardL);
		world.addGameObject(paardL, tileLength*2, 8*tileLength);
	 paardR = new Paard(world,schaakstuk.WIT,pickupSound,putdownSound);
		schaakstukken.add(paardR);
		world.addGameObject(paardR, tileLength*7, 8*tileLength);
	}
	
	private static void lopers() {
		schaakstuk loperL = new Loper(world,schaakstuk.ZWART,pickupSound,putdownSound);
		schaakstukken.add(loperL);
		world.addGameObject(loperL, tileLength*3, 1*tileLength);
		schaakstuk loperR = new Loper(world,schaakstuk.ZWART,pickupSound,putdownSound);
		schaakstukken.add(loperR);
		world.addGameObject(loperR, tileLength*6, 1*tileLength);
		loperL = new Loper(world,schaakstuk.WIT,pickupSound,putdownSound);
		schaakstukken.add(loperL);
		world.addGameObject(loperL, tileLength*3, 8*tileLength);
	 loperR = new Loper(world,schaakstuk.WIT,pickupSound,putdownSound);
		schaakstukken.add(loperR);
		world.addGameObject(loperR, tileLength*6, 8*tileLength);
	}
	
	private static void koningEnKonining() {
		schaakstuk koning = new Koning(world,schaakstuk.ZWART,pickupSound,putdownSound,gewonnenSound);
		schaakstukken.add(koning);
		world.addGameObject(koning, tileLength*5, 1*tileLength);
		schaakstuk koningin = new Koningin(world,schaakstuk.ZWART,pickupSound,putdownSound);
		schaakstukken.add(koningin);
		world.addGameObject(koningin, tileLength*4, 1*tileLength);
		koning = new Koning(world,schaakstuk.WIT,pickupSound,putdownSound,gewonnenSound);
		schaakstukken.add(koning);
		world.addGameObject(koning, tileLength*5, 8*tileLength);
		koningin = new Koningin(world,schaakstuk.WIT,pickupSound,putdownSound);
		schaakstukken.add(koningin);
		world.addGameObject(koningin, tileLength*4, 8*tileLength);		
	}
	
	public static void klokken() {
		 Klok zwartText = new Klok(world, schaakstuk.ZWART,false);
	        world.addGameObject(zwartText,580, 25);
	        Klokken.add(zwartText );
	        Klok witText = new Klok(world, schaakstuk.WIT,true);
	        Klokken.add(witText);	        
	        world.addGameObject(witText,50, 25);	        
	}
	
	public  static boolean isKlokAan(String ZofW) {
		for (Klok klok : Klokken) {
			if(klok.welkeKleur() == ZofW) {
				if(klok.isActive()) {
					return true;
				}else return false;
			}else return false;
		}
return false;
		
	}
	
	public static Boolean IsHierSchaakstuk(int vergelijkX, int vergelijkY) {
		int X;
		int Y;
		for (schaakstuk schaakstuk : schaakstukken)
		{ 
		    X = (int) schaakstuk.getX();
		    Y = (int) schaakstuk.getY();
		   
		    
		    if(X == vergelijkX && Y == vergelijkY && !schaakstuk.getDeleted() ) {
		    	
		    	return true;
		    	
		    }
		}
	
	return false;
	}
	
	public static String WelkeKleur(int vergelijkX, int vergelijkY) {
		int X;
		int Y;
		for (schaakstuk schaakstuk : schaakstukken)
		{ 
		    X = (int) schaakstuk.getX();
		    Y = (int) schaakstuk.getY();
		   
		    
		    if(X == vergelijkX && Y == vergelijkY) {
		    	return schaakstuk.getZW();
		    }
		}
	
	return "niks";
	}

	


}

