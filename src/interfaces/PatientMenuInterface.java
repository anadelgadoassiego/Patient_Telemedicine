/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import static interfaces.CreateLoginInterface.socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import static java.lang.Integer.parseInt;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pojos.Doctor;
import pojos.Ecg;
import pojos.Emg;
import static utils.InputOutput.getStringFromKeyboard;

/**
 *
 * @author gustavo
 */
public class PatientMenuInterface extends javax.swing.JFrame {
    public static String response = new String("");
    private static InputStream inputStream2;
    private static OutputStream outputStream2;
    private static DataInputStream dint2;
    private static DataOutputStream dout2;
    public static Socket socket2 = CreateLoginInterface.socket;
    public static ObjectInputStream objectInputStream = null;
    public static List<Doctor> doctorList = new ArrayList <Doctor>();
    public static int id = 0;
    public static List<Integer> values_int_public = new ArrayList();
    /**
     * Creates new form signUp
     */
    public PatientMenuInterface() {
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

        jLabel1 = new javax.swing.JLabel();
        form = new javax.swing.JButton();
        addEmg = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        ecgname = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        doc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Welcome!");

        form.setText("Complete Clinical Trial");
        form.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formActionPerformed(evt);
            }
        });

        addEmg.setText("Add EMG or ECG");
        addEmg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmgActionPerformed(evt);
            }
        });

        jButton3.setText("Search EMG by date");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        ecgname.setText("Search ECG by date");
        ecgname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ecgnameActionPerformed(evt);
            }
        });

        jButton5.setText("Change Username");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Change Password");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Go back");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        doc.setText("Choose your doctor");
        doc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addEmg)
                            .addComponent(form)
                            .addComponent(jButton5)
                            .addComponent(jButton6)
                            .addComponent(jButton7)
                            .addComponent(jButton3)
                            .addComponent(ecgname)
                            .addComponent(doc))))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addComponent(form)
                .addGap(18, 18, 18)
                .addComponent(addEmg)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(ecgname)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addGap(18, 18, 18)
                .addComponent(doc)
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formActionPerformed
        try {
            // TODO add your handling code here:
            
            outputStream2 = socket2.getOutputStream();
            dout2 = new DataOutputStream(outputStream2);
            inputStream2 = socket2.getInputStream();                
            dint2 = new DataInputStream(inputStream2);
            int entero = 1;
            dout2.writeInt(entero);
            Formulary form = new Formulary(this,true);
            form.setVisible(true);
            dout2.writeUTF(response);
            // String okay = dint2.readUTF();
            System.out.println(response);
            
            
            
            
            
           
        } catch (IOException ex) {
            Logger.getLogger(PatientMenuInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        PatientMenuInterface p = new PatientMenuInterface();
        JOptionPane.showMessageDialog(p, "Form saved successfully!");
        p.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_formActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        CreateLoginInterface c = new CreateLoginInterface();
        this.setVisible(false);
        c.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            // TODO add your handling code here:
            outputStream2 = socket2.getOutputStream();
            dout2 = new DataOutputStream(outputStream2);
            inputStream2 = socket2.getInputStream();
            dint2 = new DataInputStream(inputStream2);
            int entero = 5;
            dout2.writeInt(entero);
            String okay;
            String username2 = JOptionPane.showInputDialog("Introduce your new Username");
            dout2.writeUTF(username2);
            okay = dint2.readUTF();
            if (okay.equals("Action Completed")){
                PatientMenuInterface p = new PatientMenuInterface();
                JOptionPane.showMessageDialog(p, "Action completed!");
            } else {
                PatientMenuInterface p = new PatientMenuInterface();
                JOptionPane.showMessageDialog(p, "Can not be completed!");
            }
        } catch (IOException ex) {
            Logger.getLogger(PatientMenuInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        PatientMenuInterface p = new PatientMenuInterface();
        p.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            // TODO add your handling code here:
            outputStream2 = socket2.getOutputStream();
            dout2 = new DataOutputStream(outputStream2);
            inputStream2 = socket2.getInputStream();
            dint2 = new DataInputStream(inputStream2);
            int entero = 6;
            dout2.writeInt(entero);
            String okay;
            String password = JOptionPane.showInputDialog("Introduce your new Password");
            dout2.writeUTF(password);
            okay = dint2.readUTF();
            if (okay.equals("Action Completed")){
                PatientMenuInterface p = new PatientMenuInterface();
                JOptionPane.showMessageDialog(p, "Action completed!");
            } else {
                PatientMenuInterface p = new PatientMenuInterface();
                JOptionPane.showMessageDialog(p, "Can not be completed!");
            }
        } catch (IOException ex) {
            Logger.getLogger(PatientMenuInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        PatientMenuInterface p = new PatientMenuInterface();
        p.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void addEmgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmgActionPerformed
        try {
            // TODO add your handling code here:
            outputStream2 = socket2.getOutputStream();
            dout2 = new DataOutputStream(outputStream2);
            inputStream2 = socket2.getInputStream();
            dint2 = new DataInputStream(inputStream2);
            int entero = 2;
            dout2.writeInt(entero);
            FormularyEXG exg = new FormularyEXG(this,true);
            exg.setVisible(true);
            dout2.writeUTF(response);
            
            addEmg addemg = new addEmg(this,true);
            addemg.setVisible(true);
            dout2.writeUTF(response);
            BITalino.BitalinoDemo.main(socket);
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(PatientMenuInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        PatientMenuInterface p = new PatientMenuInterface();
        p.setVisible(true);
        this.setVisible(false); 
    }//GEN-LAST:event_addEmgActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {        
            // TODO add your handling code here:
            
            // TODO add your handling code here:
            outputStream2 = socket2.getOutputStream();
            dout2 = new DataOutputStream(outputStream2);
            inputStream2 = socket2.getInputStream();
            dint2 = new DataInputStream(inputStream2);
            int entero = 3;
            dout2.writeInt(entero);
            objectInputStream = new ObjectInputStream(inputStream2);
            List<Emg> emgList = new ArrayList <Emg>();
            Object tmp;
            while ((tmp = objectInputStream.readObject()) != null) {
                Emg emg = (Emg) tmp;
                emgList.add(emg);
                
                
                
            boolean found = false;
            String month = JOptionPane.showInputDialog("Introduce the month");
            String day = JOptionPane.showInputDialog("Introduce the day");
            String name_emg = day + month  ;
            String name_select;
            for (Emg emg2  : emgList) {
                 name_select = emg2.getName_emg();
                 if (name_select.contains(name_emg)){
                    PatientMenuInterface p = new PatientMenuInterface();
                    JOptionPane.showMessageDialog(p, name_select);
                 }
            } 
        
       
            String position2 = JOptionPane.showInputDialog("Introduce the position");
            int position = parseInt(position2);
            name_emg = "EMG_" + day +month + "_" + position + ".txt" ; 
            for (Emg emg2 : emgList){
                name_select = emg2.getName_emg();
                 if (name_select.equals(name_emg)){
                    System.out.println(emg2);
                    found= true;
                    byte [] emg_values = emg2.getPatient_emg();
                    List <String> values = new ArrayList();
                    String pasar = "";
                    for(int i=0;i<(emg_values.length)-1;i++){
                       char value = (char) emg_values[i];
                       int compare = (int) emg_values[i];
                       while(compare!=10){
                           value = (char) emg_values[i];
                           compare = (int) emg_values[i];
                           if(compare!=10){
                                pasar = pasar+value;
                                i++;
                           }

                       }
                       values.add(pasar);
                       pasar="";

                   }
                    PatientMenuInterface p = new PatientMenuInterface();
                    JOptionPane.showMessageDialog(p, values.toString());
                 }
            }
            if(!found){
                PatientMenuInterface p = new PatientMenuInterface();
                JOptionPane.showMessageDialog(p, "Does not exist!");
            }
            }
        } catch (IOException ex) {
            Logger.getLogger(PatientMenuInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PatientMenuInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        PatientMenuInterface p = new PatientMenuInterface();
        p.setVisible(true);
        this.setVisible(false);
            
    }//GEN-LAST:event_jButton3ActionPerformed

    private void ecgnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ecgnameActionPerformed
        // TODO add your handling code here:
        try {        
            // TODO add your handling code here:
            
            // TODO add your handling code here:
            outputStream2 = socket2.getOutputStream();
            dout2 = new DataOutputStream(outputStream2);
            inputStream2 = socket2.getInputStream();
            dint2 = new DataInputStream(inputStream2);
            int entero = 4;
            dout2.writeInt(entero);
            objectInputStream = new ObjectInputStream(inputStream2);
            List<Ecg> ecgList = new ArrayList <Ecg>();
            Object tmp; 
            while ((tmp = objectInputStream.readObject()) != null) {
                            Ecg ecg = (Ecg) tmp;
                            ecgList.add(ecg);
                        
            }
            boolean found = false;
            String month = JOptionPane.showInputDialog("Introduce the month");
            String day = JOptionPane.showInputDialog("Introduce the day");
            String name_ecg = day + month ;
            String name_select;
            for (Ecg ecg  : ecgList) {
                 name_select = ecg.getName_ecg();
                 if (name_select.contains(name_ecg)){
                    PatientMenuInterface p = new PatientMenuInterface();
                    JOptionPane.showMessageDialog(p, name_select);
                 }
            } 

            String position2 = JOptionPane.showInputDialog("Introduce the position");
            int position = parseInt(position2);
            name_ecg = "ECG_" + day + month + "_" + position + ".txt"; 
            for (Ecg ecg : ecgList){
                name_select = ecg.getName_ecg();
                 if (name_select.equals(name_ecg)){
                    System.out.println(ecg);
                    found= true;
                    byte [] ecg_values = ecg.getPatient_ecg();
                    List <String> values = new ArrayList();
                    String pasar = "";

                    for(int i=0;i<(ecg_values.length)-1;i++){
                       char value = (char) ecg_values[i];
                       int compare = (int) ecg_values[i];
                       while(compare!=10){
                           value = (char) ecg_values[i];
                           compare = (int) ecg_values[i];
                           if(compare!=10){
                                pasar = pasar+value;
                                i++;
                           }

                       }
                       values.add(pasar);
                       pasar="";

                   }
                    PatientMenuInterface p = new PatientMenuInterface();
                    JOptionPane.showMessageDialog(p, values.toString());
                 }
            }
            if(!found){
                PatientMenuInterface p = new PatientMenuInterface();
                JOptionPane.showMessageDialog(p, "Does not exist!");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(PatientMenuInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PatientMenuInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        PatientMenuInterface p = new PatientMenuInterface();
        p.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ecgnameActionPerformed

    private void docActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docActionPerformed
        try {
            // TODO add your handling code here:
            outputStream2 = socket2.getOutputStream();
            dout2 = new DataOutputStream(outputStream2);
            inputStream2 = socket2.getInputStream();
            dint2 = new DataInputStream(inputStream2);
            int entero = 7;
            dout2.writeInt(entero);
            objectInputStream = new ObjectInputStream(inputStream2);
            
            Object tmp3;
            while ((tmp3 = objectInputStream.readObject()) != null) {
                Doctor doctor = (Doctor) tmp3;
                doctorList.add(doctor);
            }
            
        
            PatientMenuInterface p = new PatientMenuInterface();
            JOptionPane.showMessageDialog(p, "Press OK to see the doctor's list");
            for (Doctor doctor : doctorList) {
                JOptionPane.showMessageDialog(p, doctor.toString());    
            }
            
            ChooseDoc cdoc = new ChooseDoc(this,true);
            cdoc.setVisible(true);
            
            dout2.writeInt(id);
            
            
            JOptionPane.showMessageDialog(p, "Changes Applied!");
            
            

            
            
            
        } catch (IOException ex) {
            Logger.getLogger(PatientMenuInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PatientMenuInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        PatientMenuInterface p = new PatientMenuInterface();
        p.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_docActionPerformed

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
                    java.util.logging.Logger.getLogger(PatientMenuInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(PatientMenuInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(PatientMenuInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(PatientMenuInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                //</editor-fold>
                //</editor-fold>
                
                
                outputStream2 = socket2.getOutputStream();
                
                inputStream2 = socket2.getInputStream();
                
                dint2 = new DataInputStream(inputStream2);
                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new PatientMenuInterface().setVisible(true);
                    }
                });
                
            } catch (IOException ex) {
                Logger.getLogger(PatientMenuInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEmg;
    private javax.swing.JButton doc;
    private javax.swing.JButton ecgname;
    private javax.swing.JButton form;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
