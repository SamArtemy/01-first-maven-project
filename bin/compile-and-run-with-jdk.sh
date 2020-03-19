#!/bin/bash
javac -d bin src/main/java/*.java
java -classpath ./bin App
