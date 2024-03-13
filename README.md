## Описание
Приложение сборная солянка, через которое можно узнать историю матчей в баскетболе, новости о баскетболе, создать и сохранить заметки, отсортировать новости по календарю (ui работает, сортировка не работает), развлечься и поиграть в игру "три в ряд" с зачислением очков.

## О проекте
Все данные хранятся локально.
Архитектура проекта старается следовать принципам Clean architecture, и делится на модули:

* app - модуль, который знает обо всех модулях в проекте и выступает местом для хранения всех зависимостей (в классе MainApp)
* common - модуль для хранения общей на проект информации: расширений классов, сущностей для обмена данными между слоями ui, domain, data, настроек темы, и ресурсов
* data - модуль для работы с внутренней БД
* ui-* - модули для хранений экранов и вью моделей для них
* domain - модуль для выполнения бизнес логики и подтягивания данных из слоя data в слой ui

## Скриншоты

<img src="https://github.com/askosarygin/SportsNews/assets/77168356/3329df45-d421-4f94-80df-3dd583c07d3b" alt="drawing" width="200"/>
<img src="https://github.com/askosarygin/SportsNews/assets/77168356/d7cba8db-9195-468a-b75f-2b8b9c06c7c8" alt="drawing" width="200"/>
<img src="https://github.com/askosarygin/SportsNews/assets/77168356/a5eaa6f2-5b93-44b8-88c9-6f7afc28acae" alt="drawing" width="200"/>
<img src="https://github.com/askosarygin/SportsNews/assets/77168356/e2836287-49a3-4fef-87c6-8a8226ba7979" alt="drawing" width="200"/>
<img src="https://github.com/askosarygin/SportsNews/assets/77168356/0d4ece7e-1e12-4045-9606-422446a29dce" alt="drawing" width="200"/>
<img src="https://github.com/askosarygin/SportsNews/assets/77168356/643ec2f3-247e-4767-901d-72bde74504ff" alt="drawing" width="200"/>
<img src="https://github.com/askosarygin/SportsNews/assets/77168356/8bd7f886-beb6-4277-b0ec-0ef649f77a30" alt="drawing" width="200"/>
