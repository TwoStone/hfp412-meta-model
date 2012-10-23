package view.objects;

import view.ModelException;

public abstract class AssociationInTreeWrapper extends ViewObjectInTree {

	private ViewRoot object;
	protected int index;
	ViewRoot parent;

	public AssociationInTreeWrapper(ViewRoot parent, int index, ViewRoot object) {
		this.object = object;
		this.index = index;
		this.parent = parent;
	}
	public ViewRoot getWrappedObject() {
		return this.object;
	}
	public ViewRoot getParent() {
		return this.parent;
	}
	public boolean equals(Object object){
		if (object instanceof AssociationInTreeWrapper){
			AssociationInTreeWrapper wrapper = (AssociationInTreeWrapper)object;
			return this.parent.equals(wrapper.parent) && this.index == wrapper.index;
		}
		if(object instanceof ViewRoot){
			return this.getWrappedObject().equals(object);
		}
		return false;
	}
	public int getIndexOfChild(Object child) throws ModelException {
		return this.getWrappedObject().getIndexOfChild(child);
	}

}
