
UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'ACADEMIC_DEGREE',
    NAME = 'Academic degree',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'ACADEMIC_DEGREE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'ACTIVITY_TYPE',
    NAME = 'Activity type',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PARTNER',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'ACTIVITY_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'ADDRESS',
    NAME = 'Address',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'ADDRESS');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'ADDRESS_TYPE',
    NAME = 'Address type',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'ADDRESS_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'APPARTMENT_TYPE',
    NAME = 'Appartment type',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'APPARTMENT_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'ASSET',
    NAME = 'Fixed Assets',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'N',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'ASSET');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'BANK',
    NAME = 'Bank',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BANK',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'Y',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'BANK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'BANK_ACCOUNT',
    NAME = 'Bank account',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BANK',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'BANK_ACCOUNT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'BANK_CONTEXT',
    NAME = 'Bank context',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BANK',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'BANK_CONTEXT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'BRIGADE',
    NAME = 'Brigade',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'N',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'BRIGADE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'BUSINESSABLE',
    NAME = 'Businessable',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'BUSINESSABLE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'BUSINESSABLE_ENTITY',
    NAME = 'Businessable entity',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'N',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'BUSINESSABLE_ENTITY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'BUSINESSABLE_REGISTER',
    NAME = 'Businessable register',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'BUSINESSABLE_REGISTER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'CASH_INCOME',
    NAME = 'Cash income',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CASH',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'CASH_INCOME');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'CASH_OUTCOME',
    NAME = 'Cash outcome',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CASH',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'CASH_OUTCOME');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'CITY',
    NAME = 'City',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'CITY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'CONTACT',
    NAME = 'Contact',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'ORGANIZATION',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'Y',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'CONTACT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'CONTACTABLE',
    NAME = 'Contactable',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'CONTACTABLE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'CONTACTABLE_ENTITY',
    NAME = 'Contactable entity',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'N',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'CONTACTABLE_ENTITY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'CONTACT_CONTEXT',
    NAME = 'Contact context',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'CONTACT_CONTEXT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'CONTACT_TYPE',
    NAME = 'Contact type',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'ORGANIZATION',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'CONTACT_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'CONTRACT',
    NAME = 'Contract',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'DOCUMENT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'CONTRACT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'CONTRACTOR',
    NAME = 'Contractor',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'CONTRACTOR');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'CONTRACTOR_MOVE',
    NAME = 'Contractor move',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'CONTRACTOR_MOVE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'COUNTRY',
    NAME = 'Country',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'COUNTRY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'CURRENCY',
    NAME = 'Currency',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'CURRENCY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'DATA_TYPE',
    NAME = 'Data type',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'DATA_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'DEPARTMENT',
    NAME = 'Department',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'ORGANIZATION',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'DEPARTMENT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'DISCHARGE_TYPE',
    NAME = 'Discharge type',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'EMPLOYEE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'DISCHARGE_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'DISTRICT',
    NAME = 'District',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'DISTRICT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'DOCUMENT',
    NAME = 'Document',
    ENTITY_CLASS = 'JournalDocument',
    ENTITY_PACKAGE = 'DOCUMENT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'DOCUMENT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'DOCUMENT_TYPE',
    NAME = 'Document type',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'DOCUMENT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'DOCUMENT_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'DRUGSTORE',
    NAME = 'Drugstore',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'N',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'DRUGSTORE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'EDUCATION_FORM',
    NAME = 'Education form',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'EDUCATION_FORM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'EDUCATION_INSTITUTE',
    NAME = 'Education institute',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'EDUCATION_INSTITUTE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'EDUCATION_TYPE',
    NAME = 'Education type',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'EDUCATION_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'EMAIL',
    NAME = 'Email',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'EMAIL');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'EMPLOYEE',
    NAME = 'Employee',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'EMPLOYEE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'Y',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'EMPLOYEE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'EMPLOYEE_CATEGORY',
    NAME = 'Employee category',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'EMPLOYEE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'EMPLOYEE_CATEGORY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'EMPLOYEE_DISCHARGE',
    NAME = 'Employee discharge',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'EMPLOYEE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'EMPLOYEE_DISCHARGE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'EMPLOYEE_VACATION',
    NAME = 'Employee vacation',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'EMPLOYEE_VACATION');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'EMPLOYEE_VACATION_AVERANGE',
    NAME = 'Employee vacation averange',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'EMPLOYEE_VACATION_AVERANGE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'EMPLOYEE_MOVE',
    NAME = 'Employee move',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'EMPLOYEE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'N',
    IS_FORM = 'Y',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'EMPLOYEE_MOVE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'EMPLOYEE_PAYROLL',
    NAME = 'Employee payroll',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'EMPLOYEE_PAYROLL');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'EMPLOYEE_RANK',
    NAME = 'Employee rank',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'EMPLOYEE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'EMPLOYEE_RANK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'EMPLOYEE_RECEPTION',
    NAME = 'Employee reception',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'EMPLOYEE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'EMPLOYEE_RECEPTION');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'EMPLOYEE_SICKLIST',
    NAME = 'Employee sicklist',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'EMPLOYEE_SICKLIST');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'EMPLOYEE_SICKLIST_AVERANGE',
    NAME = 'Employee sicklist averange',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'EMPLOYEE_SICKLIST_AVERANGE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'EMPLOYEE_TOTAL',
    NAME = 'Employee total',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'EMPLOYEE_TOTAL');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'ENTRY_ITEM',
    NAME = 'Entry item',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'ENTRY_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'FACTORY',
    NAME = 'Factory',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'N',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'FACTORY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'FAMILIARITY',
    NAME = 'Familiarity',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'FAMILIARITY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'FAMILY_STATUS',
    NAME = 'Family status',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'FAMILY_STATUS');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'FINANCE_DOCUMENT',
    NAME = 'Finance document',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'FINANCE_DOCUMENT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'FINANCE_DOCUMENT_TYPE',
    NAME = 'Finance document type',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'FINANCE_DOCUMENT_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'FORM_PROPERTY',
    NAME = 'Form property',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PARTNER',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'FORM_PROPERTY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'GOODS',
    NAME = 'Goods',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'Y',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'GOODS');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'GOODS_INCOME',
    NAME = 'Goods income',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'GOODS_INCOME');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'GOODS_INCOME_ITEM',
    NAME = 'Goods income item',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'GOODS_INCOME_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'GOODS_OUTCOME',
    NAME = 'Goods outcome',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'GOODS_OUTCOME');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'GOODS_OUTCOME_ITEM',
    NAME = 'Goods outcome item',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'GOODS_OUTCOME_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'GOODS_TYPE',
    NAME = 'Goods type',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'GOODS',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'GOODS_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'INVENTORY_MOVE',
    NAME = 'Inventory move',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'INVENTORY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'INVENTORY_MOVE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'INVENTORY_MOVE_ITEM',
    NAME = 'Inventory move item',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'INVENTORY',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'INVENTORY_MOVE_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'INVENTORY_REST',
    NAME = 'Inventory rest',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'INVENTORY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'INVENTORY_REST');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'INVENTORY_REST_ITEM',
    NAME = 'Inventory rest item',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'INVENTORY',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'INVENTORY_REST_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'INVENTORY_WRITEOFF',
    NAME = 'Inventory writeoff',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'INVENTORY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'INVENTORY_WRITEOFF');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'INVENTORY_WRITEOFF_ITEM',
    NAME = 'Inventory writeoff item',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'INVENTORY',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'INVENTORY_WRITEOFF_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'INVENTORY_INCOME',
    NAME = 'Inventory income',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'INVENTORY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'INVENTORY_INCOME');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'INVENTORY_INCOME_ITEM',
    NAME = 'Inventory income item',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'INVENTORY',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'INVENTORY_INCOME_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'INVENTORY_OUTCOME',
    NAME = 'Inventory outcome',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'INVENTORY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'INVENTORY_OUTCOME');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'INVENTORY_OUTCOME_ITEM',
    NAME = 'Inventory outcome item',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'INVENTORY',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'INVENTORY_OUTCOME_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'INDUSTRY',
    NAME = 'Industry',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PARTNER',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'INDUSTRY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'INTANGIBLE',
    NAME = 'Intangible',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'N',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'INTANGIBLE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'LANGUAGE',
    NAME = 'Language',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'LANGUAGE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'VACATION_AVERANGE_TYPE',
    NAME = 'Vacation averange type',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'VACATION_AVERANGE_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'VACATION_CALCULATE',
    NAME = 'Vacation calculate',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'VACATION_CALCULATE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'VACATION_TYPE',
    NAME = 'Vacation type',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'VACATION_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'LEDGER_ACCOUNT',
    NAME = 'Ledger account',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'LEDGER_ACCOUNT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'LEDGER_ACCOUNT_REGISTER',
    NAME = 'Ledger account register',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'LEDGER_ACCOUNT_REGISTER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'LEDGER_ACCOUNT_REST',
    NAME = 'Ledger account rest',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'LEDGER_ACCOUNT_REST');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'LEDGER_ACCOUNT_TYPE',
    NAME = 'Ledger account type',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'LEDGER_ACCOUNT_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'LOCALITY',
    NAME = 'Locality',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'LOCALITY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'LOCALITY_TYPE',
    NAME = 'Locality type',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'LOCALITY_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'MILITARY_RANK',
    NAME = 'Military rank',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'MILITARY_RANK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'MILITARY_SPECIALITY',
    NAME = 'Military speciality',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'MILITARY_SPECIALITY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'MILITARY_STATUS',
    NAME = 'Military status',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
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
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
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
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
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
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
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
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
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
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
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
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
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
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
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
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
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
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
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
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
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
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
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
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'M_PRODUCT_REGISTER_SUM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'ORGANIZATION',
    NAME = 'Organization',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'ORGANIZATION',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'ORGANIZATION');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PARTNER',
    NAME = 'Partner',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PARTNER',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'Y',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PARTNER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PARTNER_ACTIVITY_TYPE_LINK',
    NAME = 'Partner activity type link',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PARTNER',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PARTNER_ACTIVITY_TYPE_LINK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PARTNER_CATEGORY',
    NAME = 'Partner category',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PARTNER',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PARTNER_CATEGORY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PARTNER_CATEGORY_LINK',
    NAME = 'Partner category link',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PARTNER',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PARTNER_CATEGORY_LINK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PARTNER_GROUP',
    NAME = 'Partner group',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PARTNER',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PARTNER_GROUP');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'PARTNER_MOVE',
    NAME = 'Partner move',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PARTNER_MOVE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'PARTNER_REGISTER',
    NAME = 'Partner register',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PARTNER_REGISTER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'PARTNER_REST',
    NAME = 'Partner rest',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PARTNER_REST');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYMENT_DOCUMENT_LINK',
    NAME = 'Paymnet document link',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BANK',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PAYMENT_DOCUMENT_LINK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PAYMENT_INCOME',
    NAME = 'Payment income',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BANK',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PAYMENT_INCOME');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYMENT_MISSING',
    NAME = 'Payment missing',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BANK',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PAYMENT_MISSING');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PAYMENT_OUTCOME',
    NAME = 'Payment outcome',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BANK',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PAYMENT_OUTCOME');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYMENT_OUTCOME_TEMPLATE',
    NAME = 'Payment outcome template',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BANK',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PAYMENT_OUTCOME_TEMPLATE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYMENT_TYPE',
    NAME = 'Payment type',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BANK',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PAYMENT_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYROLL',
    NAME = 'Payroll',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PAYROLL');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYROLL_ALGORITM',
    NAME = 'Payroll algoritm',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PAYROLL_ALGORITM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYROLL_ALGORITM_TYPE',
    NAME = 'Payroll algoritm type',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PAYROLL_ALGORITM_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYROLL_FORM',
    NAME = 'Payroll form',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PAYROLL_FORM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYROLL_GROUP',
    NAME = 'Payroll group',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PAYROLL_GROUP');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYROLL_ITEM',
    NAME = 'Payroll item',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'N',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PAYROLL_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYROLL_MODE',
    NAME = 'Payroll mode',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PAYROLL_MODE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PAYROLL_TYPE',
    NAME = 'Payroll type',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PAYROLL_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'PERIOD',
    NAME = 'Period',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PERIOD');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERIOD_TYPE',
    NAME = 'Period type',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PERIOD_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON',
    NAME = 'Person',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'Y',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PERSON');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON_CARD',
    NAME = 'Person card',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PERSON_CARD');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON_DOCUMENT',
    NAME = 'Person document',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PERSON_DOCUMENT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON_DOCUMENT_TYPE',
    NAME = 'Person document type',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PERSON_DOCUMENT_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON_EDUCATION',
    NAME = 'Person education',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PERSON_EDUCATION');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON_FAMILY',
    NAME = 'Person family',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PERSON_FAMILY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON_JOB',
    NAME = 'Person job',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PERSON_JOB');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON_LANGUAGE',
    NAME = 'Person language',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PERSON_LANGUAGE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PERSON_MILITARY',
    NAME = 'Person military',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PERSON_MILITARY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PHONE',
    NAME = 'Phone',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PHONE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PHONE_TYPE',
    NAME = 'Phone type',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PHONE_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'POSITIONS',
    NAME = 'Positions',
    ENTITY_CLASS = 'Position',
    ENTITY_PACKAGE = 'EMPLOYEE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'POSITIONS');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRICE_TYPE',
    NAME = 'Price type',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PRICE_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRODUCT',
    NAME = 'Product',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PRODUCT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRODUCT_CLASS',
    NAME = 'Product class',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PRODUCT_CLASS');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRODUCT_CLASS_GROUP',
    NAME = 'Product class group',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PRODUCT_CLASS_GROUP');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRODUCT_CLASS_TYPE',
    NAME = 'Product class type',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PRODUCT_CLASS_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'PRODUCT_DETAIL_REGISTER',
    NAME = 'Product detail register',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PRODUCT_DETAIL_REGISTER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRODUCT_GROUP',
    NAME = 'Product group',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PRODUCT_GROUP');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRODUCT_INSTANCE',
    NAME = 'Product instance',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PRODUCT_INSTANCE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRODUCT_MOVE',
    NAME = 'Product move',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PRODUCT_MOVE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRODUCT_PRICE',
    NAME = 'Product price',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PRODUCT_PRICE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'PRODUCT_REGISTER',
    NAME = 'Product register',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PRODUCT_REGISTER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRODUCT_SECTION',
    NAME = 'Product section',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PRODUCT_SECTION');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PRODUCT_UNIT',
    NAME = 'Product unit',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PRODUCT',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PRODUCT_UNIT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'PROJECT',
    NAME = 'Project',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'Y',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PROJECT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'PROJECT_CONTACT_LINK',
    NAME = 'Project contact link',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'N',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PROJECT_CONTACT_LINK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PROJECT_CONTEXT',
    NAME = 'Project context',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PROJECT_CONTEXT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'PROJECT_EMPLOYEE_LINK',
    NAME = 'Project employee link',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'N',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PROJECT_EMPLOYEE_LINK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PROJECT_ROLE',
    NAME = 'Project role',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PROJECT_ROLE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PROJECT_STAGE',
    NAME = 'Project stage',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PROJECT_STAGE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PROJECT_STAGE_GROUP',
    NAME = 'Project stage group',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PROJECT_STAGE_GROUP');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PROJECT_STAGE_LINK',
    NAME = 'Project stage link',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PROJECT_STAGE_LINK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PROJECT_STATUS',
    NAME = 'Project status',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PROJECT_STATUS');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'PROJECT_TYPE',
    NAME = 'Project type',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PROJECT_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PURCHASE_INVOICE',
    NAME = 'Purchase Invoice',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PURCHASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PURCHASE_INVOICE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PURCHASE_INVOICE_ITEM',
    NAME = 'Purchase Invoice item',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PURCHASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PURCHASE_INVOICE_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PURCHASE_ORDER',
    NAME = 'Purchase order',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PURCHASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PURCHASE_ORDER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PURCHASE_ORDER_ITEM',
    NAME = 'Purchase order item',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PURCHASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PURCHASE_ORDER_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PURCHASE_PLAN',
    NAME = 'Purchase plan',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PURCHASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PURCHASE_PLAN');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PURCHASE_PLAN_ITEM',
    NAME = 'Purchase plan item',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PURCHASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PURCHASE_PLAN_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PURCHASE_SERV',
    NAME = 'Purchase service',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PURCHASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PURCHASE_SERV');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PURCHASE_SERV_ITEM',
    NAME = 'Purchase service item',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PURCHASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PURCHASE_SERV_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PURCHASE_TAX_WAYBILL',
    NAME = 'Purchase Tax waybill',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PURCHASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PURCHASE_TAX_WAYBILL');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'PURCHASE_TAX_WAYBILL_ITEM',
    NAME = 'Purchase Tax waybill item',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PURCHASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'PURCHASE_TAX_WAYBILL_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'REGION',
    NAME = 'Region',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'REGION');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'RESPONSIBLE',
    NAME = 'Responsible',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'ORGANIZATION',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'RESPONSIBLE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'SALE_INVOICE',
    NAME = 'Sale Invoice',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'SALE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SALE_INVOICE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'SALE_INVOICE_ITEM',
    NAME = 'Sale Invoice item',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'SALE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SALE_INVOICE_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'SALE_ORDER',
    NAME = 'Sale order',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'SALE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SALE_ORDER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'SALE_ORDER_ITEM',
    NAME = 'Sale order item',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'SALE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SALE_ORDER_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'SALE_PLAN',
    NAME = 'Sale plan',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'SALE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SALE_PLAN');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'SALE_PLAN_ITEM',
    NAME = 'Sale plan item',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'SALE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SALE_PLAN_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'SALE_SERV',
    NAME = 'Sale service',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'SALE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SALE_SERV');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'SALE_SERV_ITEM',
    NAME = 'Sale service item',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'SALE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SALE_SERV_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'SALE_TAX_WAYBILL',
    NAME = 'Sale Tax waybill',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'SALE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SALE_TAX_WAYBILL');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DOCUMENT',
    CODE = 'SALE_TAX_WAYBILL_ITEM',
    NAME = 'Sale Tax waybill item',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'SALE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SALE_TAX_WAYBILL_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'SECURE_OBJECT',
    NAME = 'Secure object',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SECURE_OBJECT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SHOP',
    NAME = 'Shop',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'N',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SHOP');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SICKLIST_AVERANGE_TYPE',
    NAME = 'Sicklist averange type',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SICKLIST_AVERANGE_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SICKLIST_TYPE',
    NAME = 'Sicklist type',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SICKLIST_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SICK_TYPE',
    NAME = 'Sick type',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PAYROLL',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SICK_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SPECIALITY',
    NAME = 'Speciality',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PERSONALITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SPECIALITY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'WAREHOUSE',
    NAME = 'Warehouse',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'ORGANIZATION',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'WAREHOUSE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'WAREHOUSE_ENTITY',
    NAME = 'Warehouse entity',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'ORGANIZATION',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'WAREHOUSE_ENTITY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'WAREHOUSE_MOVE',
    NAME = 'Warehouse move',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'WAREHOUSE_MOVE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'STORE',
    NAME = 'Store',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'ORGANIZATION',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'STORE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'STREET_TYPE',
    NAME = 'Street type',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'STREET_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'SYSTEM_ATTR',
    NAME = 'Attribute (custom)',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_ATTR');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'SYSTEM_ATTR_TYPE',
    NAME = 'Attribute type (custom)',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_ATTR_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'SYSTEM_ATTR_TYPE_GROUP',
    NAME = 'Attribute type group (custom)',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_ATTR_TYPE_GROUP');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_DAY',
    NAME = 'System day',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_DAY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'SYSTEM_ENTITY',
    NAME = 'System entity',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_ENTITY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_ENTITY_TYPE',
    NAME = 'System entity type',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_ENTITY_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'SYSTEM_ENUMERATION',
    NAME = 'Enumeration (custom)',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_ENUMERATION');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_INFO',
    NAME = 'System info',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_INFO');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_MONTH',
    NAME = 'System month',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_MONTH');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_PERMISSION',
    NAME = 'System permission',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'SECURITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_PERMISSION');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_PREFERENCE',
    NAME = 'System preference',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_PREFERENCE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_QUARTER',
    NAME = 'System quarter',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'Y',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_QUARTER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'SYSTEM_REFERENCE',
    NAME = 'Reference (custom)',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_REFERENCE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_ROLE',
    NAME = 'System role',
    ENTITY_CLASS = 'Role',
    ENTITY_PACKAGE = 'SECURITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_ROLE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_USER',
    NAME = 'System user',
    ENTITY_CLASS = 'User',
    ENTITY_PACKAGE = 'SECURITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_USER');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_USER_ROLE',
    NAME = 'System user role',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'SECURITY',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_USER_ROLE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'SYSTEM_VARIABLE',
    NAME = 'System variable',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'SYSTEM_VARIABLE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'TASK',
    NAME = 'Task',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'Y',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'TASK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'TASK_CONTACT_LINK',
    NAME = 'Task contact link',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'N',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'TASK_CONTACT_LINK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'TASK_CONTEXT',
    NAME = 'Task context',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'N',
    IS_FORM = 'N',
    IS_PERMISSION = 'N',
    IS_SYSTEM = 'Y',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'TASK_CONTEXT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'ENTITY',
    CODE = 'TASK_EMPLOYEE_LINK',
    NAME = 'Task employee link',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'N',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'TASK_EMPLOYEE_LINK');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'TASK_PRIORITY',
    NAME = 'Task priority',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'TASK_PRIORITY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'TASK_RESULT',
    NAME = 'Task result',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'TASK_RESULT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'TASK_ROLE',
    NAME = 'Task role',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'TASK_ROLE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'TASK_STATUS',
    NAME = 'Task status',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'TASK_STATUS');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'TASK_TYPE',
    NAME = 'Task type',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'PROJECT',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'TASK_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'TAX',
    NAME = 'Tax',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'TAX');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'TAXPRINT_TYPE',
    NAME = 'Taxprint type',
    ENTITY_CLASS = 'TaxPrintType',
    ENTITY_PACKAGE = 'BANK',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'TAXPRINT_TYPE');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'TEMPLATE_ENTRY',
    NAME = 'Template entry',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'TEMPLATE_ENTRY');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'TEMPLATE_ENTRY_ITEM',
    NAME = 'Template entry item',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'FINANCE',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'TEMPLATE_ENTRY_ITEM');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'UNIT',
    NAME = 'Unit',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'BASE',
    IS_ENABLE = 'Y',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'UNIT');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'WEB',
    NAME = 'Web',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = 'CONTACT',
    IS_ENABLE = 'Y',
    IS_BASE = 'N',
    IS_BEAN = 'Y',
    IS_FORM = 'Y',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'WEB');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'WORKS',
    NAME = 'Works',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'N',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'WORKS');

UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'WORKSHOP',
    NAME = 'Workshop',
    ENTITY_CLASS = NULL,
    ENTITY_PACKAGE = '-',
    IS_ENABLE = 'N',
    IS_BASE = 'Y',
    IS_BEAN = 'Y',
    IS_FORM = 'N',
    IS_PERMISSION = 'Y',
    IS_SYSTEM = 'N',
    IS_CUSTOM = 'N',
    IS_CUSTOM_ATTRIBUTE = 'N',
    IS_CACHE = 'N',
    CACHE_EXPIRE_TIME = 0
WHERE (ID = 'WORKSHOP');


