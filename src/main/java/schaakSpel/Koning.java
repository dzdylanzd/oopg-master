package schaakSpel;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.sound.Sound;


public class Koning extends schaakstuk {
	
	public Koning(schaakSpel world,String text, Sound pickupSound, Sound putdownSound) {
		super(new Sprite("src/main/java/schaakSpel/media/" + text + "King.png"),pickupSound,putdownSound);
		this.world = world;
	}

	@Override
	protected void maakPlekken() {
		// TODO Auto-generated method stub
	}
	
	
}
