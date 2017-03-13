/*
 * Name: James Vanaselja
 * Program to read in RFID tags using a 125KHz RFID reader.
 * Copyright James Vanaselja 2017. All Rights Reserved.
 */
package rfidsystem;
<<<<<<< HEAD
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
=======

import java.util.ArrayList;
>>>>>>> 237384f71c86692ba120c2c56ae1777d033a0cbd
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author James
 */
public class RFIDSystem {
<<<<<<< HEAD
    //hardwired tag id
    private static final String Allowed = "0002104953";
=======
   //String of the test ID
   // private static final String Allowed = "0002104953";
>>>>>>> 237384f71c86692ba120c2c56ae1777d033a0cbd

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Boolean bool = true;
        
        Object[] options = new String[]{"Add A Tag", "Remove A Tag", "List All IDs", "Check Tag", "Exit"};
        JTextField field = new JTextField(20);
        
<<<<<<< HEAD
        
        
=======
>>>>>>> 237384f71c86692ba120c2c56ae1777d033a0cbd
        ArrayList list = new ArrayList();
        Object[] message = {
            "Scan Tag Now:\n", field
        };
        while (bool) {
            int option = JOptionPane.showOptionDialog(null, message, "RFID Tag Reading Program",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, null);

            if (option == 0) {
               // System.out.println("Option: " + option);
<<<<<<< HEAD
                
                addToList(field.getText(), list);
               
=======

                addToList(field.getText(), list);

>>>>>>> 237384f71c86692ba120c2c56ae1777d033a0cbd
            } else if (option == 1) {
               // System.out.println("Option: " + option);
                removeFromList(field.getText(), list);

            } else if (option == 2) {
                //System.out.println("Option: " + option);
                printList(list);
            } else if (option == 3) {
                //System.out.println("Option: " + option);
                validateID(field.getText(), list);
            } else {
                bool = false;
                /*System.out.println("option: " + option);
                System.out.println("Tag Reading aborted");
                */
                System.exit(0);
            }
        }
    }

    public static void addToList(String field, ArrayList list) {
        String compare = "";
<<<<<<< HEAD
        String message = "";
        field = sanitize(field);
        compare = field;    
 
        
        if (field.isEmpty()){
            Toolkit.getDefaultToolkit().beep();
            message += "Please scan or enter a tag number";
            JOptionPane.showMessageDialog(null, message, "Notice", 1);
             
        }
        else if (list.isEmpty() || !list.contains(compare)) {
            list.add(field);
            
=======
        compare = field;

        if (list.isEmpty() || !list.contains(compare)) {
            list.add(field);

>>>>>>> 237384f71c86692ba120c2c56ae1777d033a0cbd
            System.out.println(list);
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
<<<<<<< HEAD
        
=======
>>>>>>> 237384f71c86692ba120c2c56ae1777d033a0cbd
    }

    public static void removeFromList(String field, ArrayList list) {
        //Removes the entered ID from the program.
        String compareTo = "";
        String message = "";
<<<<<<< HEAD
        
=======
>>>>>>> 237384f71c86692ba120c2c56ae1777d033a0cbd
        compareTo = field;
        if (list.contains(compareTo)) {
            list.remove(compareTo);
            message += "Tag ID# " + compareTo + " has been removed from the system.";
            JOptionPane.showMessageDialog(null, message, "Notice", 1);
        } else if (list.isEmpty()) {
            //System.out.println("List is empty");
<<<<<<< HEAD
             Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Unable to remove item. "
                    + "List is currently empty", "Alert", 1);
        } else if (!list.contains(compareTo)) {
             Toolkit.getDefaultToolkit().beep();
=======
            JOptionPane.showMessageDialog(null, "Unable to remove item. "
                    + "List is currently empty", "Alert", 1);
        } else if (!list.contains(compareTo)) {
>>>>>>> 237384f71c86692ba120c2c56ae1777d033a0cbd
            JOptionPane.showMessageDialog(null, "Unable to remove item. "
                    + "List does not contain ID#" + compareTo, "Alert", 1);
            //System.out.println("List does not contain the requested item");
        }

    }

    public static void validateID(String field, ArrayList list) {
        /*Compares the number entered into the textfield to the list of IDs
        in the system.
        */
        String msg = "";
<<<<<<< HEAD
        
        if (list.contains(field)) {
            //System.out.println("Access Allowed");
            msg += "Access Granted!";
            JOptionPane.showMessageDialog(null, msg, "Notice", 1);
        } else if (list.isEmpty()) {
            msg += "Access Denied. No Tag ID entered";
            //System.out.println("List is empty!");
             Toolkit.getDefaultToolkit().beep();
              JOptionPane.showMessageDialog(null, msg, "Error", 1);
        } else {
            msg += "Access Denied!";
             Toolkit.getDefaultToolkit().beep();
            //System.out.println("Access Denied");
              JOptionPane.showMessageDialog(null, msg, "Error", 1);
        }
       

    }
    
    private static String sanitize(String field){
        String clean = "";
        clean = field.replaceAll("[^\\d]","");
        System.out.println("field: " + field + "\nclean: " + clean);
        return clean;
    }
=======

        if (list.contains(field)) {
            //System.out.println("Access Allowed");
            msg += "Access Granted!";

        } else if (list.isEmpty()) {
            msg += "Access Denied. No Tag ID entered";
            //System.out.println("List is empty!");
        } else {
            msg += "Access Denied!";
            //System.out.println("Access Denied");
        }
        JOptionPane.showMessageDialog(null, msg, "Error", 1);

    }

>>>>>>> 237384f71c86692ba120c2c56ae1777d033a0cbd
    public static void printList(ArrayList list) {
        //Prints list of IDs in system.
        int counter = 0;
        String message = "";
        if(list.isEmpty()){
                //System.out.println("Error");
            message += "List is empty";
<<<<<<< HEAD
             Toolkit.getDefaultToolkit().beep();
=======
>>>>>>> 237384f71c86692ba120c2c56ae1777d033a0cbd
            }
        
        for (Object list1 : list) {
            
            counter++;
            message += counter + ": ID# " + list1 + "\n";
            //System.out.println(message);
        }
        JOptionPane.showMessageDialog(null, message, "Current Tag ID's in System", 1);
    }
}
