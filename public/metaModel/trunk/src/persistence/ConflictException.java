package persistence;

@SuppressWarnings("serial")
public class ConflictException extends PersistenceException {

	private static final String ConflictExceptionText = "Conflict due to optimistic locks!";
	private static final int ConflictExceptionNumber = -1;
	
	public ConflictException() {
		super(ConflictExceptionText, ConflictExceptionNumber);
	}

}
