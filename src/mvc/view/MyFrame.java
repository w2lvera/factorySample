/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import mvc.controller.Controller;
import mvc.model.myShape.factory.EllipseMaker;
import mvc.model.myShape.factory.RectangleMaker;

/**
 *
 * @author Netbeans
 */
public class MyFrame extends JFrame{
    MyPanel panel;
 Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public MyFrame(MyPanel panel) {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu action = new JMenu("фигура");
        JMenuItem rect = new JMenuItem("прямоугольник");
        JMenuItem ellips = new JMenuItem("овал");
        action.add(rect);
        action.add(ellips);
        menuBar.add(action);
        rect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setRectangularShape(new RectangleMaker() );
            }
        });
        ellips.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setRectangularShape(new EllipseMaker() );
            }
        });
    
        this.panel = panel;
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
    }
    
}
