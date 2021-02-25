package array2D;
// Photoshop program that can run several manipulations on 
// an image
// filler code by Mr. David
// Help on edge and blur from Mr.Friedman

import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class PhotoshopFiller extends Component {

	// the name of the output file. will be determined by which methods are called
    private String outputName;
    
    // the 2d array of colors representing the image
    private Color[][] pixels;
    
    // the width and height of the image 
    private int w,h;
    

    // this method increases each color's rgb value by a given amount.
    // don't forget that rgb values are limited to the range [0,255]
    public void brighten(int amount) {
    	//the file name of the brightened file
        outputName = "brightened_" + outputName;
        
        //for loop to go through the color of every pixel in the photo
        for (int i=0;i<h;i++) {
        	for (int j=0;j<w;j++) {
        		//Picks out the color of the pixel
        		Color c= pixels[i][j];
        		//adds the amount of brightness to each r,g,b value of the pixel
        		int r=c.getRed()+ amount;
        		int g=c.getGreen()+ amount;
        		int b=c.getBlue()+ amount;
        		
        		//Take cares of end cases
        		//Sets red to maximum if the red value exceeds 255
        		if (r>255) {
        			r=255;
        		}
        		//Sets red to minimum if the red value is below 0
        		if (r<0) {
        			r=0;
        		}
        		
        		//Sets green to maximum if the green value exceeds 255
        		if (g>255) {
        			g=255;
        		}
        		//Sets green to minimum if the green value is below 0
        		if (g<0) {
        			g=0;
        		}
        		//Sets blue to maximum if the blue value exceeds 255
        		if (b>255) {
        			b=255;
        		}
        		//Sets blue to minimum if the blue value is below 0
        		if (b<0) {
        			b=0;
        		}
        		
        		//Applies the new brightened color to the original pixel
        		pixels[i][j]= new Color(r,g,b);

        	}
        }
    }
    
    // flip an image either horizontally or vertically.
    public void flip(boolean horizontally) {
    	//the file name of the brightened file
        outputName = (horizontally?"h":"v") + "_flipped_" + outputName;
        
        //saves the color of the pixel while the original position is replaced with a new Color
        Color repeatedPixel;
        
        //Vertical flip
        if (horizontally!=true) {
        	//for loop to go through the color of every pixel in the front half of the photo
        	for (int i=0;i<h/2;i++) {
        		for (int j=0;j<w;j++) {
        			//saves the color of the original pixel while the original position is replaced with a new Color
        			repeatedPixel= pixels[i][j];
        			//sets the original pixel the same color to the pixel vertically symmetrical to it
        			pixels[i][j]=pixels[h-i-1][j];
        			//sets the 'symmetrical' pixel to the original pixel which is saved beforehand in 'repeatedPixel'
        			pixels[h-i-1][j]= repeatedPixel;
        		}
        	}
        }
        //Horizontal flip
        else {
        	//for loop to go through the color of every pixel in the top half of the photo
            for (int i=0;i<h;i++) {
            	for (int j=0;j<w/2;j++) {
            		//saves the color of the original pixel while the original position is replaced with a new Color
            		repeatedPixel= pixels[i][j];
            		//sets the original pixel the same color to the pixel horizontally symmetrical to it
            		pixels[i][j]=pixels[i][w-j-1];
            		//sets the 'symmetrical' pixel to the original pixel which is saved beforehand in 'repeatedPixel'
            		pixels[i][w-j-1]= repeatedPixel;
            	}
           	}

        }
    }
    
    // negates an image
    // to do this: subtract each pixel's rgb value from 255 
    // and use this as the new value
    public void negate() {
    	//the file name of the brightened file
        outputName = "negated_" + outputName;
        
        //for loop to go through the color of every pixel in the photo
        for (int i=0;i<h;i++) {
        	for (int j=0;j<w;j++) {
        		//Picks out the color of the pixel
        		Color c= pixels[i][j];
        		//subtracts the r, g, b value of the pixel from 255, to get the reverse Color
        		int r=255-c.getRed();
        		int g=255-c.getGreen();
        		int b=255-c.getBlue();
        		//sets the original pixel to the negated color
        		pixels[i][j]= new Color(r,g,b);
        	}
        }
        
    }
    
    // this makes the image 'simpler' by redrawing it using only a few colors
    // to do this: for each pixel, find the color in the list that is closest to
    // the pixel's rgb value. 
    // use this predefined color as the rgb value for the changed image.
    public void simplify() {
    
    		// the list of colors to compare the rgb values to. Feel free to change/add colors
    		Color[] colorList = {Color.BLUE, Color.RED,Color.ORANGE, Color.MAGENTA,
                Color.BLACK, Color.WHITE, Color.GREEN, Color.YELLOW, Color.CYAN};
    	//the file name of the brightened file
        outputName = "simplified_" + outputName;
        
      //for loop to go through the color of every pixel in the photo
        for (int i=0;i<h;i++) {
        	for (int j=0;j<w;j++) {
        		//Picks out the color of the pixel
        		Color c= pixels[i][j];
        		
        		//set the minimum to 256 which is one value higher than any color can get
        		double minimum=256;
        		//sets minimum color to any color in list
        		Color minColor= Color.black;
        		//for loop to go through each color in the list
        		for (int z=0;z<colorList.length;z++) {
        			//compares if the difference between the simplified colors and color of the pixel
        			if (distance (c,colorList[z])<minimum) {
        				//sets 'minimum' equal to the distance between the simplified and original color if they are smaller 
        				//than the minimum
        				minimum=distance(c,colorList[z]);
        				//sets the Color with the minimum distance
        				minColor= colorList[z];
        			}
        		}
        		//sets the original color the Color closest to the original color
        		pixels[i][j]= minColor;
        	}
        }
         
    }
    
    // optional helper method (recommended) that finds the 'distance' 
    // between two colors.
    // use the 3d distance formula to calculate
    public double distance(Color c1, Color c2) {
    	//gets r,g,b values for both color c1 and c2
		int r1=c1.getRed(),r2=c2.getRed();
		int g1=c1.getGreen(),g2=c2.getGreen();
		int b1=c1.getBlue(),b2=c2.getBlue();
		
		//finds out distance between them using the 3d distance formula
    	double distance=Math.sqrt((r1-r2)*(r1-r2) +(g1-g2)*(g1-g2)+ (b1-b2)*(b1-b2));
    	//returns distance
    	return distance;	
    }
    
    // this blurs the image
    // to do this: at each pixel, sum the 8 surrounding pixels' rgb values 
    // with the current pixel's own rgb value. 
    // divide this sum by 9, and set it as the rgb value for the blurred image
    public void blur() {
    	//the file name of the brightened file
		outputName = "blurred_" + outputName;
		//blank canvas to fill new Colors in
		Color[][]pixels2 = new Color [h][w];
		//for loop to go through the color of every pixel in the photo
		for (int i=0;i<h;i++) {
	       	for (int j=0;j<w;j++) {
	       		//Sums of each r,g,b values
	    		int redSum=0;
	    		int greenSum=0;
	    		int blueSum=0;
	    		//Makes the Edge case pixels black
	    		if (i==0||j==0||i==h-1||j==w-1) {
	    			pixels2[i][j]=Color.black;
	    		}
	    		else {
	    			//for loops going through the 3 by 3 squares 
		       		for (int z=i-1;z<i+2;z++) {
		       			for (int s=j-1;s<j+2;s++) {
		       			//adds the sum of the r g b values of the squares
		       				redSum+=pixels[z][s].getRed();
		       				greenSum+=pixels[z][s].getGreen();
		       				blueSum+=pixels[z][s].getBlue();
		       			}
		       		}
		       		//finds the average color of the 8 surrouning pixels including the current position.
		       		pixels2[i][j]=new Color (redSum/9,greenSum/9,blueSum/9);
	    		}
	       	}
		}
		pixels=pixels2;
	}
    
    // this highlights the edges in the image, turning everything else black. 
    // to do this: at each pixel, sum the 8 surrounding pixels' rgb values. 
    // now, multiply the current pixel's rgb value by 8, then subtract the sum.
    // this value is the rgb value for the 'edged' image
    public void edge() {
    	//the file name of the brightened file
        outputName = "edged_" + outputName;
        Color[][]pixels2 = new Color [h][w];
        //for loop to go through the color of every pixel in the photo
		for (int i=0;i<h;i++) {
	       	for (int j=0;j<w;j++) {
	       		//initiates the total sum of r,g,b values
	    		int redSum=0;
	    		int greenSum=0;
	    		int blueSum=0;
	    		//makes the Edge case pixels black
	    		if (i==0||j==0||i==h-1||j==w-1) {
	    			pixels2[i][j]=Color.black;
	    		}
	    		else {
	    			//for loops going through the 3 by 3 squares 
		       		for (int z=i-1;z<i+2;z++) {
		       			for (int s=j-1;s<j+2;s++) {
		       				//adds the sum of the r g b values of the squares
		       				redSum+=pixels[z][s].getRed();
		       				greenSum+=pixels[z][s].getGreen();
		       				blueSum+=pixels[z][s].getBlue();
		       			}
		       		}
		       		//multiplies the rgb value by 9 then subtracts the sum
		       		int redValue= -redSum+(pixels[i][j].getRed()*9);
		       		int greenValue= -greenSum+(pixels[i][j].getGreen()*9);
		       		int blueValue= -blueSum+(pixels[i][j].getBlue()*9);
		       	
		       		//Take cares of end cases
	        		//Sets red to maximum if the red value exceeds 255
	        		if (redValue>255) {
	        			redValue=255;
	        		}
	        		//Sets red to minimum if the red value is below 0
	        		if (redValue<0) {
	        			redValue=0;
	        		}
	        		//Sets green to maximum if the green value exceeds 255
	        		if (greenValue>255) {
	        			greenValue=255;
	        		}
	        		//Sets green to minimum if the green value is below 0
	        		if (greenValue<0) {
	        			greenValue=0;
	        		}
	        		//Sets blue to maximum if the blue value exceeds 255
	        		if (blueValue>255) {
	        			blueValue=255;
	        		}
	        		//Sets blue to minimum if the blue value is below 0
	        		if (blueValue<0) {
	        			blueValue=0;
	        		}
	        		//Applies the new brightened color to the blank canvas
	        		pixels2[i][j]=new Color (redValue,greenValue,blueValue);
	    		}
	    	
	       		
	       	}
		}
		//Transfers the image on the blank canvas to the original image
		pixels=pixels2;
    }
    
    //Makes the photo greyscaled
    //averages the r,g,b values of the pixel
    public void greyscale () {
    	//the file name of the brightened file
    	outputName = "greyscaled_" + outputName;
    	
    	//for loop to go through the color of every pixel in the photo
    	for (int i=0;i<h;i++) {
    		for (int j=0;j<w;j++) {
    			//Picks out the color of the pixel
    			Color c= pixels[i][j];
    			//finds out the rgb values of the pixel
    			int r=c.getRed();
        		int g=c.getGreen();
        		int b=c.getBlue();
        		//finds the average of the three r g b values
        		int average= (r+g+b)/3;
        		
        		//sets the original pixel to the averaged r g b values
        		pixels[i][j]=new Color (average,average,average);
    		}
    	}
    }
    
    //pixelates the photo
    //size of the pixel is determined by user input
    public void pixel (int size) {
    	//the file name of the brightened file
    	outputName = "pixelated_" + outputName;
    	
    	//for loop to go through the color of every pixel in the photo
    	for (int i=0;i<h-size+(h%size);i+=size) {
    		for (int j=0;j<w-size+(w%size);j+=size) {
    			//initiates the total sum of r,g,b values
    			int redSum=0;
	    		int greenSum=0;
	    		int blueSum=0;
	    		//for loop to go through the section that will be pixelated (filled in with the same color)
	    		//finds the total sum of the section of the pixel
	    		for (int x=i;x<i+size && x<h;x++) {
	    			for (int y=j;y<j+size && y<w;y++) {
	    				//adds the sum of the r g b values of the squares
	    				redSum+=pixels[x][y].getRed();
	       				greenSum+=pixels[x][y].getGreen();
	       				blueSum+=pixels[x][y].getBlue();
	    			}
	    		}
	    		//for loop to go through the section that will be pixelated (filled in with the same color)
	    		//actually applies the color to the section that will be pixelated.
	    		for (int x=i;x<i+size && x<h;x++) {
	    			for (int y=j;y<j+size && y<w;y++) {
	    				pixels[x][y]=new Color (redSum/(size*size), greenSum/(size*size),blueSum/(size*size));
	    			}
	    		}
    		}

    	}
    }
    
    //Makes image look more contrasted (darker portions look darker, brighter portions look brighter)
    //Degree of contrast is determined through user input
    public void contrast (int degree) {
    	//the file name of the brightened file
    	outputName= "contrasted_"+outputName;
    	//the half hexadecimal value to determine whether or not the pixel will become darker or brighter
    	int half= 128;
    	//for loop to go through the color of every pixel in the photo
    	for (int i=0;i<h;i++) {
    		for (int j=0;j<w;j++) {
    			//Picks out the color of the pixel
    			Color c= pixels[i][j];
    			//finds out the rgb values of the pixel
    			int r=c.getRed();
        		int g=c.getGreen();
        		int b=c.getBlue();
        		
        		//adds red value by the degree of contrast if it is bigger of equal to half
        		if (r>=half) {
        			r+=degree;
        		}
        		//subtracts red value by the degree of contrast if it is small than half
        		else {
        			r-=degree;
        		}
        		//adds green value by the degree of contrast if it is bigger of equal to half
        		if (g>=half) {
        			g+=degree;
        		}
        		//subtracts red value by the degree of contrast if it is small than half
        		else {
        			g-=degree;
        		}
        		//adds blue value by the degree of contrast if it is bigger of equal to half
        		if (b>=half) {
        			b+=degree;
        		}
        		//subtracts red value by the degree of contrast if it is small than half
        		else {
        			b-=degree;
        		}
        		
        		
        		//Take cares of end cases
        		//Sets red to maximum if the red value exceeds 255
        		if (r>255) {
        			r=255;
        		}
        		//Sets red to minimum if the red value is below 0
        		if (r<0) {
        			r=0;
        		}
        		//Sets green to maximum if the green value exceeds 255
        		if (g>255) {
        			g=255;
        		}
        		//Sets green to minimum if the green value is below 0
        		if (g<0) {
        			g=0;
        		}
        		//Sets blue to maximum if the blue value exceeds 255
        		if (b>255) {
        			b=255;
        		}
        		//Sets blue to minimum if the blue value is below 0
        		if (b<0) {
        			b=0;
        		}
        		//sets pixel color to contrasted color
        		pixels[i][j]=new Color (r,g,b);
        		
    		}
    	}
    }
    	
    
    // *************** DON'T MESS WITH THE BELOW CODE **************** //
    
    // feel free to check it out, but don't change it unless you've consulted 
    // with Mr. David and understand what the code's doing
    
    

    public void run() {
    	JFileChooser fc = new JFileChooser();
		File workingDirectory = new File(System.getProperty("user.dir")+System.getProperty("file.separator")+ "Images");
		//fc.setCurrentDirectory(workingDirectory);
		fc.showOpenDialog(null);
		File my_file = fc.getSelectedFile();
		if (my_file == null)
			System.exit(-1);
		
		// reads the image file and creates our 2d array
        BufferedImage image;
		try {
			image = ImageIO.read(my_file);
		
	        BufferedImage new_image = new BufferedImage(image.getWidth(),
	                        image.getHeight(), BufferedImage.TYPE_INT_ARGB);
	        create_pixel_array(image);
			outputName = my_file.getName();
			
			// runs the manipulations determined by the user
			System.out.println("Enter the manipulations you would like to run on the image.\nYour "
					+ "choices are: brighten, flip, negate, blur, edge, simplify, greyscale, pixel or contrast.\nEnter each "
					+ "manipulation you'd like to run, then type in 'done'.");
			Scanner in = new Scanner(System.in);
			String action = in.next().toLowerCase();
			while (!action.equals("done")) {
	    			try {
		    			if (action.equals("brighten")) {
		    				System.out.println("enter an amount to increase the brightness by");
		    				int brightness = in.nextInt();
		        			Method m = getClass().getDeclaredMethod(action, int.class);
		        			m.invoke(this, brightness);
		    			}
		    			else if (action.equals("flip")) {
		    				System.out.println("enter \"h\" to flip horizontally, anything else to flip vertically.");
		        			Method m = getClass().getDeclaredMethod(action, boolean.class);
		        			m.invoke(this, in.next().equals("h"));
		        			
		    			}
		    			else if (action.equals("contrast")) {
		    				System.out.println("enter the degree of contrast");
		    				int degree = in.nextInt();
		        			Method m = getClass().getDeclaredMethod(action, int.class);
		        			m.invoke(this, degree);
		    			}
		    			
		    			else if (action.equals("pixel")) {
		    				System.out.println("enter the size of the pixel");
		    				int size = in.nextInt();
		        			Method m = getClass().getDeclaredMethod(action, int.class);
		        			m.invoke(this, size);
		    			}
		    			else {
		        			Method m = getClass().getDeclaredMethod(action);
		        			m.invoke(this, new Object[0]);
		    			}
		    			System.out.println("done. enter another action, or type 'done'");
	    			}
	    			catch (NoSuchMethodException e) {
	    				System.out.println("not a valid action, try again");
	    			} catch (IllegalAccessException e) {e.printStackTrace();System.exit(1);} 
	    			catch (IllegalArgumentException e) {e.printStackTrace();System.exit(1);}
	    			catch (InvocationTargetException e) {e.printStackTrace();System.exit(1);}
	    			
	    			action = in.next().toLowerCase();
	    		} 
	        in.close();
	        
	        // turns our 2d array of colors into a new png file
	        create_new_image(new_image);
	        File output_file = new File("Images/" + outputName);
	        ImageIO.write(new_image, "png", output_file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
		
    
    public void create_pixel_array(BufferedImage image) {
        w = image.getWidth();
        h = image.getHeight();
        pixels = new Color[h][];
        for (int i = 0; i < h; i++) {
            pixels[i] = new Color[w];
            for (int j = 0; j < w; j++) {
                pixels[i][j] = new Color(image.getRGB(j,i));
            }
        }
    }

    public void create_new_image(BufferedImage new_image) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
            		new_image.setRGB(j, i, pixels[i][j].getRGB());
            }
        }
    }

    public static void main(String[] args) {
		new PhotoshopFiller();
	}

    public PhotoshopFiller() {
		run();
    }
}