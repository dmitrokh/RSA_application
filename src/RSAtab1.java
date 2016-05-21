/**
 * @author Dmytro Khelemendyk
 * CS-0026 Discrete Structures
 * 05/2016
 */

//this class is made in jgrasp
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays; //needed to print an array of String without overriding toString() method of Object

//it's a class for the first panel used for generating a new set of keys with buttons and fields on it;
//the "controllers" are iimplemented as inner private classes
public class RSAtab1 extends JPanel
{
  JPanel insidePan;
    
  private JTextField tfFirstPrime,
                     tfSecondPrime,
                     tfFirstExponent;
  private JButton bPhi,
                  bGenKeys;
  private JLabel lblPrime1,
                 lblPrime2,
                 lblPhi,
                 lblKeys;
  private JComboBox cbPrime1,
                    cbPrime2;
  public static JTextArea logMessages;
  private JScrollPane scrollPane;
  private RSAmodel myRSA;
   
  private Font myFont = new Font("Arial", Font.BOLD, 25);
  
  public RSAtab1()
  {
    //we make an outer JPanel to create two separated spaces, one for buttons and comboboxes, second - for the "log window"
    setLayout (new GridLayout ( 2, 2, 10, 20 ) );
    //an innner panel used for buttons and comboboxes
    insidePan = new JPanel(new GridLayout(3, 2, 5, 10));
        
    setBorder(BorderFactory.createRaisedBevelBorder()); //raised bevel border around JPanel
    
    lblPrime1 = new JLabel("Choose first prime number: ");  
    lblPrime1.setFont(myFont);
    insidePan.add(lblPrime1);
    
    cbPrime1 = new JComboBox(RSAmodel.buildPrimeList());
    cbPrime1.setFont(myFont);
    insidePan.add(cbPrime1);
    
    lblPrime2 = new JLabel("Choose second prime number: ");  
    lblPrime2.setFont(myFont);
    insidePan.add(lblPrime2);
    
    cbPrime2 = new JComboBox(RSAmodel.buildPrimeList());
    cbPrime2.setFont(myFont);
    insidePan.add(cbPrime2);
    
    bGenKeys = new JButton("Generate keys"); 
    bGenKeys.setFont(myFont);
    bGenKeys.addActionListener(new keysButtonHandler());
    insidePan.add(bGenKeys);
    lblKeys = new JLabel();
    lblKeys.setFont(myFont);
    lblKeys.setBorder(BorderFactory.createLoweredBevelBorder());
    insidePan.add(lblKeys); 
    
    add(insidePan);
    //makes a "log window" and adds it to the outer JPanel
    logMessages = new JTextArea();    
    logMessages.setBorder(BorderFactory.createLoweredBevelBorder());
    //makes scroller for the "log window"
    scrollPane = new JScrollPane(logMessages, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    add(scrollPane);        
  }
  
  //it's one of the "Controllers" in our VMC implementation; it's made as a private inner class;
  //could be made as a separated class also
  private class keysButtonHandler implements ActionListener
  {
    public void actionPerformed(ActionEvent ae)
    {
      int pr1 = (int) cbPrime1.getSelectedItem();//gets a first prime number
      int pr2 = (int) cbPrime2.getSelectedItem();//gets a second prime number
      
      myRSA = new RSAmodel (pr1, pr2);
      
      lblKeys.setText(Arrays.toString(myRSA.makeKeys()));      
    }
  }  
}