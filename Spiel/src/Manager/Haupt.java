package Manager;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Haupt extends Applet implements Runnable {

	private static final long serialVersionUID = -3785521478255739587L;
	Image Screen;
	Graphics ScreenG;
	Thread thread = new Thread(this);
	
	Fenstermanager fenstermanager;

	public void init() {
		setSize(1000, 500);
		Screen = createImage(getWidth(), getHeight());
		ScreenG = Screen.getGraphics();
		
		fenstermanager = new Fenstermanager(this);
	}

	@Override
	public void start() {
		thread.start();
	}

	public void run() {
		while (true) {
			try {
				thread.sleep(17);
			} catch (InterruptedException e) {
			}
			fenstermanager.update();
			repaint();
		}
	}

	public void update(Graphics g) {
		paint(g);
	}

	public void paint(Graphics g) {
		g.drawImage(Screen, 0, 0, this);
	}

	public Image getScreen(){
		return Screen;
	}
	
	public Graphics getScreenG(){
		return ScreenG;
	}
	
	public void setScreen(Image Screen){
		this.Screen = Screen;
	}
	
	public void setScreenG(Graphics ScreenG){
		this.ScreenG = ScreenG;
	}
}
