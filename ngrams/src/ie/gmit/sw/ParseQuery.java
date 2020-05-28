package ie.gmit.sw;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;

/**
 * Split the query text into Kmers and add it to the database. Resize the query
 * text to use just the 400 Kmers with the most frequencies.
 */
public class ParseQuery extends Parser{

	public ParseQuery(File file, int k) {
		super(file, k);
	}

	public static String parseQuery(String text) {

		// --------------------------------------
		// Create a query database using TreeMap.
		// Because it is sorted by key.
		// ---------------------------------------
		Map<Integer, LanguageEntry> queryDb = new TreeMap<Integer, LanguageEntry>();

		for (int i = 0; i <= text.length() - k; i++) {
			CharSequence kmer = text.substring(i, i + k);

			// GetLanguage gl = new GetLanguage();
			// ------------------------------------------------
			// Hash the string(Kmer) and store the hashcode
			// as an integer because string are more expensive
			// on the memory usage.
			// -------------------------------------------------
			int kmers = kmer.hashCode();

			// -----------------------------------
			// Initialize the frequency to 1.
			// Increment the frequency if Kmer is
			// alreay in the database.
			// ------------------------------------
			int frequency = 1;
			if (queryDb.containsKey(kmers)) {
				frequency += queryDb.get(kmers).getFrequency();
			}
			// --------------------------------
			// At the Kmer at the end if it is
			// not already in the database.
			// --------------------------------
			queryDb.put(kmers, new LanguageEntry(kmers, frequency));
		}

		// -------------------------------
		// Call the resizeQuery method to
		// use only the top 400 Kmers with
		// the most frequencies.
		// ---------------------------------
		ResizeQueryText.resizeQueryText(queryDb);

		// --------------------------
		// Get the detected language.
		// --------------------------
		String result = db.languageResult();

		return result;
	}
}
