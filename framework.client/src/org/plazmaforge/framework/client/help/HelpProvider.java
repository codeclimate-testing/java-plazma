package org.plazmaforge.framework.client.help;

/**
 * The interface provides help
 * @author ohapon
 * $Id: HelpProvider.java,v 1.1 2008/11/26 14:38:41 ohapon Exp $
 */
public interface HelpProvider {

    
    /**
     * Display help
     *
     */
    void displayHelp();
    
    /**
     * Display topic of help
     * @param topicId
     */
    void displayHelpTopic(String topicId);
    

}
