package robit;
import robocode.*;
import robocode.ScannedRobotEvent;
//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * Robit - a robot by (your name here)
 */
public class Robit extends Robot
{
double previousEnergy = 100;
int direction = 200;

public void run() {
while(true) {
ahead(direction);
turnGunRight(360);
//turnRight(20);
}
}	/**
	 * run: Robit's default behavior
	 */


	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		double o = 0;
		double t = 0;
		double f = 0;
		double mfd = 5000;
double h = e.getHeadingRadians();
double b = e.getBearingRadians();
double bd = e.getHeading();
double d = e.getDistance();	
double v = e.getVelocity();
double h1 = getHeading();


o = 180 - h + b;
t= Math.asin((v/14) * Math.sin(o));

f = t*57.2957796;


if(bd <= 180 && h1 < 90 && d <= mfd){
turnGunLeft(f);
fire(2);
}
else if (bd > 180 && h1 < 90 && d <= mfd){
turnGunRight(f);
fire(2);
}
else if(bd < 180 && h1 < 180 && d <= mfd){
turnGunRight(f);
fire(2);
}
else if(bd > 180 && h1 < 180 && d <= mfd){
turnGunLeft(f);
fire(2);
}
else if(bd < 180 && h1 < 270 && d <= mfd){
turnGunRight(f);
fire(2);
}
else if(bd > 180 && h1 < 270 && d <= mfd){
turnGunLeft(f);
fire(2);
}
else if(bd < 180 && h1 < 360 && d <= mfd){
turnGunLeft(f);
fire(2);
}
else if(bd > 180 && h1 < 360 && d <= mfd){
turnGunRight(f);
fire(2);
}

double location = e.getBearing();

turnRight(location + 90);
double changeInEnergy = previousEnergy-e.getEnergy();
if (changeInEnergy>0 && changeInEnergy<=10) {
direction = -direction;
}


}
public void onHitByBullet(HitByBulletEvent e) {

}

public void onHitWall(HitWallEvent e) {
direction = -direction;

} 

/* if(bd > 180 && h1<= 180 && d > 180){
turnGunLeft(f);
fire(2);
	}
if(bd < 180 && h1<= 180 && d > 180){
turnGunRight(f);
fire(2);
	}
	if(bd > 180 && h1>= 180 && d > 180){
turnGunRight(f);
fire(2);
	}
if(bd < 180 && h1>= 180 && d > 108){
turnGunLeft(f);
fire(2);
	}*/
}
	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */

	
	/**
	 * onHitWall: What to do when you hit a wall
	 */


