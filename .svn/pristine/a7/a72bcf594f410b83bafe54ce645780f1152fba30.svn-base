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

public class CarDetailVariantPaintEditForm extends AbstractEditForm {

    private Label carPaintLabel;
    private Label carPaintDetailTypeLabel;
    
    private XComboEdit carPaintField;
    private XComboEdit carPaintDetailTypeField;
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public CarDetailVariantPaintEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }
    
    
    private void initialize() {
	
	setDataSourceSupport(false);
	
	GridData gridData;


	setTitle(Messages.getString("CarDetailVariantPaint.title")); //$NON-NLS-1$

	
	GridLayout gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	gridLayout.numColumns = 2;
	setLayout(gridLayout);
    	
    	carPaintLabel = new Label(this, SWT.NONE);
	carPaintLabel.setText(Messages.getString("CarDetailVariantPaint.carPaintLabel.text")); //$NON-NLS-1$

    	carPaintField = new XComboEdit(this, SWT.BORDER, PWT.VIEW_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	gridData.widthHint = 300;
    	carPaintField.setLayoutData(gridData);

    	
    	carPaintDetailTypeLabel = new Label(this, SWT.NONE);
	carPaintDetailTypeLabel.setText(Messages.getString("CarDetailVariantPaint.carPaintDetailTypeLabel.text")); //$NON-NLS-1$

    	carPaintDetailTypeField = new XComboEdit(this, SWT.BORDER, PWT.VIEW_BUTTON);
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	gridData.widthHint = 300;
    	carPaintDetailTypeField.setLayoutData(gridData);
    	
    	this.setSize(new Point(550, 264));
    	
    }

    protected void bindControls() {
	bindControl(carPaintField, "carPaint", carPaintLabel, REQUIRED);
	bindControl(carPaintDetailTypeField, "carPaintDetailType", carPaintDetailTypeLabel, REQUIRED);
    }



}
