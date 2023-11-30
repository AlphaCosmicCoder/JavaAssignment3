package rwsn;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class MainFrame extends JFrame implements ActionListener{

	DisplayCanvas canvas = new DisplayCanvas();
	

	public MainFrame() {
		setTitle("Rechargable WSN");
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(canvas);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		BaseStation bs = new BaseStation((int)((d.getWidth()-20)/2),(int)(d.getHeight()/2));
		canvas.bs = bs;
		int ns = Integer.parseInt(JOptionPane.showInputDialog("How Many Sensors?"));
		int nc = Integer.parseInt(JOptionPane.showInputDialog("How Many Chargers?"));
		
		for(int i=0;i<nc;i++) {
			int x = (int)(Math.random()*d.getWidth()+0.5);
			int y = (int)(Math.random()*(d.getHeight()-150)+0.5);					
			Charger c = new Charger(x, y);
			canvas.chargers.add(c);
		}
		
		for(int i=0;i<ns;i++) {
			int x = (int)(Math.random()*d.getWidth()+0.8);
			int y = (int)(Math.random()*(d.getHeight()-150)+0.8);					
			Sensor s = new Sensor(x, y, bs);
			canvas.chargers.add(s);
		}
	}
	
	public static void main(String[] args) {
		MainFrame f = new MainFrame();
		f.setVisible(true);
		
		
		while(true) {
			//TODO Implement each round of WSN
			f.canvas.repaint();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			((Charger)f.canvas.chargers.get(0)).remainingEnergy=1;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
