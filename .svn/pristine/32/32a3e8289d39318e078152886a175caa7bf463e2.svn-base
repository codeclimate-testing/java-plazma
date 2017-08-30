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

package org.plazmaforge.framework.client.swt.dialogs;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.framework.client.swt.dialogs.ImageViewer.ImageNavigator;
import org.plazmaforge.framework.ext.model.ImageEntry;
import org.plazmaforge.framework.ext.model.ImageStorage;
import org.plazmaforge.framework.ext.model.ImageStorageImpl;

public class ImageTablePanel extends Composite {

    private TableViewer viewer;
    
    private ImageStorage imageStorage;
    
    
    
    
    
    public ImageTablePanel(Composite parent, String title) {
	
	super(parent, SWT.NONE);
	
	setLayout(new FillLayout());
	
	Group group = new Group(this, SWT.NONE);
	if (title != null) {
	   group.setText(title);
	}
	
	
	GridLayout layout = new GridLayout();
	layout.numColumns = 2;
	
	group.setLayout(layout);
	
	createImageTable(group);
	createToolPanel(group);
    }
    
    
    protected Composite createImageTable(Composite parent) {

	viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.FULL_SELECTION);
	viewer.setContentProvider(new ViewContentProvider());
	viewer.setLabelProvider(new ViewLabelProvider());
	
	
	//viewer.setColumnProperties(new String[] {"name", "size"});
	

	Table table = viewer.getTable();
	
	TableColumn column = new TableColumn(table, SWT.NONE);
	column.setText(Messages.getString("ImageTablePanel.name.column"));
	column.setWidth(300);

	column = new TableColumn(table, SWT.RIGHT);
	column.setText(Messages.getString("ImageTablePanel.size.column"));
	column.setWidth(100);

	table.setHeaderVisible(true);
	table.setLinesVisible(true);
	
	GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
	table.setLayoutData(gridData);
	
	
	//viewer.setInput(getImageStorage());
	table.addMouseListener(new MouseAdapter()  {
	    public void mouseDoubleClick(MouseEvent e) {
		doPreviewAction();
	    }
	});
	
	return table;
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
	
	button = new Button(panel, SWT.NONE);
	button.setText(Messages.getString("ImageTablePanel.preview.button"));
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	button.setLayoutData(gridData);
	
	button.addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		doPreviewAction();
	    }
	});
	
	button = new Button(panel, SWT.NONE);
	button.setText(Messages.getString("ImageTablePanel.edit.button"));
	gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
	button.setLayoutData(gridData);
	
	button.addSelectionListener(new SelectionAdapter() {
	    public void widgetSelected(SelectionEvent e) {
		doEditAction();
	    }
	});

	
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
	    
	    String fileName = filedialog.open();
	    if (fileName == null) {
		return;
	    }
	    File imageFile = new File(fileName);
	    if (!imageFile.exists()) {
		openError("File " + fileName + " not found");
		return;
	    }
	    
	    FileInputStream fis = new FileInputStream(imageFile);
	    byte[] data = getBytes(fis);

	    ImageEntry imageEntry = getImageStorage().createImage();
	    imageEntry.setBinaryData(data);
	    
	    getImageStorage().addImage(imageEntry);
	    refreshTableViewer();
	    
	} catch (Throwable ex) {
	    openError(ex.getMessage() == null ? ex.toString() : ex.getMessage());
	}

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
    
    protected void doPreviewAction() {
	try {
	    ImageEntry imageEntry = getSelectedImageEntry();
	    if (imageEntry == null) {
		return;
	    }
	    
	    
	    // FORCE LOAD IMAGE DATA FROM DB
	    doInitImage(imageEntry);
	    
	    
	    ImageViewer imageViewer = findImageViewerByData(imageEntry);
	    if (imageViewer != null) {
		imageViewer.getShell().setActive();
		return;
	    }
	    
	    imageViewer = new ImageViewer(getShell(), imageEntry, new ImageNavigatorImpl());
	    imageViewers.add(imageViewer);
	    imageViewer.open();
	} catch (Throwable ex) {
	    openError(ex.getMessage() == null ? ex.toString() : ex.getMessage());
	}
    }

    
    private List<ImageViewer> imageViewers = new ArrayList<ImageViewer>();
    
    protected void doInitImage(ImageEntry imageEntry) {
	if (imageEntry == null || imageEntry.isLoadData()) {
	    return;
	}
	getImageStorage().loadImageData(imageEntry);
    }
    
    protected void doEditAction() {
	ImageEntry imageEntry = getSelectedImageEntry();
	if (imageEntry == null) {
	    return;
	}

	ImageDialog dialog = new ImageDialog(getShell(), imageEntry);
	if (ImageDialog.OK == dialog.open()) {
	    refreshTableViewer();
	}
    }

    protected void refreshTableViewer() {
	viewer.refresh();
	
	for (ImageViewer imageViewer : imageViewers) {
	    if (!isOpenedViwer(imageViewer)) {
		continue;
	    }
	    imageViewer.updateState();
	}
    }
    
    protected boolean isOpenedViwer(ImageViewer viewer) {
	if (viewer == null) {
	    return false;
	}
	Shell shell = viewer.getShell();
	if (shell == null || shell.isDisposed()) {
	    return false;
	}
	return true;
    }
    
    protected ImageViewer findImageViewerByData(ImageEntry imageEntry) {
	if (imageEntry == null || imageViewers == null) {
	    return null;
	}
	
	for (ImageViewer imageViewer : imageViewers) {
	    if (!isOpenedViwer(imageViewer)) {
		continue;
	    }

	    ImageEntry ie = imageViewer.getImageEntry();
	    if (ie == null) {
		continue;
	    }
	    if (ie == imageEntry) {
		return imageViewer;
	    }
	}
	return null;
    }
    
    
    protected void doRemoveAction() {

	ImageEntry imageEntry = getSelectedImageEntry();
	if (imageEntry == null) {
	    return;
	}

	if (!MessageDialog.openConfirm(getShell(), "Confirm", Messages.getString("ImageTablePanel.confirmRemoveImage.message"))) {
	    return;
	}
	
	getImageStorage().removeImage(imageEntry);
	refreshTableViewer();

	
	// Close dialog with removed image entry
	ImageViewer imageViewer = findImageViewerByData(imageEntry);
	if (imageViewer != null) {
	    imageViewer.close();
	}
	
    }
    
    private List<ImageEntry> images;

    class ViewContentProvider implements IStructuredContentProvider {
	
	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
	}

	public void dispose() {
	}

	public Object[] getElements(Object input) {
	    images = getImageStorage().getImages(); 
	    return images.toArray();
	}
    }

    class ViewLabelProvider extends LabelProvider implements ITableLabelProvider {
	
	public boolean isLabelProperty(Object element, String property) {

	        return true;
	    }
	
	public String getColumnText(Object obj, int index) {

	    ImageEntry imageEntry = (ImageEntry) obj;
	    if (imageEntry == null) {
		return "";
	    }
	    
	    if (index == 0) {
		//return getText(obj);
		return getNotNullText(imageEntry.getName());
	    } else if (index == 1) {
		return imageEntry.getSizeString();
	    }
	    return "";
	}
	
	private String getNotNullText(String text) {
	    return text == null ? "" : text;
	}

	public Image getColumnImage(Object obj, int index) {
	    return getImage(obj);
	}

	public Image getImage(Object obj) {
	    return null;
	}
    }

    public ImageStorage getImageStorage() {
	if (imageStorage == null) {
	    imageStorage = new ImageStorageImpl();
	}
        return imageStorage;
    }


    public void setImageStorage(ImageStorage imageStorage) {
        this.imageStorage = imageStorage;
        viewer.setInput(getImageStorage());
    }
    
    
    protected ImageEntry getSelectedImageEntry() {
	ISelection selection = viewer.getSelection();
	if (selection == null) {
	    return null;
	}
	Object obj =((IStructuredSelection) selection).getFirstElement();
	return (ImageEntry) obj;
    }
    
    
    class ImageNavigatorImpl implements ImageNavigator {
	
	public List<ImageEntry> getImages() {
	    return images;
	}
	
	public void initImage(ImageEntry imageEntry) {
	    doInitImage(imageEntry);
	}
    }

}
