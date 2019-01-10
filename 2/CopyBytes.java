import java.io.*;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
    	
    	// parva zadaha
//        FileInputStream in = null;
//        FileOutputStream out = null;
//        try {
//            in = new FileInputStream("source.txt");
//            out = new FileOutputStream("result.txt");
//            int c;
//
//            while ((c = in.read()) != -1) {
//                out.write(c);
//            }
//        } catch (IOException e) {
//        	  System.out.println(e);
//          }
//         finally {
//            if (in != null) {
//                in.close();
//            }
//            if (out != null) {
//                out.close();
//            }
//        }
        
//        // s buferirane
//    	BufferedInputStream in = null;
//    	BufferedOutputStream out = null;
//        try {
//        	in = new BufferedInputStream(new FileInputStream("source.txt"));
//            out = new BufferedOutputStream(new FileOutputStream("result.txt"));
//            int c;
//
//            while ((c = in.read()) != -1) {
//                out.write(c);
//            }
//
//        } finally {
//            if (in != null) {
//                in.close();
//            }
//            if (out != null) {
//                out.close();
//            }
//        }
        
        // s tekstovi potoci
    	FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("source.txt");
            outputStream = new FileWriter("result.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }

    }
}