/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shipsinspace;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.*;


public class PlanetJButton extends RoundButton{
	
	
    int move;
    int name;
    
    Random randomNumber = new Random();
    int side = 10 + randomNumber.nextInt( 40 );
    int sunSide = 60;
    boolean goingDown = true;
    boolean goingRight = true;
    int xCord = 1 + randomNumber.nextInt( 500 );
    int yCord = 1 + randomNumber.nextInt( 280 );
    int bounds = side;
    int orbitSize;
    SolarSystem parentSolarSystem;
    
   public PlanetJButton( int identifier, SolarSystem solaSystem){
   // public PlanetJButton( int solaSystem){    
       super();
        parentSolarSystem = solaSystem;
      // name = identifier;
       
       //this.setText(""+name);
       
                randomNumber = new Random();
               int r1 = 1 + randomNumber.nextInt( 255 );
               randomNumber = new Random();
               int r2 = 1 + randomNumber.nextInt( 255 );
               randomNumber = new Random();
               int r3 = 1 + randomNumber.nextInt( 255 );
       
       if(identifier == 11){
           setBounds(new Rectangle(10, 10, 20, 20));
           setBackground(Color.white);
       }else
         if(solaSystem.solarSystem.get(identifier).name.equals("empty space")){
          this.move = 0;
         this.side = 60;
         setBounds(new Rectangle(210,110,side,side));
         setBackground(Color.green);//setBackground(Color.getHSBColor((float)r1, (float)r2, (float)r3));
         } else     
       
       if(identifier == 0){
         //setBounds(new Rectangle((buttontest.Main.screen.width/2),(buttontest.Main.screen.height/2),160,160));
         this.move = 0;
         this.side = 100;
         setBounds(new Rectangle(210,110,side,side));
         setBackground(Color.yellow);//setBackground(Color.getHSBColor((float)r1, (float)r2, (float)r3));
       }else 
       {
       this.move = 1 + randomNumber.nextInt( 3 );
       setBounds(new Rectangle(xCord,yCord,side,side));
       
       setBackground(setBackGround(identifier));
       //setBackground(solaSystem.solarSystem.get(identifier).color);
       //setBackground(Color.getHSBColor((float)r1, (float)r2, (float)r3));
       this.orbitSize = 10 + randomNumber.nextInt( 140 );
       }	
     
       
      System.out.println("Planet " + identifier + ":  r1: " +(float)r1 + "   r2: " +r2 + "   r3: " + r3); 
               
           
       
   } // end constructor
  
   public Color setBackGround(int i){
       
       ArrayList<SolarSystemObject> tempList  = new ArrayList<SolarSystemObject>();
       tempList = parentSolarSystem.solarSystem;
      //Collections.reverse(tempList);
       Color tempColor = tempList.get(i).color;
       return tempColor;
   }
   
   public void moveButton(){
       
            int newX = this.getX();
            int newY = this.getY();
       
            if (this.getX()+ this.bounds > 520 - orbitSize){
             goingDown = false;    
            }
            if (this.getY()+ this.bounds > 300 - orbitSize){
             goingRight = false;    
            }
            if (this.getX() < this.bounds + orbitSize){
             goingDown = true;    
            }
            if (this.getY()  < this.bounds + orbitSize){
             goingRight = true;    
            }
            if(goingDown){
                newX = this.getX() + move;
            }
              if(!goingDown){
               newX = this.getX() - move;   
            }
              if(goingRight){
                newY = this.getY() + move;
            }
              if(!goingRight){
               newY = this.getY() - move;   
            }
   setBounds(new Rectangle( newX, newY, this.side, this.side));
   
}

   public void moveUp(){
	   setBounds(new Rectangle( this.getX() , this.getY() -10, 20, 20));
   }
   public void moveDown(){
	   setBounds(new Rectangle( this.getX(), this.getY() + 10, 20, 20));
   }
   public void moveLeft(){
	   setBounds(new Rectangle( this.getX() - 10, this.getY(), 20, 20));
   }
   public void moveRight(){
	   setBounds(new Rectangle( this.getX() + 10, this.getY(), 20, 20));
   }
}    