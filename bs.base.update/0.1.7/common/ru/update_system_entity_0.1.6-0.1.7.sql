
UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'ACADEMIC_DEGREE',
    NAME = '������ �������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'ACADEMIC_DEGREE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'ACTIVITY_TYPE',
    NAME = '��� ���������� ��������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PARTNER',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'ACTIVITY_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'ADDRESS',
    NAME = '�����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'ADDRESS');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'ADDRESS_TYPE',
    NAME = '��� ������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'ADDRESS_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'APPARTMENT_TYPE',
    NAME = '��� ������������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'APPARTMENT_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'ASSET',
    NAME = '�������� ��������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'N',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'ASSET');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'BANK',
    NAME = '����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BANK',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'Y'
WHERE (ID = 'BANK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'BANK_ACCOUNT',
    NAME = '���������� ����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BANK',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'BANK_ACCOUNT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'BANK_CONTEXT',
    NAME = '�������� ������ <����>',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BANK',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'BANK_CONTEXT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'BRIGADE',
    NAME = '�������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'N',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'BRIGADE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'BUSINESSABLE',
    NAME = '������-������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'BUSINESSABLE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'BUSINESSABLE_ENTITY',
    NAME = '������-��������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'N',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'BUSINESSABLE_ENTITY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'BUSINESSABLE_REGISTER',
    NAME = '������� ������ ��������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'BUSINESSABLE_REGISTER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'CASH_INCOME',
    NAME = '��������� �������� �����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CASH',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'CASH_INCOME');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'CASH_OUTCOME',
    NAME = '��������� �������� �����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CASH',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'CASH_OUTCOME');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'CITY',
    NAME = '�����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'CITY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'CONTACT',
    NAME = '�������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'ORGANIZATION',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'Y'
WHERE (ID = 'CONTACT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'CONTACTABLE',
    NAME = '�������-������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'CONTACTABLE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'CONTACTABLE_ENTITY',
    NAME = '�������-��������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'N',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'CONTACTABLE_ENTITY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'CONTACT_CONTEXT',
    NAME = '�������� ������ <��������>',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'CONTACT_CONTEXT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'CONTACT_TYPE',
    NAME = '��� ���������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'CONTACT_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'CONTRACT',
    NAME = '�������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'DOCUMENT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'CONTRACT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'CONTRACTOR',
    NAME = '�����������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'CONTRACTOR');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'CONTRACTOR_MOVE',
    NAME = '�������� �� ������������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'CONTRACTOR_MOVE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'COUNTRY',
    NAME = '������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'COUNTRY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'CURRENCY',
    NAME = '������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'CURRENCY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'DATA_TYPE',
    NAME = '��� ������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'DATA_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'DEPARTMENT',
    NAME = '�������������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'ORGANIZATION',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'DEPARTMENT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'DISCHARGE_TYPE',
    NAME = '��� ����������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'EMPLOYEE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'DISCHARGE_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'DISTRICT',
    NAME = '�����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'DISTRICT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'DOCUMENT',
    NAME = '��������',
    ENTITY_CLASS = 'JournalDocument',
    ENTITY_PACKAGE = 'DOCUMENT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'DOCUMENT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'DOCUMENT_TYPE',
    NAME = '��� ���������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'DOCUMENT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'DOCUMENT_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'DRUGSTORE',
    NAME = '������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'N',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'DRUGSTORE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'EDUCATION_FORM',
    NAME = '����� �����������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'EDUCATION_FORM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'EDUCATION_INSTITUTE',
    NAME = '������� ���������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'EDUCATION_INSTITUTE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'EDUCATION_TYPE',
    NAME = '��� �����������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'EDUCATION_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'EMAIL',
    NAME = 'E-mail',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'EMAIL');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'EMPLOYEE',
    NAME = '��������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'EMPLOYEE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'Y'
WHERE (ID = 'EMPLOYEE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'EMPLOYEE_CATEGORY',
    NAME = '��������� ��������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'EMPLOYEE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'EMPLOYEE_CATEGORY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'EMPLOYEE_DISCHARGE',
    NAME = '������ �� ����������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'EMPLOYEE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'EMPLOYEE_DISCHARGE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'EMPLOYEE_VACATION',
    NAME = '���������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'EMPLOYEE_VACATION');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'EMPLOYEE_VACATION_AVERANGE',
    NAME = '������� �� ���������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'EMPLOYEE_VACATION_AVERANGE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'EMPLOYEE_MOVE',
    NAME = '�������� �� ��������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'EMPLOYEE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'N',
    IS_FORM = 'Y',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'EMPLOYEE_MOVE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'EMPLOYEE_PAYROLL',
    NAME = '�������� ���������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'EMPLOYEE_PAYROLL');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'EMPLOYEE_RANK',
    NAME = '���� ���������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'EMPLOYEE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'EMPLOYEE_RANK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'EMPLOYEE_RECEPTION',
    NAME = '������ � ����� �� ������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'EMPLOYEE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'EMPLOYEE_RECEPTION');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'EMPLOYEE_SICKLIST',
    NAME = '����������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'EMPLOYEE_SICKLIST');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'EMPLOYEE_SICKLIST_AVERANGE',
    NAME = '������� �� ����������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'EMPLOYEE_SICKLIST_AVERANGE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'EMPLOYEE_TOTAL',
    NAME = '���� �� ���������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'EMPLOYEE_TOTAL');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'ENTRY_ITEM',
    NAME = '�������� �� ���������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'ENTRY_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'EXEC_WORK',
    NAME = '��� ����������� �����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'EXEC_WORK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'EXEC_WORK_ITEM',
    NAME = '������� �� ���� ����������� �����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'EXEC_WORK_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'FACTORY',
    NAME = '�������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'N',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'FACTORY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'FAMILIARITY',
    NAME = '����������� �����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'FAMILIARITY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'FAMILY_STATUS',
    NAME = '�������� ���������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'FAMILY_STATUS');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'FINANCE_DOCUMENT',
    NAME = '���������� ��������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'FINANCE_DOCUMENT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'FINANCE_DOCUMENT_TYPE',
    NAME = '��� ����������� ���������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'FINANCE_DOCUMENT_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'FORM_PROPERTY',
    NAME = '����� �������������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PARTNER',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'FORM_PROPERTY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'GOODS',
    NAME = '�����/������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'Y'
WHERE (ID = 'GOODS');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'GOODS_INCOME',
    NAME = '��������� ���������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'GOODS_INCOME');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'GOODS_INCOME_ITEM',
    NAME = '������� ��������� ���������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'GOODS_INCOME_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'GOODS_MOVE',
    NAME = '��������� �� ��������� �����������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'GOODS_MOVE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'GOODS_MOVE_ITEM',
    NAME = '������� ��������� �� ��������� �����������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'GOODS_MOVE_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'GOODS_OUTCOME',
    NAME = '��������� ���������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'GOODS_OUTCOME');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'GOODS_OUTCOME_ITEM',
    NAME = '������� ��������� ���������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'GOODS_OUTCOME_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'GOODS_REST',
    NAME = '������� �� ������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'GOODS_REST');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'GOODS_REST_ITEM',
    NAME = '������� �������� �� ������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'GOODS_REST_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'GOODS_TYPE',
    NAME = '��� ������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'GOODS_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'GOODS_WRITEOFF',
    NAME = '��� �� ��������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'GOODS_WRITEOFF');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'GOODS_WRITEOFF_ITEM',
    NAME = '������� ���� �� ��������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'GOODS_WRITEOFF_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'INDUSTRY',
    NAME = '���������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PARTNER',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'INDUSTRY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'INTANGIBLE',
    NAME = '�������������� ������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'N',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'INTANGIBLE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'INVOICE',
    NAME = '����-�������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'INVOICE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'INVOICE_ITEM',
    NAME = '������� �����-�������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'INVOICE_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'LANGUAGE',
    NAME = '����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'LANGUAGE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'VACATION_AVERANGE_TYPE',
    NAME = '��� ������� �� �������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'VACATION_AVERANGE_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'VACATION_CALCULATE',
    NAME = '��� ������� �� �������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'VACATION_CALCULATE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'VACATION_TYPE',
    NAME = '��� �������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'VACATION_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'LEDGER_ACCOUNT',
    NAME = '������������� ����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'LEDGER_ACCOUNT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'LEDGER_ACCOUNT_REGISTER',
    NAME = '������� �� �������������� �����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'LEDGER_ACCOUNT_REGISTER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'LEDGER_ACCOUNT_REST',
    NAME = '������� �� �������������� �����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'LEDGER_ACCOUNT_REST');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'LEDGER_ACCOUNT_TYPE',
    NAME = '��� �������������� �����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'LEDGER_ACCOUNT_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'LOCALITY',
    NAME = '��������� �����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'LOCALITY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'LOCALITY_TYPE',
    NAME = '��� ���������� ������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'LOCALITY_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'MILITARY_RANK',
    NAME = '�������� ������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'MILITARY_RANK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'MILITARY_SPECIALITY',
    NAME = '�������� �������������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'MILITARY_SPECIALITY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'MILITARY_STATUS',
    NAME = '�������� ������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'MILITARY_STATUS');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'M_LEDGER_ACCOUNT_REGISTER',
    NAME = '-',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'M_LEDGER_ACCOUNT_REGISTER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'M_LEDGER_ACCOUNT_REGISTER_ID',
    NAME = '-',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'M_LEDGER_ACCOUNT_REGISTER_ID');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'M_LEDGER_ACCOUNT_REGISTER_SUM',
    NAME = '-',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'M_LEDGER_ACCOUNT_REGISTER_SUM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'M_PARTNER_REGISTER',
    NAME = '-',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'M_PARTNER_REGISTER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'M_PARTNER_REGISTER_ID',
    NAME = '-',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'M_PARTNER_REGISTER_ID');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'M_PARTNER_REGISTER_SUM',
    NAME = '-',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'M_PARTNER_REGISTER_SUM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'M_PRODUCT_DETAIL_REGISTER',
    NAME = '-',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'M_PRODUCT_DETAIL_REGISTER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'M_PRODUCT_DETAIL_REGISTER_ID',
    NAME = '-',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'M_PRODUCT_DETAIL_REGISTER_ID');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'M_PRODUCT_DETAIL_REGISTER_SUM',
    NAME = '-',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'M_PRODUCT_DETAIL_REGISTER_SUM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'M_PRODUCT_REGISTER',
    NAME = '-',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'M_PRODUCT_REGISTER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'M_PRODUCT_REGISTER_ID',
    NAME = '-',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'M_PRODUCT_REGISTER_ID');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'M_PRODUCT_REGISTER_SUM',
    NAME = '-',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'M_PRODUCT_REGISTER_SUM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'ORGANIZATION',
    NAME = '�����������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'ORGANIZATION',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'ORGANIZATION');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PARTNER',
    NAME = '����������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PARTNER',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'Y'
WHERE (ID = 'PARTNER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PARTNER_ACTIVITY_TYPE_LINK',
    NAME = '������������ �� �����������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PARTNER',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PARTNER_ACTIVITY_TYPE_LINK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PARTNER_CATEGORY',
    NAME = '��������� ������������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PARTNER',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PARTNER_CATEGORY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PARTNER_CATEGORY_LINK',
    NAME = '��������� �� �����������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PARTNER',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PARTNER_CATEGORY_LINK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PARTNER_GROUP',
    NAME = '������ ������������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PARTNER',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PARTNER_GROUP');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'PARTNER_MOVE',
    NAME = '�������� �� �����������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PARTNER_MOVE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'PARTNER_REGISTER',
    NAME = '������� �� �����������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PARTNER_REGISTER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'PARTNER_REST',
    NAME = '������� �� �����������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PARTNER_REST');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYMENT_DOCUMENT_LINK',
    NAME = '��������� ��� ������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BANK',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PAYMENT_DOCUMENT_LINK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PAYMENT_INCOME',
    NAME = '�������� ����������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BANK',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PAYMENT_INCOME');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYMENT_MISSING',
    NAME = '���������� �������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BANK',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PAYMENT_MISSING');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PAYMENT_OUTCOME',
    NAME = '��������� ���������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BANK',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PAYMENT_OUTCOME');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYMENT_OUTCOME_TEMPLATE',
    NAME = '������ ���������� ���������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BANK',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PAYMENT_OUTCOME_TEMPLATE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYMENT_TYPE',
    NAME = '��� ������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BANK',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PAYMENT_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYROLL',
    NAME = '����������/���������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PAYROLL');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYROLL_ALGORITM',
    NAME = '�������� ����������/���������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PAYROLL_ALGORITM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYROLL_ALGORITM_TYPE',
    NAME = '��� ��������� ����������/���������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PAYROLL_ALGORITM_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYROLL_FORM',
    NAME = '����� ������ �����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PAYROLL_FORM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYROLL_GROUP',
    NAME = '������ ����������/���������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PAYROLL_GROUP');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYROLL_ITEM',
    NAME = '���������� ����������/���������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'N',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PAYROLL_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYROLL_MODE',
    NAME = '����� ����������/���������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PAYROLL_MODE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYROLL_TYPE',
    NAME = '��� ����������/���������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PAYROLL_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'PERIOD',
    NAME = '������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PERIOD');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERIOD_TYPE',
    NAME = '��� �������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PERIOD_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON',
    NAME = '���������� ����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'Y'
WHERE (ID = 'PERSON');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON_CARD',
    NAME = '�������� ����������� ����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PERSON_CARD');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON_DOCUMENT',
    NAME = '�������� ����������� ����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PERSON_DOCUMENT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON_DOCUMENT_TYPE',
    NAME = '��� ��������� ����������� ����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PERSON_DOCUMENT_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON_EDUCATION',
    NAME = '����������� ����������� ����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PERSON_EDUCATION');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON_FAMILY',
    NAME = '����� ����������� ����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PERSON_FAMILY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON_JOB',
    NAME = '������ ����������� ����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PERSON_JOB');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON_LANGUAGE',
    NAME = '���� ������� ����������� ����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PERSON_LANGUAGE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON_MILITARY',
    NAME = '�������� ���������� �� ����������� ����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PERSON_MILITARY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PHONE',
    NAME = '�������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PHONE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PHONE_TYPE',
    NAME = '��� ��������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PHONE_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'POSITIONS',
    NAME = '���������',
    ENTITY_CLASS = 'Position',
    ENTITY_PACKAGE = 'EMPLOYEE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'POSITIONS');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRICE_TYPE',
    NAME = '��� ����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PRICE_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRODUCT',
    NAME = '�������� ��������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PRODUCT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRODUCT_CLASS',
    NAME = '������������� �������/�����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PRODUCT_CLASS');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRODUCT_CLASS_GROUP',
    NAME = '������ ������ ��������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PRODUCT_CLASS_GROUP');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRODUCT_CLASS_TYPE',
    NAME = '��� ������ ��������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PRODUCT_CLASS_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'PRODUCT_DETAIL_REGISTER',
    NAME = '����������� �������� �� ������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PRODUCT_DETAIL_REGISTER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRODUCT_GROUP',
    NAME = '������ �������� ��������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PRODUCT_GROUP');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRODUCT_INSTANCE',
    NAME = '��������� ��������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PRODUCT_INSTANCE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRODUCT_MOVE',
    NAME = '�������� �� �������� ��������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PRODUCT_MOVE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRODUCT_PRICE',
    NAME = '���� �� �������� ��������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PRODUCT_PRICE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'PRODUCT_REGISTER',
    NAME = '������� ������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PRODUCT_REGISTER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRODUCT_SECTION',
    NAME = '������ �������� ��������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PRODUCT_SECTION');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRODUCT_UNIT',
    NAME = '������� ��������� �� �������� ��������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PRODUCT_UNIT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'PROJECT',
    NAME = '������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'Y'
WHERE (ID = 'PROJECT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'PROJECT_CONTACT_LINK',
    NAME = '�������� �� �������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'N',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PROJECT_CONTACT_LINK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PROJECT_CONTEXT',
    NAME = '�������� ������ <�������>',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PROJECT_CONTEXT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'PROJECT_EMPLOYEE_LINK',
    NAME = '���������� �� �������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'N',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PROJECT_EMPLOYEE_LINK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PROJECT_ROLE',
    NAME = '���� �� �������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PROJECT_ROLE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PROJECT_STAGE',
    NAME = '������ �������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PROJECT_STAGE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PROJECT_STAGE_GROUP',
    NAME = '������ ������ �������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PROJECT_STAGE_GROUP');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PROJECT_STAGE_LINK',
    NAME = '������ �� �������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PROJECT_STAGE_LINK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PROJECT_STATUS',
    NAME = '��������� �������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PROJECT_STATUS');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PROJECT_TYPE',
    NAME = '���  �������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PROJECT_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PURCHASE_ORDER',
    NAME = '����� �� �������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PURCHASE_ORDER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PURCHASE_ORDER_ITEM',
    NAME = '������� ������ �� �������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PURCHASE_ORDER_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PURCHASE_PLAN',
    NAME = '���� �� �������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PURCHASE_PLAN');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PURCHASE_PLAN_ITEM',
    NAME = '������� ����� �� �������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'PURCHASE_PLAN_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'REGION',
    NAME = '������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'REGION');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'RESPONSIBLE',
    NAME = '�������������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'ORGANIZATION',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'RESPONSIBLE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'SALE_ORDER',
    NAME = '����� �� �������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SALE_ORDER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'SALE_ORDER_ITEM',
    NAME = '������� ������ �� �������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SALE_ORDER_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'SALE_PLAN',
    NAME = '���� �� �������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SALE_PLAN');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'SALE_PLAN_ITEM',
    NAME = '������� ����� �� �������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SALE_PLAN_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'SECURE_OBJECT',
    NAME = '������� �� ������� ��������������� ����� �������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SECURE_OBJECT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SHOP',
    NAME = '�������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'N',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SHOP');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SICKLIST_AVERANGE_TYPE',
    NAME = '��� ������� ��� ����������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SICKLIST_AVERANGE_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SICKLIST_TYPE',
    NAME = '��� ����������� �����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SICKLIST_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SICK_TYPE',
    NAME = '��� �������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SICK_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SPECIALITY',
    NAME = '�������������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'HUMAN',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SPECIALITY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'WAREHOUSE',
    NAME = '����� ��������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'ORGANIZATION',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'WAREHOUSE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'WAREHOUSE_ENTITY',
    NAME = '�������� ����������� � ������ ��������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'ORGANIZATION',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'WAREHOUSE_ENTITY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'WAREHOUSE_MOVE',
    NAME = '�������� �� ������ ��������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'WAREHOUSE_MOVE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'STORE',
    NAME = '�����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'ORGANIZATION',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'STORE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'STREET_TYPE',
    NAME = '��� �����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'STREET_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'SYSTEM_ATTR',
    NAME = '������� (custom)',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SYSTEM_ATTR');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'SYSTEM_ATTR_TYPE',
    NAME = '��� �������� (custom)',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SYSTEM_ATTR_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'SYSTEM_ATTR_TYPE_GROUP',
    NAME = '������ ���� �������� (custom)',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SYSTEM_ATTR_TYPE_GROUP');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_DAY',
    NAME = '��������� ����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SYSTEM_DAY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'SYSTEM_ENTITY',
    NAME = '��������� ��������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SYSTEM_ENTITY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_ENTITY_TYPE',
    NAME = '��� ��������� ���������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SYSTEM_ENTITY_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'SYSTEM_ENUMERATION',
    NAME = '������������ (custom)',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SYSTEM_ENUMERATION');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_INFO',
    NAME = '��������� ����������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SYSTEM_INFO');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_MONTH',
    NAME = '��������� �����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SYSTEM_MONTH');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_PERMISSION',
    NAME = '����� �������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SYSTEM_PERMISSION');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_PREFERENCE',
    NAME = '��������� ���������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SYSTEM_PREFERENCE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_QUARTER',
    NAME = '��������� �������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'Y',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SYSTEM_QUARTER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'SYSTEM_REFERENCE',
    NAME = '���������� (custom)',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SYSTEM_REFERENCE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_ROLE',
    NAME = '����',
    ENTITY_CLASS = 'Role',
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SYSTEM_ROLE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_USER',
    NAME = '������������',
    ENTITY_CLASS = 'User',
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SYSTEM_USER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_USER_ROLE',
    NAME = '���� ������������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SYSTEM_USER_ROLE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_VARIABLE',
    NAME = '��������� ����������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'SYSTEM_VARIABLE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'TASK',
    NAME = '������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'Y'
WHERE (ID = 'TASK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'TASK_CONTACT_LINK',
    NAME = '�������� �� ������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'N',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'TASK_CONTACT_LINK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'TASK_CONTEXT',
    NAME = '�������� ������ <������>',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'TASK_CONTEXT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'TASK_EMPLOYEE_LINK',
    NAME = '���������� �� ������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'N',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'TASK_EMPLOYEE_LINK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'TASK_PRIORITY',
    NAME = '��������� ������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'TASK_PRIORITY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'TASK_RESULT',
    NAME = '��������� ������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'TASK_RESULT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'TASK_ROLE',
    NAME = '���� � ������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'TASK_ROLE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'TASK_STATUS',
    NAME = '��������� ������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'TASK_STATUS');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'TASK_TYPE',
    NAME = '��� ������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'TASK_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'TAX',
    NAME = '�����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'TAX');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'TAXPRINT_TYPE',
    NAME = '����� ������ ������',
    ENTITY_CLASS = 'TaxPrintType',
    ENTITY_PACKAGE = 'BANK',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'TAXPRINT_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'TAX_WAYBILL',
    NAME = '��������� ���������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'TAX_WAYBILL');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'TAX_WAYBILL_ITEM',
    NAME = '������� ��������� ���������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'TAX_WAYBILL_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'TEMPLATE_ENTRY',
    NAME = '������ ��������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'TEMPLATE_ENTRY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'TEMPLATE_ENTRY_ITEM',
    NAME = '������� ������� ��������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'TEMPLATE_ENTRY_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'UNIT',
    NAME = '������� ���������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'UNIT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'WEB',
    NAME = 'WEB ������',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'WEB');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'WORKS',
    NAME = '�����',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'N',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'WORKS');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'WORKSHOP',
    NAME = '���',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'N',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N'
WHERE (ID = 'WORKSHOP');


