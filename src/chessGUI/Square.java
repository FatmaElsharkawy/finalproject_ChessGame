package chessGUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class Square extends JButton implements ActionListener {
	
    private int row;
    private int col;
    private Piece piece;
 

  
    public Square(int row, int col) {
        this.row = row;
        this.col = col;
        setPreferredSize(new Dimension(80, 80));
        if ((row + col) % 2 == 0) {
            setBackground(Color.white);
        } else {
            setBackground(new Color(0x937342));
        }
        setFocusable(false);
        setFocusPainted(false);
    }
    
    

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    
 
    public ImageIcon setPiece(Piece piece) {
        this.piece = piece;
        
        if (piece != null) {
        	 ImageIcon icon= new ImageIcon(piece.takePathPhoto(piece.getColor()));
        	 icon.setImage(icon.getImage().getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH)); 
             setIcon(icon); return icon;
        } 
        else return null;   
             
    }
    

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
    

    
    
	
    
}
