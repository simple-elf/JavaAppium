#!/bin/bash
cd download;
java -jar agent.jar -jnlpUrl http://212.237.55.99:8080/computer/macos/slave-agent.jnlp -secret bdd3dd502058adb9b06f13a659d32f2fe05710a31b67ed3db5f1133f36ddbddb -workDir "/Users/jenkins/slave"