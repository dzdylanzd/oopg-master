package schaakSpel;

import nl.han.ica.oopg.objects.Sprite;

import nl.han.ica.oopg.objects.SpriteObject;
import nl.han.ica.oopg.userinput.IMouseInput;
import nl.han.ica.oopg.collision.ICollidableWithTiles;
import nl.han.ica.oopg.exceptions.TileNotFoundException;

import java.util.List;

import schaakSpel.tiles.SchaakbordTile;
import nl.han.ica.oopg.collision.CollidedTile;
import nl.han.ica.oopg.collision.CollisionSide;
import processing.core.PVector;

public  class SchaakstukBlackKoning extends SpriteObject implements IMouseInput,ICollidableWithTiles{
private schaakSpel world;
private boolean selected;

public SchaakstukBlackKoning(schaakSpel world, String text) {
	
	super(new Sprite("src/main/java/schaakSpel/media/" + text + "King.png"));
	

	
   	this.world=world;

    this.selected=false;
}


@Override
public void update() {
	// TODO Auto-generated method stub
	
}

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


	
	
	







	

