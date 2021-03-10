# InsuranceProject

An automobile insurance management application using Spring Boot, Maven and Bootstrap 

## Table of Contents

- [Technologies](#technologies)
- [Setup](#setup)
  - [Prerequisite](#prerequisites)
  - [Database](#database)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Technologies

| Bootstrap  | HTML | CSS | Javascript |  Java | JQuery | Spring Boot | Maven | Hibernate
| ------------- | ------------- | ------------- | ------------- | ------------- | ------------- | ------------- | ------------- | ------------- |
| 5.0 ✔️ | 5 ✔️ | 3 ✔️ | ES6 ✔️ | 1.8 ✔️ | 3.4.1 ✔️ | 2.3.1 ✔️ | 3.0 ✔️ | 5.4 ✔️ |

## Setup

To run this project, you need to do the following

### Prerequisites

- Install Xampp and setup a Web Server with Apache & MySQL
  - MySQL port is default
  - Add a new database `assurance_db` with default parameters

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

Open your favorite browser and go to [localhost:8888](http://localhost:8888)

The Back-end (database) is available at [localhost/phpmyadmin](http://localhost/phpmyadmin)

## Author

- [Heyimlulu](https://github.com/Heyimlulu)
- [Dead-Bot](https://github.com/Dead-Bot)
- [namaio](https://github.com/namaio)

## Contributing

None

## License

None
