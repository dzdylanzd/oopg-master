package schaakSpel;

import java.util.ArrayList;
import java.util.List;

import nl.han.ica.oopg.collision.CollidedTile;
import nl.han.ica.oopg.collision.CollisionSide;
import nl.han.ica.oopg.exceptions.TileNotFoundException;
import nl.han.ica.oopg.objects.Sprite;
import processing.core.PVector;
import schaakSpel.tiles.SchaakbordTile;

public class Paard extends schaakstuk {

	private boolean getekend = false;
	ArrayList<mogenlijkePlek> plekken = new ArrayList<mogenlijkePlek>();
	
	public Paard(schaakSpel world,String text) {
		super(new Sprite("src/main/java/schaakSpel/media/" + text + "Knight.png"));
		
		this.world = world;
		
		
	}

	@Override
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

	@Override
	public void update() {
		// TODO Auto-generated method stub
	if(selected == true) {
		if(!getekend) {
maakPlekken();

getekend = !getekend;
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
	
	private void maakPlekken() {
		float x = getX()-15;
		float y = getY()-15;
		float tileSize = 80;
		int aantalPlaatzen = 8;
		float X[] = {x-tileSize*2,x-tileSize*2};
		float Y[] = {y-tileSize*1,y+tileSize*1};
		
		for(int i=0; i < X.length; i++) {
		mogenlijkePlek plek = new mogenlijkePlek(world);
		plekken.add(plek);	
		world.addGameObject(plek,X[i],Y[i]);
		}

	}
	

}
