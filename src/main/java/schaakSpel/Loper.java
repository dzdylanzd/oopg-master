package schaakSpel;

import java.util.List;

import nl.han.ica.oopg.collision.CollidedTile;
import nl.han.ica.oopg.collision.CollisionSide;
import nl.han.ica.oopg.exceptions.TileNotFoundException;
import nl.han.ica.oopg.objects.Sprite;
import processing.core.PVector;
import schaakSpel.tiles.SchaakbordTile;

public class Loper extends schaakstuk {

	public Loper(schaakSpel world,String text) {
		super(new Sprite("src/main/java/schaakSpel/media/" + text + "Bishop.png"));
		
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
		// TODO Auto-generated method stub
		
	}

	

}
