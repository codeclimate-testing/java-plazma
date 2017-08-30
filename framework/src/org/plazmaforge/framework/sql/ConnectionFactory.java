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

/*
 * Created on 05.08.2003
 *
 */
package org.plazmaforge.framework.sql;

import javax.naming.NamingException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.plazmaforge.framework.util.ClassUtilsExt;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 * @author Oleh Hapon
 */

public class ConnectionFactory {

    
    public static Connection getJNDIConnection(String dataSourceName) throws NamingException, SQLException {
		
        /*
        Properties p = new Properties();

        p.put("java.naming.factory.initial", "org.openejb.client.LocalInitialContextFactory");
        p.put("openejb.home", "d:\\openejb");

        Context context = new InitialContext(p);
        */

        Context context = new InitialContext();
        DataSource ds = (DataSource) context.lookup(dataSourceName);
        return ds.getConnection();
    }

  

    /*
    public static Connection getDriverConnection() throws ClassNotFoundException, SQLException {
        if (!loadDBProp) {
            String dbPath = System.getProperty(DAOEnvironment.DB_PROPERTIES_PATH, System.getProperty("user.dir"));
            String dbFile = System.getProperty(DAOEnvironment.DB_PROPERTIES_FILE, "jdbc.properties");
            Properties props = new Properties();
            try {
                props.load(new FileInputStream(new File(dbPath, dbFile)));
            } catch (IOException ioex) {

            }
            driver = props.getProperty("jdbc.driver");
            url = props.getProperty("jdbc.url");
            user = props.getProperty("jdbc.user");
            password = props.getProperty("jdbc.password");
            loadDBProp = true;
        }

        return getDriverConnection(driver, url, user, password);
    }
    */


    /**
     * Getter Connection
     * @param driver
     * @param url
     * @param user
     * @param password
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getDriverConnection(String driver, String url, String user, String password) throws ClassNotFoundException, SQLException {
        ClassUtilsExt.forName(driver);
        return DriverManager.getConnection(url, user, password);
    }

    public static Connection getConnection(String driver, String url, String user, String password) throws ClassNotFoundException, SQLException {
        return getDriverConnection(driver, url, user, password);
    }



}
