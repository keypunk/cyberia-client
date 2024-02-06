![Cyberia](src/main/resources/com/cyberiashop/cyberia_images/cyberia_logo.jpg | width=100)

# Cyberia-Shop (Client)
Cyberia-Shop is an E-Commerce platform to buy and manage electronic products

## Features
- Functioning login/register service
- Functioning customer shop with local shopping cart persistence
- Functioning product management and employee management over RMI

## Features still missing
- Order table and order logic still missing

# Client information
There is only one employee account (username: "admin", password: "1234"), since registration for employees over a customer client should not be possible, logically.  
Registration is only possible for customers.

## System prerequisites
- System with at least 4GB RAM (for modern operation system requirements)

## Software prerequisites
- At least Java SDK 19 or higher
- A PostgresSQL Server [instructions on the server repository](https://github.com/keypunk/cyberia-server)
- Gradle build system (will soon be removed, once jar files work again)

## Installing / Getting started

Before you start cloning the client repository, you should follow the [server repository instructions](https://github.com/keypunk/cyberia-server) first.  
Once you finished the server setup, clone the client repository to your IDE's project folder. (Will soon be removed once jar files work again)

```shell
git clone git@github.com:keypunk/cyberia-client.git
```
Let the Gradle build system download all the necessary libraries  
Once the building and indexing is complete, you can run the client.
