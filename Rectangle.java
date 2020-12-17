/**
 *Etude 05
 *@author Alfred J Pardoe
 *@id 7150195
 */

import java.awt.*;
import javax.swing.*;

public class Rectangle{
    private Color fill;
    private int size, x, y, red, green, blue;

    public Rectangle(int x, int y, int size, int red, int green, int blue){
        this.size = size;
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.x = x;
	this.y = y;
    }

    public int getTopLeftX(){
        return x;
    }

    public int getTopLeftY(){
        return y;
    }

    public int getTopRightX(){
	return x + size;
    }

    public int getTopRightY(){
	return y;
    }

    public int getBotLeftX(){
	return x;
    }

    public int getBotLeftY(){
	return y + size;
    }

    public int getBotRightX(){
	return x + size;
    }

    public int getBotRightY(){
	return y + size;
    }

    public int getSize(){
	return size;
    }

    public void draw(Graphics g){
        Color fill = new Color(red, green, blue);
        g.setColor(fill);
        g.fillRect(x, y, size, size);
    }
}
