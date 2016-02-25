/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thief.view;

import java.util.Scanner;

/**
 *
 * @author Jon
 */
public class GameMenuView {

    private String menu;
    private String promptMessage = "\n Please Enter Your Selection";
    
    public GameMenuView() {
        menu = "\n"
                + "\n                                                            "
                + "\n------------------------------------------------------------"
                + "\n Game Menu                                                  "
                + "\n------------------------------------------------------------"
                + "\nM - Move Locations                                          "
                + "\nS - Search Room                                             "
                + "\nI - Items to Steal                                          "
                + "\nC - Items Stolen                                            "
                + "\nB - Blow open Safe                                          "
                + "\nL - Pick Lock                                               "
                + "\nK - Sneak                                                   "
                + "\nD - Dodge Lasers                                            "
                + "\nP - Security Keypad Equation                                "
                + "\nV - View Map                                                "
                + "\nH - Help                                                    "
                + "\nA - Save and Quit                                           "
                + "\nQ - Quit                                                    "
                + "\n------------------------------------------------------------";
    }

    
    public void displayMenu() {
        
        boolean done = false; // set flag to not done
        do {
            // prompt for and get players name
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the game
            
            // do the requested action and display the next view
            done = this.doAction(menuOption);
        } while (!done);
        
    }

    private String getMenuOption() {
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
    String value = "";
    
    boolean valid = false; //set flag to invalid value entered
    while(!valid) { // while a valid name has not been retrieved
        
        //prompt for the player's name
        System.out.println(this.menu);
        System.out.println(this.promptMessage);
        
        value = keyboard.nextLine(); //get the name from the keyboard
        value = value.trim(); //trim off the excess blanks
        value = value.toUpperCase(); // converts to upper case letter
        
        // if the name is invalid (less than one character in length))
        if (value.length() >= 2) {
            System.out.println("Invalid value - the value cannot be more than one");
            continue; // and repeat again
        }
        if (value.length() < 1) {
            System.out.println("Invalid value - the value cannot be blank");
            continue; // and repeat again
        }
        valid = true; // set flag to end repetition
    }
    
    return value; // return the value
        
    }
    private boolean doAction(String choice) {
        
        switch (choice) {
            case "M":
                this.moveLocation();
                break;
            case "S":
                this.searchRoom();
                break;
            case "I":
                this.itemsToSteal();
                break;
            case "C":
                this.itemsStolen();
                break;
            default:
                System.out.println("\n *** Invalid Selection Try Again ***");
                break;
        }
        return false;
    }

    private void moveLocation() {
        System.out.println("*** MoveLocation stub function called ***");
    }

    private void searchRoom() {
        System.out.println("*** SearchRoom stub function called ***");
    }

    private void itemsToSteal() {
        ItemsToStealView toStealMenu = new ItemsToStealView();
        toStealMenu.displayMenu();
    }

    private void itemsStolen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
