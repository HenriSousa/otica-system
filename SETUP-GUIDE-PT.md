# 🛠️ Guia de Instalação e Configuração - Ótica System

## ✅ Pré-requisitos

1. **Java 17 JDK**
   - Download: https://adoptium.net/
   - Verificar: `java -version`

2. **Node.js 18+**
   - Download: https://nodejs.org/
   - Verificar: `node -v` e `npm -v`

3. **MySQL 8**
   - Download: https://www.mysql.com/downloads/
   - Verificar: `mysql --version`

4. **Maven 3.8+** (geralmente incluído com Java)
   - Verificar: `mvn --version`

## 📦 Passo 1: Configurar Banco de Dados MySQL

1. **Abra o terminal/prompt do MySQL:**
   ```bash
   mysql -u root -p
   ```

2. **Crie a database:**
   ```sql
   CREATE DATABASE otica_system CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
   ```

3. **Crie um usuário (opcional, para segurança):**
   ```sql
   CREATE USER 'otica_user'@'localhost' IDENTIFIED BY 'sua_senha_aqui';
   GRANT ALL PRIVILEGES ON otica_system.* TO 'otica_user'@'localhost';
   FLUSH PRIVILEGES;
   ```

4. **Verifique a conexão:**
   ```sql
   USE otica_system;
   SHOW TABLES;
   ```

## 🔧 Passo 2: Configurar Backend (Java/Spring Boot)

1. **Abra o arquivo de configuração:**
   ```
   src/main/resources/application.properties
   ```

2. **Atualize as configurações do banco de dados:**
   ```properties
   # MySQL Configuration
   spring.datasource.url=jdbc:mysql://localhost:3306/otica_system?useSSL=false&serverTimezone=UTC
   spring.datasource.username=root
   spring.datasource.password=sua_senha_do_mysql
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

   # Hibernate Configuration
   spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=false
   spring.jpa.properties.hibernate.format_sql=true

   # Application Configuration
   server.port=8080
   spring.application.name=otica-system
   ```

3. **Compile o projeto:**
   ```bash
   cd c:\Users\Pichau\Desktop\otica-system
   mvn clean install
   ```

4. **Inicie o servidor:**
   ```bash
   mvn spring-boot:run
   ```

   Você verá:
   ```
   Started OticaSystemApplication in 2.4 seconds
   Tomcat started on port 8080
   ```

   ✅ Backend rodando em: `http://localhost:8080`

## 🎨 Passo 3: Configurar Frontend (Angular)

1. **Abra um novo terminal e navegue para o frontend:**
   ```bash
   cd c:\Users\Pichau\Desktop\otica-system\frontend
   ```

2. **Instale as dependências do Node:**
   ```bash
   npm install
   ```
   
   Aguarde enquanto todas as dependências são baixadas (pode levar alguns minutos).

3. **Inicie o servidor de desenvolvimento do Angular:**
   ```bash
   npm start
   ```

   Você verá:
   ```
   Application bundle generation complete. [X.XXX seconds]
   Server is listening on http://localhost:4200
   ```

   ✅ Frontend rodando em: `http://localhost:4200`

## 🌐 Acessar a Aplicação

1. **Abra seu navegador**
2. **Acesse:** `http://localhost:4200`
3. **Você verá a página de Gerenciamento de Clientes**

## ✔️ Verificando se está funcionando

### Criar um Cliente de Teste

1. Clique em **"+ Novo Cliente"**
2. Preencha os campos:
   - **Nome**: João da Silva
   - **Telefone**: 11987654321
   - **CPF**: 12345678901
   - **Data de Nascimento**: 1990-01-01
   - **Endereço**: Rua Principal, 123
   - **Bairro**: Centro
   - **Ponto de Referência**: Próximo à farmácia
3. Clique em **"Criar"**

### Listar Clientes

- A página deve exibir o cliente criado em uma tabela
- Você pode editar ou deletar o cliente

## 🔗 API - Testar Endpoints

Use Postman ou curl para testar a API:

### Listar Clientes
```bash
curl http://localhost:8080/api/customers
```

### Criar Cliente
```bash
curl -X POST http://localhost:8080/api/customers \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Maria Silva",
    "phone": "11987654322",
    "cpf": "98765432109",
    "birthDate": "1995-05-15",
    "address": "Avenida Secundária, 456",
    "neighborhood": "Vila Nova",
    "referencePoint": "Próximo ao mercado"
  }'
```

## 🐛 Troubleshooting

### Erro: "Connection refused" ao conectar no MySQL
```
Solução: Certifique-se de que MySQL está rodando
Windows: Verifique em Serviços (Services)
```

### Erro: "Port 8080 already in use"
```
Solução 1: Feche a aplicação anterior ou
Solução 2: Altere a porta em application.properties:
  server.port=8081
```

### Erro: "Port 4200 already in use"
```
Solução: Use ng serve --port 4201
```

### Erro: "npm: command not found"
```
Solução: Reinstale Node.js ou adicione ao PATH do sistema
```

### NPM install lento
```
Solução: Use npm ci em vez de npm install
ou configure um registrador mais rápido:
npm config set registry https://registry.npmmirror.com
```

## 📁 Estrutura de Pastas Esperada

```
otica-system/
├── src/
│   ├── main/
│   │   ├── java/com/otica_system/
│   │   │   ├── domain/customer/
│   │   │   ├── dto/customer/
│   │   │   ├── service/customer/
│   │   │   ├── repository/customer/
│   │   │   ├── controller/customer/
│   │   │   ├── exception/
│   │   │   └── OticaSystemApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── frontend/
│   ├── src/
│   │   ├── app/
│   │   │   ├── components/
│   │   │   ├── services/
│   │   │   ├── models/
│   │   │   └── app.component.ts
│   │   ├── main.ts
│   │   └── styles.scss
│   ├── package.json
│   └── angular.json
├── pom.xml
└── README.md
```

## 🚀 Próximos Passos

1. **Familiarize-se com o código backend:**
   - Explore as entidades em `src/main/java/com/otica_system/domain/`
   - Veja os controllers em `src/main/java/com/otica_system/controller/`

2. **Explore o código frontend:**
   - Veja os componentes em `frontend/src/app/components/`
   - Veja os serviços em `frontend/src/app/services/`

3. **Desenvolva novos recursos:**
   - Adicione novos módulos (Inventory, Orders, etc.)
   - Implemente novas telas e componentes

## 📚 Referências

- **Spring Boot**: https://spring.io/projects/spring-boot
- **Angular**: https://angular.io/
- **MySQL**: https://dev.mysql.com/doc/
- **TypeScript**: https://www.typescriptlang.org/

## 💡 Dicas Úteis

1. **IDE Recomendada para Backend**: IntelliJ IDEA ou VS Code com extensões
2. **IDE Recomendada para Frontend**: VS Code com extensões Angular
3. **Debugging Frontend**: Use DevTools do navegador (F12)
4. **Debugging Backend**: Use debugger do VS Code ou IntelliJ

## 📞 Suporte

Se encontrar problemas, verifique:
1. Todas as pré-requisitos estão instaladas corretamente
2. Banco de dados MySQL está rodando
3. Portas 8080 e 4200 estão disponíveis
4. Verificar console para mensagens de erro específicas

---

**Boa sorte com o Ótica System!** 🎉
