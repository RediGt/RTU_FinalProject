package pac01;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ImageImplement extends JPanel {
	private Image img;
	private int picWidth;
	private int picHeigth;
	
	public ImageImplement(Image img, int width, int height) {
		this.img = img;
		this.picWidth = width;
		this.picHeigth = height;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, picWidth, picHeigth, null);
	}
}
