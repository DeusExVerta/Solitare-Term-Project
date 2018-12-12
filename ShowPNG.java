/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitare;
    
    import java.awt.*; 
import javax.swing.*; 

@SuppressWarnings("serial")
public class ShowPNG extends JFrame
{    

  public void showcard(Card C) 
  {
      String arg=null;
      try{
      
    if (arg == null ) {
        arg = C.getFace();
    }      
    JPanel panel = new JPanel(); 
    panel.setSize(50000,64000);
    panel.setBackground(Color.CYAN); 
    ImageIcon icon = new ImageIcon(arg); 
    JLabel label = new JLabel(); 
    label.setIcon(icon);
    panel.add(label);
    this.getContentPane().add(panel); 
    this.setVisible(true);
  }
  catch(Exception ex)
  {
  }
  }
}
    
