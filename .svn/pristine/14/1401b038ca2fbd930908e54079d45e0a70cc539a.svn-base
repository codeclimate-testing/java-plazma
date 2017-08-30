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

/*
 * Created on 09.08.2005
 *
 */
package org.plazmaforge.bsolution.finance.client.swing.forms;

import org.plazmaforge.bsolution.document.client.swing.forms.AbstractDocumentParentEdit;
import org.plazmaforge.bsolution.finance.FinanceEnvironment;
import org.plazmaforge.bsolution.finance.common.beans.FinanceDocument;
import org.plazmaforge.bsolution.product.common.beans.ProductDocument;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.resources.Resources;



/**
 * @author Oleh Hapon
 *
 */
public abstract class AbstractFinanceDocumentParentEdit extends AbstractDocumentParentEdit {


    public AbstractFinanceDocumentParentEdit() {
        super();
    }
    
    public AbstractFinanceDocumentParentEdit(Resources resources) {
        super(resources);
    }
    
    protected FinanceDocument getFinanceDocument() {
        return (FinanceDocument) this.getEntity();
    }
    
    protected void initData() throws ApplicationException {
        super.initData();
        FinanceEnvironment.initFinanceDocument(getFinanceDocument(), getEntityCode(), getEnterpriseContext());
    }
    
    protected ProductDocument getProductDocument() {
        return (ProductDocument) this.getEntity();
    }
}
