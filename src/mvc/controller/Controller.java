/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import mvc.model.myShape.FillBehavior;
import mvc.model.Model;
import mvc.model.myShape.MyShape;
import mvc.model.myShape.factory.ShapeMaker;
import mvc.view.MyFrame;
import mvc.view.MyPanel;

/**
 *
 * @author Netbeans
 */
public class Controller {

    Model model;
    MyFrame frame;
    MyPanel panel;
    MyShape shape;
    static Controller controller;
    Point2D[] p;

    public void draw(Graphics2D g2) {
        model.draw(g2);
    }

   private Controller() {
        shape = new MyShape(new Rectangle2D.Double(), FillBehavior.Fill, Color.BLUE);
        model = new Model();
        model.setShape(shape);
        panel = new MyPanel(this);
        model.addObserver(panel);
        frame = new MyFrame(panel);
        frame.setController(this);
        p = new Point2D[2];

    }
   public static Controller getInstanse(){
       if(controller == null) controller = new Controller();
       return controller;
   }
    public void mousePressed(Point point) {
        p[0] = point;
        model.mousePressed();
    }

    public void mouseDragged(Point point) {
        p[1] = point;
        model.mouseDragged(p);
    }

    public void setRectangularShape(ShapeMaker shapeMaker) {
         model.setShapeMaker(shapeMaker);
    }

}
