package persistence;

abstract public class PersistentInCacheDecoratorProxiOptimistic extends PersistentInCacheProxi {

	protected PersistentInCacheDecoratorProxiOptimistic(PersistentObject object) {
		super(object);
	}
	protected PersistentInCacheDecoratorProxiOptimistic(long id) {
		super(id);
	}
	public String createProxiInformation(boolean asLeaf) throws PersistenceException {
		return this.getTheObject().createProxiInformation(asLeaf);
	}

}
