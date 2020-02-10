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
public class Adobe extends Sprite {
    private static final int WIDTH = 10;
    private static final int HEIGHT = 15;
    
    
    public Adobe(int speed, int x, int y, Color color) {
        super(speed, x, y, WIDTH, HEIGHT, color);
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(super.getColor());
        g.fillRect(super.getY(), super.getX(), super.getWidth(), super.getHeight());
    }
}
