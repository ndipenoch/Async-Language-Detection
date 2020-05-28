package ie.gmit.sw;

import java.io.*;

/**
 * This class takes the subject language file. It splits
 * it into Kmers or ngrams and populates the database.
 */
public class Parser implements Runnable {
	protected static Database db = null;
	private File file;
	protected static int k;

	public Parser(File file, int k) {
		this.file = file;
		this.k = k;
	}

	public void setDb(Database db) {
		this.db = db;
	}

	/**
	 * Read the subject language file and split at the "@" character.
	 */
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] record = line.trim().split("@");
				if (record.length != 2)
					continue;
				ParseFile.parse(record[0], record[1]);
			}

			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
