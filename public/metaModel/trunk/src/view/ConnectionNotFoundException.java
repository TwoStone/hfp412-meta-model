package view;

@SuppressWarnings("serial")
public class ConnectionNotFoundException extends ModelException {

	public ConnectionNotFoundException(String message, long number) {
		super(message, number);
	}

}
