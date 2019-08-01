# sti-ssm

#How to setup Redis
Install Redis Client and Client Server 
- For windows 64 bit download zip file Redis-x64-3.2.100 
- https://github.com/MSOpenTech/redis/releases/download/win-3.2.100/Redis-x64-3.2.100.msi
- Navigate to folder and start redis-server and redis-cli

#How to setup Quartz Tables in Database
Run the SQL script present in file "quartz_tables" present at \src\main\resources in your Database.
- mysql> source <PATH_TO_QUARTZ_TABLES.sql>


## SSO Routes for authentication
- http://localhost:8080/
- http://localhost:8080/saml/login

## Un-Authenticated Routes
- http://localhost:8080/companys
- http://localhost:8080/company/1

## live reload with gradle
./gradlew build --continuous along with
./gradlew bootrun
