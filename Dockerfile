FROM fabric8/java-centos-openjdk11-jre
ADD target/*.jar /home/dynamaze-leisure.jar

WORKDIR /home
COPY elasticapm.properties /home

USER root
RUN yum install -y wget
RUN wget -O apm-agent.jar https://search.maven.org/remotecontent?filepath=co/elastic/apm/elastic-apm-agent/1.13.0/elastic-apm-agent-1.13.0.jar
RUN chmod 755 apm-agent.jar
USER jboss
CMD java -javaagent:apm-agent.jar -jar dynamaze-leisure.jar
