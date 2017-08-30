/*
 * Copyright (C) 2005-2010 Oleh Hapon ohapon@users.sourceforge.net
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307, USA.
 * 
 * Oleh Hapon
 * Kyiv, UKRAINE
 * ohapon@users.sourceforge.net
 */

package org.plazmaforge.framework.client.forms;

import java.io.Serializable;
import java.util.List;

import org.plazmaforge.framework.core.criteria.ICriteria;
import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.core.criteria.CriteriaFilterSet;
import org.plazmaforge.framework.core.criteria.CriteriaSorterSet;
import org.plazmaforge.framework.core.criteria.ICriteriaFilter;
import org.plazmaforge.framework.core.criteria.ICriteriaSorter;
import org.plazmaforge.framework.core.criteria.InCriteriaFilter;
import org.plazmaforge.framework.core.criteria.Order;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.ext.association.Association;
//import org.plazmaforge.framework.service.impl.ICriteria;
import org.plazmaforge.framework.util.StringUtils;


/** 
 * @author Oleh Hapon
 *
 */

public abstract class AbstractListFormController extends AbstractFormController implements IListFormController {

    
    
    public AbstractListFormController() {
	super();
    }

    public void doRemoveEntity() throws ApplicationException {
	
    }
    
    public void doFindEntity() throws ApplicationException {
	
    }

    
    public void doLoadRow() throws ApplicationException{
	
    }
    
    public void doRemoveRow() throws ApplicationException {
    
    }
    
    
    
    public void doRefreshAction() throws ApplicationException {
	viewAction("Refresh");
    }
    
    public void doChooseAction() throws ApplicationException {
	viewAction("Choose");
    }
    
    public void doAddAction() throws ApplicationException {
	viewAction("Add");
    }
    
    public void doDelAction() throws ApplicationException {
	viewAction("Del");
    }
    
    public void doEditAction() throws ApplicationException {
	viewAction("Edit");
    }
    
    public void doAddCycleAction() throws ApplicationException {
	viewAction("Add cycle");
    }
    
  
    public void doSortAction() throws ApplicationException {
	viewAction("Sort");
    }
    
    public void doFindAction() throws ApplicationException {
	viewAction("Find");
    }
    
    public void doFilterAction() throws ApplicationException {
	viewAction("Filter");
    }
    
    /*
    public void configure() {
	super.configure();
	configureListFormClass();
    }
    */

    public void configureModel() {
	super.configureModel();
	configureListFormClass();
    }
    
    protected void configureListFormClass() {
	Association association = getAssociation();
	if (association == null) {
	    return;
	}
	IFormModel model = getModel();
	if (model == null) {
	    return;
	}
	
	// TODO: Only for list form
	if (model.isAutoConfigureEntityForm() && !model.isReadOnly() && model.getEntityFormClass() == null) {
	    model.setEntityFormClass(association.getElementByType(getEditFormType()));
	}		
    }
    
    // -----------------------------------------------------------------------------------------------------------------------------------
    //
    // Entity methods. Methods use entity manager. You can overwrite this methods. 
    //
    // -----------------------------------------------------------------------------------------------------------------------------------
    
    public List loadDataList() throws ApplicationException {
	if (getEntityManager() == null) {
	    return null;
	}
	Object service = getEntityService();
	if (service == null) {
	    return null;
	}
	return getEntityManager().findAll(service);
    }

    public List loadDataList(ICriteria criteria) throws ApplicationException {
	if (getEntityManager() == null) {
	    return null;
	}
	Object service = getEntityService();
	if (service == null) {
	    return null;
	}
	Criteria ermCriteria = createERMCriteria(criteria);
	return getEntityManager().findByCriteria(service, ermCriteria);
    }

    ////
    
    protected Criteria createERMCriteria(ICriteria inputCriteria) {
   	Criteria criteria = new Criteria();;
   	populateERMCriteria(inputCriteria, criteria);
   	return criteria;
     }
    
    
    
    /**
     * Populate ERM Criteria by <code>ICriteria</code>
     * @param inputCriteria
     * @param criteria
     */
    protected void populateERMCriteria(ICriteria inputCriteria, Criteria criteria) {
	if (inputCriteria == null || criteria == null) {
	    return;
	}
	criteria.setOffset(inputCriteria.getFrom());
	criteria.setLimit(inputCriteria.getSize());
	if (inputCriteria.hasFilter()) {
	    CriteriaFilterSet s = inputCriteria.getFilterSet();
	    List<ICriteriaFilter> filters =  s.getItems();
	    for (ICriteriaFilter filter: filters) {
		String property = filter.getField();
		if (filter instanceof InCriteriaFilter) {
		    InCriteriaFilter inFilter = (InCriteriaFilter) filter;
		    Object[] values = inFilter.getValues();
		    Serializable[] serializableValues = null;
		    if (values != null) {
			serializableValues = new Serializable[values.length];
			int i = 0;
			for (Object value: values) {
			    serializableValues[i] = (Serializable) value;
			    i++;
			}
		    }
		    criteria.addInFilter(property, serializableValues);
		    continue;
		}
		
		String clause = filter.getClause();
		Object value = filter.getValue();
		
		// Special fix to convert user match string to SQL math string
		// '*' -> '%'
		if (ICriteria.LIKE.equals(clause) && value != null) {
		    String expr = value.toString();
		    value = StringUtils.normalizeLike(expr, "*", null, "%", null, true);
		}
		criteria.addFilter(filter.getField(), (Serializable) value, clause);
		
	    }
	}
	if (inputCriteria.hasSorter()) {
	    CriteriaSorterSet s = inputCriteria.getSorterSet();
	    List<ICriteriaSorter> sorters =  s.getItems();
	    for (ICriteriaSorter sorter: sorters) {
		criteria.addOrder(new Order(sorter.getField(), sorter.isDown()));
	    }
	}
    }
}


