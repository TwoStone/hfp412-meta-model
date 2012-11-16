
package view.visitor;

import view.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleMAtomicType(MAtomicTypeView mAtomicType) throws ModelException;
    
    public abstract void handleTypeManager(TypeManagerView typeManager) throws ModelException;
    
    public abstract void handleMAspect(MAspectView mAspect) throws ModelException;
    
    public abstract void handleAspectManager(AspectManagerView aspectManager) throws ModelException;
    
    public abstract void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    
    public abstract void handleMBoolean(MBooleanView mBoolean) throws ModelException;
    
    public void handleMFalse(MFalseView mFalse) throws ModelException{
        this.handleMBoolean(mFalse);
    }
    public void handleMTrue(MTrueView mTrue) throws ModelException{
        this.handleMBoolean(mTrue);
    }
    public abstract void handleServer(ServerView server) throws ModelException;
    
    public abstract void handleMComplexType(MComplexTypeView mComplexType) throws ModelException;
    
    public void handleMProductType(MProductTypeView mProductType) throws ModelException{
        this.handleMComplexType(mProductType);
    }
    public void handleMSumType(MSumTypeView mSumType) throws ModelException{
        this.handleMComplexType(mSumType);
    }
    
}
