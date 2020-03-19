#!/bin/bash
javac -d target/classes src/main/java/*.java
java -classpath ./target/classes App
