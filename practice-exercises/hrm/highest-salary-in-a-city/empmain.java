import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
public final class empmain {

public static void main(String[] args) throws IllegalArgumentException, IOException, ClassNotFoundException, InterruptedException
{
Configuration conf=new Configuration();
Job job=Job.getInstance(conf,”emain”);
job.setJarByClass(empmain.class);
job.setMapperClass(empmap.class);
//job.setNumReduceTasks(0);
job.setReducerClass(empreduce.class);
//job.setMapOutputKeyClass(Text.class);
////job.setReducerClass(Empreduce.class);
//job.setMapOutputValueClass(Text.class);
job.setOutputKeyClass(Text.class);
//job.setOutputValueClass(ArrayWritable.class);
job.setOutputValueClass(Text.class);
FileInputFormat.addInputPath(job, new Path(args[0]));
FileOutputFormat.setOutputPath(job, new Path(args[1]));
System.exit(job.waitForCompletion(true) ? 0 : 1);

}

}