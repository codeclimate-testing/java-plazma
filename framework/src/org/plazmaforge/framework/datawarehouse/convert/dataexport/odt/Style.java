
package org.plazmaforge.framework.datawarehouse.convert.dataexport.odt;

import java.io.IOException;
import java.io.Writer;


public abstract class Style {

    protected Writer styleWriter = null;

    public Style(Writer styleWriter) {
	this.styleWriter = styleWriter;
    }

    public abstract String getId();

    public abstract void write(String styleName) throws IOException;

}

