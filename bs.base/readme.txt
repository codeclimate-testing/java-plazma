THE PLAZMA ERP + CRM SOLUTION, release {version} ({build.month} {build.year})
-------------------------------------------------------------------------------------------------
http://plazma.sourceforge.net

Lite Server type.



Release contents:


  conf - Configuration files
  db - Database files
  dist - Plazma JAR files
  docs - Documentation files
  fonts - Fonts for PDF export (UNICODE)
  lib - JAR files
  logs - LOG files
  reports - Report files

  start_server.bat - Start server bat file (Windows)
  start_server.sh - Start server shell file (Linux)
  unsinstall.bat	- Uninstall bat file (Windows)
  uninstall.sh - Uninstall shell file (Linux)

  plazma.properties - System properties file


Start up:

  Lite server can be started by executing the following commands:


  Windows
  -------

  start_server.bat


  Linux
  -----

  start_server.sh


  
  Demo user
  ---------
  Login/Password:

  admin/test		SUPERVISOR

  
Configuration:

  You can change <PlazmaServer>/conf/jdbc.properties file to configure database connection.
    
  SQL scrips for create database locate in <PlazmaServer>/db/script/createdb/<database vendor>/<language> folder. 
  For example: <Plazma>/db/script/createdb/firebird/en
    
  create_plazma_db_demo.sql - demo database
  create_plazma_db.sql - live database

  