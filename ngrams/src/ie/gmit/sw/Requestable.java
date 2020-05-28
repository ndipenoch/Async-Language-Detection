package ie.gmit.sw;

/**
 * Request object interface.
 */
public interface Requestable {
	public void setQuery(String query);

	public String getQuery();

	public void getTaskNumber(long jobNumber);

	public long getTaskNumber();

}
