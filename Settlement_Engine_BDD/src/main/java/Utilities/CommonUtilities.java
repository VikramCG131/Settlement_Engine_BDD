package Utilities;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class CommonUtilities {
	
	 // Method to take screenshot
		public void  screenshot() {
	        try {
	            // Create a Robot instance
	            Robot robot = new Robot();
	 
	            // Get the screen size
	            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	 
	            // Capture the screen shot as a BufferedImage
	            BufferedImage screenshot = robot.createScreenCapture(screenRect);
	 
	            // Define the output file
	            File file = new File("screenshot.png");
	 
	            // Save the screenshot to the file
	            ImageIO.write(screenshot, "png", file);
	 
	            System.out.println("Screenshot saved as screenshot.png");
	 
	        } catch (AWTException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
		
		public static String getRandomInteger()
		{
		int random = (int) (Math.floor(Math.random() * 1000) + 1);
		return ""+random;
		}
	}
