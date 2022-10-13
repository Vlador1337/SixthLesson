Feature: Авторизация на сайте

  Scenario: Авторизация пользователя в Jira
    Given Пользователь перешел по ссылке "https://edujira.ifellow.ru/"
    Then  Пользователь авторизовался введя логин "ivanov" и пароль "Qwerty123"

