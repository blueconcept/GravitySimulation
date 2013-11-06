package GraphicBasics;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings("serial")
public class Space extends JPanel implements ActionListener {
	Timer t = new Timer(50, this);
	boolean starting = true;
	private ArrayList<Particle> matter;
	Ellipse2D particle;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		if(starting) {
		// double inputmass, double inputradius, double inputx, double inputy, double inputvx, double inputvy
		matter = new ArrayList<Particle>();
		
		int numberofparticles = 50;
		for(int i=0;i<numberofparticles; i+=1)
		{

			matter.add(new Particle(.0000001*Math.random(), 10, Math.random()*1000, Math.random()*1000, Math.random()/100, Math.random()/100));
			matter.add(new Particle(.0000001*Math.random(), 10, Math.random()*1000, Math.random()*1000, -Math.random()/100, -Math.random()/100));
			matter.add(new Particle(.0000001*Math.random(), 10, Math.random()*1000, Math.random()*1000, Math.random()/100, -Math.random()/100));
			matter.add(new Particle(.0000001*Math.random(), 10, Math.random()*1000, Math.random()*1000, -Math.random()/100, Math.random()/100));
		}
		
		matter.add(new Particle(.000001, 120, 600, 500, 0, 0));
		matter.add(new Particle(.00001, 30, 600, 600, 0, 0));
		matter.add(new Particle(.0001, 60, 250, 250, 0,0));
		System.out.println(matter);
		
		starting = false;
		}
		
		for(int i=0;i<matter.size(); i+=1) {
			particle = new Ellipse2D.Double(matter.get(i).getX(), matter.get(i).getY(), matter.get(i).getRadius(), matter.get(i).getRadius());
			g2.fill(particle);
		}
		
		t.start();
	}
	

	
	/*
	 * This will sum the particle's accelerate according to every other particles position and mass
	 * and do this for every particle 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i =0; i<matter.size();i+=1) {
			for(int j =0; j<matter.size(); j+=1) {
				if(i!=j) {
					matter.get(j).accelerateParticle(matter.get(i));
				}
			}
		}
		
		repaint();
	}
	
	
}
