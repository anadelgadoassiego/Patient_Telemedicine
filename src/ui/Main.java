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
import pojos.Ecg;
import pojos.Emg;
import pojos.Patient;
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
            
            response = name+","+age+","+weight+","+height+","+gender+","+username+","+password+","+roleId;
            //response = "Amancio,88,100.0,150.55,Male,Amancio123,Amancio123,1";
            System.out.println(response);
            
            return response;
        }

        public static String login() throws Exception {
            String response = "";
            System.out.println("Please input your credentials");
            String username = getStringFromKeyboard("Username: ");
            String password = getStringFromKeyboard("Password: ");
            response = username+","+password;
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
        
        
        response_form = q1+","+q2+","+q3+","+q4+","+q5+","+q6+","+q7+","+q8+","+q9+","+q10+","+q11+","+q12+","+q13+","+q14+","+q15+","+q16+","+q17+","+q18+","+q19+","+q20;
        return response_form;
    }

    
    public static void searchEMGByName_patient(List<Emg> emgList) throws Exception{
        String month = getStringFromKeyboard("Introduce the month: ");
        String day = getStringFromKeyboard("Introduce day: ");
        String name_emg = day + month ;
        String name_select;
        for (Emg emg  : emgList) {
             name_select = emg.getName_emg();
             if (name_select.contains(name_emg)){
                System.out.println(name_select);
             }
        } 
        
        System.out.println("Introduce the number of the emg");
        int position = Integer.parseInt(reader.readLine());
        name_emg = day + month + "_" + position ; 
        for (Emg emg : emgList){
            name_select = emg.getName_emg();
             if (name_select == name_emg){
                System.out.println(emg);
             }
        }
        
    }
    
        
    public static void searchECGByName_patient(List<Ecg> ecgList) throws Exception{
        String month = getStringFromKeyboard("Introduce the month: ");
        String day = getStringFromKeyboard("Introduce day: ");
        String name_ecg = day + month ;
        String name_select;
        for (Ecg ecg  : ecgList) {
             name_select = ecg.getName_ecg();
             if (name_select.contains(name_ecg)){
                System.out.println(name_select);
             }
        } 
        
        System.out.println("Introduce the number of the emg");
        int position = Integer.parseInt(reader.readLine());
        name_ecg = day + month + "_" + position ; 
        for (Ecg ecg : ecgList){
            name_select = ecg.getName_ecg();
             if (name_select == name_ecg){
                System.out.println(ecg);
             }
        }
        
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

 
    public static String changeUsername() {
        String newName = getStringFromKeyboard("Introduce your new username: ");
        return newName;
    }
    public static String changePassword() {
        String newPassword = getStringFromKeyboard("Introduce your new password: ");
        return newPassword;
    }
    
    private static void addPatient() throws Exception {
        System.out.println("Please, enter the following information: ");
        System.out.println("Name: ");
        String name = reader.readLine();
        System.out.println("Age: ");
        Integer age = Integer.parseInt(reader.readLine());
        System.out.println("Weight: ");
        Float weight = Float.parseFloat(reader.readLine());
        System.out.println("Height: ");
        Float height = Float.parseFloat(reader.readLine());
        System.out.println("Gender: ");
        String gender = reader.readLine();

        Patient patient = new Patient(name, age, weight, height, gender);

        String username = "";
        boolean distinctUser = false;
        do {
            System.out.println("Introduce a username for the patient: ");
            username = reader.readLine();
            List<String> existUsernames = new ArrayList<String>();
            existUsernames = patientManager.getUsernames();
            if (existUsernames.contains(username)) {
                distinctUser = true;
            } else {
                distinctUser = false;
            }
        } while (distinctUser);

        String UserName = username;
        System.out.print("Password: ");
        String password = getPassword();
      
        // Create the password's hash
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] hash = md.digest();
        int roleId = 1;
        // Get the chosen role from the database
        Role chosenRole = userManager.getRole(roleId);
        // Create the user and store it
        User user = new User(UserName, hash, chosenRole);
        userManager.createUser(user);
        patient.setNameuser(UserName);
        patientManager.add(patient);
        int patientId=dbManager.getLastId();
        System.out.println(patientId);
        int doctorId = doctorManager.getId(doctorName);
        System.out.println(doctorId);
        doctorManager.asign(doctorId, patientId);

        
        
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
