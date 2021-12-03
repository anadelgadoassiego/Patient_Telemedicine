/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputOutput {

    public static int getIntFromKeyboard1to10(String question) {
        int readInt;
        BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println(question);
                String cadena = consola.readLine();
                readInt = Integer.parseInt(cadena);
                if (readInt < 1 || readInt > 10) {
                    throw new NumberFormatException("You must enter an integer between 1 and 10.");
                }
                return readInt;
            } catch (IOException ioe) {
                System.out.println("There was a problem while reading, please enter it again.");
            } catch (NumberFormatException nfe) {
                System.out.println("You must enter an integer between 1 and 10.");
            }

        }
    }

    public static String getStringFromKeyboard(String question) {
        BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                
                System.out.println(question);
                String stringLeida = consola.readLine();
                
                while(stringLeida.equals("")||stringLeida.equals("\n")){
                stringLeida = consola.readLine();
                }
                return stringLeida;
            } catch (IOException ioe) {
                System.out.println("There was a problem while reading, please enter it again.");
            }

        }
    }

    public static int getIntFromKeyboard(String question) {
        int intLeido;
        BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println(question);
                String cadena = consola.readLine();
                intLeido = Integer.parseInt(cadena);
                return intLeido;
            } catch (IOException ioe) {
                System.out.println("There was a problem while reading, please enter it again.");
            } catch (NumberFormatException nfe) {
                System.out.println("You must enter an integer.");
            }

        }

    }

    public static float getFloatFromKeyboard(String question) {
        float floatLeido;
        BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println(question);
                String cadena = consola.readLine();
                floatLeido = Float.parseFloat(cadena);
                return floatLeido;
            } catch (IOException ioe) {
                System.out.println("There was a problem while reading, please enter it again.");
            } catch (NumberFormatException nfe) {
                System.out.println("You must enter a float.");
            }

        }

    }

}
