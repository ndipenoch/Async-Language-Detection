package ie.gmit.sw;

import java.util.Map;
import java.util.Set;

/**
 * Resize method cut down the size of the Kmers from the file to size that we desire. Normally
 * 300 is good. Because theoretically the top 300 Kmers tell us the language. Get
 * a set of all the languages and for each language call the getTop method, pass
 * the size(300) and language. Get top most frequent kmers of the language for
 * the given size(300).
 */
public class ResizeFile extends Database {

	public static void resize(int max) {
		// Get a set of all the languages.
		Set<Language> keys = db.keySet();
		// Loop over each language and call getTop method.
		for (Language lang : keys) {
			Map<Integer, LanguageEntry> top = GetTop.getTop(max, lang, db);
			db.put(lang, top);
		}
	}
}
