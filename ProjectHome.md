## Description ##

JDigest is an open source graphical file MD5 / SHA-1 digest calculator and verifier, written in Java for cross-platform portability.

Windows version has an installer that creates the necessary Explorer associations so that you can calculate / verify checksums by right clicking on files or folders.

Ubuntu users can use the Ubuntu package which will automatically install nautilus-actions and create the Nautilus context menu associations.

In other platforms it can be run by double-clicking the .jar file and going through the wizard-style interface.

## Screenshots ##

For screenshots of JDigest running on a Mac, click [here](http://mac.softpedia.com/progScreenshots/JDigest-Screenshot-63584.html)

Digest options screen:

![http://jdigest.googlecode.com/files/jdigest-screen03.png](http://jdigest.googlecode.com/files/jdigest-screen03.png)

Digest progress screen:

![http://jdigest.googlecode.com/files/jdigest-screen04.png](http://jdigest.googlecode.com/files/jdigest-screen04.png)

[More screenshots](http://code.google.com/p/jdigest/downloads/list?can=2&q=Type-Screenshot&colspec=Filename+Summary+Uploaded+Size+DownloadCount).

## Requirements ##
  * JRE 6

## Current features ##
  * Two modes of operation: calculates the checksum of the given files and directories (recursively) into a digest file, and matches file checksums against a digest file
  * Wizard-like GUI
  * Progress indicators: size, speed and ETA, for both current file and total
  * Windows Explorer and Nautilus integration
  * 3 path treatment modes: full paths, relative to digest file location or relative to user-defined location
  * Possibility to choose the encoding of the digest file (useful when you have a muti-cultural environment with file names using different code pages like, say, French and Japanese)

## Current issues ##
  * The source code is plain ugly. I used to be a good coder, but it's surprising how rusty you can get when you don't code often. Suggestions are welcome.
  * Can not digest from Nautilus context menu in Ubuntu 11.04 if the selected file name contains spaces: please follow the workaround described in http://code.google.com/p/jdigest/issues/detail?id=3&can=1 to fix this issue.
  * Nautilus-actions 3.1.2: only folders can be digested from Nautilus context menu (http://code.google.com/p/jdigest/issues/detail?id=4).

## Future features ##
  * Internationalization
  * Help & about
  * DDE for supporting multiple file selection from Windows Explorer (seems like quite a challenge in a Java application, though)