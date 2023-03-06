import org.apache.hadoop.io.* ;
import java.util.* ;
 
public class WritablesTest
{
  public static class TextArrayWritable extends ArrayWritable
  {
     public TextArrayWritable()
    {
      super(Text.class) ;
    }
  }
 
  public static class IntArrayWritable extends ArrayWritable  
  {
    public IntArrayWritable()
    {
      super(IntWritable.class) ;
    }
  }
 
  public static void main(String[] args)
  {
 
   IntWritable i1 = new IntWritable(2) ;
   IntWritable i2 = new IntWritable() ;
   i2.set(5);
 
   IntWritable i3 = new IntWritable();
   i3.set(i2.get());
 
   System.out.printf("Int Writables Test I1:%d , I2:%d , I3:%d", i1.get(), i2.get(), i3.get()) ;
 
   BooleanWritable bool1 = new BooleanWritable() ;
   bool1.set(true);
 
   ByteWritable byte1 = new ByteWritable( (byte)7) ;
 
   System.out.printf("\n Boolean Value:%s Byte Value:%d", bool1.get(), byte1.get()) ;
 
   Text t = new Text("hadoop");
   Text t2 = new Text();
   t2.set("pig");
 
   System.out.printf("\n t: %s, t.legth: %d, t2: %s, t2.length: %d \n", t.toString(), t.getLength(), t2.getBytes(), t2.getBytes().length);
 
   ArrayWritable a = new ArrayWritable(IntWritable.class) ;
   a.set( new IntWritable[]{ new IntWritable(10), new IntWritable(20), new IntWritable(30)}) ;
 
   ArrayWritable b = new ArrayWritable(Text.class) ;
   b.set( new Text[]{ new Text("Hello"), new Text("Writables"), new Text("World !!!")}) ;
 
   for (IntWritable i: (IntWritable[])a.get())
   System.out.println(i) ;
 
   for (Text i: (Text[])b.get())
   System.out.println(i) ;
 
   IntArrayWritable ia = new IntArrayWritable() ;
   ia.set( new IntWritable[]{ new IntWritable(100), new IntWritable(300), new IntWritable(500)}) ;
 
   IntWritable[] ivalues = (IntWritable[])ia.get() ;
 
   for (IntWritable i : ivalues)
   System.out.println(i);
 
   MapWritable m = new MapWritable() ;
   IntWritable key1 = new IntWritable(1) ;
   NullWritable value1 = NullWritable.get() ;
   
   m.put(key1, value1) ;
   m.put(new VIntWritable(2), new LongWritable(163)); 
   m.put(new VIntWritable(3), new Text("Mapreduce"));
   
   System.out.println(m.containsKey(key1)) ;
   System.out.println(m.get(new VIntWritable(3))) ;
 
   m.put(new LongWritable(1000000000), key1) ;
   Set<Writable> keys = m.keySet() ;
 
   for(Writable w: keys)
    System.out.println(m.get(w)) ;
  }
}