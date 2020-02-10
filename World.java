/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adobeflashplayer;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

/**
 *
 * @author 805619
 */
public class World extends JPanel {
    
    //private ArrayList<Flash> flashs = new ArrayList<>();    
    //private ArrayList<Player> players = new ArrayList<>();    
    private ArrayList<Sprite> sprites = new ArrayList<>();
    Timer timer;

    public World() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/30);
        for (int i = 0; i < 100; i++) {
            int x = (int) (Math.random() * 800/2);
            int y = (int) (Math.random() * 600);
            sprites.add(new Flash(x,y));
        }
        for (int i = 0; i < 100; i++) {
            int x = (int) (Math.random() * 800/2 + 800/2);
            int y = (int) (Math.random() * 600);
            sprites.add(new Player(x,y));
        }
        for (int i = 0; i < 40; i++) {
            int x = (int) (Math.random() * 800);
            int y = (int) (Math.random() * 600);
            sprites.add(new Food(x,y));
        }
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Sprite sprite: sprites) {
            sprite.draw(g);
            sprite.update();
            for (Sprite other: sprites) {
                if (sprite != other) {
                sprite.collide(other);
                }
            }
        }
    }
    
    private class ScheduleTask extends TimerTask {
        @Override
        public void run() {
            repaint();
        }
    }
    
    
    
    
}
