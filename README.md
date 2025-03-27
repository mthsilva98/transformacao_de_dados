# 📄 Transforma Dados

Este projeto realiza a extração de dados de um PDF, salva as informações em um arquivo CSV, compacta o arquivo gerado e substitui abreviações encontradas nos dados.

## 📌 Tecnologias Utilizadas

- **Java 21**
- **Maven**
- **Apache PDFBox** (Extração de texto de PDFs)
- **JSoup** (Web scraping)
- **ZIP I/O Streams** (Compactação de arquivos)

## 🛠️ Funcionalidades

✅ **Scraping de PDF**: O sistema localiza e baixa um PDF específico de um site do governo.  
✅ **Extração de Dados**: O conteúdo do PDF é processado e organizado em formato tabular.  
✅ **Substituição de Abreviações**: Algumas abreviações são substituídas por descrições mais legíveis.  
✅ **Exportação para CSV**: Os dados extraídos são salvos em um arquivo CSV.  
✅ **Compactação**: O arquivo CSV gerado é compactado em formato ZIP.  

## 🚀 Como Executar o Projeto

### 🛠️ Pré-requisitos
Antes de rodar o projeto, certifique-se de ter instalado:
- **Java 21**
- **Maven**

### ▶️ Passo a Passo

```sh
git clone https://github.com/seu-usuario/transforma_dados.git
cd transforma_dados
mvn clean package
java -jar target/transforma_dados-1.0-SNAPSHOT.jar
