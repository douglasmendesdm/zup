# Douglas Mendes ZUP

Cadastro de Produtos Java - 
Para executar o programa é preciso ter instalado o MongoDB, é preciso também do maven para fazer o build do projeto, o servidor usado é jetty!
A aplicação usa Spring, MongoDB, bootstrap

### Instalação

- [Instalação](#instalacao)
- [Deploy](#deploy)

<a name="instalacao"></a>
## Instalacao

```shell
git clone https://github.com/douglasmendesdm/zup.git
```

<a name="deploy"></a>
## Deploy

```shell
Após baixar o projeto, abrir a pasta onde está o arquivo(pasta onde se encontra o pom.xml) e fazer o build usando o maven ({diretorio_maven}\bin\mvn install).
Em seguida iniciar o mongoDB
O último passo é voltar a pasta zup e excutar o seguinte comando maven ({{diretorio_maven}\bin\mvn jetty:run}), isso vai subir a aplicação usando o jetty
a url é http://localhost:8080/zup 

### Atenção >>>>>>>> como se trata de uma aplicação para fins de prova de conhecimento a aplicação funciona apenas na porta 8080

```