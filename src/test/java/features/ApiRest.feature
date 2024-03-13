# language: en

  Feature: API/Rest de Marcas de Maquiagem

  Scenario: Realizar uma consulta de fabricante de maquiagem
    Given o envio de uma requisição GET ou POST para o endPoint "https://makeup-api.herokuapp.com/api/v1/products.json"
    And para consultar com makeup por "maybelline"
    When enviar essa requisição GET
    Then devo receber um status code 200 de response
    And deve receber um json de response com "maybelline"

  Scenario: Realizar um POST em um endPoint gratuito
    Given o envio de uma requisição GET ou POST para o endPoint "https://jsonplaceholder.typicode.com/posts"
    And informar um userId
    And informar um id
    And informar um title "Titulo"
    And informar um body "Teste de POST"
    When enviar essa requisição POST
    Then devo receber um status code 200 de response

