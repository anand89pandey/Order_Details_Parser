package in.unlimint.sample.parser.IncomeDataParser.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStreamReader;

public class JsonParsingService implements ParsingService {
    @Override
    public void parse(String fileName) {

        try {
            InputStreamReader isr = new InputStreamReader(new ClassPathResource(fileName, this.getClass().getClassLoader()).getInputStream());

            JSONParser jsonParser = new JSONParser();
            JSONArray resultOrderList = new JSONArray();

            Object obj = jsonParser.parse(isr);

            JSONArray orderList = new JSONArray();
            orderList.add(obj);

            int id = 1;
            for (Object orders : orderList) {

                JSONObject order = (JSONObject) orders;
                JSONArray orderDetails = (JSONArray) order.get("orders");
                for (Object object : orderDetails) {
                    JSONObject orderDetail = new JSONObject();
                    JSONObject orderObject = (JSONObject) object;
                    orderDetail.put("id", id);
                    orderDetail.put("orderId", orderObject.get("orderId"));
                    orderDetail.put("amount", orderObject.get("amount"));
                    orderDetail.put("comment", orderObject.get("comment"));
                    orderDetail.put("fileName", fileName);
                    orderDetail.put("line", id);
                    orderDetail.put("result", "OK");
                    id++;

                    resultOrderList.add(orderDetail);
                }
            }
            System.out.println(resultOrderList.toJSONString());

        } catch (Exception ex) {

            JSONObject orderDetail = new JSONObject();
            orderDetail.put("Error", ex.getMessage());
            System.out.println(orderDetail.toJSONString());
        }
    }

}
