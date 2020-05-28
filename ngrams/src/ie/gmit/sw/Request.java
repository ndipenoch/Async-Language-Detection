package ie.gmit.sw;

/**
 * Create a Request object that have 2 parameters, Query and taskNumber.
 */
public class Request implements Requestable {
	private String query;
	private String taskNumber;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public void setTaskNumber(String taskNumber) {
		this.taskNumber = taskNumber;
	}

	public Request(String query, String taskNumber) {
		super();
		this.query = query;
		this.taskNumber = taskNumber;
	}

	public Request() {
	}

	@Override
	public String toString() {
		return "Request [query=" + query + ", taskNumber=" + taskNumber + "]";
	}

	@Override
	public void getTaskNumber(long jobNumber) {
	}

	@Override
	public long getTaskNumber() {
		return 0;
	}

}
