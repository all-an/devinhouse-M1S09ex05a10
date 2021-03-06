# devinhouse-M1S09ex05a10
Módulo 1 - Semana 9 - Exercícios de 05 a 10

## Requisitos:

```xml
<properties>
		<java.version>11</java.version>
</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
```

## Para rodar:

```bash
git clone https://github.com/all-an/devinhouse-M1S09ex05a10.git
cd devinhouse-M1S09ex05a10
```
#### Abrir com Spring Tools Suite 4
#### Rodar como aplicação Spring Boot

## Exercício 05

- [x] Crie um Projeto Spring Framework que tenha uma entidade "Cliente". 
O programa deve ser capaz de:

- [x] Criar um novo objeto Cliente.
- [x] Pesquisar todos os Clientes
- [x] Deletar um Cliente específico com base no seu ID
- [x] Alterar um Cliente com base no seu ID
- [x] Pesquisar um Cliente com base no seu ID

- [x] O Cliente precisa ter um nome e o CPF e o serviço de validação do CPF antes de criar um novo cliente.

## Exercício 06

- [x] No Projeto Spring Framework, adicione uma entidade !Conta! . 
O programa deve ser capaz de:

- [x] Criar um novo objeto Conta  

Endpoint /contas
POST

```json
{
	"id": 3,
	"cliente": {
		"id": 1,
		"name": "José Vieira",
		"cpf": "67024317086"
	},
	"saldo": 0.0
}
```
- [x] Pesquisar todos os objetos Conta 
- [x] Deletar um objeto Conta específico com base no seu ID
- [x] Alterar um objeto Conta com base no seu ID
- [x] Pesquisar um objeto Conta com base no seu ID

- [x] A Conta deve ter um cliente vinculado a ela e ser criada com um valor zerado.
- [x] Deve ser possível realizar depósitos e saques de valores de uma Conta, porém o valor na Conta nunca pode ficar negativo.

/contas/deposito/{id}
/contas/saque/{id}
```json
{
    "id": 1,
    "valorOperacao": 500.0
}
```

- [x] Exercício 7

Com base no programa criado com o  Spring Framework, crie um programa Spring Boot que nos permita realizar o cadastro e a consulta das entidades "Conta" e "Cliente". 
Essas funcionalidades devem ser feitas por meio de requisições HTTP:

- As requisições devem ser POST para cadastro e GET para consulta.
- As requisições devem ser feitas nos endpoints /cliente e no /conta.
- As requisições devem ser no padrão JSON.

- [x] Exercício 8

Agora expandindo as funcionalidades do programa anterior, devemos ser capazes de realizar todas as operações CRUD(Create, Read, Update, Delete) tanto para a "Conta" quanto para o "Cliente".

- Os endpoints devem ser os mesmos
- A operação de Update deve ser feita por meio do PUT e deve usar o ID da entidade em questão, seja ela Cliente ou Conta.
- A operação de Delete deve ser feita por meio do Delete, e deve também usar o ID da entidade em questão.





