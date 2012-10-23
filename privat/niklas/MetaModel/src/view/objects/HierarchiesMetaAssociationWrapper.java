package view.objects;


/* Additional import section end */

public class HierarchiesMetaAssociationWrapper extends AssociationInTreeWrapper {

	public HierarchiesMetaAssociationWrapper(ViewRoot parent, int index, ViewRoot object) {
		super(parent, index, object);
	}
    
    /*Start of protected part that is not overridden by persistence generator*/

    public void setIcon(IconRenderer renderer) {
        //TODO: Implement setIcon in wrapper class of association hierarchies in class MetaAssociation
    	this.getWrappedObject().setIcon(renderer);
    }
	
	public String toString(){
    	//TODO: Implement toString in wrapper class for association hierarchies in class MetaAssociation
    	return this.getWrappedObject().toString();
    }

    /*End of protected part that is not overridden by persistence generator*/

}
