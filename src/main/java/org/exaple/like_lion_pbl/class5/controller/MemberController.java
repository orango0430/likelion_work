package org.exaple.like_lion_pbl.class5.controller;

import org.exaple.like_lion_pbl.class5.dto.*;
import org.exaple.like_lion_pbl.class5.package2.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    public MemberController (MemberService service){
        this.memberService = service;
    }
    @PostMapping("/lions")
    public ResponseEntity<MemberResponse> createLion(@RequestBody LionCreateRequest request) {
        MemberResponse response = memberService.createLion(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response); // 201
    }

    // POST /members/staffs
    @PostMapping("/staffs")
    public ResponseEntity<MemberResponse> createStaff(@RequestBody StaffCreateRequest request) {
        MemberResponse response = memberService.createStaff(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response); // 201
    }

    // GET /members/{id} — name → id로 변경
    @GetMapping("/{id}")
    public ResponseEntity<MemberResponse> getMember(@PathVariable Long id) {
        MemberResponse response = memberService.findById(id);
        if (response == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404
        return ResponseEntity.ok(response); // 200
    }

    // PUT /members/lions/{id} — name → id로 변경
    @PutMapping("/lions/{id}")
    public ResponseEntity<MemberResponse> updateLion(@PathVariable Long id, @RequestBody LionUpdateRequest request) {
        MemberResponse response = memberService.updateLion(id, request);
        if (response == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404
        return ResponseEntity.ok(response); // 200
    }

    // PUT /members/staffs/{id} — name → id로 변경
    @PutMapping("/staffs/{id}")
    public ResponseEntity<MemberResponse> updateStaff(@PathVariable Long id, @RequestBody StaffUpdateRequest request) {
        MemberResponse response = memberService.updateStaff(id, request);
        if (response == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404
        return ResponseEntity.ok(response); // 200
    }

    // DELETE /members/{id} — name → id로 변경
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        boolean deleted = memberService.deleteMember(id);
        if (!deleted) return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404
        return ResponseEntity.noContent().build(); // 204
    }

}
