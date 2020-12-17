/**
 *Etude 05
 *@author Alfred J Pardoe
 *@id 7150195
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class QuiltPanel extends JPanel{
    static ArrayList<String> layers = new ArrayList<String>();
    static ArrayList<Rectangle> objects = new ArrayList<Rectangle>();
    int x, y, s, r, g, b;
    

    public QuiltPanel(){
	
        Scanner sc = new Scanner(System.in);
	String firstLayer = sc.nextLine();
	//add each line in the file as a layer into the list 
        while(sc.hasNextLine()){
            layers.add(sc.nextLine());
        }

        //Create first square only
        String[] layer1 = firstLayer.split(" ");
	//Try and determine the best size window and fit of that window
	int window;
	int standard;
	if(Double.parseDouble(layer1[0]) >= 3.0){
	    window = 1250;
	    standard = 180;
	}else if(Double.parseDouble(layer1[0]) <= 1.0){
	    window = 700;
	    standard = 300;
	}else{
	    window = 1000;
	    standard = 400;
	}

        s = (int) (Double.parseDouble(layer1[0]) * standard);
        r = Integer.parseInt(layer1[1]);
        g = Integer.parseInt(layer1[2]);
        b = Integer.parseInt(layer1[3]);
        x = (window / 2) - (s / 2);
	y = x;
        //add first square to list objects
        Rectangle rect = new Rectangle(x, y, s, r, g, b);
        objects.add(rect);
	
	//add layer by layer
        int offset = 0;
	int range = 1;
	int prev = 1;
	int a = 0;
        while(a < layers.size()){
	    addLayer(a, offset, range, standard);
	    offset = range;
	    a++;
	    range = objects.size();
	}

        setPreferredSize(new Dimension(window, window));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(Rectangle r : objects){
            r.draw(g);
        }
        
    }

    public void addLayer(int a, int offset, int range, int standard){
	//for the given layer, initialise needed information from the file line
	String[] layer = layers.get(a).split(" ");
	s = (int) (Double.parseDouble(layer[0]) * standard);
	r = Integer.parseInt(layer[1]);
	g = Integer.parseInt(layer[2]);
	b = Integer.parseInt(layer[3]);
	//for each square in the previous layer, add four to its corners. 
	for(int k = offset; k < range; k++){
	    Rectangle p = objects.get(k);
	    for(int u = 0; u < 4; u++){
		addTopLeft(p.getTopLeftX(), p.getTopLeftY(), s, r, g, b);
		addTopRight(p.getTopRightX(), p.getTopRightY(), s, r, g, b);
		addBotLeft(p.getBotLeftX(), p.getBotLeftY(), s, r, g, b);       
		addBotRight(p.getBotRightX(), p.getBotRightY(), s, r, g, b);
	    } 
	}
    }

    //Adds new square to top left of current square
    public void addTopLeft(int x, int y, int s, int r, int g, int b){
	Rectangle rect = new Rectangle(x - (s / 2), y - (s / 2), s, r, g, b);
	objects.add(rect);
    }

    //Adds new square to top left of current square
    public void addTopRight(int x, int y, int s, int r, int g, int b){
	Rectangle rect = new Rectangle(x - (s / 2), y - (s / 2), s, r, g, b);
	objects.add(rect);
    }

    //Adds new square to top left of current square
    public void addBotLeft(int x, int y, int s, int r, int g, int b){
	Rectangle rect = new Rectangle(x - (s / 2), y - (s / 2), s, r, g, b);
	objects.add(rect);
    }

    //Adds new square to top left of current square
    public void addBotRight(int x, int y, int s, int r, int g, int b){
	Rectangle rect = new Rectangle(x - (s / 2), y - (s / 2), s, r, g, b);
	objects.add(rect);
    }

}//end class
