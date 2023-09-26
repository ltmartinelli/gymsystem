# GYM SYSTEM

## Sobre o Projeto
Gym System é uma aplicação desenvolvida como projeto pessoal de estudo.

A aplicação consiste em um protótipo de sistema para uma franquia de academias, onde usuários podem registrar e alterar treinos e exercícios nos seus perfis pessoais, consultar as unidades e planos existentes, bem como detalhes sobre seu contrato e pagamentos associados, quando existentes.
Administradores podem adicionar contratos e pagamentos para os clientes, alterar estado dos pagamentos, dentre outras operações.

Alguns dos casos de uso do sistema incluem:

**Usuário Logado**
- Criar Treino
- Consultar Treino
- Consultar todos seus treinos
- Alterar Treino
- Deletar Treino
- Consultar seus dados pessoais
- Consultar seu contrato e lista de pagamentos associados
- Consultar um pagamento específico

**Todos os usuários**
- Consultar lista de unidades da franquia
- Consultar planos disponíveis

**Administrador**
- Procurar usuários por nome
- Adicionar contrato para um usuário
- Alterar estado de um pagamento específico

**Aplicação em Produção:** [https://ltm-gymsystem.netlify.app/](https://ltm-gymsystem.netlify.app/)

Perfil de Administrador para testar funcionalidades do front-end:
- Usuário:``fernando@outlook.com``
- Senha:``12345678``

## Modelo Conceitual
![Modelo Conceitual](https://raw.githubusercontent.com/ltmartinelli/gymsystem-images/main/GymSystemDomain.jpg)

# Tecnologias Utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- PostgreSQL
- JWT
- OAuth2

# Como executar o projeto

## Back end
Pré-requisitos: Java 17

```bash
# clonar repositório do back end
git clone https://github.com/ltmartinelli/gymsystem

# entrar na pasta backend do projeto
cd gymsystem/backend

# executar o projeto (de forma alternativa, pode ser executado através de uma IDE como IntelliJ ou STS)
mvn spring-boot:run
```

As requisições podem ser testadas com o software Postman, importando a seguinte coleção de requisições, bem como as variáveis de ambiente. O ambiente disponibilizado já permite que se utilize a requisição de autenticação para logar como um usuário administrador. 
- Arquivos para importar as requisições e ambiente: [DOWNLOAD](https://drive.google.com/drive/folders/1F9iqUWd9Ur4ZauAgsMx7FdFghpbGIUt7?usp=drive_link)

## Front end
Pré-requisitos: npm / yarn

```bash
# clonar repositório
git clone https://github.com/ltmartinelli/gymsystem

# entrar na pasta do projeto front end
cd gymsystem/frontend

# instalar dependências
yarn

# executar o projeto
yarn dev
```


# Autor

Lucas Trindade Martinelli

https://www.linkedin.com/in/ltmartinelli
