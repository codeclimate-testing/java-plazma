package org.plazmaforge.framework.datawarehouse.convert.dataimport.xml;

import org.plazmaforge.framework.core.exception.ApplicationException;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public interface XPathExecuter {

    /**
     * Selects a node list by evaluating an XPath expression on a context node.
     * 
     * @param contextNode the context node (a document can also be used)
     * @param expression the XPath expression
     * @return the selected node list
     * @throws ApplicationException if the XPath evaluation failed
     */
    NodeList selectNodeList(Node contextNode, String expression) throws ApplicationException;

    /**
     * Selects an object by evaluating an XPath expression on a context node.
     * <p/>
     * If the expression evaluates to a node list, the first node in the list
     * should be returned. Otherwise, the primitive value resulted from the
     * evaluation should be returned as a <code>java.lang.String</code>,
     * <code>java.lang.Number</code> or <code>java.lang.Boolean</code>.
     * 
     * @param contextNode the context node (a document can also be used)
     * @param expression the XPath expression
     * @return the selected node or value
     * @throws ApplicationException if the XPath evaluation failed
     */
    Object selectObject(Node contextNode, String expression) throws ApplicationException;
    
    
}
