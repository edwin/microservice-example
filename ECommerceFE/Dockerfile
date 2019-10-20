FROM adoptopenjdk/openjdk8:jre8u222-b10-alpine

LABEL io.k8s.description="Platform for running plain Java applications (fat-jar and flat classpath)" \
      io.k8s.display-name="My Simple Java Applications" \
      io.openshift.tags="builder,java" \
      org.jboss.deployments-dir="/deployments" \
      com.redhat.deployments-dir="/deployments" \
      com.redhat.dev-mode="JAVA_DEBUG:false" \
      com.redhat.dev-mode.port="JAVA_DEBUG_PORT:5005"

MAINTAINER Muhammad Edwin < emuhamma at redhat dot com >

# set working directory at /deployments
WORKDIR /deployments

# copy corresponding jar file
COPY target/*.war myapp.war

# gives uid
USER 185

EXPOSE 8080

# run it
CMD ["java","-jar","myapp.war"]