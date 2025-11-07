@CreacionUsuario
Feature: Gestión de usuarios en Petstore API

  Scenario Outline: Ciclo completo de gestión de usuario
    Given creo un nuevo usuario con username "<username>", nombre "<nombre>", apellido "<apellido>" y email "<email>"
    When consulto el usuario creado
    Then el sistema debe mostrar el usuario con código 200
    When actualizo el usuario con nuevo nombre "<nuevo_nombre>" y email "<nuevo_email>"
    Then la actualización debe ser exitosa con código 200
    And elimino el usuario
    Then la eliminación debe ser exitosa con código 200

    Examples:
      | username  | nombre   | apellido | email           | nuevo_nombre | nuevo_email     |
      | juan123   | Juan     | Pérez    | juan@mail.com   | Juan Pablo   | juanp@mail.com  |
      | ana456    | Ana      | García   | ana@mail.com    | Ana María    | anam@mail.com   |