# sproutt2-ladder
사다리 게임 구현을 위한 저장소

## 요구사항 명세

-[x] 참여할 사람 이름을 입력받기
  -[x] 사람 이름은 쉼표로 구분하기
  -[x] 사람의 이름은 최대 5글자까지 부여할 수 있다.
  -[x] 사람의 이름은 최소 한글자 이상이어야 한다. 
  -[x] 이름 앞 뒤 공백을 제거한다.
-[x] 실행 결과 입력받기
  -[x] 실행 결과는 쉼표로 구분하기
  -[x] 실행 결과는 최소 한글자 이상어어야 한다. 
  -[x] 실행 결과 앞 뒤 공백을 제거한다.
-[x] 최대 사다리 높이 입력 받기
  -[x] 최대 사다리 높이는 숫자 입력이어야 한다.
-[x] 사다리 결과 문구 출력하기
-[x] 참여한 사람 이름 출력하기
  -[x] 5자 기준으로 간격을 둔다.
-[x] 사다리 높이와 간격을 함께 출력한다.
-[x] 실행 결과 출력하기
  -[x] 5자 기준으로 간격을 둔다.
-[x] 결과를 보고 싶은 사람은? 입력받기
  -[x] 결과를 보고 싶은 사람은 참여한 사람 목록 중 존재해야 한다. 
  -[x] all로 입력이 들어올 경우 모든 참여자 실행 결과 출력하기
-[x] 결과를 보고 싶은 사람의 실행 결과 출력하기

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

## 테스트 목록
Point.class
-[x] 포인트가 오직 하나 존재할 경우를 포인트의 양쪽 연결 다리의 존재 여부는 거짓을 반환한다.
-[x] 포인트가 하나 이상일 경우 첫 번째 포인트의 왼쪽 연결 다리는 거짓을 반환한다.
-[x] 이전 포인트의 오른쪽 연결 다리가 존재하면 현재 포인트의 오른쪽 연결 다리는 거짓을 반환한다.
-[x] 이전 포인트의 오른쪽 연결 다리가 존재하지 않으면 현재 포인트의 왼쪽 연결 다리는 거짓을 반환한다.
-[x] 마지막 포인트의 오른쪽 연결 다리는 존재하지 않는다.
-[x] 한 포인트의 왼쪽과 오른쪽 연결 다리가 존재하면 예외를 처리한다.
  
Line.class
-[x] 한 포인트의 왼쪽 연결 다리가 존재하고 오른쪽 연결 다리가 존재하지 않을 경우 방향을 왼쪽으로 반환한다.
-[x] 한 포인트의 오른쪽 연결 다리가 존재하고 왼쪽 연결 다리가 존재하지 않을 경우 방향을 오른쪽으로 반환한다.
-[x] 한 포인트의 양쪽 다리가 모두 존재하지 않을 경우 방향을 아래로 반환한다.

Position.class
-[x] 위치를 왼쪽으로 이동할 때 포인트의 x 좌표가 왼쪽으로 이동하는지 테스트한다.
-[x] 위치를 오른쪽으로 이동할 때 포인트의 x 좌표가 오른쪽으로 이동하는지 테스트한다.
-[x] 위치를 아래쪽으로 이동할 때 포인트의 y 좌표가 아래로 이동하는지 테스트한다.
-[x] x 좌표 또는 y 좌표가 음수일 때 예외를 처리한다.

Player.class
-[x] 포인트의 방향이 왼쪽일 때 플레이어의 위치를 x좌표는 -1만큼 y좌표는 +1만큼 이동한다.
-[x] 포인트의 방향이 오른쪽일 때 플레이어의 위치를 x좌표는 +1만큼 y좌표는 +1만큼 이동한다.
-[x] 포인트의 방향이 아래일 때 플레이어의 위치를 y좌표는 +1만큼 이동한다.

Players.class
-[x] 결과를 보고 싶은 사람이 참여한 사람들에 포함되어 있다면 true를 반환한다.
-[x] 결과를 보고 싶은 사람이 참여한 사람들에 포함되어 있지 않다면 false를 반환한다.

PlayersFactory.class
-[x] 참여한 사람들의 수만큼 Player 객체를 생성한다.

Name.class
-[x] 이름이 없을 경우 예외를 처리한다.
-[x] 이름의 길이가 5글자를 초과할 경우 예외를 처리한다.

Height.class
-[x] 사다리의 높이가 음수일 경우 예외를 처리한다.

GameResultName.class
-[x] 이름이 없을 경우 예외를 처리한다.

GameResultFactory.class
-[x] 참여한 사람들의 수만큼 실행 결과 객체를 생성한다.