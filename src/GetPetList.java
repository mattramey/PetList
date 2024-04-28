/*
 * Java Advanced
 * Final project demonstrating all key concepts
 * 4/19/2024
 * Matt Ramey
 */



// runable class that reads pet records from a file 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GetPetList {// open GetPetList class
    public static void main(String[] args) throws Exception {// open main()

// print asignment information
System.out.println("Java Advanced");
System.out.println("Demonstrate all key concepts");
System.out.println(java.time.LocalDate.now());
System.out.println("Matt Ramey");
        

//use scanner to get user input. the user will enter the file name of their choosing
Scanner scanner = new Scanner(System.in);
System.out.println("Enter the file you want");
String fileName = scanner.nextLine();
scanner.close();


// read the pet records from this file and create pet objects 
ArrayList<Pet> petList = new ArrayList<>();

try (BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))) {
    String line;
    while ((line = br.readLine()) != null) {
        String[] petRecord =line.split(":");
        String petType = petRecord[0].trim();
        String name = petRecord[1].trim();
        int age = Integer.parseInt(petRecord[2].trim());
        String color = petRecord[3].trim();
        String gender = petRecord[4].trim();

        switch (petType) {
            case "Dog":
                if (petRecord.length < 8) {
                    throw new PetException("Invalid Dog record format");
              }
                String breed = petRecord[5].trim();
                boolean wagsTail = Boolean.parseBoolean(petRecord[6].trim());
                boolean slobbers = Boolean.parseBoolean(petRecord[7].trim());
                petList.add(new Dog(name, age, gender, color, breed, slobbers, false, wagsTail));
                break;
            case "Bird":
                String speciesType = petRecord[5].trim();
                boolean talks = Boolean.parseBoolean(petRecord[6].trim());
                int maxAltitude = Integer.parseInt(petRecord[7].trim());
                petList.add(new Bird(name, age, gender, color, speciesType, talks, maxAltitude));
                break;
            case "Turtle":
                String habitat = petRecord[5].trim();
                boolean needsWarmth = Boolean.parseBoolean(petRecord[6].trim());
                petList.add(new Turtle(name, age, gender, color, habitat, needsWarmth));
                break;
            default:
                throw new PetException("Invalid pet type" + petType + "on line" + line);
        }
    }

    // Walk each pet
    for (Pet pet : petList) {
        pet.walk();
    }

} catch (FileNotFoundException e) {
    System.out.println("Cannot find file: " + e.getMessage());
} catch (IOException e) {
    System.out.println("Error reading file: " + e.getMessage());
} catch (PetException e) {
    System.out.println("Error parsing pet records: " + e.getMessage());
}
    }// close main()
}// close GetPetList class
