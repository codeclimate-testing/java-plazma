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

import org.jfree.report.modules.gui.base.PreviewDialog;
import org.jfree.report.*;
import org.jfree.report.elementfactory.*;
import org.jfree.report.style.ElementStyleSheet;
import org.jfree.report.style.FontDefinition;
import org.jfree.report.function.FunctionInitializeException;
import org.jfree.report.function.ExpressionCollection;
import org.jfree.report.function.ItemSumFunction;
import org.jfree.report.function.ElementVisibilitySwitchFunction;
import org.jfree.ui.FloatDimension;

import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;

/**
 * @author Oleh Hapon Date: 04.03.2004 Time: 9:54:14 $Id: SampleReport.java,v 1.2 2010/04/28 06:34:40 ohapon Exp $
 */
public class SampleReport {

    private TableModel data;

    public SampleReport(TableModel data) {
	this.data = data;
    }

    private PageHeader createPageHeader() {
	final PageHeader header = new PageHeader();
	header.getStyle().setStyleProperty(ElementStyleSheet.MINIMUMSIZE,
		new FloatDimension(0, 18));
	header.getBandDefaults().setFontDefinitionProperty(
		new FontDefinition("Serif", 10));
	header.setDisplayOnFirstPage(false);
	header.setDisplayOnLastPage(false);

	int count = data.getColumnCount();

	for (int i = 0; i < count; i++) {
	    Class klass = data.getColumnClass(i);
	    if ((klass == Integer.class) || (klass == Double.class)
		    || (klass == Float.class) || (klass == Byte.class)) {

		LabelElementFactory nfactory = new LabelElementFactory();
		nfactory.setName("Field" + (i + 1));
		nfactory.setAbsolutePosition(new Point2D.Float(i * 100, 0));
		nfactory.setMinimumSize(new FloatDimension(100, 10));
		nfactory.setHorizontalAlignment(ElementAlignment.LEFT);
		nfactory.setVerticalAlignment(ElementAlignment.MIDDLE);
		// nfactory.setNullString("");
		// nfactory.setFieldname(data.getColumnName(i));
		nfactory.setText(data.getColumnName(i));
		// nfactory.setFormatString("#,##0");
		header.addElement(nfactory.createElement());

	    } else {
		LabelElementFactory factory = new LabelElementFactory();
		factory.setName("Field" + (i + 1));
		factory.setAbsolutePosition(new Point2D.Float(i * 100, 0));
		factory.setMinimumSize(new FloatDimension(176, 10));
		factory.setHorizontalAlignment(ElementAlignment.LEFT);
		factory.setVerticalAlignment(ElementAlignment.MIDDLE);
		factory.setText(data.getColumnName(i));
		// factory.setNullString("");
		// factory.setFieldname(data.getColumnName(i));
		header.addElement(factory.createElement());
	    }

	}
	return header;
    }

    private PageFooter createPageFooter() {

	final PageFooter pageFooter = new PageFooter();
	pageFooter.getStyle().setStyleProperty(ElementStyleSheet.MINIMUMSIZE,
		new FloatDimension(0, 30));
	pageFooter.getBandDefaults().setFontDefinitionProperty(
		new FontDefinition("Dialog", 10));

	pageFooter.addElement(StaticShapeElementFactory
		.createRectangleShapeElement(null, Color.black, null,
			new Rectangle2D.Float(0, 0, -100, -100), true, false));

	final LabelElementFactory factory = new LabelElementFactory();
	factory.setName("Label 2");
	factory.setAbsolutePosition(new Point2D.Float(0, 0));
	factory.setMinimumSize(new FloatDimension(-100, 0));
	factory.setHorizontalAlignment(ElementAlignment.LEFT);
	factory.setVerticalAlignment(ElementAlignment.TOP);
	factory.setText("Some Text for the page footer");
	factory.setDynamicHeight(Boolean.TRUE);
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
	factory.setText("*** END OF REPORT ***");
	footer.addElement(factory.createElement());

	return footer;
    }

    private ReportHeader createReportHeader() {

	final ReportHeader header = new ReportHeader();
	header.getStyle().setStyleProperty(ElementStyleSheet.MINIMUMSIZE,
		new FloatDimension(0, 48));
	header.getBandDefaults().setFontDefinitionProperty(
		new FontDefinition("Serif", 20, true, false, false, false));
	final LabelElementFactory factory = new LabelElementFactory();
	factory.setName("Label 1");
	factory.setAbsolutePosition(new Point2D.Float(0, 0));
	factory.setMinimumSize(new FloatDimension(-100, 24));
	factory.setHorizontalAlignment(ElementAlignment.CENTER);
	factory.setVerticalAlignment(ElementAlignment.MIDDLE);
	factory.setText("LIST OF CONTINENTS BY COUNTRY");
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

	int count = data.getColumnCount();

	for (int i = 0; i < count; i++) {
	    Class klass = data.getColumnClass(i);
	    if ((klass == Integer.class) || (klass == Double.class)
		    || (klass == Float.class) || (klass == Byte.class)) {

		NumberFieldElementFactory nfactory = new NumberFieldElementFactory();
		nfactory.setName("Field" + (i + 1));
		nfactory.setAbsolutePosition(new Point2D.Float(i * 100, 0));
		nfactory.setMinimumSize(new FloatDimension(100, 10));
		nfactory.setHorizontalAlignment(ElementAlignment.RIGHT);
		nfactory.setVerticalAlignment(ElementAlignment.MIDDLE);
		nfactory.setNullString("");
		nfactory.setFieldname(data.getColumnName(i));
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
		factory.setFieldname(data.getColumnName(i));
		items.addElement(factory.createElement());
	    }

	}

	return items;
    }

    private ExpressionCollection createFunctions()
	    throws FunctionInitializeException {
	final ExpressionCollection functions = new ExpressionCollection();

	final ItemSumFunction sum = new ItemSumFunction();
	sum.setName("sum");
	sum.setProperty("field", "Population");
	sum.setProperty("group", "Continent Group");
	functions.add(sum);

	final ElementVisibilitySwitchFunction backgroundTrigger = new ElementVisibilitySwitchFunction();
	backgroundTrigger.setName("backgroundTrigger");
	backgroundTrigger.setProperty("element", "background");
	functions.add(backgroundTrigger);

	return functions;
    }

    private GroupList createGroups() {
	final GroupList list = new GroupList();
	list.add(createContinentGroup());
	return list;
    }

    private Group createContinentGroup() {
	final Group continentGroup = new Group();
	continentGroup.setName("Continent Group");

	final GroupHeader header = new GroupHeader();

	header.getStyle().setStyleProperty(ElementStyleSheet.MINIMUMSIZE,
		new FloatDimension(0, 18));
	header.getBandDefaults().setFontDefinitionProperty(
		new FontDefinition("Monospaced", 9, true, false, false, false));

	int count = data.getColumnCount();

	for (int i = 0; i < count; i++) {
	    Class klass = data.getColumnClass(i);
	    if ((klass == Integer.class) || (klass == Double.class)
		    || (klass == Float.class) || (klass == Byte.class)) {

		LabelElementFactory nfactory = new LabelElementFactory();
		nfactory.setName("Field" + (i + 1));
		nfactory.setAbsolutePosition(new Point2D.Float(i * 100, 0));
		nfactory.setMinimumSize(new FloatDimension(100, 10));
		nfactory.setHorizontalAlignment(ElementAlignment.LEFT);
		nfactory.setVerticalAlignment(ElementAlignment.MIDDLE);
		// nfactory.setNullString("");
		// nfactory.setFieldname(data.getColumnName(i));
		nfactory.setText(data.getColumnName(i));
		// nfactory.setFormatString("#,##0");
		header.addElement(nfactory.createElement());

	    } else {
		LabelElementFactory factory = new LabelElementFactory();
		factory.setName("Field" + (i + 1));
		factory.setAbsolutePosition(new Point2D.Float(i * 100, 0));
		factory.setMinimumSize(new FloatDimension(176, 10));
		factory.setHorizontalAlignment(ElementAlignment.LEFT);
		factory.setVerticalAlignment(ElementAlignment.MIDDLE);
		factory.setText(data.getColumnName(i));
		// factory.setNullString("");
		// factory.setFieldname(data.getColumnName(i));
		header.addElement(factory.createElement());
	    }

	}

	continentGroup.setHeader(header);

	return continentGroup;
    }

    public JFreeReport createReport() throws FunctionInitializeException {

	final JFreeReport report = new JFreeReport();
	report.setName("Sample Report 1");
	report.setReportFooter(createReportFooter());
	report.setReportHeader(createReportHeader());
	report.setPageFooter(createPageFooter());
	report.setPageHeader(createPageHeader());
	report.setGroups(createGroups());
	report.setItemBand(createItemBand());
	report.setFunctions(createFunctions());
	report.setPropertyMarked("report.date", true);
	report.setData(this.data);

	return report;
    }

    public TableModel getData() {
	return data;
    }

    public static void main(final String[] args) throws Exception {
	// initialize JFreeReport
	Boot.start();
	final JFreeReport report = null;// new SampleReport(new
                                        // SampleData1()).createReport();
	// report.setData();
	final PreviewDialog dialog = new PreviewDialog(report);
	dialog.setModal(true);
	dialog.pack();
	dialog.setVisible(true);
    }

}
