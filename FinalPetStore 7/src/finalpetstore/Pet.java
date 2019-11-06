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
public class Pet {                                                     //Pet class responsible for getters and setters for name and age
    
    public static Scanner s = new Scanner(System.in);
    public static Pet[] petarraylist = new Pet[5];                      //new array petarraylist
    
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
    
    public static int getChoice(){                                      //what is displayed to the user for their options 
        System.out.println("");
        System.out.println("What would you like to do?");
        System.out.println(" 1) View all pets");
        System.out.println(" 2) Add more pets");
        System.out.println(" 3) Search for pets");                      //added in searching for pets (choice 3)
        System.out.println(" 4) Update existing pets");                 //added in updating existing pets (choice 4)
        System.out.println(" 5) remove existing pets");                 //added in deleting existing pets (choice 5)
        System.out.println(" 6) exit the program");                     //exit the program 
        System.out.print("Your Choice is: ");
        int getchoice = s.nextInt();
        return getchoice;
    }
    
    public static void showPets(){
        System.out.println("+-------------------------+");
        System.out.printf("|%-3s |%-12s | %2s|","ID","NAME","AGE");      //table layout for output
        System.out.println("");
        System.out.println("+-------------------------+");
        for(int count = 0; count < pcount; count++){
            System.out.printf("|%-3d |%-12s |  %2d|", count, petarraylist[count].getName(), petarraylist[count].getAge());
            System.out.println("");
            
        } 
        System.out.println("+-------------------------+");              //finish table layout for output
        System.out.println(pcount + " pets added to the list.");        //let user know how many pets were added succesfully
    }
    
    public static void addNewPets() {                                   //method for adding a pet (name and age) to the array petarraylist
        String name = s.next();
        int age = s.nextInt();
        int count = 0;
        System.out.print("Please add your pet here (name, age):  ");
        Pet pnew = new Pet(name,age);
        petarraylist[pcount] = pnew;                                    //adding pnew (new name and age) to the array list
        pcount++;
    }
    
    
    public static void Search() {                                       //new searching for pets
        System.out.print("Enter the pet you want to search: ");
        String name = s.next();                                         //looking for pet based on name
        for(int count = 0; count < pcount; count++) {
            if(name.equals(petarraylist[count].getName())) {            //determing where the pet is in the array list to get the values to display
                System.out.printf("|%-3d |%-12s |  %2d|", count, petarraylist[count].getName(), petarraylist[count].getAge());
                System.out.println("");
            }
        }
    }
    
    
    public static void updatePets() {                                   //new updating pets
        System.out.print("Enter Pet Id you wish to change: ");
        int id = s.nextInt();
        for(int count = 0; count < pcount ;count++) {
            if(id == count) {
                System.out.print("Enter the updated information for the selected pet ");
                String newN = s.next();
                int newA = s.nextInt();
                petarraylist[count].setName(newN);                      //setting a new value for updated pets (newName, newAge)
                petarraylist[count].setAge(newA);                       //setting the name and age of the pet selected to the new values
                System.out.println("Pet " + count + " was updated to " + newN + " " + newA);
                
            }
        }
    }
    
    
    public static void removePets() {                                   //deleting existing pets
        System.out.print("Enter the ID of the pet you wish to remove: ");
        int id = s.nextInt();
        for(int count = 0; count < pcount; count++){
            if(id == count) {
                petarraylist[count] = petarraylist[count-1];            //taking one value from the array list based on what pet is selected
                System.out.println("Pet " + count + "has been removed from the list.");
                break;
            }
        }
    }
    
    
    public static void main(String[] args){
        loop:
        while(true) {
        System.out.println("Welcome to the Pet Store!");
            switch(getChoice()){                                         //switch case for determing what the user selects in the menu
                case 1: showPets(); 
                    break;
                case 2: addNewPets(); 
                    break;
                case 3: Search(); 
                    break;
                case 4: updatePets();
                    break;
                case 5: removePets(); 
                    break;
                case 6: System.out.println("Thank you for using the Pet Store program. "); 
                    break loop;
                }
            }
        }
}