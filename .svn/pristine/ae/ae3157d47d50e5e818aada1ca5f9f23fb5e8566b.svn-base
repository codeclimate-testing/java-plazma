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
package org.plazmaforge.framework.client.swing.gui;

import javax.swing.*;
import java.io.File;

/**
 * @author Oleh Hapon
 * Date: 22.01.2004
 * Time: 11:01:32
 * $Id: DefaultFileListBoxModel.java,v 1.2 2010/04/28 06:36:10 ohapon Exp $
 */
public class DefaultFileListBoxModel extends DefaultListModel implements FileListBoxModel {

    public DefaultFileListBoxModel() {
        super();
    }

    public void addFile(File file) {
        addElement(file);
    }

	
    public File getFile(int idx) {
        return (File)get(idx);
    }

 
    public String[] getFileNames() {		
        String[] fileNames = new String[getSize()];
        for (int i = 0, limit = fileNames.length; i < limit; ++i) {
            fileNames[i] = getFile(i).getAbsolutePath();
        }
        return fileNames;
    }

 

    public void insertFileAt(File file, int idx) {
        insertElementAt(file, idx);
    }


    public File removeFile(int idx) {
        return (File) remove(idx);
    }

}
