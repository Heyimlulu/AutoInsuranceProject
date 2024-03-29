# Auto Insurance Project

![](https://img.shields.io/badge/Apache%20Maven%3A%20Build-passing-success?logo=github) ![](https://img.shields.io/badge/Spring%20Boot%20Back--End%3A%20Build%20--%20Test%20--%20Deploy-passing-success?logo=github) ![](https://img.shields.io/badge/Bootstrap%20Frond--End%3A%20Deploy-passing-success?logo=github)

An automobile insurance management application using the Spring Boot, Maven and Bootstrap frameworks

## Technologies

| Languages   | Version       |
| :---------: | :-----------: |
| HTML        | 5             |
| CSS         | 3             |
| Javascript  | ES6           |
| Java        | 1.8           |

| Frameworks  | Version       |
| :---------: | :-----------: |
| Bootstrap   | 5.0           |
| Spring Boot | 2.3.1.RELEASE |
| Maven       | 3.8.1         |

## Setup

To run this project, you need to do the following

### Prerequisites

> Windows
- Install Xampp and setup a Web Server with Apache & MySQL
  - Set HTTP port to default (required for MySQL)  
  - Set MySQL port to default
  - Add the default database `assurance_db or YourDatabaseName` with default parameters
    - Don't forget to change your database name in the `application.properties` file if you changed it

### Database

In the `./src/main/resources/application.properties` files, look for theses lines

```
spring.datasource.url=jdbc:mysql://localhost:3306/assurance_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=	

server.port=8888
```

- `datasource.url` is the database URL connection
- Make sure your username and password are correct in the `datasource.username` and `datasource.password` field
- `server.port` default set is 8888, but you can change that

## Usage

Open your favorite browser [Must not be IE] and go to [localhost:8888](http://localhost:8888)

The Back-end (database) is available at [localhost/phpmyadmin](http://localhost/phpmyadmin)

The public instances hosted on Heroku is also available

- Front-End : https://autoinsuranceproject.herokuapp.com/

## Authors

- [Heyimlulu](https://github.com/Heyimlulu)
- [Dead-Bot](https://github.com/Dead-Bot)
- [namaio](https://github.com/namaio)

## Contributing

None as it is a personal project

## License

None (Copyright)
