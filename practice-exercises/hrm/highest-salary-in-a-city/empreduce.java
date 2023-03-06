import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
public class empreduce extends Reducer<Text, Text,Text, Text>
{
public void reduce(Text key,Iterable<Text> itr,Context context) throws IOException, InterruptedException
{ int maxsal=0;
String s= “” ;
String sal = ” “;

for (Text val : itr){
String arr[] = val.toString().split(“\\s”);
if (maxsal < Integer.parseInt(arr[1]))
{
maxsal = Integer.parseInt(arr[1]);
sal = arr[1].toString();

s = arr[0].toString();

}

}
context.write(new Text(key), new Text(s.toString() +”  ” + sal.toString()));

}

}