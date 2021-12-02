package ui;

import BITalino.BitalinoDemo;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.Main;

public class ClientSendCharactersViaNetwork2 {
    
    public static void main(String args[]) throws IOException, Exception {
        int byteRead;
        new Main();
        //Redirect the console
        InputStream console = (System.in);
        //You should change localhost by the IP address 
        //We are connecting to a "service" in an IP and port 9000
        Socket socket = new Socket("192.168.1.35", 9000);
        try{
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dout;
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
                        //login();
                        break;
                    case 0:
                        System.out.println("Finish");
                        releaseResources(outputStream, console, socket);
                        System.exit(0);
                        return;
                    default:
                        break;
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
