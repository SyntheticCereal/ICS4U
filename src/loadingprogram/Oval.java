package loadingprogram;

import java.awt.Color;
import java.awt.Graphics;

public class Oval {
	public double  x, y, r, angle;
	public int cx, cy, j, cc;
	public Color c, c2, c3, c4, c5, c6;
	public boolean reverse;

	public Oval(double x, double y, double r, double angle, int cy, int cx) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.angle = angle;
		this.cy = cy;
		this.cx = cx;
	}

	public void DrawReverseOval (Graphics g) {
		g.fillOval((int)x-1,(int)y-1, 15, 15);
	}

	public void DrawOval (Graphics g) {
		g.setColor(c3);
		g.fillOval((int)x,(int)y, 10,10);
		j++;
	}
	
	public void SpiralCalculation () {
		if (!reverse) {
			r += 0.15;
			angle += 0.5*cc;
		}
		else {
			r -= 0.15; 
			angle -= 0.5*cc;
		}

		if (r > 150) {	
			reverse = true;
			j=0;
		}
		if (r < 0.0) {
			reverse = false;				
			cc*=-1;
			r = 0.0;
			j=0;
		}
	}

	public void OvalCalculation (double r, double angle, int cx, int cy) {
		x = (cx + r*Math.cos(angle));
		y = (cy + r*Math.sin(angle));
	}


}
