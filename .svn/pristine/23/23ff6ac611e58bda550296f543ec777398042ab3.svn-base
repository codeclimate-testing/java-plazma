package org.plazmaforge.framework.client.swt.help;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Shell;
import org.plazmaforge.framework.client.help.HelpProvider;
import org.plazmaforge.framework.client.help.HelpSystem;


public class SWTHelpProvider implements HelpProvider {

    public void displayHelp() {
	try {
	    HelpBrowser browser = createHelpBrowser();
	    browser.open();
	} catch (Exception ex) {
	    String url = HelpSystem.getHelpUrl();
	    Program.launch(url);
	}
    }
    
    public void displayHelpTopic(String topicId) {
	MessageDialog.openInformation(null, "Help", "Help Topic is not support");
    }

    
    private HelpBrowser createHelpBrowser() {
	HelpBrowser browser = new HelpBrowser((Shell)null);
	return browser;
    }
}
