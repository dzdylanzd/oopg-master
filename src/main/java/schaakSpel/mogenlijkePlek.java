package schaakSpel;

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

public class mogenlijkePlek extends SpriteObject  {

	schaakSpel world;
	
	public mogenlijkePlek(schaakSpel world) {
		super(new Sprite("src/main/java/schaakSpel/media/selecteerVakje.png"));
		// TODO Auto-generated constructor stub
		this.world = world;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	

	
}
