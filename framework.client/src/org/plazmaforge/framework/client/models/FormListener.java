package org.plazmaforge.framework.client.models;

import org.plazmaforge.framework.core.exception.ApplicationException;

public interface FormListener {

   
    void openForm(FormEvent event) throws ApplicationException;
    
    void closeForm(FormEvent event) throws ApplicationException;
    
    void disposeForm(FormEvent event) throws ApplicationException;
    
    void updateForm(FormEvent event) throws ApplicationException;
    
    
}
