public class Pet {// open pet class

    // set instances for pet constructor
    public String name;
    private int age;
    private String gender;
    private String bodyColor;

    //create pet constructor with with instance parameters
    public Pet (String name, int age, String gender, String bodyColor ){// open pet constructor
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.bodyColor = bodyColor;


    }// close pet constructor
    
    // getter methods 
    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getGender(){
        return gender;
    }

    public String bodyColor(){
        return bodyColor;
    }

public void walk(){
    System.out.println("Take" + name + "on a walk!");
}


}// close pet class
