package BouncingBalls;

import java.awt.*;

public class Ball {
private double diameter;
private double centerX;
private double centerY;
private Color color;
private double direction; //angle
private double speed;
private double Vx;
private double Vy;
private double radius;

public Ball(double diameter,
double centerX,
double centerY,
Color color,
double direction,
double speed){
	this.diameter=diameter;
	this.centerX=centerX;
	this.centerY=centerY;
	this.color=color;
	this.direction=direction;
	this.speed=speed;
	Vx=getVx();
	Vy=getVy();
	radius=diameter/2.0;
}

public void setColor(Color color){
	this.color=color;
}

public void setDiameter(double diameter){
	this.diameter=diameter;
	this.radius=diameter/2.0;
}

public void setDirection(double Direction){
	this.direction=direction;
}

public void setSpeed(double speed){
	this.speed=speed;
}

private double getVx(){
	 return speed*Math.cos(Math.toRadians(direction));
}

private double getVy(){
	return speed*Math.sin(Math.toRadians(direction));
}

public void move(double frame, double width, double height){
	
	
	centerX +=frame*Vx;
	
	if(centerX+radius>width){
		centerX-=centerX+radius-width; 
		Vx=-Vx;
	} else if(centerX-radius<0){
		centerX+=0-(centerX-radius);
		Vx=-Vy;
	}
	
	centerY+=frame*Vy;
	
	if(centerY+radius>height){
		centerY-=centerY+radius-height;
		Vy=-Vy;
	} else if(centerY-radius<0){
		centerY+=0-(centerY-radius);
		Vy=-Vy;
	}

	
}
}
