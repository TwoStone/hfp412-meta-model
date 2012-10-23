package view.objects;

import viewClient.ExceptionAndEventHandler;

public abstract class ViewDecoratorProxi extends ViewProxi{

	long decorateeClassId;
	long decorateeId;
	
	protected ViewDecoratorProxi(long id, long classId, ExceptionAndEventHandler connectionKey) {
		super(id, classId, connectionKey);
	}
	public long getDecorateeClassId() {
		return decorateeClassId;
	}

	public void setDecorateeClassId(long decorateeClassId) {
		this.decorateeClassId = decorateeClassId;
	}

	public long getDecorateeId() {
		return decorateeId;
	}

	public void setDecorateeId(long decorateeId) {
		this.decorateeId = decorateeId;
	}

	public String createProxiInformation() {
		return common.RPCConstantsAndServices.createFromClientProxiRepresentation(this.getClassId(), this.getId(), this.getRemoteDepth(),
																					this.getDecorateeClassId(), this.getDecorateeId());
	}

}
