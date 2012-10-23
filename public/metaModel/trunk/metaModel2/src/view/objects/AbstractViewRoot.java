package view.objects;

import view.*;

public interface AbstractViewRoot {

  public long getId();
  public long getClassId();
  public ViewObject getTheObject()  throws ModelException;

}