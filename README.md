# TicketBooking-SpringBootApplication
## Installation
### Linux
> [!IMPORTANT]
> These steps are for Debian based Linux systems only
Firstly, navigate to a directory where you want the project to reside then clone the project.
```
git clone https://github.com/JulianoF/TicketBooking-SpringBootApplication.git
```
Next, make sure you have docker installed on the system, if not follow the following steps.
```
sudo apt install docker.io
```
```
sudo snap install docker
```
To verify docker is installed run,
```
docker --version
```
After you have verified you have Docker, navigate into the project folder containing the POM.xml
```
cd TicketBooking-SpringBootApplication/TicketApplication
```
When you are in the folder where the POM is located, run this command to build the project and run the tests
```
mvn clean test package
```
In order to deploy the Ticket Application, while you are in the folder containing compose.yaml (Same folder as POM.xml) run the following command
```
sudo docker compose up -d --build
```
Now, if you open your web browser and navigate to
```
localhost:8080/
```
you will see the Ticket Application.
To shut down the Application run this command
```
sudo docker compose down
```
