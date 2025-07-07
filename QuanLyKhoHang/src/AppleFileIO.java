import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AppleFileIO implements FileIo<Apple> {
    @Override
    public boolean writeCSVFile(List<Apple> AppleList, String csvFile) {
        try {
            File file = new File(csvFile);
            File folder = new File("contacts.csv");
            if (!folder.exists()) folder.mkdir();
            if (!file.exists()) file.createNewFile();
            Writer writer = new BufferedWriter(new FileWriter(file));
            for (Apple apple : AppleList) {
                String text = apple.getLoai() + "," + apple.getTen() + "," + apple.getSoLuong() + "," + apple.getDungLuong() + "," + apple.getSoLuong() + "," + apple.getGia() + "\n";
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
    public List<Apple> readCSV(String csvFile) {
        List<Apple> appleList = new ArrayList<>();
        try {
            File file = new File("contacts.csv");
            if (!file.exists()) file.createNewFile();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String cvsSplitBy = ",";
                if (!line.contains(cvsSplitBy)) continue;

                String[] data = line.split(cvsSplitBy);

                if (data.length < 6) continue;

                LoaiHang loai = new LoaiHang(data[0]);
                Apple apple;

                switch (loai.getTen().toLowerCase()) {
                    case "iphone":
                        apple = new Iphone();
                        break;
                    case "ipad":
                        apple = new Ipad();
                        break;
                    case "macbook":
                        apple = new Macbook();
                        break;
                    default:
                        continue;
                }

                apple.setLoaiHang(loai);
                apple.setTen(data[1]);
                apple.setSoLuong(Integer.parseInt(data[2]));
                apple.setGia(Double.parseDouble(data[3]));
                apple.setMau(data[4]);
                apple.setDungLuong(Integer.parseInt(data[5]));

                appleList.add(apple);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return appleList;
    }
}