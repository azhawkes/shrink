shrink
======

This is a crude, experimental HTTP web service around [Straightjacket](https://github.com/azhawkes/straightjacket) and [Nashorn](http://www.oracle.com/technetwork/articles/java/jf14-nashorn-2126515.html).

It exposes an ```/execute``` endpoint that you can POST to with any JavaScript code snippet you want. Shrink then runs the script in a Straightjacket sandbox, exposing any Java packages you choose to allow.

This is just a simple proof of concept and is not production ready. Letting other people run scripts on your server has obvious security implications, so only run this in friendly environments.

Running the Server
------------------

To start the server, just run the main method of ```com.andyhawkes.shrink.Server```. The server will listen on [http://localhost:4567](http://localhost:4567).

Using the Shrink UI
-------------------

Navigate to [http://localhost:4567](http://localhost:4567) in your browser. Fill in a snippet of JavaScript (which must declare at least one function). Then enter the name of the function you want to execute, up to 3 optional arguments, and a comma-separated list of Java classes or packages that should be exposed to the script's classloader. Submitting this will send a POST to Shrink's ```/execute``` endpoint.

Calling the Shrink Service Directly
-----------------------------------

You can also run scripts with your HTTP client of choice. For instance, curl:

```sh

$ curl -X POST --data '{"script":"function hello() { return \"hello\"; }","function":"hello","arguments":[],"exposedJavaClasses":[""]}' http://localhost:4567/execute

```
