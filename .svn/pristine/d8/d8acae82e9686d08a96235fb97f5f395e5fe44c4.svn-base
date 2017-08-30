package org.plazmaforge.framework.datawarehouse.convert.dataexport.odt;

import java.awt.Color;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class StyleCache {

    private Writer styleWriter = null;

    private Map fontMap = null;

    private Set fontFaces = new HashSet();

    private Map frameStyles = new HashMap();// FIXMEODT soft cache?

    private int frameStylesCounter = 0;

    private Map cellStyles = new HashMap();

    private int cellStylesCounter = 0;

    private Map graphicStyles = new HashMap();

    private int graphicStylesCounter = 0;

    private Map paragraphStyles = new HashMap();

    private int paragraphStylesCounter = 0;

    private Map textSpanStyles = new HashMap();

    private int textSpanStylesCounter = 0;

    public StyleCache(Writer styleWriter, Map fontMap) {
	this.styleWriter = styleWriter;
	this.fontMap = fontMap;
    }

    public Collection getFontFaces() {
	return fontFaces;
    }

    public String getFrameStyle(byte backgroundMode, Color backgroundColor) throws IOException {
	return getFrameStyle(backgroundMode, backgroundColor, null);
    }

    public String getFrameStyle(byte backgroundMode, Color backgroundColor, Box box) throws IOException {
	FrameStyle frameStyle = new FrameStyle(styleWriter, backgroundMode, backgroundColor);
	if (box != null) {
	    frameStyle.setBox(box);
	}

	String frameStyleId = frameStyle.getId();
	String frameStyleName = (String) frameStyles.get(frameStyleId);

	if (frameStyleName == null) {
	    frameStyleName = "F" + frameStylesCounter++;
	    frameStyles.put(frameStyleId, frameStyleName);

	    frameStyle.write(frameStyleName);
	}

	return frameStyleName;
    }

    public String getGraphicStyle(byte backgroundMode, Color backgroundColor, Pen pen) throws IOException {
	
	GraphicStyle graphicStyle = new GraphicStyle(styleWriter, backgroundMode, backgroundColor, pen);

	String graphicStyleId = graphicStyle.getId();
	String graphicStyleName = (String) cellStyles.get(graphicStyleId);

	if (graphicStyleName == null) {
	    graphicStyleName = "G" + graphicStylesCounter++;
	    graphicStyles.put(graphicStyleId, graphicStyleName);

	    graphicStyle.write(graphicStyleName);
	}

	return graphicStyleName;
    }

    public String getCellStyle(byte backgroundMode, Color backgroundColor, byte hAlign, byte vAlign, byte rotation) throws IOException {
	return getCellStyle(backgroundMode, backgroundColor, hAlign, vAlign, rotation, null, null);
    }

    public String getCellStyle(byte backgroundMode, Color backgroundColor,  byte hAlign, byte vAlign, byte rotation, Box box, Pen pen) throws IOException {

	CellStyle cellStyle = new CellStyle(styleWriter, backgroundMode, backgroundColor, hAlign, vAlign, rotation);

	if (box != null) {
	    cellStyle.setBox(box);
	}

	if (pen != null) {
	    cellStyle.setPen(pen);
	}

	String cellStyleId = cellStyle.getId();
	String cellStyleName = (String) cellStyles.get(cellStyleId);

	if (cellStyleName == null) {
	    cellStyleName = "C" + cellStylesCounter++;
	    cellStyles.put(cellStyleId, cellStyleName);

	    cellStyle.write(cellStyleName);
	}

	return cellStyleName;
    }

    /**
         * 
         */
    public String getParagraphStyle(byte hAlign, byte vAlign, byte rotation) throws IOException {
	ParagraphStyle paragraphStyle = new ParagraphStyle(styleWriter, hAlign, vAlign, rotation);

	String paragraphStyleId = paragraphStyle.getId();
	String paragraphStyleName = (String) paragraphStyles
		.get(paragraphStyleId);

	if (paragraphStyleName == null) {
	    paragraphStyleName = "P" + paragraphStylesCounter++;
	    paragraphStyles.put(paragraphStyleId, paragraphStyleName);

	    paragraphStyle.write(paragraphStyleName);
	}

	return paragraphStyleName;
    }

    /**
         * 
         */
    public String getTextSpanStyle(Map attributes, String text) throws IOException {
	String fontFamily;
	String fontFamilyAttr = (String) attributes.get(TextAttribute.FAMILY);
	if (fontMap != null && fontMap.containsKey(fontFamilyAttr)) {
	    fontFamily = (String) fontMap.get(fontFamilyAttr);
	} else {
	    fontFamily = fontFamilyAttr;
	}
	fontFaces.add(fontFamily);

	StringBuffer textSpanStyleIdBuffer = new StringBuffer();
	textSpanStyleIdBuffer.append(fontFamily);

	String forecolorHexa = null;
	Color forecolor = (Color) attributes.get(TextAttribute.FOREGROUND);
	if (!Color.black.equals(forecolor)) {
	    forecolorHexa = Utils.getColorHexa(forecolor);
	    textSpanStyleIdBuffer.append(forecolorHexa);
	}

	String backcolorHexa = null;
	Color runBackcolor = (Color) attributes.get(TextAttribute.BACKGROUND);
	if (runBackcolor != null) {
	    backcolorHexa = Utils.getColorHexa(runBackcolor);
	    textSpanStyleIdBuffer.append(backcolorHexa);
	}

	String size = String.valueOf(attributes.get(TextAttribute.SIZE));
	textSpanStyleIdBuffer.append(size);

	String weight = null;
	if (TextAttribute.WEIGHT_BOLD.equals(attributes.get(TextAttribute.WEIGHT))) {
	    weight = "bold";
	    textSpanStyleIdBuffer.append(weight);
	}
	String posture = null;
	if (TextAttribute.POSTURE_OBLIQUE.equals(attributes.get(TextAttribute.POSTURE))) {
	    posture = "italic";
	    textSpanStyleIdBuffer.append(posture);
	}
	String underline = null;
	if (TextAttribute.UNDERLINE_ON.equals(attributes.get(TextAttribute.UNDERLINE))) {
	    underline = "single";
	    textSpanStyleIdBuffer.append(underline);
	}
	String strikeThrough = null;
	if (TextAttribute.STRIKETHROUGH_ON.equals(attributes.get(TextAttribute.STRIKETHROUGH))) {
	    strikeThrough = "single";
	    textSpanStyleIdBuffer.append(strikeThrough);
	}

	// if
        // (TextAttribute.SUPERSCRIPT_SUPER.equals(attributes.get(TextAttribute.SUPERSCRIPT)))
	// {
	// textSpanStyleIdBuffer.append(" vertical-align: super;");
	// }
	// else if
        // (TextAttribute.SUPERSCRIPT_SUB.equals(attributes.get(TextAttribute.SUPERSCRIPT)))
	// {
	// textSpanStyleIdBuffer.append(" vertical-align: sub;");
	// }

	String textSpanStyleId = textSpanStyleIdBuffer.toString();
	String textSpanStyleName = (String) textSpanStyles.get(textSpanStyleId);

	if (textSpanStyleName == null) {
	    textSpanStyleName = "T" + textSpanStylesCounter++;
	    textSpanStyles.put(textSpanStyleId, textSpanStyleName);

	    styleWriter.write("<style:style style:name=\"" + textSpanStyleName
		    + "\"");
	    styleWriter.write(" style:family=\"text\">\n");
	    styleWriter.write("<style:text-properties");
	    if (forecolorHexa != null) {
		styleWriter.write(" fo:color=\"#" + forecolorHexa + "\"");
	    }
	    styleWriter.write(" style:font-name=\"" + fontFamily + "\"");
	    styleWriter.write(" fo:font-size=\"" + size + "pt\"");
	    if (posture != null) {
		styleWriter.write(" fo:font-style=\"" + posture + "\"");
	    }
	    if (weight != null) {
		styleWriter.write(" fo:font-weight=\"" + weight + "\"");
	    }
	    if (backcolorHexa != null) {
		styleWriter.write(" fo:background-color=\"#" + backcolorHexa
			+ "\"");
	    }
	    // styleWriter.write(" style:text-rotation-angle=\"" +
                // textRotationAngle + "\"");
	    // styleWriter.write(" style:text-rotation-scale=\"" +
                // textRotationScale + "\"");
	    if (underline != null) {
		styleWriter.write(" style:text-underline-type=\"" + underline
			+ "\"");
	    }
	    if (strikeThrough != null) {
		styleWriter.write(" style:text-line-through-type=\""
			+ strikeThrough + "\"");
	    }
	    styleWriter.write(">\n");
	    styleWriter.write("</style:text-properties>\n");
	    styleWriter.write("</style:style>\n");
	}

	return textSpanStyleName;
    }

}

