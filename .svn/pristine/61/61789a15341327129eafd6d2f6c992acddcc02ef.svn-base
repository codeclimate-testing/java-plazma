package org.plazmaforge.framework.datawarehouse.convert.dataexport.odt;

import java.awt.Color;
import java.io.IOException;
import java.io.Writer;


public class GraphicStyle extends Style {

    private String backcolor = null;

    private String forecolor = null;

    private String style = null;

    private String width = null;

    private String hAlign = null;

    private String vAlign = null;

    public GraphicStyle(Writer styleWriter, byte backgroundMode,  Color backgroundColor, Pen pen) {
	super(styleWriter);

	if (backgroundMode == Constants.MODE_OPAQUE) {
	    // fill = "solid";
	    backcolor = Utils.getColorHexa(backgroundColor);
	} else {
	    // fill = "none";
	}

	forecolor = Utils.getColorHexa(pen.getLineColor());

	double doubleWidth = pen.getLineWidth();
	if (doubleWidth < 0) {
	    style = "none";
	} else {
	    switch (pen.getLineStyle()) {
	    case Pen.LINE_STYLE_DOTTED: // FIXMEBORDER
	    case Pen.LINE_STYLE_DASHED: {
		style = "dash";
		break;
	    }
	    case Pen.LINE_STYLE_SOLID:
	    default: {
		style = "solid";
		break;
	    }
	    }
	}

	width = String.valueOf(Utils
		.translatePixelsToInchesWithNoRoundOff(doubleWidth));
	byte horizontalAlignment = Constants.HORIZONTAL_ALIGN_LEFT;
	byte verticalAlignment = Constants.VERTICAL_ALIGN_TOP;

	// if(isImage) {
	// horizontalAlignment = image.getHorizontalAlignment();
	// verticalAlignment = image.getVerticalAlignment();
	// }

	switch (horizontalAlignment) {
	case Constants.HORIZONTAL_ALIGN_RIGHT: {
	    hAlign = "right";
	    break;
	}
	case Constants.HORIZONTAL_ALIGN_JUSTIFIED: {
	    hAlign = "justified";
	    break;
	}
	case Constants.HORIZONTAL_ALIGN_CENTER: {
	    hAlign = "center";
	    break;
	}
	case Constants.HORIZONTAL_ALIGN_LEFT:
	default: {
	    hAlign = "left";
	    break;
	}
	}

	switch (verticalAlignment) {
	case Constants.VERTICAL_ALIGN_BOTTOM: {
	    vAlign = "bottom";
	    break;
	}
	case Constants.VERTICAL_ALIGN_MIDDLE: {
	    vAlign = "middle";
	    break;
	}
	case Constants.VERTICAL_ALIGN_TOP:
	default: {
	    vAlign = "top";
	    break;
	}

	}
    }

    public String getId() {
	// return fill + "|" + backcolor
	StringBuffer id = new StringBuffer();
	id.append(backcolor);
	id.append("|");
	id.append(forecolor);
	id.append("|");
	id.append(style);
	id.append("|");
	id.append(width);
	id.append("|");
	id.append(hAlign);
	id.append("|");
	id.append(vAlign);
	return id.toString();
    }

    public void write(String lineStyleName) throws IOException {
	styleWriter.write(" <style:style style:name=\"" + lineStyleName + "\"");
	styleWriter.write(" style:family=\"graphic\" style:parent-style-name=\"Graphics\">\n");
	styleWriter.write("   <style:graphic-properties");
	styleWriter.write(" draw:fill-color=\"#" + backcolor + "\"");
	styleWriter.write(" style:horizontal-pos=\"" + hAlign + "\" style:horizontal-rel=\"paragraph\"");
	styleWriter.write(" style:vertical-pos=\"" + vAlign + "\" style:vertical-rel=\"paragraph\"");
	styleWriter.write(" svg:stroke-color=\"#" + forecolor + "\"");
	styleWriter.write(" draw:stroke=\"" + style + "\"");// FIXMENOW
                                                                // dashed
                                                                // borders do
                                                                // not work;
                                                                // only dashed
                                                                // lines and
                                                                // ellipses seem
                                                                // to work
	styleWriter.write(" draw:stroke-dash=\"Dashed\"");
	styleWriter.write(" svg:stroke-width=\"" + width + "in\"");
	styleWriter.write("/>\n");
	styleWriter.write("</style:style>\n");
    }

}
