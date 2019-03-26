package schaakSpel;

import java.util.ArrayList;
import java.util.List;

import nl.han.ica.oopg.collision.CollidedTile;
import nl.han.ica.oopg.collision.CollisionSide;
import nl.han.ica.oopg.collision.ICollidableWithTiles;
import nl.han.ica.oopg.exceptions.TileNotFoundException;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import nl.han.ica.oopg.userinput.IMouseInput;
import processing.core.PVector;
import schaakSpel.tiles.SchaakbordTile;

public abstract class schaakstuk extends SpriteObject implements IMouseInput,ICollidableWithTiles{
	
	public final static String ZWART = "black";
	public final static String WIT = "white";
	protected boolean getekend = false;
	protected ArrayList<mogenlijkePlek> plekken = new ArrayList<mogenlijkePlek>();

	public schaakstuk(Sprite sprite) {
		super(sprite);
	}

	protected schaakSpel world;
	protected boolean selected = false;

	
	
	public void mouseReleased(int x, int y, int button) {
		if(x>getX() && x<getX()+getWidth() && y>getY() && y<getY()+getHeight() && selected == false) {

			selected=true;
			
	}else {selected=false;

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
		// TODO Auto-generated method stub
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
	
	protected abstract void maakPlekken();
	
	


	
	
}
