# BotClient-Kt
---
### What is it?
 This is the client for the BotServer that is compatible with java or other JVM languages. It is also the recommended API. That means that this API will be the most stable and most quickly updated API when a new version of the server is released.
### How to obtain
You can download compiled versions of this API here: https://github.com/RMHSProgrammingClub/Bot-Game/releases. If you are modifying the client, or for some reason want to build it yourself, building instructions are below.
### How to use
Please reference the wiki for the documentation and in depth instructions on how to begin. Here: https://github.com/RMHSProgrammingClub/Bot-Game/wiki
### How to build
 - Download / clone this repository
 - Unzip the repository if necessary
 - cd to the directory
 - run this command 
   - linux / osx - "./gradlew build"
   - windows - "./gradlew.bat build" (not tested, may not work)
 - Yay! Your compiled client is now located under build/libs/

### Importing into IntelliJ
 - Download and install IntelliJ here: https://www.jetbrains.com/idea/
 - Download / clone this repository
 - In IntelliJ - to open the project:
   - "Import Project"
   - Select the directory
   - "Import project from external model"
   - "Gradle"
   - Make sure "Use auto-import" and "Create directories for empty content roots automatically" are both checked
   - Select "Use customizable gradle wrapper"
   - Select "Finish"
 - Inside the project, under the "Gradle" sidebar:
   - Manually refresh all gradle projects
   - Double click on Tasks/build/build
 - Yay! Your compiled client is now located under build/libs/
