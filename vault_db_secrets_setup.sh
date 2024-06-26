#!/bin/bash

# Add database secrets engine
vault secrets enable database

# Configure database connection
vault write database/config/my-postgresql-database \
    plugin_name=postgresql-database-plugin \
    allowed_roles="dynamic-role" \
    connection_url="postgresql://{{username}}:{{password}}@localhost:5432/spring-cloud-vault-demo?sslmode=disable" \
    username="postgres" \
    password="Simform@123"

# Add dynamic role
vault write database/roles/dynamic-role \
    db_name=my-postgresql-database \
    creation_statements="CREATE ROLE \"{{name}}\" WITH LOGIN PASSWORD '{{password}}' VALID UNTIL '{{expiration}}'; GRANT SELECT ON ALL TABLES IN SCHEMA public TO \"{{name}}\";" \
    default_ttl="1h" \
    max_ttl="24h"