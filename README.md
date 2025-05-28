
# 📦 RestAssuredStudies

Repositório com exemplos básicos de testes de API utilizando o framework [Rest Assured](https://rest-assured.io/) em Java. Ideal para iniciantes que desejam aprender a realizar operações CRUD (Create, Read, Update, Delete) em APIs RESTful.

## 🚀 Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **Rest Assured**: Biblioteca para testes de APIs REST.
- **JUnit**: Framework de testes unitários.
- **Maven**: Gerenciador de dependências e automação de build.
- **MAMP**: Ambiente local para desenvolvimento com Apache, MySQL e PHP.

## 📁 Estrutura do Projeto

```
RestAssuredStudies/
├── .idea/                   # Configurações do IntelliJ IDEA
├── API TESTING/             # Onde a API e o BD estão
|   └──api_testing/
|      └──config/
|         └──database.php                     
├── end/
│   └── api-testing/         # Scripts de testes de API
├── guia_conexao_mamp_mysql.md  # Guia para conexão com MySQL via MAMP se erro
├── pom.xml                  # Arquivo de configuração do Maven
└── README.md                # Este arquivo
```

## 🧪 Exemplos de Testes

Os testes estão localizados no diretório `end/api-testing/` e cobrem as seguintes operações:

- **GET**: Recuperar recursos.
- **POST**: Criar novos recursos.
- **PUT**: Atualizar recursos existentes.
- **DELETE**: Remover recursos.

Exemplo de teste GET:

```java
@Test
public void getCategories() {
    String endpoint = "http://localhost:8888/api_testing/category/read.php";

    ValidatableResponse response = given()
            .when()
            .get(endpoint)
            .then();

    response.log().body();
}
```

## ⚙️ Configuração do Ambiente

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/adlernatanael/RestAssuredStudies.git
   ```

2. **Importe o projeto no IntelliJ IDEA:**

   - Selecione a opção "Import Project".
   - Escolha o arquivo `pom.xml` para importar as dependências do Maven.

3. **Configure o MAMP:**

   - Inicie o MAMP.
   - Verifique as portas configuradas para Apache e MySQL.
   - Certifique-se de que o banco de dados `ApiTestingDB` está criado.
   - **Importante**: Copie a pasta `api_testing` para o **Document Root** configurado no MAMP, normalmente localizado em `htdocs`. Isso garante que a API fique acessível via `http://localhost:8888/api_testing/`.

4. **Atualize as configurações de conexão no arquivo `Database.php`:**

   ```php
   private $host = "127.0.0.1";
   private $port = "8889"; // Porta padrão do MySQL no MAMP
   private $db_name = "ApiTestingDB";
   private $username = "root";
   private $password = "root";
   ```

   > Consulte o arquivo `guia_conexao_mamp_mysql.md` para mais detalhes se houver erro.

## 📄 Guia de Conexão com MySQL via MAMP

Para resolver erros de conexão com o MySQL ao utilizar o MAMP, siga as instruções detalhadas no arquivo [guia_conexao_mamp_mysql.md](../guia_conexao_mamp_mysql.md).

## 🤝 Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.

## 📄 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

---

> Desenvolvido por [Adler Natanael](https://github.com/adlernatanael)
