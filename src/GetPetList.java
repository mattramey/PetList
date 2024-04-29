/*
 * Java Advanced
 * Final project demonstrating all key concepts
 * 4/19/2024
 * Matt Ramey
 */

 //runable class that reads pet records from a file 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
 public class GetPetList {// open GetPetList class
     public static void main(String[] args) throws FileNotFoundException {// open main()
// Print assignment information
System.out.println("Java Advanced");
System.out.println("Demonstrate all key concepts");
System.out.println(java.time.LocalDate.now());
System.out.println("Matt Ramey");
// open scanner to take user input for a file name
         try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the file name: ");
            String fileName = scanner.nextLine();
//user buffered reader to read each line of the file. the variable line will store each line read
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
// create an arrayList to store pet objects              
                ArrayList<Pet> petList = new ArrayList<>();
// a while loop will read each line untile the file ends. this logic will trim and skip any empty lines
                while ((line = br.readLine()) != null) {
                    if (line.trim().isEmpty()) {
                        continue; 
                    }
                    String[] partOfLine = line.split(":"); // use : delimiter to seperate segments of line
// check if the record has the minimum 5 instances and if not throw an error and skip
                    if (partOfLine.length < 5) {
                        System.out.println("Invalid pet record: " + line);
                        continue;
                    }
                    String petType = partOfLine[0];
                    String name = partOfLine[1];
                    int age;
                    try {
                        age = Integer.parseInt(partOfLine[2]); // parse age to an int and throw a numberFormatException if the value is not a digit
                    } catch (NumberFormatException e) { // use PetException to output an age format error
                        throw new PetException("Invalid age format for pet " + name );
                        
                    }
                    String color = partOfLine[3];// [3] accesses the element at index 3 
                    String gender = partOfLine[4];
// use a switch statement to create individual pet objects 
                    switch (petType) { 
                        case "Dog":// override constructor and add addidtional details specific to the pet from the array
// the logic going to be used will be the ternary operator ? : this is a short way to write an if else 
                            String breed = partOfLine.length > 5 ? partOfLine[5] : "N/A";
// partOfLin.length > 6 checks to see if array is > 6 this will avoid ArrayIndexOutOfBounds. Boolean.parseBoolean(partOfLine[6]) this will parse the string at index 6 if the condition is true. :false if this condition is false the value in index 6 will be assigned to requiresHeat.
                            boolean tailWags = partOfLine.length > 6 ? Boolean.parseBoolean(partOfLine[6]) : false;
                            boolean slobbery = partOfLine.length > 7 ? Boolean.parseBoolean(partOfLine[7]) : false;
                            boolean canCatchBall = partOfLine.length > 8 ? Boolean.parseBoolean(partOfLine[8]) : false;
    // create a new Dog object and add to array
                            petList.add(new Dog(name, age, color, gender, breed, tailWags, slobbery, canCatchBall));
                            break;
                        case "Bird":
                            String species = partOfLine.length > 5 ? partOfLine[5] : "N/A"; // If breed is left blank use "N/A as default value"
                            boolean canTalk = partOfLine.length > 6 ? Boolean.parseBoolean(partOfLine[6]) : false;
                            int maxAltitude = partOfLine.length > 7 ? Integer.parseInt(partOfLine[7]) : 0;
    // create a new Bird object and add to array
                            petList.add(new Bird(name, age, color, gender, species, canTalk, maxAltitude));
                            break;
                        case "Turtle":
                            String habitat = partOfLine.length > 5 ? partOfLine[5] : "N/A";
                            boolean requiresHeat = partOfLine.length > 6 ? Boolean.parseBoolean(partOfLine[6]) : false;
    // create a new Turtle object and add to array
                            petList.add(new Turtle(name, age, color, gender, habitat, requiresHeat));
                            break;
    // throw an error for an unknown pet type
                        default:
                            throw new PetException("Unknown pet type: " + petType);
                    }// close switch
                }

                // use a for each loop to itterate through petlist. and call walk() method for each pet
                for (Pet pet : petList) {
                    pet.walk();
                }// close for each loop
    // use a catch block to handle a misspelled file name.
            } catch (IOException e) {
                System.out.println("Error reading the input file.");
            }
         }
     }// close main()
 }// close GetPetList

