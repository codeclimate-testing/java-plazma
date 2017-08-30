package org.plazmaforge.framework.client.swt.views;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.Widget;
import org.plazmaforge.framework.client.swt.controls.XTableCursor;

public class TableViewHelper<T, C, R> {

    private ISWTTableView<T, C, R> view;
    
    private XTableCursor cursor;
    

    public TableViewHelper(ISWTTableView<T, C, R> view) {
	super();
	this.view = view;
    }
    
    private ISWTTableView<T, C, R> getView() {
	return view;
    }
    
    private T getTable() {
	return getView().getTable();
    }
    
    private boolean isValidTable(T Table) {
	T table = getTable();
	if (table == null) {
	    return false;
	}
	if ((table instanceof Table) || (table instanceof Tree)) {
	    return true;
	}
	return false;
    }
    
    
    public void initSetDataListener() {
	T t = getTable();
	if (!isValidTable(t)) {
	    return;
	}
	Widget table = (Widget) t;
   	table.addListener (SWT.SetData, new Listener () {
	      public void handleEvent (Event event) {
	          R row = (R) event.item;
	          Object entity = getView().getEntityByRow(row);
	          getView().mapRow(row, entity);
	      }
	 }); 	
    }
    
    
    /**
     * Initialize Table <code>PaintListener<code>
     *
     */
    protected void initPaintListener() {
	
	T t = getTable();
	if (!isValidTable(t)) {
	    return;
	}
	if (!(t instanceof Table)) {
	    return;
	}
	
	final Table table = (Table) t;

 	table.addPaintListener(new PaintListener() {
    	    
    	    public void paintControl(PaintEvent e) {
    		
    		if (getView().isEmptyCellRenderers()) {
    		    return;
    		}
    		
    		int startIndex = -1;
    		int endIndex = -1;
    		
    		startIndex = 0;
    		endIndex = table.getItemCount() - 1;

    		for (int i = startIndex; i <= endIndex; i++) {
    		    TableItem item = table.getItem(i);
    		    repaintTableItem(i, item, e);
    		}
    		
    	    }
    	});

    }
  
    /**
     * Initialize Table item listeners:
     * 
     * SWT.EraseItem
     * SWT.MeasureItem 
     * SWT.PaintItem
     *
     */
    protected void initRowListeners() {
	T t = getTable();
	if (!isValidTable(t)) {
	    return;
	}
	Widget table = (Widget) t;
	
	// Bag: EraseItem, MeasureItem, PaintItem clear background in sort column mode 
	
	// ERASE ITEM
	table.addListener(SWT.EraseItem, new Listener() {
	    public void handleEvent(Event event) {
	    
		int columnIndex = event.index;
		ITableCellRenderer r = getView().getCellRenderer(columnIndex);
		if (r == null) {
		    return;
		}
		r.eraseCell(event);
	    }
	});
	

	// MEASURE ITEM
	table.addListener(SWT.MeasureItem, new Listener() {
	    public void handleEvent(Event event) {

		int columnIndex = event.index;
		ITableCellRenderer r = getView().getCellRenderer(columnIndex);
		if (r == null) {
		    return;
		}
		r.measureCell(event);

	    }
	});
	

	// PAINT ITEM
	table.addListener(SWT.PaintItem, new Listener() {
	    public void handleEvent(Event event) {

		if (event.item == null) {
		    return;
		}
		int columnIndex = event.index;
		ITableCellRenderer r = getView().getCellRenderer(columnIndex);
		if (r == null) {
		    return;
		}
		r.paintCell(event);

	    }
	});

	
    }
    
    
    

    
    
    
    /**
     * Repaint <code>TableItem</code>
     * @param index
     * @param item
     * @param e
     */
    protected void repaintTableItem(int index, TableItem item, PaintEvent e) {
	if (item == null) {
	    return;
	}
	List<ITableCellRenderer> renderers = getView().getCellRenderers();
	for (ITableCellRenderer r : renderers) {
	    
	    Event event = new Event();
	    event.gc = e.gc;
	    
	    // Cell rectangle
	    Rectangle cellRec = item.getBounds(r.getColumnIndex());
	    
	    // Create cell event
	    event.x = cellRec.x;
	    event.y = cellRec.y;
	    event.width = cellRec.width;
	    event.height = cellRec.height;
	    
	    event.count = e.count;
	    event.item = item;
	    event.index = r.getColumnIndex();

	    r.paintCell(event);
	}
	
    }
    
    
    public void addCursorSelectionListener(SelectionListener listener) {
	if (cursor == null) {
	    return;
	}
	cursor.addSelectionListener(listener);
    }
    
    public void addCursorKeyListener(KeyListener listener) {
	if (cursor == null) {
	    return;
	}
	cursor.addKeyListener(listener);
    }
    
    public void addCursorMouseListener(MouseListener listener) {
	if (cursor == null) {
	    return;
	}
	cursor.addMouseListener(listener);
	
    }
    
    protected void initCursor() {
	
	T t = getTable();
	if (!(t instanceof Table)) {
	    return;
	}
	final Table table = (Table) getTable();
	if (table == null) {
	    return;
	}
	
        final XTableCursor cursor = new XTableCursor(table, SWT.NONE);
        this.cursor = cursor;
        cursor.setBackground(table.getDisplay().getSystemColor(SWT.COLOR_LIST_SELECTION));
        cursor.setForeground(table.getDisplay().getSystemColor(SWT.COLOR_LIST_SELECTION_TEXT));
        cursor.setLayout(new FillLayout());
        cursor.setVisible(false);
        
        cursor.addSelectionListener(new SelectionAdapter() {
            // when the TableEditor is over a cell, select the corresponding row in 
            // the table
            public void widgetSelected(SelectionEvent e) {
                
                table.setSelection(new TableItem[] {cursor.getRow()});
                cursor.setVisible(true);
                
            }
        });

        // Bad code: problem with table.setItemCount(...);
        /*
        cursor.addControlListener(new ControlAdapter() {
            public void controlResized(ControlEvent e) {
                if (cursor != null) {
                    if (cursor.getRow() == null) {
                        cursor.setVisible(false);
                    } else {
                        cursor.layout();
                        cursor.redraw();
                        cursor.setVisible(true);
                    }
                }
            }
        });
        */

        table.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                Table t = (Table) e.widget;
                if (t.getItemCount() != 0) {
                    cursor.setVisible(true);
                }
            }           
        });

        /*
        table.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
        	TableItem row = cursor.getRow();
        	int column = cursor.getColumn();
        	if (row != null && column >= 0) {
        	    return;
        	}
        	if (table.getItemCount() == 0) {
        	    return;
        	}
        	if (table.getColumnCount() == 0) {
        	    return;
        	}
        	cursor.notifyListeners(SWT.MouseDown, null);
        	return;

        
            }
        });
        */

    
    }
    
    protected void setCursorMenu(Menu menu) {
	if (menu == null || cursor == null) {
	    return;
	}
	cursor.setMenu(menu);
    }
    
}
