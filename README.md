###  Update  2026 06/30

# 🦁 멋쟁이사자처럼 Java 과제 모음

Java 기초부터 객체지향, 컬렉션, Spring boot 전환까지 주차별로 학습한 내용을 정리한 저장소입니다.

---

## 1주차 - 콘솔 입출력 & 배열

> 콘솔로 만드는 아기사자 명단 관리 프로그램

### 학습 내용
- `Scanner`를 이용한 콘솔 입력 처리
- 배열을 활용한 여러 데이터 저장
- `for`문과 조건문으로 입력 → 처리 → 출력 흐름 구현

### 구현 기능
- 아기사자 수를 입력받고, 그 수만큼 이름을 입력받아 배열에 저장
- 5명 미만 입력 시 에러 출력, 5명 이상이면 명단 출력

### 핵심 코드
```java
int baby_lions = sc.nextInt();
if (baby_lions >= 5) {
    String[] names = new String[baby_lions];
    for (int i = 0; i < names.length; i++) {
        names[i] = sc.next();
    }
    for (int j = 0; j < names.length; j++) {
        System.out.println("아기사자 번호 : " + (j+1) + " 이름 명단 : " + names[j]);
    }
}
```

---

## 2주차 - 클래스 설계 & 캡슐화

> 아기사자 정보를 하나의 객체로 설계하며 클래스의 역할과 책임, 캡슐화를 직접 경험

### 학습 내용
- 클래스와 객체의 개념 이해
- 생성자에서 유효성 검증 로직 구현
- 접근 제어자(`public`, `private`)로 캡슐화
- `IllegalArgumentException`을 이용한 예외 처리
- 패키지 간 클래스 접근 (`import`)

### 구현 단계
| 단계 | 파일 | 내용 |
|------|------|------|
| Step 1 | `package1/step1.java` | main에서 유효성 검증 후 Lion 객체 생성 |
| Step 2 | `package1/step2.java` | public 필드 직접 수정 가능 확인 |
| Step 3 | `package2/step3.java` | 다른 패키지에서 import 후 Lion 객체 사용 |

### 핵심 코드
```java
// 생성자에서 유효성 검증
public Lion(String name, String major, int generation) {
    if (name.isEmpty()) throw new IllegalArgumentException("이름은 비어 있을 수 없습니다.");
    if (generation < 1) throw new IllegalArgumentException("기수는 1보다 작을 수 없습니다.");
}

// 예외 처리
try {
    Lion lion = new Lion(name, major, generation);
} catch (IllegalArgumentException e) {
    System.out.println("Error: " + e.getMessage());
}
```

---

## 3주차 - 상속 & 추상화 & 다형성

> 역할을 묻는 조건문 대신, 역할을 가진 객체에게 판단을 맡기는 다형성 구조 설계

### 학습 내용
- 추상 클래스(`abstract`)로 공통 속성과 메서드 정의
- 인터페이스(`interface`)로 역할별 동작 추상화
- 상속(`extends`)과 구현(`implements`)
- 다형성 — 부모 타입으로 자식 객체 다루기

### 클래스 구조
```
role (추상 클래스)
├── Lion (아기사자) — implements Submit_assignment → cansubmit() = true
└── Staff (운영진)  — implements Submit_assignment → cansubmit() = false

Submit_assignment (인터페이스)
└── boolean cansubmit()
```

### 핵심 코드
```java
// 다형성 활용 — role 타입으로 Lion, Staff 모두 처리
role lion = new Lion(name, major, generation, part, student_id);
role staff = new Staff(name, major, generation, part, position);

System.out.println(lion.getrole());   // 각 객체에 맞는 메서드 호출
System.out.println(staff.getrole());
```

---

## 4주차 - 컬렉션 (List & Map)

> Java 컬렉션(List, Map)을 활용해 여러 멤버를 등록, 검색, 그룹화하는 관리 시스템 구현

### 학습 내용
- `List<role>`로 동적 크기 멤버 목록 관리
- `Map<String, List<role>>`으로 파트별 멤버 그룹화
- 제네릭(`Generic`)으로 타입 안전성 확보
- `computeIfAbsent`로 Map에 리스트 동적 추가
- `instanceof`로 런타임 타입 확인

### 구현 기능
| 메뉴 | 기능 |
|------|------|
| 1. 멤버 등록 | 중복 확인 후 아기사자/운영진 등록, List와 Map에 동시 저장 |
| 2. 전체 멤버 조회 | 전체 멤버 목록 및 총 인원 출력 |
| 3. 이름으로 검색 | 이름 입력 후 해당 멤버 상세 정보 출력 |
| 4. 파트별 조회 | 등록된 파트 목록 출력 후 파트별 멤버 조회 |
| 5. 종료 | 프로그램 종료 |

### 핵심 코드
```java
// List와 Map에 동시 저장
Lion newLion = new Lion(name, major, generation, part, student_id);
roles.add(newLion);
part_check.computeIfAbsent(part, key -> new ArrayList<>()).add(newLion);

// 파트별 조회
for (role r : part_check.get(searchPart)) {
    String roleType = (r instanceof Lion) ? "아기사자" : "운영진";
    System.out.println(r.name + " (" + roleType + ") - " + r.generation + "기");
}
```

---

## 5주차 - 레이어 분리 & 의존성 주입 (DI/IoC)

> Service가 Repository를 직접 생성하지 않도록 리팩토링하여, 의존성 주입(DI)과 제어의 역전(IoC)의 필요성을 구조적으로 이해

### 학습 내용
- Repository, Service, Main 세 개의 레이어로 책임 분리
- 인터페이스로 Repository 추상화
- 생성자를 통한 의존성 주입(DI)
- `final` 키워드로 불변 필드 설정
- Memory/Mock 두 개의 구현체 교체 체험

### 클래스 구조
```
MemberRepository (인터페이스)
├── MemoryMemberRepository — 실제 데이터 저장/조회
└── MockMemberRepository   — 더미 데이터 반환, 실제 저장 안 함

MemberService — Repository 인터페이스에 의존, 생성자로 주입받음
Main          — Repository 구현체 선택 후 Service에 주입
```

### Step 1 vs Step 2 비교
| 항목 | Step 1 (직접 생성) | Step 2 (생성자 주입) |
|------|------|------|
| 객체 생성 위치 | Service 내부 | Main (외부) |
| 의존 대상 | 클래스 (구현체) | 인터페이스 |
| 구현체 교체 시 | Service 코드 수정 필요 | Main만 수정 |
| 결합도 | 강함 | 느슨함 |

### 핵심 코드
```java
// MemberRepository 인터페이스
public interface MemberRepository {
    void save(role member);
    List<role> findAll();
    role findByName(String name);
    boolean existsByName(String name);
}

// 생성자 DI - Service가 Repository를 직접 생성하지 않음
public class MemberService {
    private final MemberRepository repository;  // final로 불변 설정

    public MemberService(MemberRepository repository) {
        this.repository = repository;  // 외부에서 주입
    }
}

// Main에서 구현체 선택 후 주입
MemberRepository repository;
if (choice == 1) {
    repository = new MemoryMemberRepository();
} else {
    repository = new MockMemberRepository();  // Service 코드 수정 없이 교체!
}
MemberService service = new MemberService(repository);
```

---

## 6주차 - Spring Bean & IoC / DI / REST Controller

> 5주차에서 직접 new로 조립했던 코드를 스프링 컨테이너가 관리하도록 전환하고, 첫 번째 REST API 엔드포인트 구현

### 학습 내용
- `@Configuration` + `@Bean`으로 스프링 컨테이너에 빈 등록
- `ApplicationContext`(스프링 컨테이너) 개념과 빈 관리 방식 이해
- 수동 주입(`@Bean`)과 자동 주입(`@Service`, `@Repository`, `@Component`) 차이
- 생성자 주입 방식과 `@Autowired`의 역할
- 생성자가 1개일 때 `@Autowired` 생략 가능한 이유
- `@RestController` + `@GetMapping`으로 HTTP 요청 처리

### 클래스 구조
```
AppConfig (@Configuration)
├── memberRepository() @Bean → MemoryMemberRepository 등록
└── memberService()    @Bean → MemberService 등록 + MemberRepository 주입

HelloController (@RestController)
└── GET /hello → "Hello, Likelion!" 반환
```

### 5주차 vs 6주차 비교

| 구분 | 5주차 (직접 조립) | 6주차 (Spring Bean) |
|------|------|------|
| 객체 생성 | 개발자 (new) | 개발자 (new) |
| 객체 관리 | 없음 (지역변수) | 스프링 컨테이너 |
| 싱글톤 보장 | ❌ | ✅ 자동 |
| 어디서든 사용 | ❌ Main에서만 | ✅ getBean()으로 |
| 생명주기 관리 | ❌ | ✅ init/destroy |

### 핵심 코드

```java
// AppConfig — 수동 빈 등록
@Configuration
public class AppConfig {
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository()); // DI 주입
    }
}

// 스프링 컨테이너에서 빈 꺼내기
ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
MemberService service = context.getBean(MemberService.class);

// HelloController — 첫 번째 REST API
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello, Likelion!";
    }
}
```

### 핵심 개념 요약

| 어노테이션 | 역할 |
|------|------|
| `@Configuration` | 이 클래스가 빈 설정 클래스임을 선언, CGLIB 프록시로 싱글톤 보장 |
| `@Bean` | 메서드 반환값을 스프링 컨테이너에 빈으로 등록 |
| `@Autowired` | 컨테이너에서 타입에 맞는 빈을 찾아 자동 주입 |
| `@RestController` | HTTP 요청을 처리하는 컨트롤러, 반환값을 JSON/문자열로 응답 |
| `@GetMapping` | GET 방식의 특정 경로 요청을 메서드에 매핑 |

> 💡 IoC(제어의 역전): 객체 제어권이 개발자 → 스프링 컨테이너로 이전  
> 💡 생성자 1개일 때 `@Autowired` 생략 가능 (Spring 4.3+)

---

## 7주차 - REST API / DTO / ResponseEntity

> DTO로 요청·응답을 분리하고, HTTP 메서드와 상태코드를 활용한 완전한 CRUD REST API 구현

### 학습 내용
- REST API 설계 원칙 (URI는 명사, 행위는 HTTP 메서드)
- HTTP 메서드별 역할 (GET / POST / PUT / DELETE)
- HTTP 상태코드 의미 (200 / 201 / 204 / 404 / 409)
- `@PathVariable`과 `@RequestBody`의 차이
- DTO(Data Transfer Object) 개념과 필요성
- 역할별 DTO 분리 (Request / Response)
- `ResponseEntity`로 상태코드 제어

### DTO 구조
```
dto/
├── LionCreateRequest   — Lion 생성 요청 (name, major, generation, part, studentId)
├── StaffCreateRequest  — Staff 생성 요청 (name, major, generation, part, position)
├── LionUpdateRequest   — Lion 수정 요청 (name 제외, URL PathVariable로 받음)
├── StaffUpdateRequest  — Staff 수정 요청 (name 제외, URL PathVariable로 받음)
├── LionResponse        — Lion 조회 응답 (roleName 추가)
└── StaffResponse       — Staff 조회 응답 (roleName 추가)
```

### 완성된 API 목록
| 메서드 | 경로 | 기능 | 성공 | 실패 |
|------|------|------|------|------|
| POST | /members/lions | Lion 등록 | 201 | 409 (중복) |
| POST | /members/staffs | Staff 등록 | 201 | 409 (중복) |
| GET | /members/{name} | 단일 조회 | 200 | 404 (없음) |
| PUT | /members/lions/{name} | Lion 수정 | 200 | 404 (없음) |
| PUT | /members/staffs/{name} | Staff 수정 | 200 | 404 (없음) |
| DELETE | /members/{name} | 멤버 삭제 | 204 | 404 (없음) |

### 핵심 개념 요약

| 개념 | 설명 |
|------|------|
| `@PathVariable` | URL 경로에서 값 추출 → `/members/김사자` |
| `@RequestBody` | HTTP Body JSON을 객체로 변환 |
| `ResponseEntity` | 상태코드 + 바디를 함께 반환하는 스프링 클래스 |
| `static from()` | 도메인 객체 → Response DTO 변환 팩토리 메서드 |
| DTO 분리 | Request(입력) / Response(출력) 역할별로 분리 |

> 💡 URI에는 동사 쓰지 말고 명사로 자원만 표현, 행위는 HTTP 메서드가 담당  
> 💡 식별자(누구?)는 PathVariable, 데이터(뭘로?)는 RequestBody

---

## 8주차 - JPA / MySQL 연동 & 단일 엔티티 리팩토링

> 메모리 저장소를 JPA + MySQL 기반으로 교체하고, 상속 구조(Lion/Staff)를 단일 Member 엔티티로 간소화

### 학습 내용
- Spring Boot + MySQL 연동 (`spring-boot-starter-data-jpa`, `mysql-connector-j`)
- `@Entity`, `@Id`, `@GeneratedValue`로 JPA 엔티티 설계
- `@Enumerated(EnumType.STRING)`으로 Enum을 DB에 문자열로 저장
- `JpaRepository` 상속으로 CRUD 메서드 자동 제공
- 메서드 이름 규칙으로 자동 쿼리 생성 (`findByName`, `existsById`)
- `Optional`로 null 안전하게 처리
- 상속 구조(Lion/Staff) → 단일 엔티티(Member + RoleType) 리팩토링
- 응답 DTO 통합 (`LionResponse` + `StaffResponse` → `MemberResponse`)
- 식별자 변경 (`String name` → `Long id`)

### 구조 변화

```
Before (7주차): Role → Lion (studentId)
                     └── Staff (position)

After (8주차):  Member (id, name, major, generation, part, roleType, studentId, position)
                RoleType { LION("아기사자"), STAFF("운영진") }
```

### 핵심 개념 요약

| 개념 | 설명 |
|------|------|
| `@Entity` | 이 클래스가 DB 테이블과 매핑됨을 선언 |
| `@GeneratedValue(IDENTITY)` | DB AUTO_INCREMENT 사용 (id 자동 생성) |
| `@Enumerated(EnumType.STRING)` | Enum을 숫자 대신 문자열로 DB에 저장 |
| `JpaRepository<Member, Long>` | 엔티티 타입, PK 타입 지정 → CRUD 자동 제공 |
| `Optional` | null 대신 안전하게 값 유무 처리 |
| `save()` | id 없으면 INSERT, id 있으면 UPDATE 자동 판단 |
| `ddl-auto=create` | 앱 실행 시 테이블 자동 생성 (개발용) |

> 💡 `JpaRepository` 상속하면 `save()`, `findById()`, `deleteById()`, `existsById()` 등 자동 제공  
> 💡 `save()` 반환값을 사용해야 DB에서 채워진 `id` 값을 쓸 수 있음

---

## 9주차 - 연관관계 & 트랜잭션 (1:N 관계 설계)

> Member와 Assignment 간의 1:N 양방향 관계를 설계하고, @Transactional로 데이터 안정성 확보

### 학습 내용
- `@ManyToOne` / `@OneToMany`로 1:N 양방향 연관관계 설정
- `@JoinColumn`으로 외래키 컬럼 지정
- `mappedBy`로 연관관계 주인 지정
- `@Transactional(readOnly = true)`로 조회 성능 최적화
- `@Transactional`로 데이터 변경 트랜잭션 관리
- Stream API (`stream().map().collect()`)로 List 변환
- 기능별 패키지 분리 (`member/`, `assignment/`)

### 프로젝트 구조
```
src/main/java/
└── org.exaple.like_lion_pbl.class5/
    ├── member/
    │   ├── controller/ — MemberController
    │   ├── service/    — MemberService (@Transactional 추가)
    │   ├── repository/ — MemberRepository
    │   ├── domain/     — Member (@OneToMany 추가), RoleType
    │   └── dto/        — LionCreateRequest, MemberResponse 등
    └── assignment/
        ├── controller/ — AssignmentController
        ├── service/    — AssignmentService (@Transactional 적용)
        ├── repository/ — AssignmentRepository
        ├── domain/     — Assignment (@ManyToOne 엔티티)
        └── dto/        — AssignmentCreateRequest, AssignmentResponse 등
```

### 연관관계 구조
```
Member (1) ←→ Assignment (N)

Member.java
└── @OneToMany(mappedBy = "member")
    List<Assignment> assignments  ← 읽기 전용 (mappedBy)

Assignment.java
└── @ManyToOne
    @JoinColumn(name = "member_id")
    Member member  ← 연관관계 주인 (외래키 관리)
```

### 완성된 API 목록
| 메서드 | 경로 | 기능 | 성공 | 실패 |
|------|------|------|------|------|
| POST | /members/{memberId}/assignments | 과제 등록 | 201 | 404 (멤버 없음) |
| GET | /members/{memberId}/assignments | 멤버별 목록 | 200 | - |
| GET | /assignments/{id} | 과제 단건 조회 | 200 | 404 |
| PUT | /assignments/{id} | 과제 수정 | 200 | 404 |
| DELETE | /assignments/{id} | 과제 삭제 | 204 | 404 |

### 핵심 코드

```java
// Assignment 엔티티 - 연관관계 주인
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "member_id")  // assignment 테이블에 member_id 컬럼 생성
    private Member member;
}

// Member 엔티티 - 양방향 관계 추가
@OneToMany(mappedBy = "member")           // 읽기 전용, DB 컬럼 추가 없음
private List<Assignment> assignments = new ArrayList<>();

// AssignmentService - @Transactional 패턴
@Service
@Transactional(readOnly = true)  // 클래스 레벨: 조회 메서드 기본 적용
public class AssignmentService {

    @Transactional  // 메서드 레벨: 데이터 변경 시 오버라이드
    public AssignmentResponse create(Long memberId, AssignmentCreateRequest request) {
        Member member = memberRepository.findById(memberId).orElse(null);
        if (member == null) return null;
        Assignment assignment = new Assignment(request.getTitle(), request.getDescription(), member);
        return AssignmentResponse.from(assignmentRepository.save(assignment));
    }

    public List<AssignmentResponse> findByMemberId(Long memberId) {
        return assignmentRepository.findByMemberId(memberId)
                .stream()
                .map(AssignmentResponse::from)
                .collect(Collectors.toList());
    }
}

// AssignmentResponse - from() 에서 연관 엔티티 접근
public static AssignmentResponse from(Assignment assignment) {
    return new AssignmentResponse(
        assignment.getId(),
        assignment.getTitle(),
        assignment.getDescription(),
        assignment.getMember().getId(),    // 연관된 Member의 id
        assignment.getMember().getName()   // 연관된 Member의 name
    );
}
```

### 핵심 개념 요약

| 개념 | 설명 |
|------|------|
| `@ManyToOne` | N:1 관계 선언, 연관관계 주인 (외래키 보유) |
| `@OneToMany(mappedBy)` | 1:N 관계 선언, 읽기 전용 (DB 컬럼 추가 없음) |
| `@JoinColumn(name)` | 외래키 컬럼명 지정 |
| `mappedBy = "member"` | Assignment의 member 필드가 관계를 관리함을 선언 |
| `@Transactional(readOnly=true)` | 조회 전용 트랜잭션, 성능 최적화 |
| `@Transactional` | 데이터 변경 트랜잭션, 실패 시 롤백 보장 |
| `stream().map().collect()` | List<Entity> → List<DTO> 변환 |

> 💡 연관관계 주인 = 외래키를 가진 쪽(N쪽), `@ManyToOne` 붙은 곳  
> 💡 `mappedBy` 붙은 쪽은 읽기 전용, DB에 컬럼이 추가되지 않음  
> 💡 `@Transactional(readOnly=true)` 클래스 레벨 + `@Transactional` 메서드 레벨 조합이 일반적인 패턴