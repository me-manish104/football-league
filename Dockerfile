FROM java:8
WORKDIR /
ADD target/football-league-*.jar app.jar
EXPOSE 8099
CMD java -jar app.jar