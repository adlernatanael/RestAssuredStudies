Esse repositorio está sendo criado á base de um curso na plataforma Linkedin Learning
Java: Automated API Testing with REST Assured com a Angie Jones (Java Champion, Senior Director, and Master Inventor)
Usamos Junit, Maven, RestAssured, JDK 17 (mas estou utilizando JDK24), MySql no MAMP pra rodar Localmente
Como no intellij comunity não há possibilidade de conectar-se diretamente com o Banco de Dados,
utilizei-me do plugin Database Navigator e do ChatGpt para o erro apresentado nesse documento

# 📄 Guia: Corrigindo Erro de Conexão com MySQL no MAMP

## ❗ Erro apresentado:

```
Connection error: SQLSTATE[HY000] [2002] Nenhuma conexão pôde ser feita porque a máquina de destino as recusou ativamente
```

Esse erro acontece quando:  
- A **porta do MySQL** está incorreta.  
- O **servidor MySQL** não está ativo.  
- A **string de conexão** está incompleta ou incorreta.

---

## ✅ Cenário:

- Ambiente local com **MAMP**.
- Banco de dados: **MySQL**.
- API escrita em **PHP** com conexão via **PDO**.
- Configuração padrão do MAMP:  
  - Porta: `8889`  
  - Usuário: `root`  
  - Senha: `root`

---

## ✅ Passo a Passo para Resolver:

### 1. Confirme a porta do MySQL no MAMP

1. Abra o **MAMP**.
2. Vá em: `Preferences` → `Ports`.
3. Confirme qual é a **porta do MySQL** (normalmente `8889`).

---

### 2. Verifique o banco de dados

1. Acesse o **phpMyAdmin**:  
   → `http://localhost:8888/phpMyAdmin`
2. Confirme se o banco de dados existe.  
   Exemplo: `ApiTestingDB`.

---

### 3. Corrija o arquivo de conexão (`Database.php`)

**Antes (errado):**

```php
$this->conn = new PDO("mysql:host=localhost;dbname=ApiTestingDB", "root", "root");
```

**Depois (correto):**

```php
<?php
class Database {

    private $host = "127.0.0.1";
    private $port = "8889";
    private $db_name = "ApiTestingDB";
    private $username = "root";
    private $password = "root";
    public $conn;

    public function getConnection(){
        $this->conn = null;

        try {
            $this->conn = new PDO(
                "mysql:host=" . $this->host . ";port=" . $this->port . ";dbname=" . $this->db_name,
                $this->username,
                $this->password
            );
            $this->conn->exec("set names utf8");
        } catch(PDOException $exception) {
            echo "Connection error: " . $exception->getMessage();
        }

        return $this->conn;
    }
}
?>
```

✅ **Importante**: Sempre incluir `port` na string de conexão.

---

### 4. Reinicie o servidor MAMP

- Clique em **Stop** → depois em **Start**.

---

### 5. Teste a conexão

1. No navegador:  
   → `http://localhost:8888/api_testing/category/read.php`
   
2. Ou rode seus testes usando:  
   - **Postman**  
   - **RestAssured**  
   - **Insomnia**

---

## ✅ Dicas adicionais:

- Sempre use `127.0.0.1` no MAMP, evita problemas com `localhost`.
- Se mudar a porta no MAMP, **atualize também no código**.
- Confirme que o **MySQL** está ativo no **MAMP**.

---

## ✅ Resumo rápido:

| Verificar         | O que fazer                                      |
|-------------------|--------------------------------------------------|
| Porta             | Confirmar no MAMP (`Preferences > Ports`).       |
| Banco             | Criar ou verificar no **phpMyAdmin**.            |
| String de conexão | Adicionar `port` na string PDO.                  |
| Servidor          | Sempre reiniciar o MAMP após mudanças.           |

---

## ✅ Exemplo de URL de teste:

```
http://localhost:8888/api_testing/category/read.php
```

---
**Criado por:** [Natanael e ChatGPT]
