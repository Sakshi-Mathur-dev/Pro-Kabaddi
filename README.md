# Pro-Kabaddi

Build the domain model only that generates the round robin schedule for the PRO-Kabaddi event that
conforms to the following constraints
- Accept N number of teams
- Each team must play against every other team once home and away
- Maximum 2 matches per day are allowed
- No team should play on consecutive days

# Steps to execute the Service

Clone GIT Repository locally 
Import Maven Project in eclipse
Deploy prokabbadi-0.0.1-SNAPSHOT.war war in Tomcat
Open browser and type this URL to see available REST services to generate scheduled matches information : http://localhost:8080/prokabaddi/matches
