package com.ashwin.kafka.fintech.resource;

import com.ashwin.kafka.fintech.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
@RestController
@RequestMapping("kafka")
public class UserResource {


    @Autowired
    private KafkaTemplate<String, Transaction> kafkaTemplate;

    public static String getRandomElement(List<Integer> list)
    {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size())).toString();
    }


    public static double getRandomMulti(List<Integer> list)
    {
        Random rand = new Random();
        double value=(list.get(rand.nextInt(list.size()))*10000.5);
        return value;
    }

    @GetMapping("/publishFile/{name}")
    public String publishFile(@PathVariable("name") final String name) {
        String topic=name.split(":")[0];
        Integer Value=Integer.valueOf(name.split(":")[1]);
        System.out.println("topic>>"+topic);
        System.out.println("Value>>"+Value);
        String csvFile = "bank_data.csv";

//        String csvFile = "D:\\Work\\Docker\\pythonKafka\\spring\\src\\main\\resources\\bank_data.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        int i=1;
        try {

            br = new BufferedReader(new FileReader(csvFile));
            br.readLine();
            while ((i<=Value) && ((line = br.readLine()) != null)) {

                String[] columns = line.split(cvsSplitBy);
                kafkaTemplate.send(topic,columns[0],  new Transaction("", columns[0], "test", "",Integer.valueOf(columns[5])));
                System.out.println("AC>>"+columns[0]);
                i++;
            }

        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "Published successfully "+Value+" msgs" ;
    }



    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name) {
        String topic=name.split(":")[0];
        Integer Value=Integer.valueOf(name.split(":")[1]);
        System.out.println("topic>>"+topic);
        System.out.println("Value>>"+Value);
        List<Integer> rangeAccountNumber = IntStream.range(1000, 1020).boxed().collect(Collectors.toList());
        List<Integer> rangeAmount = IntStream.range(1, 10).boxed().collect(Collectors.toList());

        int i=1;
        while(i<=Value) {
            UUID uniqueKey = UUID.randomUUID();
            String accountNum=getRandomElement(rangeAccountNumber);
            kafkaTemplate.send(topic,accountNum,  new Transaction(uniqueKey.toString(), accountNum, "test", "", getRandomMulti(rangeAmount)));
            System.out.println("AC>>"+accountNum);
        i++;
        }

        return "Published successfully "+Value+" msgs" ;
    }
}
