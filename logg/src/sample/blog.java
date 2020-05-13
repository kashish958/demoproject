/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author kashish
 */
public class blog  extends JFrame implements ActionListener {
    
    
    JLabel name;
    JTextField nm;
   JButton s;
JLabel l;
   public blog(){
        
      
      name = new JLabel("Enter any data  :");
         
         name.setBounds(70,50,100,50);
         
      add(name); 
 
      l =new JLabel("");
      l.setBounds(70,500,100,50 );
        add(l); 
          nm = new JTextField("");
         nm.setBounds(190,50,300,50);
                  nm.setBackground(new Color(210,180,140));

         add(nm);
          
         
                   
            s = new JButton("SUBMIT");
         s.setBounds(340,360,100,40);
         add(s);
      s.addActionListener(this);
         
//frame 
  
        setTitle("Blog page");
         setSize(800,700);
         setLayout(null);
          setVisible(true);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
    }

 public void actionPerformed(ActionEvent ae)    {
     String r= nm.getText();
  l.setText(r+" ");
  
  nm.setText("");
                
    
                
nm.requestFocus();
 }
    
    
    
    
    public static void main(String a[]) {
        
        blog b= new blog();
        
    }


}
