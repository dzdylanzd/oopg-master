package testGame;

import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.view.View;

	// deze 3 classes moet je geimporteerd hebben om het te laten werken.
	
	import nl.han.ica.oopg.objects.TextObject;


	public class TestWorld extends GameEngine {

		public static void main(String[] args) {
			TestWorld hw = new TestWorld();

					// deze methode start de game.
			hw.runSketch();
		}

		@Override
		public void setupGame() {
			int worldWidth = 500;
			int worldHeight = 500;
			
			TextObject to = new TextObject("dit is de beste test ooit", 40);
			to.setForeColor(255, 255, 255, 255);
			addGameObject(to, 100, 100);
			
			View view = new View(worldWidth, worldHeight);

			setView(view);
			size(worldWidth, worldHeight);
		}

		@Override
		public void update() {
			// Dit doet nog niets
			
		}

	}
