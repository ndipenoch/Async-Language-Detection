package ie.gmit.sw;

/**
 * Compare one Kmer/n-gram to another using their frequency in descending other.
 * The most frequent appears first.
 */
public class LanguageEntry implements Comparable<LanguageEntry> {
	private int kmer;
	private int frequency;
	private int rank;

	/**
	 * Call the LanguageEntry and pass in a Kmer and it frequency.
	 */
	public LanguageEntry(int kmer, int frequency) {
		super();
		this.kmer = kmer;
		this.frequency = frequency;
	}

	public int getKmer() {
		return kmer;
	}

	public void setKmer(int kmer) {
		this.kmer = kmer;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	/**
	 * Compare one Kmer/n-gram to another using their frequency in descending other.
	 * The most frequent you appear first.
	 */
	public int compareTo(LanguageEntry next) {
		return -Integer.compare(frequency, next.getFrequency());
	}

	/**
	 * Print the Kmer, the frequency and rank.
	 */
	@Override
	public String toString() {

		return "[" + kmer + "/" + frequency + "/" + rank + "]";
	}
}