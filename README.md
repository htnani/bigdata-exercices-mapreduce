# Exercices MapReduce du cours de big data

## Préparation

### Mise à jour de la machine virtuelle

### Téléchargement des fichiers de données

### Copie des fichiers de données sur la machine virtuelle

## Manipulation des fichiers avec HDFS

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

### Visualisation de l'exécution de la tâche

## Votre première tâche MapReduce

### Ouverture du projet dans Eclipse

### Modification

