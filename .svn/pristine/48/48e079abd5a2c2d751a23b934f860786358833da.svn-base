package org.plazmaforge.framework.client.swt.controls;



import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.List;

public class Combo extends AbstractExtCombo {

    
    
    
    /**
     * The List Control
     */
    private List list;
    
  
    
 
    public Combo(Composite parent, int style) {
	super(parent, style);
    }
    
    

    public Combo(Composite parent, int style, int toolStyle) {
	super(parent, style, toolStyle);
    }



    @Override
    protected void createPopupContent() {
	
	int style = getStyle ();
	int listStyle = SWT.SINGLE | SWT.V_SCROLL;
	if ((style & SWT.FLAT) != 0) listStyle |= SWT.FLAT;
	if ((style & SWT.RIGHT_TO_LEFT) != 0) listStyle |= SWT.RIGHT_TO_LEFT;
	if ((style & SWT.LEFT_TO_RIGHT) != 0) listStyle |= SWT.LEFT_TO_RIGHT;
	
	list = new List (popup, listStyle);
	popupContent = list;
	initPopupContentListener();

    }
    
    
    
    @Override
    protected Control getTextParent() {
	return text;
    }

    
    protected void doControlAdd(String string) {
    	list.add(string);
    }
    
    protected void doControlAdd(String string, int index) {
    	list.add(string, index);
    }
    
    protected void doControlRemove(int index) {
	list.remove(index);
    }
    
    protected void doControlRemove(int start, int end) {
    	list.remove (start, end);
    }

    protected void doControlRemoveAll() {
    	list.removeAll();
    }

    protected void doControlDeselect(int index) {
    	list.deselect(index);
    }

    protected void doControlDeselectAll() {
    	list.deselectAll();
    }
    
    protected String doControlGetItem(int index) {
    	return list.getItem(index);
    }
    
    protected int doControlGetItemCount() {
    	return list.getItemCount();
    }
    
    protected int doControlGetItemHeight() {
    	return list.getItemHeight();
    }
    
    protected String [] doControlGetItems () {
    	return list.getItems();
    }
    
    protected int doControlGetSelectionIndex () {
    	return list.getSelectionIndex();
    }
    
    protected void doControlSetSelectionIndex(int index) {
    	list.setSelection(index);
    }
    
    protected void doControlShowSelection() {
	list.showSelection();
    }
    
    protected int doControlIndexOf(String string) {
	return list.indexOf(string);
    }


  

}
