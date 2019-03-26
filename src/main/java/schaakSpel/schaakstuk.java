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

public abstract class schaakstuk extends SpriteObject implements IMouseInput,ICollidableWithTiles{
	
	public final static String ZWART = "black";
	public final static String WIT = "white";
	protected boolean getekend = false;
	protected boolean selected = false;
	protected ArrayList<mogenlijkePlek> plekken = new ArrayList<mogenlijkePlek>();
	private Sound pickupSound;
	private Sound putdownSound;
	protected schaakSpel world;

	public schaakstuk(Sprite sprite, Sound pickupSound, Sound putdownSound) {
		super(sprite);
		this.pickupSound=pickupSound;
		this.putdownSound=putdownSound;
	}
	
	protected abstract void maakPlekken();	
	
	public void mouseReleased(int x, int y, int button) {
		if(x>getX() && x<getX()+getWidth() && y>getY() && y<getY()+getHeight() && selected == false) {
		selected=true;
		pickupSound.rewind();
		pickupSound.play();	
	}else if(x>getX() && x<getX()+getWidth() && y>getY() && y<getY()+getHeight() && selected == true){
		selected=false;
		putdownSound.rewind();
		putdownSound.play();
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
	             } catch (TileNotFoundException e) {
	                 e.printStackTrace();
	             }
	        }
	}
	}
	}	
	
}
