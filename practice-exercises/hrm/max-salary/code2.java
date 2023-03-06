public class MyMap extends Mapper<LongWritable,Text,Text,Text>    
   {  
     public void map(LongWritable k,Text v, Mapper<LongWritable,Text,Text,Text>.Context 
     con)throws IOException, InterruptedException  
   {  
     String line = v.toString();  
     String[] w=line.split(","); 
     String name = w[1] ; 
    int sal=Integer.parseInt(w[3]);  
    String map_op = name+","+sal ; 
    con.write(new Text("ds"), new Text(map_op)); 
    //ds {raj,8000 kiran,6000 john,9000}

    }  
   }

   public class MyRed extends Reducer<Text,Text,IntWritable,Text>  
   {  
   
         //ds {raj,8000 kiran,6000 john,9000}
   
    public void reduce(Text k, Iterable<Text> vlist, Reducer<Text,Text,IntWritable,Text>.Context con)
    throws IOException , InterruptedException  
       {  
        int max=0;  
        String name = k.toString() ;
   
        for(Text v: vlist)  
     {
   
            int salary = Integer.parseInt(v.toString().split(",")[1]) ;
            max=Math.max(max, salary); 
   
            if(salary == max)
           {
               name = v.toString().split(",")[0] ;
           }
     }  
   
     con.write(new IntWritable(max), new Text(name));  
    }
   }