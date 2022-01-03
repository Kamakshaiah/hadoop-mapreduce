import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class EmployeeMinMaxCountReducer extends Reducer<Text, CustomMinMaxTuple, Text, CustomMinMaxTuple> {
    private CustomMinMaxTuple result = new CustomMinMaxTuple();

    public void reduce(Text key, Iterable<CustomMinMaxTuple> values, Context context)
            throws IOException, InterruptedException {
        result.setMin(null);
        result.setMax(null);
        result.setCount(0);
        long sum = 0;
        for (CustomMinMaxTuple minMaxCountTuple : values) {
            if (result.getMax() == null || (minMaxCountTuple.getMax() > result.getMax())) {
                result.setMax(minMaxCountTuple.getMax());
            }
            if (result.getMin() == null || (minMaxCountTuple.getMin() < result.getMin())) {
                result.setMin(minMaxCountTuple.getMin());
            }
            sum = sum + minMaxCountTuple.getCount();
            result.setCount(sum);
        }
        context.write(new Text(key.toString()), result);
    }
}