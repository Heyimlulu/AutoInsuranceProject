# InsuranceProject

## Prerequisites

- Eclipse IDE for Enterprise Java Developers
- Xampp (Apache & MySQL)
  - Port is default
  - Add a new database **assurane_db** with default parameters

## Build

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

Delete .m2 folder in `C:\Users\<user>\.m2` if the build failed

## Run

1. Right-Click on the project
2. Go to `Run As` > `Spring Boot App`
