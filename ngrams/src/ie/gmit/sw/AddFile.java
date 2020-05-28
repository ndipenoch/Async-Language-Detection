package ie.gmit.sw;

import java.io.File;
import java.util.Map;

/**
 * Call the add method, pass a string of text and the language name
 * corresponding to the string.
 * Get the frequency of each Kmer.
 */
public class AddFile extends Parser {

	public AddFile(File file, int k) {
		super(file, k);
	}

	public static void add(CharSequence s, Language lang) {

		GetLanguageEntries ge = new GetLanguageEntries();

		// ------------------------------------------------
		// Hash the string(Kmer) and store the hashcode
		// as an integer because string are more expensive
		// on the memory usage.
		// -------------------------------------------------
		int kmer = s.hashCode();

		// -----------------------------------------
		// Call the getLanguageEntries
		// and pass the language and then
		// store the result to the language database,
		// ------------------------------------------
		Map<Integer, LanguageEntry> langDb = ge.getLanguageEntries(lang);

		// -----------------------------------------
		// Initialize frequency to 1.
		// If the Kmer is already in the database
		// get the frequency and increase it by 1.
		// If add the Kmer in the database and give
		// it an initial frequency of 1.
		// -----------------------------------------
		int frequency = 1;
		if (langDb.containsKey(kmer)) {
			frequency += langDb.get(kmer).getFrequency();
		}
		langDb.put(kmer, new LanguageEntry(kmer, frequency));

	}
}
