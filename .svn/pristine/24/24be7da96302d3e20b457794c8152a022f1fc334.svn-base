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
 * Created on 03.05.2007
 *
 */

package org.plazmaforge.framework.liteserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.BindException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.plazmaforge.framework.core.exception.ApplicationException;
import org.plazmaforge.framework.platform.service.Initializer;
import org.plazmaforge.framework.platform.service.impl.DefaultInitializer;



/** 
 * @author Oleh Hapon
 * $Id: Server.java,v 1.3 2010/12/05 07:51:27 ohapon Exp $
 */

public class Server {
    
    public static String DEFAULT_SHUTDOWN_COMMAND = "SHUTDOWN";
    
    public static int DEFAULT_COMMAND_PORT = 2007; 

    public void init() throws ApplicationException {
	Initializer intializer = new DefaultInitializer();
	intializer.init();
    }
    
    
    public void start(String expectedCommand, int port) throws IOException {
	
        final String localHostName = "localhost";
        final String localHostIP = "127.0.0.1";

        if (expectedCommand == null) {
            throw new IllegalArgumentException("Expected command for shutdown on the local server must be not null.");
        }

        ServerSocket listenSocket = null;
        boolean shouldShoutdown = false;
        try {
            listenSocket = new ServerSocket();
            InetSocketAddress localAddr = new InetSocketAddress(localHostName, port);
            InetAddress addr = localAddr.getAddress();
            if (!localHostIP.equals(addr.getHostAddress())) {
                throw new BindException() {
                    public String toString() {
                        return "The host name \'localhost\' have to correspond the 127.0.0.1 IP address.";
                    }

                    public String getMessage() {
                        return toString();
                    }

                    public String getLocalizedMessage() {
                        return getMessage();
                    }
                };
            }
            listenSocket.setReuseAddress(true);
            listenSocket.bind(localAddr);
            //logger.info("The Plazma Server started listen for incoming control commands at port: " + port);
            System.out.println("The Plazma Server started listen for incoming control commands at port: " + port);
            System.out.println("From command line, use -commandport argument to set command port and [Ctrl]+[C] to abort abruptly");
            
            
            while (!shouldShoutdown) {
                Socket acceptedSocket = listenSocket.accept();
                PrintWriter out = null;
                BufferedReader inReader = null;
                try {
                    out = new PrintWriter(acceptedSocket.getOutputStream(), true);
                    if (false /*!isShutdonEnabled()*/) {
                        out.println("The shutdown server operation is disabled.");
                    } else {
                        if (localHostIP.equals(acceptedSocket.getInetAddress().getHostAddress())
                                || localHostName.equals(acceptedSocket.getInetAddress().getHostName())) {
                            out.println("Type \"" + expectedCommand + "\" command to stop Plazma Server...");
                            inReader = new BufferedReader(new InputStreamReader(acceptedSocket.getInputStream()));
                            while (!shouldShoutdown) {
                                String incomingCommand = inReader.readLine();
                                shouldShoutdown = expectedCommand.equalsIgnoreCase(incomingCommand);
                                if (!shouldShoutdown) {
                                    out.println("Invalid command. Try again...");
                                }
                            }
                            out.println("The Plazma Server will be shuted down...");
                            //logger.info("The Plazma Server was shuted down...");
                        } else {
                            out.println("Connection rejected: disallowed host - ["
                                    + acceptedSocket.getInetAddress().getHostAddress() + "]. Closing connection...");
                        }
                    }
                } finally {
                    if (out != null) {
                        out.close();
                    }
                    if (inReader != null) {
                        inReader.close();
                    }
                    if (acceptedSocket != null) {
                        acceptedSocket.close();
                    }
                }
            }
        } finally {
            if (listenSocket != null) {
                listenSocket.close();
            }
        }
    }

    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
	try {
	    int commandPort = DEFAULT_COMMAND_PORT; 
	    boolean useCommandListener = true;
	    
	    boolean hasCommandPort = false;
	    for (String arg : args) {
		
		if ("-commandport".equals(arg)) {
		    hasCommandPort = true;
		    continue;
		}
		
		if (hasCommandPort) {
		    hasCommandPort = false;
		    if ("none".equals(arg)) {
			useCommandListener = false;
		    } else {
			try {
			    commandPort = Integer.valueOf(arg);
			} catch (NumberFormatException e) {
			    //
			}
		    }
		}
	    }
	    
	    Server server = new Server();
	    server.init();
	    
	    if (useCommandListener) {
		server.start(DEFAULT_SHUTDOWN_COMMAND, commandPort);
	    }
	    
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

}
