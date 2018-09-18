(cd helper && ./mvnw package)
(cd helper-ui && yarn build)

docker-compose up