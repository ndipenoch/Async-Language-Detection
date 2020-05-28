package ie.gmit.sw;

import java.util.Map;
import java.util.TreeMap;

/**
 * Check if the language is already in the database. If yes, get the language
 * and return the database. If not add the language to the database and return the database.
 */
public class GetLanguageEntries extends Database {

	public Map<Integer, LanguageEntry> getLanguageEntries(Language lang) {

		Map<Integer, LanguageEntry> langDb = null;
		if (db.containsKey(lang)) {
			langDb = db.get(lang);
		} else {
			langDb = new TreeMap<Integer, LanguageEntry>();
			db.put(lang, langDb);
		}
		return langDb;
	}
}
