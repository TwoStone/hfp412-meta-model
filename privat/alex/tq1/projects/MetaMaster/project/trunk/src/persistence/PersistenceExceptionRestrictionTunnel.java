package persistence;

@SuppressWarnings("serial")
public class PersistenceExceptionRestrictionTunnel extends PersistenceException {

	public model.RestrictionException restrictionException;

	public PersistenceExceptionRestrictionTunnel(model.RestrictionException restrictionException) {
		super(restrictionException.getMessage(), 0);
		this.restrictionException = restrictionException;
	}

}
