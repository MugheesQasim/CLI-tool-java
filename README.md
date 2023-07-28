# CLI-tool-java




## Command

```
ccwc [-l/-w/-m/-c] Path-to-file
```
-l   to get the number of lines in a file
<br>
-w   to get the number of words in a file
<br>
-m   to get the number of characters in a file
<br>
-c   to get the number of bytes in a file
<br>
<br>

## What does this tool do?
- Gives a file's exact number of words, characters, bytes, and lines. 
- Can handle different character encodings
- Can handle different file types
<br>

## How to use this tool? (Windows)

1-) Clone this repo

2-) Create a new text file anywhere on your device and write the following script (Replace your project path with "PathToProject") and save it as ccwc.bat file

```
@echo off
java -cp "PathToProject/target/classes" Main
```

3-) Add the path of this ccwc.bat file in the Path in user variables
  
You are all set and can now use ccwc command.
