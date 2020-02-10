/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adobeflashplayer;

import java.awt.Color;

/**
 *
 * @author 805619
 */
public class Flash extends Adobe {
    private static final int SPEED = 5;
    private static final Color COLOR = Color.BLUE;
        
    public Flash(int x, int y) {
        super(SPEED, x, y, COLOR);
    } 
}
