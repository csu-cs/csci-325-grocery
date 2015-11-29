/**
 * Created by Matthew McCrackin for CSCI-325 2015 Grocery Program [DESKTOP]
 * File loading portion of the code by Eric Comitz
 *
 *  Handles all the fun UI stuff
 * Code should be pretty well documented and easy to follow ;)
 * All listeners are initially added for now, will implement better listener management after the list stuff is finalized
 * The main things missing from the UI currently are implementation of other classes and list viewing.
 *
 * List of current buttons:
 *
 * 1. createList : Shifts the UI to the Create List Screen   [done]
 * 2. viewList: Opens the file loader [almost done] (still needs to call the file management class)
 * 3. addElm: Opens two dialog boxes to get the item name and quanity [almost done] (still needs to pass the string and int to the list)
 * 4. removeElm: Needs to be able to delete items from the list [not done] (needs to be implemented)
 * 5. saveList: Needs to shift back to the homescreen and save the file [almost done] (needs to call the file saver)
 * 6. editList: Shifts the UI to the Create List Screen [done]
 * 7. sendList: Shifts the UI to the send screen [done]
 * 8. finalSend: Sends the list once the address/bluetooth/phone/whatever is put into the recepientInfo field [almost done] (needs to call the networking class)
 *
 * List of other components:
 * 1. homeLabel: Just a label for the home screen :) [done]
 * 2. recepientInfo: Text field for entering the recepeint info [done]
 */
// imports utilized by the class
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class UIManagement extends JPanel {
    // components used by the gui
    private JButton createList, viewList, addElm, removeElm, saveList, editList, sendList, finalSend, printList;
    private JLabel homeLabel;
    private JTextField recepientInfo;

    UIManagement() {
        // utilizes a flow layout
        setLayout(new FlowLayout());
        // create the buttons
        createList = new JButton("Create New List");
        viewList = new JButton("View List");
        addElm = new JButton("Add");
        removeElm = new JButton("Remove");
        saveList = new JButton("Save");
        homeLabel = new JLabel("Grocery List Maker");
        editList = new JButton("Edit");
        sendList = new JButton("Send");
        finalSend = new JButton("Send");
        recepientInfo = new JTextField(14);
        printList = new JButton("Print");
        // fonts and default fonts for buttons
        Font myFontSmall = new Font("Helvetica", Font.PLAIN, 28);
        Font myFontMedium = new Font("Helvetica", Font.PLAIN, 60);
        createList.setFont(myFontMedium);
        viewList.setFont(myFontMedium);
        homeLabel.setFont(myFontMedium);
        addElm.setFont(myFontSmall);
        removeElm.setFont(myFontSmall);
        saveList.setFont(myFontSmall);
        editList.setFont(myFontSmall);
        sendList.setFont(myFontSmall);
        finalSend.setFont(myFontSmall);
        printList.setFont(myFontSmall);
        // add initial buttons
        this.add(homeLabel);
        this.add(createList);
        this.add(viewList);
        // add listeners for when the buttons are pressed
        viewList.addActionListener(new viewButtonListener());
        createList.addActionListener(new createButtonListener());
        // temporarily adding listeners for these at the beginning for easy testing
        addElm.addActionListener(new addButtonListener());
        removeElm.addActionListener(new removeButtonListener());
        saveList.addActionListener(new saveButtonListener());
        editList.addActionListener(new editButtonListener());
        sendList.addActionListener(new sendButtonListener());
        finalSend.addActionListener(new finalSendListener());
        printList.addActionListener(new printListener());
        // preferred size set for testing
        this.setPreferredSize(new Dimension(600, 800));
    }
    /**
     * BEGIN HOME SCREEN LISTENER CODE
     */
    // when createList is pressed, the UI needs to change to the List Creation UI
    private class createButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("SWITCH TO LIST CREATE UI");
            remove(viewList);
            remove(createList);
            remove(homeLabel);
            add(addElm);
            add(removeElm);
            add(saveList);
            revalidate();
            repaint();
        }
    }
    // when viewList is pressed, the UI needs to change to the List Selection UI
    private class viewButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("SWITCH TO LIST SELECTION");
            JFileChooser chooser = new JFileChooser();
            int status = chooser.showOpenDialog(null);
            if (status != JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(null, "No File Chosen!");  // choosing no file goes back to the homescreen
            } else {
                File file = chooser.getSelectedFile();
                System.out.println("SUCCESS FOR FILE SELECTION!"); // file successfully is loaded
                remove(viewList);
                remove(createList);
                remove(homeLabel);
                add(editList);
                add(printList);
                add(sendList);
                List viewedList = new List(file.getName());
                revalidate();
                repaint();




                  viewedList = fileManagement.populateListFromFile(file.getPath());


            }
        }
    }
    /** END HOME SCREEN LISTENER CODE */
    /**
     * BEGIN LIST CREATE SCREEN LISTENER CODE
     */
    // when addButton is pressed, open the add box
    private class addButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("NEED TO OPEN DIALOG BOX");
            String name = null, temp;
            int quantity;
            Boolean tempFlag = true; // temporary flag variable
            // ensure an item name is entered, ask until one is entered
            while (tempFlag) {
                try {
                    name = JOptionPane.showInputDialog("Enter item name: ");
                    if (name.length() != 0) {
                        tempFlag = false;
                    }
                } catch (NullPointerException exception) {
                    JOptionPane.showMessageDialog(null, "You need to enter a name");
                }
            }
            /// ensure a proper number is entered for the quantity
            tempFlag = true;
            while (tempFlag) {
                try {
                    temp = JOptionPane.showInputDialog("Enter quantity");  // get a quantity as a string
                    quantity = Integer.valueOf(temp); // attempt to convert to int
                    System.out.println(quantity);
                    tempFlag = false; // set flag to false
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Enter a number!"); // catch for invalid number input
                }
            }
        }
    }
    // when remove is pressed, remove selected element
    private class removeButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("REMOVE ITEMS");  // NEEDS TO BE IMPLEMENTED
        }
    }
    // when save is pressed, save the list and goto main
    private class saveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {   // needs to call save method
            System.out.println("SAVE AND GOTO MAIN MENU");
            Boolean tempFlag = true;
            String listName;
            while (tempFlag) {
                try {
                    listName = JOptionPane.showInputDialog("Enter list name: ");
                    if (listName.length() != 0) {
                        tempFlag = false;
                        if (fileManagement.fileExists(listName)) {
                            int response = JOptionPane.showConfirmDialog(null, "Do you want to overwrite or delete the current file?. Yes = overwrite. " +
                                            "No = delete current file.", "Confirm",
                                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (response == JOptionPane.YES_OPTION) {
                                fileManagement.deleteFile(listName);
                                fileManagement.makeFile(listName);
                            } else if (response == JOptionPane.NO_OPTION) ;
                            fileManagement.deleteFile(listName);
                        } else
                            fileManagement.makeFile(listName);
                        List aList = new List(listName);
                        // The following items are test items!
                        Items item1 = new Items("Icecream", 10);
                        Items item2 = new Items("Chips", 9);
                        aList.itemsInList[0] = item1;
                        aList.itemsInList[1] = item2;
                        fileManagement.populateFileFromList(aList,listName);
                    }





                    //-------------------------------
                } catch (NullPointerException exception) {
                    JOptionPane.showMessageDialog(null, "You need to enter a name");
                }
            }
            add(homeLabel);
            add(createList);
            add(viewList);
            remove(addElm);
            remove(removeElm);
            remove(saveList);
            revalidate();
            repaint();
        }
    }
    /** END LIST CREATE SCREEN LISTENER CODE */
    /**
     * BEGIN LIST VIEW CODE
     */
    // swap to the list creation ui
    private class editButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("EDIT");
            remove(editList);
            remove(sendList);
            add(addElm);
            add(removeElm);
            add(saveList);
            revalidate();
            repaint();
        }
    }
    // shift to the send list ui
    private class sendButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("SHIFT TO SEND UI");
            remove(editList);
            remove(sendList);
            remove(printList);
            add(recepientInfo);
            add(finalSend);
            revalidate();
            repaint();
        }
    }
    // print it
    private class printListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("IMPLEMENT PRINT CODE");
        }
    }
    /** END LIST VIEW CODE */
    /**
     * BEGIN SEND LIST VIEW CODE
     */
    // send the list to the recepeint when finalSend is pressed and recepientInfo isn't empty
    private class finalSendListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (recepientInfo.getText().length() != 0) {
                System.out.println("SHIFT TO HOME UI. SUCCESSFUL LIST SEND");
                remove(finalSend);
                remove(recepientInfo);
                add(createList);
                add(viewList);
                revalidate();
                repaint();
            } else {
                JOptionPane.showMessageDialog(null, "Enter who to send the list to!");
            }
        }
    }
}
/** END SEND LIST VIEW CODE */
