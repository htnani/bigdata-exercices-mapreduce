package exercices.comptelignes;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * Un compteur de lignes.
 */
public class CompteLignes {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Usage: CompteLignes <repertoire d'entree> <repertoire de sortie>");
            System.exit(-1);
        }

        // On crée la tâche à envoyer à Hadoop MapReduce
        Job job = new Job();

        job.setJarByClass(CompteLignes.class);

        // On spécifie le nom de la tâche. Comme celle-ci est visible dans
        // l'interface web de Hadoop MapReduce et que c'est le seul moyen
        // de la distinguer d'une autre tâche, un bon nom est utile.
        job.setJobName("Compte lignes");

        // On configure les répertoires d'entrée et de sortie.
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        // On spécifie les classes a utiliser pour la phase Map et la phase Reduce
        job.setMapperClass(CompteLignesMapper.class);
        job.setReducerClass(CompteLignesReducer.class);

        // On spécifie le format de sortie
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        // Finalement, on lance la tâche sur le "cluster" et on attend qu'elle se termine
        boolean completeSansErreurs = job.waitForCompletion(true);

        if (completeSansErreurs)
            System.exit(0);
        else
            System.exit(1);
    }
}
