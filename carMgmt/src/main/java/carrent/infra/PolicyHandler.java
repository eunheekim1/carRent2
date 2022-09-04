package carrent.infra;

import carrent.config.kafka.KafkaProcessor;
import carrent.domain.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    CarMgmtRepository carMgmtRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Reserved'"
    )
    public void wheneverReserved_CarStatusChange(@Payload Reserved reserved) {
        Reserved event = reserved;
        System.out.println(
            "\n\n##### listener CarStatusChange : " + reserved + "\n\n"
        );

        // Sample Logic //
        CarMgmt.carStatusChange(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Rented'"
    )
    public void wheneverRented_CarStatusChange(@Payload Rented rented) {
        Rented event = rented;
        System.out.println(
            "\n\n##### listener CarStatusChange : " + rented + "\n\n"
        );

        // Sample Logic //
        CarMgmt.carStatusChange(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Returned'"
    )
    public void wheneverReturned_CarStatusChange(@Payload Returned returned) {
        Returned event = returned;
        System.out.println(
            "\n\n##### listener CarStatusChange : " + returned + "\n\n"
        );

        // Sample Logic //
        CarMgmt.carStatusChange(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ReserveCancelled'"
    )
    public void wheneverReserveCancelled_CarStatusChange(
        @Payload ReserveCancelled reserveCancelled
    ) {
        ReserveCancelled event = reserveCancelled;
        System.out.println(
            "\n\n##### listener CarStatusChange : " + reserveCancelled + "\n\n"
        );

        // Sample Logic //
        CarMgmt.carStatusChange(event);
    }
    // keep

}
