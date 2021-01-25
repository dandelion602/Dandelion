package com.dandelion.backend.controller;

import com.dandelion.backend.entity.Board;
import com.dandelion.backend.entity.Deal;
import com.dandelion.backend.entity.Locker;
import com.dandelion.backend.entity.member.Member;
import com.dandelion.backend.entity.member.MyMemberDetails;
import com.dandelion.backend.repository.MemberRepository;
import com.dandelion.backend.service.BoardService;
import com.dandelion.backend.service.DealService;
import com.dandelion.backend.service.LockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
public class DealController {

    @Autowired
    DealService dealService;

    @Autowired
    BoardService boardService;

    @Autowired
    LockerService lockerService;

    @Autowired
    MemberRepository memberRepository;


    //deal 데이터 생성
    @RequestMapping(value = "/buy/{board_number}", method = RequestMethod.POST)
    public boolean save(@PathVariable int board_number, @AuthenticationPrincipal MyMemberDetails myMemberDetails) {
        Deal deal = new Deal();
        Board board = boardService.getOne(board_number); //구매할 물건의 게시판 정보를 가져옴
        Member buyer = memberRepository.getOne(myMemberDetails.getNumber()); // 인터셉터로 member값을 가져와 적용
        Locker locker = lockerService.bringUnusedLocker(); // is_use = 0 인 locker를 찾아 1개의 locker의 정보를 가져옴

        locker.setBoardNumber(board); // locker 에 board 연결 (board_number 값을 넣음)
        locker.setIsUse(1); // locker is_use 값을 1로 변경 (locker 사용중으로 변경)

        board.setStatus(1); // board status 값을 1로 변경 (물품 등록 대기중으로 변경)

        deal.setBoardNumber(board);
        deal.setSellerNumber(board.getMemberNumber());
        deal.setBuyerNumber(buyer.getNumber());
//        deal.setBirdNumber(1); // 멤버넘버 1 은 널값과 동일하다.
        deal.setLockerNumber(locker.getNumber());
        deal.setIsPickup(0); // 처음엔 무조건 픽업으로 진행 IsPickup = 0 (추후에 버드 신청 가능)
        deal.setTempStatus(1); // status 1(물건등록 대기중)

        // 구매자의 잔액확인
        if (buyer.getPoint() > board.getPrice()) {
            buyer.setPoint(buyer.getPoint() - board.getPrice());
            memberRepository.save(buyer);
            lockerService.save(locker);
            boardService.save(board);
            dealService.save(deal);
            return true;
        } else {
            return false;
        }

//        {
//            "board_number": url 로 받은 보드넘버,
//            "seller_number": 보드넘버로 부터 판매자 정보 가져오기,
//            "buyer_number": 토큰값에서 판매자 정보 추출하기,
//            "bird_number": null (1 멤버가 null 멤버),
//            "locker_number": 비사용중인 라커에서 하나 가져오기 (1 -10) //비사용중인 라커 찾는 로직 필요
//            "create_date": new date(); entity 에서 기본값 들어가게 설정해둠...
//            "receiving_date": null
//            "shipping_date": null
//            "delivery_date": null
//            "is_pickup": 0 // null 처음에는 무조건 0 이후에 픽업을 신청하게 되면 1로 변경
//            "temp_status":  = 1 (물건 등록 대기중)
//        }

    }

    //내가 구매한 구매목록 찾기
    @RequestMapping(value = "/findMyBuy", method = RequestMethod.GET)
    public List<Deal> findMyBuy(@AuthenticationPrincipal MyMemberDetails myMemberDetails) {
        return dealService.findMyBuy(myMemberDetails.getNumber());
    }

    //판매자가 "등록완료버튼"을 클릭하면 receiving_date 값 변경
    @RequestMapping(value = "/receivingFinish/{board_number}", method = RequestMethod.GET)
    public Deal receivingFinish (@PathVariable int board_number) {
        return dealService.receivingFinish(board_number);
    }

    @GetMapping(value = "order-history/sell")
    public List<Deal> sell(@AuthenticationPrincipal MyMemberDetails myMemberDetails){
        Member member = myMemberDetails.getMember();
        return dealService.findBySeller(member.getNumber());
    }

    @GetMapping(value = "order-history/buy")
    public List<Deal> buy(@AuthenticationPrincipal MyMemberDetails myMemberDetails){
        Member member = myMemberDetails.getMember();

        return dealService.findByBuyer(member.getNumber());
    }
}
