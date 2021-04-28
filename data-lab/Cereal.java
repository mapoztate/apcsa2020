public class Cereal {
	// instance variables
	private String name;
	private String type;
	private int calories;
	private int protein;
	private int fat;
	private int sodium;
	private int sugar;
	private int potassium;
	private int vitamins;
	private int shelf;
	private double fiber;
	private double carbs;
	private double weight;
	private double cups;
	private double rating;

	public Cereal(String initName, String initType, int initCal, int initProtein, int initFat, int initSodium,
			double initFiber, double initCarbs, int initSugar, int initPotassium, int initVit, int initShelf,
			double initWeight, double initCups, double initRating) {
		this.name = initName;
		this.type = initType;
		this.calories = initCal;
		this.protein = initProtein;
		this.fat = initFat;
		this.sodium = initSodium;
		this.fiber = initFiber;
		this.carbs = initCarbs;
		this.sugar = initSugar;
		this.potassium = initPotassium;
		this.vitamins = initVit;
		this.shelf = initShelf;
		this.weight = initWeight;
		this.cups = initCups;
		this.rating = initRating;
	}
	
    public Cereal() {
		this.name = "";
		this.type = "C";
		this.calories = 0;
		this.protein = 0;
		this.fat = 0;
		this.sodium = 0;
		this.fiber = 0;
		this.carbs = 0;
		this.sugar = 0;
		this.potassium = 0;
		this.vitamins = 0;
		this.shelf = 0;
		this.weight = 0;
		this.cups = 0;
		this.rating = 0;

	}

	// General Methods
	public String toString() {
		return "Cereal " + name + " Type:" + type + " Calories:" + calories + " Cups:" + cups + " Rating:" + rating;
	}

    
    //Helper methods
    public int sugarToProtein() {
        return sugar - protein;
    }

    // accessor methods
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public int getCalories() {
		return calories;
	}
	public int getProtein() {
		return protein;
	}
	public int getFat() {
		return fat;
	}
	public int getSodium() {
		return sodium;
	}
	public int getSugar() {
		return sugar;
	}
	public int getPotassium() {
		return potassium;
	}
	public int getVitamins() {
		return vitamins;
	}
	public int getShelf() {
		return shelf;
	}
	public double getFiber() {
		return fiber;
	}
	public double getCarbs() {
		return carbs;
	}
	public double getWeight() {
		return weight;
	}
	public double getCups() {
		return cups;
	}
	public double getRating() {
		return rating;
	}

}
