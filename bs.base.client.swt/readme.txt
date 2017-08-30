THE PLAZMA ERP + CRM SOLUTION, {version} ({build.month} {build.year})
-------------------------------------------------------------------------------------------------
http://plazma.sourceforge.net

Release contents:


  conf - Configuration files
  db - Database files
  dist - Plazma JAR files
  docs - Documentation files
  fonts - Fonts for PDF export (UNICODE)
  lib - JAR files
  logs - LOG files
  reports - Report files

  plazma.bat - Start bat file (Windows)
  plazma.sh - Start shell file (Linux)
  unsinstall.bat	- Uninstall bat file (Windows)
  uninstall.sh - Uninstall shell file (Linux)

  launcher.bat - Launcher bat file (Windows)
  launcher.sh - Launcher shell file (Linux)
  launcher.jar - Launcher JAR archive
  plazma.conf - Configuration file (Only for launcher variant)
  plazma.classpath - Classpath file (Only for launcher variant)
  plazma.properties - System properties file


Start up:

  Application can be started by executing the following commands:

  Windows 
  -------
 
  plazma.bat
 
  or
 
  java -Djava.library.path="lib\swt\win32" -jar launcher.jar plazma
     
  or you can click Start -> Programs -> Plazma ERP+CRM <version> -> Plazma ERP+CRM menu.
 
 
 
  Linux
  -----
 
  plazma.sh
 
  or
 
  java -Djava.library.path="lib/swt/linux-gtk" -jar launcher.jar plazma




  Demo user
  ---------
  Login/Password:

  admin/test		SUPERVISOR
  

  
Configuration:

  					Only for Standalone
  
  Demo mode 
  ---------

  You can use -demo argument in command line for set demo mode:
  java -jar launcher.jar plazma -demo 

  or you can set plazma.platform.demo property in plazma.properties file. 
  For example: plazma.platform.demo = true

  The demo mode uses demo database. The -demo flag is higher priority than plazma.platform.demo property.

  You can set autologin mode too.
  For example: plazma.platform.autologin = true
  
  
  Database connection
  -------------------
  
  You can change <Plazma>/conf/jdbc.properties file to configure database connection.
  
  SQL scrips for create database locate in <Plazma>/db/script/createdb/<database vendor>/<language> folder. 
  For example: <Plazma>/db/script/createdb/firebird/en
  
  create_plazma_db_demo.sql - demo database
  create_plazma_db.sql - live database
   
  
