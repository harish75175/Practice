FROM openjdk
COPY target/*.jar /
EXPOSE 8050
ENTRYPOINT ["java","-jar","/Stocks-0.0.1-SNAPSHOT.jar"]
ENV spring.datasource.url=jdbc:mysql://zenstockdb.cycjxiz63uxm.ap-northeast-1.rds.amazonaws.com:3306/zenstockdb