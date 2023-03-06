import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class empmap extends Mapper<Object, Text, Text, Text> {

public void map(Object key,Text value,Context ctx) throws IOException, InterruptedException
{
String[] arr=value.toString().split(“\\s”);
ctx.write(new Text(arr[2].toString()), new Text((arr[1].toString()) + ” ” +arr[4].toString()));
}
}