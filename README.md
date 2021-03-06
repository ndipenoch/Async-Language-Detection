# Async-Language-Detection
An Asynchronous Language Detection System</b><br>
Advanced Object Oriented Software Development main assignment.</b><br>
Name: Mark Ndipenoch

********DESIGN PATERN AND TECHNIQUE********

****OVERVIEW****</b><br>
The project have 17 classes. I design the project so that each class should do only one thing and one thing only.
The application is consisted of a front end and a back end.
The front end or client side is run on a web browser hosted on Tomcat server.
The back end is consisted of the java classes that does the language detection.
When the application starts the user is presented with a web view. They will enter 
a text of their chosen language and click the process button. After 10 seconds the application will tell them 
what language was the query text written in.</b><br>
****FUNCTIONALITIE****</b><br>
When the application starts, it reads the subject file that contains all the languages and generate the Kmers per language.
It stores the top 300 Kmers with the most frequencies in a descending order in the subject language database.
This is done once at start of the application.
Once the user enters the query text and hit the process button they are re-routed to another page where the language
of query language will be displayed after 10 seconds.
The query text is passed to the back end. At the back end the query text will first be splitted into Kmers and the top
400 Kmers with the most frequencies will be stored in another database.
Then I used the out of place matric to calculate the distance between the Kmers in the 2 databases. 
The language with the distance closest to zero will be retain as the query language and displayed to the user.</b><br>
****DESIGN DECISION****</b><br>
I taught eliminating the spaces and special characters will give me a better prediction but  the results proof me wrong.
I got better results leaving the text in their original forms and some characters that I might consider as special characters
in fact are used in other languages. For example the inverted question mark (¿) and exclamation mark (¡) in Spanish have special meanings.
I also taught of converting all the characters to either lower or upper case characters but since we are dealing UTF-8.
I am not sure if all the languages have upper and lower cases. So, that can jeopardize the result if a language does not have lower or upper cases.
So, I decide to leave the texts in their original form.</b><br>
****DESIGN TECHNIQUES****</b><br>
In the project spec we were told to split the query text into Kmers and used the first 400 characters.
But I decided to split the query text and use the top 400 Kmers with the most frequencies or occurrence instead and got a better result.
I split the Kmers with an offset of one and the Kmers are made up of 2 characters each.
The Kmers are store as integer as it is less expensive on the memory compare to strings.</b><br>

********HOW TO RUN THE APPLICATION********</b><br>
-Install Tomcat, deploy the war file in the webapp folder.</b><br>
-Start the Tomcat server.</b><br>
-Navigate to http://localhost:8080/ngrams/</b><br>
-Create a data/wili-2018-Edited.txt in the bin directory in Tomcat.</b><br>
PS:It is advice to re-run the application each time you want to make a prediction.
It works for the first two times perfectly, but from the 3rd attempt it just keep giving back the result of the 
second prediction.</b><br>

********MINIMUM REQUIREMENT********</b><br>
-Computer
-Java
-Web browser
-Tomcat

********RESEARCH********</b><br>
I did research and watched a few videos online to help me do this project.
Here are some of the links I read and videos I watched:

1- How to use Tomcat in Eclipse
https://www.youtube.com/watch?v=PH-bK3g2YmU

2 -Create a dynamic web app in Eclipse and deploy on Tomcat
https://www.youtube.com/watch?v=EkacxN8gx08&list=PLsyeobzWxl7pUPF2xjjJiG4BKC9x_GY46&index=5

3-Encoding UFT-8
https://howtodoinjava.com/eclipse/how-to-display-non-english-unicode-e-g-chinese-characters-in-eclipse/
https://mifrahyoussef.wordpress.com/2014/01/03/display-non-english-characters-in-eclipse-console-arabic-chinese/
https://stackoverflow.com/questions/3751791/how-to-change-default-text-file-encoding-in-eclipse

4-Install Objectaid to draw a UML in Eclipse
https://www.youtube.com/watch?v=0Zlh56mTS6c
