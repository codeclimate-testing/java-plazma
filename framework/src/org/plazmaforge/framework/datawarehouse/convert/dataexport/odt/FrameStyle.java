package org.plazmaforge.framework.datawarehouse.convert.dataexport.odt;

import java.awt.Color;
import java.io.IOException;
import java.io.Writer;


public class FrameStyle extends BorderStyle {

    private String fill = null;

    private String backcolor = null;

    public FrameStyle(Writer styleWriter, byte backgroundMode, Color backgroundColor) {
	super(styleWriter);

	if (backgroundMode == Constants.MODE_OPAQUE) {
	    fill = "solid";
	    backcolor = Utils.getColorHexa(backgroundColor);
	} else {
	    fill = "none";
	}
    }

    public String getId() {
	return fill + "|" + backcolor + "|" + super.getId();
    }

    public void write(String frameStyleName) throws IOException {
	styleWriter.write("<style:style style:name=\"");
	styleWriter.write(frameStyleName);
	styleWriter.write("\" style:family=\"graphic\"");
	// styleWriter.write(" style:parent-style-name=\"Frame\"" +
	styleWriter.write(">\n");
	styleWriter.write(" <style:graphic-properties");
	// styleWriter.write(" style:run-through=\"foreground\"");
	// styleWriter.write(" style:wrap=\"run-through\"");
	// styleWriter.write(" style:number-wrapped-paragraphs=\"no-limit\"");
	// styleWriter.write(" style:wrap-contour=\"false\"");
	styleWriter.write(" style:vertical-pos=\"from-top\"");
	styleWriter.write(" style:vertical-rel=\"page\"");
	styleWriter.write(" style:horizontal-pos=\"from-left\"");
	styleWriter.write(" style:horizontal-rel=\"page\"");
	styleWriter.write(" draw:fill=\"");
	styleWriter.write(fill);
	styleWriter.write("\" draw:fill-color=\"#");
	styleWriter.write(backcolor);
	styleWriter.write("\"");

	writeBorder(TOP_BORDER);
	writeBorder(LEFT_BORDER);
	writeBorder(BOTTOM_BORDER);
	writeBorder(RIGHT_BORDER);

	styleWriter.write("/>\n");
	styleWriter.write("</style:style>\n");
    }

}

