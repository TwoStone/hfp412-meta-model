package view.objects;


/* Additional import section end */

public class DisjunctiveNormalformComposedMetaTypeWrapper extends AssociationInTreeWrapper {

	public DisjunctiveNormalformComposedMetaTypeWrapper(ViewRoot parent, int index, ViewRoot object) {
		super(parent, index, object);
	}
    
    /*Start of protected part that is not overridden by persistence generator*/

    public void setIcon(IconRenderer renderer) {
        //TODO: Implement setIcon in wrapper class of association disjunctiveNormalform in class ComposedMetaType
    	this.getWrappedObject().setIcon(renderer);
    }
	
	public String toString(){
    	//TODO: Implement toString in wrapper class for association disjunctiveNormalform in class ComposedMetaType
    	return this.getWrappedObject().toString();
    }

    /*End of protected part that is not overridden by persistence generator*/

}
