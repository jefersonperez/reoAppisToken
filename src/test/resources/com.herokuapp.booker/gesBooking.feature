Feature: Consulta de reserva de libros

  Scenario: Consultar la reserva de libros creados anteriormente
    Then El estado de la solicitud debe ser 200
    And El valor del campo firstname debe coincidir con el enviado en el request del paso anterior