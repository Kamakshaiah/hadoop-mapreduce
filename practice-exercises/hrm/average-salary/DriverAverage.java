import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
public class DriverAverage {
public static void main(String[] args) throws Exception {
/*
* I have used my local path in windows change the path as per your
* local machine
*/
args = new String[] { "Replace this string with Input Path location",
"Replace this string with output Path location" };
/* delete the output directory before running the job */
FileUtils.deleteDirectory(new File(args[1]));
/* set the hadoop system parameter */
System.setProperty("hadoop.home.dir", "replace this with hadoop home directory location");
if (args.length != 2) {
System.err.println("Please specify the input and output path");
System.exit(-1);
}
Configuration conf = ConfigurationFactory.getInstance();
Job job = Job.getInstance(conf);
job.setJarByClass(DriverAverage.class);
job.setJobName("Find_Average_Salary");
FileInputFormat.addInputPath(job, new Path(args[0]));
FileOutputFormat.setOutputPath(job, new Path(args[1]));
job.setMapperClass(AverageSalaryPerDepartmentMapper.class);
job.setReducerClass(AverageSalaryPerDepartmentReducer.class);
job.setOutputKeyClass(Text.class);
job.setOutputValueClass(CustomAverageTuple.class);
System.exit(job.waitForCompletion(true) ? 0 : 1);
}
}