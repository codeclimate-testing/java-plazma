package org.plazmaforge.bsolution.base.client.swt.dialogs;

import java.util.Locale;
import java.util.Properties;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.plazmaforge.framework.app.AppConfigurer;
import org.plazmaforge.framework.app.AppEnvironment;
import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.util.LocalePartInfo;
import org.plazmaforge.framework.util.LocaleRepository;
import org.plazmaforge.framework.xml.XMLProperties;

public class GeneralPanel extends DialogItemPanel {

    private Combo countryField;
    private Combo languageField;
    
    private LocalePartInfo[] countries;
    private LocalePartInfo[] languages;
    
    public GeneralPanel(Composite parent, String title) {
	super(parent, title);
    }

    protected PropertyManager createPropertyManager() {
	String fileName = AppEnvironment.getRootConfigFileName(AppEnvironment.getApplicationConfigFile());
	return createPropertyManager(fileName);
    }

    
    public void loadData() {
	loadProperties();
	updateControls();
    }
    
    public void storeData() {
	updateData();
	storeProperties();
    }
    
    protected void updateControls() {
	// We get locale from Default locale because we set locale by 'locale' property  
	Locale locale = Locale.getDefault();
	String country = locale.getCountry();
	String language = locale.getLanguage();
	
	int countryIndex = LocaleRepository.indexOfName(country, countries);
	int languageIndex = LocaleRepository.indexOfName(language, languages);
	
	if (countryIndex > -1) {
	    countryField.select(countryIndex);
	}
	if (languageIndex > -1) {
	    languageField.select(languageIndex);
	}
	
    }
    
    protected void updateData() {
	
	String country = null;
	String language = null;

	int countryIndex = countryField.getSelectionIndex();
	int languageIndex = languageField.getSelectionIndex();
	if (countryIndex > -1) {
	    country = countries[countryIndex].getName();
	}
	if (languageIndex > -1) {
	    language = languages[languageIndex].getName();
	}
	
	
	String locale = null;
	if (language.length() > 0) {
	    locale = language; 
	}
	if (country.length() > 0) {
	    locale = (locale == null) ? country : (locale + "_" + country);
	}
	if (locale == null) {
	    locale = Locale.getDefault().toString();
	}
	getProperties().setProperty("locale", locale);
	
    }
    
    
    protected Composite createDialogContent(Composite parent) {
	Composite content = super.createContent(parent);
	GridLayout layout = new GridLayout();
	layout.numColumns = 2;
	content.setLayout(layout);
	
	countries = LocaleRepository.getCountries(true);
	languages = LocaleRepository.getLanguages(true);
	 
	countryField = addComboField(content, Messages.getString("ConfigPanel.general.country"), 200);
	languageField = addComboField(content, Messages.getString("ConfigPanel.general.language"));
	
	populateComboField(countryField, countries);
	populateComboField(languageField, languages);
	
	
	return content;
    }
    
 
    
    protected void createContent() {
	createDialogContent(this);
    }
    
    
    protected PropertyManager createPropertyManager(String fileName) {
	PropertyManager propertyManager = new XMLPropertyManager(fileName, true);
	return propertyManager;
    }

    
    
    class XMLPropertyManager extends PropertyManager {
	
	public XMLPropertyManager() {
	    super();
	}

	public XMLPropertyManager(String fileName, boolean forceCreateFile) {
	    super(fileName, forceCreateFile);
	}

	public XMLPropertyManager(String fileName) {
	    super(fileName);
	}

	public Properties createProperties() {
	    return new XMLProperties();
	}
	
	
	public void load() throws ApplicationException {
		try {
		    XMLProperties properties = AppConfigurer.loadProperties(getFileName());
		    setProperties(properties);
		} catch (Exception e) {
		    throw new ApplicationException(e);
		}
	    }

	    public void store() throws ApplicationException {
		try {
		    ((XMLProperties) getProperties()).store(getFileName());
		} catch (Exception e) {
		    throw new ApplicationException(e);
		}
	    }
    }
    
}
