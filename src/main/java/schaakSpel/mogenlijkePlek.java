package schaakSpel;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

public class mogenlijkePlek extends SpriteObject  {

	schaakSpel world;
	
	public mogenlijkePlek(schaakSpel world) {
		super(new Sprite("src/main/java/schaakSpel/media/selecteerVakje.png"));
		this.world = world;
	}

	@Override
	public void update() {
		
	}
	

	
}
