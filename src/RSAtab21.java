/**
 * @author Dmytro Khelemendyk
 * CS-0026 Discrete Structures
 * 05/2016
 */

//this class is made in NetBeans, so it looks a bit different from other classes
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Arrays; //needed to print an array of String without overriding toString() method of Object
//import java.awt.GridBagConstraints; //will use GridBagLayout to build this tab
//import java.awt.GridBagLayout;

public class RSAtab21 extends javax.swing.JPanel {
    
  private FileWriter fw;//for writing into file
  private PrintWriter pw;//will be used for writing into file 
  private FileReader fr;//for reading from file
  private BufferedReader br;//will be used for reading from file
  private JFileChooser fc;//file chooser
  
  private String filename;
  private String textLine;
  static private final String newline = "\n";
 
  private RSAmodel myRSA;
  
    public RSAtab21() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Choose what to do:");
        jLabel1.setPreferredSize(new java.awt.Dimension(170, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 65;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 15, 0, 0);
        add(jLabel1, gridBagConstraints);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jRadioButton1.setText("Encrypt message");
        jRadioButton1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRadioButton1.setMaximumSize(new java.awt.Dimension(217, 37));
        jRadioButton1.setMinimumSize(new java.awt.Dimension(200, 29));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 45;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 25, 0, 0);
        add(jRadioButton1, gridBagConstraints);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jRadioButton2.setText("Decrypt message");
        jRadioButton2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 28;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 25, 0, 0);
        add(jRadioButton2, gridBagConstraints);

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jCheckBox1.setText("Choose to type keys manually");
        jCheckBox1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 32;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 2, 0, 0);
        add(jCheckBox1, gridBagConstraints);

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 135;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 19, 0, 0);
        add(jTextField1, gridBagConstraints);

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 135;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 19, 0, 0);
        add(jTextField2, gridBagConstraints);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1376;
        gridBagConstraints.ipady = 128;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(9, 25, 0, 0);
        add(jScrollPane1, gridBagConstraints);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1376;
        gridBagConstraints.ipady = 132;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(16, 25, 31, 0);
        add(jScrollPane2, gridBagConstraints);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Open File");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton1.setMaximumSize(new java.awt.Dimension(117, 31));
        jButton1.setMinimumSize(new java.awt.Dimension(117, 31));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 41;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 24, 0, 0);
        add(jButton1, gridBagConstraints);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Encrypt/Decrypt");
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.ipadx = -1;
        gridBagConstraints.ipady = 29;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 24, 0, 0);
        add(jButton2, gridBagConstraints);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("Save to File");
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton3.setMaximumSize(new java.awt.Dimension(117, 31));
        jButton3.setMinimumSize(new java.awt.Dimension(117, 31));
        jButton3.setPreferredSize(new java.awt.Dimension(107, 31));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 42;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 24, 0, 15);
        add(jButton3, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Exponent");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 39, 0, 0);
        add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Modulus");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 39, 0, 0);
        add(jLabel3, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    //a button handler for encrypt/decrypt button
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      if (jRadioButton1.isSelected()) //means we encrypt
      {
        if(jCheckBox1.isSelected()) //means we will use foreign keys
        {
          RSAtab1.logMessages.append("Encrypting with the keys typed in manually...");
          int e = Integer.parseInt(jTextField1.getText());
          int n = Integer.parseInt(jTextField2.getText());
               
          myRSA = new RSAmodel(jTextArea1.getText(), e, n);
          String encryptResult = Arrays.toString(myRSA.encrypt());
          if (encryptResult == null)
          {
            RSAtab1.logMessages.append("The size of n is not big enough for your message, choose bigger primes.");
          }
          else
          {
            jTextArea2.setText(encryptResult);
          }
        } 
        else  //means we use keys generated by application
        {
          RSAtab1.logMessages.append("Encrypting using the keys from created set of keys...");
          myRSA = new RSAmodel(jTextArea1.getText());
          String encryptResult = Arrays.toString(myRSA.encrypt());
          if (encryptResult == null)
          {
            RSAtab1.logMessages.append("The size of n is not big enough for your message, choose bigger primes.");
          }
          else
          {
            jTextArea2.setText(encryptResult);
          }
        }            
      }
      else //means we decrypting
      {
         if(jCheckBox1.isSelected()) //means we use foreign keys
         {
           int d = Integer.parseInt(jTextField1.getText());
           int n = Integer.parseInt(jTextField2.getText());
             
           RSAtab1.logMessages.append("Decrypting with the keys typed in manually...");
           //gets rid of square brackets first, then splits by delimiters: comma(one or more) and white space characters(zero or more - see regex)
           String[] splittedText = jTextArea1.getText().replaceAll("[\\[\\]]", "").split(",+\\s*");
           myRSA = new RSAmodel(splittedText, d, n);
           jTextArea2.setText(myRSA.decrypt());
         }
         else //means we use keys generated by application
         {
           RSAtab1.logMessages.append("Decrypting using the keys from created set of keys...");
           //gets rid of square brackets first, then splits by delimiters: comma and white space characters (one or more - see regex)
           String[] splittedText = jTextArea1.getText().replaceAll("[\\[\\]]", "").split(",+\\s+");
           myRSA = new RSAmodel(splittedText);
           jTextArea2.setText(myRSA.decrypt());
         }
      }    
    }//GEN-LAST:event_jButton2ActionPerformed

    //a button handler for the open file button and for the save into file button
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      fc = new JFileChooser(); 
      fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

      if ( evt.getSource() == jButton1 ) //means open file button 
      {
         int returnVal = fc.showOpenDialog(getParent());

         if (returnVal == JFileChooser.APPROVE_OPTION) 
         {
             File file = fc.getSelectedFile();
             //this is where application opens a file.
             try
               {
                  fr = new FileReader(file);
                  br = new BufferedReader(fr);
                  
                  do
                  {
                  textLine = br.readLine();
                  jTextArea1.append(textLine);
                  }
                  while (textLine != null );
                  
                  br.close();
                  fr.close();
               }
               catch(Exception e)
                 { 
                   System.out.println(e); 
                 }

             RSAtab1.logMessages.append("Opening: " + file.getName() + "." + newline);             
         } 
         else 
           {
             RSAtab1.logMessages.append("Open command cancelled by user." + newline);
           }
           
         jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
      }
      else if (evt.getSource() == jButton3) //means save to file button
        {
          int returnVal = fc.showSaveDialog(null);
          if (returnVal == JFileChooser.APPROVE_OPTION) 
          {
            //this is where application saves a file.
            File file = fc.getSelectedFile();
            try
            {
              fw = new FileWriter(file, false);
              pw = new PrintWriter(fw, true);
            
              pw.println(jTextArea2.getText());
            
              pw.close();
              fw.close();         
            }
            catch(Exception e)
              { System.out.println(e); }
   
           RSAtab1.logMessages.append("Saving: " + file.getName() + "." + newline);
         } 
         else 
           {
             RSAtab1.logMessages.append("Save command cancelled by user." + newline);
           }
         jTextArea2.setCaretPosition(jTextArea2.getDocument().getLength());
      }     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      fc = new JFileChooser(); 
      fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
      
      if ( evt.getSource()== jButton1 )
      {
         int returnVal = fc.showOpenDialog(getParent());

         if (returnVal == JFileChooser.APPROVE_OPTION) 
         {
             File file = fc.getSelectedFile();
             //This is where application opens a file.
             try
               {
                  fr = new FileReader(file);
                  br = new BufferedReader(fr);
                  
                  do
                  {
                  textLine = br.readLine();
                  jTextArea1.append(textLine);
                  }
                  while (textLine != null );
                  
                  br.close();
                  fr.close();
               }
               catch(Exception e)
                 { 
                   System.out.println(e); 
                 }

             RSAtab1.logMessages.append("Opening: " + file.getName() + "." + newline);             
         } 
         else 
           {
             RSAtab1.logMessages.append("Open command cancelled by user." + newline);
           }
           
         jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
      }
      else if (evt.getSource() == jButton3) 
        {
          int returnVal = fc.showSaveDialog(null);
          if (returnVal == JFileChooser.APPROVE_OPTION) 
          {
            //This is where application saves a file.
            File file = fc.getSelectedFile();
            try
            {
              fw = new FileWriter(file, false);
              pw = new PrintWriter(fw, true);
            
              pw.println(jTextArea2.getText());
            
              pw.close();
              fw.close();         
            }
            catch(Exception e)
              { System.out.println(e); }
   
           RSAtab1.logMessages.append("Saving: " + file.getName() + "." + newline);
         } 
         else 
           {
             RSAtab1.logMessages.append("Save command cancelled by user." + newline);
           }
         jTextArea2.setCaretPosition(jTextArea2.getDocument().getLength());
      }     
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
