FROM mongo

COPY customers.json /import/customers.json
CMD mongoimport --host mongo --db local --collection customers --type json --drop --file /import/customers.json --jsonArray