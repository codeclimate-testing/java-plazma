package org.plazmaforge.bs.base.client.forms;

import org.plazmaforge.framework.uwt.form.ListForm;
import org.plazmaforge.framework.uwt.layout.FitLayout;
import org.plazmaforge.framework.uwt.widget.Composite;
import org.plazmaforge.framework.uwt.widget.Viewer;
import org.plazmaforge.framework.uwt.widget.table.Table;
import org.plazmaforge.framework.uwt.widget.table.TableColumn;

public class UnitListForm extends ListForm {

    private Table table;

    @Override
    protected void configure() {
	super.configure();
	setLazyLoad(false);
    }

    protected void buildContent(Composite content) {
	setTitle("Units");
	content.setLayout(new FitLayout());

	table = new Table();
	//table.setSelectionMode(SelectionMode.CELL);
	TableColumn column = new TableColumn();
	column.setText("Code");
	column.setProperty("code");
	column.setWidth(200);
	column.setDataType("String");
	table.addColumn(column);

	column = new TableColumn();
	column.setText("Name");
	column.setProperty("name");
	column.setWidth(300);
	column.setDataType("String");
	//column.setCellEditor(new DefaultCellEditor()); !!!
	table.addColumn(column);

	content.add(table);
    }

    @Override
    public Viewer getViewer() {
	return table;
    }
}
