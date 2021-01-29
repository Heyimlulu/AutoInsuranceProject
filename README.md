# InsuranceProject

An automobile insurance management application using Spring Boot, Maven and Boostrap 

## Table of Contents

- [Technologies](#technologies)
- [Setup](#setup)
  - [Prerequisite](#prerequisites)
  - [Build](#build)
  - [Run](#run)

## Technologies

| Bootstrap  | HTML | CSS | Javascript |  Java | JQuery | Spring Boot | Maven | Hibernate
| ------------- | ------------- | ------------- | ------------- | ------------- | ------------- | ------------- | ------------- | ------------- |
| 5.0 ✔️ | 5 ✔️ | 3 ✔️ | ES6 ✔️ | 1.8 ✔️ | 3.4.1 ✔️ | 2.3.1 ✔️ | 3.8.1 ✔️ | 5.4.27 ✔️ |

## Setup

To run this project, you need to do the following

### Prerequisites

- Install Eclipse IDE for Enterprise Java Developers
  - Install the `Spring Tools 4 (Spring Tool Suite 4)` in the Eclipse marketplace
- Install Xampp and setup a Web Server with Apache & MySQL
  - Ports is default
  - Add a new database `assurance_db` with default parameters

### Build

1. Right-Click on the project
2. Go to `Run As` > `Run Configurations...`
3. Right-Click on `Maven Build` in the filter menu then `New Configuration`
4. Fill the required fields
    - Base directory
      - Click on `Workspace...` and select the project
    - Goals
      - Type `install`
    - Ticks `Skip Tests`
5. Apply
6. Run

```
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  12.539 s
[INFO] Finished at: 2021-01-14T09:54:14+01:00
[INFO] ------------------------------------------------------------------------
```

Delete .m2 folder in `C:\Users\<user>\.m2` if the build failed

### Run

1. Right-Click on the project
2. Go to `Run As` > `Spring Boot App`
3. Access through `http://localhost:8888/`

```
21-01-14 jeu. 09:55:03.442 INFO  AssuranceApplication Started AssuranceApplication in 11.748 seconds (JVM running for 12.851)
```
