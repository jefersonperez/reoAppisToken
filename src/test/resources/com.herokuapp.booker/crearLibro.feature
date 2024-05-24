Feature: Como usuario de la API, quiero crear una reserva con la API CreateBooking y validar la respuesta

  @CreateBooking
  Scenario: Crear dos reservas y validar la respuesta
    Given Que se requiere crear una reserva con la siguiente informacion
      | firstname | lastname         | totalprice | depositpaid | checkin     | checkout    | additionalneeds |
      | Pedro     | Gutierrez        | 100        | true        | 2024-03-01  | 2024-04-01  | Comics          |
      | Javier    | Jaramillo        | 356        | true        | 2024-03-15  | 2024-04-15  | Terror          |
    When Se hace la solicitud para crear una reserva