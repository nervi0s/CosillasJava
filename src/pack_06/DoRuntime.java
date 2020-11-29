package pack_06;

import java.io.*;
import java.util.*;
 
public class DoRuntime {
  public static void main(String args[]) throws IOException {

    if (args.length <= 0) {
      System.err.println("Need command to run");
      System.exit(-1);
    }

    Runtime runtime = Runtime.getRuntime();
    Process process = runtime.exec(args);
    InputStream is = process.getInputStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    String line;

    System.out.printf("Output of running %s is:", 
        Arrays.toString(args));

    while ((line = br.readLine()) != null) {
      System.out.println(line);
    }

  }
 } 