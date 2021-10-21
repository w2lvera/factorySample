/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

import mvc.model.myShape.MyShape;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Observable;
import mvc.model.myShape.factory.ShapeMaker;

/**
 *
 * @author Netbeans
 */
public class Model extends Observable{
    MyShape shape;
    MyShape currentShape;
    ArrayList<MyShape> listShape;

    public Model() {
        listShape = new ArrayList<>();
    }

    
    
    public void mouseDragged(Point2D[] p) {
        currentShape.getShape().setFrameFromDiagonal(p[0], p[1]);
        setChanged();
        notifyObservers();
    }

    public void draw(Graphics2D g2) {
         for(MyShape x:listShape)
            x.draw(g2);
        
    }

    public void setShape(MyShape shape) {
       this.shape = shape;
    }

    public void setShapeMaker(ShapeMaker shapeMaker) {
        shape.setSm(shapeMaker);
    }

    public void mousePressed() {
       currentShape = shape.createNewShape();
       listShape.add(currentShape);
    }
    
}
