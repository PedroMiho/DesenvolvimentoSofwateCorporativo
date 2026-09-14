# Deploy no Render com GitHub Actions

Este projeto usa Java 21, Spring Boot, Docker e um banco MySQL externo. Nenhuma credencial deve ser salva no repositório.

## 1. Preparar o banco MySQL

Crie um banco MySQL acessível pela internet em um provedor de sua preferência. Anote:

- URL JDBC;
- usuário;
- senha.

Exemplo do formato da URL, sem dados reais:

```text
jdbc:mysql://HOST:3306/NOME_DO_BANCO?useSSL=true&serverTimezone=UTC
```

O Flyway executará automaticamente as migrations da pasta `src/main/resources/db/migration`.

## 2. Criar o serviço com o Blueprint

1. Acesse o Render.
2. Clique em **New +** e depois em **Blueprint**.
3. Conecte o repositório `PedroMiho/DesenvolvimentoSofwateCorporativo`.
4. O Render encontrará o arquivo `render.yaml` na raiz.
5. Informe as variáveis solicitadas:
   - `DB_URL`: URL JDBC do MySQL;
   - `DB_USERNAME`: usuário do banco;
   - `DB_PASSWORD`: senha do banco.
6. Aplique o Blueprint e aguarde o primeiro deploy.

O serviço usa `/actuator/health` para verificar a saúde da aplicação.

## 3. Criar o Deploy Hook

1. Abra o serviço **agendamento-odontologico** no Render.
2. Entre em **Settings**.
3. Localize **Deploy Hook** e copie a URL.
4. Não salve essa URL em arquivos do projeto.

O `render.yaml` deixa o deploy automático do Render desligado. Assim, o deploy acontece somente depois que o GitHub Actions conclui testes, build Maven e build Docker.

## 4. Salvar o hook como Secret no GitHub

1. Abra o repositório no GitHub.
2. Vá em **Settings > Secrets and variables > Actions**.
3. Clique em **New repository secret**.
4. Use o nome `RENDER_DEPLOY_HOOK_URL`.
5. Cole a URL do Deploy Hook e salve.

## 5. Executar o CI/CD

A automação está em `.github/workflows/agendamento-odontologico-cicd.yml`.

- Em pull requests, executa testes e valida o build.
- Em pushes para `main`, executa testes, gera o pacote, valida a imagem Docker e aciona o Render.
- Também pode ser iniciada manualmente em **Actions > Agendamento Odontologico CI/CD > Run workflow**.

## 6. Conferir o deploy

1. No GitHub, confira se os jobs **Testar e gerar pacote** e **Implantar no Render** ficaram verdes.
2. No Render, acompanhe os logs do deploy.
3. Teste `https://SEU-SERVICO.onrender.com/actuator/health`.
4. A resposta esperada é:

```json
{"status":"UP"}
```

## Variáveis locais

Para executar localmente, defina as mesmas variáveis no terminal ou na IDE:

```text
DB_URL=jdbc:mysql://localhost:3306/odonto
DB_USERNAME=root
DB_PASSWORD=sua_senha_local
```

Nunca publique arquivos `.env`, senhas do banco ou a URL do Deploy Hook.
