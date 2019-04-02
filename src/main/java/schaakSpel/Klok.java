package schaakSpel;

import nl.han.ica.oopg.alarm.Alarm;
import nl.han.ica.oopg.alarm.IAlarmListener;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.userinput.IKeyInput;
import nl.han.ica.oopg.userinput.IMouseInput;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PGraphics;



public class Klok extends GameObject implements IAlarmListener,IMouseInput{
	/** seconden waarden
	 * 
	 */
	int waarde=00;
	/** maximum aantal seconen
	 * 
	 */
	int maximum=60;
	/** hoeveel minuten er zijn
	 * 
	 */
	int minuten=20;
    /** de text van de klok
     * 
     */
    private String text;
	/** de naam/kleur van de klok
	 * 
	 */
	private String name;	
	/** de verwijzing naar de main classe
	 * 
	 */
	protected schaakSpel world;
	/** het alarm wat om de seconden af gaat
	 * 
	 */
	Alarm alarm=new Alarm(name,60*20);
    /** of de klok aan is
     * 
     */
    private boolean Active=false;
    
    
    /** de constructor van klok
     * @param world geef de main methode mee
     * @param name geeft de kleur/ naam van de klok mee
     * @param Active geeft mee of de klok aan of uit moet starten
     */
    public Klok(schaakSpel world,String name, boolean Active) {
    	
  this.Active=Active;
  this.name=name;
  startAlarm();
    }

    
    /** hier mee kan je de text van de klok zetten
     * @param text de text die je wilt zetten
     */
    public void setText(String text) {
        this.text = text;
    }
    
    
    
	public void keyPressed(int keyCode, char key){
		
			if(key==' ') {
				Active = !Active;
				
				startAlarm();
				
			}		
			
	
	}
	
	/** hiermee haal je de kleur van de klok op
	 * @return de kleur van de klok (String)
	 */
	public String welkeKleur() {
		return name;
	}
	
	/** hiermee haal je op of de klok aan is of niet 
	 * @return true als aan false als uit
	 */
	public boolean isActive() {
		return Active;
	}
	
	
		
	


	@Override
    public void update() {
		
	
	}
    

    /** hier teken we de klok
     * @see nl.han.ica.oopg.objects.GameObject#draw(processing.core.PGraphics)
     */
    @Override
    public void draw(PGraphics g) {
        g.textAlign(PConstants.LEFT, PConstants.TOP);
        g.textSize(30);
        g.text(name+": "+minuten+":"+geefTijdNotatie(), getX(), getY());
    }
   


	/** hier is de trigger om de seconden elke seconden doet hij een tik en start het alarm opnieuw
	 * @see nl.han.ica.oopg.alarm.IAlarmListener#triggerAlarm(java.lang.String)
	 */
	@Override
	public void triggerAlarm(String name) {
		if(Active==true) {
		tik();
		startAlarm();
		}
	}
	 /** start het alarm
	 * 
	 */
	protected void startAlarm() {
	        Alarm alarm=new Alarm(name,1);
	        alarm.addTarget(this);
	        
	        alarm.start();
	    }
	 /** refresht de text
	 * 
	 */
	public void refreshText() {
		 setText(name+":"+"" +geefTijdNotatie());
	 }

	 /** tikt de tijd omlaag
	 * 
	 */
	void tik() {
		    waarde=(waarde-1) % maximum;
		  }
	 
	
	/**  haal de tijd op als String
	 * @return (String) de tijd
	 */
	String geefTijdNotatie(){
		  if(waarde<10){
			
			 if(waarde==0 && Active ==true) {
				 waarde=59;
				 minuten--;
			 }
		    return "0" + PApplet.str(waarde);
		  
		  }
		  else{
		    return PApplet.str(waarde);
		}

}
	
}

		