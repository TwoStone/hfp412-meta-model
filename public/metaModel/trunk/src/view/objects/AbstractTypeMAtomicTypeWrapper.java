package view.objects;


/* Additional import section end */

public class AbstractTypeMAtomicTypeWrapper extends AssociationInTreeWrapper {

	public AbstractTypeMAtomicTypeWrapper(ViewRoot parent, int index, ViewRoot object) {
		super(parent, index, object);
	}
    
    /*Start of protected part that is not overridden by persistence generator*/

    public void setIcon(IconRenderer renderer) {
        //TODO: Implement setIcon in wrapper class of association abstractType in class MAtomicType
    	this.getWrappedObject().setIcon(renderer);
    }
	
	public String toString(){
    	//TODO: Implement toString in wrapper class for association abstractType in class MAtomicType
    	return this.getWrappedObject().toString();
    }

    /*End of protected part that is not overridden by persistence generator*/

}
