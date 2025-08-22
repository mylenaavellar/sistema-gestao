# Sistema de Gestão - Projeto JSF

Este projeto é um **sistema de gestão** desenvolvido com **Java, JSF** e arquitetura MVC, com o objetivo de gerenciar tarefas. Ele demonstra a integração entre **XHTML**, **ManagedBeans**, **Serviços**, **Repositórios** e mapeamento de entidades.

---

## Estrutura do Projeto

```
├───src
│   ├───main
│   │   ├───java
│   │   │   └───com/br/sistema/sistema_gestao
│   │   │       ├───controller
│   │   │       ├───dto
│   │   │       ├───entity
│   │   │       ├───mapper
│   │   │       ├───repository
│   │   │       └───service
│   │   ├───resources
│   │   │   └───META-INF
│   │   └───webapp
│   │       ├───paginas
│   │       │   ├───cadastrar_responsavel.xhtml
│   │       │   ├───cadastrar_tarefa.xhtml
│   │       │   └───listar_tarefas.xhtml
│   │       ├───web
│   │       │   └───WEB-INF
│   │       └───WEB-INF

```

---

## Funcionalidades Implementadas

As principais funcionalidades implementadas neste projeto são:

a) **Cadastro de responsáveis** – Permite adicionar novos responsáveis através do formulário `cadastrar_responsavel.xhtml`.  
b) **Cadastro de tarefas** – Permite criar novas tarefas através do formulário `cadastrar_tarefa.xhtml`.  
c) **Listagem de tarefas** – Exibe todas as tarefas cadastradas na página `listar_tarefas.xhtml`.  

---

## Requisitos

- Java JDK 17 ou superior  
- Apache Tomcat 10+  
- Maven (caso deseje gerenciar dependências)  
- Biblioteca **Jakarta Faces (JSF)** adicionada ao projeto ou via Maven  

---

## Instruções para execução local

1. **Clonar ou baixar o projeto** para sua máquina.

2. **Adicionar bibliotecas JSF** (se não estiver usando Maven):
   - Copie o `.jar` do `jakarta.faces` para `WEB-INF/lib`.

   Ou, se estiver usando Maven, adicione no `pom.xml`:

   ```xml
   <dependency>
       <groupId>org.glassfish</groupId>
       <artifactId>jakarta.faces</artifactId>
       <version>4.0.2</version>
   </dependency>
    ```

3. **Configurar o `web.xml`** para mapear o `FacesServlet`:

   ```xml
   <servlet>
       <servlet-name>Faces Servlet</servlet-name>
       <servlet-class>jakarta.faces.webapp.FacesServlet</servlet-class>
       <load-on-startup>1</load-on-startup>
   </servlet>

   <servlet-mapping>
       <servlet-name>Faces Servlet</servlet-name>
       <url-pattern>*.xhtml</url-pattern>
   </servlet-mapping>
   ```

4. **Compilar e gerar o WAR** (caso Maven):

   ```bash
   mvn clean package
   ```

5. **Deploy no Tomcat**:

   * Copie o WAR para a pasta `webapps` do Tomcat ou configure no IDE (IntelliJ/Eclipse).
   * Reinicie o Tomcat.

6. **Acessar o sistema no browser**:

   ```
   http://localhost:8080/NomeDoProjeto/paginas/cadastrar_responsavel.xhtml
   ```

---

