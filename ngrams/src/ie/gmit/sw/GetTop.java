package ie.gmit.sw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Create a temporary TreeMap database of LanguageEntry(contains Kmer,frequency
 * and rank). The advantage of a TreeMap is that it is ordered. Create a List of
 * languages in a sorted order. The rank of the Kmer in the LanguageEntry is
 * already order in descending order using comparable. Assigned 1 to the rank of
 * most frequent Kmer. Loop over the LanguageEntry and add each Kmer to the
 * temporary database and stop when the rank of the Kmer of the LanguageEntry is
 * equal to the desire size(300). The return the temporary database.
 */
public class GetTop {

	public static Map<Integer, LanguageEntry> getTop(int max, Language lang,
			Map<Language, Map<Integer, LanguageEntry>> db) {

		// Create a temporary TreeMap
		Map<Integer, LanguageEntry> temp = new TreeMap<>();
		// Get a list of frequencies for the language from the main Map
		List<LanguageEntry> les = new ArrayList<>(db.get(lang).values());
		Collections.sort(les);

		// ---------------------------------------
		// Assign 1 to the most frequent Kmer
		// Loop over the frequencies. Increment
		// the rank and stop when the rank is
		// equal to the desire size(300).
		// Then return the temporary database.
		// ---------------------------------------
		int rank = 1;
		for (LanguageEntry le : les) {
			le.setRank(rank);
			temp.put(le.getKmer(), le);
			if (rank == max)
				break;
			rank++;
		}

		return temp;
	}
}
