###  Update  2026 05/18 

# 🦁 멋쟁이사자처럼 Java 과제 모음

Java 기초부터 객체지향, 컬렉션까지 주차별로 학습한 내용을 정리한 저장소입니다.

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

## 기술 스택

- Language: `Java`
- IDE: `IntelliJ IDEA`
- Build Tool: `Gradle`