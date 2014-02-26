package exercices.comptelignes;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Le "mapper" du compteur de lignes.
 */
public class CompteLignesMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // On ignore ici la valeur. Dans votre code, vous en aurez besoin.
        String ligne = value.toString();

        // On émet ici une seule valeur, toujours vers la même clef.
        context.write(new Text("nombreDeLignes"), new IntWritable(1));
    }
}
