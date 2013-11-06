package GraphicBasics;
import javax.swing.JFrame;


public class Main {
	
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		Space p = new Space();
		
		f.add(p);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1200, 1200);
		
		
	}
	
	
}
