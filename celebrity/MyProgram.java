/*IF NOT FROM EDHESIVE, READ:
If doing this lab independently, you can do this activity using several class files. Since I cannot create my own Java files in Edhesive, I am limited to only one file. It is still possible to write multiple classes and subclasses in this file after the MyProgram class, however you will not be able to declare these as public, since they would need to be in a file with the same name as this. There is a very brief example in this file already to show you how this works.
*/

public class MyProgram{
  public static void main(String[] args){
    Parent a = new Child();
    System.out.println(a);
  }
}
// MyProgram should be the only class, and it should appear at the top of the file (or main method won't be found)


class Parent{
  public String location(){
  System.out.println("They reside in Martinez.")
 } 
  
  public String toString(){
    return "Parent class";
  }
}

class Child extends Parent{
  @Override
  public String toString(){
    return "Child class";
  }
}

/*
