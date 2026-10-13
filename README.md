# Health Hub API — Deploy em Nuvem

![Java](https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.1-6DB33F?logo=springboot&logoColor=white)
![Azure](https://img.shields.io/badge/Azure_App_Service-0078D4?logo=microsoftazure&logoColor=white)
![GitHub Actions](https://img.shields.io/badge/CI%2FCD-GitHub_Actions-2088FF?logo=githubactions&logoColor=white)

Esta é a versão da [Health Hub API](https://github.com/RenanCCastilho/HealthHub-API) preparada para produção no **Azure App Service**. O deploy é contínuo e feito com **GitHub Actions**.

A cada push na branch `main`, o pipeline compila o projeto com Maven, gera o `.jar` e publica no Web App `HealthHub-web`.

## Pipeline de CI/CD

```
push na main ──► build (Maven, Java 17) ──► artefato .jar ──► deploy no Azure App Service
```

O workflow está em [`.github/workflows/main_healthhub-web.yml`](.github/workflows/main_healthhub-web.yml). Já o plano de serviço usado no Azure aparece em [`Print_VisaoGeral/`](Print_VisaoGeral).

## Sobre a API

A API controla dados de saúde do usuário: batimentos cardíacos, pressão arterial e nível de glicose. Ela usa Spring Security com HTTP Basic, senhas com hash BCrypt e persistência em Oracle via Spring Data JPA.

| Método | Rota | Descrição |
|---|---|---|
| `GET` / `POST` | `/usuarios` | Lista ou cadastra usuários |
| `GET` / `PUT` / `DELETE` | `/usuarios/{id}` | Consulta, atualiza ou remove usuário |
| `GET` / `POST` | `/registros-saude` | Lista ou cadastra registros de saúde |
| `GET` / `PUT` / `DELETE` | `/registros-saude/{id}` | Consulta, atualiza ou remove registro |
| `GET` | `/registros-saude/search?nomeUsuario=` | Busca paginada por usuário |

## Configuração

As credenciais do banco são lidas de variáveis de ambiente. No Azure, elas ficam em *Configuração → Configurações do aplicativo*.

| Variável | Obrigatória | Descrição |
|---|---|---|
| `DB_USERNAME` | sim | Usuário do Oracle |
| `DB_PASSWORD` | sim | Senha do Oracle |
| `DB_URL` | não | JDBC URL (padrão: Oracle da FIAP) |
| `ADMIN_PASSWORD` | não | Senha do usuário `admin` da API |

Para executar localmente:

```bash
export DB_USERNAME=seu_usuario DB_PASSWORD=sua_senha
./mvnw spring-boot:run
```

---

Projeto acadêmico desenvolvido na **FIAP** (Global Solution, 2023).
