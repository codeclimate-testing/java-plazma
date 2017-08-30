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

package org.plazmaforge.framework.report.engine.jfreereport;

import org.jfree.report.*;
import org.jfree.report.modules.gui.base.PreviewDialog;
import org.jfree.report.function.*;
import org.jfree.report.elementfactory.*;
import org.jfree.report.style.ElementStyleSheet;
import org.jfree.report.style.FontDefinition;
import org.jfree.report.style.BandStyleSheet;
import org.jfree.ui.FloatDimension;

import javax.swing.table.TableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.AbstractTableModel;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;
import java.awt.*;

/**
 * @author Oleh Hapon Date: 05.03.2004 Time: 7:36:48 $Id: TableSampleReport.java,v 1.2 2010/04/28 06:34:40 ohapon Exp $
 */
public class TableSampleReport extends JFreeReport {

    public TableSampleReport(String title, TableModel tableModel,
	    TableColumnModel tableColumnModel) {
	this.title = title;
	setData(tableModel);
	this.tableColumnModel = tableColumnModel;

	setName("List Form Report");

	setReportFooter(createReportFooter());
	setReportHeader(createReportHeader());
	setPageFooter(createPageFooter());
	setPageHeader(createPageHeader());
	setGroups(createGroups());
	setItemBand(createItemBand());
	try {
	    setFunctions(createFunctions());
	    PageFunction f1 = new PageFunction("page_number");
	    addFunction(f1);
	} catch (Exception e) {
	    System.err.println(e);
	}

	// setPropertyMarked("report.page", true);
	setPropertyMarked("report.date", true);

    }

    private String title;

    private TableColumnModel tableColumnModel;

    public TableColumnModel getTableColumnModel() {
	return tableColumnModel;
    }

    private PageHeader createPageHeader() {
	final PageHeader header = new PageHeader();
	return header;
    }

    private PageFooter createPageFooter() {
	final PageFooter pageFooter = new PageFooter();

	pageFooter.getStyle().setStyleProperty(ElementStyleSheet.MINIMUMSIZE,
		new FloatDimension(0, 30));
	pageFooter.getBandDefaults().setFontDefinitionProperty(
		new FontDefinition("Dialog", 10));
	ShapeElement line = StaticShapeElementFactory.createLineShapeElement(
		null, Color.black, null, new Line2D.Float(0, 0, 1000, 0));
	pageFooter.addElement(line);

	final NumberFieldElementFactory factory = new NumberFieldElementFactory();
	factory.setName("Label 2");
	factory.setAbsolutePosition(new Point2D.Float(0, 1));
	factory.setMinimumSize(new FloatDimension(-100, 14));
	factory.setHorizontalAlignment(ElementAlignment.RIGHT);
	factory.setVerticalAlignment(ElementAlignment.TOP);
	// factory.setText("Some Text for the page footer");
	// factory.setText("page");
	// factory.setDynamicHeight(Boolean.TRUE);

	// factory.setFormatString("Page 0");
	factory.setFormatString("стр 0");
	factory.setFieldname("page_number");

	pageFooter.addElement(factory.createElement());

	return pageFooter;
    }

    private ReportFooter createReportFooter() {
	final ReportFooter footer = new ReportFooter();
	footer.getStyle().setStyleProperty(ElementStyleSheet.MINIMUMSIZE,
		new FloatDimension(0, 48));
	footer.getBandDefaults().setFontDefinitionProperty(
		new FontDefinition("Serif", 16, true, false, false, false));

	final LabelElementFactory factory = new LabelElementFactory();
	factory.setName("Label 2");
	factory.setAbsolutePosition(new Point2D.Float(0, 0));
	factory.setMinimumSize(new FloatDimension(-100, 24));
	factory.setHorizontalAlignment(ElementAlignment.CENTER);
	factory.setVerticalAlignment(ElementAlignment.MIDDLE);
	factory.setText("");
	footer.addElement(factory.createElement());

	return footer;
    }

    private ReportHeader createReportHeader() {
	final ReportHeader header = new ReportHeader();
	header.getStyle().setStyleProperty(ElementStyleSheet.MINIMUMSIZE,
		new FloatDimension(0, 48));
	header.getBandDefaults().setFontDefinitionProperty(
		new FontDefinition("Serif", 18, true, false, false, false));

	final LabelElementFactory factory = new LabelElementFactory();
	factory.setName("Label 1");
	factory.setAbsolutePosition(new Point2D.Float(0, 0));
	factory.setMinimumSize(new FloatDimension(-100, 24));
	factory.setHorizontalAlignment(ElementAlignment.CENTER);
	factory.setVerticalAlignment(ElementAlignment.MIDDLE);
	factory.setText(title == null ? "" : title);
	header.addElement(factory.createElement());
	return header;
    }

    private ItemBand createItemBand() {

	final ItemBand items = new ItemBand();

	items.getStyle().setStyleProperty(ElementStyleSheet.MINIMUMSIZE,
		new FloatDimension(0, 10));
	items.getBandDefaults().setFontDefinitionProperty(
		new FontDefinition("Monospaced", 10));

	items.addElement(StaticShapeElementFactory.createRectangleShapeElement(
		"background", Color.decode("#DFDFDF"), new BasicStroke(0),
		new Rectangle2D.Float(0, 0, -100, -100), false, true));
	items.addElement(StaticShapeElementFactory.createLineShapeElement(
		"top", Color.decode("#DFDFDF"), new BasicStroke(0.1f),
		new Line2D.Float(0, 0, 0, 0)));
	items.addElement(StaticShapeElementFactory.createLineShapeElement(
		"bottom", Color.decode("#DFDFDF"), new BasicStroke(0.1f),
		new Line2D.Float(0, 10, 0, 10)));

	int count = getData().getColumnCount();

	for (int i = 0; i < count; i++) {
	    Class klass = getData().getColumnClass(i);
	    if ((klass == Integer.class) || (klass == Double.class)
		    || (klass == Float.class) || (klass == Byte.class)) {

		NumberFieldElementFactory nfactory = new NumberFieldElementFactory();
		nfactory.setName("Field" + (i + 1));
		nfactory.setAbsolutePosition(new Point2D.Float(i * 100, 0));
		nfactory.setMinimumSize(new FloatDimension(100, 10));
		nfactory.setHorizontalAlignment(ElementAlignment.RIGHT);
		nfactory.setVerticalAlignment(ElementAlignment.MIDDLE);
		nfactory.setNullString("");
		nfactory.setFieldname(getData().getColumnName(i));
		// nfactory.setFormatString("#,##0");
		items.addElement(nfactory.createElement());

	    } else {
		TextFieldElementFactory factory = new TextFieldElementFactory();
		factory.setName("Field" + (i + 1));
		factory.setAbsolutePosition(new Point2D.Float(i * 100, 0));
		factory.setMinimumSize(new FloatDimension(176, 10));
		factory.setHorizontalAlignment(ElementAlignment.LEFT);
		factory.setVerticalAlignment(ElementAlignment.MIDDLE);
		factory.setNullString("");
		factory.setFieldname(getData().getColumnName(i));
		items.addElement(factory.createElement());
	    }

	}

	return items;
    }

    private ExpressionCollection createFunctions()
	    throws FunctionInitializeException {
	final ExpressionCollection functions = new ExpressionCollection();
	final ElementVisibilitySwitchFunction backgroundTrigger = new ElementVisibilitySwitchFunction();
	backgroundTrigger.setName("backgroundTrigger");
	backgroundTrigger.setProperty("element", "background");
	functions.add(backgroundTrigger);
	return functions;
    }

    private GroupList createGroups() {
	final GroupList list = new GroupList();
	list.add(createNullGroup());
	return list;
    }

    private Group createNullGroup() {
	final Group continentGroup = new Group();
	continentGroup.setName("Continent Group");
	final GroupHeader header = new GroupHeader();
	header.getStyle().setBooleanStyleProperty(BandStyleSheet.REPEAT_HEADER,
		true);

	header.getStyle().setStyleProperty(ElementStyleSheet.MINIMUMSIZE,
		new FloatDimension(0, 18));
	header.getBandDefaults()
		.setFontDefinitionProperty(
			new FontDefinition("Monospaced", 12, true, false,
				false, false));

	int count = getData().getColumnCount();

	for (int i = 0; i < count; i++) {
	    Class klass = getData().getColumnClass(i);
	    if ((klass == Integer.class) || (klass == Double.class)
		    || (klass == Float.class) || (klass == Byte.class)) {

		LabelElementFactory nfactory = new LabelElementFactory();
		nfactory.setName("Field" + (i + 1));
		nfactory.setAbsolutePosition(new Point2D.Float(i * 100, 0));
		nfactory.setMinimumSize(new FloatDimension(100, 16));
		nfactory.setHorizontalAlignment(ElementAlignment.LEFT);
		nfactory.setVerticalAlignment(ElementAlignment.MIDDLE);
		// nfactory.setNullString("");
		// nfactory.setFieldname(data.getColumnName(i));
		nfactory.setText(getData().getColumnName(i));
		// nfactory.setFormatString("#,##0");
		header.addElement(nfactory.createElement());

	    } else {
		LabelElementFactory factory = new LabelElementFactory();
		factory.setName("Field" + (i + 1));
		factory.setAbsolutePosition(new Point2D.Float(i * 100, 0));
		factory.setMinimumSize(new FloatDimension(176, 16));
		factory.setHorizontalAlignment(ElementAlignment.LEFT);
		factory.setVerticalAlignment(ElementAlignment.MIDDLE);
		factory.setText(getData().getColumnName(i));
		// factory.setNullString("");
		// factory.setFieldname(data.getColumnName(i));
		header.addElement(factory.createElement());
	    }

	}

	continentGroup.setHeader(header);
	return continentGroup;
    }

    /*
         * public JFreeReport createReport() throws FunctionInitializeException {
         * 
         * final JFreeReport report = new JFreeReport(); report.setName("Sample
         * Report 1");
         * 
         * report.setReportFooter(createReportFooter());
         * report.setReportHeader(createReportHeader());
         * report.setPageFooter(createPageFooter());
         * report.setPageHeader(createPageHeader());
         * report.setGroups(createGroups());
         * report.setItemBand(createItemBand());
         * report.setFunctions(createFunctions());
         * report.setPropertyMarked("report.date", true);
         * 
         * return report; }
         */

    public static void main(final String[] args) throws Exception {
	Boot.start();

	final JFreeReport report = new TableSampleReport("Report",
		new SampleData2(), null);
	// final JFreeReport report = new SampleReport1().createReport();

	// report.setData();

	final PreviewDialog dialog = new PreviewDialog(report);
	dialog.setModal(true);
	dialog.pack();
	dialog.setVisible(true);
    }

    private static class SampleData2 extends AbstractTableModel {

	private final Object[][] data;

	public SampleData2() {
	    data = new Object[71][4];
	    data[0] = new Object[] { "Morocco", "MA", "Africa",
		    new Integer(29114497) };
	    data[1] = new Object[] { "South Africa", "ZA", "Africa",
		    new Integer(40583573) };
	    data[2] = new Object[] { "China", "CN", "Asia",
		    new Integer(1254400000) };
	    data[3] = new Object[] { "Iran", "IR", "Asia",
		    new Integer(66000000) };
	    data[4] = new Object[] { "Iraq", "IQ", "Asia",
		    new Integer(19700000) };
	    data[5] = new Object[] { "Australia", "AU", "Australia",
		    new Integer(18751000) };
	    data[6] = new Object[] { "Austria", "AT", "Europe",
		    new Integer(8015000) };
	    data[7] = new Object[] { "Belgium", "BE", "Europe",
		    new Integer(10213752) };
	    data[8] = new Object[] { "Estonia", "EE", "Europe",
		    new Integer(1445580) };
	    data[9] = new Object[] { "Finland", "FI", "Europe",
		    new Integer(5171000) };
	    data[10] = new Object[] { "France", "FR", "Europe",
		    new Integer(60186184) };
	    data[11] = new Object[] { "Germany", "DE", "Europe",
		    new Integer(82037000) };
	    data[12] = new Object[] { "Hungary", "HU", "Europe",
		    new Integer(10044000) };
	    data[13] = new Object[] { "Italy", "IT", "Europe",
		    new Integer(57612615) };
	    data[14] = new Object[] { "Norway", "NO", "Europe",
		    new Integer(4445460) };
	    data[15] = new Object[] { "Poland", "PL", "Europe",
		    new Integer(38608929) };
	    data[16] = new Object[] { "Portugal", "PT", "Europe",
		    new Integer(9918040) };
	    data[17] = new Object[] { "Spain", "ES", "Europe",
		    new Integer(39669394) };
	    data[18] = new Object[] { "Sweden", "SE", "Europe",
		    new Integer(8854322) };
	    data[19] = new Object[] { "Switzerland", "CH", "Europe",
		    new Integer(7123500) };
	    data[20] = new Object[] { "Canada", "CA", "North America",
		    new Integer(30491300) };
	    data[21] = new Object[] { "United States of America", "US",
		    "North America", new Integer(273866000) };
	    data[22] = new Object[] { "Brazil", "BR", "South America",
		    new Integer(165715400) };

	    data[23] = new Object[] { "Morocco", "MA", "Africa",
		    new Integer(29114497) };
	    data[24] = new Object[] { "South Africa", "ZA", "Africa",
		    new Integer(40583573) };
	    data[25] = new Object[] { "China", "CN", "Asia",
		    new Integer(1254400000) };
	    data[26] = new Object[] { "Iran", "IR", "Asia",
		    new Integer(66000000) };
	    data[27] = new Object[] { "Iraq", "IQ", "Asia",
		    new Integer(19700000) };
	    data[28] = new Object[] { "Australia", "AU", "Australia",
		    new Integer(18751000) };
	    data[29] = new Object[] { "Australia", "AU", "Australia",
		    new Integer(18751000) };
	    data[30] = new Object[] { "Australia", "AU", "Australia",
		    new Integer(18751000) };

	    data[31] = new Object[] { "South Africa", "ZA", "Africa",
		    new Integer(40583573) };
	    data[32] = new Object[] { "China", "CN", "Asia",
		    new Integer(1254400000) };
	    data[33] = new Object[] { "Iran", "IR", "Asia",
		    new Integer(66000000) };
	    data[34] = new Object[] { "Iraq", "IQ", "Asia",
		    new Integer(19700000) };
	    data[35] = new Object[] { "Australia", "AU", "Australia",
		    new Integer(18751000) };
	    data[36] = new Object[] { "Austria", "AT", "Europe",
		    new Integer(8015000) };
	    data[37] = new Object[] { "Belgium", "BE", "Europe",
		    new Integer(10213752) };
	    data[38] = new Object[] { "Estonia", "EE", "Europe",
		    new Integer(1445580) };
	    data[39] = new Object[] { "Finland", "FI", "Europe",
		    new Integer(5171000) };
	    data[40] = new Object[] { "France", "FR", "Europe",
		    new Integer(60186184) };
	    data[41] = new Object[] { "Germany", "DE", "Europe",
		    new Integer(82037000) };
	    data[42] = new Object[] { "Hungary", "HU", "Europe",
		    new Integer(10044000) };
	    data[43] = new Object[] { "Italy", "IT", "Europe",
		    new Integer(57612615) };
	    data[44] = new Object[] { "Norway", "NO", "Europe",
		    new Integer(4445460) };
	    data[45] = new Object[] { "Poland", "PL", "Europe",
		    new Integer(38608929) };
	    data[46] = new Object[] { "Portugal", "PT", "Europe",
		    new Integer(9918040) };
	    data[47] = new Object[] { "Spain", "ES", "Europe",
		    new Integer(39669394) };
	    data[48] = new Object[] { "Sweden", "SE", "Europe",
		    new Integer(8854322) };
	    data[49] = new Object[] { "Switzerland", "CH", "Europe",
		    new Integer(7123500) };
	    data[50] = new Object[] { "Canada", "CA", "North America",
		    new Integer(30491300) };

	    data[51] = new Object[] { "Germany", "DE", "Europe",
		    new Integer(82037000) };
	    data[52] = new Object[] { "Hungary", "HU", "Europe",
		    new Integer(10044000) };
	    data[53] = new Object[] { "Italy", "IT", "Europe",
		    new Integer(57612615) };
	    data[54] = new Object[] { "Norway", "NO", "Europe",
		    new Integer(4445460) };
	    data[55] = new Object[] { "Poland", "PL", "Europe",
		    new Integer(38608929) };
	    data[56] = new Object[] { "Portugal", "PT", "Europe",
		    new Integer(9918040) };
	    data[57] = new Object[] { "Spain", "ES", "Europe",
		    new Integer(39669394) };
	    data[58] = new Object[] { "Sweden", "SE", "Europe",
		    new Integer(8854322) };
	    data[59] = new Object[] { "Switzerland", "CH", "Europe",
		    new Integer(7123500) };
	    data[60] = new Object[] { "Canada", "CA", "North America",
		    new Integer(30491300) };

	    data[61] = new Object[] { "Germany", "DE", "Europe",
		    new Integer(82037000) };
	    data[62] = new Object[] { "Hungary", "HU", "Europe",
		    new Integer(10044000) };
	    data[63] = new Object[] { "Italy", "IT", "Europe",
		    new Integer(57612615) };
	    data[64] = new Object[] { "Norway", "NO", "Europe",
		    new Integer(4445460) };
	    data[65] = new Object[] { "Poland", "PL", "Europe",
		    new Integer(38608929) };
	    data[66] = new Object[] { "Portugal", "PT", "Europe",
		    new Integer(9918040) };
	    data[67] = new Object[] { "Spain", "ES", "Europe",
		    new Integer(39669394) };
	    data[68] = new Object[] { "Sweden", "SE", "Europe",
		    new Integer(8854322) };
	    data[69] = new Object[] { "Switzerland", "CH", "Europe",
		    new Integer(7123500) };
	    data[70] = new Object[] { "Canada", "CA", "North America",
		    new Integer(30491300) };

	}

	public int getRowCount() {
	    return data.length;
	}

	public int getColumnCount() {
	    return 4;
	}

	public Class getColumnClass(final int column) {
	    if (column == 3) {
		return Integer.class;
	    } else {
		return String.class;
	    }
	}

	public String getColumnName(final int column) {
	    if (column == 0) {
		return "Country";
	    } else if (column == 1) {
		return "ISO Code";
	    } else if (column == 2) {
		return "Continent";
	    } else if (column == 3) {
		return "Population";
	    } else {
		return null;
	    }
	}

	public Object getValueAt(final int row, final int column) {
	    return data[row][column];
	}

    }
}
