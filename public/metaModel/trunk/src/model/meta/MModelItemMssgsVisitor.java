package model.meta;

public interface MModelItemMssgsVisitor extends MModelItemDOWNMssgsVisitor, MModelItemUPMssgsVisitor {}


interface MModelItemDOWNMssgsVisitor extends AbstractObjectDOWNMssgsVisitor, MEnumDOWNMssgsVisitor, MEnumValueDOWNMssgsVisitor, MTypeDOWNMssgsVisitor, MObservationTypeDOWNMssgsVisitor, MObservationDOWNMssgsVisitor, MessageOrLinkDOWNMssgsVisitor {

    
}


interface MModelItemUPMssgsVisitor  {

    
}
