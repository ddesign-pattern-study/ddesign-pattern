# Command Pattern

요청 내역을 객체로 캡슐화 해서 객체를 서로 다른 요청 내역에 따라 매개변수화.
요청을 큐에 저장하거나 로그로 기록하거나 작업 취소를 구현할 수 있음.

- 어떤 작업을 요청하는 쪽과 그 작업을 처리하는 쪽을 분리할 수 있음
- command object(커맨드 객체) 추가
- command object 는 특정 객체에 관한 특정 작업 요청을 캡슐화 함

### Null object

딱히 리턴할 객체도 없고 클라이언트가 null을 처리하지 않게 하고싶을때 활용
