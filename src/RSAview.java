/**
 * @author Dmytro Khelemendyk
 * CS-0026 Discrete Structures
 * 05/2016
 */

//this class is made in jgrasp
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JTabbedPane;
import java.awt.event.*;

public class RSAview extends JFrame
{
  private JTabbedPane tabPane;
 
  public RSAview ()
  {    
    super("RSA app");
    getContentPane().setLayout(new GridLayout(1, 1));
    JTabbedPane tabbedPane = new JTabbedPane();
    tabbedPane.setFont(new Font( "Arial", Font.BOLD|Font.ITALIC, 30 ) );
    getContentPane().add(tabbedPane);
    
    //create a first tab for new set of key generation
    RSAtab1 genKeysTab = new RSAtab1();
    //add this tab to the frame
    tabbedPane.addTab("Generate keys", genKeysTab);
    
    //create a second tab for encryption/decryption
    RSAtab21 encrDecrTab = new RSAtab21();
    tabbedPane.addTab("Encryption/Decryption", encrDecrTab);    
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(900,600);
    setResizable(false);
    setVisible(true);
  }
  
  public static void main(String[] args)
  {
    RSAview rsaview = new RSAview();    
  }
}