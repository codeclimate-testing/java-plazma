package org.plazmaforge.framework.datawarehouse.convert.dataexport.odt;

import java.io.IOException;
import java.io.Writer;


public abstract class BorderStyle extends Style {
    
    private static final String[] border = new String[] { "top", "left", "bottom", "right" };

    protected static final int TOP_BORDER = 0;

    protected static final int LEFT_BORDER = 1;

    protected static final int BOTTOM_BORDER = 2;

    protected static final int RIGHT_BORDER = 3;

    private String[] borderColor = new String[4];

    private String[] borderWidth = new String[4];

    private String[] borderStyle = new String[4];

    private String[] borderPadding = new String[4];

    public BorderStyle(Writer styleWriter) {
	super(styleWriter);
    }

    public void setBox(Box box) throws IOException {
	appendBorder(box.getTopPen(), TOP_BORDER);
	borderPadding[TOP_BORDER] = String.valueOf(Utils.translatePixelsToInchesWithNoRoundOff(box.getTopPadding()));
	appendBorder(box.getLeftPen(), LEFT_BORDER);
	borderPadding[LEFT_BORDER] = String.valueOf(Utils.translatePixelsToInchesWithNoRoundOff(box.getLeftPadding()));
	appendBorder(box.getBottomPen(), BOTTOM_BORDER);
	borderPadding[BOTTOM_BORDER] = String.valueOf(Utils.translatePixelsToInchesWithNoRoundOff(box.getBottomPadding()));
	appendBorder(box.getRightPen(), RIGHT_BORDER);
	borderPadding[RIGHT_BORDER] = String.valueOf(Utils.translatePixelsToInchesWithNoRoundOff(box.getRightPadding()));
    }

    public void setPen(Pen pen) throws IOException {
	if (borderWidth[TOP_BORDER] == null && borderWidth[LEFT_BORDER] == null
		&& borderWidth[BOTTOM_BORDER] == null
		&& borderWidth[RIGHT_BORDER] == null) {
	    appendBorder(pen, TOP_BORDER);
	    appendBorder(pen, LEFT_BORDER);
	    appendBorder(pen, BOTTOM_BORDER);
	    appendBorder(pen, RIGHT_BORDER);
	}
    }

    public String getId() {
	return borderWidth[TOP_BORDER] + "|" + borderColor[TOP_BORDER] + "|"
		+ borderStyle[TOP_BORDER] + "|" + borderPadding[TOP_BORDER]
		+ "|" + borderWidth[LEFT_BORDER] + "|"
		+ borderColor[LEFT_BORDER] + "|" + borderStyle[LEFT_BORDER]
		+ "|" + borderPadding[LEFT_BORDER] + "|"
		+ borderWidth[BOTTOM_BORDER] + "|" + borderColor[BOTTOM_BORDER]
		+ "|" + borderStyle[BOTTOM_BORDER] + "|"
		+ borderPadding[BOTTOM_BORDER] + "|"
		+ borderWidth[RIGHT_BORDER] + "|" + borderColor[RIGHT_BORDER]
		+ "|" + borderStyle[RIGHT_BORDER] + "|"
		+ borderPadding[RIGHT_BORDER];
    }

    protected void writeBorder(int side) throws IOException {
	if (borderWidth[side] != null) {
	    styleWriter.write(" fo:border-");
	    styleWriter.write(border[side]);
	    styleWriter.write("=\"");
	    styleWriter.write(borderWidth[side]);
	    styleWriter.write("in ");
	    styleWriter.write(borderStyle[side]);
	    styleWriter.write(" #");
	    styleWriter.write(borderColor[side]);
	    styleWriter.write("\"");
	}

	if (borderPadding[side] != null) {
	    styleWriter.write(" fo:padding-");
	    styleWriter.write(border[side]);
	    styleWriter.write("=\"");
	    styleWriter.write(borderPadding[side]);
	    styleWriter.write("in\"");
	}
    }

    private void appendBorder(Pen pen, int side) throws IOException {
	double width = pen.getLineWidth();
	String style = null;

	if (width > 0f) {
	    switch (pen.getLineStyle())// FIXMEBORDER is this working? deal
                                        // with double border too.
	    {
	    case Pen.LINE_STYLE_DOTTED: {
		style = "dotted";
		break;
	    }
	    case Pen.LINE_STYLE_DASHED: {
		style = "dashed";
		break;
	    }
	    case Pen.LINE_STYLE_SOLID:
	    default: {
		style = "solid";
		break;
	    }
	    }

	    borderWidth[side] = String.valueOf(Utils.translatePixelsToInchesWithNoRoundOff(width));
	} else {
	    style = "none";
	}

	borderStyle[side] = style;
	borderColor[side] = Utils.getColorHexa(pen.getLineColor());
    }

}
