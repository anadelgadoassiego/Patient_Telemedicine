/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import pojos.Doctor;
import pojos.Ecg;
import pojos.Emg;
import static utils.InputOutput.*;

/**
 *
 * @author RAQUEL
 */
public class Main {

    //To initialize the bufferedReader
    private static BufferedReader reader;

    public static void menu() throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to our database!");

    }

    public static String newUser() throws Exception {
        String response = "";
        System.out.println("Please, enter the following information: ");
        String name = getStringFromKeyboard("Name: ");
        Integer age = getIntFromKeyboard("Age: ");
        Float weight = getFloatFromKeyboard("Weight: ");
        Float height = getFloatFromKeyboard("Height: ");
        String gender = getStringFromKeyboard("Gender: ");

        System.out.println("Please type the new user information: ");
        String username = getStringFromKeyboard("DNI (this will be your username): ");
        String password = getStringFromKeyboard("Password: ");

        // Show all the roles and let the user choose one
        Integer roleId = 1;

        response = name + "," + age + "," + weight + "," + height + "," + gender + "," + username + "," + password + "," + roleId;

        return response;
    }

    public static String login() throws Exception {
        String response = "";
        System.out.println("Please input your credentials");
        String username = getStringFromKeyboard("Username: ");
        String password = getStringFromKeyboard("Password: ");
        response = username + "," + password;
        return response;
    }

    public static String completeForm() throws Exception {
        String response_form = "";

        System.out.println("Please answer the following questions.");
        System.out.println("For each question, enter a number between 1 (not likely) to 10 (very likely)");
        Integer q1 = getIntFromKeyboard1to10("1. Do you have difficulty or pain when opening your mouth, for example, when yawning?");
        Integer q2 = getIntFromKeyboard1to10("2. Do you feel your jaw “sticking”, “locking” or “popping out”?");
        Integer q3 = getIntFromKeyboard1to10("3. Do you have difficulty or pain when you chew, speak, or use your jaws?");
        Integer q4 = getIntFromKeyboard1to10("4. Have you noticed noises in your jaw joints?");
        Integer q5 = getIntFromKeyboard1to10("5. Do your jaws regularly feel stiff or clenched?");
        Integer q6 = getIntFromKeyboard1to10("6. Do you have pain around your ears, temples, or cheeks?");
        Integer q7 = getIntFromKeyboard1to10("7. Do you have frequent headaches or neck pain?");
        Integer q8 = getIntFromKeyboard1to10("8. Have you had a recent injury or trauma to your head, neck, or jaw?");
        Integer q9 = getIntFromKeyboard1to10("9. Have you noticed or felt any recent change in your bite?");
        Integer q10 = getIntFromKeyboard1to10("10. Have you ever been treated for a jaw joint problem?");
        Integer q11 = getIntFromKeyboard1to10("11. Have you noticed that you grind or clench your teeth frequently during sleep?");
        Integer q12 = getIntFromKeyboard1to10("12. Has anyone heard you grind your teeth at night?");
        Integer q13 = getIntFromKeyboard1to10("13. Did your jaw feel sore or fatigued when you woke up in the morning?");
        Integer q14 = getIntFromKeyboard1to10("14. Do you ever have a momentary headache when you wake up in the morning?");
        Integer q15 = getIntFromKeyboard1to10("15. Have you noticed that you grind/clench your teeth during the day?");
        Integer q16 = getIntFromKeyboard1to10("16. Do you have difficulty opening your mouth wide when you wake up?");
        Integer q17 = getIntFromKeyboard1to10("17. Do you feel pain in your teeth when they come in contact with cold air or liquids?");
        Integer q18 = getIntFromKeyboard1to10("18. Do you feel your jaw joint lock or make a clicking sound when you move it?");
        Integer q19 = getIntFromKeyboard1to10("19. Do your teeth or gums feel sore when you wake up in the morning?");
        Integer q20 = getIntFromKeyboard1to10("20. Have you noticed that you have considerable wear on your teeth?");

        response_form = q1 + "," + q2 + "," + q3 + "," + q4 + "," + q5 + "," + q6 + "," + q7 + "," + q8 + "," + q9 + "," + q10 + "," + q11 + "," + q12 + "," + q13 + "," + q14 + "," + q15 + "," + q16 + "," + q17 + "," + q18 + "," + q19 + "," + q20;
        return response_form;
    }

    public static String addEMG_addECG() throws Exception {
        String response_EMG_ECG = "";
        System.out.println("Please, enter the following information");
        String month = getStringFromKeyboard("Month: ");
        String day = getStringFromKeyboard("Day: ");
        String position = getStringFromKeyboard("position (number of record of this day): ");
        response_EMG_ECG = month + day + "_" + position;
        return response_EMG_ECG;

    }

    public static void searchEMGByName_patient(List<Emg> emgList) throws Exception {
        boolean found = false;
        String month = getStringFromKeyboard("Introduce the month: ");
        String day = getStringFromKeyboard("Introduce day: ");
        String name_emg = month + day;
        String name_select;
        for (Emg emg : emgList) {
            name_select = emg.getName_emg();
            if (name_select.contains(name_emg)) {
                System.out.println(name_select);
            }
        }

        int position = Integer.parseInt(getStringFromKeyboard("Introduce the number of the emg"));
        name_emg = "EMG_" + month + day + "_" + position + ".txt";
        for (Emg emg : emgList) {
            name_select = emg.getName_emg();
            if (name_select.equals(name_emg)) {
                System.out.println(emg);
                found = true;
                byte[] emg_values = emg.getPatient_emg();
                List<String> values = new ArrayList();
                String pasar = "";
                for (int i = 0; i < (emg_values.length) - 1; i++) {
                    char value = (char) emg_values[i];
                    int compare = (int) emg_values[i];
                    while (compare != 10) {
                        value = (char) emg_values[i];
                        compare = (int) emg_values[i];
                        if (compare != 10) {
                            pasar = pasar + value;
                            i++;
                        }

                    }
                    values.add(pasar);
                    pasar = "";

                }
                System.out.println(values.toString());
            }
        }
        if (!found) {
            System.out.println("It does not exisist...");
        }

    }

    public static void searchECGByName_patient(List<Ecg> ecgList) throws Exception {
        boolean found = false;
        String month = getStringFromKeyboard("Introduce the month: ");
        String day = getStringFromKeyboard("Introduce day: ");
        String name_ecg = month + day;
        String name_select;
        for (Ecg ecg : ecgList) {
            name_select = ecg.getName_ecg();
            if (name_select.contains(name_ecg)) {
                System.out.println(name_select);
            }
        }

        int position = Integer.parseInt(getStringFromKeyboard("Introduce the number of the ecg: "));
        name_ecg = "ECG_" + month + day + "_" + position + ".txt";
        for (Ecg ecg : ecgList) {
            name_select = ecg.getName_ecg();
            if (name_select.equals(name_ecg)) {
                System.out.println(ecg);
                found = true;
                byte[] ecg_values = ecg.getPatient_ecg();
                List<String> values = new ArrayList();
                String pasar = "";

                for (int i = 0; i < (ecg_values.length) - 1; i++) {
                    char value = (char) ecg_values[i];
                    int compare = (int) ecg_values[i];
                    while (compare != 10) {
                        value = (char) ecg_values[i];
                        compare = (int) ecg_values[i];
                        if (compare != 10) {
                            pasar = pasar + value;
                            i++;
                        }

                    }
                    values.add(pasar);
                    pasar = "";

                }
                System.out.println(values.toString());
            }
        }
        if (!found) {
            System.out.println("It does not exisist...");
        }

    }

    public static int chooseDoctor(List<Doctor> doctorList) throws Exception {
        int id = 0;
        
        System.out.println("List of available doctors:");
        for (Doctor doctor : doctorList) {
            System.out.println(doctor.toString());
        }

        String name_select_doctor;
        
        System.out.println("1. Choose an id because I don't know any doctor");
        System.out.println("2. Choose an specific doctor");
        Integer choice = new Integer(0);
        boolean wrongtext = false;
        do {
            try {
                choice = Integer.parseInt(getStringFromKeyboard("Introduce the number of the option you would like to choose: "));
                wrongtext = false;
            } catch (NumberFormatException ex) {
                wrongtext = true;
                System.out.println("It's not an int, please enter an int");
            }
        } while (choice < 1 || choice > 2 || wrongtext);

        switch (choice) {
            case 1:
                id = Integer.parseInt(getStringFromKeyboard("Introduce the id of the doctor you would like to choose: "));
                break;
            case 2:
                String name_doctor = getStringFromKeyboard("Introduce the name of the doctor: ");
                for (Doctor doctor : doctorList) {
                    name_select_doctor = doctor.getFull_name();
                    if (name_select_doctor.contains(name_doctor)) {
                        System.out.println(doctor.toString());
                    }
                }
                id = Integer.parseInt(getStringFromKeyboard("Introduce the id of the doctor you would like to choose: "));
                break;
        }
        return id;

    }

    public static String changeUsername() {
        String newName = getStringFromKeyboard("Introduce your new username: ");
        return newName;
    }

    public static String changePassword() {
        String newPassword = getStringFromKeyboard("Introduce your new password: ");
        return newPassword;
    }

}
