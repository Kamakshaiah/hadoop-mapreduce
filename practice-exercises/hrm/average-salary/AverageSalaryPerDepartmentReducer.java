import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
public class AverageSalaryPerDepartmentReducer extends Reducer<Text, CustomAverageTuple, Text, CustomAverageTuple> {
private CustomAverageTuple result = new CustomAverageTuple();
public void reduce(Text key, Iterable<CustomAverageTuple> values, Context context)
throws IOException, InterruptedException {
double sum = 0;
long count = 0;
for (CustomAverageTuple customAverageTuple : values) {
sum = sum + customAverageTuple.getAverage() * customAverageTuple.getCount();
count = count + customAverageTuple.getCount();
}
result.setCount(count);
result.setAverage(sum / count);
context.write(new Text(key.toString()), result);
}
}