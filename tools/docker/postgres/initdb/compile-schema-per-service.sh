#!/bin/bash

set -e

for schema in workspace board list;
do
  psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<- EOSQL
    create database $schema;
    GRANT ALL PRIVILEGES ON DATABASE $schema TO $POSTGRES_USER;
EOSQL

done
