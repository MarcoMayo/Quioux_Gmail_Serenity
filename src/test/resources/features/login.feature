# new feature
# Tags: optional

Feature: Login Gmail

  Background:
    Given the user is on the main page

  Scenario Outline: Send mail successfully
    Given the user logged in with "<username>" and "<password>"
    When he creates a new email to "<user>" and attaches the file "<attachment>"
    Then he can see the success message

    Examples:
      | username                 | password         | attachment      | user                                |
      | test.quipux.01@gmail.com | contrasena123456 | MODELO DE DATOS | pruebautomatizacionquipux@gmail.com |
      | test.quipux.01@gmail.com | contrasena123456 | PRUEBA TECNICA  | pruebautomatizacionquipux@gmail.com |
