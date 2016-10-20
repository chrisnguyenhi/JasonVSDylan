import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class cnguyen7_Animator {
	EZImage Actor;
	int x, y, startx, starty;
	int destx, desty;
	long starttime;
	long duration;
	boolean doingsumshit;
	int angle;
	Scanner fileScanner;
	String command;
	long dur = 1;
	int startangle;
	int destangle;
	double scale;
	double startscale;
	double targetscale;

	public cnguyen7_Animator(String filename, String picname, int placex,
			int placey) throws IOException {

		Actor = EZ.addImage(picname, placex, placey);
		duration = (dur * 1000);
		starttime = System.currentTimeMillis();
		startx = Actor.getXCenter();
		starty = Actor.getYCenter();
		startangle = (int) Actor.getRotation();
		startscale = Actor.getScale();
		fileScanner = new Scanner(new FileReader(filename));
	}

	public void go() {

		if (doingsumshit == true) {
			float normTime = (float) (System.currentTimeMillis() - starttime)
					/ (float) duration;

			x = (int) (startx + ((float) (destx - startx) * normTime));

			y = (int) (starty + ((float) (desty - starty) * normTime));

			angle = (int) (startangle + (destangle - startangle) * normTime);

			scale = (double) (startscale + (targetscale - startscale)
					* normTime);

			if ((System.currentTimeMillis() - starttime) >= duration) {
				doingsumshit = false;
				x = destx;
				y = desty;
				angle = destangle;
				scale = targetscale;
			}
			Actor.translateTo(x, y);
			Actor.rotateTo(angle);
			Actor.scaleTo(scale);
		} else {
			if (fileScanner.hasNext()) {
				command = fileScanner.next();
				switch (command) {
				case "action": // Tri-Command. You can use it to do three
								// commands at one time
					doingsumshit = true;
					destx = fileScanner.nextInt(); // Note that every command is
													// in relative to the
													// current location, scale
													// and angle of the actor
													// after every command
					desty = fileScanner.nextInt(); // In this case, if you don't
													// wanna move, set the x
													// and y to the current x
													// and y location of the
													// actor
					destangle = fileScanner.nextInt(); // In this case, if you
														// don't wanna rotate,
														// set rotate in the
														// script to 0
					targetscale = fileScanner.nextDouble(); // In this case, just
															// if you don't
															// wanna scale, set
															// the scale in the
															// script to 1
					dur = fileScanner.nextLong();
					startx = Actor.getXCenter();
					starty = Actor.getYCenter();
					starttime = System.currentTimeMillis();
					duration = (dur * 1000);
					startangle = (int) Actor.getRotation();
					startscale = Actor.getScale();
					break;
				case "move": // Basic movement
					doingsumshit = true;
					destx = fileScanner.nextInt();
					desty = fileScanner.nextInt(); // Takes you to the x and y
													// coordinate you wanna go
					dur = fileScanner.nextLong();
					startx = Actor.getXCenter();
					starty = Actor.getYCenter();
					starttime = System.currentTimeMillis();
					duration = (dur * 1000);
					startangle = (int) Actor.getRotation();
					startscale = Actor.getScale();
					targetscale = Actor.getScale();

					break;
				case "rotate": // Basic rotation
					doingsumshit = true;
					destangle = fileScanner.nextInt(); // Takes you to the angle
														// you wanna go to
					dur = fileScanner.nextLong();
					startx = Actor.getXCenter();
					starty = Actor.getYCenter();
					starttime = System.currentTimeMillis();
					startangle = (int) Actor.getRotation();
					duration = (dur * 1000);
					startscale = Actor.getScale();
					targetscale = Actor.getScale();

					break;
				case "scale": // Basic scaling
					doingsumshit = true;
					targetscale = fileScanner.nextDouble(); // Multiplies your
															// original size by
															// the amount you
															// wanna scale to
					dur = fileScanner.nextLong();
					startx = Actor.getXCenter();
					starty = Actor.getYCenter();
					starttime = System.currentTimeMillis();
					startscale = Actor.getScale();
					startangle = (int) Actor.getRotation();
					duration = (dur * 1000);

					break;
				case "swerve": // Dual-Command: Rotate and Scale. Use it to tilt
								// and fatten your actor at the same time.
					doingsumshit = true;
					destangle = fileScanner.nextInt(); // Basically a dual usage
														// of case "rotate" and
														// case "scale"
					targetscale = fileScanner.nextDouble();
					dur = fileScanner.nextLong();
					startx = Actor.getXCenter();
					starty = Actor.getYCenter();
					starttime = System.currentTimeMillis();
					startangle = (int) Actor.getRotation();
					duration = (dur * 1000);
					startscale = Actor.getScale();

					break;
				case "die": // Kills or hides the actor (To revive use the
							// "live" case)
					doingsumshit = true;
					dur = fileScanner.nextLong();
					duration = (dur * 100); // Reason why we need a dur for die
											// is in case you want to do a
											// flashing effect when mixing die
											// and live. Duration is faster to
											// make a flashing effect
					targetscale = Actor.getScale();
					startx = Actor.getXCenter();
					starty = Actor.getYCenter();
					starttime = System.currentTimeMillis();
					startscale = Actor.getScale();
					startangle = (int) Actor.getRotation();
					destx = Actor.getXCenter();
					desty = Actor.getYCenter();
					Actor.hide();
					break;
				case "live": // Brings back actor from Java Hell
								// and shows the actor (Java Reincarnation) to
								// emulate "flash"
					doingsumshit = true;
					dur = fileScanner.nextLong(); // Reason why we need a dur
													// for live is in case you
													// want to do a flashing
													// effect when using die
													// and live
					duration = (dur * 100); // Duration is faster to make a
											// flashing effect
					targetscale = Actor.getScale();
					startx = Actor.getXCenter();
					starty = Actor.getYCenter();
					starttime = System.currentTimeMillis();
					startscale = Actor.getScale();
					startangle = (int) Actor.getRotation();
					destx = Actor.getXCenter();
					desty = Actor.getYCenter();
					Actor.show();
					break;
				case "standby": // Tell the actor to remain as it is and at
								// where it is at
					doingsumshit = true;
					dur = fileScanner.nextLong();
					duration = (dur * 1000);
					targetscale = Actor.getScale();
					startx = Actor.getXCenter();
					starty = Actor.getYCenter();
					starttime = System.currentTimeMillis();
					startscale = Actor.getScale();
					startangle = (int) Actor.getRotation();
					destx = Actor.getXCenter();
					desty = Actor.getYCenter();
					break;
				}
			}
		}
	}
}
