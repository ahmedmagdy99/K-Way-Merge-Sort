import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Index {
    public static String [] DivideInputFileIntoRuns(String Inputfilename, int runSize) throws IOException {
        String [] files = new String[runSize];
        RandomAccessFile IndexFile = new RandomAccessFile(Inputfilename, "rw");
        long size = IndexFile.length()/runSize;
        for(int i=0; i<runSize; i++) {
            String FileName = "file" + (i + 1);
            RandomAccessFile file = new RandomAccessFile(FileName + ".bin", "rw");
            files[i] = FileName+".bin";
            for(int j=0; j<size/4; j++)
                file.writeInt(IndexFile.readInt());

        }
System.out.println(size);
        return files;
    }

    public static String [] SortEachRunOnMemoryAndWriteItBack (String [] RunsFilesNames) throws IOException {
        for(int i=0; i<RunsFilesNames.length; i++)
        {
            RandomAccessFile RunFile = new RandomAccessFile(RunsFilesNames[i] , "rw");

            ArrayList <Integer> keys = new ArrayList<>();

            for(int j=0; j<RunFile.length()/4; j++) {
                keys.add(j,RunFile.readInt());
                RunFile.readInt();
                System.out.print(keys.get(j)+"  ");
                System.out.println("$$$$");
            }
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$");
            /*int k, l, minIndex, tmp;
            for (k = 0; k < numbers.size() - 1; k++) {
                minIndex = k;
                for (l = k + 1; l < numbers.size(); l++)
                    if (numbers.get(l) < numbers.get(minIndex))
                        minIndex = l;
                if (minIndex != k) {
                    tmp = numbers.get(k);
                    numbers.add(k, numbers.get(minIndex));
                    numbers.add(minIndex , tmp);
                }
            }
            for(int j=0; j<RunFile.length()/4; j++) {
                RunFile.writeInt(numbers.get(j));
            }
                         */
        }


        return RunsFilesNames;
    }






    public static void main(String [] args) throws IOException {
        //Scanner in =new Scanner(System.in);
        //System.out.println("Please enter the input");
        //String stream=in.next();
        DivideInputFileIntoRuns("index.bin" , 3);
        //SortEachRunOnMemoryAndWriteItBack(DivideInputFileIntoRuns("index.bin" , 3));


    }
}
