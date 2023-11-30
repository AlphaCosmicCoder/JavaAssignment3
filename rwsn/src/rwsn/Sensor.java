package rwsn;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Sensor implements DisplayObject {
	
	Image img;
	int x,y,id;
	
	BaseStation bs;
	double energyDepletionRate;
	double remainingEnergy;
//	double energyChangeLevel;
	public Sensor(int x, int y, BaseStation bs) {
		this.x=x;
		this.y=y;
		this.bs = bs;
		remainingEnergy = Parameters.InitialEnergy;
		energyDepletionRate = Math.random()+0.01;
		img = new ImageIcon(getClass().getResource("/images/sensor.jpg")).getImage();
	}
	
	@Override
	public void draw(Graphics2D g) {
		g.drawImage(img,x,y,50,70,null);
		double changedValue = this.changeInEnergy();
		if(changedValue == 0) {
			g.setColor(Color.RED);
			g.drawString(String.valueOf(changedValue), x, y+5);
		} else {
			g.setColor(Color.GREEN);
			g.drawString(String.valueOf(changedValue), x, y+5);
		}
	}

	public double changeInEnergy() {
		this.remainingEnergy = this.remainingEnergy - this.energyDepletionRate;
		if(this.remainingEnergy < 0) {
			return 0;
		}
		return this.remainingEnergy;
	}
	
}
