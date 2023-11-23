# Health Hub
Nossa solução se baseia em um aplicativo no qual é responsável por controlar dados de saúde e descobrir consumos calórios. 
Com este aplicativo você monitora os Batimentos cardíacos, Pressão arterial e Nível de Glicose armazenando o registro de todos os dados inseridos além, de uma calculadora de taxa metabólica com indicações para emagrecimento ou aumento de massa. 
Para monitorar estes dados, o aplicativo conta com um dispositivo IOT através de um arduino que monitora estes dados através de LEDS e conforme os dados são passados para o arduino, os LEDS mudam de cor entre verde, laranja ou vermelho para avaliação da saúde destes dados.


# Lista de Endpoints
## ***Usuários***
## GET 
https://healthhub-web.azurewebsites.net/usuarios
### Descrição: Consulta a lista de usuários cadastrados.
### Exemplo de resposta:
          
       {
        "id": 1,
        "nome": "Nome do Usuário",
        "email": "usuario@example.com",
        "senha": "$2a$10$ANAQD5GnQNlJGsyz4JJM5.gzYlNuOmBeP0HLZCKc9V3Srex1anRci"
      }


## POST
https://healthhub-web.azurewebsites.net/usuarios
### Descrição: Cadastra um novo usuario.
### Exemplo de solicitação:

         {
          "nome": "Renan Costa",
          "email": "renan@fiap.com.br",
          "senha": "senha123"
          }




## PUT 
https://healthhub-web.azurewebsites.net/usuarios/1
### Descrição: Atualiza informações sobre o usuario cadastrado.
### Exemplo de solicitação:

      {
        "nome": "Renan Costa",
        "email": "castilho@fiap.com.br",
        "senha": "senha123"
      }




## DELETE 
https://healthhub-web.azurewebsites.net/usuarios/1
### Descrição: Deleta o usuario selecionado. No caso deletará o usuario com o id = 1.

## ***Registros de Saúde***
## GET 
https://healthhub-web.azurewebsites.net/registros-saude
### Descrição: Consulta a lista de registros de saúde cadastrados. 
### Exemplo de resposta:
          
     {
        "content": [
          {
              "id": 1,
              "usuario": {
                  "id": 1,
                  "nome": "Nome do Usuário",
                  "email": "usuario@example.com",
                  "senha": "$2a$10$ANAQD5GnQNlJGsyz4JJM5.gzYlNuOmBeP0HLZCKc9V3Srex1anRci"
              },
              "pressaoArterial": 120.0,
              "batimentosCardiacos": 80,
              "nivelGlicose": 90.5,
              "dataRegistro": "2023-11-15"
          }
          

## POST
https://healthhub-web.azurewebsites.net/registros-saude
### Observação: Colocar id de um usuario ja cadastrado!
### Descrição: Cadastra um novo registro de saúde
### Exemplo de solicitação:

       {
          "usuario": {
          "id": 1,
          "nome": "Renan Costa",
          "email": "castilho@fiap.com.br",
          "senha": "senha123"
        },
          "pressaoArterial": 120.0,
          "batimentosCardiacos": 80,
          "nivelGlicose": 90.5,
          "dataRegistro": "2023-11-16"
        }



## PUT 
https://healthhub-web.azurewebsites.net/registros-saude/1
### Descrição: Atualiza informações sobre o registro de saúde cadastrado.
### Exemplo de solicitação:

    {
        "usuario": {
        "id": 1,
        "nome": "Renan Costa",
        "email": "castilho@fiap.com.br",
        "senha": "senha123"
    },
        "pressaoArterial": 120.0,
        "batimentosCardiacos": 75,
        "nivelGlicose": 90.5,
        "dataRegistro": "2023-11-16"
    }


## DELETE 
https://healthhub-web.azurewebsites.net/registro-saude/1
### Descrição: Deleta o usuario selecionado. No caso deletará o registro de saúde com o id = 1.
