package org.plazmaforge.framework.datawarehouse.convert.dataexport.odt;

import java.io.IOException;
import java.io.Writer;
import java.util.List;


public class StyleBuilder {

    private List reportList = null;

    private Writer writer = null;

    public StyleBuilder(List reportList, Writer writer) {
	this.reportList = reportList;
	this.writer = writer;
    }

    public void build() throws IOException {
	buildBeforeAutomaticStyles();

	//for(int reportIndex = 0; reportIndex < reportList.size(); reportIndex++)	{
	buildPageLayout(0, Constants.ORIENTATION_PORTRAINT, 0 /*210*/, 0 /*297*/); // TODO

	buildBetweenAutomaticAndMasterStyles();

	//for(int reportIndex = 0; reportIndex < reportList.size(); reportIndex++)
	buildMasterPage(0);

	buildAfterMasterStyles();

	writer.flush();
    }

    private void buildBeforeAutomaticStyles() throws IOException {
	writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");

	writer.write("<office:document-styles");
	writer.write(" xmlns:office=\"urn:oasis:names:tc:opendocument:xmlns:office:1.0\"");
	writer.write(" xmlns:style=\"urn:oasis:names:tc:opendocument:xmlns:style:1.0\"");
	writer.write(" xmlns:text=\"urn:oasis:names:tc:opendocument:xmlns:text:1.0\"");
	writer.write(" xmlns:table=\"urn:oasis:names:tc:opendocument:xmlns:table:1.0\"");
	writer.write(" xmlns:draw=\"urn:oasis:names:tc:opendocument:xmlns:drawing:1.0\"");
	writer.write(" xmlns:fo=\"urn:oasis:names:tc:opendocument:xmlns:xsl-fo-compatible:1.0\"");
	writer.write(" xmlns:xlink=\"http://www.w3.org/1999/xlink\"");
	writer.write(" xmlns:dc=\"http://purl.org/dc/elements/1.1/\"");
	writer.write(" xmlns:meta=\"urn:oasis:names:tc:opendocument:xmlns:meta:1.0\"");
	writer.write(" xmlns:number=\"urn:oasis:names:tc:opendocument:xmlns:datastyle:1.0\"");
	writer.write(" xmlns:svg=\"urn:oasis:names:tc:opendocument:xmlns:svg-compatible:1.0\"");
	writer.write(" xmlns:chart=\"urn:oasis:names:tc:opendocument:xmlns:chart:1.0\"");
	writer.write(" xmlns:dr3d=\"urn:oasis:names:tc:opendocument:xmlns:dr3d:1.0\"");
	writer.write(" xmlns:math=\"http://www.w3.org/1998/Math/MathML\"");
	writer.write(" xmlns:form=\"urn:oasis:names:tc:opendocument:xmlns:form:1.0\"");
	writer.write(" xmlns:script=\"urn:oasis:names:tc:opendocument:xmlns:script:1.0\"");
	writer.write(" xmlns:ooo=\"http://openoffice.org/2004/office\"");
	writer.write(" xmlns:ooow=\"http://openoffice.org/2004/writer\"");
	writer.write(" xmlns:oooc=\"http://openoffice.org/2004/calc\"");
	writer.write(" xmlns:dom=\"http://www.w3.org/2001/xml-events\"");
	writer.write(" xmlns:xforms=\"http://www.w3.org/2002/xforms\"");
	writer.write(" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"");
	writer.write(" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
	writer.write(" office:version=\"");
	writer.write(ContentBuilder.VERSION);
	writer.write("\">\n");

	writer.write(" <office:styles>\n");
	writer.write("<draw:stroke-dash draw:name=\"Dashed\" draw:display-name=\"Dashed\" "
			+ "draw:style=\"rect\" draw:dots1=\"1\" draw:dots1-length=\"0.05cm\" draw:dots2=\"1\" "
			+ "draw:dots2-length=\"0.05cm\" draw:distance=\"0.05cm\"/>");
	writer.write(" </office:styles>\n");
	writer.write(" <office:automatic-styles>\n");
    }

    private void buildBetweenAutomaticAndMasterStyles() throws IOException {
	writer.write(" </office:automatic-styles>\n");
	writer.write(" <office:master-styles>\n");
    }

    private void buildAfterMasterStyles() throws IOException {
	writer.write(" </office:master-styles>\n");
	writer.write("</office:document-styles>\n");
    }

    private void buildPageLayout(int reportIndex, byte orientation, int pageWidth, int pageHeight) throws IOException {
	writer.write("<style:page-layout");
	writer.write(" style:name=\"page_" + reportIndex + "\">\n");

	writer.write("<style:page-layout-properties");
	if (pageWidth > 0) {
	    writer.write(" fo:page-width=\""  + Utils.translatePixelsToInchesRound(pageWidth) + "in\"");  
	}
	if (pageHeight > 0) {
	    writer.write(" fo:page-height=\"" + Utils.translatePixelsToInchesRound(pageHeight) + "in\"");//FIXMEODT we probably need some actualHeight trick  
	}

	// TODO: Static margin 
	double margin = Utils.translatePixelsToInchesRound(40);
	
	writer.write(" fo:margin-top=\"0" + margin + "in\"");
	writer.write(" fo:margin-bottom=\"0" + margin + "in\"");
	writer.write(" fo:margin-left=\"0" + margin + "in\"");
	writer.write(" fo:margin-right=\"0" + margin + "in\"");

	switch (orientation) {
	case Constants.ORIENTATION_LANDSCAPE:
	    writer.write(" style:print-orientation=\"landscape\"");
	    break;
	default:
	    writer.write(" style:print-orientation=\"portrait\"");
	    break;
	}

	writer.write("/>\n");
	writer.write("</style:page-layout>\n");
    }

    private void buildMasterPage(int reportIndex) throws IOException {
	writer.write("<style:master-page style:name=\"master_");
	writer.write(String.valueOf(reportIndex));
	writer.write("\" style:page-layout-name=\"page_");
	writer.write(String.valueOf(reportIndex));
	writer.write("\"/>\n");
    }

}
