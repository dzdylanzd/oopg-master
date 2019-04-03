package schaakSpel;

import java.util.ArrayList;
import nl.han.ica.oopg.sound.Sound;

/**
 * @author dylan zweers
 *
 */
public class schaakbord  {	
	
	/** de grote van een tile
	 * 
	 */
	private static int tileLength = 80;	
	
	/** een lijst met alle schaakstukken
	 * 
	 */
	static ArrayList<schaakstuk> schaakstukken = new ArrayList<schaakstuk>();
	/**een lijst met alle klokken
	 * 
	 */
	static ArrayList<Klok> Klokken = new ArrayList<Klok>();
	/** een verwijzing naar het hoofd spel
	 * 
	 */
	private static schaakSpel world;
	/** het op pak geluid
	 * 
	 */
	private static Sound pickupSound;
	/** het zet neer geluid
	 * 
	 */
	private static Sound putdownSound;
	/**het gewonnen geluid
	 * 
	 */
	private static Sound gewonnenSound;
	
	/** dit is de constructor van schaakbord je moet world mee geven en de 3 geluiden pickupSound,putdownSound,gewonnenSound
	 * @param world
	 * @param pickupSound
	 * @param putdownSound
	 * @param gewonnenSound
	 */
	public schaakbord(schaakSpel world, Sound pickupSound, Sound putdownSound, Sound gewonnenSound){
		schaakbord.pickupSound=pickupSound;
		schaakbord.putdownSound=putdownSound;
		schaakbord.gewonnenSound=gewonnenSound;
		schaakbord.world = world;		
	}
	
	/** met deze functie maak je alle schaakstukken aan en de klokken
	 * 
	 */
	public static void startGame() {
		lopers();
		pionnen();
		 torens();
		 paarden();
		 koningEnKonining();
		 klokken() ;

		
	}
	
	/** met deze functie kun je het spel herstarten. Het maakt het schaakbord leeg en maakt alle objecten opnieuw aan
	 * 
	 */
	public static void restart() {
		
			world.deleteAllGameOBjects();
			schaakstukken.clear();
			Klokken.clear();
			startGame();
		
	}
	
	/** dit maakt de pionnen aan
	 * 
	 */
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
	
	/** dit maakt de torens aan
	 * 
	 */
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
	
	/** dit maakt de paarden aan
	 * 
	 */
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
	
	/** dit maakt de lopers aan
	 * 
	 */
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
	
	/** dit maakt de koning en konining aan
	 * 
	 */
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
	
	/** dit maakt de klokken aan
	 * 
	 */
	public static void klokken() {
		 Klok zwartText = new Klok(world, schaakstuk.ZWART,false);
	        world.addGameObject(zwartText,580, 25);
	        Klokken.add(zwartText );
	        Klok witText = new Klok(world, schaakstuk.WIT,true);
	        Klokken.add(witText);	        
	        world.addGameObject(witText,50, 25);	        
	}
	
	/** met deze functie kan je kijken of een bepaald kleur klok aan is
	 * @param ZofW
	 * @return of de megegeven klok aan is
	 */
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
	
	/** hiermee kijk je of er een schaakstuk is op de meegegeven coordinaten
	 * @param vergelijkX de vergelijk x
	 * @param vergelijkY de vergelijk y
	 * @return boolean of er een schaakstuk is
	 */
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
	
	/** hiermee kan je checken je een schaakstuk vast hebt
	 * @return true als je een stuk vast hebt false als je geen stuk vast hebt
	 */
	public static boolean schaakstukVast() {
		for (schaakstuk schaakstuk : schaakstukken) {
			if(schaakstuk.getSelected()) {
				return true;
			}
		}
		return false;
	
	}
	
	/** hiermee haal je het geselecteerde stuk op
	 * @return het geselecteerde stuk
	 */
	public static schaakstuk GeselecteerdStuk() {
		schaakstuk jan = null;
		for (schaakstuk schaakstuk : schaakstukken) {
			if(schaakstuk.getSelected()) {
				return schaakstuk;
			}
		}
		return jan;
	}
	


	
	/** hier mee kan je de kleur ophalen van het schaakstuk op de meegegeven x en y
	 * @param vergelijkX de x waar het schaakstuk is waar je de kleur van wilt weten
	 * @param vergelijkY de y waar het schaakstuk is waar je de kleur van wilt weten
	 * @return de kleur van het schaakstuk op de mee gegeven x en y
	 */
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

