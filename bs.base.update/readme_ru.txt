=======================================================================================================

 ���������� ���� ������.

=======================================================================================================

<new_version> - ����� ������
<old_version> - ������ ������
<db_vendor> - ������������� ���� ������ (firebird, hsql, mysql, oracle, postgresql)
<lang> - ���� (en, ru)


�������������� update ������: <new_version>/<db_vendor>/<lang>/update_<old_version>-<new_version>.sql
��� ���������� ���� ������ ���������� ��������� ������ ������ �� ����������.


��� ��������� ������� ���������� 5 ����� (��. ANT task script-update-db � bs.base.update/build.xml):

=======================================================================================================
1. �������� �������� ������ ������
=======================================================================================================
<new_version>/common/drop_constraints.sql
<new_version>/common/drop_constraints_user.sql
<new_version>/<db_vendor>/drop_views.sql

=======================================================================================================
2. ���������� ���������
=======================================================================================================
<new_version>/common/update_structure.sql

=======================================================================================================
3. ���������� �������
=======================================================================================================
<new_version>/common/update_system.sql
<new_version>/common/<lang>/update_system_entity.sql

=======================================================================================================
4. ���������� ������ (�����������)
=======================================================================================================
<new_version>/common/update_data_pre.sql
<new_version>/common/<lang>/update_data.sql
<new_version>/common/update_data_post.sql

=======================================================================================================
5. �������� �������� ����� ������
=======================================================================================================
<new_version>/comon/create_constraints.sql
<new_version>/common/create_constraints_user.sql
<new_version>/<db_vendor>/create_views.sql
