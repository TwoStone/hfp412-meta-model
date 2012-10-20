package viewClient;

import java.util.Vector;

import javax.swing.JList;

@SuppressWarnings("serial")
public class JListRefresh extends JList {

	public JListRefresh(){
		super();
	}
	public void setListData(Vector data){
		Object[] selected = this.getSelectedValues();
		super.setListData(data);
		int[] newSelection = find(selected);
		this.setSelectedIndices(newSelection);
	}
	private int[] find(Object[] selected) {
		int[] result = new int[selected.length];
		for (int index = 0; index < selected.length; index++)result[index] = -1;
		int mySize = this.getModel().getSize(); //Indices greater or equal mySize are ignored by "setSelectedIndices"
		for (int old = 0; old < selected.length; old++){
			for (int newIndex = 0; newIndex < this.getModel().getSize(); newIndex++){
				if(selected[old].equals(this.getModel().getElementAt(newIndex)))result[old] = newIndex;
			}
			if(result[old] == -1) result[old] = mySize;
		}
		return result;
	}
}
