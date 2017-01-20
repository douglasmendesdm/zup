# Douglas Mendes ZUP

Cadastro de Produtos Java - 
Para executar o programa é preciso ter instalado o MongoDB, é preciso também do maven para fazer o build do projeto, o servidor usado é jetty!

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
Após baixar o projeto, abrir a pasta onde está o arquivo e fazer o build usando o maven ({diretorio_maven}/mvn install).
Em seguida iniciar o mongoDB
O último passo é voltar a pasta zup_parente e excutar o seguinte comando maven ({{diretorio_maven}/mvn jetty:run}), isso vai subir a aplicação usando o jetty
a url é http://localhost:8080/app/zup/index.xhtml
```