package numbergame;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class RectanglePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private int length = 10; // default length 

	   // draw a square of the specified length
	   @Override
	   public void paintComponent(Graphics g)
	   {
	      super.paintComponent(g);
	      g.fillRect(10, 10, length, length);
	   }

	   // validate and set length, then repaint 
	   public void setLength(int newLength)
	   {
	      // if diameter invalid, default to 10
	      length = (newLength >= 0 ? newLength : 10);
	      repaint(); // repaint panel
	   } 

	   // used by layout manager to determine preferred size
	   public Dimension getPreferredSize()
	   {
	      return new Dimension(200, 200);
	   }

	   // used by layout manager to determine minimum size
	   public Dimension getMinimumSize()
	   {
	      return getPreferredSize();
	   } 
}
