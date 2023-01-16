package mall.domain;

import mall.domain.StockDecreased;
import mall.domain.StockIncreased;
import mall.StockApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Stock_table")
@Data

public class Stock  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;

    @PostPersist
    public void onPostPersist(){


        StockDecreased stockDecreased = new StockDecreased(this);
        stockDecreased.publishAfterCommit();



        StockIncreased stockIncreased = new StockIncreased(this);
        stockIncreased.publishAfterCommit();

    }

    public static StockRepository repository(){
        StockRepository stockRepository = StockApplication.applicationContext.getBean(StockRepository.class);
        return stockRepository;
    }




    public static void stockDecrease(OrderPlaced orderPlaced){

        /** Example 1:  new item 
        Stock stock = new Stock();
        repository().save(stock);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(stock->{
            
            stock // do something
            repository().save(stock);


         });
        */

        
    }
    public static void stockIncrease(OrderCanceled orderCanceled){

        /** Example 1:  new item 
        Stock stock = new Stock();
        repository().save(stock);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(stock->{
            
            stock // do something
            repository().save(stock);


         });
        */

        
    }


}
