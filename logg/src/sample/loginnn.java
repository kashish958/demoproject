/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author kashish
 */
public class loginnn extends JFrame implements  ActionListener  {
 Connection con;
    PreparedStatement pst;
ResultSet rs;
    JPanel heading ;
       JLabel login;
        JPanel lp ;
         JLabel nam;
    JLabel pp;
        JPasswordField pw;
        JTextField un ;
            JButton loginn ;   
         JButton newuser;
   JButton cancel;
         public loginnn()
     {
         //font
         
         Font f = new Font("Serif", Font.BOLD, 30);                             
         
          
//header
         
         
         heading = new JPanel();
         heading.setBackground(Color.ORANGE);
         heading.setBounds(0,0,900,100);
         login = new JLabel("LOGIN");
         login.setBounds(200,25,400,50);
         login.setFont(f);
         heading.add(login); 
                                                                                 
         
// login pannel
         
         lp = new JPanel();
         lp.setLayout(null);
         lp.setSize(400,350);
         lp.setBackground(new Color(0,0,0,80));//this is used for making trancpiracy
         lp.setBounds(250,175,500,350);
        
         
//username
                 nam = new JLabel("Enter Username");
nam.setBounds(50,20,100,25);
nam.setForeground (Color.red);
         un = new JTextField("");
         un.setBounds(50,40,300,50);
         un.setBackground(new Color(210,180,140));
         lp.add(un);
        lp.add(nam);
//password
          pp = new JLabel("Enter Password");
pp.setBounds(50,115,100,25);
pp.setForeground (Color.red);
        pw = new JPasswordField("");
         pw.setBounds(50,140,300,50);
                  pw.setBackground(new Color(210,180,140));

         lp.add(pw);
         lp.add(pp);
         
//button
         
          newuser = new JButton("SignUP");
         newuser.setBounds(20,250,100,40);
         lp.add(newuser);
        newuser.addActionListener(this);  
           loginn = new JButton("LOGIN");
         loginn.setBounds(180,250,100,40);
         lp.add(loginn);
         loginn.addActionListener(this);
                               
    cancel = new JButton("CANCEL");
         cancel.setBounds(340,250,100,40);
         lp.add(cancel);
      cancel.addActionListener(this);
   
//frame   
    ImageIcon background_image = new ImageIcon("C:\\Users\\kashish\\Downloads\\hh.jpg");
          //basically image is set on the label thts why
          Image img = background_image.getImage();
          Image temp_img = img.getScaledInstance(900,600,Image.SCALE_SMOOTH);
         background_image = new ImageIcon(temp_img);
         JLabel background = new JLabel("",background_image,JLabel.CENTER);
 
        
         
// now adding is done with background only now//
 
         background.add(lp);
         background.add(heading);
         background.setBounds(0,0,900,600);
          add(background);
          pack();


setTitle("Login page");
         setSize(900,600);
         setLayout(new FlowLayout());
         setDefaultCloseOperation(EXIT_ON_CLOSE);
   setVisible(true);             
}
  
         
         
          public void actionPerformed(ActionEvent ae)
    {   
        
        try{
           
            if(ae.getSource() == cancel)
            {
                this.hide();
            }
            
                 if(ae.getSource()==newuser)  
                 {
                     su s = new su();
                     this.hide();
                     s.setVisible(true);
                 }            
                 
         //checking not null values//
         if(un.getText().isEmpty()||pw.getText().isEmpty())
         {
                 JOptionPane.showMessageDialog(this,"Username or  Password blank");        

         } 
        
         else {
   
             //database//
        
              String username= un.getText();
                            String pass= pw.getText();
             Class.forName("com.mysql.jdbc.Driver");    //this is method which register the deriver//  
        
               con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","Demo12345");
                       pst = con.prepareStatement("select * from tt where username = ? and password = ?");
 pst.setString(1,username);
              pst.setString(2,pass);
rs = pst.executeQuery();
       
         
         if(rs.next())                              
         {
        blog b = new blog();   
         this.hide();
        b.setVisible(true);
         
         
         }
         else
         {
              
              JOptionPane.showMessageDialog(this,"Username or  Password do not matched..");
              un.setText("");
                            pw.setText("");
                            un.requestFocus();

         }
         
         }
               
               
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
  
    }
         
         
          
    public static void main(String a[]) {
        
       new loginnn();        
    }
}