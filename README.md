# 6dvp-netflix-support
Microserviço para abertura/consulta de chamados, trabalho conclusão de curso.

<p>Porta de execução: <b>8091</b></p>
## Segurança
<p>Para acessar as APIs necessário passar um token JWT no header da requisição para autorização.</p>
<p>Para gerar o token JWT válido, necessário utilizar o micro-serviço de autorização.</p>

## /swagger-ui
<p>Documentação detalhada das API</p>

## /openTicket
<p>Possibilita a abertura de um chamado através do envio de um JSON.</p>
<p>Nível de permissão: permitAll
<p><i>Exemplo do json</i></p>
<p>{</p>
<p>  "username": "teste",</p>
<p>  "subject": "teste",</p>
<p>  "description": "teste",</p>
<p>  "status": open</p>
<p>}</p>

## /getAllTickets
<p>Retorna lista com todos os chamados</p>
<p>Nível de permissão: permitAll
 
## /getTicketsByUser
<p>Retorna lista com todos os chamados por usuário</p>
<p>Parâmetro: <b>username</b></p>
<p>Nível de permissão: permitAll
 
## /getTicketsByStatus
<p>Retorna lista com todos os chamados por status.</p>
<p>Parâmetro: <b>status</b></p>
<p>Nível de permissão: permitAll
 
## Variáveis de ambiente.
<p>Configurações do MySQL</p>
<p>DB_SERVER = <i>Servidor do MySQL</i></p>
<p>DB_PORT = <i>Porta do servidor</i></p>
<p>DB_USERNAME =<i>Usuário</i></p>
<p>DB_PASSWORD =<i>Senha</i></p>

<p>Configurações do RabbitMQ</p>
<p>MQ_SERVER = <i>Servidor do RabbitMQ</i></p>
<p>MQ_PORT = <i>Porta do servidor</i></p>
<p>MQ_USERNAME =<i>Usuário</i></p>
<p>MQ_PASSWORD =<i>Senha</i></p>

## Dump Mysql
<p>Restaurar o arquivo de backup <i>support-db.sql</i> localizado na pasta <i>/data</i></p>

## Execução Docker
<p>docker build -t 6dvp-netflix/support:v1.0.0 .</p>
<p>docker run --name support -d -p 8091:8091 -e DB_SERVER=xxx.xxx.xxx.xxx -e DB_PORT=3306 -e DB_USERNAME=xxx -e DB_PASSWORD=xxx -e MQ_SERVER=xxx.xxx.xxx.xxx -e MQ_PORT=5672 -e MQ_USERNAME=xxx -e MQ_PASSWORD=xxx dvp-netflix/support:v1.0.0</p>
