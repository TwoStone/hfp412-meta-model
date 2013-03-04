package model;

import model.visitor.UserExceptionStandardVisitor;
import persistence.PersistenceException;
import persistence.PersistentErrorDisplay;

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
