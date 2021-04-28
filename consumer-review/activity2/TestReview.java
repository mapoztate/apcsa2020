public class TestReview
{
    public static void main(String[] args)
    {

        //Test the totalSentiment and starRating methods here!
        System.out.println(Review.totalSentiment("SimpleReview.txt")); 
        System.out.println(Review.starRating("SimpleReview.txt")); 
        System.out.println("");
        System.out.println(Review.totalSentiment("26WestReview.txt")); 
        System.out.println(Review.starRating("26WestReview.txt")); 

    }
}
