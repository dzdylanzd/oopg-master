package schaakSpel;

import nl.han.ica.oopg.alarm.Alarm;
import nl.han.ica.oopg.alarm.IAlarmListener;
import nl.han.ica.oopg.objects.GameObject;
import processing.core.PGraphics;


public class TextObject extends GameObject implements IAlarmListener{

    private String text;

    public TextObject(String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(PGraphics g) {
        g.textAlign(g.LEFT, g.TOP);
        g.textSize(30);
        g.text(text, getX(), getY());
    }

	@Override
	public void triggerAlarm(String alarmName) {
		
		
	}
	 protected void startAlarm() {
	        Alarm alarm=new Alarm("witAlarm",-1);
	        alarm.addTarget(this);
	        alarm.start();
	    }
}