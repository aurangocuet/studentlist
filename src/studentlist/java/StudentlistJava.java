/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentlist.java;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class StudentlistJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        while (true) {
            System.out.println("1. Show all student");
            System.out.println("2. Show random student");
            System.out.println("3. Show number of students");
            System.out.println("4. Add a student");
            System.out.println("5. Find a student");
            System.out.println("6. Close");

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter option(1-5):");
            int option = sc.nextInt();

            if (option == 1) {
                BufferedReader br = getReader();
                String st;
                while ((st = br.readLine()) != null) {
                    if (st.equals(Constants.EMPTY_STRING)) {
                        continue;
                    }
                    System.out.println(st);
                }
            } else if (option == 2) {
                int count = getNumberOfStudent();
                BufferedReader br = getReader();

                String[] ids = new String[count];

                int i = 0;
                String st;
                while ((st = br.readLine()) != null) {
                    if (st.equals(Constants.EMPTY_STRING)) {
                        continue;
                    }
                    ids[i] = st;
                    i++;
                }

                int randNumber = randInt(0, count - 1);

                System.out.println("Random Student : " + ids[randNumber]);

            } else if (option == 3) {

                int count = getNumberOfStudent();
                System.out.println("Number of student : " + count);

            } else if (option == 4) {

                FileWriter fx = getWriter();
                
                System.out.print("Enter ID : ");
                String newst = sc.next();
                fx.write("\n" + newst);
                fx.close();
                System.out.println("Student Added");

            } else if (option == 5) {

                BufferedReader br = getReader();

                System.out.print("Enter ID : ");
                String checkst = sc.next();
                String st;
                int flag = 0;
                while ((st = br.readLine()) != null) {
                    if (st.equals(checkst)) {
                        flag = 1;
                    }
                }
                if (flag == 0) {
                    System.out.println("Not Found");
                } else {
                    System.out.println("Found");
                }
            }else if(option==6){
                break;
            }else {
                System.out.println("Select Correct Option");
            }
            
            System.out.println("-------END-------");
        }

    }

    public static int randInt(int min, int max) {
        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    public static int getNumberOfStudent() throws IOException {
        File file = new File(Constants.TEXT_FILE_NAME);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException ex) {
            System.out.println("Exception : " + ex.toString());
        }
        String st;
        int count = 0;
        while ((st = br.readLine()) != null) {
            if (st.equals("")) {
                continue;
            }
            count = count + 1;
        }
        return count;
    }

    public static BufferedReader getReader() {
        File file = new File(Constants.TEXT_FILE_NAME);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException ex) {
            System.out.println("Exception : " + ex.toString());
        }
        return br;
    }

    public static FileWriter getWriter() {
        FileWriter fx = null;
        try {
            fx = new FileWriter(Constants.TEXT_FILE_NAME, true);
        } catch (IOException ex) {
            System.out.println("Exception : " + ex.toString());
        }
        return fx;
    }
}
