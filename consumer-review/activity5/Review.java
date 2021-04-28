import java.util.Scanner;

public class Review {
  private static String teacher;
  private static String theClass;
  private static double percentage;
  private double min;
  private double max;
  private double overallMin;
  private double overallMax;
  private static double repMin;
  private static double repMax;
  private String letterGrade;

public Review(Double min, Double max) {
  overallMin = min;
  overallMax = max;
}

public String calcLetter() {
  if(percentage >= 97)
    return "A+";
  else if(percentage >= 93)
    return "A";
  else if(percentage >= 90)
    return "A-";
  else if(percentage >= 87)
    return "B+";
  else if(percentage >= 83)
    return "B";
  else if(percentage >= 80)
    return "B-";
  else if(percentage >= 77)
    return "C+";
  else if(percentage >= 73)
    return "C";
  else if(percentage >= 70)
    return "C-";
  else if(percentage >= 67)
    return "D+";
  else if(percentage >= 63)
    return "D";
  else if(percentage >= 60)
    return "D-";
  else
    return "F";
}

public static String toString(Double repMin, Double repMax, String teacher, String theClass) {
  percentage = (int) ((repMin / repMax) * 10000);
  percentage /= 100;
  return teacher + ", " + theClass + ": " + percentage + "%";
}

public Double returnMin() {
  return overallMin;
}

public Double returnMax() {
  return overallMax;
}

//-----------------------------------------

public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        boolean run = true;
        
        String command = "";
        double runMin = 0;
	      double runMax = 0;
	      double min1 = 0;
	      double max1 = 0;

        System.out.println("Please enter your teacher's name.");
        String runTeacher = scan.nextLine();
        System.out.println("\nPlease enter the class name.");
        String runClass = scan.nextLine();
        while(run) {
          System.out.println("\nType \"Add\" to add an assignment, type \"Q\" to know your final grade");
          command = scan.nextLine().toLowerCase();
          if(command.equals("add")) {
            System.out.println("Enter your score");
            runMin = scan.nextDouble();
            System.out.println("Enter maximum score");
            runMax = scan.nextDouble();
	          Review a = new Review(runMin, runMax);
	          min1 += a.returnMin();
	          max1 += a.returnMax();
}
          else if(command.equals("q")) {
            run = false;
          }
      }
        Review a = new Review(runMin, runMax);
        System.out.println("\n" + a.toString(min1, max1, runTeacher, runClass));
    
        System.out.println("\nWould you like to know your letter grade equivalent?");
        command = scan.nextLine().toLowerCase();
        if(command.equals("yes"))
        System.out.println("\nYou have a(n) " + a.calcLetter() + " in " + runClass + ".");
    } 
}

/*Alternate algorithms written for various methods to answer questions.

public String calcLetter() {
	if(percentage < 60)
	 return "F";
	
	if(percentage < 63)
	 return "D-";
	else if(percentage < 67)
	 return "D";
	else if(percentage < 70)
	 return "D+";
	
	if(percentage < 73)
	 return "C-";
	else if(percentage < 77)
	 return "C";
	else if(percentage < 80)
	 return "C+";

	if(percentage < 83)
	 return "B-";
	else if(percentage < 87)
	 return "B";
	else if(percentage < 90)
	 return "B+";

	if(percentage < 93)
	 return "A-";
	else if(percentage < 97)
	 return "A";
	else
	 return "A+";
} 

for (int i = 999; i > 0; i--) {
  System.out.println("\nType \"Add\" to add an assignment, type \"Q\" to know your final grade");
  command = scan.nextLine().toLowerCase();
  if(command.equals("add")) {
    System.out.println("Enter your score");
    runMin = scan.nextDouble();
    System.out.println("Enter maximum score");
    runMax = scan.nextDouble();
	  Review a = new Review(runMin, runMax);
	  min1 += a.returnMin();
	  max1 += a.returnMax();
}
  else if(command.equals("q")) {
    i = 0;
          }
      } 
*/
