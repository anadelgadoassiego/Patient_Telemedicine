package ui;

import BITalino.BitalinoDemo;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.Main;

public class ClientSendCharactersViaNetwork2 {
    
   
   
    private static Socket socket;
    
    public static void main(String args[]) throws IOException, Exception {
        int byteRead;
        socket = new Socket("192.168.68.112", 9000);
        InputStream console;
        InputStream inputStream;
        OutputStream outputStream;
        DataInputStream dint;
        DataOutputStream dout;
        
        
        //Redirect the console
        
        try{
            console = (System.in);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            dint= new DataInputStream(inputStream);
            dout = new DataOutputStream(outputStream);
         while (true) {

                System.out.println("What do you want to do?");
                System.out.println("1. Create a new user");
                System.out.println("2. Login");
                System.out.println("0. Exit");
                Integer choice = new Integer(0);

                boolean wrongtext = false;
                do {
                    System.out.println("Introduce the number of the option you would like to choose: ");
                    try {
                        choice = Character.getNumericValue(console.read());
                        wrongtext = false;
                    } catch (NumberFormatException ex) {
                        wrongtext = true;
                        System.out.println("It's not an int, please enter an int");
                    }
                } while (choice < 0 || choice > 2 || wrongtext);
               
                System.out.println(dout);
                dout.writeInt(choice);
                switch (choice) {
                    case 1:
                        String response = ui.Main.newUser();
                        dout.writeUTF(response);
                        break;
                    case 2:
                        String response_login = ui.Main.login();
                        dout.writeUTF(response_login);
                        String okay = dint.readUTF();
                        System.out.println(okay);
                        if (okay.equals("Welcome patient !")) {
                           menuPatient();
                           //releaseResources2(outputStream, console, inputStream, dint, dout);
                        }
                        /*socket = new Socket("192.168.68.112", 9000);
                        outputStream = socket.getOutputStream();
                        inputStream = socket.getInputStream();
                        dint= new DataInputStream(inputStream);
                        console = (System.in);
                        dout = new DataOutputStream(outputStream);*/
                        break;
                        
                        
                    case 0:
                        System.out.println("Finish");
                        releaseResources(outputStream,console, inputStream, console,dint,dout, socket);
                        System.exit(0);
                        return;
                    default:
                        return;
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(ClientSendCharactersViaNetwork2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    private static void menuPatient() throws Exception {
        
        InputStream console2;
        InputStream inputStream2;
        OutputStream outputStream2;
        DataInputStream dint2;
        DataOutputStream dout2;
        
       
        try {
            console2 = (System.in);
            inputStream2 = socket.getInputStream();
            outputStream2 = socket.getOutputStream();
            dint2 = new DataInputStream(inputStream2);
            dout2 = new DataOutputStream(outputStream2);
            
            while (true) {
                System.out.println("What would you like to do?");
                System.out.println("1. Complete form");
                System.out.println("2. Add EMG and ECG");
                System.out.println("3. Search EMG by start date");
                System.out.println("4. Search ECG by start date");
                System.out.println("5. Change your user name");
                System.out.println("6. Change your password");
                System.out.println("7. Go back");
                Integer choice = new Integer(0);
                boolean wrongtext = false;
                do {
                    System.out.println("Introduce the number of the option you would like to choose: ");
                    try {
                        choice = Character.getNumericValue(console2.read());
                        wrongtext = false;
                    } catch (NumberFormatException ex) {
                        wrongtext = true;
                        System.out.println("It's not an int, please enter an int");
                    }
                } while (choice < 1 || choice > 7 || wrongtext);
                System.out.println(dout2);
                dout2.writeInt(choice);
                switch (choice) {
                    case 1:
                        String response_form = ui.Main.completeForm();
                        dout2.writeUTF(response_form);
                        String okay = dint2.readUTF();
                        System.out.println(okay);
                        break;
                    case 2:
                        String response_EMG_ECG = ui.Main.addEMG_addECG();
                        dout2.writeUTF(response_EMG_ECG);
                        BITalino.BitalinoDemo.main(socket);
                        break;
                    case 3:
                        //searchECGByName();
                        break;
                    case 4:
                        //searchEMGByName();
                        break;
                    case 5:
                        String response_newUser = ui.Main.changeUsername();
                        dout2.writeUTF(response_newUser);
                        okay = dint2.readUTF();
                        System.out.println(okay);
                        break;
                    case 6:
                        String response_newPassword = ui.Main.changePassword();
                        dout2.writeUTF(response_newPassword);
                        okay = dint2.readUTF();
                        System.out.println(okay);
                        break;
                    case 7:
                        //releaseResources2(outputStream2, console2, inputStream2, dint2, dout2);
                        return;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientSendCharactersViaNetwork2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private static void releaseResources(OutputStream outputStream, InputStream console, InputStream inputStream, InputStream console2, DataInputStream dint, DataOutputStream dout, Socket socket) {
        try {
            try {
                dout.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientSendCharactersViaNetwork2.class.getName()).log(Level.SEVERE, null, ex);

            }
            try {
                dint.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientSendCharactersViaNetwork2.class.getName()).log(Level.SEVERE, null, ex);

            }
            try {
                outputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientSendCharactersViaNetwork2.class.getName()).log(Level.SEVERE, null, ex);

            }

            try {
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientSendCharactersViaNetwork2.class.getName()).log(Level.SEVERE, null, ex);

            }
            try {
                console.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientSendCharactersViaNetwork2.class.getName()).log(Level.SEVERE, null, ex);

            }

            socket.close();

        } catch (IOException ex) {
            Logger.getLogger(ClientSendCharactersViaNetwork2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private static void releaseResources2(OutputStream outputStream2,InputStream console2, InputStream inputStream2, DataInputStream dint2, DataOutputStream dout2) {
        try {
            dout2.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientSendCharactersViaNetwork2.class.getName()).log(Level.SEVERE, null, ex);

        }
        
        try {
            dint2.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientSendCharactersViaNetwork2.class.getName()).log(Level.SEVERE, null, ex);

        }
        try {
            inputStream2.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientSendCharactersViaNetwork2.class.getName()).log(Level.SEVERE, null, ex);

        }
         try {
            outputStream2.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientSendCharactersViaNetwork2.class.getName()).log(Level.SEVERE, null, ex);

        }
        try {
            console2.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientSendCharactersViaNetwork2.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    
}
