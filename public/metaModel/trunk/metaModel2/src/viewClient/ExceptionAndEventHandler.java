package viewClient;

import view.ModelException;
import view.UserException;

public interface ExceptionAndEventHandler {
	public void handleException(ModelException exception);
	public void handleUserException(UserException exception);
	public void handleRefresh();
	public void handleOKMessage(String message);
	public void setConnection(ConnectionMaster connection);
	public void initializeConnection();
}