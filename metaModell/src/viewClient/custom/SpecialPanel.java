package viewClient.custom;

import view.Anything;
import viewClient.DetailPanel;
import viewClient.ExceptionAndEventHandler;

public abstract class SpecialPanel extends DetailPanel {

	
	
	protected SpecialPanel(ExceptionAndEventHandler exceptionHandler) {
		super(exceptionHandler);
	}

	@Override
	public void setAnything(Anything anything) {
		this.anything = anything;
	}

}
