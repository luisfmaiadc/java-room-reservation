<h1 align="center">Projeto Java - Sistema de Reservas de Sala com Hibernate</h1>
<p align="center">
 <a href="#started">Começando</a> • 
  <a href="#cloning">Clonando</a> •
 <a href="#creating">Banco de Dados</a> •
 <a href="#environment">Variáveis de Ambiente</a> •
 <a href="#colab">Colaboradores</a>
</p>

<p align="center" style="margin-bottom: 20;">
    <img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java" />
    <img src="https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL" />
    <img src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white" alt="Hibernate" />
    <img src="https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white" alt="Apache Maven" />
</p>

<p style="text-align: justify;">Este é um projeto desenvolvido em Java que implementa um Sistema de Reservas de Salas utilizando Hibernate para persistência de dados conforme a especificação JPA, com MySQL como banco de dados. A aplicação permite gerenciar usuários e salas, consultar disponibilidade e realizar reservas. As consultas são implementadas utilizando tanto JPQL quanto a API Criteria, demonstrando diferentes abordagens para acesso a dados.</p>

<h2 id="started">🚀 Começando</h2>

Antes de começar, verifique se você possui as seguintes ferramentas instaladas em sua máquina:

- [Java](https://www.oracle.com/java/technologies/downloads/#java22)
- [MySQL](https://dev.mysql.com/downloads/installer/)

<h2 id="cloning">👾 Clonando</h2>

Como clonar o projeto:
```bash
git clone git@github.com:luisfmaiadc/Java-Room-Reservation.git
```

<h2 id="creating">💾 Criando Banco de Dados</h2>
<p style="margin-bottom: 20;">Para que o projeto funcione corretamente, é necessário criar um banco de dados MySQL com o nome <i>dbReserva</i> e as seguintes tabelas:</p>

- <b>Usuario:</b> Armazena informações dos usuários do sistema.
- <b>Sala:</b> Armazena detalhes sobre as salas.
- <b>Reserva:</b> Registra as reservas realizadas pelos usuários, associando um usuário a uma sala.


```SQL
CREATE DATABASE dbReserva;
USE dbReserva;

CREATE TABLE Usuario (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) DEFAULT NULL,
    email VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Sala (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) DEFAULT NULL,
    descricao VARCHAR(255) DEFAULT NULL,
    capacidade INT DEFAULT NULL,
    disponivel BIT(1) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Reserva (
    id INT NOT NULL AUTO_INCREMENT,
    dataInicio DATETIME(6) DEFAULT NULL,
    dataFim DATETIME(6) DEFAULT NULL,
    dataReserva DATE DEFAULT NULL,
    idUsuario INT NOT NULL,
    idSala INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (idUsuario) REFERENCES Usuario(id),
    FOREIGN KEY (idSala) REFERENCES Sala(id)
);

```

<h2 id="environment">💻 Configurando variáveis de ambiente</h2>

Antes de rodar o projeto, é necessário criar um arquivo .env na raiz do projeto para configurar as variáveis de ambiente responsáveis pelo acesso ao banco de dados MySQL. O arquivo deve conter as seguintes variáveis:

```env
DB_URL=jdbc:mysql://localhost:3306/nome_do_banco
DB_USER=seu_usuario
DB_PASSWORD=sua_senha
```

<h2 id="colab">🤝 Colaboradores</h2>
<p style="margin-bottom: 20;">O projeto foi desenvolvido de forma independente, proporcionando uma experiência enriquecedora e contribuindo para o meu crescimento como desenvolvedor.</p>
<table>
  <tr>
    <td align="center">
      <a href="#">
        <img src="https://avatars.githubusercontent.com/u/168129517?v=4&size=64" width="100px;" alt="Luis Felipe Maia da Costa Profile Picture"/><br>
        <sub>
          <b>Luis Felipe Maia da Costa</b>
        </sub>
      </a>
    </td>
  </tr>
</table>



