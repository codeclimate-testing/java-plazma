package org.plazmaforge.framework.datawarehouse.convert.dataimport.xml;

import javax.xml.transform.TransformerException;
import org.apache.xpath.CachedXPathAPI;
import org.apache.xpath.objects.XObject;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XalanXPathExecuter implements XPathExecuter {

    // XPath API facade
    private CachedXPathAPI xpathAPI = new CachedXPathAPI();

    /**
     * Default constructor.
     */
    public XalanXPathExecuter() {
    }

    public NodeList selectNodeList(Node contextNode, String expression)
	    throws ApplicationException {
	try {
	    return xpathAPI.selectNodeList(contextNode, expression);
	} catch (TransformerException e) {
	    throw new ApplicationException("XPath selection failed. Expression: " + expression, e);
	}
    }

    public Object selectObject(Node contextNode, String expression) throws ApplicationException {
	try {
	    Object value;
	    XObject object = xpathAPI.eval(contextNode, expression);
	    switch (object.getType()) {
	    case XObject.CLASS_NODESET:
		value = object.nodeset().nextNode();
		break;
	    case XObject.CLASS_BOOLEAN:
		value = object.bool() ? Boolean.TRUE : Boolean.FALSE;
		break;
	    case XObject.CLASS_NUMBER:
		value = new Double(object.num());
		break;
	    default:
		value = object.str();
		break;
	    }
	    return value;
	} catch (TransformerException e) {
	    throw new ApplicationException("XPath selection failed. Expression: " + expression, e);
	}
    }

}
