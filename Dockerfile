FROM bellsoft/liberica-openjdk-debian:8u232-10
RUN apt-get -yqq update && \
    apt-get install -yqq wget && \
    wget http://archive.apache.org/dist/tomcat/tomcat-8/v8.0.38/bin/apache-tomcat-8.0.38.tar.gz && \
    mkdir /opt/tomcat && \
    tar -xf apache-tomcat-8.0.38.tar.gz -C /opt/tomcat
ADD target/mivoto.war /opt/tomcat/apache-tomcat-8.0.38/webapps
EXPOSE 8080
CMD ["/opt/tomcat/apache-tomcat-8.0.38/bin/catalina.sh", "run"]
