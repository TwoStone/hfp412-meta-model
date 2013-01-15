package view.objects;


/* Additional import section end */

public class OfTypeMFormalParameterWrapper extends AssociationInTreeWrapper {

	public OfTypeMFormalParameterWrapper(ViewRoot parent, int index, ViewRoot object) {
		super(parent, index, object);
	}
    
    /*Start of protected part that is not overridden by persistence generator*/

    public void setIcon(IconRenderer renderer) {
        //TODO: Implement setIcon in wrapper class of association ofType in class MFormalParameter
    	this.getWrappedObject().setIcon(renderer);
    }
	
	public String toString(){
    	//TODO: Implement toString in wrapper class for association ofType in class MFormalParameter
    	return this.getWrappedObject().toString();
    }

    /*End of protected part that is not overridden by persistence generator*/

}
