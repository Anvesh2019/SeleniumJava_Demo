package seleniumDemo.TestCases;
import seleniumDemo.TestCases.clsAnimal;

class clsDog extends clsAnimal {
    @Override
    void sound(int sno,String sname) {
        System.out.println("Dog barks from child class");
        
    }
}

