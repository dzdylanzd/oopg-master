package schaakSpel;

import java.util.ArrayList;
import java.util.List;

import nl.han.ica.oopg.collision.CollidedTile;
import nl.han.ica.oopg.collision.CollisionSide;
import nl.han.ica.oopg.exceptions.TileNotFoundException;
import nl.han.ica.oopg.objects.Sprite;
import processing.core.PVector;
import schaakSpel.tiles.SchaakbordTile;

public class Koningin extends schaakstuk {
	
	

	public Koningin(schaakSpel world,String text) {
		super(new Sprite("src/main/java/schaakSpel/media/" + text + "Queen.png"));
		
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
	protected void maakPlekken() {
		float x = getX()-15;
		float y = getY()-15;
		float tileSize = 80;
		float X[] = {-1,1,0,0};
		float Y[] = {0,0,-1,1};
		
		for(int i=0; i < X.length; i++) {
			if(x+tileSize*X[i] < 800-tileSize && x+tileSize*X[i] > tileSize && y+tileSize*Y[i] < 800-tileSize && y+tileSize*Y[i] > tileSize  ) {
		mogenlijkePlek plek = new mogenlijkePlek(world);
		plekken.add(plek);	
		world.addGameObject(plek,x+tileSize*X[i],y+tileSize*Y[i]);
			}
		}

	}

}
