# Problem

Develop a file system using OO (object oriented) principles.  
The solution should take into consideration the basic aspects of a file system (folders and files), the properties of each one (dates, permissions, etc.) as well as the main operations that can be done (create, move, copy, etc.).

## Analysis

There should be two classes, Folder and File, each representing a folder and a file, respectively.  

### Folder
The folder, will, therefore, have a list of folders inside, since a folder can have several folders inside, and the same thing goes for files. A folder is made to be able to have several of both.  

### File
The file will only have a name.
Regarding the extension of the file, it is included in the name.
