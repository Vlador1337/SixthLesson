Feature: Работа с задачами в Jira

  Background:
    Given Пользователь перешел по ссылке "https://edujira.ifellow.ru/"
    Then  Пользователь авторизовался введя логин "ivanov" и пароль "Qwerty123"

  Scenario: Открыть проект и проверить количество задач в нем
    Given Пользователь открыл проект
    Then  Проверяем количество задач

  Scenario: Найти задачу TestSelenium_bug и проверить статус
    Given Пользователь ищет задачу "TestSelenium_bug"
    Then  Проверить статус задачи TestSelenium_bug

  Scenario: Найти задачу TestSelenium_bug и проверить версию
    Given Пользователь ищет задачу "TestSelenium_bug"
    Then  Проверяем версию в задаче TestSelenium_bug