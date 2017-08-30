package org.plazmaforge.bsolution.carservice.client.swt.forms;

import java.util.ArrayList;
import java.util.List;

import org.plazmaforge.bsolution.carservice.common.beans.CarMark;
import org.plazmaforge.bsolution.carservice.common.beans.CarModel;
import org.plazmaforge.framework.client.forms.IEditForm;
import org.plazmaforge.framework.client.forms.IEditFormInitializer;
import org.plazmaforge.framework.client.models.LoadEvent;
import org.plazmaforge.framework.client.models.LoadListener;
import org.plazmaforge.framework.client.models.UpdateEvent;
import org.plazmaforge.framework.client.models.UpdateListener;
import org.plazmaforge.framework.client.swt.controls.XComboEdit;

/**
 * Special class to provide CarMark and CarModel fields
 * @author Oleh Hapon
 * $Id: CarMarkAndModelProvider.java,v 1.1 2008/11/30 18:54:47 ohapon Exp $
 */
public class CarMarkAndModelProvider {

    private XComboEdit markField;
    
    private XComboEdit modelField;

    
    private boolean isLoadCarModel = false;
    
    
    protected XComboEdit getMarkField() {
        return markField;
    }

    protected void setMarkField(XComboEdit markField) {
        this.markField = markField;
    }

    protected XComboEdit getModelField() {
        return modelField;
    }

    protected void setModelField(XComboEdit modelField) {
        this.modelField = modelField;
    }    

    
    /**
     * Initialize fields
     */
    public void init() {
	
    	markField.addLoadListener(new LoadListener() {
    	    public void load(LoadEvent evt) {
    		// Store all marks
    		markField.setData("mark.list", new ArrayList(markField.getDataList()));
    	    }
    	});
    	
    	modelField.addLoadListener(new LoadListener() {
    	    public void load(LoadEvent evt) {
    		// Store all models
    		modelField.setData("model.list", new ArrayList(modelField.getDataList()));
    		isLoadCarModel = true;
    	    }
    	});
    	
    	////////////////////////////////////////////////////////////////////////////////////////////////////
    	
    	modelField.setEditFormInitializer(new IEditFormInitializer() {
    	    public void initEditForm(IEditForm editForm) {
    		if (editForm == null || !editForm.isAddMode()) {
    		    return;
    		}
    		// Add to new form Car Mark value like group
    		editForm.setCategoryEntity(markField.getValue());
    	    }
    	});
    	
    	
    	////////////////////////////////////////////////////////////////////////////////////////////////////
    	
    	markField.addUpdateListener(new UpdateListener() {
    	    public void update(UpdateEvent evt) {
    		
    		CarMark carMark = (CarMark) markField.getValue();
    		List<CarModel> models = (List<CarModel>) modelField.getData("model.list");
    		setCarModelList(models, carMark);
    		
    		CarModel carModel = (CarModel) modelField.getValue();
    		if (carModel != null) {
    		    
    		    if (carMark == null || carMark.getId() == null) {
    			modelField.setValue(null);
    			return;
    		    }
    		    
    		    CarMark m = carModel.getCarMark();
    		    if (m == null || m.getId() == null || (!m.getId().equals(carMark.getId()))) {
    			modelField.setValue(null);
    			return;
    		    }
    		    
    		}
    	    }
    	});
    	
    	modelField.addUpdateListener(new UpdateListener() {
    	    public void update(UpdateEvent evt) {
    	
    		boolean forceLoad = false;
    		CarModel carModel = (CarModel) modelField.getValue();
    		if (carModel == null) {
    		    
    		    // If we update car model by list form and list form was not modify (not add, delete, edit)
    		    // then we get model value because model value is valid always
    		    if (!isLoadCarModel && /*"LIST_FORM".equals(evt.getSource()*/   modelField.isListFormEvent(evt)) {
    			 carModel = (CarModel) modelField.getModelValue();
    			 if (carModel == null) {
    			     return;
    			 }
    			 // We have to load data 
    			 forceLoad = true;
    		    } else {
    			return;
    		    }
    		    
    		}
    		CarMark carMark = carModel.getCarMark();
    		if (carMark == null || carMark.getId() == null) {
    		    return;
    		}

    		if (forceLoad || isLoadCarModel) {
    		    isLoadCarModel = false;
    		    List<CarModel> models = (List<CarModel>) modelField.getData("model.list");
    		    setCarModelList(models, carMark);
    		}
    		
    		if (forceLoad) {
    		    modelField.setValue(carModel);
    		}
    		
    		CarMark selectedCarMark = (CarMark) markField.getValue();
    		if (selectedCarMark == null || selectedCarMark.getId() == null || !carMark.getId().equals(selectedCarMark.getId())) {
    		    markField.setValue(carMark);
    		}
    	    }
    	});
	
    }
    
    
    
    public void refresh() {
	isLoadCarModel = false;
        CarMark carMark = (CarMark) markField.getValue();
        CarModel carModel = (CarModel) modelField.getValue();
        if (carMark == null && carModel == null) {
            return;
        }
        
        List<CarModel> models = (List<CarModel>) modelField.getData("model.list");
        
        if (carMark == null) {
            carMark = carModel.getCarMark();
            markField.setValue(carMark);
        }
        
        setCarModelList(models, carMark);
    }
    
    protected void setCarModelList(List<CarModel> models, CarMark selectedCarMark) {
	List<CarModel> dataList = new ArrayList<CarModel>();
	if (models == null || selectedCarMark == null || selectedCarMark.getId() == null) {
	    modelField.setDataList(dataList);
	    return;
	}
	
	int size = models.size();
	for (int i = 0; i < size; i++) {
	    CarModel carModel = (CarModel) models.get(i);
	    CarMark carMark = carModel.getCarMark();
	    if (carMark == null) {
		continue;
	    }
	    if (selectedCarMark.getId().equals(carMark.getId())) {
		dataList.add(carModel);
	    }
	}
	
	CarModel currentValue = (CarModel) modelField.getValue();
	modelField.setDataList(dataList);
	if (currentValue != null) {
	    Integer selectedMarkId = selectedCarMark.getId();
	    Integer currentMarkId = currentValue.getCarMark() == null ? null : currentValue.getCarMark().getId(); 
	    modelField.setValue(selectedMarkId.equals(currentMarkId) ? currentValue : null);
	}
	
    }
    
}
