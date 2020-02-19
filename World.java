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
    private ArrayList<Food> foods = new ArrayList<>();
    private ArrayList<Adobe> adobes = new ArrayList<>();
    private ArrayList<Flash> flashs = new ArrayList<>();
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Virus> viruss = new ArrayList<>();
    Timer timer;
    int frames = 0;

    public World() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/30);
        for (int i = 0; i < 20; i++) {
            int x = (int) (Math.random() * 800/2);
            int y = (int) (Math.random() * 600);
            Flash flash = new Flash(x,y);
            sprites.add(flash);
            adobes.add(flash);
            flashs.add(flash);
        }
        for (int i = 0; i < 20; i++) {
            int x = (int) (Math.random() * 800/2 + 800/2);
            int y = (int) (Math.random() * 600);
            Player player = new Player(x,y);
            sprites.add(player);
            adobes.add(player);
            players.add(player);
        }
        for (int i = 0; i < 40; i++) {
            int x = (int) (Math.random() * 800);
            int y = (int) (Math.random() * 600);
            Food food = new Food(x,y);
            foods.add(food);
            sprites.add(food);
            
        }
        for (int i = 0; i < 10; i++) {
            int x = (int) (Math.random() * 800);
            int y = (int) (Math.random() * 600);
            Virus virus = new Virus(x,y);
            viruss.add(virus);
            sprites.add(virus);
            
        }
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        frames++;
        
        for (Adobe adobe : adobes) {
            for (Food food : foods) {
                adobe.eat(food);
            }            
        }
        
        ArrayList<Flash> newFlashs = new ArrayList<>();
        ArrayList<Player> newPlayers = new ArrayList<>();
        
        for (Flash flash : flashs) {
            for (Player player : players) {
                flash.fight(player);
            }
            for (Flash otherFlash : flashs) {
                if (flash == otherFlash) continue;
                if (flash.collide(otherFlash) && Math.random() < 0.1)
                    newFlashs.add(flash.reproduce(otherFlash));
            }
        }
        for (Player player : players) {
            for (Player otherPlayer : players) {
                if (player == otherPlayer) continue;
                if (player.collide(otherPlayer) && Math.random() < 0.1)
                    newPlayers.add(player.reproduce(otherPlayer));
            }
        }
        for (Sprite sprite : sprites) {
            sprite.draw(g);
            sprite.update();
            sprite.collideWorldBounds(800,600);
        }        
        
        takeOutTheTrash();
        addNewAdobes(newFlashs, newPlayers);
    }
    
     private void addNewAdobes(ArrayList<Flash> newFlashs, ArrayList<Player> newPlayers) {
        flashs.addAll(newFlashs);
        players.addAll(newPlayers);
        sprites.addAll(newFlashs);
        sprites.addAll(newPlayers);
        
    }
    
    private void takeOutTheTrash() {
        ArrayList<Sprite> trash = new ArrayList<>();
        for (Sprite sprite : sprites) {
            if (!sprite.isAlive())
                trash.add(sprite);
        }
        sprites.removeAll(trash);
        trash.clear();
        for (Food food : foods) {
            if (!food.isAlive())
                trash.add(food);
        }
        foods.removeAll(trash);
        trash.clear();
        for (Flash flash : flashs) {
            if (!flash.isAlive())
                trash.add(flash);
        }
        flashs.removeAll(trash);
        trash.clear();
        for (Player player : players) {
            if (!player.isAlive())
                trash.add(player);
        }
        players.removeAll(trash);
        trash.clear();        
    }
    
    private class ScheduleTask extends TimerTask {
        @Override
        public void run() {
            repaint();
        }
    }
    
    
}
