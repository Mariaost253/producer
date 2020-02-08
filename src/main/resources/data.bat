curl -i \
-d '{"eventID":77,"publisher":{"publisherID":7556,"time":"dfdf","readings":"12"}}' \
-H "Content-Type: application/json" \
-X POST http://localhost:8080/v1/publisherevent