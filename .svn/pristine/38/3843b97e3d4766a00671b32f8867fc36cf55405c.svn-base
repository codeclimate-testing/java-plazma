package org.plazmaforge.bsolution.carservice.common.beans;

import org.plazmaforge.framework.ext.model.ImageEntry;
import org.plazmaforge.framework.ext.model.ImageEntryImpl;
import org.plazmaforge.framework.ext.model.BaseEntity;

public class CarServOrderImage extends BaseEntity {

    
    
    public static final String INCOME_TYPE = "INCOME";
    
    public static final String OUTCOME_TYPE = "OUTCOME";
    
    
    
	
    private CarServOrder carServOrder;
    
    private String recordType;
    
    
    private ImageEntry imageEntry;    
    

    public CarServOrder getCarServOrder() {
        return carServOrder;
    }

    public void setCarServOrder(CarServOrder carServOrder) {
        this.carServOrder = carServOrder;
    }
    


    public ImageEntry getImageEntry() {
	if (imageEntry == null) {
	    imageEntry = new ImageEntryImpl();
	}
        return imageEntry;
    }

    public void setImageEntry(ImageEntry imageEntry) {
        this.imageEntry = imageEntry;
    }

    
    public void setImageName(String name) {
	getImageEntry().setName(name);
    }
    
    public String getImageName() {
	return getImageEntry().getName();
    }
    
    public void setImageSize(int size) {
	getImageEntry().setSize(size);
    }
    
    public int getImageSize() {
	return getImageEntry().getSize();
    }

    public String getRecordType() {
	if (recordType == null) {
	    recordType = INCOME_TYPE;
	}
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }
    
    
}
