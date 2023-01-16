package mall.domain;

import mall.domain.*;
import mall.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class DeliveryCanceled extends AbstractEvent {

    private Long id;

    public DeliveryCanceled(Delivery aggregate){
        super(aggregate);
    }
    public DeliveryCanceled(){
        super();
    }
}
