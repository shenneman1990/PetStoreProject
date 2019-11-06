/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalpetstore;

import static finalpetstore.Pet.pcount;
import static finalpetstore.Pet.petarraylist;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author samhenneman
 */
public class PetsDatabase {
    
    public String file = "pet.txt";
    private ArrayList<Pet> pets = new ArrayList<Pet>();
    public int size;
    
    public PetsDatabase() {
        Scanner s = new Scanner(System.in);
        this.file = s.nextLine().trim();
        this.pets = new ArrayList<>();
        this.size = 0;
    }
    
    public void load() {
        Scanner fileReader;
        
        try {
            fileReader = new Scanner(new File(file));
            while(fileReader.hasNextLine()) {
                String line = fileReader.nextLine().trim();
                String[] data = line.split(",");
                
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                this.pets.add(new Pet(name, age));
            } fileReader.close();
            
            } catch (FileNotFoundException f) {
                    System.out.println("Error: Cannot find" + file + ".\n");
                    System.exit(1);
        }
        
    }
    
    public void showPets(){
        if(this.pets.isEmpty())
            System.out.println("There are no pets to show");
        else {
        System.out.println("+-------------------------+");
        System.out.printf("|%-3s |%-12s | %2s|","ID","NAME","AGE");      //table layout for output
        System.out.println("");
        System.out.println("+-------------------------+");
        
        for(int count = 0; count < pcount; count++) {
            
            System.out.printf("|%-3d |%-12s |  %2d|", count, petarraylist[count].getName(), petarraylist[count].getAge());
            System.out.println("");
            
        } 
        System.out.println("+-------------------------+");              //finish table layout for output
        System.out.println(pcount + " pets added to the list.");        //let user know how many pets were added succesfully
    }
  }
    
    public void addNewPets() {      //method for adding a pet (name and age) to the array petarraylist
        Scanner s = new Scanner(System.in);
        String line;
        String name = s.next();
        int age = s.nextInt();
        int count = 0;
        
        do {
        System.out.print("Please add your pet here (name, age):  ");
        line = s.nextLine().trim();
        if(line.equalsIgnoreCase("done"))
            break;
        
        if(size >= 5) {
            System.out.println("Error: No more pets can be added");
            return;
        }
        
        while (line.split("").length !=2 || isInt(line.split("")[0]) || 
                (Integer.parseInt(line.split("")[1]) < 1 || Integer.parseInt(line.split("")[1]) > 20)) {
            if(line.split("").length !=2) {
                System.out.print("Error " + line + "is not a valid input");
                System.out.print("add pet(name,age)");
                line = s.nextLine().trim();
            }
            
        }
        
        
        
        String[] data = line.split("");
        name = data[0];
        age = Integer.parseInt(data[1]);
        
        this.pets.add(new Pet(name,age));
        size ++;
        pcount++;
        }
        while(line.equalsIgnoreCase("done"));
        System.out.println(size + "pets added.");

    }
    
    private boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
            
        } catch(NumberFormatException n) {
            return false;
        }
    }
    
    public void removePets() {
        showPets();
        
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the Id of the pet you want to remove: ");
        int Id = Integer.parseInt(s.nextLine().trim());
        if(Id < 0 || Id > size) {
            System.out.println("Error: ID" + Id + "does not exist.");
        } else {
            String remName = this.pets.get(Id).getName();
            int remAge = this.pets.get(Id).getAge();
            
            this.pets.remove(Id);
            size--;
            System.out.println(remName + " " + remAge + " is removed.");
            
        }
    }
    
    public void writeToFile() {
        FileWriter f;
        PrintWriter p;
        
        try {
            f = new FileWriter(new File(file));
            p = new PrintWriter(f);
            
            for(Pet pets : this.pets) {
                p.write(pets.getName() + "," + pets.getAge());
                
            }
            
            
        } catch (IOException ie) {
            System.out.println("Error writing to file" + file + "-");
            
        }
        
    }
    
}
