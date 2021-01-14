import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	private BufferedImage canvas;
	
	public GamePanel(int width, int height) {
		setSize(new Dimension(width, height));
		canvas = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(canvas,0,0,this);
	}
	
	public void paintPixel(int x, int y, Color color) {
		canvas.setRGB(x, y, color.getRGB());
	}
}
