# CheckoutE-commerce
API de checkout para E-commerce


## Objetivo
Esta documentação tem como objetivo a exposição da ferramenta de checkout para sistemas de E-commerce.

## Instalando a aplicação
	
O arquivo docker-compose se encontra na raiz do projeto: 	
  > docker-compose.yml  
  
	  
Link para o repositório do GitHub:   
https://github.com/igorpserra/CheckoutE-commerce  
Link DokerHub:  
https://hub.docker.com/repository/docker/igorps/ecommerce_backend  
Link Collection Postman:  
https://www.getpostman.com/collections/8b79492c495e5f40c2f1  

## Utilizando a ferramenta
Inicialmente é necessário informar ao sistema qual o usuário que efetuará a compra. Os clientes cadastrados podem ser visualizados através da URL:  
  
 ```
 GET localhost:8080/cliente/procurar/all  
```
Após isto, basta informar na URL o nome do usuário que realizará a compra, no exemplo abaixo, foi utilizado o PulseCompras:    

```
POST localhost:8080/pedido/inicio?user=PulseCompras  
```
  
Neste momento o carrinho já foi iniciado e os produtos já podem ser adicionados. Para checar os produtos existentes, basta consultar a URL:  
  
  ```
GET localhost:8080/produtos  
  ```
  
Através dos dados retornados, é possível adicionar ou remover itens do carrinho de acordo com o id do produto por meio das URLs:  
  
  ```
POST localhost:8080/pedido/adicionar?id=”id do produto”
```
```
DELETE localhost:8080/pedido/remover?id=”id do produto”
```
  
Após adicionar os produtos, o carrinho pode ser pré-visualizado através da URL:  
  
```
GET localhost:8080/pedido/carrinho
```
  
Para finalizar a compra, após a adição dos itens, basta acessar a URL e fornecer os dados da compra:  
  
```
POST localhost:8080/pedido/checkout
```
  
É necessário informar no corpo da requisição o tipo de pagamento, a transportadora e o cupom de desconto, caso haja.
Quantos aos tipos de pagamento:  

| Tipo |	Desconto |
|-------|------------|
|VISTA	|5% de desconto|
|BOLETO	|5% de desconto|
|PARCELADO	|Sem desconto|
|CREDIARIO	|Sem desconto|

  
Para consultar as transportadoras e os fretes, basta acessar a URL:	
	
```
GET localhost:8080/pedido/checkout/transportadoras
```
	
E os cupons disponíveis em:	
	
```
GET localhost:8080/pedido/checkout/cupons
```
	
Desta forma, checkout será realizado de acordo com o exemplo:	
	
```
POST localhost:8080/pedido/checkout	
Json:	
{	
    "tipoPagamento":"PARCELADO",	
    "nomeTransportadora":"Transporte Ja",	
    "cupom":"Pulse10"	
}	
```
	
	
Por fim, para consultar o relatório de pedidos, utiliza-se a URL:	
	
```
GET localhost:8080/pedido/pedidos	
```
	
**No escopo deste protótipo, caso deseje adicionar um novo pedido, é necessário fazer o reload da aplicação e reafazer os passos descritos acima com os dados do novo pedido. Pedidos anteriores não serão apagados, continuarão gravados no BD**