THE PLAZMA ERP + CRM SOLUTION, release {version} ({build.month} {build.year})
-------------------------------------------------------------------------------------------------
http://plazma.sourceforge.net

Lite Server type.



Содержимое инсталляции:


  conf - Configuration files
  db - Database files
  dist - Plazma JAR files
  docs - Documentation files
  fonts - Fonts for PDF export (UNICODE)
  lib - JAR files
  logs - LOG files
  reports - Report files

  start_server.bat - Командный bat файл запуска сервера (Windows)
  start_server.sh - Командный shell файл запуска сервера (Linux)
  unsinstall.bat - Командный bat файл деинсталляции (Windows)
  uninstall.sh - Файл системных свойств (Linux)

  plazma.properties - Файл системных свойств


Запуск:

  Для старта Lite сервера необходимо выполнить командный файл:


  Windows
  -------

  start_server.bat


  Linux
  -----

  start_server.sh


  
  Демо пользователь
  -----------------
  Login/Password:

  admin/test		SUPERVISOR

  
Конфигурация:

  База данных
  -----------
  
  В файле <PlazmaServer>/conf/jdbc.properties Вы можете изменить свойства подключения к базе данных
      
  SQL скрипты для создания базы данных размещены в папке <PlazmaServer>/db/script/createdb/<производитель базы данных>/<язык>. 
  Например: <Plazma>/script/createdb/firebird/ru
  
  create_plazma_db_demo.sql - демонстрационная база данных
  create_plazma_db.sql - рабочая база данных
  

  