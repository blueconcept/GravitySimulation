package GraphicBasics;

import java.util.ArrayList;

/*
 * The purpose of this class is to represent a particle of mass with various fields and functions
 * The particle needs to know where it is, how fast it is going, and what it's current acceleration is
 * 
 */
public class Particle {

	private double mass;
	private double radius;
	private double x;
	private double y;
	private double vx;
	private double vy;
	private double ax = 0;
	private double ay = 0;
	
	
	/*
	 * This is the constructor which initializes all of the fields from the parameters
	 */
	public Particle(double inputmass, double inputradius, double inputx, double inputy, double inputvx, double inputvy) 
	{
		mass = inputmass;
		radius = inputradius;
		x = inputx;
		y = inputy;
		vx = inputvx;
		vy = inputvy;
	}
	
	/*
	 * This is the function for accelerating this particle given a parameter particle (and it's position and mass)
	 */
	public void accelerateParticle(Particle input) {
	
		double dx1 = input.getX() - this.getX();
		double dy1 = input.getY() - this.getY();
		double r1 = Math.pow(dx1*dx1+dy1*dy1, 1/2 );
		
		/*
		 * The key here is that I am not using trignometry divide up the force of gravity into x and y forces
		 * but directly calculating the acceleration that would be cause by the particle given a distance in either x or y
		 * ax = dx*m/(r^3)  this is derived from f=ma, Fg= m1m2/r^2, sin(theta) = y/r cos(theta) = x/r
		 */
		double ax1 = input.getMass()*dx1/Math.pow(r1, 3);
		double ay1 = input.getMass()*dy1/Math.pow(r1, 3);
		
		//add to the velocity
		this.addVx(ax1);
		this.addVy(ay1);
		
		//change the position
		this.addX(this.getVx());
		this.addY(this.getVy());
		
	}
	
	/*
	 * This is a function for calculating the Pythagoream theorem 
	 */
	public double pythag(double dx, double dy) {
		return Math.pow(dx*dx +  dy*dy, 0.5);
	}
	
	/*
	 * This is necessary to make sure the objects aren't comparing themselves
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object) {
		return object.toString().equals(this.toString());
	}

	/*
	 * This is an elaborate toString overrided to show all of the fields with a string labeling them
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Particle [mass=" + mass + ", radius=" + radius + ", x=" + x
				+ ", y=" + y + ", vx=" + vx + ", vy=" + vy + "]";
	}
	
	/*
	 * Getters and Setters
	 */
	public double getAx() {
		return ax;
	}

	public void setAx(double ax) {
		this.ax = ax;
	}

	public double getAy() {
		return ay;
	}

	public void setAy(double ay) {
		this.ay = ay;
	}

	public double getX() {
		return x;
	}

	public void addX(double x) {
		this.x += x;
	}

	public double getY() {
		return y;
	}

	public void addY(double y) {
		this.y += y;
	}

	public double getVx() {
		return vx;
	}

	public void addVx(double vx) {
		this.vx += vx;
	}

	public double getVy() {
		return vy;
	}

	public void addVy(double vy) {
		this.vy += vy;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
}
