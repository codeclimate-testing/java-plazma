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

package org.plazmaforge.framework.datawarehouse.convert.dataimport.xml;




import org.plazmaforge.framework.core.datastorage.DSArrayDataSet;
import org.plazmaforge.framework.core.datastorage.DSField;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.core.type.TypeUtils;
import org.plazmaforge.framework.core.type.Types;
import org.plazmaforge.framework.datawarehouse.convert.dataimport.AbstractImporter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


/**
 * 
 * @author Oleh Hapon
 * $Id: XMLImporter.java,v 1.16 2010/12/05 07:51:30 ohapon Exp $
 */
public class XMLImporter extends AbstractImporter {

    
    public static final String DEFAULT_SELECT_EXPRESSION = ".";
    
    
    
    private List<String> columnNames = new ArrayList<String>();
    
    
    // the xml document
    private Document document;

    // the XPath select expression that gives the nodes to iterate
    private String selectExpression;

    // the node list
    private NodeList nodeList;

    // the node list length
    private int nodeListLength;

    // the current node
    private Node currentNode;

    // current node index
    private int currentNodeIndex = -1;

    private/* final */XPathExecuter xPathExecuter;
    
    
    
    public XMLImporter() {
	xPathExecuter = getXPathExecuter();
    }

    protected String getFileExt() {
	return ".xml";
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    
    protected void openInput() throws ApplicationException {
	this.document = createDocument();
	moveFirst();
    }
    
    protected Document createDocument(File file) throws ApplicationException {
	InputSource in = new InputSource(file.toURI().toASCIIString());
	
	// Disable setting encoding because you have to set encoding in XML file
	//<?xml version="1.0" encoding=windows-1251?>
			
	//String encodig = getEncoding();
	//if (!isEmpty(encodig)) {
	//    in.setEncoding(encodig);
	//}
	
	return XMLUtils.parse(in);
    }

    protected Document createDocument() throws ApplicationException {
	return createDocument(createFile());
    }

    protected void closeInput() throws ApplicationException {
	//do nothing
    }
    
    
    ////////////////////////////////////////////////////////////////////////////
    
    protected void importMetaData() throws ApplicationException {
	DSArrayDataSet dataSet = new DSArrayDataSet();
	setDataSet(dataSet);
    }
    
    
    protected void importBody() throws ApplicationException {
	DSArrayDataSet dataSet = (DSArrayDataSet) getDataSet();
	boolean initDataSetColumns = false;
	boolean firstRow = true;
	int columnCount = 0;
	List<Object[]> rows = new ArrayList<Object[]>();
	while (next()) {
	    
	    // Initialize columns
	    if (firstRow) {
		
		if (columnNames.isEmpty()) {
		    //loadDefaultColumns();
		}
		initDataSetColumns(dataSet);
		columnCount = dataSet.getFieldCount();
		initDataSetColumns = true;
		firstRow = false;
		
	    }
	    
	    if (firstRow) {
		break;
	    }
	    
	    Object values[] = new Object[columnCount];
	    for (int i = 0; i < columnCount; i++) {
		int columnIndex = i;
		DSField column = dataSet.getField(columnIndex);
		Object val = getValue(column.getName(), column.getDataType());
		values[i] =  val;
	    }
	    rows.add(values);
	    
	}
	
	if (!initDataSetColumns) {
	    initDataSetColumns(dataSet);
	}
	
	dataSet.setData(rows);
    }

    
    protected void initDataSetColumns(DSArrayDataSet dataSet) {
	List<DSField> columns = new ArrayList<DSField>();
	for (String c : columnNames) {
	    String columnName = c;

	    DSField column = new DSField();
	    column.setName(columnName);
	    column.setCaption(columnName);

	    //TODO: WHY!!!
	    column.setDataType(Types.StringType);

	    columns.add(column);
	}

	dataSet.setFields(columns);

    }    

    
    ////////////////////////////////////////////////////////////////////////////
    
    public String[] loadColumns() throws ApplicationException {
	if (isProcessingStarted()) {
	    throw new ApplicationException("Can not loading columns because process was started");
	}
	if (!isValid()) {
	    return new String[0];
	}
	init();
	
	openInput();
	
	moveFirst();
	if (!next()) {
	    return new String[0]; 
	}
	String[] columnNames = getColumnNamesByNodes();
	
	closeInput();
	
	return columnNames;
    }
    
    protected String[] getColumnNamesByNodes() {
	if(currentNode == null) {
	    return new String[0]; 
	}
	NodeList nodeList = currentNode.getChildNodes();
	int len = nodeList.getLength();
	List<String> names = new ArrayList<String>();
	String name = null;
	
	Map<String, Integer> columnGroupCountMap = new HashMap<String, Integer>();
	
	for (int i = 0; i < len; i++){
	    Node node = nodeList.item(i);
	    name = node.getNodeName();
	    if (name == null || name.startsWith("#")) {
		continue;
	    }
	    names.add(name);
	    Integer count = columnGroupCountMap.get(name);
	    if (count == null) {
		count = new Integer(0);
	    }
	    count++;
	    columnGroupCountMap.put(name, count);
	    
	}
	
	Map<String, Integer> columnCurrentGroupIndexMap = new HashMap<String, Integer>();
	
	for (int i = 0; i < names.size(); i++) {
	    String n = names.get(i);
	    Integer c = columnGroupCountMap.get(n);
	    if (c == null || c.intValue() <= 1) {
		continue;
	    }
	    Integer currentIndexInGroup = columnCurrentGroupIndexMap.get(n);
	    if (currentIndexInGroup == null) {
		currentIndexInGroup = new Integer(1); // XPath: Index start with 1 !!!
	    }
	    String fixName = n + "[" + currentIndexInGroup + "]";
	    names.set(i, fixName);
	    
	    currentIndexInGroup++;
	    columnCurrentGroupIndexMap.put(n, currentIndexInGroup);
	}
	
	return (String[]) names.toArray(new String[0]);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    
    
    public void moveFirst() throws ApplicationException {
	if (document == null) {
	    throw new ApplicationException("document cannot be null");
	}
	if (getSelectExpression() == null) {
	    throw new ApplicationException("selectExpression cannot be null");
	}
	currentNode = null;
	currentNodeIndex = -1;
	nodeListLength = 0;
	nodeList = xPathExecuter.selectNodeList(document, getSelectExpression());
	nodeListLength = nodeList.getLength();
    }

    public boolean next() {
	if (currentNodeIndex == nodeListLength - 1) {
	    return false;
	}
	currentNode = nodeList.item(++currentNodeIndex);
	return true;
    }

    
    
    public Object getValue(String expression, String type) throws ApplicationException {
	
	if (currentNode == null)
	    return null;

	if (expression == null || expression.length() == 0) {
	    return null;
	}

	
	if  (Types.ObjectType.equals(type)) {
	    return null;
	}

	Object value = null;

	Object selectedObject = xPathExecuter.selectObject(currentNode,
		expression);

	if (selectedObject != null) {
	    if (selectedObject instanceof Node) {
		String text = getText((Node) selectedObject);
		if (text != null) {
		    // value = convertByLocale(text, valueClass);
		    value = convert(text, type);
		}
	    } else if (selectedObject instanceof Boolean && type.equals(Types.BooleanType)) {
		value = selectedObject;
	    } else if (selectedObject instanceof Number && TypeUtils.isLikeNumberType(type)) {
		value = convertNumber((Number) selectedObject, type);
	    } else {
		String text = selectedObject.toString();
		// value = convertByLocale(text, valueClass);
		value = convert(text, type);
	    }
	}
	return value;
	
	
    }    
    
	
    /**
     * Creates a document using the current node as root.
     * 
     * @return a document having the current node as root
     * @throws ApplicationException
     */
    public Document subDocument() throws ApplicationException {
	if (currentNode == null) {
	    throw new ApplicationException("No node available. Iterate or rewind the data source.");
	}
	// create a new document from the current node
	Document doc = XMLUtils.createDocument(currentNode);
	return doc;
    }	
	

    /**
     * Return the text that a node contains. This routine:
     * <ul>
     * <li>Ignores comments and processing instructions.
     * <li>Concatenates TEXT nodes, CDATA nodes, and the results of recursively
     * processing EntityRef nodes.
     * <li>Ignores any element nodes in the sublist. (Other possible options are
     * to recurse into element sublists or throw an exception.)
     * </ul>
     * 
     * @param node a DOM node
     * @return a String representing node contents or null
     */
    public String getText(Node node) {
	
	if (!node.hasChildNodes()) {
	    return node.getNodeValue();
	}
	    
	StringBuffer result = new StringBuffer();

	NodeList list = node.getChildNodes();
	for (int i = 0; i < list.getLength(); i++) {
	    Node subnode = list.item(i);
	    if (subnode.getNodeType() == Node.TEXT_NODE) {
		String value = subnode.getNodeValue();
		if (value != null)
		    result.append(value);
	    } else if (subnode.getNodeType() == Node.CDATA_SECTION_NODE) {
		String value = subnode.getNodeValue();
		if (value != null)
		    result.append(value);
	    } else if (subnode.getNodeType() == Node.ENTITY_REFERENCE_NODE) {
		// Recurse into the subtree for text
		// (and ignore comments)
		String value = getText(subnode);
		if (value != null)
		    result.append(value);
	    }
	}

	return result.toString();
    }	
	
	
    protected static XPathExecuter getXPathExecuter() {
	XalanXPathExecuter executer = new XalanXPathExecuter();
	return executer;
    }    

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    public void setColumnNames(String[] columnNames) {
	if (isProcessingStarted()) {
	    throw new RuntimeException(getCannotModifyMessage());
	}
	if (columnNames == null) {
	    this.columnNames.clear();
	    return;
	}
	for (int i = 0; i < columnNames.length; i++)
	    this.columnNames.add(columnNames[i]);
    }

    public String[] getColumnNames() {
	return (String[]) this.columnNames.toArray(new String[0]);
    }

    public String getSelectExpression() {
	if (isEmpty(selectExpression)) {
	    return DEFAULT_SELECT_EXPRESSION;
	}
        return selectExpression;
    }

    public void setSelectExpression(String selectExpression) {
        this.selectExpression = selectExpression;
    }


    
}
