import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Lorenz extends JFrame {
	final static int s = 600;
	final static int ds = 1;
	final static int sc = 9;
	int i = 255;
	boolean m = false;
	static double xt = 0;
	static double yt = 0;
	static double zt = 0;
	double x = 0.1, y = 0, z = 0, dt = 0.001;
	double a = 10.0, b = 28.0, c = 8.0 / 3.0;

	Lorenz() {
		setVisible(true);
		setTitle("Lorenz");
		setBounds(100, 100, s, s);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setBackground(new Color(0, 0, 0));
	}

	public void paint(Graphics g) {
		g.setColor(new Color(i / 2, i / 2, i));
		if (i > 25 && !m) {
			i--;
		} else {
			i++;
			m = true;
			if (i == 255)
				m = false;
		}
		g.fillOval((int) (sc * x) + s / 2, (int) (-1 * (sc * y) + s / 2), ds, ds);
		run();
		repaint();
	}

	public void run() {
		xt = x + dt * a * (y - x);
		yt = y + dt * (x * (b - z) - y);
		zt = z + dt * (x * y - c * z);
		x = xt;
		y = yt;
		z = zt;
	}

	public static void main(String args[]) {
		new Lorenz();
	}
}