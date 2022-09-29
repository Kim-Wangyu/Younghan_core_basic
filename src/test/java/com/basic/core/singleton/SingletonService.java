package com.basic.core.singleton;

public class SingletonService {

    //자기자신을 private, static으로 하나 가지고 있음 , 자바기본 영역:스태틱으로 하나만 만들어져서 올라감
    //자기자신을 생성해서 instance에 넣어놓음, static영역에 딱 1개만 생성
    private static final SingletonService instance = new SingletonService();

    //조회 instance참조를 꺼낼 수 있는곳은 여기뿐
    //2. public으로 열어서 객체 인스턴스가 필요하면 이 static메서드를 통해서만 조회하도록 허용
    public static SingletonService getInstance() {
        return instance;
    }

    //3.생성자를 private으로 선언해서 외부에서 new키워드를 사용한 객체 생성을 못하게 막는다.
    private SingletonService() {

    }

    public void logic(){
        System.out.println(" 싱글톤 객체 로직 호출");
    }
}
