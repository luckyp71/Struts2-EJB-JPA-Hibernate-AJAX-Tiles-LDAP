# Struts2, EJB, JPA (Hibernate), AJAX, Tiles, LDAP Example

This repository is a simple example on how to create ejb (session bean including JPA as a replacement for EJB's entity bean), client web appliation using struts 2 with AJAX (get and post methods), and LDAP for login authentication.

Prerequisites:

1. Netbeans 8.1
2. Apache Directory Studio 2.0.0. (Create new entry, add inetOrgPerson object class, and add displayName attribute for each user in users organizational unit)
3. Struts 2
4. EJB 3
5. Hibernate (JPA 2.1)
6. Apache Tiles
7. Maven
8. Wildfly 10.1.0.Final (Make sure you have created the required file and directory for adding MySQL's jdbc driver, configure the datasource name in standalone.xml or standalone-full.xml inside your wildfly directory and put the datasource name defined in persistence.xml)
9. MySQL
