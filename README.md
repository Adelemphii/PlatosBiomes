# PlatosBiomes
A cool biome mod

# How to build
Step 1: Open the project.

Step 2: You're left with a choice.
If you prefer to use Eclipse:
1. Run the following command: `gradlew genEclipseRuns` (`./gradlew genEclipseRuns` if you are on Mac/Linux)
2. Open Eclipse, Import > Existing Gradle Project > Select Folder
   or run `gradlew eclipse` to generate the project.

If you prefer to use IntelliJ:
1. Open IDEA, and import project.
2. Select your build.gradle file and have it import.
3. Run the following command: `gradlew genIntellijRuns` (`./gradlew genIntellijRuns` if you are on Mac/Linux)
4. Refresh the Gradle Project in IDEA if required.

Step 3: To run the dev environment you have to do the following.
1. Run `gradlew runData` (`./gradlew runData` if you are on Mac/Linux)
2. Run `gradlew runClient` (`./gradlew runClient` if you are on Mac/Linux)
3. Voila.

If at any point you are missing libraries in your IDE, or you've run into problems you can
run `gradlew --refresh-dependencies` to refresh the local cache. `gradlew clean` to reset everything
{this does not affect your code} and then start the process again.
