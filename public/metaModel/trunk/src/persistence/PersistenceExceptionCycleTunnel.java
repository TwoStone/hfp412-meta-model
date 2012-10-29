package persistence;

@SuppressWarnings("serial")
public class PersistenceExceptionCycleTunnel extends PersistenceException {

	public model.CycleException cycleException;

	public PersistenceExceptionCycleTunnel(model.CycleException cycleException) {
		super(cycleException.getMessage(), 0);
		this.cycleException = cycleException;
	}

}
