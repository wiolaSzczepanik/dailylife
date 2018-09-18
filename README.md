## prerequisites

install docker (https://docs.docker.com/docker-for-windows/ or  https://docs.docker.com/install/linux/docker-ce/ubuntu/)
install docker compose (https://docs.docker.com/compose/install/)
install yarn https://yarnpkg.com/lang/en/docs/install/

## run all (production-like)

./run.sh

access UI at http://localhost:3000/ in a browser

## run just backend (development purposes)

cd helper
./start.sh

access API at http://localhost:8080/api/tasks/ in a browser, send more requests with postman
you need to stop the script and run again when you introduce changes to the code

## run dev frontend (development purposes)

run the backend first with "run just backend" instruction, then

cd helper-ui
yarn start

access UI at http://localhost:3000/ in a browser, 
you can modify code and just reload the page to see changes