package gr.teic.ie.oop2.paint;

import gr.teic.ie.oop2.paint.logger.FileTextLogger;
import java.awt.Color;
import java.awt.Graphics;

abstract class MyBoundedShape implements MyShape {

    private int x1, y1, x2, y2; //coordinates of shape
    private Color color; // color of shape
    private String text = "";
    private boolean fill; //boolean variable that determines whether the shape is filled or not

    public MyBoundedShape() {
        x1 = 0;
        y1 = 0;
        x2 = 0;
        y2 = 0;
        color = Color.BLACK;
        fill = false;
    }

    public MyBoundedShape(int x1, int y1, int x2, int y2, Color color, boolean fill) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
        this.fill = fill;
    }

    //Mutator methods
    /**
     * set fill
     */
    public void setFill(boolean fill) {
        this.fill = fill;
    }

    /**
     * Mutator method for x1
     */
    public void setX1(int x1) {
        this.x1 = x1;
    }

    /**
     * Mutator method for y1
     */
    public void setY1(int y1) {
        this.y1 = y1;
    }

    /**
     * Mutator method for x2
     */
    public void setX2(int x2) {
        this.x2 = x2;
    }

    /**
     * Mutator method for y2
     */
    public void setY2(int y2) {
        this.y2 = y2;
    }

    /**
     * Mutator method for color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Mutator method for text
     */
    public void setText(String text) {
        this.text = text;
        //Logging
        new FileTextLogger().writeLog("Shape text changed.");
    }

    /**
     * Accessor method for x1
     */
    public int getX1() {
        return x1;
    }

    /**
     * Accessor method for y1
     */
    public int getY1() {
        return y1;
    }

    /**
     * Accessor method for x2
     */
    public int getX2() {
        return x2;
    }

    /**
     * Accessor method for y2
     */
    public int getY2() {
        return y2;
    }

    /**
     * Accessor method for color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Accessor method for text
     */
    public String getText() {
        return text;
    }

    /**
     * gets the upper left x
     */
    public int getUpperLeftX() {
        return Math.min(getX1(), getX2());
    }

    /**
     * gets the upper left y
     */
    public int getUpperLeftY() {
        return Math.min(getY1(), getY2());
    }

    /**
     * gets width
     */
    public int getWidth() {
        return Math.abs(getX1() - getX2());
    }

    //Accessor methods
    /**
     * gets height
     */
    public int getHeight() {
        return Math.abs(getY1() - getY2());
    }

    /**
     * return fill
     */
    public boolean getFill() {
        return fill;
    }

    /**
     * Abstract method for drawing the shape that must be overriden
     */
    abstract public void draw(Graphics g);
} // end class MyBoundedShape
