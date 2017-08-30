=======================================================================================================

 Update Database.

=======================================================================================================

<new_version> - new version
<old_version> - old version
<db_vendor> - Database vendor (firebird, hsql, mysql, oracle, postgresql)
<lang> - language (en, ru)


Result update script: <new_version>/<db_vendor>/<lang>/update_<old_version>-<new_version>.sql
To update database you have to execute the script.


To generate the script use 5 steps (ANT task script-update-db in bs.base.update/build.xml):

=======================================================================================================
1. Drop old version objects
=======================================================================================================
<new_version>/common/drop_constraints.sql
<new_version>/common/drop_constraints_user.sql
<new_version>/<db_vendor>/drop_views.sql

=======================================================================================================
2. Update structure
=======================================================================================================
<new_version>/common/update_structure.sql

=======================================================================================================
3. Update system
=======================================================================================================
<new_version>/common/update_system.sql
<new_version>/common/<lang>/update_system_entity.sql

=======================================================================================================
4. Update data (optional)
=======================================================================================================
<new_version>/common/update_data_pre.sql
<new_version>/common/<lang>/update_data.sql
<new_version>/common/update_data_post.sql

=======================================================================================================
5. Create new version objects
=======================================================================================================
<new_version>/comon/create_constraints.sql
<new_version>/common/create_constraints_user.sql
<new_version>/<db_vendor>/create_views.sql
