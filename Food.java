/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adobeflashplayer;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author 805619
 */
public class Food extends Sprite{
    private static final int WIDTH = 5;
    private static final int HEIGHT = 7;
    
   private static final int SPEED = 0;
    private static final Color COLOR = Color.GREEN;
        
    public Food(int x, int y) {
        super(SPEED, x, y,WIDTH, HEIGHT, COLOR);
    }   
    
    public void draw(Graphics g) {
        g.setColor(super.getColor());
        g.fillRect(super.getY(), super.getX(), super.getWidth(), super.getHeight());
    }
}
