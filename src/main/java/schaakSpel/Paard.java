package schaakSpel;

import java.util.List;

import nl.han.ica.oopg.collision.CollidedTile;
import nl.han.ica.oopg.collision.CollisionSide;
import nl.han.ica.oopg.exceptions.TileNotFoundException;
import nl.han.ica.oopg.objects.Sprite;
import processing.core.PVector;
import schaakSpel.tiles.SchaakbordTile;

public class Paard extends schaakstuk {

	public boolean test;
	
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
			System.out.println("ik mag 2 vakje omhog en 1 naar rechts of links en mag over dingen heen springen");
	}
	}

}
