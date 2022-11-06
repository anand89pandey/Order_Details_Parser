package in.unlimint.sample.parser.IncomeDataParser.service;

import com.opencsv.bean.CsvToBeanBuilder;
import model.CSVOderDataModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.List;

public class CSVParsingService implements ParsingService {
    @Override
    public void parse(String fileName)  {

        List<CSVOderDataModel> dataFromCsvFile = null;
        JSONArray orderList = new JSONArray();

        try {
             InputStreamReader isr = new InputStreamReader(new ClassPathResource(fileName, this.getClass().getClassLoader()).getInputStream());

            dataFromCsvFile = new CsvToBeanBuilder(isr)
                    .withType(CSVOderDataModel.class).build().parse();

            int id = 1;
            for (CSVOderDataModel data : dataFromCsvFile) {
                JSONObject orderDetail = new JSONObject();

                orderDetail.put("id", id);
                orderDetail.put("orderId", data.getOrderId());
                orderDetail.put("amount", data.getAmount());
                orderDetail.put("comment", data.getComment());
                orderDetail.put("fileName", fileName);
                orderDetail.put("line", id);
                orderDetail.put("result", "OK");

                orderList.add(orderDetail);
                id++;
            }

        } catch (IllegalStateException | IllegalArgumentException | FileNotFoundException exception) {
            exception.getStackTrace();
            JSONObject orderDetail = new JSONObject();
            orderDetail.put("Error", exception.getMessage());
            orderList.add(orderDetail);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(orderList.toJSONString());

    }


}
