/**
 *Etude 05
 *@author Alfred J Pardoe
 *@id 7150195
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Quilt{

    public static void main(String [] args){
        JFrame frame = new JFrame("Etude05: Patchwork Quilt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new QuiltPanel());
        frame.pack();
        frame.setVisible(true);;
    }
}
