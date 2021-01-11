# Projeto JSF

 #### Projeto para estudo de Java EE e JSF

---
- Branch main: Estudos, comits pequenos de exemplos
- Branch projeto: Projeto sendo implementado
---

Configurações do projeto:
- WildFly na versão 19.+
- Arquivo de inicialização é o standalone-full.xml
- Em standalone-full.xml, é necessáio ter linhas dentro de subsystem messaging-activemq:
~~~~
 <jms-queue name="SoftQueue" entries="java:/jms/queue/SoftQueue"/>
 <jms-topic name="SoftTopic" entries="java:/jms/topic/SoftTopic"/>   
~~~~
- Necessáio ter conexão com DB configurada

Vamos codar ?  🎉🙌

