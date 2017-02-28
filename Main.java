
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nnnnew
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        try {
            File filePath = new File(args[0]);
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            BinarySearchTree bst = new BinarySearchTree();
        
            String line = reader.readLine();
            //System.out.println(line);
            while(line != null) {
                if(line.length() == 0) {
                    line = reader.readLine();
                    continue;
                }
                String[] command = line.split(" ");
                doCommand(command, bst);
                line = reader.readLine();
                //System.out.println(line); 
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not Found");
            return;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No file input arguments");
            return;
        }

    }
    
    private static void doCommand(String[] command, BinarySearchTree bst) {
        if(!isCommand(command[0])) {
            System.out.println("No command");
        }
        else if(command[0].equalsIgnoreCase("I")) {
            bst.addElement(Integer.parseInt(command[1]));
        }
        else if(command[0].equalsIgnoreCase("D")) {
            bst.removeNode(Integer.parseInt(command[1]));
        }
        else if(command[0].equalsIgnoreCase("P")) {
            bst.printTree(bst.getRoot(), 0);
            System.out.println();
        }
        else if(command[0].equalsIgnoreCase("H")) {
            int height = bst.getHeight(bst.getRoot());
            System.out.println("Height tree is " + height);
        }
        else {
            System.out.println("Exit program");
            System.exit(0);
        }
        
    }
    
    private static boolean isCommand(String str) {
        String[] commandSet = {"D", "E", "H", "I", "P"};
        if(Arrays.binarySearch(commandSet, str) != -1) {
            return true;
        }
        return false;
        
    }
}
