/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;
import BITalino.BitalinoDemo;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import ui.Main;
import static utils.InputOutput.getStringFromKeyboard;
/**
 *
 * @author gustavo
 */
public class CreateLoginInterface extends javax.swing.JFrame {
    private static OutputStream outputStream;
    private static DataOutputStream dout;
    private static InputStream inputStream;
    public static Socket socket;
    private static DataInputStream dint;
    private static InputStream console;
    public static String response = new String("");
    /**
     * Creates new form CreateLoginInterface
     */
    public CreateLoginInterface() {
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

        jScrollBar1 = new javax.swing.JScrollBar();
        jLabel1 = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        signup = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Hi! Welcome to the DataBase");

        login.setText("Log In");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        signup.setText("Sign Up");
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });

        jButton3.setText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(login)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(signup)
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel2)))
                .addContainerGap(112, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 295, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login)
                    .addComponent(signup))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
        
        
       
        try {
            dout = new DataOutputStream(outputStream);
            int entero = 1;
            dout.writeInt(entero);
            int roleId = 1;
            dout.writeInt(roleId);
            //AddPatient addpat = new AddPatient();
            //addpat.setVisible(true);
            AddPatient2 add = new AddPatient2(this,true);
            add.setVisible(true);
     
            if (response.equals("")){
                //no pasa
            }
            else{  
                dout.writeUTF(response);
                CreateLoginInterface c = new CreateLoginInterface();
                JOptionPane.showMessageDialog(c, "Patient Created!");
            
            }
        } catch (IOException ex) {
            Logger.getLogger(CreateLoginInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
    CreateLoginInterface c = new CreateLoginInterface();
           
    c.setVisible(true);  
    this.setVisible(false);
    }//GEN-LAST:event_signupActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        
        try {
            System.out.println(socket);
            dout = new DataOutputStream(outputStream);
            int entero = 2;
            dout.writeInt(entero);
            String okay;
            
            String username2 = JOptionPane.showInputDialog("Introduce your Username");
            String password2 = JOptionPane.showInputDialog("Introduce your Password");
            response = username2+","+password2;
            dout.writeUTF(response);
            okay = dint.readUTF();
            System.out.println(okay);
            if (okay.equals("Wrong credentials, please try again!")) {
                CreateLoginInterface c = new CreateLoginInterface();
                JOptionPane.showMessageDialog(c, "Wrong credentials, please try again!");
                this.setVisible(false);
           
                
            }
            
            
            if (okay.equals("Welcome patient !")) {
                CreateLoginInterface c = new CreateLoginInterface();
                JOptionPane.showMessageDialog(c, "Welcome patient!");
                
                PatientMenuInterface pat = new PatientMenuInterface();
                pat.setVisible(true);
                this.setVisible(false);
            } else{
                CreateLoginInterface c = new CreateLoginInterface();
           
                c.setVisible(true);
            }
            
            
            
                  } catch (IOException ex) {
            Logger.getLogger(CreateLoginInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }//GEN-LAST:event_loginActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            dout = new DataOutputStream(outputStream);
            int entero = 0;
            dout.writeInt(entero);
            System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(CreateLoginInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
            * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
            */
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(CreateLoginInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(CreateLoginInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(CreateLoginInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(CreateLoginInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>
            
            socket = new Socket("192.168.1.131", 9000);
            outputStream = socket.getOutputStream();
        
            inputStream = socket.getInputStream();
        
            dint= new DataInputStream(inputStream);
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new CreateLoginInterface().setVisible(true);
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(CreateLoginInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JButton login;
    private javax.swing.JButton signup;
    // End of variables declaration//GEN-END:variables
}
