package org.plazmaforge.bsolution.carservice.client.swt.forms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.plazmaforge.framework.client.swt.SWTToolkit;
import org.plazmaforge.framework.client.swt.forms.AbstractListForm;

public class CarDetailListForm extends AbstractListForm {

    //private Tree tree;
    
    private Table table;
    

    
    public CarDetailListForm(Composite parent, int style) {
	super(parent, style);
	initialize();
    }
    
    
    private void initialize() {
	setTitle(Messages.getString("CarDetailListForm.title")); //$NON-NLS-1$
        TableColumn tableColumn;
        
        TableColumn codeColumn;
        TableColumn nameColumn;
        //TableColumn goodsTypeColumn;
        TableColumn unitColumn;
        TableColumn currencyColumn;
        TableColumn currencyCostPriceColumn;
        TableColumn currencyListPriceColumn;
        
        // oha:disable: customer requirement
        //TableColumn carMarkColumn;
        //TableColumn carModelColumn;

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
    	codeColumn.setText(Messages.getString("CarDetailListForm.codeColumn.text")); //$NON-NLS-1$

    	nameColumn = new TableColumn(table, SWT.NONE);
    	nameColumn.setWidth(300);
    	nameColumn.setText(Messages.getString("CarDetailListForm.nameColumn.text")); //$NON-NLS-1$
    	
    	//goodsTypeColumn = new TableColumn(table, SWT.NONE);
    	//goodsTypeColumn.setWidth(100);
    	//goodsTypeColumn.setText(Messages.getString("CarDetailListForm.goodsTypeColumn.text")); //$NON-NLS-1$
    	
    	unitColumn = new TableColumn(table, SWT.CENTER);
    	unitColumn.setWidth(100);
    	unitColumn.setText(Messages.getString("CarDetailListForm.unitColumn.text")); //$NON-NLS-1$
    	
    	currencyColumn = new TableColumn(table, SWT.CENTER);
    	currencyColumn.setWidth(100);
    	currencyColumn.setText(Messages.getString("CarDetailListForm.currencyColumn.text")); //$NON-NLS-1$
    	
    	currencyCostPriceColumn = new TableColumn(table, SWT.RIGHT);
    	currencyCostPriceColumn.setWidth(100);
    	currencyCostPriceColumn.setText(Messages.getString("CarDetailListForm.currencyCostPriceColumn.text")); //$NON-NLS-1$

    	
    	currencyListPriceColumn = new TableColumn(table, SWT.RIGHT);
    	currencyListPriceColumn.setWidth(100);
    	currencyListPriceColumn.setText(Messages.getString("CarDetailListForm.currencyListPriceColumn.text")); //$NON-NLS-1$

        // oha:disable: customer requirement
    	//carMarkColumn = new TableColumn(table, SWT.NONE);
    	//carMarkColumn.setWidth(150);
    	//carMarkColumn.setText(Messages.getString("CarDetailListForm.carMarkColumn.text")); //$NON-NLS-1$
    	
    	//carModelColumn = new TableColumn(table, SWT.NONE);
    	//carModelColumn.setWidth(150);
    	//carModelColumn.setText(Messages.getString("CarDetailListForm.carModelColumn.text")); //$NON-NLS-1$
    	
    	
    	//sashForm.setWeights(new int[] {1, 5 });
    	
        this.setSize(new Point(600, 300));
        
        
        
        
    }
    
    public Table getTable() {
	return table;
    }
    
    protected void bindTable() {
	bindColumn(1, "code");	
	bindColumn("name");
	//bindColumn("goodsTypeName");
	bindColumn("unitName");
	bindColumn("currencyName");
	
	bindColumn("currencyCostPrice", getCurrencyFormat());
	bindColumn("currencyListPrice", getCurrencyFormat());
	
        // oha:disable: customer requirement
	//bindColumn("carMarkName");
	//bindColumn("carModelName");
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
    
   

 


}
