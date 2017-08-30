/*
 * Copyright (C) 2012-2013 Oleh Hapon ohapon@users.sourceforge.net
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

/**
 * 
 */
package org.plazmaforge.bs;

import java.io.Serializable;
import java.util.List;

import org.plazmaforge.framework.core.criteria.Criteria;
import org.plazmaforge.framework.core.data.Callback;
import org.plazmaforge.framework.core.data.Customizer;
import org.plazmaforge.framework.core.data.PropertyProvider;
import org.plazmaforge.framework.core.data.PropertyProviderFactory;
import org.plazmaforge.framework.core.data.object.Creator;
import org.plazmaforge.framework.core.data.path.TypeInfo;
import org.plazmaforge.framework.core.data.path.TypeResolver;
import org.plazmaforge.framework.core.data.provider.DataProviderAsync;
import org.plazmaforge.framework.core.data.provider.ListProviderAsync;
import org.plazmaforge.framework.core.data.provider.ModelProviderAsync;
import org.plazmaforge.framework.core.logging.Logger;
import org.plazmaforge.framework.core.service.ServiceCaller;
import org.plazmaforge.framework.util.CoreUtils;
import org.plazmaforge.framework.uwt.Application;
import org.plazmaforge.framework.uwt.ApplicationContext;
import org.plazmaforge.framework.uwt.UWT;
import org.plazmaforge.framework.uwt.form.IEditForm;
import org.plazmaforge.framework.uwt.form.IForm;
import org.plazmaforge.framework.uwt.form.IListForm;
import org.plazmaforge.framework.uwt.widget.IField;
import org.plazmaforge.framework.uwt.widget.IViewer;
import org.plazmaforge.framework.uwt.widget.Viewer;

/**
 * @author ohapon
 *
 */
public class ApplicationFormCustomizer implements Customizer {

    
    private static final Logger logger = Logger.getLogger(ApplicationFormCustomizer.class.getName());
    
    
    private TypeResolver typeResolver;
    
    private Creator entityCreator;
    
    
    public ApplicationFormCustomizer(TypeResolver typeResolver, Creator entityCreator) {
	this.typeResolver = typeResolver;
	this.entityCreator = entityCreator;
    }

    @Override
    public void customize(Object object) {

	if (object == null) {
	    return;
	}
	if (!(object instanceof IForm)) {
	    return;
	}
	
	IForm<?> form = (IForm<?>) object;
	
	String className = form.getClass().getName();
	
	String genSuffix = UWT.GEN_SUFFIX;
	if (className.endsWith(genSuffix)) {
	    className = className.substring(0, className.length() - genSuffix.length());
	}
	TypeInfo typeInfo = typeResolver.parseClass(className);
	
	cusomizeForm(form, typeInfo);
    }
    
    protected <T> void cusomizeForm(IForm<T> form, TypeInfo typeInfo) {
	// base customization
	
	if (form instanceof IListForm) {
	    cusomizeListForm((IListForm<T>) form, typeInfo);
	    return;
	} else if (form instanceof IEditForm) {
	    cusomizeEditForm((IEditForm<T>) form, typeInfo);
	    return;
	}
    }
    
    protected <T> void cusomizeListForm(final IListForm<T> form, TypeInfo typeInfo) {
	
	//TODO: Must check service name
	String className = form.getClass().getName();
	String entityName = typeResolver.getPath(typeInfo, "Entity");
	String entityClass = typeResolver.getClassName(typeInfo, "Entity");
	String serviceName = typeResolver.getPath(typeInfo, "Service");
	String editFormName = typeResolver.getPath(typeInfo, "EditForm");
	String editFormClass = typeResolver.getClassName(typeInfo, "EditForm");
	
	log(form, "entityName='" + entityName + "'");
	log(form, "entityClass='" + entityClass + "'");
	log(form, "serviceName='" + serviceName + "'");
	log(form, "editFormName='" + editFormName + "'");
	log(form, "editFormClass='" + editFormClass + "'");

	form.setModelName(entityName);
	form.setData("$entityClass", entityClass);
	form.setServiceName(serviceName);
	
	if (form.getResourceName() == null) {
	    form.setResourceName(getResourceName(className));
	}
	
	// LazyLoad=false
	if (form.getLazyLoad() == null) {
	    form.setLazyLoad(false);
	}

	// ClientData=false (Load data from server)
	if (form.getClientData() == null) {
	    form.setClientData(false);
	}

	
	// DataProvider
	if (isNeedDataProvider(form)) {
	    initFormDataProvider(form);
	}


	// PropertyProvider
	if  (isNeedPropertyProvider(form)) {
	    final PropertyProvider propertyProvider = getPropertyProvider(entityClass);
	    if (propertyProvider != null) {
		form.setPropertyProvider(propertyProvider);
		Customizer postCustomizer = new Customizer() {

		    @Override
		    public void customize(Object object) {
			Viewer<T> viewer = form.getActiveViewer();
			if (viewer == null) {
			    return;
			}
			viewer.setPropertyProvider(propertyProvider);
		    }

		};

		form.setPostCustomizer(postCustomizer);
	    }
	}
	
	// EditForm
	if (isNeedFormByCategory(form, "EditForm") ) {
	    form.addRelationForm("EditForm", editFormClass);
	}

    }
    
    protected <T> void cusomizeEditForm(final IEditForm<T> form, TypeInfo typeInfo) {
	
	//TODO: Must check service name
	String className = form.getClass().getName();
	String entityName = typeResolver.getPath(typeInfo, "Entity");
	String entityClass = typeResolver.getClassName(typeInfo, "Entity");
	String serviceName = typeResolver.getPath(typeInfo, "Service");
	
	log(form, "entityName='" + entityName + "'");
	log(form, "entityClass='" + entityClass + "'");
	log(form, "serviceName='" + serviceName + "'");
	
	form.setModelName(entityName);
	form.setData("$entityClass", entityClass);
	form.setServiceName(serviceName);
	
	if (form.getResourceName() == null) {
	    form.setResourceName(getResourceName(className));
	}

	// DataProvider
	if (isNeedDataProvider(form)) {
	    initFormDataProvider(form);
	}
	
	// PropertyProvider
	if (isNeedPropertyProvider(form)) {
	    PropertyProvider propertyProvider = getPropertyProvider(entityClass);
	    if (propertyProvider != null) {
		form.setPropertyProvider(propertyProvider);
	    }
	}
	
	    
	Customizer postCustomizer = new Customizer() {

	    @Override
	    public void customize(Object object) {

		final List<IField<?>> fields = form.getFields();
		if (fields == null) {
		    return;
		}

		for (IField<?> field : fields) {
		    if (!(field instanceof IViewer)) {
			continue;
		    }
		    IViewer<?> viewerField = (IViewer<?>) field;
		    String dataType = field.getDataType();
		    if (dataType == null || dataType.indexOf("/") == -1) {
			continue;
		    }
		    TypeInfo fieldEntityInfo = typeResolver.parsePath(dataType, "Entity");
		    String fieldServiceName = typeResolver.getPath(fieldEntityInfo, "Service");
		    DataProviderAsync dataProviderAsync = new FieldDataProviderAsync(form, fieldServiceName);
		    viewerField.setDataProviderAsync(dataProviderAsync);
		}

	    }

	};

	form.setPostCustomizer(postCustomizer);		
	
    }

    protected <T> void initFormDataProvider(IForm<T> form) {
	form.setDataProviderAsync(createServiceDataProviderAsync(form));
    }

    protected <T> ServiceDataProviderAsync<T> createServiceDataProviderAsync(IForm<T> form) {
	return new ServiceDataProviderAsync<T>(form);
    }
    
    ////
    
    class FieldDataProviderAsync<T> implements ListProviderAsync<T> {

	private IForm<?> form;

	private String serviceName;
	
	public FieldDataProviderAsync(IForm<?> form, String serviceName) {
	    super();
	    this.form = form;
	    this.serviceName = serviceName;
	}

	protected ServiceCaller getServiceCaller() {
	    return form.getServiceCaller();
	}

	@Override
	public void getList(Callback<List<T>> callback) {
	    getServiceCaller().call(serviceName, "findAll", (Object[]) null, callback);
	}
    }
    
    
    ////
	
    class ServiceDataProviderAsync<T> implements ModelProviderAsync<T> {

	private IForm<?> form;

	private String serviceName;
	
	private String entityClass;

	public ServiceDataProviderAsync(IForm<?> form) {
	    super();
	    this.form = form;
	    this.serviceName = form.getServiceName();
	    this.entityClass = (String) form.getData("$entityClass");
	}

	protected ServiceCaller getServiceCaller() {
	    return form.getServiceCaller();
	}

	@Override
	public void getList(Callback<List<T>> callback) {
	    getServiceCaller().call(serviceName, "findAll", (Object[]) null, callback);
	}

	@Override
	public void getList(Criteria criteria, Callback<List<T>> callback) {
	    getServiceCaller().call(serviceName, "findAll",  new Object[] {criteria}, callback);
	}

	@Override
	public void create(T data, Callback<Serializable> callback) {
	    getServiceCaller().call(serviceName, "create",  new Object[] {data}, callback);
	}

	@Override
	public void remove(T data, Callback<?> callback) {
	    getServiceCaller().call(serviceName, "remove",  new Object[] {data}, callback);
	}

	@Override
	public void removeById(Serializable id, Callback<?> callback) {
	    getServiceCaller().call(serviceName, "removeById",  new Object[] {id}, callback);
	}

	@Override
	public void update(T data, Callback<?> callback) {
	    getServiceCaller().call(serviceName, "store",  new Object[] {data}, callback);
	}

	@Override
	public void getById(Serializable id, Callback<T> callback) {
	    getServiceCaller().call(serviceName, "findById",  new Object[] {id}, callback);
	}

	@Override
	public void get(Criteria criteria, Callback<T> callback) {
	    // TODO
	}

	@Override
	public void instance(Callback<T> callback) {
	    T entity = null;
	    if (entityCreator != null) {
		entity = (T) entityCreator.create(entityClass);
	    }
	    callback.onSuccess(entity); 
	}

    }

    protected <T> boolean isNeedDataProvider(IForm<T> form) {
	if (form == null) {
	    return false;
	}
	return form.getDataProvider() == null && form.getDataProviderAsync() == null;
    }
    
    protected <T> boolean isNeedPropertyProvider(IForm<T> form) {
	if (form == null) {
	    return false;
	}
	return form.getPropertyProvider() == null;
    }
    
    protected <T> boolean isNeedFormByCategory(IForm<T> form, String category) {
	if (form == null || category == null) {
	    return false;
	}
	return form.getRelationFormByCategory(category) == null;
    }

    
    protected PropertyProviderFactory getPropertyProviderFactory() {
	return (PropertyProviderFactory) Application.getCurrent().getApplicationContext().getAttribute(ApplicationContext.CONFIG_PROPERTY_PROVIDER_FACTORY);
    }
    
    protected PropertyProvider getPropertyProvider(String entityClass) {
	PropertyProviderFactory propertyProviderFactory = getPropertyProviderFactory();
	if (propertyProviderFactory == null) {
	    return null;
	}
	return propertyProviderFactory.getPropertyProvider(entityClass);
    }
    
    protected String getResourceName(String className) {
	String resourceName = CoreUtils.getPackageName(className);
	return (resourceName == null ? "" : resourceName) + "messages";
    }
    
    protected void log(IForm<?> form, String message) {
	logger.log("Customize form '" + form.getClass() + "': " + message);
    }
    
}
