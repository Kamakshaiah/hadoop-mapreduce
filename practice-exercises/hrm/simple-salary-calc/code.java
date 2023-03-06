public static class Mymap extends Mapper<LongWritable,Text,Text,Text>    
 {  
  public void map(LongWritable k,Text v, Context con)throws IOException, InterruptedException  
  {  
   String line = v.toString();  
   String[] w=line.split(",");  
   int sal=Integer.parseInt(w[3]);  
   string name=Integer.parseInt(w[1]);
   con.write(new Text(name), new Text(name+","+sal));  
   }  
 } 

 public static class MyRed extends Reducer<Text,Text,IntWritable,Text>  
 {  
  public void reduce(Text k, Iterable<Text> vlist, Context con)
  throws IOException , InterruptedException  
     {  
      int max=0;  
      for(Text v:vlist)  
   {
        String line = v.toString();  
        String[] w=line.split(",");  
        int sal=Integer.parseInt(w[1]); 
        max=Math.max(max, sal);
   }  
   con.write(new IntWritable(max), k);  
  }

 }