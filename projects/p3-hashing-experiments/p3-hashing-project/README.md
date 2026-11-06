
# Project #: Project Name

* Author: Lisa Hitt
* Class: CS321 Section #
* Semester: Fall 2026
**3 Late coupons used for this project


## Overview

This project uses both linear probing and double hashing to take a variety of different keys (numbers, dates, words) and places them into a hashtable.  The experiment file uses both linear probing and double hashing and then compares the results. As expected, double hashing reduces collisions.

## Reflection

This project was tough for me. It probably would have went a lot better if I didn't procrastinate, but here we are.
The math went really well. I really enjoy the math behind linear probing and double hashing. I also enjoyed the TwinPrimeGenerator. The naming of things and making them protected, public, etc is coming easier to me.  I understand class hierarchy much more now.
The hardest part for me was the logistics of figuring out how to make sure that my output matched what the assignment was expecting.  As per usual, braces are still my enemy.


## Compiling and Using

To compile my code, open a terminal and make sure you are in the correct folder. To compile, type javac *.java
To run the program, type java HashtableExperiment arg1 arg2 arg 3.  arg1 is the data source (numbers, dates, or words)
arg2 is the load factor (how much are we loading the table)   arg3 is the debug level (What level of output do you want)



## Results 
### Random Numbers
| Load Factor | Linear Probing | Double Hashing |
|-------------|----------------|----------------|
| 0.50        | 1.4990         | 1.3873         |
| 0.60        | 1.7612         | 1.5261         |
| 0.70        | 2.1700         | 1.7227         |
| 0.80        | 3.0091         | 2.0061         |
| 0.90        | 5.3493         | 2.5400         |
| 0.95        | 9.7224         | 3.1377         |
| 0.99        | 32.0164        | 4.6342         |


### Dates

| Load Factor | Linear Probing | Double Hashing |
|-------------|----------------|----------------|
| 0.50        | 1.4882         | 1.5545         |
| 0.60        | 1.5453         | 1.6788         |
| 0.70        | 1.6005         | 1.8499         |
| 0.80        | 1.7965         | 2.2250         |
| 0.90        | 2.3320         | 2.8983         |
| 0.95        | 2.8453         | 3.5761         |
| 0.99        | 3.9769         | 5.2103         |

### Words

| Load Factor | Linear Probing | Double Hashing |
|-------------|----------------|----------------|
| 0.50        | 1.5969         | 1.3905         |
| 0.60        | 2.1494         | 1.5341         |
| 0.70        | 3.6039         | 1.7213         |
| 0.80        | 6.7084         | 2.0160         |
| 0.90        | 19.8149        | 2.5692         |
| 0.95        | 110.5940       | 3.1861         |
| 0.99        | 471.6714       | 4.6955         |



## Sources used (this is VERY important!)

ChatGPT  
I used ChatGPT as a learning and debugging resource throughout this project. I used it to better understand linear probing, double hashing, collision handling, and probe counts. I also used it to discuss errors in my program and identify possible causes of failed tests. I troubleshot an issue with reading word-list.txt, where skipping blank lines caused my output to differ from the expected results. I started the project by putting the AI policy in and asked Chat to follow the policy.  Below are prompts.  
Does it make sense that double hashing probecount is higher on dates?
How do I add the results into ReadMe?
(Most prompts were posting code in and asking if it looked ok)




----------

## Notes

* This README.md template is using Markdown. Here is some help on using Markdown: 
[markdown cheatsheet](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)


* Markdown can be edited and viewed natively in most IDEs such as Eclipse and VS Code. Just toggle
between the Markdown source and preview tabs.

* To preview your README.md output online, you can copy your file contents to a Markdown editor/previewer
such as [https://stackedit.io/app](https://stackedit.io/app).