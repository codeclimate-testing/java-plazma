THE PLAZMA ERP + CRM SOLUTION, {version} ({build.month} {build.year})
-------------------------------------------------------------------------------------------------
http://plazma.sourceforge.net

Содержимое инсталляции:


  conf - Файлы конфигурации
  db - Файлы баз данных
  dist - Plazma JAR файлы
  docs - Документация
  fonts - Шрифты для экспорта в PDF (UNICODE)
  lib - JAR файлы
  logs - LOG файлы
  reports - Отчёты

  plazma.bat - Командный bat файл запуска (Windows)
  plazma.sh - Командный shell файл запуска (Linux)
  unsinstall.bat - Командный bat файл деинсталляции (Windows)
  uninstall.sh - Командный shell файл деинсталляции (Linux)

  launcher.bat - Launcher bat файл (Windows)
  launcher.sh - Launcher shell файл (Linux)
  launcher.jar - Launcher JAR файл
  plazma.conf - Файл конфигурации (только для launcher варианта)
  plazma.classpath - Classpath файл (только для launcher варианта)
  plazma.properties - Файл системных свойств


Запуск:


  Для запуска приложения необходимо выполнить следующие команды:


  Windows
  -------
     
  plazma.bat
     
  или
     
  java -Djava.library.path="lib\swt\win32" -jar launcher.jar plazma
     
  или выбрать пункт меню  Пуск -> Программы -> Plazma ERP+CRM <версия> -> Plazma ERP+CRM


  Linux
  -----
     
  plazma.sh
     
  или
     
  java -Djava.library.path="lib/swt/linux-gtk" -jar launcher.jar plazma




  Демо пользователь
  -----------------
  Login/Password:

  admin/test		SUPERVISOR
  

  
Конфигурация:

			Только для Standalone
			
  Демо режим
  ----------

  Для запуска программы в демо режиме необходимо указать флаг -demo в строчке запуска, например:
  java -jar launcher.jar plazma -demo 

  или установить в файле plazma.properties свойство plazma.platform.demo, например:
  plazma.platform.demo = true

  При запуске программы в демо режиме будет произведено подключение к демострационной базе данных.
  Приоритет флага -demo выше чем свойства plazma.platform.demo 

  Включить/выключить режим автоматической установки логина и пароля по умолчанию, можно путём редактирования
  свойства plazma.platform.autologin, например:
  plazma.platform.autologin = true

  
  База данных
  -----------
  
  В файле <Plazma>/conf/jdbc.properties Вы можете изменить свойства подключения к базе данных.
    
  SQL скрипты для создания базы данных размещены в папке <Plazma>/db/script/createdb/<производитель базы данных>/<язык>. 
  Например: <Plazma>/db/script/createdb/firebird/ru
  
  create_plazma_db_demo.sql - демонстрационная база данных
  create_plazma_db.sql - рабочая база данных
   
  
