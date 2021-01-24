package com.dandelion.backend.controller;


import com.dandelion.backend.entity.Board;
import com.dandelion.backend.entity.member.MyMemberDetails;
import com.dandelion.backend.repository.ImageRepository;
import com.dandelion.backend.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@CrossOrigin(origins = "*")
@RestController
public class BoardController {

    @Autowired
    BoardService boardService;

    @Autowired
    ImageRepository imageRepository;

    @RequestMapping(value = "/addBoard", method = RequestMethod.POST)
    public Board save(@RequestBody Board board) {
        return boardService.save(board);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Stream<Board> boardList(@AuthenticationPrincipal MyMemberDetails myMemberDetails) {
        return boardService.findAll().stream()
                .sorted(Comparator.comparing(Board::getNumber).reversed());
    }

    @RequestMapping(value = "/findBoardId/{id}", method = RequestMethod.GET)
    public Optional<Board> findId(@PathVariable int id) {
        return boardService.findById(id);
    }

    @RequestMapping(value = "/modifyBoard/{id}", method = RequestMethod.POST)
    public Board modifyBoard(@PathVariable int id, @RequestBody Board newBoard) {
        return boardService.modifyBoard(id, newBoard);
    }

    @RequestMapping(value = "/board/{partOfTitle}", method = RequestMethod.GET)
    public List<Board> searchWithTitle(@PathVariable String partOfTitle) {
        return boardService.searchWithTitle(partOfTitle);
    }
}
