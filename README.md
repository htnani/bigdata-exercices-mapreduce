# Exercices MapReduce du cours de big data

## Préparation

### Mise à jour de la machine virtuelle

```
wget https://raw.github.com/jfim/bigdata-exercices-mapreduce/master/miseajourvm.sh
chmod +x miseajourvm.sh
sudo ./miseajourvm.sh
```

### Téléchargement des fichiers de données

Les fichiers sont sur R:\H14N\INF-O17 gr.000001\documents

### Copie des fichiers de données sur la machine virtuelle

## Manipulation des fichiers avec HDFS

```
hadoop fs
```
```
Usage: hadoop fs [generic options]
        [-cat [-ignoreCrc] <src> ...]
        [-chgrp [-R] GROUP PATH...]
        [-chmod [-R] <MODE[,MODE]... | OCTALMODE> PATH...]
        [-chown [-R] [OWNER][:[GROUP]] PATH...]
        [-copyFromLocal <localsrc> ... <dst>]
        [-copyToLocal [-ignoreCrc] [-crc] <src> ... <localdst>]
        [-count [-q] <path> ...]
        [-cp <src> ... <dst>]
        [-df [-h] [<path> ...]]
        [-du [-s] [-h] <path> ...]
        [-expunge]
        [-get [-ignoreCrc] [-crc] <src> ... <localdst>]
        [-getmerge [-nl] <src> <localdst>]
        [-help [cmd ...]]
        [-ls [-d] [-h] [-R] [<path> ...]]
        [-mkdir [-p] <path> ...]
        [-moveFromLocal <localsrc> ... <dst>]
        [-moveToLocal <src> <localdst>]
        [-mv <src> ... <dst>]
        [-put <localsrc> ... <dst>]
        [-rm [-f] [-r|-R] [-skipTrash] <src> ...]
        [-rmdir [--ignore-fail-on-non-empty] <dir> ...]
        [-setrep [-R] [-w] <rep> <path/file> ...]
        [-stat [format] <path> ...]
        [-tail [-f] <file>]
        [-test -[ezd] <path>]
        [-text [-ignoreCrc] <src> ...]
        [-touchz <path> ...]
        [-usage [cmd ...]]

Generic options supported are
-conf <configuration file>     specify an application configuration file
-D <property=value>            use value for given property
-fs <local|namenode:port>      specify a namenode
-jt <local|jobtracker:port>    specify a job tracker
-files <comma separated list of files>    specify comma separated files to be copied to the map reduce cluster
-libjars <comma separated list of jars>    specify comma separated jar files to include in the classpath.
-archives <comma separated list of archives>    specify comma separated archives to be unarchived on the compute machines.

The general command line syntax is
bin/hadoop command [genericOptions] [commandOptions]
```

### Affichage de votre répertoire personnel

```
hadoop fs -ls /user
```

```
Found 3 items
drwxr-xr-x   - bigdata supergroup          0 2014-02-26 01:17 /user/bigdata
drwxrwxr-t   - hive    hive                0 2014-02-08 19:12 /user/hive
drwxrwxr-x   - oozie   oozie               0 2014-02-08 19:14 /user/oozie
```

```
hadoop fs -ls /user/bigdata
```

### Copie des fichiers de la machine virtuelle vers HDFS

```
hadoop fs -mkdir /user/bigdata/ontime
```

```
hadoop fs -ls /user/bigdata
```

```
Found 1 items
drwxr-xr-x   - bigdata supergroup          0 2014-02-26 01:19 /user/bigdata/ontime
```

## Exécution d'une tâche sur Hadoop

### Compilation du projet

```
cd /data/bigdata-exercices-mapreduce
mvn package
```
```
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building bigdata-exercices-mapreduce 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- maven-resources-plugin:2.3:resources (default-resources) @ bigdata-exercices-mapreduce ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /data/bigdata-exercices-mapreduce/src/main/resources
[INFO]
[INFO] --- maven-compiler-plugin:2.1:compile (default-compile) @ bigdata-exercices-mapreduce ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-resources-plugin:2.3:testResources (default-testResources) @ bigdata-exercices-mapreduce ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /data/bigdata-exercices-mapreduce/src/test/resources
[INFO]
[INFO] --- maven-compiler-plugin:2.1:testCompile (default-testCompile) @ bigdata-exercices-mapreduce ---
[INFO] No sources to compile
[INFO]
[INFO] --- maven-surefire-plugin:2.10:test (default-test) @ bigdata-exercices-mapreduce ---
[INFO] No tests to run.
[INFO] Surefire report directory: /data/bigdata-exercices-mapreduce/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------

Results :

Tests run: 0, Failures: 0, Errors: 0, Skipped: 0

[INFO]
[INFO] --- maven-jar-plugin:2.2:jar (default-jar) @ bigdata-exercices-mapreduce ---
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 14.222s
[INFO] Finished at: Wed Feb 26 01:21:59 EST 2014
[INFO] Final Memory: 7M/59M
[INFO] ------------------------------------------------------------------------
```

### Démarrage de la tâche

```
hadoop jar target/bigdata-exercices-mapreduce-1.0-SNAPSHOT.jar exercices.comptelignes.CompteLignes /user/bigdata/ontime /user/bigdata/output
```

```
14/02/26 01:06:55 WARN mapred.JobClient: Use GenericOptionsParser for parsing the arguments. Applications should implement Tool for the same.
14/02/26 01:06:57 INFO input.FileInputFormat: Total input paths to process : 1
14/02/26 01:06:59 INFO mapred.JobClient: Running job: job_201402252318_0004
14/02/26 01:07:00 INFO mapred.JobClient:  map 0% reduce 0%
14/02/26 01:07:36 INFO mapred.JobClient:  map 100% reduce 0%
14/02/26 01:07:51 INFO mapred.JobClient:  map 100% reduce 100%
14/02/26 01:07:57 INFO mapred.JobClient: Job complete: job_201402252318_0004
14/02/26 01:07:57 INFO mapred.JobClient: Counters: 32
14/02/26 01:07:57 INFO mapred.JobClient:   File System Counters
14/02/26 01:07:57 INFO mapred.JobClient:     FILE: Number of bytes read=70
14/02/26 01:07:57 INFO mapred.JobClient:     FILE: Number of bytes written=322250
14/02/26 01:07:57 INFO mapred.JobClient:     FILE: Number of read operations=0
14/02/26 01:07:57 INFO mapred.JobClient:     FILE: Number of large read operations=0
14/02/26 01:07:57 INFO mapred.JobClient:     FILE: Number of write operations=0
14/02/26 01:07:57 INFO mapred.JobClient:     HDFS: Number of bytes read=675
14/02/26 01:07:57 INFO mapred.JobClient:     HDFS: Number of bytes written=18
14/02/26 01:07:57 INFO mapred.JobClient:     HDFS: Number of read operations=2
14/02/26 01:07:57 INFO mapred.JobClient:     HDFS: Number of large read operations=0
14/02/26 01:07:57 INFO mapred.JobClient:     HDFS: Number of write operations=1
14/02/26 01:07:57 INFO mapred.JobClient:   Job Counters
14/02/26 01:07:57 INFO mapred.JobClient:     Launched map tasks=1
14/02/26 01:07:57 INFO mapred.JobClient:     Launched reduce tasks=1
14/02/26 01:07:57 INFO mapred.JobClient:     Data-local map tasks=1
14/02/26 01:07:57 INFO mapred.JobClient:     Total time spent by all maps in occupied slots (ms)=16883
14/02/26 01:07:57 INFO mapred.JobClient:     Total time spent by all reduces in occupied slots (ms)=26617
14/02/26 01:07:57 INFO mapred.JobClient:     Total time spent by all maps waiting after reserving slots (ms)=0
14/02/26 01:07:57 INFO mapred.JobClient:     Total time spent by all reduces waiting after reserving slots (ms)=0
14/02/26 01:07:57 INFO mapred.JobClient:   Map-Reduce Framework
14/02/26 01:07:57 INFO mapred.JobClient:     Map input records=26
14/02/26 01:07:57 INFO mapred.JobClient:     Map output records=26
14/02/26 01:07:57 INFO mapred.JobClient:     Map output bytes=494
14/02/26 01:07:57 INFO mapred.JobClient:     Input split bytes=114
14/02/26 01:07:57 INFO mapred.JobClient:     Combine input records=0
14/02/26 01:07:57 INFO mapred.JobClient:     Combine output records=0
14/02/26 01:07:57 INFO mapred.JobClient:     Reduce input groups=1
14/02/26 01:07:57 INFO mapred.JobClient:     Reduce shuffle bytes=66
14/02/26 01:07:57 INFO mapred.JobClient:     Reduce input records=26
14/02/26 01:07:57 INFO mapred.JobClient:     Reduce output records=1
14/02/26 01:07:57 INFO mapred.JobClient:     Spilled Records=52
14/02/26 01:07:57 INFO mapred.JobClient:     CPU time spent (ms)=2520
14/02/26 01:07:57 INFO mapred.JobClient:     Physical memory (bytes) snapshot=286416896
14/02/26 01:07:57 INFO mapred.JobClient:     Virtual memory (bytes) snapshot=1892405248
14/02/26 01:07:57 INFO mapred.JobClient:     Total committed heap usage (bytes)=175312896
```


### Visualisation de l'exécution de la tâche

http://10.5.17.118:50030/jobtracker.jsp

### La sortie de la tâche

```
hadoop fs -ls /user/bigdata/output
```

```
Found 3 items
-rw-r--r--   3 bigdata supergroup          0 2014-02-26 01:07 /user/bigdata/output/_SUCCESS
drwxr-xr-x   - bigdata supergroup          0 2014-02-26 01:06 /user/bigdata/output/_logs
-rw-r--r--   3 bigdata supergroup         18 2014-02-26 01:07 /user/bigdata/output/part-r-00000
```

```
hadoop fs -cat /user/bigdata/output/part-r-00000
```

```
nombreDeLignes  26
```

## Votre première tâche MapReduce

### Ouverture du projet dans Eclipse

Ajouter le logiciel enfichable M2Eclipse:

http://download.eclipse.org/technology/m2e/releases

Alternativement, vous devez télécharger Maven http://maven.apache.org/ et l'extraire sur votre bureau, puis exécuter

```
SET PATH=%PATH%;c:\users\jfim\desktop\apache-maven-3.2.1\bin
SET "JAVA_HOME=C:\Program Files (x86)\Java\jdk1.7.0_45"
```

À partir de ce moment, la commande "mvn" devrait fonctionner. Si tout fonctionne, connectez le lecteur réseau sur une lettre (par exemple Z:) puis exécutez:

```
z:
cd bigdata-exercices-mapreduce
mvn eclipse:eclipse
mvn -Declipse.workspace=C:\users\jfim\workspace eclipse:configure-workspace
```

Vous devriez maintenant être capable d'importer le projet Eclipse.

### Modification

### Compilation et exécution

### Problèmes

- Combien de vols par compagnie aerienne?
- Quelle paire d'aéroports à fait le plus de vols en 2013?
- Quel avion a le plus volé en 2013? Quel quantité de milles a-t-il volé?
- En moyenne, quelle compagnie aerienne a le plus de retards?
- Quel mois est-ce qu'il y a le plus de retards? Quelle heure? Quel jour de la semaine?
- Quel jour est-ce qu'il y a le plus d'annulations de vols?
- Est-ce qu'il y a une correlation entre la duree d'un vol et la quantite de retards?
- Quels conseils donneriez-vous a quelqu'un qui veut eviter d'etre en retard?
- Selon vous, comment feriez-vous pour joindre deux ensembles de données avec MapReduce?
