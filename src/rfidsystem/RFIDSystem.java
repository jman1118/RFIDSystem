/*
 * Name: James Vanaselja
 * Program to read in RFID tags using a 125KHz RFID reader.
 * Copyright James Vanaselja 2017. All Rights Reserved.
 */
package rfidsystem;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author James
 */
public class RFIDSystem {
    //hardwired tag id
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
             Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Unable to remove item. "
                    + "List is currently empty", "Alert", 1);
        } else if (!list.contains(compareTo)) {
             Toolkit.getDefaultToolkit().beep();
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
    public static void printList(ArrayList list) {
        //Prints list of IDs in system.
        int counter = 0;
        String message = "";
        if(list.isEmpty()){
                //System.out.println("Error");
            message += "List is empty";
             Toolkit.getDefaultToolkit().beep();
            }
        
        for (Object list1 : list) {
            
            counter++;
            message += counter + ": ID# " + list1 + "\n";
            //System.out.println(message);
        }
        JOptionPane.showMessageDialog(null, message, "Current Tag ID's in System", 1);
    }
}
