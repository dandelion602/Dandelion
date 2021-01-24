package com.dandelion.backend.controller;

import com.dandelion.backend.entity.Locker;
import com.dandelion.backend.service.LockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class LockerController {

    @Autowired
    LockerService lockerService;

    @RequestMapping(value = "/setBoardNumber/{board_number}")
    public Locker setBoardNumber(@PathVariable int board_number) {
        Locker unsedLocker = lockerService.bringUnusedLocker();
        unsedLocker.setBoardNumber(board_number);
        return lockerService.save(unsedLocker);
    }
}
