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
 * Create on 24.04.2006
 */
package org.plazmaforge.framework.report.engine.jasperreports;

import java.awt.Color;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.swing.table.TableModel;

import org.plazmaforge.framework.core.SystemEnvironment;
import org.plazmaforge.framework.report.IReport;
import org.plazmaforge.framework.report.ReportConstants;

import net.sf.jasperreports.engine.JRElement;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRTextElement;
import net.sf.jasperreports.engine.design.JRDesignBand;
import net.sf.jasperreports.engine.design.JRDesignExpression;
import net.sf.jasperreports.engine.design.JRDesignField;
import net.sf.jasperreports.engine.design.JRDesignLine;
import net.sf.jasperreports.engine.design.JRDesignParameter;
import net.sf.jasperreports.engine.design.JRDesignReportFont;
import net.sf.jasperreports.engine.design.JRDesignStaticText;
import net.sf.jasperreports.engine.design.JRDesignTextField;
import net.sf.jasperreports.engine.design.JRDesignVariable;
import net.sf.jasperreports.engine.design.JasperDesign;

public class TableDesign extends JasperDesign implements ReportConstants {

    public TableDesign(TableModel model, int[] fieldWidth) throws JRException {
	super();
    }

    protected void iniialilze(TableModel model, int[] fieldWidth)
	    throws JRException {

	setName("TableReport");

	int FIELD_MARGIN = 4;
	int COLUMN_HEADER_HEIGHT = 22;
	int DETAIL_HEIGHT = 21;

	int[] tableCols = new int[fieldWidth.length];
	int len = 0;
	for (int i = 0; i < fieldWidth.length; i++) {
	    len += (i == 0 ? 0 : FIELD_MARGIN) + fieldWidth[i];
	    tableCols[i] = fieldWidth[i] + FIELD_MARGIN * 2;
	}

	boolean isDynamicCols = false;

	if (len > A4_WIDTH - LEFT_MARGIN - RIGHT_MARGIN) {
	    if (len > A4_HEIGHT - LEFT_MARGIN - RIGHT_MARGIN) {
		isDynamicCols = true;
	    }
	    setPageWidth(A4_HEIGHT);
	    setPageHeight(A4_WIDTH);
	} else {
	    setPageWidth(A4_WIDTH);
	    setPageHeight(A4_HEIGHT);
	}

	setLeftMargin(LEFT_MARGIN);
	setRightMargin(RIGHT_MARGIN);
	setTopMargin(TOP_MARGIN);
	setBottomMargin(BOTTOM_MARGIN);

	int COLUMN_WIDTH = getPageWidth() - getLeftMargin() - getRightMargin();
	setColumnWidth(COLUMN_WIDTH);

	// jasperDesign.setOrientation(JRReport.ORIENTATION_PORTRAIT);

	setColumnSpacing(0);

	// Fonts
	JRDesignReportFont normalFont = new JRDesignReportFont();
	normalFont.setName("Arial_Normal");
	normalFont.setDefault(true);
	normalFont.setFontName("Arial");
	normalFont.setSize(11);
	normalFont.setPdfFontName("Helvetica");
	// normalFont.setPdfFontName("ARIAL.TTF");

	normalFont.setPdfEncoding(SystemEnvironment.getCodepage());
	// normalFont.setPdfEncoding("Identity-H");

	normalFont.setPdfEmbedded(false);
	// normalFont.setPdfEmbedded(true);
	// jasperDesign.addFont(normalFont);

	JRDesignReportFont boldFont = new JRDesignReportFont();
	boldFont.setName("Arial_Bold");
	boldFont.setDefault(false);
	boldFont.setFontName("Arial");
	boldFont.setSize(11);
	boldFont.setBold(true);
	boldFont.setPdfFontName("Helvetica-Bold");
	boldFont.setPdfEncoding(SystemEnvironment.getCodepage());
	boldFont.setPdfEmbedded(false);
	// jasperDesign.addFont(boldFont);

	JRDesignReportFont italicFont = new JRDesignReportFont();
	italicFont.setName("Arial_Italic");
	italicFont.setDefault(false);
	italicFont.setFontName("Arial");
	italicFont.setSize(11);
	italicFont.setItalic(true);
	italicFont.setPdfFontName("Helvetica-Oblique");
	italicFont.setPdfEncoding(SystemEnvironment.getCodepage());
	italicFont.setPdfEmbedded(false);
	addFont(italicFont);

	// Parameters
	JRDesignParameter prm = new JRDesignParameter();
	prm.setName(IReport.TITLE);
	prm.setValueClass(java.lang.String.class);
	addParameter(prm);

	// Fields
	for (int i = 0; i < model.getColumnCount(); i++) {
	    JRDesignField field = new JRDesignField();
	    field.setName("COLUMN_" + i);
	    field.setValueClass(model.getColumnClass(i));
	    addField(field);
	}

	// Variables
	JRDesignVariable variable = new JRDesignVariable();

	JRDesignExpression expression = new JRDesignExpression();

	JRDesignBand band = new JRDesignBand();

	JRDesignTextField textField = new JRDesignTextField();

	expression = new JRDesignExpression();

	JRDesignLine line = new JRDesignLine();

	expression = new JRDesignExpression();

	// Title
	band = new JRDesignBand();
	band.setHeight(50);
	line = new JRDesignLine();
	line.setX(0);
	line.setY(0);
	line.setWidth(COLUMN_WIDTH);
	line.setHeight(0);
	band.addElement(line);
	textField = new JRDesignTextField();
	textField.setBlankWhenNull(true);
	textField.setX(0);
	textField.setY(10);
	textField.setWidth(COLUMN_WIDTH);
	textField.setHeight(30);
	textField.setTextAlignment(JRTextElement.TEXT_ALIGN_CENTER);

	JRDesignReportFont bigFont = new JRDesignReportFont();
	bigFont.setName("Arial_Normal");
	bigFont.setDefault(true);
	bigFont.setFontName("Arial");
	bigFont.setSize(20);
	bigFont.setPdfFontName("Helvetica");
	bigFont.setPdfEncoding(SystemEnvironment.getCodepage());
	bigFont.setPdfEmbedded(false);

	textField.setFont(bigFont);
	expression = new JRDesignExpression();
	expression.setValueClass(java.lang.String.class);
	expression.setText("$P{" + IReport.TITLE + "}");
	textField.setExpression(expression);
	band.addElement(textField);
	setTitle(band);

	// Column header
	band = new JRDesignBand();
	band.setHeight(COLUMN_HEADER_HEIGHT);

	JRDesignStaticText staticText = new JRDesignStaticText();

	int x = 0;
	for (int i = 0; i < model.getColumnCount(); i++) {

	    int h = band.getHeight() - 1;
	    int d = fieldWidth[i] + FIELD_MARGIN * 2 + 1;

	    if (i == 0) {
		line = new JRDesignLine();
		line.setX(0);
		line.setY(0);
		line.setWidth(0);
		line.setHeight(h);
		band.addElement(line);

	    }

	    // top
	    line = new JRDesignLine();
	    line.setX(x);
	    line.setY(0);
	    line.setWidth(d);
	    line.setHeight(0);
	    band.addElement(line);

	    // bottom
	    line = new JRDesignLine();
	    line.setX(x);
	    line.setY(h);
	    line.setWidth(d);
	    line.setHeight(0);
	    band.addElement(line);

	    // right
	    line = new JRDesignLine();
	    line.setX(x + d - 1);
	    line.setY(0);
	    line.setWidth(0);
	    line.setHeight(h);
	    band.addElement(line);

	    staticText = new JRDesignStaticText();
	    staticText.setX(x + FIELD_MARGIN);
	    staticText.setY(4);
	    staticText.setWidth(fieldWidth[i]);
	    staticText.setHeight(16);
	    staticText.setForecolor(Color.BLACK);
	    // staticText.setBackcolor(new Color(0x33, 0x33, 0x33));
	    staticText.setMode(JRElement.MODE_OPAQUE);
	    staticText.setTextAlignment(JRTextElement.TEXT_ALIGN_CENTER);
	    staticText.setFont(boldFont);
	    staticText.setText(model.getColumnName(i));

	    band.addElement(staticText);

	    x += fieldWidth[i] + FIELD_MARGIN * 2;
	}

	setColumnHeader(band);

	/*
         * //Column header band = new JRDesignBand();
         * jasperDesign.setColumnHeader(band);
         */

	// Detail
	band = new JRDesignBand();
	band.setHeight(DETAIL_HEIGHT);

	x = 0;
	for (int i = 0; i < model.getColumnCount(); i++) {

	    int h = band.getHeight() - 1;
	    int d = fieldWidth[i] + FIELD_MARGIN * 2 + 1;

	    if (i == 0) {
		line = new JRDesignLine();
		line.setX(0);
		line.setY(0);
		line.setWidth(0);
		line.setHeight(h);
		band.addElement(line);

	    }

	    line = new JRDesignLine();
	    line.setX(x);
	    line.setY(h);
	    line.setWidth(d);
	    line.setHeight(0);
	    band.addElement(line);

	    line = new JRDesignLine();
	    line.setX(x + d - 1);
	    line.setY(0);
	    line.setWidth(0);
	    line.setHeight(h);
	    band.addElement(line);

	    textField = new JRDesignTextField();
	    textField.setX(x + FIELD_MARGIN);
	    textField.setY(4);
	    textField.setWidth(fieldWidth[i]);
	    textField.setHeight(16);

	    Class klass = model.getColumnClass(i);

	    if ((klass.equals(java.util.Date.class))
		    || (klass.equals(java.sql.Date.class))) {
		textField.setPattern(SystemEnvironment.getDatePattern());
	    } else if (klass.equals(java.sql.Timestamp.class)) {
		textField.setPattern(SystemEnvironment.getDatePattern());
	    } else if ((klass.equals(Float.class))
		    || (klass.equals(Double.class))
		    || (klass.equals(BigDecimal.class))) {
		textField.setPattern(SystemEnvironment.getNumberPattern());
	    }

	    if ((klass.equals(Integer.class)) || (klass.equals(Byte.class))
		    || (klass.equals(Short.class))
		    || (klass.equals(Float.class))
		    || (klass.equals(Double.class))
		    || (klass.equals(BigInteger.class))
		    || (klass.equals(BigDecimal.class))) {

		textField.setTextAlignment(JRTextElement.TEXT_ALIGN_RIGHT);
	    } else {
		textField.setTextAlignment(JRTextElement.TEXT_ALIGN_LEFT);
	    }

	    textField.setFont(normalFont);
	    expression = new JRDesignExpression();
	    expression.setValueClass(model.getColumnClass(i));
	    // expression.setText("$F{"+model.getColumnName(i)+"}");

	    expression.setText("$F{COLUMN_" + i + "}");

	    textField.setExpression(expression);
	    band.addElement(textField);

	    x += fieldWidth[i] + FIELD_MARGIN * 2;
	}

	setDetail(band);

	// Column footer
	band = new JRDesignBand();
	setColumnFooter(band);

	// Page footer
	band = new JRDesignBand();
	setPageFooter(band);

	// Summary
	band = new JRDesignBand();
	setSummary(band);

	// TODO: DISABLED for net.
	// Create grid
	/*
         * if (isDynamicCols) { JRBaseTable table = new JRBaseTable();
         * table.setColumnsWidth(tableCols);
         * 
         * JRBaseTableBand tableBand = new JRBaseTableBand();
         * 
         * JRBaseTableRow tableRow = new JRBaseTableRow();
         * tableRow.setHeight(COLUMN_HEADER_HEIGHT); tableBand.addRow(tableRow);
         * 
         * JRBaseTableCell cell = null; for(int i = 0; i < tableCols.length;
         * i++) { cell = new JRBaseTableCell(); cell.setColumnIndex(i);
         * tableRow.addCell(cell); }
         * 
         * table.setColumnHeader(tableBand);
         * 
         * 
         * tableBand = new JRBaseTableBand();
         * 
         * tableRow = new JRBaseTableRow(); tableRow.setHeight(DETAIL_HEIGHT);
         * tableBand.addRow(tableRow);
         * 
         * for(int i = 0; i < tableCols.length; i++) { cell = new
         * JRBaseTableCell(); cell.setColumnIndex(i); tableRow.addCell(cell); }
         * 
         * table.setDetail(tableBand);
         * 
         * table.prepareTable(); //table.setPrint(false);
         * 
         * 
         * prm = new JRDesignParameter();
         * 
         * prm.setName(ExtendParametersLoader.REPORT_TABLE);
         * prm.setValueClass(String.class); prm.setDescription(new
         * XMLTableParametersWriter().writeTable(table));
         * 
         * jasperDesign.addParameter(prm); }
         */

    }

}
