package com.dandelion.backend.controller;

import com.dandelion.backend.entity.Board;
import com.dandelion.backend.entity.Image;
import com.dandelion.backend.service.BoardService;
import com.dandelion.backend.service.ImageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



import java.nio.file.Path;


@CrossOrigin(origins = "*")
@RestController
public class ImageController {

    @Autowired
    ImageService imageService;

    @Autowired
    BoardService boardService;


    @PostMapping("/fileupload/")
    public String fileupload(@RequestParam("files") MultipartFile[] multipartFile) {
        int order = 0;

//        Path dir = Paths.get("C:\\javian\\dandelion\\BackEnd_Board\\vue\\dandelion 2\\src\\assets\\images\\");
        Path dir = imageService.getAbsolutePath("../front_end/src/assets/images/");

        Board board = boardService.findLastBoard();

        for (MultipartFile file : multipartFile) {

            imageService.write(file, dir.toAbsolutePath(), board.getNumber() + "_" + (order));
            Image image = new Image();
            // 나중에 이미지서비스에 메서드로 옮기기... 아니면 생성자라도 만드러엇 단순화시키기
            image.setFileName(board.getNumber() + "_" + (order));
            image.setSize( (int) file.getSize());
            image.setImageDir(dir.toString());
            image.setFileOriName(file.getOriginalFilename());
            image.setFormat(imageService.getFormat(file));
            image.setOrderNumber(order);
            image.setBoardNumber(board.getNumber());
            imageService.save(image);

            order++;
        }

        return String.format("file upload successfully");
    }
}
