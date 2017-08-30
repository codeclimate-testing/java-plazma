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
 * Created on 10.05.2009
 *
 */

package org.plazmaforge.framework.client.swt.dialogs;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

/** 
 * @author Oleh Hapon
 * $Id: ImagePanel.java,v 1.4 2010/04/28 06:36:49 ohapon Exp $
 */

public class ImagePanel extends Composite {

    private ImageCanvas canvas;
    
    private byte[] data;
    
    /** 
     * Last open file name.
     * If we don't use open dialog then file name is null.
     * 
     */
    
    private String fileName;
    
    
    public ImagePanel(Composite parent, String title) {
	
	super(parent, SWT.NONE);
	
	setLayout(new FillLayout());
	
	Group group = new Group(this, SWT.NONE);
	if (title != null) {
	   group.setText(title);
	}
	
	
	GridLayout layout = new GridLayout();
	layout.numColumns = 2;
	
	group.setLayout(layout);
	
	createImagePanel(group);
	createToolPanel(group);
    }
    
    protected Composite createImagePanel(Composite parent) {
	canvas = new ImageCanvas(parent, SWT.BORDER);
	GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
	canvas.setLayoutData(gridData);
	
	return canvas;
    }

    protected Composite createToolPanel(Composite parent) {
	Composite panel = new Composite(parent, SWT.NONE);
	GridData gridData = new GridData(SWT.FILL, SWT.FILL, false, true);
	panel.setLayoutData(gridData);

	GridLayout layout = new GridLayout();
	panel.setLayout(layout);
	
	Button button = new Button(panel, SWT.NONE);
	button.setText(Messages.getString("ImageTablePanel.load.button"));
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	button.setLayoutData(gridData);

	button.addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		doLoadAction();
	    }
	});
	
	/*
	button = new Button(panel, SWT.NONE);
	button.setText(Messages.getString("ImageTablePanel.preview.button"));
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	button.setLayoutData(gridData);
	
	button.addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		//doPreviewAction();
	    }
	});
	
	button = new Button(panel, SWT.NONE);
	button.setText(Messages.getString("ImageTablePanel.edit.button"));
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	button.setLayoutData(gridData);
	
	button.addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		//doEditAction();
	    }
	});
	*/

	
	button = new Button(panel, SWT.NONE);
	button.setText(Messages.getString("ImageTablePanel.remove.button"));
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	button.setLayoutData(gridData);
	
	button.addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		doRemoveAction();
	    }
	});

	return panel;
    }
    
    
    protected void doLoadAction() {
	Shell shell = getShell();
	try {

	    FileDialog filedialog = new FileDialog(shell);
	    filedialog.setText("Open image file");
	    filedialog.setFilterExtensions(new String[] { "*.gif; *.jpg; *.png; *.ico; *.bmp" });
	    
	    fileName = filedialog.open();
	    if (fileName == null) {
		return;
	    }
	    File imageFile = new File(fileName);
	    if (!imageFile.exists()) {
		openError("File " + fileName + " not found");
		return;
	    }
	    
	    
	    FileInputStream fis = new FileInputStream(imageFile);
	    data = getBytes(fis);

	    Image image = createImage(data);
	    canvas.setImage(image);
	    canvas.redraw();
	    
	    
	} catch (Throwable ex) {
	    openError(ex.getMessage() == null ? ex.toString() : ex.getMessage());
	}

    }
    
    
    protected void doRemoveAction() {

	if (data == null) {
	    return;
	}

	if (!MessageDialog.openConfirm(getShell(), "Confirm", Messages.getString("ImageTablePanel.confirmRemoveImage.message"))) {
	    return;
	}
	data = null;
	canvas.setImage(null);
	canvas.redraw();
    }
    
    
    
    private Image createImage(byte[] data) throws Exception {
	
	if (data == null) {
	    return null;
	}
	
	if (data.length <= 100000) {
	    // OutOfMemory !!!
	    ByteArrayInputStream bais = new ByteArrayInputStream(data);
	    org.eclipse.swt.graphics.ImageData idata = new org.eclipse.swt.graphics.ImageData(bais);
	    return new Image(getShell().getDisplay(), idata);
	}
	
	// If image data are very big we have OutOfMemory error (Java heap space)
	// We use tmp file to store image data
	File tmpFile = File.createTempFile("tmp" + System.currentTimeMillis(), "");
	String fileName = tmpFile.getAbsolutePath();
	FileOutputStream fos = new FileOutputStream(fileName);
	fos.write(data);
	fos.close();

	return new Image(getShell().getDisplay(), fileName);
    }
    
    protected void openError(String title, String message) {
	MessageDialog.openError(getShell(), title, message);
    }

    protected void openError(String message) {
	MessageDialog.openError(getShell(), "Error", message);
    }

    private byte[] getBytes(InputStream is) throws IOException {
	byte[] data = new byte[is.available()];
	is.read(data);
	return data;
    }

    public void setData(byte[] data) {
        this.data = data;
        try {
            Image image = createImage(data);
            canvas.setImage(image);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] getData() {
        return data;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileExt() {
	if (fileName == null) {
	    return null;
	}
        int index = fileName.lastIndexOf(".");
        if (index < 0 || index + 1 == fileName.length()) {
            return null;
        }
        return fileName.substring(index + 1);
    }
    
}
