package mall.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import mall.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import mall.domain.*;

@Service
@Transactional
public class PolicyHandler{
    @Autowired StockRepository stockRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderPlaced'")
    public void wheneverOrderPlaced_StockDecrease(@Payload OrderPlaced orderPlaced){

        OrderPlaced event = orderPlaced;
        System.out.println("\n\n##### listener StockDecrease : " + orderPlaced + "\n\n");


        

        // Sample Logic //
        Stock.stockDecrease(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderCanceled'")
    public void wheneverOrderCanceled_StockIncrease(@Payload OrderCanceled orderCanceled){

        OrderCanceled event = orderCanceled;
        System.out.println("\n\n##### listener StockIncrease : " + orderCanceled + "\n\n");


        

        // Sample Logic //
        Stock.stockIncrease(event);
        

        

    }

}


