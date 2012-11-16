
package view.visitor;

import view.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleMProductType(MProductTypeView mProductType) throws ModelException{
        this.standardHandling(mProductType);
    }
    public void handleTypeManager(TypeManagerView typeManager) throws ModelException{
        this.standardHandling(typeManager);
    }
    public void handleAspectManager(AspectManagerView aspectManager) throws ModelException{
        this.standardHandling(aspectManager);
    }
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException{
        this.standardHandling(errorDisplay);
    }
    public void handleMFalse(MFalseView mFalse) throws ModelException{
        this.standardHandling(mFalse);
    }
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
    }
    public void handleMAtomicType(MAtomicTypeView mAtomicType) throws ModelException{
        this.standardHandling(mAtomicType);
    }
    public void handleMAspect(MAspectView mAspect) throws ModelException{
        this.standardHandling(mAspect);
    }
    public void handleMSumType(MSumTypeView mSumType) throws ModelException{
        this.standardHandling(mSumType);
    }
    public void handleMBoolean(MBooleanView mBoolean) throws ModelException{
        this.standardHandling(mBoolean);
    }
    public void handleMTrue(MTrueView mTrue) throws ModelException{
        this.standardHandling(mTrue);
    }
    protected abstract void standardHandling(Anything anything) throws ModelException;
}
