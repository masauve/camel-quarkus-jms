install AMQBroker Operator

deploy AMQBroker instance with acceptor for AMQP on port 5672:
```
oc apply -f manifests/broker.yaml
```
deploy to OpenShift:
```
./mvnw clean package -Dquarkus.kubernetes.deploy=true
```

Test the API:

```curl --location --request PUT 'http://{HOST}/messages' \
--header 'Content-Type: application/json' \
--data-raw '{"msg": "my message"}'
```