Com certeza! Aqui está o código Markdown completo, exatamente como o anterior, mas com a seção "Estrutura do Projeto" removida, conforme solicitado.

Basta copiar o bloco de código abaixo e colar no seu arquivo.

Markdown

# 🎯 Projeto: Agenda de Eventos em Java (Console)

<p align="center">
  <img src="https://img.shields.io/badge/Java-11-blue?logo=java&logoColor=white" alt="Java 11">
  <img src="https://img.shields.io/badge/Plataforma-Console-lightgrey?logo=windows-terminal" alt="Console">
  <img src="https://img.shields.io/badge/Status-Concluído-brightgreen" alt="Status Concluído">
</p>

## 📋 Descrição

Este projeto implementa uma agenda de eventos simples que roda no terminal. Desenvolvido em Java puro, o sistema permite cadastrar usuários, gerenciar eventos, confirmar presença e persistir todos os dados em um arquivo binário, garantindo que as informações não sejam perdidas entre as execuções.

**Autor:** Argeu Rodrigues  
**Curso:** Análise e Desenvolvimento de Sistemas - Universidade Anhembi Morumbi

---

## ✨ Funcionalidades Principais

* **👥 Cadastro de Usuários:** Permite registrar novos usuários com nome, email e cidade.
* **📅 Listagem de Eventos:** Exibe todos os eventos disponíveis, ordenados cronologicamente.
* **✅ Confirmação de Presença:** Usuários podem se inscrever nos eventos de seu interesse.
* **📂 Meus Eventos:** Visualização dos eventos em que um usuário confirmou presença.
* **💾 Persistência de Dados:** Salva e carrega automaticamente os dados de eventos no arquivo `events.data`.

---

## 🛠️ Tecnologias e Ferramentas

* **Linguagem:** `Java 11`
* **Bibliotecas Padrão:** `java.time`, `java.io`, `java.util`
* **Ferramentas:** JDK, PowerShell/Terminal, Visual Studio Code

---

## 📁 ESTRUTURA DO PROJETO

src/
├── gestoreventos/
│ ├── Programa.java # Classe principal
│ ├── modelos/
│ │ ├── Usuario.java # Modelo de usuário
│ │ └── Evento.java # Modelo de evento
│ ├── logica/
│ │ ├── GerenciadorUsuarios.java # Gerenciamento de usuários
│ │ └── GerenciadorEventos.java # Gerenciamento de eventos
│ ├── armazenamento/
│ │ └── ArquivoEventos.java # Persistência em arquivo
│ └── tela/
│ └── MenuConsole.java # Interface com usuário
events.data # Arquivo de persistência
diagrama_de_classes.png # Diagrama de classes

---

## 📚 Aprendizados Obtidos

Este projeto foi fundamental para solidificar conhecimentos em diversas áreas:

#### **☕ Conceitos Fundamentais de Java**
* Estrutura de classes, objetos e modificadores de acesso (`public`, `private`).
* Uso de construtores, getters e o princípio de encapsulamento.
* Manipulação de coleções com `ArrayList` e `List`.
* Tratamento de exceções com blocos `try-catch`.
* Leitura de entrada do usuário com a classe `Scanner`.
* Manipulação de datas e horas com a API `LocalDateTime`.

#### **🏗️ Arquitetura de Software**
* **Separação de Responsabilidades:** Divisão do código em camadas (Model, Logic, Storage, UI).
* **Programação Orientada a Objetos (POO):** Aplicação prática dos pilares da POO.
* **Organização de Pacotes:** Estruturação do projeto de forma clara e manutenível.

#### **💾 Persistência de Dados**
* **Serialização de Objetos:** Implementação da interface `Serializable` para converter objetos em bytes.
* **Leitura e Escrita de Arquivos:** Uso de `FileInputStream` e `FileOutputStream` para persistir dados.
* **Gerenciamento de Recursos:** Fechamento correto de *streams* para evitar vazamento de recursos.

---

## 🚀 Guia de Instalação e Execução

Siga os passos abaixo para compilar e executar o projeto em sua máquina local.

### 1. Pré-requisitos

* **Java JDK 11** ou superior instalado.
* **Git** (opcional, para clonar o repositório).

### 2. Instalação do Java JDK

> **Dica:** Você pode usar um gerenciador de pacotes como o **winget** (Windows) para facilitar a instalação.

```powershell
# Comando para instalar o Temurin JDK 11 via winget
winget install EclipseAdoptium.Temurin.11.JDK

# Verifique se a instalação foi bem-sucedida
java -version
javac -version
Caso prefira a instalação manual, acesse o site oficial da Adoptium e siga as instruções do instalador.

### 3. Configuração do `PATH` (se necessário)

Se os comandos `java` e `javac` não forem reconhecidos, adicione o diretório `bin` do JDK às variáveis de ambiente do seu sistema.
1.  Pressione `Windows + R`, digite **`sysdm.cpl`** e pressione Enter.
2.  Vá para a aba **Avançado** → **Variáveis de Ambiente**.
3.  Em "Variáveis do sistema", selecione **`Path`** e clique em **Editar**.
4.  Clique em **Novo** e adicione o caminho para a pasta `bin` do JDK (ex: `C:\Program Files\Eclipse Adoptium\jdk-11.x.x-hotspot\bin`).

### 4. Obtenha o Projeto

Clone o repositório com Git ou baixe o arquivo ZIP.

```bash
# Clone o repositório (substitua pela URL correta)
git clone <URL_DO_REPOSITORIO>
cd <NOME_DA_PASTA_DO_PROJETO>

### 5. Compile o Código-Fonte

Abra um terminal na raiz do projeto e execute o comando abaixo. Ele compilará todos os arquivos `.java` da pasta `src` e organizará os arquivos `.class` na pasta `bin`.

```bash
# Cria o diretório 'bin' para os arquivos compilados (se não existir)
mkdir bin

# Compila todos os arquivos .java e os coloca no diretório 'bin'
javac -d bin src/gestoreventos/*/*.java src/gestoreventos/*.java

### 6. Execute o Programa

Use o seguinte comando para iniciar a aplicação:

```bash
# Executa a classe principal a partir do diretório 'bin'
java -cp bin gestoreventos.Programa

---

## 📝 Observações

* **Arquivo de Persistência:** O arquivo `events.data` é criado e gerenciado automaticamente na raiz do projeto. Não o apague se quiser manter os dados dos eventos.
* **Codificação de Caracteres:** O projeto foi desenvolvido para lidar com caracteres do padrão UTF-8. Se houver problemas de acentuação no seu terminal, verifique sua configuração.

---

## 📞 Contato

**Argeu Rodrigues**

* [LinkedIn](URL_DO_SEU_LINKEDIN)
* [GitHub](URL_DO_SEU_GITHUB)

> "Aprender a programar é como aprender uma nova linguagem: exige prática, paciência e persistência!"