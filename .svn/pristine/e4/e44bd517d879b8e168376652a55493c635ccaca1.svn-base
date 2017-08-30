package org.plazmaforge.framework.client.help;

/**
 * The Help System
 * 
 * @author ohapon
 * $Id: HelpSystem.java,v 1.1 2008/11/26 14:38:41 ohapon Exp $
 */
public class HelpSystem {

    private static String helpSite;
    
    private static String helpUrl;
    
    private static HelpProvider helpProvider; 
    
    public static void displayHelp() {
	if (getHelpProvider() == null) {
	    return;
	}
	getHelpProvider().displayHelp();
    }
    
    
    public static void displayHelpTopic(String topicId) {
	if (getHelpProvider() == null) {
	    return;
	}
	getHelpProvider().displayHelpTopic(topicId);
    }


    public static HelpProvider getHelpProvider() {
        return helpProvider;
    }


    public static void setHelpProvider(HelpProvider helpProvider) {
        HelpSystem.helpProvider = helpProvider;
    }


    public static String getHelpSite() {
        return helpSite;
    }


    public static void setHelpSite(String helpSite) {
        HelpSystem.helpSite = helpSite;
    }


    public static String getHelpUrl() {
        return helpUrl;
    }


    public static void setHelpUrl(String helpUrl) {
        HelpSystem.helpUrl = helpUrl;
    }
    
    
    
  
}
