package org.plazmaforge.bsolution.document.client.swing.forms;


import javax.swing.*;

import org.plazmaforge.bsolution.base.client.swing.forms.SystemEntityList;
import org.plazmaforge.bsolution.document.client.swing.GUIDocumentEnvironment;
import org.plazmaforge.bsolution.document.common.beans.DocumentType;
import org.plazmaforge.bsolution.document.common.services.DocumentTypeService;
import org.plazmaforge.framework.client.swing.controls.XComboEdit;
import org.plazmaforge.framework.client.swing.controls.XTextField;
import org.plazmaforge.framework.client.swing.forms.EXTEditForm;
import org.plazmaforge.framework.client.swing.gui.GridBagPanel;
import org.plazmaforge.framework.config.object.EntityConfig;
import org.plazmaforge.framework.core.exception.ApplicationException;

import java.awt.*;

/**
 * @author Oleh Hapon
 * Date: 03.06.2006
 * Time: 11:45:59
 * $Id: DocumentTypeEdit.java,v 1.2 2010/12/05 07:56:45 ohapon Exp $
 */
public class DocumentTypeEdit extends EXTEditForm {

    private JLabel entityLabel;
    private JLabel documentSectionLabel;
    private JLabel documentCategoryLabel;

    private XComboEdit entityComboEdit;
    private XTextField documentSectionField;
    private XTextField documentCategoryField;


    public DocumentTypeEdit() {
        super(GUIDocumentEnvironment.getResources());
        initialize();
    }

    private void initialize() {
        this.setEntityClass(DocumentType.class);
        this.setEntityServiceClass(DocumentTypeService.class);
    }

    protected void initComponents() throws ApplicationException {

        setTitle(getString("title"));
        entityLabel = new JLabel(getString("panel.label-entity.text"));
        documentSectionLabel = new JLabel(getString("panel.label-document-section.text"));
        documentCategoryLabel = new JLabel(getString("panel.label-document-category.text"));

        entityComboEdit = new XComboEdit();
        documentSectionField = new XTextField(20);
        documentSectionField.setMaxChar(20);
        documentCategoryField = new XTextField(50);
        documentCategoryField.setMaxChar(50);


        GridBagPanel editPanel = new GridBagPanel();
        GridBagConstraints gbc = editPanel.getGridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;

        editPanel.add(entityLabel);
        editPanel.addByY(documentSectionLabel);
        editPanel.addByY(documentCategoryLabel);

        gbc.gridy = 0;
		gbc.gridwidth = 1;
        editPanel.addByX(entityComboEdit);
        editPanel.addByY(documentSectionField);
        editPanel.addByY(documentCategoryField);

        entityComboEdit.initListFormAction(this, SystemEntityList.class);

        add(editPanel);
    }


    private DocumentType getDocumentType() {
        return (DocumentType) this.getEntity();
    }

    protected void updateView() throws ApplicationException {

        appendTitle(getDocumentType().getName());
        entityComboEdit.setValue(getDocumentType().getEntity());
        documentSectionField.setText(getDocumentType().getDocumentSection());
        documentCategoryField.setText(getDocumentType().getDocumentCategory());

    }


    protected void populateData() throws ApplicationException {
        getDocumentType().setEntity((EntityConfig) entityComboEdit.getValue());
        getDocumentType().setDocumentSection(documentSectionField.getText());
        getDocumentType().setDocumentCategory(documentCategoryField.getText());
    }

    protected void validateData() throws ApplicationException {
        super.validateData();
        StringBuffer buf = new StringBuffer();
        validateRequiredField(buf, getDocumentType().getEntity(), entityLabel.getText());
        checkError(buf);
    }

}
