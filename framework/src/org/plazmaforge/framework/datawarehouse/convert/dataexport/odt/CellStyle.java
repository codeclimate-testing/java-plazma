package org.plazmaforge.framework.datawarehouse.convert.dataexport.odt;

import java.awt.Color;
import java.io.IOException;
import java.io.Writer;


public class CellStyle extends BorderStyle {

    // private String fill = null;
    private String backcolor = null;

    private final String verticalAlignment;

    public CellStyle(Writer styleWriter, byte backgroundMode, Color backgroundColor, byte hAlign, byte vAlign, byte rotation) {
	super(styleWriter);

	if (backgroundMode == Constants.MODE_OPAQUE) {
	    // fill = "solid";
	    backcolor = Utils.getColorHexa(backgroundColor);
	} else {
	    // fill = "none";
	}

	verticalAlignment = ParagraphStyle.getVerticalAlignment(hAlign, vAlign,	rotation);
    }

    public String getId() {
	return backcolor + super.getId() + "|" + verticalAlignment;
    }

    public void write(String cellStyleName) throws IOException {
	styleWriter.write("<style:style style:name=\"");
	styleWriter.write(cellStyleName);
	styleWriter.write("\"");
	styleWriter.write(" style:family=\"table-cell\">\n");
	styleWriter.write(" <style:table-cell-properties");
	styleWriter.write(" fo:wrap-option=\"wrap\"");
	styleWriter.write(" style:shrink-to-fit=\"false\"");
	if (backcolor != null) {
	    styleWriter.write(" fo:background-color=\"#");
	    styleWriter.write(backcolor);
	    styleWriter.write("\"");
	}

	writeBorder(TOP_BORDER);
	writeBorder(LEFT_BORDER);
	writeBorder(BOTTOM_BORDER);
	writeBorder(RIGHT_BORDER);

	if (verticalAlignment != null) {
	    styleWriter.write(" style:vertical-align=\"");
	    styleWriter.write(verticalAlignment);
	    styleWriter.write("\"");
	}

	styleWriter.write("/>\n");
	styleWriter.write("</style:style>\n");
    }

}
