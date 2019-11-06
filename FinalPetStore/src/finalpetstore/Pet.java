/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalpetstore;
import java.util.Scanner;
/**
 *
 * @author samhenneman
 * Last release to add, show, search, update and remove pets 
 */
public class Pet {                                                     
    public static Scanner s = new Scanner(System.in);
    public static Pet[] petarraylist = new Pet[5];
    
    public static int pcount = 0;                                       //set initial count to 0 for id
    private String name;
    private int age;

    public Pet(String name, int age){
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        PetsDatabase petsDB = new PetsDatabase();
        petsDB.load();
        
        while(true) {
        System.out.println("Welcome to the Pet Store!");
            switch(getChoice()){                                         //switch case for determing what the user selects in the menu
                case 1: petsDB.showPets();
                break;
                case 2: petsDB.addNewPets(); 
                    break;
                case 3: petsDB.removePets(); 
                    break;
                case 4: petsDB.writeToFile();
                    System.out.println("Thank you for using the Pet Store program. "); 
                    break;
                }
            }
    }
        public static int getChoice(){                                      //what is displayed to the user for their options 
        System.out.println("");
        System.out.println("What would you like to do?");
        System.out.println(" 1) View all pets");
        System.out.println(" 2) Add more pets");              
        System.out.println(" 3) Remove a pet");                 
        System.out.println(" 4) Exit the program");                     //exit the program 
        System.out.print("Your Choice is: ");
        int getchoice = s.nextInt();
        return getchoice;
        
        
        
    }
        
}