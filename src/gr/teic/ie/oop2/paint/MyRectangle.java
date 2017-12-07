package gr.teic.ie.oop2.paint;

import gr.teic.ie.oop2.paint.logger.FileTextLogger;
import gr.teic.ie.oop2.paint.logger.LoggerFactory;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class MyRectangle extends MyBoundedShape {
    //private static int id;
    public MyRectangle() {
        super();
        super.setText("Rect_"+KeyGenerator.id++);
        //Logging
        LoggerFactory.createLogger().writeLog("Rectangle '" + getText() + "' created.");
    }

    public MyRectangle(int x1, int y1, int x2, int y2, Color color, boolean fill) {
        super(x1, y1, x2, y2, color, fill);
        super.setText("Rect_"+KeyGenerator.id++);

        //Logging
        LoggerFactory.createLogger().writeLog("Rectangle '" + getText() + "' created.");
    }

    /**
     * Overrides the draw method in MyShape.
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(getColor()); //sets the color
        if (getFill()) //determines whether fill is true or false
        {
            g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight()); //draws a filled rectangle
        } else {
            g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight()); //draws a regular rectangle
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

}
