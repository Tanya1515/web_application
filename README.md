# Web application for Law firm 

**Use Cases для Web-приложения**

**Страницы:** 

**Страница авторизации:**

Сотрудник юридической фирмы авторизуется по номеру телефона, затем его вниманию предстают 3 опции:
+ Клиенты (ссылка на страницу, содержащую список клиентов)
+ Сотрудники (ссылка на страницу, содержащую список сотрудников)
+ Регистрация договора
		
**Страница, содержащая список сотрудников «Сотрудники»:**

(опция - кнопка выбора из выпадающего списка услуг/клиентов/дат обращения или окончания работы)
+ список сотрудников (имя/фамилия)
+ «Добавить сотрудника» (ссылка, переадресующая на страницу добавления пользователя (сотрудника))
+ опция «Выбор услуги»
+ опция «Выбор клиента»
+ опция «Дата обращения»
+ опция «Дата окончания работы»


**Страница, содержащая список клиентов  «Клиенты»:**

(опция - кнопка выбора из выпадающего списка услуг/сотрудников/дат обращения или окончания работы)
+ список клиентов (имя/фамилия или наименование организации)
+ «Добавить клиента»  (ссылка, переадресующая на страницу добавления пользователя (клиента))
+ опция «Выбор услуги»
+ опция «Выбор сотрудника»
+ опция «Дата обращения»
+ опция «Дата окончания работы»

**Страница редактирования, содержащая информацию о конкретном сотруднике:**
+ имя/фамилия
+ телефон 
+ e-mail
+ образование
+ должность
+ стаж работы 
+ домашний адрес
+ «История услуг» (ссылка, переадресующая на страницу «История услуг», которая содержит информацию об оказанных услугах)     
+ кнопка «Сохранить»
+ кнопка «Удалить сотрудника»   

**Страница редактирования, содержащая информацию о конкретном клиенте:**
+ имя/фамилия или наименование организации
+ телефон 
+ e-mail
+ «История услуг» (ссылка, переадресующая на страницу «История услуг», которая содержит информацию об оказанных услугах) 
+ кнопка «Сохранить»
+ кнопка «Удалить клиента»

**Страница добавления пользователя:**
+ имя/фамилия
+ телефон
+ e-mail
+ образование (в случае если пользователь - сотрудник) 
+ должность (в случае если пользователь - сотрудник)
+ стаж работы (в случае если пользователь - сотрудник)
+ домашний адрес (в случае если пользователь - сотрудник)
+ кнопка «Добавить»

**Страница «История услуг»:**

(содержит список оказанных услуг, каждая строка которого включает следующие поля с информацией)
+ название услуги
+ стоимость 
+ дата обращения
+ дата окончания работы

**Страница регистрации договора об услуге «Регистрация договора»:**

(опция - кнопка выбора из выпадающего списка клиентов/услуг/сотрудников)
+ опция «Выбор клиента»
+ опция «Выбор услуги»
+ опция «Выбор сотрудника»
+ дата обращения (заполняется вручную)
+ дата окончания работы (заполняется вручную)
+ кнопка «Готово»

**Действия, доступные в этом приложении:**
**Действия производимые над информацией о пользователе:**

**Добавление:**

Страница, содержащая список клиентов  «Клиенты» -> «Добавить» -> Страница добавления пользователя -> «Добавить»

**Удаление:**

Страница, содержащая список клиентов  «Клиенты» -> выбор необходимых опций (Услуга, сотрудник, дата обращения, дата окончания работы) 
-> получение списка клиентов -> выбор профиля клиента по имени/фамилии/ -> «Удалить»

**Чтение:**

Страница, содержащая список клиентов  «Клиенты» -> выбор необходимых опций (Услуга, сотрудник, дата обращения, дата окончания работы) -> получение списка клиентов 
-> выбор профиля клиента по имени/фамилии
		
**Редактирование:**

Страница, содержащая список клиентов  «Клиенты» -> выбор необходимых опций (Услуга, сотрудник, дата обращения, дата окончания работы) -> получение списка клиентов 
-> выбор профиля клиента по имени/фамилии -> внесение необходимых изменений -> «Сохранить»

**Регистрация договора об оказании услуг:**

Страница регистрации договора об услуге «Регистрация договора» -> «Готово»

**Получение списка клиентов, в т.ч. по оказываемым услугам в заданном интервале времени, задействованным служащим:** 

Страница, содержащая список клиентов  «Клиенты» ->  выбор необходимых опций (Услуга, сотрудник, дата обращения, дата окончания работы) -> получение списка клиентов

**Получение списка служащих по их участию в оказании услуг заданным клиентам и в заданное время:**

Страница, содержащая список клиентов  «Сотрудники» ->  выбор необходимых опций (Услуга, клиент, дата обращения, дата окончания работы) -> получение списка сотрудников


