#language: es
Característica: Como usuario de Bancolombia, quiero realizar la creación de una solicitud de servicio para segundas veces

  @LISTCASESALTERNATIVE
  Esquema del escenario: Realizo una consulta donde el usuario existe en listas de control

    Dado Que se requiere conocer la informacion detallada de las solicitud
      | userName   | password   |
      | <userName> | <password> |
    Cuando Se hace la busqueda del estado de solicitud con un solo filtro

    Ejemplos:
      | userName | password    |
      | admin    | password123 |



