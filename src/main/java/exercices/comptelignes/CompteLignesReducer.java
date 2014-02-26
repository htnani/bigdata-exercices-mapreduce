package exercices.comptelignes;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Le "reducer" du compteur de lignes.
 */
public class CompteLignesReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int nombreDeLignes = 0;

        // On prend toutes les valeurs et on les additionne
        for (IntWritable valeur : values) {
            nombreDeLignes += valeur.get();
        }

        // Finalement, on écrit la somme
        context.write(key, new IntWritable(nombreDeLignes));
    }
}
