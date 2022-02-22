# sproutt2-ladder
사다리 게임 구현을 위한 저장소

## 요구사항 명세

* 참여할 사람 이름을 입력받기
    * 사람 이름은 쉼표로 구분하기
    * 사람의 이름은 최대 5글자까지 부여할 수 있다.
    * 사람의 이름은 최소 한글자 이상이어야 한다.
    * 이름 앞 뒤 공백을 제거한다.
* 실행 결과 입력받기
    * 실행 결과는 쉼표로 구분하기
    * 실행 결과는 최소 한글자 이상어어야 한다.
    * 실행 결과 앞 뒤 공백을 제거한다.
* 최대 사다리 높이 입력 받기
    * 최대 사다리 높이는 숫자 입력이어야 한다.
* 사다리 결과 문구 출력하기
* 참여한 사람 이름 출력하기
  * 5자 기준으로 간격을 둔다.
* 사다리 높이와 간격을 함께 출력한다.
* 실행 결과 출력하기
  * 5자 기준으로 간격을 둔다.
* 결과를 보고 싶은 사람은? 입력받기
  * 결과를 보고 싶은 사람은 참여한 사람 목록 중 존재해야 한다.
  * all로 입력이 들어올 경우 모든 참여자 실행 결과 출력하기
* 결과를 보고 싶은 사람의 실행 결과 출력하기

### 도메인
* Participant(참여자)
  * Name(이름)
  * GameResult(실행 결과)
* Participants (일급 컬렉션)
  * List<Participant> participants;
  * 실행 결과를 참여자에 대입해준다.
  * 모든 참여자의 실행 결과 리스트를 반환해준다.
* Name (이름)
  * String name;
  * 검증
* GameResult(실행 결과)
  * GameResultName name;
* GameResultName(실행 결과 이름) 
  * String name;
  * 검증
* Point
  * boolean left;
  * boolean right;
  * 첫 번째 Point의 left 상태값은 false, 마지막 Point의 right 상태값은 false
  * 이전 포인트의 right 값과 현재 포인트의 left 값은 일치
    * 이전 포인트의 right 값이 false일 경우 현재 포인트의 right 값은 true or false
    * 이전 포인트의 right 값이 true일 경우 현재 포인트의 right 값은 false
* Line
  * List<Point> points;
* Ladder
  * List<Line> lines;
  
### 사다리 만들기
* 사다리 라인이 생길 수 있는 조건은?
  * 두 라인이 연속되어 존재할 수 없다.
  * 두 사다리 사이의 라인이 존재하지 않을 수 있다.
  
### 추후 할일
* 예외사항 커스텀하기
* 테스트할 수 없는 코드는 Boundary Layer로 옮기기

    
## 설계 중 고민
* 실세계에서 중복된 이름이 존재할거라고 생각된다. 그래서 중복된 이름을 받을 수 있다.

generateSingleLine 메서드 리팩토링 하기 -> Point의 양 옆 연결다리가 false인 메서드를 추가해 
generateSingleLine
generateMultiLine 메서드 네임 바꾸기 Points 들을 생성하다는 의미로