package org.plazmaforge.bsolution.helloplazma.client.swt.forms;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.forms.AbstractListForm;

public class HelloListForm extends AbstractListForm {

    private Table table;
    

    
    public HelloListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("HelloListForm.title")); //$NON-NLS-1$
	
        TableColumn tableColumn;
        TableColumn messageColumn;
       
        setLayout(new FillLayout());
 

    	table = new Table(this, SWTToolkit.TABLE_STYLE);
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	messageColumn = new TableColumn(table, SWT.NONE);
    	messageColumn.setWidth(100);
    	messageColumn.setText(Messages.getString("HelloListForm.messageColumn.text")); //$NON-NLS-1$

    	
        this.setSize(new Point(600, 300));
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "message"); // hello.getMessage()
    }
 

 
}  //  @jve:decl-index=0:visual-constraint="10,10"

