FROM mongo

COPY customers.json /import/customers.json
CMD mongoimport --host mongo --db local --collection customers  --drop --type json --file /import/customers.json --jsonArray