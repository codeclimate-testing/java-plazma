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
 * Created on 14.07.2007
 *
 */

package org.plazmaforge.bsolution.base.client.swt.dialogs;


import java.text.Collator;


import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ColumnWeightData;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.bsolution.base.EnterpriseConstants;
import org.plazmaforge.framework.app.AppEnvironment;
import org.plazmaforge.framework.client.swt.SWTResourceManager;

/** 
 * @author Oleh Hapon
 * $Id: AboutDialog.java,v 1.3 2010/04/28 06:31:03 ohapon Exp $
 */

public class AboutDialog extends Dialog implements EnterpriseConstants {

    private Image logoImage;
    
    public AboutDialog(Shell parentShell) {
	super(parentShell);
	logoImage =  SWTResourceManager.getImage(getClass(), "/org/plazmaforge/framework/client/images/about.jpg");
    }

    protected void configureShell(Shell newShell) {
	super.configureShell(newShell);
	newShell.setText(Messages.getString("AboutDialog.null.title")); //$NON-NLS-1$
    }

    
    protected Point getInitialSize() {
        //return new Point(455, 340);
	int width = 400;
	int height = 400;
	if (logoImage != null) {
	    width = logoImage.getImageData().width + (30 * 2) - 10;
	    height = logoImage.getImageData().height + (30 * 2) + 15 + 120;
	}
        return new Point(width, height);
    }

    protected void createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
    }

    protected void setShellStyle(int newShellStyle) {
        super.setShellStyle(newShellStyle );// | SWT.RESIZE
    }

    
    protected Control createDialogArea(Composite parent) {
        // top level composite
        Composite parentComposite = (Composite) super.createDialogArea(parent);

        parentComposite.setLayout(new FillLayout());

        TabFolder tabFolder = new TabFolder(parentComposite, SWT.NULL);

        TabItem tabItem1 = new TabItem(tabFolder, SWT.NULL);
        tabItem1.setText(Messages.getString("AboutDialog.tabItem1.text")); //$NON-NLS-1$
        tabItem1.setToolTipText(Messages.getString("AboutDialog.tabItem1.toolTipText")); //$NON-NLS-1$

        //TabItem tabItem2 = new TabItem(tabFolder, SWT.NULL);
        //tabItem2.setText("Credits");
        //tabItem2.setToolTipText("CreditsToolTip");

        //TabItem tabItem3 = new TabItem(tabFolder, SWT.NULL);
        //tabItem3.setText("License");
        //tabItem3.setToolTipText("LicenseToolTip");
        
        TabItem tabItem4 = new TabItem(tabFolder, SWT.NULL);
        tabItem4.setText(Messages.getString("AboutDialog.tabItem4.text")); //$NON-NLS-1$
        tabItem4.setToolTipText(Messages.getString("AboutDialog.tabItem4.toolTipText")); //$NON-NLS-1$

        new AboutItem(tabItem1, tabFolder);
        //new CreditsItem(tabItem2, tabFolder);
        //new LicenseItem(tabItem3, tabFolder);        
        new SystemProperties(tabItem4, tabFolder);
        
        parentComposite.pack();
        return parentComposite;
    }

    
    
    class AboutItem {

	    

	    AboutItem(TabItem item, Composite parent) {

	        
	        

	        /*
	        parent.addDisposeListener(new DisposeListener() {

	            public void widgetDisposed(DisposeEvent event) {
	                ImageUtil.disposeImage("Images.Logo");
	            }
	        });
	        */
	        
	        
	        Composite cmp = new Composite(parent, SWT.NULL);
	        item.setControl(cmp);
	        GridLayout lay = new GridLayout();
	        lay.numColumns = 1;
	        lay.marginWidth = 15;
	        lay.marginHeight = 15;
	        cmp.setLayout(lay);

	        Label versionLabel = new Label(cmp, SWT.CENTER);
	        versionLabel.setFont(SWTResourceManager.getBoldFont(versionLabel.getFont()));
	        versionLabel.setText(APP_NAME + " " + VERSION + (AppEnvironment.isDemo() ? " Demo" : ""));

	        GridData data = new GridData(SWT.CENTER, SWT.CENTER, true, true);
	        versionLabel.setLayoutData(data);

	        ImageData imgData = logoImage.getImageData();
	        int width = imgData.width;
	        int height = imgData.height;

	        final Label imgComposite = new Label(cmp, SWT.BORDER);
	        data = new GridData(GridData.VERTICAL_ALIGN_CENTER | GridData.CENTER);
	        imgComposite.setLayoutData(data);
	        data.heightHint = height;
	        data.widthHint = width;

	   
	        //final Color imageBackgroundColor = new Color(parent.getDisplay(), 255, 255, 255);
	        final Color fontColor = new Color(parent.getDisplay(), 102, 118, 145);
	        
	        imgComposite.setImage(logoImage);
	        
	        /*
	        imgComposite.addPaintListener(new PaintListener() {

	            public void paintControl(PaintEvent event) {
	                GC gc = event.gc;
	                //gc.drawImage(logoImage, 0, 0);
	                gc.setBackground(imageBackgroundColor);
	                gc.setForeground(fontColor);
	                gc.drawText(version, 290, 75);
	            }
	        });
	        */
	        
	        Label copyrightLabel = new Label(cmp, SWT.CENTER);

	        copyrightLabel.setText(COPYRIGHT);

	        data = new GridData(SWT.CENTER, SWT.CENTER, true, true);
	        copyrightLabel.setLayoutData(data);


	        Link link = new Link(cmp, SWT.CENTER);
	        link.setText("http://plazma.sourceforge.net");
	        //data = new GridData(SWT.FILL);
	        data = new GridData(SWT.CENTER, SWT.CENTER, true, true);
	        
	        
	        link.setLayoutData(data);
	        link.setForeground(fontColor);
	        link.addListener (SWT.Selection, new Listener () {
	            public void handleEvent(Event event) {

	                try {
	                    //IWebBrowser browser = WorkbenchBrowserSupport.getInstance().getExternalBrowser();
	                    //browser.openURL(new URL(event.text));
	                } catch (Exception e) {
	                    //SQLExplorerPlugin.error("Error launching browser", e); //$NON-NLS-1$
	                }
	            }
	        });
	    }
	}

    
    
   
    class SystemProperties {

	    private class LProvider extends LabelProvider implements ITableLabelProvider {

		
		public Image getColumnImage(Object arg0, int arg1) {
	            return null;
	        }

	        public String getColumnText(Object element, int columnIndex) {
	            java.util.Map.Entry cp = (java.util.Map.Entry) element;
	            if (columnIndex == 0)
	                return cp.getKey().toString();
	            else
	                return cp.getValue().toString();
	        }
	    }
	    
	    

	    java.util.Properties props;

	    SystemProperties(TabItem itemTab, Composite parent) {
	        props = System.getProperties();

	        TableViewer tv = new TableViewer(parent, SWT.NULL);
	        tv.setSorter(new MyViewerSorter());
	        Table table = tv.getTable();
	        TableColumn c1 = new TableColumn(table, SWT.NULL);
	        c1.setText(Messages.getString("AboutDialog.propertyName")); //$NON-NLS-1$
	        TableColumn c2 = new TableColumn(table, SWT.NULL);
	        c2.setText(Messages.getString("AboutDialog.propertyValue")); //$NON-NLS-1$
	        //c2.sets
	        table.setLinesVisible(true);
	        table.setHeaderVisible(true);

	        TableLayout tableLayout = new TableLayout();
	        tableLayout.addColumnData(new ColumnWeightData(1, 50, true));
	        tableLayout.addColumnData(new ColumnWeightData(1, 100, true));
	        
	        table.setLayout(tableLayout);

	        itemTab.setControl(tv.getControl());
	        tv.setContentProvider(new IStructuredContentProvider() {

	            public Object[] getElements(Object input) {
	                return props.entrySet().toArray();
	            }

	            public void dispose() {
	            }

	            public void inputChanged(Viewer viewer, Object arg1, Object arg2) {
	            }
	        });
	        
	        tv.setLabelProvider(new LProvider());
	        tv.setInput(this);
	        
	        //ProgressBar bar = new ProgressBar(table, SWT.NONE);
	        //bar.setSelection(10);
	        
	        //Label label = new Label(table, SWT.CENTER);
	        //label.setImage(image);
	        //TableEditor editor = new TableEditor(table);
	        //editor.grabHorizontal = editor.grabVertical = true;
	        //editor.setEditor(label, table.getItem(0), 1);
	        

	    }

	}

	class MyViewerSorter extends ViewerSorter {

	    public MyViewerSorter() {
	        super();
	    }

	    public MyViewerSorter(Collator collator) {
	        super(collator);
	    }

	    public boolean isSorterProperty(Object element, String propertyId) {
	        return true;
	    }
	}
    
}
