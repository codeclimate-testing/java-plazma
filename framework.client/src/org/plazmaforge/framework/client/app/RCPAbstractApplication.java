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

package org.plazmaforge.framework.client.app;

import org.plazmaforge.framework.app.AbstractApplication;

/**
 * The Abstract Application
 * 
 * @author ohapon
 *
 * @param <C>
 * @param <MB>
 * @param <TB>
 * @param <SB>
 */
public abstract class RCPAbstractApplication<C, MB, TB, SB> extends AbstractApplication implements RCPApplication {

    protected C content;
    
    protected MB menuBar;
    
    protected TB toolBar;
    
    protected SB statusBar;

    public C getContent() {
        return content;
    }

    public MB getMenuBar() {
        return menuBar;
    }

    public SB getStatusBar() {
        return statusBar;
    }

    public TB getToolBar() {
        return toolBar;
    }
    
    
     
}
