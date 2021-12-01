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
import java.util.List;

/**
 *
 * @author RAQUEL
 */
public class Main {
    //To initialize the bufferedReader
        private static BufferedReader reader; // To read from the console
        public static void menu() throws Exception {
            reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Welcome to our database!");
            // System.out.println("Do you want to create the tables?");
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
                        choice = Integer.parseInt(reader.readLine());
                        wrongtext = false;
                    } catch (NumberFormatException ex) {
                        wrongtext = true;
                        System.out.println("It's not an int, please enter an int");
                    }
                } while (choice < 0 || choice > 2 || wrongtext);
                switch (choice) {
                    case 1:
                        newUser();
                        break;
                    case 2:
                        login();
                        break;
                    case 0:
                        dbManager.disconnect();
                        userManager.disconnect();
                        return;
                    default:
                        break;
                }
            }

        }

      /*
        private static void newUser() throws Exception {
            List<Role> roles = userManager.getRoles();
            if (roles.isEmpty()) {
                System.out.println("There are not roles, please create the roles");
                return;
            }
            System.out.println("Please type the new user information: ");
            System.out.print("Username: ");
            String username = reader.readLine();
            System.out.print("Password: ");
            String password = reader.readLine();

            // Create the password's hash
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] hash = md.digest();
            // Show all the roles and let the user choose one
            Integer roleId = new Integer(0);
            boolean wrongtext = true;
            String exit = "1";
            do {
                if (exit.equals("yes") || exit.equals("Yes")) {
                    break;
                }
                for (Role role : roles) {

                    System.out.println(role);

                }
                System.out.print("Type the chosen role ID: ");
                try {
                    roleId = Integer.parseInt(reader.readLine());
                    wrongtext = false;
                } catch (NumberFormatException ex) {
                    wrongtext = true;
                    System.out.println("It's not an int, please enter an int");
                }
                if (roleId != 2 && roleId != 1) {
                    System.out.println("That's not a valid ID, if you want to exit this option type 'yes': ");
                    exit = reader.readLine();
                }
                if (roleId == 1) {
                    System.out.println("Patients can only be created by doctors (not here). Introduce another Id: ");
                    roleId = 3;
                }
            } while (roleId != 1 && roleId != 2);
            if (exit.contentEquals("yes") || exit.contentEquals("Yes")) {
                return;
            }
            Role chosenRole = userManager.getRole(roleId);
            // Create the user and store it
            User user = new User(username, hash, chosenRole);

            userManager.createUser(user);

            //String pharmacyName = username;
            System.out.println("Enter your full name: ");
            String fullname = reader.readLine();


            Doctor doctor = new Doctor(fullname,username);
            doctorManager.add(doctor);

        }
*/
        private static void login() throws Exception {
            System.out.println("Please input your credentials");
            System.out.print("Username: ");
            String username = reader.readLine();
            System.out.print("Password: ");
            String password = reader.readLine();
            User user = userManager.checkPassword(username, password);
            // We check if the user/password combination was OK
            if (user == null) {
                System.out.println("Wrong credentials, please try again!");
            } else if (user.getRole().getRole().equalsIgnoreCase("patient")) {
                System.out.println("Welcome patient " + username + "!");
                patientName = username;
                patientMenu();
            } else {
                System.out.println("Invalid role");
            }
        }
        
    private static void patientMenu() throws Exception {
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1. Complete form");
            System.out.println("2. Add EMG");
            System.out.println("3. Add ECG");
            System.out.println("4. Search EMG by start date");
            System.out.println("5. Search ECG by start date");
            System.out.println("6. Change your user name");
            System.out.println("7. Change your password");
            System.out.println("8. Go back");
            Integer choice = new Integer(0);
            boolean wrongtext = false;
            do {
                System.out.println("Introduce the number of the option you would like to choose: ");
                try {
                    choice = Integer.parseInt(reader.readLine());
                    wrongtext = false;
                } catch (NumberFormatException ex) {
                    wrongtext = true;
                    System.out.println("It's not an int, please enter an int");
                }
            } while (choice < 0 || choice > 8 || wrongtext);
            switch (choice) {
                case 1:
                    completeForm();
                    break;
                case 2:
                    addEMG();
                    break;
                case 3:
                    addECG();
                    break;
                case 4:
                    searchEMGByName();
                    break;
                case 5:
                    searchECGByName();
                    break;
                case 6:
                    String username = userManager.updateUsername(patientName);
                    patientManager.updateUsername(patientName, username);
                    return;
                case 7:
                    userManager.updatePassword(patientName);
                    return;
                case 8:
                    return;
            }
        }
    }

    private static void completeForm() throws Exception {
        Integer patient_id = patientManager.searchByUsername(patientName);
        Patient patient = patientManager.getPatient(patient_id);

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
        
       
        String nameForm = patientName+("_form.txt");
        File file = new File(nameForm);
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(file);
            printWriter.print("1. Do you have difficulty or pain when opening your mouth, for example, when yawning? -> " + q1.toString());
            printWriter.print("\n2. Do you feel your jaw “sticking”, “locking” or “popping out”? -> " + q2.toString());
            printWriter.print("\n3. Do you have difficulty or pain when you chew, speak, or use your jaws? -> " + q3.toString());
            printWriter.print("\n4. Have you noticed noises in your jaw joints? -> " + q4.toString());
            printWriter.print("\n5. Do your jaws regularly feel stiff or clenched? -> " + q5.toString());
            printWriter.print("\n6. Do you have pain around your ears, temples, or cheeks? -> " + q6.toString());
            printWriter.print("\n7. Do you have frequent headaches or neck pain? -> " + q7.toString());
            printWriter.print("\n8. Have you had a recent injury or trauma to your head, neck, or jaw? -> " + q8.toString());
            printWriter.print("\n9. Have you noticed or felt any recent change in your bite? -> " + q9.toString());
            printWriter.print("\n10. Have you ever been treated for a jaw joint problem? -> " + q10.toString());
            printWriter.print("\n11. Have you noticed that you grind or clench your teeth frequently during sleep? -> " + q11.toString());
            printWriter.print("\n12. Has anyone heard you grind your teeth at night? -> " + q12.toString());
            printWriter.print("\n13. Did your jaw feel sore or fatigued when you woke up in the morning? -> " + q13.toString());
            printWriter.print("\n14. Do you ever have a momentary headache when you wake up in the morning? -> " + q14.toString());
            printWriter.print("\n15. Have you noticed that you grind/clench your teeth during the day? -> " + q15.toString());
            printWriter.print("\n16. Do you have difficulty opening your mouth wide when you wake up? -> " + q16.toString());
            printWriter.print("\n17. Do you feel pain in your teeth when they come in contact with cold air or liquids? -> " + q17.toString());
            printWriter.print("\n18. Do you feel your jaw joint lock or make a clicking sound when you move it? -> " + q18.toString());
            printWriter.print("\n19. Do your teeth or gums feel sore when you wake up in the morning? -> " + q19.toString());
            printWriter.print("\n20. Have you noticed that you have considerable wear on your teeth? -> " + q20.toString());

        } catch (IOException ex) {
            System.out.println("There was an error while saving");

        } finally {
            if (printWriter != null) {
                printWriter.close();
            }

        }
        String filePath = nameForm;
        byte[] patient_form = Files.readAllBytes(Paths.get(filePath));
        System.out.println(patient_form);
        patient.setPatient_form(patient_form);
        patientManager.addForm(patient);
        System.out.println("Form saved successfully");


    }

    private static void searchECGByName() throws Exception{
        Integer patient_id = patientManager.searchByUsername(patientName);
        List<Ecg> ecgList = ecgManager.getECGpatient(patient_id);
        searchECGByName_patient(ecgList);
    }
    
     private static void searchEMGByName() throws Exception{
        Integer patient_id = patientManager.searchByUsername(patientName);
        List<Emg> emgList = emgManager.getEMGpatient(patient_id);
        searchEMGByName_patient(emgList);
    }
    
    private static void addEMG() throws Exception {
        System.out.println("Please, enter the following information");
        System.out.println("Month: ");
        String month = reader.readLine();
        System.out.println("Day: ");
        String day = reader.readLine();
        System.out.println("position: ");
        String position = reader.readLine();
        String name = month + day + "_" + position ;
        Integer patient_id = patientManager.searchByUsername(patientName);

        Emg emg = new Emg(name, patient_id);
        emgManager.add(emg);
    }

    private static void addECG() throws Exception {
        System.out.println("Please, enter the following information");
        System.out.println("Month: ");
        String month = reader.readLine();
        System.out.println("Day: ");
        String day = reader.readLine();
        System.out.println("position: ");
        String position = reader.readLine();
        String name = month + day + "_" + position ;
        Integer patient_id = patientManager.searchByUsername(patientName);

        Ecg ecg = new Ecg(name, patient_id);

        ecgManager.add(ecg);
    }

    public static String getPassword(int length) {
        return getPassword(numbers + caps + low_case, length);
    }

    public static String getPassword(String key, int length) {
        String pswd = "";

        for (int i = 0; i < length; i++) {
            pswd += (key.charAt((int) (Math.random() * key.length())));
        }

        return pswd;
    }

    public static String getPassword() {
        return getPassword(8);
    }

}
