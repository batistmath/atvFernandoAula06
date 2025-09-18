# Projeto RMI: Controle Remoto Virtual

Este projeto demonstra o uso de RMI (Remote Method Invocation) em Java para criar uma aplicação cliente-servidor. A aplicação simula um controle remoto (cliente) que envia comandos para uma televisão virtual (servidor), que por sua vez, processa e armazena o seu estado (volume, canal, etc.).

## Autores

* [Ricardo Teles de Oliveira]
* [Matheus Batista Rodrigues]


## Instruções para Execução

Para rodar esta aplicação, você precisará de duas máquinas conectadas na mesma rede local (ex: mesmo Wi-Fi) e com o JDK instalado em ambas.

Siga os passos abaixo **exatamente** na ordem apresentada.

### 1. Configuração Obrigatória (IP do Servidor)

Antes de tudo, o servidor precisa saber qual é o seu próprio endereço de IP na rede para poder anunciá-lo corretamente.

1.  **Descubra o IP da Máquina Servidora:**
    * Abra um terminal (Prompt de Comando/PowerShell) na máquina que será o **servidor**.
    * Digite o comando `ipconfig` (no Windows) ou `ifconfig` / `ip addr` (no Linux/macOS).
    * Procure pelo endereço "IPv4". Será algo como `192.168.0.15` ou `10.40.134.106`.

2.  **Atualize o Código-Fonte:**
    * Abra o arquivo `IniciaServidor.java`.
    * Encontre a linha a seguir:
        ```java
        System.setProperty("java.rmi.server.hostname", "COLOQUE_SEU_IP_AQUI");
        ```
    * Substitua `"COLOQUE_SEU_IP_AQUI"` pelo endereço de IP que você encontrou no passo anterior.

    **Exemplo:** Se o seu IP for `10.40.134.106`, a linha deverá ficar assim:
    ```java
    System.setProperty("java.rmi.server.hostname", "10.40.134.106");
    ```
    * Salve o arquivo.

---

### 2. Compilação e Execução

#### Na Máquina SERVIDORA

1.  **Abra um terminal** na pasta raiz do projeto (onde estão os arquivos `.java`).

2.  **Compile todos os arquivos** Java com o seguinte comando:
    ```bash
    javac *.java
    ```
    Isso irá gerar os arquivos `.class` necessários.

3.  **Inicie o Servidor.** No mesmo terminal, execute a classe principal do servidor:
    ```bash
    java IniciaServidor
    ```
    Se tudo der certo, você verá a seguinte mensagem e o terminal ficará aguardando conexões:
    ```
    Servidor RMI pronto. A TV está esperando comandos...
    ```
    **Atenção:** Deixe este terminal aberto. Se você fechá-lo, o servidor será desligado.

#### Na Máquina CLIENTE

1.  **Atualize o Código-Fonte:**
    * Abra o arquivo `IniciaServidor.java`.
    * Encontre a linha a seguir:
        ```java
        System.setProperty("java.rmi.server.hostname", "COLOQUE_SEU_IP_AQUI");
        ```
    * Substitua `"COLOQUE_SEU_IP_AQUI"` pelo endereço de IP que você encontrou no passo anterior.

    **Exemplo:** Se o seu IP for `10.40.134.106`, a linha deverá ficar assim:
    ```java
    System.setProperty("java.rmi.server.hostname", "10.40.134.106");
    ```
    * Salve o arquivo.

---

2.  **Compile todos os arquivos** Java com o seguinte comando:
    ```bash
    javac *.java
    ```

3.  **Abra um terminal** na pasta que você acabou de copiar.

44.  **Execute o Cliente,** passando o IP do servidor como um argumento de linha de comando:
    ```bash
    java Cliente <IP_DA_MAQUINA_SERVIDOR>
    ```
    **Exemplo prático:**
    ```bash
    java Cliente 10.40.134.106
    ```
    O cliente irá se conectar, enviar uma sequência de comandos pré-definidos e exibir o status da TV a cada passo. Ao mesmo tempo, você verá os logs das ações aparecendo no terminal da Máquina Servidora.
