/**
 * This class contains the results after a successful run of reviewOger.
 * It contains all informations needed to start the matching.
 * Is filled while the data is read by io.
 */

package data;

import java.util.ArrayList;
import java.util.List;

public class ReviewPlan {
	
	
	
	public static List<Review> reviews = new ArrayList<Review>();

	
	public static int maxNumberOfReviews;
	
	public static void add(Review review) {
		reviews.add(review);
	}
}
