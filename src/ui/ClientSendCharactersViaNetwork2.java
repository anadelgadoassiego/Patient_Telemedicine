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
    
    private static OutputStream outputStream;
    private static DataOutputStream dout;
    private static InputStream inputStream;
    private static Socket socket;
    private static DataInputStream dint;
    private static InputStream console;
    
    
    public static void main(String args[]) throws IOException, Exception {
        int byteRead;
        
        //Redirect the console
        console = (System.in);
        //You should change localhost by the IP address 
        //We are connecting to a "service" in an IP and port 9000
        socket = new Socket("192.168.43.204", 9000);
        try{
        outputStream = socket.getOutputStream();
        
        inputStream = socket.getInputStream();
        
        dint= new DataInputStream(inputStream);
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
                dout = new DataOutputStream(outputStream);
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
                        }
                        break;
                        
                        
                    case 0:
                        System.out.println("Finish");
                        releaseResources(outputStream, console, socket);
                        System.exit(0);
                        return;
                    default:
                        return;
                }
            }
     /*   
        while (true) {
            //Read from our console
            byteRead = console.read();
             
            //And send it to the server
            dout = new DataOutputStream(outputStream);
            System.out.println(dout);
            dout.writeInt(byteRead);
            if (byteRead == -1 || byteRead == 'x') {
                System.out.println("Finish");
                releaseResources(outputStream, console, socket);
                System.exit(0);
            }
        }
*/
        } catch (IOException ex) {
            Logger.getLogger(ClientSendCharactersViaNetwork2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void menuPatient() throws Exception {
        console = (System.in);
        try {
            outputStream = socket.getOutputStream();
            inputStream = socket.getInputStream();
            dint= new DataInputStream(inputStream);
            
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
                        choice = Character.getNumericValue(console.read());
                        wrongtext = false;
                    } catch (NumberFormatException ex) {
                        wrongtext = true;
                        System.out.println("It's not an int, please enter an int");
                    }
                } while (choice < 1 || choice > 8 || wrongtext);
                dout = new DataOutputStream(outputStream);
                System.out.println(dout);
                dout.writeInt(choice);
                switch (choice) {
                    case 1:
                        String response_form = ui.Main.completeForm();
                        dout.writeUTF(response_form);
                        String okay = dint.readUTF();
                        System.out.println(okay);
                        break;
                    case 2:
                        //addEMG();
                        break;
                    case 3:
                        //searchECGByName();
                        break;
                    case 4:
                        //searchEMGByName();
                        break;
                    case 5:
                         String response_newUser = ui.Main.changeUsername();
                        dout.writeUTF(response_newUser);
                        //okay = dint.readUTF();
                        //System.out.println(okay);
                        break;
                    case 6:
                        String response_newPassword = ui.Main.changePassword();
                        dout.writeUTF(response_newPassword);
                        //okay = dint.readUTF();
                        //System.out.println(okay);
                        //userManager.updatePassword(patientName);
                        break;
                    case 7:
                        
                        return;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientSendCharactersViaNetwork2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private static void releaseResources(OutputStream outputStream,InputStream console, Socket socket) {
        try {
            try {
                console.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientSendCharactersViaNetwork2.class.getName()).log(Level.SEVERE, null, ex);

            }

            try {
                outputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientSendCharactersViaNetwork2.class.getName()).log(Level.SEVERE, null, ex);

            }

            socket.close();

        } catch (IOException ex) {
            Logger.getLogger(ClientSendCharactersViaNetwork2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
