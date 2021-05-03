# 자동차 경주 게임

## 게임 설명

- 사용자에게 자동차 이름, 시도 할 횟수를 입력받고, 주어진 횟수만큼 각 자동차들이 전진, 멈춤을 반복하며 우승자를 가린다.

## 게임 방법

1. 입력
   1. 경주 할 자동차 이름 (쉼표(,)를 기준으로 구분)
   2. 시도 할 회수
2. 출력
   1. 각 회수 별 게임 진행 상황
   2. 최종 우승자
3. 게임 진행
   1. 각 자동차들은 0~9 random값 을 구하고, 4이상일 경우 전진, 3 이하이면 멈춘다.

## 게임 규칙
1. 입력
   1. 자동차 이름은 5자 이하만 가능하다.
2. 출력
   1. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
   2. 우승자는 한 명 이상일 수 있다.

## 기능 목록

1. 게임 core 기능
   1. 자동차 전진, 멈춤 기능
   2. 전진, 멈춤 판정 기능
   3. 0~9 random 값 계산 기능
   4. 우승자 계산 기능
2. 입력
   1. 이름 입력
   2. 몇번 이동할 것인지 입력
3. 출력
   1. 게임 진행 상황
   2. 게임 결과 (우승자)

## 게임 실행 예시
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,crong,honux
시도할 회수는 몇회인가요?
5

pobi:-
crong:-
honux:

pobi:--
crong:--
honux:-

pobi:---
crong:---
honux:--

pobi:----
crong:----
honux:--

pobi:----
crong:-----
honux:---

crong가 최종 우승했습니다.
```

## 디렉토리 구조
```
└─src
    ├─main
    │  └─java
    │      ├─common
    │      │  └─code
    │      │     └─ GameErrorCode.java  Game 공통 에러 코드
    │      │
    │      └─game
    │          ├─app
    │          │  └─ GameApp.java       Game input/output(application)
    │          │
    │          └─core
    │             └─ Car.java           Car 객체 (name, position)
    │                Cars.java          Cars 객체 (Cars)
    │                GamePlayer.java    Game 실행
    │
    └─test
        └─java
            └─game
                └─core
                   └─ CarsTest.java
                      CarTest.java
                      GamePlayerTest.java

```