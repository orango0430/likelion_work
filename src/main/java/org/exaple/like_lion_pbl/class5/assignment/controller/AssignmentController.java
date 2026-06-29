package org.exaple.like_lion_pbl.class5.assignment.controller;

import lombok.RequiredArgsConstructor;
import org.exaple.like_lion_pbl.class5.assignment.dto.AssignmentCreateRequest;
import org.exaple.like_lion_pbl.class5.assignment.dto.AssignmentResponse;
import org.exaple.like_lion_pbl.class5.assignment.dto.AssignmentUpdateRequest;
import org.exaple.like_lion_pbl.class5.assignment.service.AssignmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentService assignmentService;

    // POST /members/{memberId}/assignments - 과제 등록
    @PostMapping("/members/{memberId}/assignments")
    public ResponseEntity<AssignmentResponse> create(
            @PathVariable Long memberId,
            @RequestBody AssignmentCreateRequest request) {
        AssignmentResponse response = assignmentService.create(memberId, request);
        if (response == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404
        return ResponseEntity.status(HttpStatus.CREATED).body(response); // 201
    }

    // GET /members/{memberId}/assignments - 멤버별 과제 목록 조회
    @GetMapping("/members/{memberId}/assignments")
    public ResponseEntity<List<AssignmentResponse>> findByMemberId(
            @PathVariable Long memberId) {
        List<AssignmentResponse> responses = assignmentService.findByMemberId(memberId);
        return ResponseEntity.ok(responses);
    }

    // GET /assignments/{id} - 과제 단건 조회
    @GetMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> findById(@PathVariable Long id) {
        AssignmentResponse response = assignmentService.findById(id);
        if (response == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404
        return ResponseEntity.ok(response); // 200
    }

    // PUT /assignments/{id} - 과제 수정
    @PutMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> update(
            @PathVariable Long id,
            @RequestBody AssignmentUpdateRequest request) {
        AssignmentResponse response = assignmentService.update(id, request);
        if (response == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404
        return ResponseEntity.ok(response); // 200
    }

    // DELETE /assignments/{id} - 과제 삭제
    @DeleteMapping("/assignments/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = assignmentService.delete(id);
        if (!deleted) return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404
        return ResponseEntity.noContent().build(); // 204
    }
}