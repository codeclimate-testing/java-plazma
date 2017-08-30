package org.plazmaforge.bsolution.carservice.client.swt.forms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.forms.AbstractListForm;
import org.plazmaforge.framework.client.swt.views.ImageTableCellRenderer;

public class CarPaintListForm extends AbstractListForm {

    //private Tree tree;
    
    private Table table;
    

    
    public CarPaintListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("CarPaintListForm.title")); //$NON-NLS-1$
        TableColumn tableColumn;
        
        TableColumn codeColumn;
        TableColumn nameColumn;
        //TableColumn goodsTypeColumn;
        TableColumn unitColumn;
        TableColumn currencyColumn;
        TableColumn currencyCostPriceColumn;
        TableColumn currencyListPriceColumn;
        
        TableColumn typeColumn;
        TableColumn markColumn;
        TableColumn consumableColumn;

        setLayout(new FillLayout());
 
        //SashForm sashForm = new SashForm(this, SWT.NONE);
	
	// Create Group Tree 
        //tree = new Tree(sashForm, SWT.BORDER);


    	table = new Table(this/*sashForm*/, SWTToolkit.TABLE_STYLE);
    	table.setLinesVisible(true);
    	table.setHeaderVisible(true);

    	tableColumn = new TableColumn(table, SWT.NONE);
    	tableColumn.setResizable(false);
    	tableColumn.setWidth(20);

    	codeColumn = new TableColumn(table, SWT.NONE);
    	codeColumn.setWidth(100);
    	codeColumn.setText(Messages.getString("CarPaintListForm.codeColumn.text")); //$NON-NLS-1$

    	nameColumn = new TableColumn(table, SWT.NONE);
    	nameColumn.setWidth(300);
    	nameColumn.setText(Messages.getString("CarPaintListForm.nameColumn.text")); //$NON-NLS-1$
    	
    	//goodsTypeColumn = new TableColumn(table, SWT.NONE);
    	//goodsTypeColumn.setWidth(100);
    	//goodsTypeColumn.setText(Messages.getString("CarPaintListForm.goodsTypeColumn.text")); //$NON-NLS-1$
    	
    	unitColumn = new TableColumn(table, SWT.CENTER);
    	unitColumn.setWidth(100);
    	unitColumn.setText(Messages.getString("CarPaintListForm.unitColumn.text")); //$NON-NLS-1$
    	
    	currencyColumn = new TableColumn(table, SWT.CENTER);
    	currencyColumn.setWidth(100);
    	currencyColumn.setText(Messages.getString("CarPaintListForm.currencyColumn.text")); //$NON-NLS-1$
    	
    	currencyCostPriceColumn = new TableColumn(table, SWT.RIGHT);
    	currencyCostPriceColumn.setWidth(100);
    	currencyCostPriceColumn.setText(Messages.getString("CarPaintListForm.currencyCostPriceColumn.text")); //$NON-NLS-1$

    	currencyListPriceColumn = new TableColumn(table, SWT.RIGHT);
    	currencyListPriceColumn.setWidth(100);
    	currencyListPriceColumn.setText(Messages.getString("CarPaintListForm.currencyListPriceColumn.text")); //$NON-NLS-1$
    	
    	typeColumn = new TableColumn(table, SWT.NONE);
    	typeColumn.setWidth(150);
    	typeColumn.setText(Messages.getString("CarPaintListForm.typeColumn.text")); //$NON-NLS-1$
    	
    	markColumn = new TableColumn(table, SWT.NONE);
    	markColumn.setWidth(150);
    	markColumn.setText(Messages.getString("CarPaintListForm.markColumn.text")); //$NON-NLS-1$
    	
    	consumableColumn = new TableColumn(table, SWT.CENTER);
    	consumableColumn.setWidth(70);
    	consumableColumn.setText(Messages.getString("CarPaintListForm.consumableColumn.text")); //$NON-NLS-1$
    	
    	//sashForm.setWeights(new int[] {1, 5 });
    	
        this.setSize(new Point(600, 300));
        
        
        
        
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "code");	
	bindColumn(2, "name");
	//bindColumn("goodsTypeName");
	bindColumn(3, "unitName");
	bindColumn(4, "currencyName");
	bindColumn(5, "currencyCostPrice", getCurrencyFormat());
	bindColumn(6, "currencyListPrice", getCurrencyFormat());

	
	bindColumn(7, "carPaintTypeName");
	bindColumn(8, "carPaintMarkName");
	bindColumn(9, "consumable");
	
	addCellRenderer(9, new ImageTableCellRenderer());
    }
 
    ////
    
    /*
    protected Tree getTree() {
	return tree;
    }
    
    protected Class getTreeServiceClass() {
	return ProductGroupService.class;
    }
    
    protected String getTreeItemRefIdProperty() {
	return "productGroupId";
    }
    
    protected String getTreeItemParentIdProperty() {
	return "parentId";
    }
    */

    ////
    
   

 
}  //  @jve:decl-index=0:visual-constraint="10,10"
