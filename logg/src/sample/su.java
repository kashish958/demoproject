/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author kashish
 */
public class su  extends JFrame  implements  ActionListener   {
    JPanel user ;

    Connection con ;
    
    JTextField nm;
    JPasswordField p;
     JPasswordField Cp;
     JButton can;
     JButton add;
     JTextField type ;
     JButton bl;
    public su()
    {  
//Panel
        
      
      
    
         user = new JPanel();
         user.setLayout(null);
          user.setSize(400,350);
         user.setBackground(Color.ORANGE);
         user.setBounds(190,155,500,450);
        
//username
        
        JLabel name = new JLabel("UserName :");
         
         name.setBounds(70,50,100,50);
         
      user.add(name); 
      
         
          nm = new JTextField("");
         nm.setBounds(190,50,300,50);
                  nm.setBackground(new Color(210,180,140));

         user.add(nm);
      
//password
       JLabel pas = new JLabel("Password :");
         
         pas.setBounds(70,130,100,50);
         
      user.add(pas); 
            
       p= new JPasswordField("");
               p.setBounds(190,130,300,50);

                  p.setBackground(new Color(210,180,140));
                  user.add(p);
//cofirm pass    
     
   JLabel cp = new JLabel("Confirm Password :");
         
         cp.setBounds(70,200,200,50);
         
      user.add(cp); 
        
      Cp= new JPasswordField("");
       Cp.setBounds(190,200,300,50);
                  Cp.setBackground(new Color(210,180,140));
                  user.add(Cp);

        
                    add = new JButton("ADD");
         add.setBounds(40,360,100,40);
         user.add(add);
        
      add.addActionListener(this);
   
      
                   
             can = new JButton("CANCEL");
         can.setBounds(340,360,100,40);
         user.add(can);
        can.addActionListener(this);
      
        bl = new JButton("Back to Login");
        bl.setBounds(170,400,150,40);
        user.add(bl);
        bl.addActionListener(this);
//frame 
         add(user);
        setTitle("NEW USER");
         setSize(800,700);
         setLayout(null);
          setVisible(true);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    
        public void actionPerformed(ActionEvent ae)    
    {   
           if(ae.getSource() == can)
           {
                this.hide();         //for cancelling
            }
           
            if(ae.getSource()==bl){
           loginnn l = new loginnn();
           l.setVisible(true);
       } 
            
        if(nm.getText().length() == 0)
         {
    JOptionPane.showMessageDialog(this,"Please type the username");        
        }
       else if(p.getText().length() == 0)
        {
    JOptionPane.showMessageDialog(this,"Please type the Password");        
        } 
       else if(p.getText().equals(Cp.getText())==false)
        {
            JOptionPane.showMessageDialog(this,"Password not match");     
        }
       
      
       //Database//
       else 
       { 
           try
           {   
               
              String username= nm.getText();
                            String confirmpass= Cp.getText();
     

                                
                  Class.forName("com.mysql.jdbc.Driver");    //this is method which register the deriver//  
        
               con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","Demo12345");
       
              PreparedStatement st = con.prepareStatement("insert into tt(username,password)values(?,?) ");
                  st.setString(1, username);
                                   st.setString(2,confirmpass);

                                       st.executeUpdate();
                       JOptionPane.showMessageDialog(null,"User created");     
                nm.setText("");
                           Cp.setText("");
    
                p.setText("");
nm.requestFocus();
           }
           catch(Exception e)
           {
               System.out.println(e);
           }
           
       }



    }
    
    public static void main(String a[]) {
        
       su s = new su();
        
    }
}
