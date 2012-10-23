package view.objects;

import view.ModelException;

public abstract class ViewObjectInTree {

	public abstract void setIcon(IconRenderer renderer);
	public abstract ViewRoot getWrappedObject();

	public boolean equals(Object argument){
		if (argument instanceof ViewObjectInTree){
			ViewObjectInTree argumentAsViewObjectInTree = (ViewObjectInTree) argument;
			return this.getWrappedObject().equals(argumentAsViewObjectInTree.getWrappedObject());
		}
		return false;
	}
	public int hashCode(){
		return (int) (this.getWrappedObject().getId() + this.getWrappedObject().getClassId());
	}
	public ViewObjectInTree getChild(int index) throws ModelException {
		return this.getWrappedObject().getChild(index);
	}
	public int getChildCount() throws ModelException {
		return this.getWrappedObject().getChildCount();
	}
	public int getIndexOfChild(Object child) throws ModelException {
		try {
			AssociationInTreeWrapper wrapper = (AssociationInTreeWrapper)child;
			if(wrapper.parent.equals(this)) return wrapper.index;
			return -1;
		}catch (ClassCastException cce){
			return -1;
		}
	}
	public boolean isLeaf() throws ModelException {
		return this.getWrappedObject().isLeaf();
	}

}
