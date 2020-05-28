package ie.gmit.sw;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Pass the query and subject language map. Create a TreeSet (TreeSet because it
 * is order). Get a TreeSet of the query map. For each Kmer in the query set
 * check if it exist in the subject language map. If it does not add it at the
 * back and if it does subtract the query map rank from the subject map rank and
 * increment the distance.
 */
public class GetOutOfPlaceDistance {

	public int getOutOfPlaceDistance(Map<Integer, LanguageEntry> query, Map<Integer, LanguageEntry> subject) {
		int distance = 0;

		// -----------------------------------------------------
		// Create TreeSet database for the query text.
		// TreeSet sort the query by the frequency of the Kmers.
		// ------------------------------------------------------
		Set<LanguageEntry> les = new TreeSet<>(query.values());

		for (LanguageEntry q : les) {
			LanguageEntry s = subject.get(q.getKmer());
			if (s == null) {
				distance += subject.size() + 1;
			} else {
				distance += s.getRank() - q.getRank();
			}
		}
		return distance;
	}

}
