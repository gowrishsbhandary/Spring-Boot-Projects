Apache Kafka Producer

1. Create project on https://start.spring.io/ with below details
	Springboot - 2.4.4
	Java 11

	Dependencies
		Spring Web
		Spring for Apache Kafka

2. Add the server port in application.properties
3. create a controller to publish message with and endpoint /publish/{message}
4. Start the zookeeper server
	.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
5. Start the kafka server
	.\bin\windows\kafka-server-start.bat .\config\server.properties
6. Consume the message	
	.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic NewTopic --from-beginning
	Note : NewTopic is the topic name created in the application
7. Start the spring boot application
8. Hit the endpoint with message	
	http://localhost:8081/publish/Hello
9. You should see message on the kafka topics console

--------------------------------------------------------------------------------------------------------------
10. Add a KafkaConfig file to accept object instead of default kafka template String serialization. 
	Note: @Configuration annotaion makes the class to be available at the spring startup
11. create ProducerFactory bean
12. Create a book class to add it to the kafka template
13. add the configuration to a map
	a. config To bootstrap the server for passing messasges over topic - localconfig 127.0.0.1:9092 default port for kafka
	b. config for key type - StringSerializer as the key_Serializer
	c. config for value type - JsonSerializer as Value_Serializer

14. Add the post mapping to publish message with an enpoint /publish 
15. Hit the URL http://localhost:8081/publish from postman with book object as request body json
	{
		"bookName": "Biology",
		"isbn": "1234"
	}
16. On succesfull status 200 ok and "Message Published!" message in the console, json value shoud be published over the topicn
