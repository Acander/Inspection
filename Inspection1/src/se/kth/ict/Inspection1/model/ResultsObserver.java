package se.kth.ict.Inspection1.model;

public interface ResultsObserver {
	/**
	 * Invoked when a result has been logged
	 * @param result
	 */
	
	void newResult(boolean result);

}
