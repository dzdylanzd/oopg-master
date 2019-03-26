package schaakSpel;

import java.util.ArrayList;
import java.util.List;

import nl.han.ica.oopg.collision.CollidedTile;
import nl.han.ica.oopg.collision.CollisionSide;
import nl.han.ica.oopg.exceptions.TileNotFoundException;
import nl.han.ica.oopg.objects.Sprite;
import processing.core.PVector;
import schaakSpel.tiles.SchaakbordTile;

public class Pion extends schaakstuk {
	
	private String ZW;
	private boolean verplaatst = false;
	
	

	public Pion(schaakSpel world,String text) {
		super(new Sprite("src/main/java/schaakSpel/media/" + text + "Pawn.png"));
		this.ZW = text;
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
		
		if(ZW == schaakstuk.WIT) {
		if(!verplaatst) {
			if(x < 800-tileSize && x > tileSize && y+tileSize*-2 < 800-tileSize && y+tileSize*-2 > tileSize  ) {
		mogenlijkePlek plek = new mogenlijkePlek(world);
		plekken.add(plek);	
		world.addGameObject(plek,x,y+tileSize*-2);
		verplaatst = true;
			}
		} else if(verplaatst) {
			if(x < 800-tileSize && x > tileSize && y+tileSize*-1 < 800-tileSize && y+tileSize*-1 > tileSize  ) {
		mogenlijkePlek plek = new mogenlijkePlek(world);
		plekken.add(plek);	
		world.addGameObject(plek,x,y+tileSize*-1);
			}
		}
		}
		else if(ZW == schaakstuk.ZWART) {
			if(!verplaatst) {
				if(x < 800-tileSize && x > tileSize && y+tileSize*2 < 800-tileSize && y+tileSize*2 > tileSize  ) {
			mogenlijkePlek plek = new mogenlijkePlek(world);
			plekken.add(plek);	
			world.addGameObject(plek,x,y+tileSize*2);
			verplaatst = true;
				}
			} else if(verplaatst) {
				if(x < 800-tileSize && x > tileSize && y+tileSize*1 < 800-tileSize && y+tileSize*1 > tileSize  ) {
			mogenlijkePlek plek = new mogenlijkePlek(world);
			plekken.add(plek);	
			world.addGameObject(plek,x,y+tileSize*1);
				}
			}
			}

	}

}
