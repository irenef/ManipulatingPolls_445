all: Elections.class

test: results.csv
	cat results.csv

results.csv: all
	java -ea Elections > results.csv

Elections.class: Elections.java Voter*.java
	javac Elections.java Voter*.java

Elections.java: ElectionsBase.java voters.csv
	python ./formatBase.py voters.csv < ElectionsBase.java > Elections.java

clean:
	rm -rf *.class Elections.java results.csv
