/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adobeflashplayer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author 805619
 */
public abstract class Sprite {
    private int speed;
    private int width, height;
    private int x,y,vx,vy;
    private Color color;
    private Rectangle bounds;
    private boolean alive = true;
    

    public Sprite(int speed,int x, int y, int width, int height, Color color) {
        this.speed = speed;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.vx = (int) (Math.random() * this.speed * 2 - this.speed);
        this.vy = (int) (Math.random() * this.speed * 2 - this.speed);
        this.color = color;
        this.bounds = new Rectangle(x,y,width,height);
    }
    
    public void update() {
        this.x += this.vx;
        this.y += this.vy;
        this.bounds = new Rectangle(x,y,width,height);
        
    }
    
    public void grow(double rate) {
        this.width *= rate;
        this.height *= rate;
    }
    
    public abstract void draw(Graphics g);
    
    public int getWidth() {
        return width;
    }    

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }
    
    public int getSpeed() {
        return speed;
    }

    public void die() {
        this.alive = false;
    }

    public boolean isAlive() {
        return alive;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public void setColor() {
        this.color = Color.GREEN;
    }

    
    public boolean collide(Sprite other) {
        boolean collided = this.bounds.intersects(other.bounds); 
        if (collided) {        
            this.didCollide();
            other.didCollide();
        }
        return collided;
    }
    
    public void collideWorldBounds(int cWidth, int cHeight) {
        if (this.x < 0 || this.x + this.width > cWidth)
            this.vx = -this.vx;
        if (this.y < 0 || this.y + this.height > cHeight)
            this.vy = -this.vy;       
    }

    public Rectangle getBounds() {
        return bounds;
    }
    
    public void didCollide() {
        this.vx = -this.vx;
        this.vy = -this.vy;
        this.update();
    }
    
    
     
    
}
