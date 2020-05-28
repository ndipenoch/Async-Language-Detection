package ie.gmit.sw;

import java.io.File;

/**
 * Split the subject language file into Kmers per language add them to the
 * database.
 */
public class ParseFile extends Parser {

	public ParseFile(File file, int k) {
		super(file, k);
	}

	static void parse(String text, String lang) {
		Language language = Language.valueOf(lang);

		for (int i = 0; i <= text.length() - k; i++) {
			CharSequence kmer = text.substring(i, i + k);
			AddFile.add(kmer, language);
		}
	}

}
