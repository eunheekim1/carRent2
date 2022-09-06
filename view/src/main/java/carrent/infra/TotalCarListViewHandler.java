package carrent.infra;

import carrent.config.kafka.KafkaProcessor;
import carrent.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class TotalCarListViewHandler {

    @Autowired
    private TotalCarListRepository totalCarListRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReserved_then_CREATE_1(@Payload Reserved reserved) {
        try {
            if (!reserved.validate()) return;

            // view 객체 생성
            TotalCarList totalCarList = new TotalCarList();
            // view 객체에 이벤트의 Value 를 set 함
            totalCarList.setId(reserved.getRentId());
            // view 레파지 토리에 save
            totalCarListRepository.save(totalCarList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRegistered_then_UPDATE_1(@Payload Registered registered) {
        try {
            if (!registered.validate()) return;
            // view 객체 조회
            Optional<TotalCarList> totalCarListOptional = totalCarListRepository.findById(
                registered.getCarId()
            );

            if (totalCarListOptional.isPresent()) {
                TotalCarList totalCarList = totalCarListOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                totalCarList.setCarMgmtStatus("신규등록됨");
                // view 레파지 토리에 save
                totalCarListRepository.save(totalCarList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReserveCancelled_then_UPDATE_2(
        @Payload ReserveCancelled reserveCancelled
    ) {
        try {
            if (!reserveCancelled.validate()) return;
            // view 객체 조회
            Optional<TotalCarList> totalCarListOptional = totalCarListRepository.findById(
                reserveCancelled.getRentId()
            );

            if (totalCarListOptional.isPresent()) {
                TotalCarList totalCarList = totalCarListOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                totalCarList.setCarRentStatus("배송취소됨");
                // view 레파지 토리에 save
                totalCarListRepository.save(totalCarList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReserveCancelled_then_DELETE_1(
        @Payload ReserveCancelled reserveCancelled
    ) {
        try {
            if (!reserveCancelled.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            totalCarListRepository.deleteById(reserveCancelled.getRentId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // keep

}
