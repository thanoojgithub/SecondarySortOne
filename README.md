# SecondarySortOne
SecondarySort  using MapReduce - sort by value of reducer input&lt;key,value>






```
$ ls -ltr
total 10
-rw-r--r-- 1 thanooj hadoop 8610 Mar  9 12:15 SecondarySortOne-1.0.jar
drwxr-xr-x 2 thanooj hadoop    3 Mar  9 12:20 input
drwxr-xr-x 2 thanooj hadoop    2 Mar  9 12:21 output

$ cd input/
$ ls -ltr
total 3
-rw-r--r-- 1 thanooj hadoop 377 Mar  9 12:20 temparature.txt

$ cat temparature.txt
2012,01,01,5
2012,01,02,45
2012,01,03,35
2012,01,04,10
2001,11,01,46
2001,11,02,47
2001,11,03,48
2001,11,04,40
2005,08,20,50
2005,08,21,52
2005,08,22,38
2005,08,23,70
2011,11,02,47
2011,11,03,48
2011,11,04,40
2015,08,20,50
2015,08,21,52
2015,08,22,38
2015,08,23,70
2010,11,01,46
2010,11,02,47
2010,11,03,48
2010,11,04,40
2002,08,20,50
2002,08,21,52
2002,08,22,38
2002,08,23,70
$ cd ..

$ thanooj jar SecondarySortOne-1.0.jar com.SecondarySortDriver /home/thanooj/work/input/temparature.txt /home/thanooj/work/output/

$ cat output/part-r-00000
2001 11 04      40
2001 11 01      46
2001 11 02      47
2001 11 03      48
2002 08 22      38
2002 08 20      50
2002 08 21      52
2002 08 23      70
2005 08 22      38
2005 08 20      50
2005 08 21      52
2005 08 23      70
2010 11 04      40
2010 11 01      46
2010 11 02      47
2010 11 03      48
2011 11 04      40
2011 11 02      47
2011 11 03      48
2012 01 01      5
2012 01 04      10
2012 01 03      35
2012 01 02      45
2015 08 22      38
2015 08 20      50
2015 08 21      52
2015 08 23      70
$
```
