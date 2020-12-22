FROM openjdk:8
ADD target/transaction-producer-1.jar transaction-producer-1.jar
ADD resources/bank_data.csv bank_data.csv
EXPOSE 8081
ENTRYPOINT [ "java","-jar","transaction-producer-1.jar" ]