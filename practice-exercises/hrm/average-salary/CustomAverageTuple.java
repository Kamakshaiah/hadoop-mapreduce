import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Writable;
public class CustomAverageTuple implements Writable {
private Double average = new Double(0);
private long count = 1;
public Double getAverage() {
return average;
}
public void setAverage(Double average) {
this.average = average;
}
public long getCount() {
return count;
}
public void setCount(long count) {
this.count = count;
}
public void readFields(DataInput in) throws IOException {
average = in.readDouble();
count = in.readLong();
}
public void write(DataOutput out) throws IOException {
out.writeDouble(average);
out.writeLong(count);
}
public String toString() {
return average + "\t" + count;
}
}