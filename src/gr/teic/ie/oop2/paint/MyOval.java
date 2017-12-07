package gr.teic.ie.oop2.paint;

import gr.teic.ie.oop2.paint.logger.FileTextLogger;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 * This class inherits from MyBoundedShape and is responsible for drawing a oval.
 */
public class MyOval extends MyBoundedShape {

    public MyOval() {
        super();
        
        //Logging
        new FileTextLogger().writeLog("Oval '" + getText() + "' created.");
    }

    public MyOval(int x1, int y1, int x2, int y2, Color color, boolean fill) {
        super(x1, y1, x2, y2, color, fill);
        
        //Logging
        new FileTextLogger().writeLog("Oval '" + getText() + "' created.");
    }

    /**
     * Overrides the draw method in MyShape.
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(getColor()); //sets the color
        if (getFill()) //determines whether fill is true or false
        {
            g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight()); //draws a filled oval
        } else {
            g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight()); //draws a regular oval
        }

        // Draw string
        FontMetrics metrics = g.getFontMetrics(g.getFont());
        int x = getUpperLeftX() + (getWidth() - metrics.stringWidth(getText())) / 2;
        int y = getUpperLeftY() + ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
        if (getFill()) {
            g.setColor(new Color(255 - getColor().getRed(), 255 - getColor().getGreen(), 255 - getColor().getBlue()));
        }
        g.drawString(getText(), x, y);
    }

} // end class MyOval
