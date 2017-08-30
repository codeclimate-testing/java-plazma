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
import org.plazmaforge.framework.client.swt.controls.XIntegerField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;

public class CarInsurerPaintBoxPriceEditForm extends AbstractEditForm {

    
    private Label carPaintDetailTypeLabel;
    
    private Label ageFromLabel;
    
    private Label ageToLabel;
    
    private Label priceLabel;
    
    
    
    
    
    private XComboEdit carPaintDetailTypeField;
    
    private XIntegerField ageFromField;
    
    private XIntegerField ageToField;
    
    private XCurrencyField priceField;
    
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public CarInsurerPaintBoxPriceEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {

	setDataSourceSupport(false);
	
	setTitle(Messages.getString("CarInsurerPaintBoxPriceEditForm.title")); //$NON-NLS-1$
	
	GridLayout gridLayout;
	GridData gridData;

    	gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	    	
    	gridLayout.numColumns = 2;
    	
    	setLayout(gridLayout);


    	////
    	carPaintDetailTypeLabel = new Label(this, SWT.NONE);
    	carPaintDetailTypeLabel.setText(Messages.getString("CarInsurerPaintBoxPriceEditForm.carPaintDetailTypeLabel.text")); //$NON-NLS-1$

    	carPaintDetailTypeField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 300;
    	carPaintDetailTypeField.setLayoutData(gridData);

    	

    	////
    	ageFromLabel = new Label(this, SWT.NONE);
    	ageFromLabel.setText(Messages.getString("CarInsurerPaintBoxPriceEditForm.ageFromLabel.text")); //$NON-NLS-1$

    	ageFromField = new XIntegerField(this, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	ageFromField.setLayoutData(gridData);


    	////
    	ageToLabel = new Label(this, SWT.NONE);
    	ageToLabel.setText(Messages.getString("CarInsurerPaintBoxPriceEditForm.ageToLabel.text")); //$NON-NLS-1$

    	ageToField = new XIntegerField(this, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	ageToField.setLayoutData(gridData);

    	
    	////
    	priceLabel = new Label(this, SWT.NONE);
    	priceLabel.setText(Messages.getString("CarInsurerPaintBoxPriceEditForm.priceLabel.text")); //$NON-NLS-1$

    	priceField = new XCurrencyField(this, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	priceField.setLayoutData(gridData);


    	
    	this.setSize(new Point(574, 298));
    	
    	
    }
    
   
    
    protected void bindControls() {
	bindControl(carPaintDetailTypeField, "carPaintDetailType", carPaintDetailTypeLabel, REQUIRED);
	bindControl(ageFromField, "ageFrom");
	bindControl(ageToField, "ageTo");
	bindControl(priceField, "price");
    }
    
   

}
