THE PLAZMA ERP + CRM SOLUTION, release {version} ({build.month} {build.year})
-------------------------------------------------------------------------------------------------
http://plazma.sourceforge.net

���������� �����������:


  conf - ����� ������������
  db - ����� ��� ������
  dist - Plazma JAR �����
  docs - ������������
  fonts - ������ ��� �������� � PDF (UNICODE)
  lib - JAR �����
  logs - LOG �����
  reports - ������

  plazma.bat - ��������� bat ���� ������� (Windows)
  plazma.sh - ��������� shell ���� ������� (Linux)
  unsinstall.bat - ��������� bat ���� ������������� (Windows)
  uninstall.sh - ��������� shell ���� ������������� (Linux)

  launcher.bat - Launcher bat ���� (Windows)
  launcher.sh - Launcher shell ���� (Linux)
  launcher.jar - Launcher JAR ����
  plazma.conf - ���� ������������ (������ ��� launcher ��������)
  plazma.classpath - Classpath ���� (������ ��� launcher ��������)
  plazma.properties - ���� ��������� �������


������:


  ��� ������� ���������� ���������� ��������� ��������� �������:


  Windows
  -------
     
  plazma.bat
     
  ���
     
  java -jar launcher.jar plazma
     
  ��� ������� ����� ����  ���� -> ��������� -> Plazma ERP+CRM <������> -> Plazma ERP+CRM


  Linux
  -----
     
  plazma.sh
     
  ���
     
  java -jar launcher.jar plazma




  ���� ������������
  -----------------
  Login/Password:

  admin/test		SUPERVISOR
  

  
������������:

			������ ��� Standalone
			
  ���� �����
  ----------

  ��� ������� ��������� � ���� ������ ���������� ������� ���� -demo � ������� �������, ��������:
  java -jar launcher.jar plazma -demo 

  ��� ���������� � ����� plazma.properties �������� plazma.platform.demo, ��������:
  plazma.platform.demo = true

  ��� ������� ��������� � ���� ������ ����� ����������� ����������� � ��������������� ���� ������.
  ��������� ����� -demo ���� ��� �������� plazma.platform.demo 

  ��������/��������� ����� �������������� ��������� ������ � ������ �� ���������, ����� ���� ��������������
  �������� plazma.platform.autologin, ��������:
  plazma.platform.autologin = true

  
  ���� ������
  -----------
  
  � ����� <Plazma>/conf/jdbc.properties �� ������ �������� �������� ����������� � ���� ������.
  
  SQL ������� ��� �������� ���� ������ ��������� � ����� <Plazma>/db/script/createdb/<������������� ���� ������>/<����>. 
  ��������: <Plazma>/db/script/createdb/firebird/ru
  
  create_plazma_db_demo.sql - ���������������� ���� ������
  create_plazma_db.sql - ������� ���� ������
   
  
