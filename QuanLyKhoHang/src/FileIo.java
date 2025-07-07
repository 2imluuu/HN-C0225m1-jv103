import java.io.*;
import java.util.List;
public interface FileIo<T> {

    boolean writeCSVFile(List<T> lists, String csvFile);

    List<T> readCSV(String csvFile);
}