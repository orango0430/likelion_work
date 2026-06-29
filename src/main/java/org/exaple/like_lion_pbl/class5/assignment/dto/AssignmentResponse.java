package org.exaple.like_lion_pbl.class5.assignment.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.exaple.like_lion_pbl.class5.assignment.domain.Assignment;

@Getter
@AllArgsConstructor
public class AssignmentResponse {
    private Long id;
    private String title;
    private String description;
    private Long memberId;
    private String memberName;

    public static AssignmentResponse from(Assignment assignment){
        return new AssignmentResponse(
                assignment.getId(),
                assignment.getTitle(),
                assignment.getDescription(),
                assignment.getMember().getId(),
                assignment.getMember().getName()
        );

    }

}
