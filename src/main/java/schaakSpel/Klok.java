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
	int waarde=00;
	int maximum=60;
	int minuten=20;
    private String text;
	private String name;	
	protected schaakSpel world;
	Alarm alarm=new Alarm(name,60*20);
    private boolean Active=false;
    public Klok(schaakSpel world,String name, boolean Active) {
    	
  this.Active=Active;
  this.name=name;
  startAlarm();
    }

    public void setText(String text) {
        this.text =text;
    }
    
    
    
	public void keyPressed(int keyCode, char key){
		
			if(key==' ') {
				Active = !Active;
				
				startAlarm();
				
			}		
			
	
	}
	
	public String welkeKleur() {
		return name;
	}
	
	public boolean isActive() {
		return Active;
	}
	
	
		
	


	@Override
    public void update() {
		
	
	}
    

    @Override
    public void draw(PGraphics g) {
        g.textAlign(PConstants.LEFT, PConstants.TOP);
        g.textSize(30);
        g.text(name+": "+minuten+":"+geefTijdNotatie(), getX(), getY());
    }
   

	@Override
	public void triggerAlarm(String name) {
		if(Active==true) {
		tik();
		startAlarm();
		}
	}
	 protected void startAlarm() {
	        Alarm alarm=new Alarm(name,1);
	        alarm.addTarget(this);
	        
	        alarm.start();
	    }
	 public void refreshText() {
		 setText(name+":"+"" +geefTijdNotatie());
	 }

	 void tik() {
		    waarde=(waarde-1) % maximum;
		  }
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

		