### kafkac test
1.create topic
``` 
kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic kafka-test-topic
```
2.list topic
``` 
kafka-topics.bat --list --zookeeper localhost:2181
```
3.producer start
``` 
kafka-console-producer.bat --broker-list localhost:9092 --topic kafka-test-topic
```
4.consumer start
``` 
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic kafka-test-topic --from-beginning
```

other:
cd kafka/bin/windows
zoo-start zookeeper.properties
kafka-start server.properties

idea plugin tools:
- zoolytic
- kafkalytic

> 关于消费组，相同groupId下的多个consumer将共同作用于offset。

