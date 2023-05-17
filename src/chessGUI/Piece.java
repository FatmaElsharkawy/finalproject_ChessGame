package chessGUI;

import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public abstract class Piece {
   private String name;
   private String color;
   private int x_piece,y_piece;
  
   
   

//Constructor
   public Piece(String name, String color, int x_piece, int y_piece) {
   this.name = name;
   this.color=color;
   this.x_piece= x_piece;
   this.y_piece= y_piece;
   
}
   public Piece(Piece piece) {
	   this.name = piece.name;
	   this.color=piece.color;
	   this.x_piece= piece.x_piece;
	   this.y_piece= piece.y_piece; 
	   
	   
	
   }

//setters&getters
   
   public void setColor(String color) {
	   this.color=color;
   }
   public void setName(String name) {
	   this.name=name;
   }
   public void setLocation(int x_piece,int y_piece) {
	  this.x_piece=x_piece;
	  this.y_piece=y_piece;
   }
  
   public  int getX(){
	   return x_piece;
   }
   public  int getY(){
	   return y_piece;
   }
   public String getColor() {
	   return color;
	   }
  
   public abstract String takePathPhoto(String color); //return the photo path name of the object
   public abstract String getName();

}
   
  











