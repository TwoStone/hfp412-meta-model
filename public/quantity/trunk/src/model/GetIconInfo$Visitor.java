package model;

import common.IconResourceManager;

import persistence.Anything;
import persistence.PersistenceException;

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
}
