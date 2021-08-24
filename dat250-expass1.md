# Deploying a simple Java web app to Heroku

## Technical problems during installation

I encountered no problems when installing Java, Maven, or Heroku.

## Validating that the dev environment works

I have run `java --version` to see that the correct version is installed, and have tested that the inexisting `String.Sindre` gives an error in my IDE of choice. Hovering the cursor over tokens will display a description of the token itself.

By installing the Heroku CLI, we can deploy apps to the Heroku platform. After running `heroku create` to create the app itself, we can run `git push heroku main` to deploy the code. When the code webapp is deployed, running `heroku open` will open it in a browser window. This all works.

`mvn clean install` installs Maven dependencies correctly. `heroku local web` runs the application locally on port 5000.

## Technical Heroku problems

I haven't encountered any problems with Heroku as of yet.
