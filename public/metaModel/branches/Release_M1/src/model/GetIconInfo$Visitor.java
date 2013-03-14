package model;

import persistence.Anything;
import persistence.PersistenceException;
import persistence.PersistentReference;

import common.IconResourceManager;

public class GetIconInfo$Visitor extends model.visitor.AnythingStandardVisitor {

	int result = 0;
	
	@Override
	protected void standardHandling(Anything anything) throws PersistenceException {
		result = IconResourceManager.getInstance().getClassImageId(anything.getClass());
	}

	public int getIconInfo(Anything anything) throws PersistenceException {
		anything.accept(this);
		return result;
	}
	@Override
	public void handleReference(PersistentReference reference) throws PersistenceException {
		if(reference.getExponent() > 0)
			result = IconResourceManager.getInstance().getClassImageId(reference.getClass())*10000;
		else
			result = IconResourceManager.getInstance().getClassImageId(reference.getClass())*20000;
	}
}
