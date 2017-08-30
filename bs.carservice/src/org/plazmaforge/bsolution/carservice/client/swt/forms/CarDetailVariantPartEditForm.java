package org.plazmaforge.bsolution.carservice.client.swt.forms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;

public class CarDetailVariantPartEditForm extends AbstractEditForm {

    private Label carPartLabel;
    private XComboEdit carPartField;
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public CarDetailVariantPartEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }
    
    
    private void initialize() {
	
	setDataSourceSupport(false);
	
	GridData gridData;


	setTitle(Messages.getString("CarDetailVariantPart.title")); //$NON-NLS-1$

	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	gridLayout.numColumns = 2;
	setLayout(gridLayout);
    	
    	carPartLabel = new Label(this, SWT.NONE);
	carPartLabel.setText(Messages.getString("CarDetailVariantPart.carPartLabel.text")); //$NON-NLS-1$

    	carPartField = new XComboEdit(this, SWT.BORDER, PWT.VIEW_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	gridData.widthHint = 300;
    	carPartField.setLayoutData(gridData);

    	this.setSize(new Point(550, 264));
    	
    }

    protected void bindControls() {
	bindControl(carPartField, "carPart", carPartLabel, REQUIRED);
    }

}
