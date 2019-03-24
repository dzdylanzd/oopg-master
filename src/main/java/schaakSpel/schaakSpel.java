package schaakSpel;

import schaakSpel.tiles.SchaakbordTile;
import nl.han.ica.oopg.dashboard.Dashboard;
import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.persistence.FilePersistence;
import nl.han.ica.oopg.persistence.IPersistence;
import nl.han.ica.oopg.sound.Sound;
import nl.han.ica.oopg.tile.TileMap;
import nl.han.ica.oopg.tile.TileType;
import nl.han.ica.oopg.view.EdgeFollowingViewport;
import nl.han.ica.oopg.view.View;
import processing.core.PApplet;



/**
 * @author Ralph Niels
 */
public class schaakSpel extends GameEngine {

 


    public static void main(String[] args) {
        String[] processingArgs = {"schaakSpel.schaakSpel"};
        schaakSpel mySketch = new schaakSpel();

        PApplet.runSketch(processingArgs, mySketch);
    }

    /**
     * In deze methode worden de voor het spel
     * noodzakelijke zaken geïnitialiseerd
     */
    @Override
    public void setupGame() {

        int worldWidth = 800;
        int worldHeight = 800;

//        SchaakstukBlackKoning koning = new SchaakstukBlackKoning(this,"black");
//        SchaakstukBlackKoning koning2 = new SchaakstukBlackKoning(this,"white");
//        addGameObject(koning, 200, 200);
//        addGameObject(koning2, 400, 200);
        
        schaakbord shaakbord = new schaakbord(this);
        shaakbord.startGame();
       
        initializeTileMap();




        createViewWithoutViewport(worldWidth, worldHeight);
    }

    /**
     * Creeërt de view zonder viewport
     *
     * @param screenWidth  Breedte van het scherm
     * @param screenHeight Hoogte van het scherm
     */
    private void createViewWithoutViewport(int screenWidth, int screenHeight) {
        View view = new View(screenWidth, screenHeight);
      
        view.setBackground(loadImage("src/main/java/schaakSpel/media/background.jpg"));
        setView(view);
        size(screenWidth, screenHeight);
    }

    /**
     * Creeërt de view met viewport
     *
     * @param worldWidth   Totale breedte van de wereld
     * @param worldHeight  Totale hoogte van de wereld
     * @param screenWidth  Breedte van het scherm
     * @param screenHeight Hoogte van het scherm
     * @param zoomFactor   Factor waarmee wordt ingezoomd
     */
   


    /**
     * Maakt de spelobjecten aan
     */
    private void createObjects() {

    }


    /**
     * Initialiseert de tilemap
     */
    private void initializeTileMap() {
        /* TILES */
        Sprite WitvakjeSprite = new Sprite("src/main/java/schaakSpel/media/Witvakje.jpg");
        Sprite ZwartvakjeSprite = new Sprite("src/main/java/schaakSpel/media/Zwartvakje.jpg");

        TileType<SchaakbordTile> Witvakje = new TileType<>(SchaakbordTile.class, WitvakjeSprite);
        TileType<SchaakbordTile> Zwartvakje = new TileType<>(SchaakbordTile.class, ZwartvakjeSprite);
        


        TileType[] tileTypes = {Witvakje,Zwartvakje};
        int tileSize = 80;
        int tilesMap[][] = {
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, 0, 1, 0, 1, 0, 1, 0, 1, -1},
                {-1, 1, 0, 1, 0, 1, 0, 1, 0, -1},
                {-1, 0, 1, 0, 1, 0, 1, 0, 1, -1},
                {-1, 1, 0, 1, 0, 1, 0, 1, 0, -1},
                {-1,  0, 1, 0, 1, 0, 1, 0, 1, -1},
                {-1, 1, 0, 1, 0, 1, 0, 1, 0, -1},
                {-1,  0, 1, 0, 1, 0, 1, 0, 1, -1},
                {-1, 1, 0, 1, 0, 1, 0, 1, 0, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}
           
        };
        tileMap = new TileMap(tileSize, tileTypes, tilesMap);
    }

    @Override
    public void update() {
    }

  

    }


