package schaakSpel;

import java.util.ArrayList;
import java.util.List;
import nl.han.ica.oopg.collision.CollidedTile;
import nl.han.ica.oopg.collision.CollisionSide;
import nl.han.ica.oopg.collision.ICollidableWithTiles;
import nl.han.ica.oopg.exceptions.TileNotFoundException;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import nl.han.ica.oopg.sound.Sound;
import nl.han.ica.oopg.userinput.IMouseInput;
import processing.core.PVector;
import schaakSpel.tiles.SchaakbordTile;
import nl.han.ica.oopg.userinput.IKeyInput;

public abstract class schaakstuk extends SpriteObject implements IMouseInput,ICollidableWithTiles,IKeyInput{
	
	/**de constante voor zwart
	 * 
	 */
	public final static String ZWART = "black";
	/**de constante voor wit
	 * 
	 */
	public final static String WIT = "white";
	/** boolean of we de mogenlijke vakjes al getekend hadden
	 * 
	 */
	protected boolean getekend = false;
	/** boolean of het schaakstuk is geselecteerd
	 * 
	 */
	protected boolean selected = false;
	/** lijst met alle getekende mogenlijke plekken van dit schaakstuk
	 * 
	 */
	protected ArrayList<mogenlijkePlek> plekken = new ArrayList<mogenlijkePlek>();
	/** het pak op geluid
	 * 
	 */
	private Sound pickupSound;
	/** het zet neer geluid
	 * 
	 */
	private Sound putdownSound;	
	/** de verwijzing naar de main class
	 * 
	 */
	 
	protected schaakSpel world;
	/** hier staat de string in waar in staat of het een wit of een zwart stuk is
	 * 
	 */
	protected String ZofW;
	/** de grote van een tile
	 * 
	 */
	int tileSize = 80;
	/** of je dit schaakstuk hebt gedelete
	 * 
	 */
	boolean deleted = false;
	/** of je aan het cheaten bent 
	 * 
	 */
	boolean cheater = false;
	
	/** hiermee haal je het deleted variabel mee
	 * @return deleted (boolean)
	 */
	public boolean getDeleted() {
		return deleted;
	}


	/**
	 * @param sprite hier kan je de sprite mee geven
	 * @param pickupSound geeft het pickupSound mee 
	 * @param putdownSound geeft het pickdownSound mee
	 */
	public schaakstuk(Sprite sprite, Sound pickupSound, Sound putdownSound) {
		super(sprite);
		this.pickupSound=pickupSound;
		this.putdownSound=putdownSound;		
	}

	
	/** abstracte methode voor het maken van sugestie vakken
	 * 
	 */
	protected abstract void maakPlekken();	
	
	
	
	public void mouseClicked(int x, int y, int button) {
		if(!cheater) {
		if(x>getX() && x<getX()+getWidth() && y>getY() && y<getY()+getHeight() && selected == false) {
			if(schaakbord.schaakstukVast()) {
				if(schaakbord.GeselecteerdStuk().mogenlijkePlek((int) getX(),(int) getY())) {
					selected=true;					
					pickupSound.rewind();
					pickupSound.play();								
				}
			}else {
			
		selected=true;
	
		pickupSound.rewind();
		pickupSound.play();			
			}
		
	}else if(mogenlijkePlek((int) getX(),(int) getY()) == true){
		selected=false;		
		update();
		putdownSound.rewind();
		putdownSound.play();	
		selected=false;
		}
		}else if(cheater) {
			if(x>getX() && x<getX()+getWidth() && y>getY() && y<getY()+getHeight() && selected == false) {
				
				selected=true;
			
				pickupSound.rewind();
				pickupSound.play();			
				
			}else {
			selected=false;		
			update();
			putdownSound.rewind();
			putdownSound.play();	
			selected=false;
			}
		}
		
	}
	
	/** hiermee haal het het selected variabel op
	 * @return selected
	 * 
	 */
	public boolean getSelected(){
	return selected;
	}
			
		
	public void keyPressed(int keyCode, char key) {
		
		if(selected==true) {
		if(key=='d') {
			this.deleted = true;
			selected = false;
			this.setX(0);
			this.setY(0);
		world.deleteGameObject(this);
		
		for(mogenlijkePlek plek: plekken ) {
			world.deleteGameObject(plek);
		}
	}
	}
if(key=='o') {
		cheater = true;	
		}
		
	}
	
	public void keyReleased(int keyCode, char key) {
		if(key=='o') {
			cheater = false;	
		}
		
	}
	
	
			
	public void mouseMoved(int x, int y) {
		if(selected==true) {
			setX(x-getWidth()/2);
			setY(y-getHeight()/2);
		}
	}
	
	@Override
	public void update() {
		if(selected == true) {	
		if(!getekend) {
        maakPlekken();
        getekend = true;
		}	
	}
	if(selected == false) {		
		getekend = false;
		for(mogenlijkePlek plek: plekken ) {
		world.deleteGameObject(plek);
		}
		plekken.clear();
	}
	
	}

	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
		 PVector vector;

		for (CollidedTile ct : collidedTiles) {
	        if (ct.getTile() instanceof SchaakbordTile) {
	              if (CollisionSide.INSIDE.equals(ct.getCollisionSide())) {
	             try {
	                 vector = world.getTileMap().getTilePixelLocation(ct.getTile());
	              setX((vector.x+getWidth()/3));
	              setY((vector.y+getHeight()/3));
	         if(selected==false) {
	        	 SchaakbordTile.bevatSchaakstuk=true;
	         }
	         if(selected==true) {
	        	 SchaakbordTile.bevatSchaakstuk=false;
	         }
	             } catch (TileNotFoundException e) {
	                 e.printStackTrace();
	             }
	        }
	}
	}
	}

	
	
	/** hier wordt terug gegeven of hij zwart of wit is het schaakstuk
	 * @return String ZWART of WIT
	 * 
	 *
	 */
	public String getZW(){
		return ZofW;
		
	}
	public Boolean mogenlijkePlek(int vergelijkX, int vergelijkY) {
		int X;
		int Y;
		for (mogenlijkePlek plek : plekken)
		{ 
		    X = (int) plek.getX();
		    Y = (int) plek.getY();
		   
		    
		    if(X == vergelijkX-15 && Y == vergelijkY-15) {
		    	return true;
		    }
		}
	
	return false;
	}
	
}
