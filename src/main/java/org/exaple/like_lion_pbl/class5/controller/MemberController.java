package org.exaple.like_lion_pbl.class5.controller;

import org.exaple.like_lion_pbl.class5.dto.*;
import org.exaple.like_lion_pbl.class5.package2.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/memebers")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
    @PostMapping("/lions")
    public ResponseEntity<LionResponse> createLion(@RequestBody LionCreateRequest request){
        LionResponse response = memberService.createLion(request);
        if(response == null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); //409
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(response); //201
    }
    @PostMapping("/Staffs")
    public ResponseEntity<StaffResponse> createStaff(@RequestBody StaffCreateRequest request){
        StaffResponse response = memberService.createStaff(request);
        if(response == null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); //409
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(response); //201
    }
    @GetMapping("/{name}")
    public ResponseEntity<Object> getMember(@PathVariable String name){
        Object response = memberService.findMemberByName(name);
        if(response == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); //404
        }
        return ResponseEntity.ok(response); //200
    }
    @PutMapping("/lions/{name}")
    public ResponseEntity<LionResponse> updateLion(@PathVariable String name, @RequestBody LionUpdateRequest request){
        LionResponse response = memberService.updateLion(name,request);
        if(response == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); //404
        }
        return ResponseEntity.ok(response);
    }
    @PutMapping("/Staffs/{name}")
    public ResponseEntity<StaffResponse> updateStaff(@PathVariable String name, @RequestBody StaffUpdateRequest request){
        StaffResponse response = memberService.updateStaff(name,request);
        if(response == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); //404
        }
        return ResponseEntity.ok(response); //200
    }
    @DeleteMapping("/members/{name}")
    public ResponseEntity<Void> deleteMember(@PathVariable String name){
        boolean deleted = memberService.deleteMemeber(name);
        if(!deleted){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); //404
        }
        return ResponseEntity.noContent().build(); //204
    }
}
