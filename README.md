# Sistema de Gerenciamento de uma Biblioteca

Este é um sistema de gerenciamento de biblioteca construído em Java, utilizando a biblioteca Swing para a interface gráfica. Ele se conecta a um banco de dados MySQL através do phpMyAdmin.
Foi um projeto realizado no 5º módulo de Java da Ada.

O sistema permite aos usuários realizar várias operações, incluindo:

- Adicionar livros ao sistema
- Deletar livros
- Emprestar livros
- Devolver livros
- Buscar livros por autor ou título

Essas funcionalidades tornam o gerenciamento de uma biblioteca mais eficiente e organizado.

## Dependências

O projeto utiliza as seguintes dependências:

- `mysql-connector-java-5.1.47.jar`
- `rs2xml.jar`
- `mysql-connector-java-5.1.47-bin.jar`

Essas dependências estão localizadas na pasta `dependencies` do projeto.

## Configuração do Banco de Dados

Este projeto requer um banco de dados MySQL local. No nosso caso, utilizamos o MySQL através do XAMPP.

_Obs: Existe a possibilidade de utilizar outro banco SQL que não seja o MySQL propriamente dito, mas será necessário atualizar o método "connect()" para o banco escolhido, isto na seguinte instrução:_
```bash
Class.forName("com.mysql.jdbc.Driver")
```
E também, na url de conexão:
```bash
con = DriverManager.getConnection("jdbc:mysql://localhost/librarydb", "root", "");
```


Após instalar e iniciar o MySQL através do XAMPP, você deve importar o arquivo `.sql` fornecido para criar o banco de dados necessário para este sistema, isso pode ser realizado através da interface do phpMyAdmin.

## Como Construir o Projeto

Para fazer a execução do projeto, é necessário instalar as dependências, principalmente para fazer a execução da interface gráfica. Caso esteja utilizando o Intelij IDEA, isso pode ser feito através de `File > Project Structure`:

![FileProjectStructure](https://github.com/GestaoBiblioteca/gestao-biblioteca/assets/151157576/db9e5df9-2ebe-41a3-99eb-9215ca2e72b0)


Após seguindo em:
1. Project `Settings > Modules`
2. Selecionando `Dependencies`
3. Clicando no símbolo de `+`
4. Clicando na primeira opção `JAR or Directories...`


![ProjectSettings](https://github.com/GestaoBiblioteca/gestao-biblioteca/assets/151157576/6295ec69-c4a0-4a5a-bfb1-1dca24a8cc06)

Depois é só adicionar os arquivos JAR das dependências, como na imagem a seguir:
![SelectingDependencies](https://github.com/GestaoBiblioteca/gestao-biblioteca/assets/151157576/fce53f49-4662-4d98-ac10-7f07442dae48)

E por fim, é importante lembrar de selecionar a dependência, aplicar e apertar em `OK` para fechar a página.

Pronto! Projeto devidamente configurado para ser executado!

