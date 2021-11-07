Requirements:</br>
Java 7</br>
</br>
Compile:</br>
mvn clean package</br>
</br>
run the jar with:</br>
java -jar target/com-jar-with-dependencies.jar</br>
</br>
An example command for each of the 3 endpoints:</br>
curl -i -X POST -H 'Content-Type: application/json' -d '{"text": "The sun shines bright bright0brIGHT."}'  http:/localhost:8080/WordAnalyzer/calculateHighestFrequency
</br>
</br>
curl -i -X POST -H 'Content-Type: application/json' -d '{"text": "The sun shines bright bright0brIGHT.", "word": "bright"}'  http:/localhost:8080/WordAnalyzer/calculateFrequencyForWord
</br>
</br>
curl -i -X POST -H 'Content-Type: application/json' -d '{"text": "The sun shines bright bright0brIGHT.", "n": 2}'  http:/localhost:8080/WordAnalyzer/calculateMostFrequentNWords
