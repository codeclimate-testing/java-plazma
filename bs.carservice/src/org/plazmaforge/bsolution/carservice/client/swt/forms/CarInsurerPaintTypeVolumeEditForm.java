package org.plazmaforge.bsolution.carservice.client.swt.forms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.plazmaforge.bsolution.carservice.common.beans.CarInsurerPaintTypeVolume;
import org.plazmaforge.bsolution.carservice.common.beans.CarPaintDetailType;
import org.plazmaforge.framework.client.PWT;
import org.plazmaforge.framework.client.models.UpdateEvent;
import org.plazmaforge.framework.client.models.UpdateListener;
import org.plazmaforge.framework.client.swt.controls.XCheckBox;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;
import org.plazmaforge.framework.client.swt.controls.XCurrencyField;
import org.plazmaforge.framework.client.swt.controls.XNumberField;
import org.plazmaforge.framework.client.swt.forms.AbstractEditForm;
import org.plazmaforge.framework.core.exception.ApplicationException;

public class CarInsurerPaintTypeVolumeEditForm extends AbstractEditForm {

    private Label carClassLabel;
    
    private Label carPaintDetailTypeLabel;
    
    
    private Label rangeLabel;
    
    private Label volumeLabel;
    
    private Label volumeToLabel;
    
    private Label percentOfBasicLabel;
    
    
    
    private XComboEdit carClassField;
    
    private XComboEdit carPaintDetailTypeField;
    
    private XCheckBox rangeField;
    
    private XNumberField volumeField;
    
    private XNumberField volumeToField;
    
    private XCurrencyField percentOfBasicField;
    
    
    /**
     * Create the form
     * @param parent
     * @param style
     */
    public CarInsurerPaintTypeVolumeEditForm(Composite parent, int style) {
	super(parent, style);
	initialize();

    }

    private void initialize() {

	setDataSourceSupport(false);
	
	setTitle(Messages.getString("CarInsurerPaintTypeVolumeEditForm.title")); //$NON-NLS-1$
	
	GridLayout gridLayout;
	GridData gridData;

    	gridLayout = new GridLayout();
	gridLayout.marginBottom = 10;
	gridLayout.marginTop = 10;
	    	
    	gridLayout.numColumns = 2;
    	
    	setLayout(gridLayout);

    	carClassLabel = new Label(this, SWT.NONE);
    	carClassLabel.setText(Messages.getString("CarInsurerPaintTypeVolumeEditForm.carClassLabel.text")); //$NON-NLS-1$

    	carClassField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON );
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 300;
    	carClassField.setLayoutData(gridData);

    	////
    	carPaintDetailTypeLabel = new Label(this, SWT.NONE);
    	carPaintDetailTypeLabel.setText(Messages.getString("CarInsurerPaintTypeVolumeEditForm.carPaintDetailTypeLabel.text")); //$NON-NLS-1$

    	carPaintDetailTypeField = new XComboEdit(this, SWT.BORDER, PWT.POPUP_BUTTON | PWT.VIEW_BUTTON);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	gridData.widthHint = 300;
    	carPaintDetailTypeField.setLayoutData(gridData);

    	

    	////
    	rangeLabel = new Label(this, SWT.NONE);
    	rangeLabel.setText(Messages.getString("CarInsurerPaintTypeVolumeEditForm.rangeLabel.text")); //$NON-NLS-1$

    	rangeField = new XCheckBox(this, SWT.NONE);
    	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
    	rangeField.setLayoutData(gridData);
    	
    	////
    	volumeLabel = new Label(this, SWT.NONE);
    	volumeLabel.setText(Messages.getString("CarInsurerPaintTypeVolumeEditForm.volumeLabel.text")); //$NON-NLS-1$

    	volumeField = new XNumberField(this, SWT.BORDER);
    	volumeField.setPattern("-#,###,##0.000");
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	volumeField.setLayoutData(gridData);

    	////
    	volumeToLabel = new Label(this, SWT.NONE);
    	volumeToLabel.setText(Messages.getString("CarInsurerPaintTypeVolumeEditForm.volumeToLabel.text")); //$NON-NLS-1$

    	volumeToField = new XNumberField(this, SWT.BORDER);
    	volumeToField.setPattern("-#,###,##0.000");
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	volumeToField.setLayoutData(gridData);

    	
    	////
    	percentOfBasicLabel = new Label(this, SWT.NONE);
    	percentOfBasicLabel.setText(Messages.getString("CarInsurerPaintTypeVolumeEditForm.percentOfBasicLabel.text")); //$NON-NLS-1$

    	percentOfBasicField = new XCurrencyField(this, SWT.BORDER);
    	gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
    	gridData.widthHint = 100;
    	percentOfBasicField.setLayoutData(gridData);

    	this.setSize(new Point(574, 298));
    	
    	carPaintDetailTypeField.addUpdateListener(new UpdateListener() {
    	    public void update(UpdateEvent evt) {
    		CarPaintDetailType carPaintDetailType = (CarPaintDetailType) carPaintDetailTypeField.getValue();
    		updatePercentField(carPaintDetailType);
    	    }
    	});
    }
    
    public void updateForm()  throws ApplicationException {
	super.updateForm();
	CarPaintDetailType carPaintDetailType = getCarInsurerPaintTypeVolume().getCarPaintDetailType();
	updatePercentField(carPaintDetailType);
    }
   
    protected void updatePercentField(CarPaintDetailType carPaintDetailType) {
	boolean isBaseType = carPaintDetailType == null ? false: carPaintDetailType.isBaseType(); 
	percentOfBasicField.setEnabled(!isBaseType);
    }
    
    protected CarInsurerPaintTypeVolume getCarInsurerPaintTypeVolume() {
	return  (CarInsurerPaintTypeVolume) getEntity();
    }
   
    
    protected void bindControls() {
	bindControl(carClassField, "carClass", carClassLabel, REQUIRED);
	bindControl(carPaintDetailTypeField, "carPaintDetailType", carPaintDetailTypeLabel, REQUIRED);

	bindControl(rangeField, "range");
	bindControl(volumeField, "volume");
	bindControl(volumeToField, "volumeTo");
	bindControl(percentOfBasicField, "percentOfBasic");
    }
}
