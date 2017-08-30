package org.plazmaforge.framework.datawarehouse.convert.dataexport.odt;

import java.io.IOException;
import java.io.Writer;


public class ParagraphStyle extends Style {

    protected static final String HORIZONTAL_ALIGN_LEFT = "start";

    protected static final String HORIZONTAL_ALIGN_RIGHT = "end";

    protected static final String HORIZONTAL_ALIGN_CENTER = "center";

    protected static final String HORIZONTAL_ALIGN_JUSTIFY = "justified";

    private static final String VERTICAL_ALIGN_TOP = "top";

    private static final String VERTICAL_ALIGN_MIDDLE = "middle";

    private static final String VERTICAL_ALIGN_BOTTOM = "bottom";

    protected static final String ROTATION_ALIGN_NONE = "none";

    protected static final String ROTATION_ALIGN_TOP = "top";

    protected static final String ROTATION_ALIGN_CENTER = "center";

    protected static final String ROTATION_ALIGN_BOTTOM = "bottom";

    private String verticalAlignment = null;

    private String horizontalAlignment = null;

    private String runDirection = null;

    private String textRotation = "0";

    public ParagraphStyle(Writer styleWriter, byte hAlign, byte vAlign,
	    byte rotation) {
	super(styleWriter);

	horizontalAlignment = getHorizontalAlignment(hAlign, vAlign, rotation);
	verticalAlignment = getVerticalAlignment(hAlign, vAlign, rotation);

	switch (rotation) {
	case Constants.ROTATION_LEFT: {
	    textRotation = "90";
	    break;
	}
	case Constants.ROTATION_RIGHT: {
	    textRotation = "270";
	    break;
	}
	case Constants.ROTATION_UPSIDE_DOWN://FIXMEODT possible?
	case Constants.ROTATION_NONE:
	default: {
	    textRotation = "0";
	}
	}

	runDirection = null;
	//		if (getRunDirection() == Constants.RUN_DIRECTION_RTL)
	//		{
	//			runDirection = "rl";
	//		}
    }

    /**
     *
     */
    public static String getVerticalAlignment(byte horizontalAlignment,
	    byte verticalAlignment, byte rotation) {
	switch (rotation) {
	case Constants.ROTATION_LEFT: {
	    switch (horizontalAlignment) {
	    case Constants.HORIZONTAL_ALIGN_RIGHT:
		return VERTICAL_ALIGN_TOP;
	    case Constants.HORIZONTAL_ALIGN_CENTER:
		return VERTICAL_ALIGN_MIDDLE;
	    case Constants.HORIZONTAL_ALIGN_JUSTIFIED:
		return HORIZONTAL_ALIGN_JUSTIFY;//FIXMEODT ?????????????????
	    case Constants.HORIZONTAL_ALIGN_LEFT:
	    default:
		return VERTICAL_ALIGN_BOTTOM;
	    }
	}
	case Constants.ROTATION_RIGHT: {
	    switch (horizontalAlignment) {
	    case Constants.HORIZONTAL_ALIGN_RIGHT:
		return VERTICAL_ALIGN_BOTTOM;
	    case Constants.HORIZONTAL_ALIGN_CENTER:
		return VERTICAL_ALIGN_MIDDLE;
	    case Constants.HORIZONTAL_ALIGN_JUSTIFIED:
		return HORIZONTAL_ALIGN_JUSTIFY;//?????????????????
	    case Constants.HORIZONTAL_ALIGN_LEFT:
	    default:
		return VERTICAL_ALIGN_TOP;
	    }
	}
	case Constants.ROTATION_UPSIDE_DOWN://FIXMEODT possible?
	case Constants.ROTATION_NONE:
	default: {
	    switch (verticalAlignment) {
	    case Constants.VERTICAL_ALIGN_BOTTOM:
		return VERTICAL_ALIGN_BOTTOM;
	    case Constants.VERTICAL_ALIGN_MIDDLE:
		return VERTICAL_ALIGN_MIDDLE;
	    case Constants.VERTICAL_ALIGN_TOP:
	    default:
		return VERTICAL_ALIGN_TOP;
	    }
	}
	}
    }

    /**
     *
     */
    public static String getHorizontalAlignment(byte horizontalAlignment,
	    byte verticalAlignment, byte rotation) {
	switch (rotation) {
	case Constants.ROTATION_LEFT: {
	    switch (verticalAlignment) {
	    case Constants.VERTICAL_ALIGN_BOTTOM:
		return HORIZONTAL_ALIGN_RIGHT;
	    case Constants.VERTICAL_ALIGN_MIDDLE:
		return HORIZONTAL_ALIGN_CENTER;
	    case Constants.VERTICAL_ALIGN_TOP:
	    default:
		return HORIZONTAL_ALIGN_LEFT;
	    }
	}
	case Constants.ROTATION_RIGHT: {
	    switch (verticalAlignment) {
	    case Constants.VERTICAL_ALIGN_BOTTOM:
		return HORIZONTAL_ALIGN_LEFT;
	    case Constants.VERTICAL_ALIGN_MIDDLE:
		return HORIZONTAL_ALIGN_CENTER;
	    case Constants.VERTICAL_ALIGN_TOP:
	    default:
		return HORIZONTAL_ALIGN_RIGHT;
	    }
	}
	case Constants.ROTATION_UPSIDE_DOWN://FIXMEODT possible?
	case Constants.ROTATION_NONE:
	default: {
	    switch (horizontalAlignment) {
	    case Constants.HORIZONTAL_ALIGN_RIGHT:
		return HORIZONTAL_ALIGN_RIGHT;
	    case Constants.HORIZONTAL_ALIGN_CENTER:
		return HORIZONTAL_ALIGN_CENTER;
	    case Constants.HORIZONTAL_ALIGN_JUSTIFIED:
		return HORIZONTAL_ALIGN_JUSTIFY;
	    case Constants.HORIZONTAL_ALIGN_LEFT:
	    default:
		return HORIZONTAL_ALIGN_LEFT;
	    }
	}
	}
    }

    /**
     *
     */
    public String getId() {
	return verticalAlignment + "|" + horizontalAlignment + "|"
		+ runDirection + "|" + textRotation;
    }

    /**
     *
     */
    public void write(String paragraphStyleName) throws IOException {
	styleWriter.write("<style:style style:name=\"" + paragraphStyleName
		+ "\"");
	styleWriter.write(" style:family=\"paragraph\">\n");
	styleWriter.write("<style:paragraph-properties");
	//		styleWriter.write(" fo:line-height=\"" + pLineHeight + "\"");
	//		styleWriter.write(" style:line-spacing=\"" + pLineSpacing + "\"");
	styleWriter.write(" fo:text-align=\"" + horizontalAlignment + "\"");

	//		styleWriter.write(" fo:keep-together=\"" + pKeepTogether + "\"");
	//		styleWriter.write(" fo:margin-left=\"" + pMarginLeft + "\"");
	//		styleWriter.write(" fo:margin-right=\"" + pMarginRight + "\"");
	//		styleWriter.write(" fo:margin-top=\"" + pMarginTop + "\"");
	//		styleWriter.write(" fo:margin-bottom=\"" + pMarginBottom + "\"");
	//		styleWriter.write(" fo:background-color=\"#" + pBackGroundColor + "\"");
	styleWriter
		.write(" style:vertical-align=\"" + verticalAlignment + "\"");
	if (runDirection != null) {
	    styleWriter.write(" style:writing-mode=\"" + runDirection + "\"");
	}
	styleWriter.write("> \r\n");
	styleWriter.write("</style:paragraph-properties>\n");
	styleWriter.write("<style:text-properties");
	styleWriter
		.write(" style:text-rotation-angle=\"" + textRotation + "\"");
	styleWriter.write("> \r\n");
	styleWriter.write("</style:text-properties>\n");

	//        styleWriter.write("<style:properties");
	//        styleWriter.write(" style:rotation-align=\"" + rotationAlignment + "\"");
	//        styleWriter.write("> \r\n");
	//        styleWriter.write("</style:properties>\n");
	//

	styleWriter.write("</style:style>\n");
    }

}
