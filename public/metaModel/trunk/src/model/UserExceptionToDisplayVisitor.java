package model;

import persistence.PersistenceException;
import persistence.PersistentErrorDisplay;
import model.visitor.UserExceptionStandardVisitor;

public class UserExceptionToDisplayVisitor extends UserExceptionStandardVisitor {

	private PersistentErrorDisplay result;

	public void standardHandling(UserException userException)
			throws PersistenceException {
		this.result = ErrorDisplay.createErrorDisplay(userException.getMessage(), false);
	}
	public PersistentErrorDisplay getResult(){
		return this.result;
	}

}
