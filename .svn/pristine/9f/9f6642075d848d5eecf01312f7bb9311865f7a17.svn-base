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
 * Created on 02.09.2008
 *
 */

package org.plazmaforge.framework.client.swt.dialogs;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.plazmaforge.framework.client.swt.SWTResourceManager;
import org.plazmaforge.framework.client.swt.forms.Messages;
import org.plazmaforge.framework.ext.model.ImageEntry;

/** 
 * @author Oleh Hapon
 * $Id: ImageViewer.java,v 1.5 2010/12/05 07:52:25 ohapon Exp $
 */

public class ImageViewer extends Dialog {

    private static final String FIRST_ACTION = "FIRST";
    private static final String PREVIOUS_ACTION = "PREVIOUS";
    private static final String NEXT_ACTION = "NEXT";
    private static final String LAST_ACTION = "LAST";
    
    private ImageCanvas canvas;
    private Label infoLabel;
    private ImageEntry imageEntry;
    private ImageNavigator imageNavigator;
    
    
    private String fileName;
    
    private int WIDTH = 640;
    private int HEIGHT = 480;
    
    private ToolItem firstToolItem;
    private ToolItem previousToolItem;
    private ToolItem nextToolItem;
    private ToolItem lastToolItem;
    
    public ImageViewer(Shell parentShell, ImageEntry imageEntry, ImageNavigator imageNavigator) {
	super(parentShell);
	this.imageEntry = imageEntry;
	this.imageNavigator = imageNavigator;
	
	
	setShellStyle(SWT.DIALOG_TRIM /*| SWT.APPLICATION_MODAL*/ | getDefaultOrientation());
	//setBlockOnOpen(false);
	
    }

    protected void configureShell(Shell shell) {
        super.configureShell(shell);
    }
    
    protected Point getInitialSize() {
	Rectangle rect = getShell().getDisplay().getClientArea();
	WIDTH = rect.width - 200;
	HEIGHT = rect.height - 100;
	return new Point(WIDTH, HEIGHT);
    }

    protected Image getResourceImage(String path) {
	return SWTResourceManager.getImage(getClass(), path);
    }
    protected Composite createToolBar(Composite parent) {
	ToolBar toolBar = new ToolBar(parent, SWT.FLAT | SWT.WRAP);
	
	
	firstToolItem = createToolItem(toolBar, FIRST_ACTION, "/org/plazmaforge/framework/client/images/eclipse/page/first.gif", null);
	previousToolItem = createToolItem(toolBar, PREVIOUS_ACTION, "/org/plazmaforge/framework/client/images/eclipse/page/previous.gif", null);
	nextToolItem = createToolItem(toolBar, NEXT_ACTION, "/org/plazmaforge/framework/client/images/eclipse/page/next.gif", null);
	lastToolItem = createToolItem(toolBar, LAST_ACTION, "/org/plazmaforge/framework/client/images/eclipse/page/last.gif", null);
	
    	return toolBar;

    }
    
    protected ToolItem createToolItem(final ToolBar toolBar, final String id, final String imagePath, final String toolTip) {
	ToolItem toolItem = new ToolItem(toolBar, SWT.NONE);
    	toolItem.addSelectionListener(new SelectionAdapter() {
    		public void widgetSelected(SelectionEvent e) {
    		    doAction(id);
    		}
    	});
    	toolItem.setImage(getResourceImage(imagePath));
    	if (toolTip != null) {
    	    toolItem.setToolTipText(Messages.getString(toolTip));
    	}
    	return toolItem;
    }
    

    
    protected Control createDialogArea(Composite parent) {
	Composite parentComposite = (Composite) super.createDialogArea(parent);

	Composite toolBar = createToolBar(parentComposite);
	toolBar.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	
	canvas = new ImageCanvas(parentComposite, SWT.BORDER);
	canvas.setBackground(getShell().getDisplay().getSystemColor(SWT.COLOR_WHITE));
	canvas.setLayoutData(new GridData(GridData.FILL_BOTH));

	infoLabel = new Label(parentComposite, SWT.NONE);
	infoLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	
	updateImage();
	updateState();
	
	return parentComposite;

    }
    
    protected void updateInfoLabel() {
	infoLabel.setText(getImageText());
    }
    
    protected void updateToolBar() {
	
	if (isEmptyList()) {
	    firstToolItem.setEnabled(false);
	    previousToolItem.setEnabled(false);
	    nextToolItem.setEnabled(false);
	    lastToolItem.setEnabled(false);
	    return;
	}
	
	int currentIndex = indexOfImage(imageEntry);
	int firstIndex = getFirstIndex();
	int lastIndex = getLastIndex();
	
	if (currentIndex < 0) {
	    previousToolItem.setEnabled(false);
	    nextToolItem.setEnabled(false);
	} else {
	    previousToolItem.setEnabled(currentIndex > firstIndex);
	    nextToolItem.setEnabled(currentIndex < lastIndex);
	}
	
	firstToolItem.setEnabled(firstIndex != lastIndex);
	lastToolItem.setEnabled(firstIndex != lastIndex);
    }
    
    protected String getImageText() {
	
	int currentIndex = indexOfImage(imageEntry) + 1;
	int lastIndex = getLastIndex() + 1;
	String navigationText = "[" + currentIndex + ":" + lastIndex + "]"; 
	if (imageEntry == null) {
	    return navigationText;
	}
	String name = imageEntry.getName();
	if (name == null) {
	    return navigationText;
	}
	return navigationText + " " + name;
    }
   
    private void initImage(ImageEntry imageEntry) {
	if (imageNavigator == null) {
	    return;
	}
	imageNavigator.initImage(imageEntry);
    }
    
    private Image createImage(byte[] data) throws Exception {
	
	if (data == null) {
	    return null;
	}
	
	if (data.length <= 100000) {
	    // OutOfMemory !!!
	    ByteArrayInputStream bais = new ByteArrayInputStream(imageEntry.getBinaryData());
	    org.eclipse.swt.graphics.ImageData idata = new org.eclipse.swt.graphics.ImageData(bais);
	    return new Image(getShell().getDisplay(), idata);
	}
	
	// If image data are very big we have OutOfMemory error (Java heap space)
	// We use tmp file to store image data
	File tmpFile = File.createTempFile("tmp" + System.currentTimeMillis(), "");
	String fileName = tmpFile.getAbsolutePath();
	FileOutputStream fos = new FileOutputStream(fileName);
	fos.write(imageEntry.getBinaryData());
	fos.close();

	return new Image(getShell().getDisplay(), fileName);
    }

    protected void updateImage() {
	if (canvas == null) {
	    return;
	}
	
	initImage(imageEntry);
	Image image = null;
	String error = null;
	try {
	    image = imageEntry == null ? null : createImage(imageEntry.getBinaryData());
	} catch (Exception ex) {
	    error = ex.getMessage();
	    ex.printStackTrace();
	}
	canvas.setImage(image);
	canvas.setError(error);
    }
    
    
    
    protected void setImageEntry(ImageEntry imageEntry) {
	this.imageEntry = imageEntry;
	updateImage();
	updateState();
	canvas.redraw();
    }
    
    protected void doAction(String actionId) {
	
	int index = indexOfImage(imageEntry);
	if (index < 0) {
	    return;
	}
	
	
	int firstIndex = getFirstIndex();
	int lastIndex = getLastIndex();
	
	// No data
	if (firstIndex == -1 || lastIndex == -1) {
	    return;
	}
	
	if (FIRST_ACTION.equals(actionId)) {
	    setImageEntry(imageNavigator.getImages().get(firstIndex));
	} else if (PREVIOUS_ACTION.equals(actionId)) {
	    index--;
	    if (index < 0) {
		return;
	    }
	    setImageEntry(imageNavigator.getImages().get(index));
	} else if (NEXT_ACTION.equals(actionId)) {
	    index++;
	    if (index > lastIndex) {
		return;
	    }
	    setImageEntry(imageNavigator.getImages().get(index));
	    
	} else if (LAST_ACTION.equals(actionId)) {
	    setImageEntry(imageNavigator.getImages().get(lastIndex));
	}
    }
    
    protected int indexOfImage(ImageEntry imageEntry) {
	if (imageEntry == null || imageNavigator == null) {
	    return -1;
	}
	List<ImageEntry> list = imageNavigator.getImages();
	if (list == null || list.isEmpty()) {
	    return -1;
	}
	return list.indexOf(imageEntry);
    }

    protected boolean isEmptyList() {
	if (imageEntry == null || imageNavigator == null) {
	    return true;
	}
	List<ImageEntry> list = imageNavigator.getImages();
	if (list == null || list.isEmpty()) {
	    return true;
	}
	return false;
    }
    
    protected int getFirstIndex() {
	if (imageNavigator == null) {
	    return -1;
	}
	List<ImageEntry> list = imageNavigator.getImages();
	if (list == null || list.isEmpty()) {
	    return -1;
	}
	return 0;
    }
    
    protected int getLastIndex() {
	if (imageNavigator == null) {
	    return -1;
	}
	List<ImageEntry> list = imageNavigator.getImages();
	if (list == null || list.isEmpty()) {
	    return -1;
	}
	return list.size() - 1;
    }
    
    public static interface ImageNavigator {
	
	List<ImageEntry> getImages();
	
	void initImage(ImageEntry imageEntry);
	
    }

    public ImageEntry getImageEntry() {
        return imageEntry;
    }
    
    public void updateState() {
	updateInfoLabel();
	updateToolBar();
    }
    
}
