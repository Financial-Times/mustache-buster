# Introduction

Content programme tech stack poc for responsive article

This is intended to demonstrate an approach that means:

1) html is delivered from a java & dropwizard based app using mustache templates
2) js & css are also delivered from this same app
3) css & js bundling are handled as a part of the build

Additionally, developer benefits include:

1) Saving of the templates (at least while running in a properly configured IDE) will be reflected in the running application (no restart)
2) Updates to sass source etc will result in re-bundling, minification etc as required and will be reflected in the running app with no restart.


# Building the application for deployment

(this doesn't all work yet!)

Run mvn package

# Developing the application & running in IDE

(this doesn't all work yet!)

Run mvn package once, run ArticleApplication (with parameters "server example.yml" in your IDE in debug mode. Changes to code or templates should be reflected immediately.

(Optional) Run "grunt watch" if you also want css & js changes to be reflected immediately and have the right tools installed for this.

TODO:
1) Add maven config to invoke resource processing as part of build, for use by build servers or by developers not needing to run grunt locally
2) Better handling and/or documentation of pre-requisites.  nodejs, ruby, etc.  At least document these, better would be getting maven to complain and explain what is missing.

FIXME:
1) Various things are committed here that should not be.  e.g., ft-velcro.  These need to be brought in properly.  Rick has ideas about this.  Must be maven compatible and must not voilate build repeatability.
2) The way target/ is being written to by both the ide and by grunt tasks is problematic and has issues.  This needs re-working, probably to make grunt stuff write to a different directory, which the ide (and maven?) see as a source folder.   Must not require special IDE specific setup.


# Running The Application

* To run the server run.

	java -jar target/ft-article-0.0.1-SNAPSHOT.jar server example.yml 

* To hit an example

	http://localhost:8080/articles/1
	http://localhost:8080/articles/2
	http://localhost:8080/articles/3

