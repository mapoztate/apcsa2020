import java.util.*;

public class Main {
	
    public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        ArrayList<Cereal> allCereal = new ArrayList<Cereal>();
        
        String cereal1 = "";
        boolean firstCereal = false;
        Cereal c1;
        String cereal2 = "";
        boolean secondCereal = false;
        Cereal c2;


        //Adds all the cereals to an ArrayList, but adding two just to show an example.
        allCereal.add("Frosted Flakes", "C", 110, 1, 0, 200, 1, 14, 11, 25, 25, 1, 1, .75, 31.43597)
        allCereal.add("Apple Jacks", "C", 110, 2, 0, 125, 1, 11, 14, 30, 25, 2, 1, 1, 33.174094)
	
        while(!firstCereal) {
            System.out.println("Which cereal would you like to start with?");
            cereal1 = scan.nextLine();
            for(int i = 0; i < allCereal.size(); i++) {
                if(cereal1.equals(allCereal.get(i)getName())) {
                    c1 = allCereal.get(i); 
                    System.out.println(c1.toString());
                    firstCereal = true;
                    break;
                }
            }
        }

        while(!secondCereal) {
            System.out.println("Which cereal would you like to compare this to?");
            cereal2 = scan.nextLine();
            for(int i = 0; i < allCereal.size(); i++) {
                if(cereal2.equals(allCereal.get(i)getName())) {
                    c2 = allCereal.get(i); 
                    System.out.println(c2.toString());
                    secondCereal = true;
                    break;
                }
            }
        }
       
        healthiestCereal(c1, c2);
        
    }

    public void healthiestCereal(Cereal a, Cereal b) {
        if(a.sugarToProtein > b.sugarToProtein) {
            System.out.println(b.getName() + " is the healthier cereal. ");
        }
        else {
            System.out.println(a.getName() + " is the healthier cereal. ");
        }
    }
}
