/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.myShape.factory;

import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

/**
 *
 * @author Netbeans
 */
public class RectangleMaker implements ShapeMaker {

    @Override
    public RectangularShape createShape() {
        return new Rectangle2D.Double();
    }
}
