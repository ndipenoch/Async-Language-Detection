package ie.gmit.sw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Resize the Kmers of the query text to use only the top 400 with the most
 * frequencies.
 */
public class ResizeQueryText {
	static final int max = 400;

	public static void resizeQueryText(Map<Integer, LanguageEntry> queryDb) {

		// Create a temporary TreeMap
		Map<Integer, LanguageEntry> temp = new TreeMap<>();
		// Get a list of frequencies for the language from the main Map
		List<LanguageEntry> les = new ArrayList<LanguageEntry>(queryDb.values());
		Collections.sort(les);

		// ---------------------------------------
		// Assign 1 to the most frequent Kmer
		// Loop over the frequencies. Increment
		// the rank and stop when the rank is
		// equal to the desire size(400).
		// Then add the temporary database to the query
		// text database.
		// ---------------------------------------
		int rank = 1;
		for (LanguageEntry le : les) {
			le.setRank(rank);
			temp.put(le.getKmer(), le);
			if (rank == max)
				break;
			rank++;
		}
		// ------------------------------------
		// Add the top 400 Kmers with the most
		// frequencies to the database
		// ------------------------------------
		queryDb.putAll(temp);

		//----------------------------------------------------------
		//Call the getLanguage method and pass the query database.
		// For each Kmer of the query get the frequency 
		//and add it to the query database.
        //---------------------------------------------------------
		GetLanguage.getLanguage(queryDb);
		
		// -------------------------------
		// Call the resizeQuery method to
		// use only the top 400 Kmers with
		// the most frequencies.
		// ---------------------------------
		ResizeQueryText.resizeQueryText(queryDb);
	}

}
