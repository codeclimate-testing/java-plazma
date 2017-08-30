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

package org.plazmaforge.framework.launcher;

import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Properties;

public class Startup {

    private final static String DEFAULT_CONF = "plazma";

    private final static String DEFAULT_CONF_FILE_SUFFIX = ".conf";

    private final static String DEFAULT_CONF_FILE = DEFAULT_CONF + DEFAULT_CONF_FILE_SUFFIX;

    private final static String MAIN_CLASS_PROP = "MainClass";

    public static void main(String[] args) {
	if (args.length == 0) {
	    System.err.println("Argument not found!\n");
	    System.err.println();
	    System.err.println("Command line:");
	    System.err.println("java -jar launcher.jar [config_file]");
	    System.err.println("[config_file] - name of config file\n");
	    System.err.println();
	    System.err.println("Example:");
	    System.err.println("java -jar launcher.jar plazma\n");
	    System.err.println("java -jar launcher.jar plazma.conf\n");
	    System.err.println();
	    System.err.println("plazma.conf:");
	    System.err.println("-----------------------------------------------");
	    System.err.println("MainClass=com.mypackage.MainClass");
	    return;
	}
	try {
	    String confName = args[0];
	    String confFile = null;

	    if (confName == null) {
		confName = DEFAULT_CONF;
		confFile = DEFAULT_CONF_FILE;
	    } else if (confName.indexOf('.') < 0) {
		confFile = confName + DEFAULT_CONF_FILE_SUFFIX;
	    }

	    FileInputStream is = new FileInputStream(confFile);
	    Properties prop = new Properties();
	    prop.load(is);
	    String mainClass = prop.getProperty(MAIN_CLASS_PROP);
	    if (mainClass == null) {
		throw new Exception(MAIN_CLASS_PROP + " not found!");
	    }

	    Startup startup = new Startup();
	    ClassLoader cl = startup.createClassLoader(confName + ".classpath");

	    Class launcherClass = Class.forName(mainClass, true, cl);
		    
	    Method startMethod = launcherClass.getDeclaredMethod("main", new Class[] { String[].class });

	    startMethod.invoke(null, new Object[] { args });

	    // int returnValue = ((Integer)startMethod.invoke(null, new
            // Object[]{ args })).intValue();
	    // Always exit cleanly after invoking the start() method
	    // System.exit(returnValue);

	} catch (Exception ex) {
	    ex.printStackTrace();

	}
    }

    private ClassLoader createClassLoader(String classpathFile) {
	try {
	    File file = new File(classpathFile);
	    if (!file.exists()) {
		System.out.println("Classpath file [" + classpathFile
			+ "] not found.");
		return null;
	    }
	    BufferedReader reader = new BufferedReader(new FileReader(file));

	    Classpath classPath = new Classpath(System.getProperty("java.class.path"));

	    String line = null;
	    while (reader.ready()) {
		line = reader.readLine();
		if (line != null) {
		    line = line.trim();
		    if (line.startsWith("#")) {
			continue;
		    }
		    classPath.addComponent(line);
		}
	    }
	    System.setProperty("java.class.path", classPath.toString());

	    ClassLoader classLoader = classPath.getClassLoader();
	    Thread.currentThread().setContextClassLoader(classLoader);

	    return classLoader;
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return null;
    }

}
