package com.dandelion.backend.repository;

import com.dandelion.backend.entity.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DealRepository extends JpaRepository<Deal, Integer> {

    @Query(value = "SELECT * FROM deal d where d.buyer_number = :number", nativeQuery = true)
    List<Deal> findMyBuy(@Param("number") int number);

    @Query(value = "SELECT * from deal d where d.board_number = :number", nativeQuery = true)
    Deal serchByBoardNumber (@Param("number")int number);

    List<Deal> findBysellerNumber(int sellerNumber);

    List<Deal> findBybuyerNumber(int buyerNumber);

    @Query(value = "select \n" +
            "b.number as board_number,\n" +
            "m.name as member_name,\n" +
            "d.seller_number as seller_number,\n" +
            "(select m1.name from deal d1 join member m1 on m1.number = d1.seller_number where d1.buyer_number = :buyerNumber) as seller_name,\n" +
            "d.bird_number as bird_number,\n" +
            "l2.name as loc_locker_name,\n" +
            "d.create_date as create_date,\n" +
            "d.receiving_date as receiving_date,\n" +
            "d.delivery_date as delivery_date,\n" +
            "d.is_pickup as is_pickup,\n" +
            "d.temp_status as temp_status \n" +
            "d.buyer_number as buyer_number \n" +
            "from deal d\n" +
            "join member m\n" +
            "join locker l1\n" +
            "join locker_location l2\n" +
            "join board b\n" +
            "on d.buyer_number = m.number\n" +
            "and l1.number = d.locker_number \n" +
            "and l1.loc_number  = l2.loc_number\n" +
            "and d.board_number = b.number \n" +
            "where d.buyer_number = :buyerNumber", nativeQuery = true)
    List<Deal> findByBuyerNumber2(@Param("buyerNumber") int buyerNumber);
}
