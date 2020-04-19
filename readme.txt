ACCOUNTING NOTEBOOK
This application was developed as a test task for AgileEngine.
The purpose is to mock a user´s bank account.

Overview:
There are two different applications in this folder:
gs-rest-service is the backend application where the transactions will be performed.
my-app is the UI to see the list of transactions.

Getting started:
In order to start the backend application, a java runtime environment is required.
Run the following command from a terminal using the absolute path where the project code is located:
java -jar ..\gs-rest-service\complete\build\libs\rest-service-0.0.1-SNAPSHOT.jar
Once the application has started, you may commit and search transactions through postman using the format shown at: https://agileengine.bitbucket.io/fsNDJmGOAwqCpzZx/api/

Transaction UI:
The UI application is built using React.js and requires to have installed node.js and material-ui.
Node.js can be downloaded from https://nodejs.org/en/
Once node is installed, a reboot is required.
After that, complete the installation by running the following commands from the terminal:
npm install @material-ui/core
npm install @material-ui/icons

The UI application can be started running the following command from "my-app" root folder:
npm start

This will open a browser tab automatically.
Make sure to commit transactions before loading, or refresh the website after commiting the transactions to see an update.