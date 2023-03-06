import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class AverageSalaryPerDepartmentMapper extends Mapper<Object, Text, Text, CustomAverageTuple> {
private CustomAverageTuple averageTuple = new CustomAverageTuple();
private Text departmentName = new Text();
@Override
public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
String data = value.toString();
String[] field = data.split(",", -1);
double salary = 0;
if (null != field && field.length == 9 && field[7].length() >0) {
salary=Double.parseDouble(field[7]);
averageTuple.setAverage(salary);
averageTuple.setCount(1);
departmentName.set(field[3]);
context.write(departmentName, averageTuple);
}
}
}
