package org.plazmaforge.bsolution.carservice.client.swt.forms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;

public class CarDetailVariantServEditForm extends AbstractEditForm {

    private Label carClassLabel;
    private Label carServLabel;
    private Label workHourLabel;
    
    private XComboEdit carClassField;
    private XComboEdit carServField;
    private XCurrencyField workHourField;
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public CarDetailVariantServEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }
    
    
    private void initialize() {
	
	setDataSourceSupport(false);
	
	GridData gridData;


	setTitle(Messages.getString("CarDetailVariantServ.title")); //$NON-NLS-1$

	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	gridLayout.numColumns = 2;
	setLayout(gridLayout);
    	
    	////
    	
    	carClassLabel = new Label(this, SWT.NONE);
	carClassLabel.setText(Messages.getString("CarDetailVariantServ.carClassLabel.text")); //$NON-NLS-1$

    	carClassField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	carClassField.setLayoutData(gridData);

    	////
    	
    	carServLabel = new Label(this, SWT.NONE);
	carServLabel.setText(Messages.getString("CarDetailVariantServ.carServLabel.text")); //$NON-NLS-1$

    	carServField = new XComboEdit(this, SWT.BORDER, PWT.VIEW_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	gridData.widthHint = 300;
    	carServField.setLayoutData(gridData);

    	
    	workHourLabel = new Label(this, SWT.NONE);
    	workHourLabel.setText(Messages.getString("CarDetailVariantServ.workHourLabel.text")); //$NON-NLS-1$

    	workHourField = new XCurrencyField(this, SWT.BORDER);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	gridData.widthHint = 300;
	workHourField.setLayoutData(gridData);

    	this.setSize(new Point(550, 264));
    	
    }

    protected void bindControls() {
	bindControl(carClassField, "carClass");
	bindControl(carServField, "carServ", carServLabel, REQUIRED);
	bindControl(workHourField, "workHour");
    }



}

