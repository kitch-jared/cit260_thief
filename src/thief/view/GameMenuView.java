/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thief.view;

import exceptions.TrapControlExceptions;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import thief.Thief;
import thief.control.*;
import thief.model.Game;
import thief.model.InventoryItem;
import thief.model.Map;
import thief.model.Supplies;

/**
 *
 * @author Jon
 */
public class GameMenuView extends View{

    
    public GameMenuView() {
        super(
        "\n.-------------------------------------------------------------------"
      + "\n| Game Menu"
      + "\n|-------------------------------------------------------------------"
      + "\n| M - Move Location"
      + "\n| S - Search Room"
      + "\n| R - List Current Inventory"
      + "\n| N - Add Items to Inventory"
      + "\n| I - Items to Steal"
      + "\n| C - Items Stolen"
      + "\n| B - Blow Open Safe"
      + "\n| L - Pick Lock"         
      + "\n| K - Sneak"
      + "\n| D - Avoid Lasers"          
      + "\n| P - Security Keypad Equation"          
      + "\n| V - View Map"
      + "\n| H - Help"             
      + "\n| A - Save and Quit"          
      + "\n| Q - Quit"
      + "\n|-------------------------------------------------------------------");
    }

    



    @Override
    public boolean doAction(String choice) {
        
        switch (choice) {
            case "M":
                this.moveLocation();
                break;
            case "S":
                this.searchRoom();
                break;
            case "R":
                this.listCurrentInventory();
                break;
            case "N":
                this.addItemToInventory();
                break;
            case "I":
                this.itemsToSteal();
                break;
            case "C":
                this.itemsStolen();
                break;
            case "B":
        {
            try {
                this.blowUpSafe();
            } catch (TrapControlExceptions ex) {
                Logger.getLogger(GameMenuView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
            case "L":
                this.pickLock();
                break;
            case "K":
                this.sneak();
                break;
            case "D":
                this.dodgeLasers();
                break;  
            case "P":
        {
            try {
                this.keypadEquation();
            } catch (TrapControlExceptions ex) {
                Logger.getLogger(GameMenuView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;    
            case "V":
                this.viewMap();
                break;
            case "H":
                this.displayHelpMenu();
                break;
            case "A":
                this.sneak();
                break;
            default:
                ErrorView.display(this.getClass().getName(),
                      "\n***************************************"
                    + "\n***** Invalid Selection Try Again *****"
                    + "\n***************************************");
                break;
        }
        return false;
    }

    private void moveLocation() {
        MoveLocationView moveLocationMenu = new MoveLocationView();
        moveLocationMenu.display();
    }

    private void searchRoom() {
        this.console.println("*** SearchRoom stub function called ***");
    }

    private void itemsToSteal() {
        ItemsToStealView toStealMenu = new ItemsToStealView();
        toStealMenu.display();
    }

    private void itemsStolen() {
        this.console.println("*** ItemsStolen stub function called ***");
    }

    private void blowUpSafe() throws TrapControlExceptions {
        BlowUpSafeView blowUpSafe = new BlowUpSafeView();
        blowUpSafe.displayMenu();
    }

    private void pickLock() {
        this.console.println("*** PickLock stub function called ***");
    }

    private void sneak() {
        this.console.println("*** Sneak stub function called ***");
    }

    private void dodgeLasers() {
        AvoidLasersView avoidLasers = new AvoidLasersView();
        avoidLasers.displayMenu();
    }

    private void keypadEquation() throws TrapControlExceptions {
        KeypadEquationView keypadView = new KeypadEquationView();
        keypadView.displayMenu();
    }

    private void viewMap() {
        
        Game game = Thief.getCurrentGame();
        Map map = game.getMap();
        MapView viewMap = new MapView(map);
    }
    
    private void displayHelpMenu() {

        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();

    }

    private void listCurrentInventory() {
        InventoryView inventoryMenu = new InventoryView();
        inventoryMenu.display();
    }

    private void addItemToInventory() {
        ItemToInventory inventory = new ItemToInventory();
        inventory.display();
    }
    
}
