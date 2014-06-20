package exception;

public class StationPasEnServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "La station du destinataire est hors service";
	}

	
}
