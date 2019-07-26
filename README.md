# Spring PetClinic Lite

Based on https://github.com/spring-projects/spring-petclinic

## Database initialization

```
create database spl_database;
create user 'spl_user'@'%' identified by 'spl_password';
grant all on spl_database.* to 'spl_user'@'%';
```

## Sample HTTP requests

https://github.com/dominisz/spring-petclinic-lite/blob/master/http_requests.http