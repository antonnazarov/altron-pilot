# altron-pilot
In order to run the Poilot services.

1. INSTALL ORACLE USERS/TABLES
run the following scripts on Oracle Database:
* create-users.sql
* create-im-tables.sql
* create-transfer-objects.sql
* create-ora-objects.sql

Compile with Maven:
* Commons: mvn -e clean install
* CII: mvn -e clean compile
* CIM: mvn -e clean install
* eurekasvr: mvn -e clean install
* metrics: mvn -e clean install

Download and install Kafka (https://kafka.apache.org/downloads)

Run Zookeeper (in the Kafka installation);
Run Kafka (in the Kafka installation);
Run Eureka Server: eurekasvr/run.cmd
Run Metrics Service: metrics/metrics-service/run.cmd
Run CIM Service 1: cim/cim-service/run.cmd
Run CIM Service 2: cim/cim-service/run2.cmd
Run CII Service: cii/cii-service/run.cmd

Run test on CII Service:
The Service WSDL: http://localhost:8100/ws/cii.wsdl
The Service URL: http://localhost:8100/ws
The request payload:
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:int="http://localhost/ci/interface">
   <soapenv:Header/>
   <soapenv:Body>
      <int:addCIMInteractionRequest>
         <int:InteractionRequest>
            <int:msisdn>0792965332</int:msisdn>
            <int:callId>00020252</int:callId>
            <int:accountId>90800005930000985</int:accountId>
            <int:source>CDDX</int:source>
            <int:topicCode>CI</int:topicCode>
            <int:comment>This is a test request</int:comment>
            <int:interactionDate>2019-07-31</int:interactionDate>
         </int:InteractionRequest>
      </int:addCIMInteractionRequest>
   </soapenv:Body>
</soapenv:Envelope>