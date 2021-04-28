### Why did you choose to implement this program?


I chose to implement this program as it would be an easy to conceptualize project that fulfilled the requirements of the project as well as challenge our programming skills. We wanted our program to have a real life application and simulate one of the aspects of what a gradebook would look like.

### Describe the development process used in the completion of the project. 


Although we originally used [repl.it](https://repl.it/@mapoztate/apcsa2020) to write our code due to the convenience of group collaboration, we had to switch to Edhesive as we ran into complications running the program. However, Edhesive had only limited us to one file so we had to write our Main method alongside the rest of the methods all in one class. 

We started off by abstracting our program. This allowed us to figure out what variables were needed in both the main method and the class to make sure that the main method would do in order to work properly as well as what libraries we would need to import for our project to run properly. In places where a method that was unwritten would go, the specific line would be commented with its function that we can later replace after we finish writing the whole project. Once the backbone of the project was completed, we conceptualized additional methods that would add more utility to the program as well as ensuring that our program satisfied the project guidelines.

As soon as we were finished writing the main method, we moved to writing each of the individual methods. We started off by writing the method that was instrumental for our core program to work. After a bit of debugging and making sure that the code met all of our test cases, we began to implement the additional features and made sure that the program still worked properly. Lastly, we did some code optimization, commenting, and renaming various variables to establish good programming practice and to make it easier for someone who would look at the project.

### Provide the method header for a method that you implemented that takes at least one parameter. Explain why you chose the given parameter(s), including type, and why you made the method static or non-static. 




```Java
public String toString(Double repMin, Double repMax, String teacher, String theClass) {
```
I included four parameters in my toString method. I used two doubles and two strings. In this method, I would divide the doubles repMin and repMax in which the value would be stored in a value called percentage. The two Strings teacher and theClass were used to bridge the main method and this method together. The inputs for the teacher String and theClass method would be equalled to a variable that asked for the user input earlier in the program. Overall, all of these parameters were necessary in order to return the following information to the user: 

teacher, theClass: percentage%

I made the method static as the method is only used once in the totality of the program which means all values and variables in this method would remain constant. This was part of my optimization in order to make the program more efficient.

### Provide the code segment(s) where two distinct methods in the String class are called. Describe what each method call is doing, and what is being returned (if anything) by the method calls. 

```Java
System.out.println("\n" + a.toString(min1, max1, runTeacher, runClass));

System.out.println("\nWould you like to know your letter grade equivalent?");
command = scan.nextLine().toLowerCase();
if(command.equals("yes"))
 System.out.println("\nYou have a(n)" + a.calcLetter() + " in " + runClass + ".");
```

The toString method in the String class is the backbone of the program. As with most programs, the toString of my program gives the essential information that the user needs to find out about calculating their grade. This takes the inputs of their teacher, class, and the total of their score/the maximum possible. This would return out a String in this format.

Barr-Wilson, APCSA: 93%

Once the user has read their results from the toString method, they are asked by the program if they want to know their letter grade. If so, it would return a letter grade based on the percentage that was calculated in the toString method.

You have a(n) A in APCSA.

### Copy and paste one code segment that uses nested conditional statements or compound Boolean expressions. What is one other way that this code could be written to achieve the same result? Provide an equivalent code segment to the one included above. 

```Java
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
```

To write this in an alternative way, we can write separate nested conditional statements for each tier of grade (ie: A+, A, A-). We would then use DeMorgan’s law to negate the equations and change the return value to the letter above it.  In order for the segment to provide the same results, we must invert the order in which the conditions appear so the program would recognize the correct grade to letter value and not return the letter value too early as that would immediately end the method and give the wrong letter value. This means that the final else statement would return an A+.

```Java
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
```
### Copy and paste one code segment that uses iteration. Describe how the loop you used works and provide an equivalent code segment to the one included above that uses a different type of loop.

```Java
while(run) {
         System.out.println("Type \"Add\" to add an assignment, type \"Q\" to know your final grade");
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
```

We used a while loop that stated as long as the boolean run equaled true, it would continue to run and accept inputs. The only time the boolean would be changed to false is if the user inputted “q” which was our command to quit the program and get your final grade. A similar type of loop that can be used instead is the for loop. Although not efficient and good programming practice, this loop gets the same output by setting the loop number abnormally high then setting it to 0 if the string is equivalent to 0.

```Java
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
```
