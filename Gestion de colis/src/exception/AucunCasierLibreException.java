package exception;

public class AucunCasierLibreException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Aucun casier libre dans la station.";
	}

}
