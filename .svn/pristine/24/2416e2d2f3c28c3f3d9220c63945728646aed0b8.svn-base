package org.plazmaforge.bsolution.helloplazma.client.swt.forms;


import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.plazmaforge.framework.client.swt.controls.XTextField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;

public class HelloEditForm extends AbstractEditForm {

    private Label messageLabel;

    
    private XTextField messageField;
   

 
    public HelloEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {
	setTitle(Messages.getString("HelloEditForm.title")); //$NON-NLS-1$
	GridData gridData;
	
	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	gridLayout.numColumns = 2;
	setLayout(gridLayout);
    	
    	
    	messageLabel = new Label(this, SWT.NONE);
    	messageLabel.setText(Messages.getString("HelloEditForm.messageLabel.text")); //$NON-NLS-1$

    	messageField = new XTextField(this, SWT.BORDER);
    	messageField.setLayoutData(new GridData(100, SWT.DEFAULT));
    	messageField.setTextLimit(50);

 
    	
    	this.setSize(new Point(470, 108));
    }
    
    protected void bindControls() {
	bindControl(messageField, "message"); //$NON-NLS-1$
	
    }

}  
