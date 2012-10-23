package persistence;

@SuppressWarnings("serial")
public class PersistenceException extends Exception {

  int errorNumber;

  public PersistenceException(String message, int errorNumber) {
    super(message);
    this.errorNumber = errorNumber;
  }
  public int getErrorNumber() {
    return this.errorNumber;
  }
}

