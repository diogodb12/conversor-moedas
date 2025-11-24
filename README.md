# Conversor de Moedas 💱

## 🔍 Descrição
Este é um projeto de **Conversor de Moedas** desenvolvido como parte do **Challenge de Backend da Alura**. O programa utiliza a API exchangerate-api.com para consultar taxas de câmbio em tempo real e realizar conversões entre diversas moedas de maneira simples e eficiente.

## 📁 Estrutura do Projeto
O projeto é composto pelos seguintes arquivos principais:

- **`Main.java`** — Ponto de entrada do programa, onde o usuário interage com o conversor e escolhe a conversão de moeda.  
- **`ConversorDeMoedas.java`** — Contém a lógica para consultar a API e realizar a conversão de valores entre moedas.  
- **`Cotacao.java`** — Classe que representa as informações de cotação retornadas pela API.

## 🔧 Dependências
- **Gson 2.11.0** — Biblioteca utilizada para deserializar a resposta JSON da API.  
  O arquivo `gson-2.11.0.jar` já está incluído no projeto.

## 🖼️ Exemplo de Execução
```bash
Conversor de Moedas 

Real para Dólar (BRL -> USD)

Dólar para Real (USD -> BRL)

Real para Peso Argentino (BRL -> ARS)

Peso Argentino para Real (ARS -> BRL)

Real para Peso Chileno (BRL -> CLP)

Peso Chileno para Real (CLP -> BRL)

Digite a opção: 1
Digite o valor: 100
Valor convertido: 18.60 USD

```
  
## 🛠️ Requisitos

### Java 17

### Gson 2.11.0
