public class LiteratureCelebrity extends Celebrity {

	//instance variables
	private String bestBook;
	
	//constructor for literature celebrity
	public LiteratureCelebrity(String answer, String clue, String book) {
		super(answer, clue);
		bestBook = book;
	}
	
	//accessor method returning book
	public String getBook() {
		return bestBook;
	}
	
	//setter method setting book
	public void setBook(String book) {
		bestBook = book;
	}
	
	//overrides the toString in Celebrity
	public String toString()
	{
		return "The literature celebrity's name is " + super.getAnswer() + ", the clue is " + super.getClue() + ", and the book is " + bestBook;
	}
}
© 2021 GitHub, Inc.
