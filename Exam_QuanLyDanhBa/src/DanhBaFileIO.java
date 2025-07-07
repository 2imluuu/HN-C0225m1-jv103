import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DanhBaFileIO implements FileIO<DanhBa> {
    @Override
    public boolean writeCSVFile(List<DanhBa> danhBaList, String csvFile) {
        try {
            File file = new File(csvFile);
            File folder = new File("contacts.csv");
            if (!folder.exists()) folder.mkdir();
            if (!file.exists()) file.createNewFile();
            Writer writer = new BufferedWriter(new FileWriter(file));
            for (DanhBa danhBa : danhBaList) {
                String text = danhBa.getSoDienThoai() + "," + danhBa.getFaceBook() + "," + danhBa.getTen() + "," + danhBa.getGioiTinh() + "," + danhBa.getEmail() + "," + danhBa.getNgaySinh() + "\n";
                try {
                    writer.write(text);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            writer.flush();
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<DanhBa> readCSV(String csvFile) {
        List<DanhBa> danhBaList = new ArrayList<>();
        try {
            File file = new File("contacts.csv");
            if (!file.exists()) file.createNewFile();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String cvsSplitBy = ",";
                if (line.contains(cvsSplitBy)) {
                    String[] data = line.split(cvsSplitBy);
                    DanhBa danhBa = new DanhBa();
                    danhBa.setSoDienThoai(data[0]);
                    danhBa.setFaceBook(data[1]);
                    danhBa.setTen(data[2]);
                    danhBa.setGioiTinh(data[3]);
                    danhBa.setEmail(data[4]);
                    danhBa.setNgaySinh(data[5]);
                    danhBaList.add(danhBa);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return danhBaList;
    }
}