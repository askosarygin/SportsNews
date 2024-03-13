Приложение сборная солянка, через которое можно узнать историю матчей в баскетболе, новости о баскетболе, создать и сохранить заметки, отсортировать новости по календарю (ui работает, сортировка не работает), развлечься и поиграть в игру "три в ряд" с зачислением очков.

Все данные хранятся локально.

Архитектура проекта старается следовать принципам Clean architecture, и делится на модули:

* app - модуль, который знает обо всех модулях в проекте и выступает местом для хранения всех зависимостей (в классе MainApp)
* common - модуль для хранения общей на проект информации: расширений классов, сущностей для обмена данными между слоями ui, domain, data, настроек темы, и ресурсов
* data - модуль для работы с внутренней БД
* ui-* - модули для хранений экранов и вью моделей для них
* domain - модуль для выполнения бизнес логики и подтягивания данных из слоя data в слой ui
