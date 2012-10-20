package model;

import persistence.*;

import com.google.common.base.Joiner;

public class ToString$Visitor extends model.visitor.ToString$Visitor {

	private String result;

	public ToString$Visitor() {
	}
	public synchronized String toString(final Anything anything) throws PersistenceException {
		this.result = null;
		anything.accept(this);
		if (this.result == null) {
			this.standardHandling(anything);
		}
		return this.result;
	}
	@Override
	protected void standardHandling(final Anything anything) {
		this.result = anything.getClassId() + ";" + anything.getId();
	}
	@Override
	public void handleOrMetaType(final PersistentOrMetaType orMetaType)
			throws PersistenceException {
		String types = Joiner.on(" + ").join(orMetaType.getComponents().iterator());
		this.result = "[SumType] " + types;
	}
	@Override
	public void handleAndMetaType(final PersistentAndMetaType andMetaType)
			throws PersistenceException {
		String types = Joiner.on(" x ").join(andMetaType.getComponents().iterator());
		this.result = "[ProductType] " + types;
	}
	@Override
	public void handleMetaAspect(final PersistentMetaAspect metaAspect)
			throws PersistenceException {
		this.result = "[Aspect] " + metaAspect.getName();
	}
	@Override
	public void handleMetaHierarchy(final PersistentMetaHierarchy metaHierarchy)
			throws PersistenceException {
		this.result = "[Hierarchy] " + metaHierarchy.getName();
	}
	@Override
	public void handleServer(final PersistentServer server)
			throws PersistenceException {
	}
	@Override
	public void handleMetaType(final PersistentMetaType metaType)
			throws PersistenceException {
		this.result =  "[Type] " + metaType.getName();
	}
	@Override
	public void handleMetaAssociation(final PersistentMetaAssociation metaAssociation)
			throws PersistenceException {
		this.result = "[Assoc] " + metaAssociation.getName();
	}
	@Override
	public void handleTypeManager(final PersistentTypeManager typeManager)
			throws PersistenceException {
		this.result = "Types";

	}
	@Override
	public void handleAspectManager(final PersistentAspectManager aspectManager)
			throws PersistenceException {
		this.result = "Aspects";
	}

}
