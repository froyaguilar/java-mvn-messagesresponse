# java-mvn-messagesresponse

run sonar: mvn clean org.jacoco:jacoco-maven-plugin:0.8.5:prepare-agent install install -D maven.test.failure.ignore=false -D jacoco.output=file -D jacoco.destFile=target/jacoco.exec sonar:sonar

al parecer al correr clean install se ejecuta el plugin d jacoco lo que crea el coverage para despues correr el plugin
de sonar:sonar y obtener el reporte: http://localhost:9000/code?id=com.froyo%3Ajava-mvn-messagesresponse
