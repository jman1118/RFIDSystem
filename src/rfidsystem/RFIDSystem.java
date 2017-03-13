/*
 * Name: James Vanaselja
 * Program to read in RFID tags using a 125KHz RFID reader.
 * Copyright James Vanaselja 2017. All Rights Reserved.
 */
package rfidsystem;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author James
 */
public class RFIDSystem {

    private static final String Allowed = "0002104953";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Boolean bool = true;
        
        Object[] options = new String[]{"Add A Tag", "Remove A Tag", "List All IDs", "Check Tag", "Exit"};
        JTextField field = new JTextField(20);
        
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

                addToList(field.getText(), list);

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
        compare = field;

        if (list.isEmpty() || !list.contains(compare)) {
            list.add(field);

            System.out.println(list);
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }

    public static void removeFromList(String field, ArrayList list) {
        //Removes the entered ID from the program.
        String compareTo = "";
        String message = "";
        compareTo = field;
        if (list.contains(compareTo)) {
            list.remove(compareTo);
            message += "Tag ID# " + compareTo + " has been removed from the system.";
            JOptionPane.showMessageDialog(null, message, "Notice", 1);
        } else if (list.isEmpty()) {
            //System.out.println("List is empty");
            JOptionPane.showMessageDialog(null, "Unable to remove item. "
                    + "List is currently empty", "Alert", 1);
        } else if (!list.contains(compareTo)) {
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

    public static void printList(ArrayList list) {
        //Prints list of IDs in system.
        int counter = 0;
        String message = "";
        if(list.isEmpty()){
                //System.out.println("Error");
            message += "List is empty";
            }
        
        for (Object list1 : list) {
            
            counter++;
            message += counter + ": ID# " + list1 + "\n";
            //System.out.println(message);
        }
        JOptionPane.showMessageDialog(null, message, "Current Tag ID's in System", 1);
    }
}
