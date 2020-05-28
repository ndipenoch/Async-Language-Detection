package ie.gmit.sw;

import java.util.Map;
import java.util.Set;

/**
 * getLanguage method takes the query text and the database. Compare the text
 * query to each language in the database. For every language in the database,
 * compare each Kmer of the language to each Kmer of the query text. Call the
 * GetOutOfPlaceDistance and if the Kmer of the query text is not in the subject
 * language add to the back. If it is get the distance by subtracting the query
 * text rank from the subject language rank and add it to the distance.
 */
public class GetLanguage extends Database {

	public static void getLanguage(Map<Integer, LanguageEntry> query) {

		// Get a set of languages in the database.
		Set<Language> langs = db.keySet();
		// -----------------------------------------------------
		// Loop over each of the language
		// and for each language call the getOutOfPlaceDistance
		// method and add the result distance to the TreeSet.
		// -----------------------------------------------------
		GetOutOfPlaceDistance goopd = new GetOutOfPlaceDistance();
		for (Language lang : langs) {
			Database.oopm.add(new OutOfPlaceMetric(lang, goopd.getOutOfPlaceDistance(query, db.get(lang))));
		}

	}

}
