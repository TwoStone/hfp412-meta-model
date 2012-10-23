package persistence;

@SuppressWarnings("serial")
public class PersistenceError extends Error {

  int errorNumber;

  public PersistenceError(PersistenceException exception) {
    super(exception.getMessage());
    this.errorNumber = exception.getErrorNumber();
  }
  public int getErrorNumber() {
    return this.errorNumber;
  }
}

