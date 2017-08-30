
UPDATE SYSTEM_ENTITY SET 
    ENTITY_TYPE_ID = 'DICTIONARY',
    CODE = 'ACADEMIC_DEGREE',
    NAME = 'Учёная степень',
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
    NAME = 'Тип активности компаний',
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
    NAME = 'Адрес',
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
    NAME = 'Тип адреса',
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
    NAME = 'Тип апартаментов',
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
    NAME = 'Основное средство',
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
    NAME = 'Банк',
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
    NAME = 'Банковский счет',
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
    NAME = 'Контекст модуля <Банк>',
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
    NAME = 'Бригада',
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
    NAME = 'Бизнес-объект',
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
    NAME = 'Бизнес-сущность',
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
    NAME = 'Регистр бизнес объектов',
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
    NAME = 'Приходный кассовый ордер',
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
    NAME = 'Расходный кассовый ордер',
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
    NAME = 'Город',
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
    NAME = 'Контакт',
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
    NAME = 'Контакт-объект',
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
    NAME = 'Контакт-сущность',
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
    NAME = 'Контекст модуля <Контакты>',
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
    NAME = 'Тип контактов',
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
    NAME = 'Договор',
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
    NAME = 'Контрактник',
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
    NAME = 'Движение по контрактнику',
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
    NAME = 'Страна',
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
    NAME = 'Валюта',
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
    NAME = 'Тип данных',
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
    NAME = 'Подразделение',
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
    NAME = 'Тип увольнения',
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
    NAME = 'Район',
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
    NAME = 'Документ',
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
    NAME = 'Тип документа',
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
    NAME = 'Аптека',
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
    NAME = 'Форма образования',
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
    NAME = 'Учебное заведение',
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
    NAME = 'Тип образования',
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
    NAME = 'Служащий',
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
    NAME = 'Категория служащих',
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
    NAME = 'Приказ об увольнении',
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
    NAME = 'Отпускные',
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
    NAME = 'Средние по отпускным',
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
    NAME = 'Движения по служащим',
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
    NAME = 'Зарплата служащего',
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
    NAME = 'Ранг служащего',
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
    NAME = 'Приказ о приёме на работу',
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
    NAME = 'Больничные',
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
    NAME = 'Средние по больничным',
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
    NAME = 'Итог по служащему',
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
    NAME = 'Проводки по документу',
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
    NAME = 'Акт выполненных работ',
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
    NAME = 'Строчки по акту выполненных работ',
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
    NAME = 'Фабрика',
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
    NAME = 'Родственные связи',
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
    NAME = 'Семейное положение',
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
    NAME = 'Финансовый документ',
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
    NAME = 'Тип финансового документа',
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
    NAME = 'Форма собственности',
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
    NAME = 'Товар/услуга',
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
    NAME = 'Приходная накладная',
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
    NAME = 'Строчки приходной накладной',
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
    NAME = 'Накладная на внутренне перемещение',
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
    NAME = 'Строчки накладной на внутренне перемещение',
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
    NAME = 'Расходная накладная',
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
    NAME = 'Строчки расходной накладной',
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
    NAME = 'Остатки по товару',
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
    NAME = 'Строчки остатков по товару',
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
    NAME = 'Тип товара',
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
    NAME = 'Акт на списание',
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
    NAME = 'Строчки акта на списание',
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
    NAME = 'Индустрия',
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
    NAME = 'Нематериальные активы',
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
    NAME = 'Счёт-фактура',
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
    NAME = 'Строчки счёта-фактуры',
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
    NAME = 'Язык',
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
    NAME = 'Тип средних по отпуску',
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
    NAME = 'Тип расчёта по отпуску',
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
    NAME = 'Тип отпуска',
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
    NAME = 'Бухгалтерский счёт',
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
    NAME = 'Регистр по бухгалтерскому счёту',
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
    NAME = 'Остатки по бухгалтерскому счёту',
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
    NAME = 'Тип бухгалтерского счёта',
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
    NAME = 'Населённый пункт',
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
    NAME = 'Тип населённого пункта',
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
    NAME = 'Воинское звание',
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
    NAME = 'Воинская специальность',
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
    NAME = 'Воинский статус',
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
    NAME = 'Организация',
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
    NAME = 'Контрагент',
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
    NAME = 'Деятельность по контрагенту',
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
    NAME = 'Категория контрагентов',
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
    NAME = 'Категории по контрагенту',
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
    NAME = 'Группа контрагентов',
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
    NAME = 'Движение по контрагенту',
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
    NAME = 'Регистр по контрагенту',
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
    NAME = 'Остатки по контрагенту',
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
    NAME = 'Документы для оплаты',
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
    NAME = 'Платёжное требование',
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
    NAME = 'Назначение платежа',
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
    NAME = 'Платежное поручение',
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
    NAME = 'Шаблон платежного поручения',
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
    NAME = 'Тип оплаты',
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
    NAME = 'Начисления/Удержания',
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
    NAME = 'Алгоритм начислений/удержаний',
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
    NAME = 'Тип алгоритма начислений/удержаний',
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
    NAME = 'Форма оплаты труда',
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
    NAME = 'Группа начислений/удержаний',
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
    NAME = 'Подчинённые начисления/удержания',
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
    NAME = 'Режим начислений/удержаний',
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
    NAME = 'Тип начислений/удержаний',
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
    NAME = 'Период',
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
    NAME = 'Тип периода',
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
    NAME = 'Физическое лицо',
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
    NAME = 'Карточка физического лица',
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
    NAME = 'Документ физического лица',
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
    NAME = 'Тип документа физического лица',
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
    NAME = 'Образование физического лица',
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
    NAME = 'Семья физического лица',
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
    NAME = 'Работа физического лица',
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
    NAME = 'Язык общения физического лица',
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
    NAME = 'Воинская информация по физическому лицу',
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
    NAME = 'Телефон',
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
    NAME = 'Тип телефона',
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
    NAME = 'Должность',
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
    NAME = 'Тип цены',
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
    NAME = 'Карточка продукта',
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
    NAME = 'Классификатор товаров/услуг',
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
    NAME = 'Группа класса продукта',
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
    NAME = 'Тип класса продукта',
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
    NAME = 'Детализация регистра по товару',
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
    NAME = 'Группа карточки продукта',
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
    NAME = 'Экземпляр продукта',
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
    NAME = 'Движение по карточке продукта',
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
    NAME = 'Цена по карточке продукта',
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
    NAME = 'Регистр товара',
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
    NAME = 'Секция карточки продукта',
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
    NAME = 'Единица измерения по карточке продукта',
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
    NAME = 'Проект',
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
    NAME = 'Контакты по проекту',
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
    NAME = 'Контекст модуля <Проекты>',
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
    NAME = 'Сотрудники по проекту',
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
    NAME = 'Роли по проекту',
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
    NAME = 'Стадия проекта',
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
    NAME = 'Группа стадий проекта',
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
    NAME = 'Стадии по проекту',
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
    NAME = 'Состояние проекта',
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
    NAME = 'Тип  проекта',
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
    NAME = 'Заказ на покупку',
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
    NAME = 'Строчки заказа на покупку',
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
    NAME = 'План на покупку',
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
    NAME = 'Строчки плана на покупку',
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
    NAME = 'Регион',
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
    NAME = 'Ответственный',
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
    NAME = 'Заказ на продажу',
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
    NAME = 'Строчки заказа на продажу',
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
    NAME = 'План на продажу',
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
    NAME = 'Строчки плана на продажу',
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
    NAME = 'Объекты на которые устанавливается права доступа',
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
    NAME = 'Магазин',
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
    NAME = 'Тип средних для больничных',
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
    NAME = 'Тип больничного листа',
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
    NAME = 'Тип болезни',
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
    NAME = 'Специальность',
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
    NAME = 'Места хранения',
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
    NAME = 'Сущности относящиеся к местам хранения',
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
    NAME = 'Движение по местам хранения',
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
    NAME = 'Склад',
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
    NAME = 'Тип улицы',
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
    NAME = 'Атрибут (custom)',
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
    NAME = 'Тип атрибута (custom)',
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
    NAME = 'Группа типа атрибута (custom)',
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
    NAME = 'Системный день',
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
    NAME = 'Системная сущность',
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
    NAME = 'Тип системных сущностей',
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
    NAME = 'Перечисление (custom)',
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
    NAME = 'Системная информация',
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
    NAME = 'Системный месяц',
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
    NAME = 'Права доступа',
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
    NAME = 'Системные настройки',
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
    NAME = 'Системный квартал',
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
    NAME = 'Справочник (custom)',
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
    NAME = 'Роль',
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
    NAME = 'Пользователь',
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
    NAME = 'Роль пользователя',
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
    NAME = 'Системные переменные',
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
    NAME = 'Задача',
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
    NAME = 'Контакты по задаче',
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
    NAME = 'Контекст модуля <Задачи>',
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
    NAME = 'Сотрудники по задаче',
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
    NAME = 'Приоритет задачи',
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
    NAME = 'Результат задачи',
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
    NAME = 'Роль в задаче',
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
    NAME = 'Состояние задачи',
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
    NAME = 'Тип задачи',
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
    NAME = 'Налог',
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
    NAME = 'Форма печати налога',
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
    NAME = 'Налоговая накладная',
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
    NAME = 'Строчки налоговой накладной',
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
    NAME = 'Шаблон проводки',
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
    NAME = 'Строчки шаблона проводки',
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
    NAME = 'Единица измерения',
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
    NAME = 'WEB ресурс',
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
    NAME = 'Завод',
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
    NAME = 'Цех',
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


