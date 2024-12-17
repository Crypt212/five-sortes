/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Compare;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author crypt
 */
public class ComparisonPanel extends Panel {
	public ComparisonPanel () {
		this.setPreferredSize(new Dimension(500, 500));
	}
	public void print (Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.setStroke(new BasicStroke());
		
	}
}
