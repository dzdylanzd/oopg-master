package schaakSpel;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.sound.Sound;

public class Loper extends schaakstuk {

	public Loper(schaakSpel world,String text, Sound pickupSound, Sound putdownSound) {
		super(new Sprite("src/main/java/schaakSpel/media/" + text + "Bishop.png"),pickupSound,putdownSound);
		this.world = world;
	}

	@Override
	protected void maakPlekken() {
		// TODO Auto-generated method stub
		}
	

}
