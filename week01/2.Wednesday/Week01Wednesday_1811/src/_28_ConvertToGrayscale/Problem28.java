package _28_ConvertToGrayscale;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Problem28 {// extends JPanel
	// ConvertToGrayscale
	public static void convertToGreyscale(String imgPath) {
	}

	public static double lum(Color color) { // Compute luminance of color.
		int r = color.getRed();
		int g = color.getGreen();
		int b = color.getBlue();
		return .299 * r + .587 * g + .114 * b;
	}

	public static Color toGray(Color color) { // Use luminance to convert to
												// grayscale.
		int y = (int) Math.round(lum(color)); // y-luminance of arg color
		Color gray = new Color(y, y, y);
		return gray;
	}

	public static boolean compatible(Color a, Color b) { // Print true if colors
															// are compatible,
															// false otherwise,
		return Math.abs(lum(a) - lum(b)) >= 128; // a[] - values or args
	}

	private static Color toColor(int intRGB) {
		int r = (intRGB >> 16) & 0xFF;
		int g = (intRGB >> 8) & 0xFF;
		int b = (intRGB) & 0xFF;
		return new Color(r, g, b);
	}

	private static void testImage(String pictureName) {
		try {
			File img_src = new File(pictureName);
			BufferedImage image = ImageIO.read(img_src);

			BufferedImage img = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
			File f = new File("Grayscale_" + pictureName);
			int r = 5;
			int g = 25;
			int b = 255;
			int col = (r << 16) | (g << 8) | b;
			for (int x = 0; x < image.getWidth(); x++) {
				for (int y = 0; y < image.getHeight(); y++) {
					col = image.getRGB(x, y);
					Color c = toColor(col);// new Color(col);
					c = toGray(c);
					img.setRGB(x, y, c.getRGB());
					// img.setRGB(x, image.getHeight()-1-y, c.getRGB());
				}
			}
			ImageIO.write(img, "PNG", f);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * private static final long serialVersionUID = 1L; private BufferedImage
	 * image;
	 * 
	 * public ConvertToGrayscale() { setMinimumSize(new Dimension(400,200));
	 * 
	 * try { //Load the image image = ImageIO.read(new File("C:/image.png")); }
	 * catch (IOException e) { e.printStackTrace(); } }
	 * 
	 * @Override public void paintComponent(Graphics g) {
	 * super.paintComponent(g); Graphics2D g2d = (Graphics2D) g.create();
	 * //Paint it on screen g2d.drawImage(image, 0, 0, image.getWidth(),
	 * image.getHeight(), null); g2d.dispose(); }
	 * 
	 * public static void main(String[] args) { JFrame window = new JFrame(
	 * "An Image On Screen"); window.add(new ImageScreen());
	 * window.setLocationRelativeTo(null);
	 * window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); window.pack();
	 * window.setVisible(true); }
	 * 
	 * }
	 */
	public static void main(String[] args) {
		testImage("ft0088.jpg");
	}
}
