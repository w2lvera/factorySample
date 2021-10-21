/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.myShape;

import mvc.model.myShape.FillBehavior;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.RectangularShape;
import mvc.model.myShape.factory.EllipseMaker;
import mvc.model.myShape.factory.RectangleMaker;
import mvc.model.myShape.factory.ShapeMaker;

/**
 *
 * @author Netbeans
 */
public class MyShape {
    RectangularShape shape;
    ShapeMaker sm;
    FillBehavior fb;
    Color color;

    public RectangularShape getShape() {
        return shape;
    }

    public void setShape(RectangularShape shape) {
        this.shape = shape;
    }

    public FillBehavior getFb() {
        return fb;
    }

    public void setFb(FillBehavior fb) {
        this.fb = fb;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    public void draw(Graphics2D g){
        Paint p = g.getPaint();
        g.setColor(color);
        fb.draw(this, g);
        g.setPaint(p);
    }

    public MyShape(RectangularShape shape, FillBehavior fb, Color color) {
        this.shape = shape;
        this.fb = fb;
        this.color = color;
        sm = new EllipseMaker();
    }

    public MyShape() {
    }
    @Override
    public MyShape clone(){
        MyShape clone = new MyShape((RectangularShape)shape.clone(),fb,color);
        return clone;
    }
    public MyShape createNewShape(){
        MyShape clone = new MyShape();
        clone.fb = fb;
        clone.color = color;
        clone.shape = sm.createShape();
        clone.sm = sm;
        return clone;
    }

    public void setSm(ShapeMaker sm) {
        this.sm = sm;
    }
    
}
