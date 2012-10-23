package view;

@SuppressWarnings("serial")
public class ModelException extends Exception {

	private long number;
	
	public ModelException(String message, long number){
		super(message);
		this.number = number;	
	}
	public long getErrorNumber(){
		return this.number;
	}
}