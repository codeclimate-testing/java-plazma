package org.plazmaforge.bsolution.carservice.client.swt.forms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.controls.XIntegerField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;

public class CarInsurerPartPriceEditForm extends AbstractEditForm {

    
    private Label ageFromLabel;
    
    private Label ageToLabel;
    
    private Label discountPercentLabel;
    
    
    
    
    private XIntegerField ageFromField;
    
    private XIntegerField ageToField;
    
    private XCurrencyField discountPercentField;
    
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public CarInsurerPartPriceEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {

	setDataSourceSupport(false);
	
	setTitle(Messages.getString("CarInsurerPartPriceEditForm.title")); //$NON-NLS-1$
	
	GridLayout gridLayout;
	GridData gridData;

    	gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	    	
    	gridLayout.numColumns = 2;
    	
    	setLayout(gridLayout);



    	////
    	ageFromLabel = new Label(this, SWT.NONE);
    	ageFromLabel.setText(Messages.getString("CarInsurerPartPriceEditForm.ageFromLabel.text")); //$NON-NLS-1$

    	ageFromField = new XIntegerField(this, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	ageFromField.setLayoutData(gridData);


    	////
    	ageToLabel = new Label(this, SWT.NONE);
    	ageToLabel.setText(Messages.getString("CarInsurerPartPriceEditForm.ageToLabel.text")); //$NON-NLS-1$

    	ageToField = new XIntegerField(this, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	ageToField.setLayoutData(gridData);

    	
    	////
    	discountPercentLabel = new Label(this, SWT.NONE);
    	discountPercentLabel.setText(Messages.getString("CarInsurerPartPriceEditForm.discountPercentLabel.text")); //$NON-NLS-1$

    	discountPercentField = new XCurrencyField(this, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	discountPercentField.setLayoutData(gridData);


    	
    	this.setSize(new Point(574, 298));
    	
    	
    }
    
   
    
    protected void bindControls() {
	bindControl(ageFromField, "ageFrom");
	bindControl(ageToField, "ageTo");
	bindControl(discountPercentField, "discountPercent");
    }

}
