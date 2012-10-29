package persistence;

public abstract class PersistentDecoratorProxi extends PersistentProxi {

	protected PersistentDecoratorProxi(PersistentInCacheProxi object) {
		super(object);
	}
	protected PersistentDecoratorProxi(long id) {
		super(id);
	}
	public String createProxiInformation(boolean asLeaf) throws PersistenceException {
		return this.getTheObject().createProxiInformation(asLeaf);
	}


}
