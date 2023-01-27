### 2023.01.27
# JSP1
## 특징
- 서블릿 기술의 확장.
- 유지 관리가 용이.
- 빠른 개발이 가능.
- 코드의 길이가 현저히! 줄어든다.

## JSP 처리과정
![Alt text](https://raw.githubusercontent.com/yonggyo1125/curriculum300H/main/4.Servlet%20%26%20JSP1%2821%EC%8B%9C%EA%B0%84%29/2%EC%9D%BC%EC%B0%A8%283h%29%20-%20JSP%EC%9D%98%20%ED%8A%B9%EC%A7%95%2C%20JSP%EC%9D%98%20%ED%8E%98%EC%9D%B4%EC%A7%80%20%EC%B2%98%EB%A6%AC%EA%B3%BC%EC%A0%95%2C%20JSP%EC%9D%98%20%EC%83%9D%EB%AA%85%EC%A3%BC%EA%B8%B0%2C%20%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8A%B8%20%ED%83%9C%EA%B7%B8%2C%20%EB%94%94%EB%A0%89%ED%8B%B0%EB%B8%8C%20%ED%83%9C%EA%B7%B8%2C%20%EC%A3%BC%EC%84%9D%EC%B2%98%EB%A6%AC/images/JSP%ED%8E%98%EC%9D%B4%EC%A7%80_%EC%B2%98%EB%A6%AC_%EA%B3%BC%EC%A0%95.png)
1. 웹 브라우저에서 웹 서버로 JSP를 요청.
2. 웹 서버에서 JSP의 확장자(.jsp) 확인 후 JSP 컨테이너로 전달.
3. JSP 컨테이너는 JSP를 서블릿으로 번역.(.jsp -> jsp.java)
4. JSP 컨테이너가 서블릿을 컴파일 후 클래스 파일로 변환해준 뒤
   웹 서버로 전달.
5. 웹 서버에서 클래스 파일 실행 및 실행 결과를 웹브라우저에 응답으로
   전달해준다.<br><br

## JSP 생명주기
![Alt text](https://raw.githubusercontent.com/yonggyo1125/curriculum300H/main/4.Servlet%20%26%20JSP1%2821%EC%8B%9C%EA%B0%84%29/2%EC%9D%BC%EC%B0%A8%283h%29%20-%20JSP%EC%9D%98%20%ED%8A%B9%EC%A7%95%2C%20JSP%EC%9D%98%20%ED%8E%98%EC%9D%B4%EC%A7%80%20%EC%B2%98%EB%A6%AC%EA%B3%BC%EC%A0%95%2C%20JSP%EC%9D%98%20%EC%83%9D%EB%AA%85%EC%A3%BC%EA%B8%B0%2C%20%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8A%B8%20%ED%83%9C%EA%B7%B8%2C%20%EB%94%94%EB%A0%89%ED%8B%B0%EB%B8%8C%20%ED%83%9C%EA%B7%B8%2C%20%EC%A3%BC%EC%84%9D%EC%B2%98%EB%A6%AC/images/JSP_%EC%83%9D%EB%AA%85%EC%A3%BC%EA%B8%B0.png)
- JSP 페이지를 컴파일한 .class 파일에는 위 메서드 3개가 존재하며, JSP 생성과 소멸까지 다음과 같은
  역할을 수행한다.
1. 번역 단계
    - JSP 컨테이너에서 JSP 파일을 읽고 구문을 분석.
2. 컴파일 단계
    - 생성된 자바 코드인 서블릿을 컴파일 하여 클래스 파일로 변환.
3. 로딩 및 초기화 단계
    - JSP 컨테이너 클래스를 로딩한 뒤 인스턴스 생성을 해준다.
    - 서블릿의 Init() 메서드 호출하여 객체를 초기화해준다.
        - 한번만 초기화가 수행되며 DB 연결, 파일 열기 등을 초기화.
4. 실행 단계
    - JSP 컨테이너가 요청에 대한 응답 및 객체 전달하는 단계.
    - _jspService() 메서드 실행.
    - 웹브라우저 요청 시마다 객체 전달.
    - 개발자가 정의한 코드들은 모두 여기에 들어가있다.
5. 소멸 단계
    - JSP 컨테이너가 실행중인 JSP를 _jspDestroy() 메서드를 실행
      하여 제거한다.
    - 데이터베이스 연결 해제 또는 열려 있는 파일 닫기 등을 수행해야
      할 경우 jspDestroy() 메서드를 오버라이딩 해주면 된다.
- _jspInit(), _jspDestroy()는 오버라이드 가능 하지만, _jspService()는 불가능 하다.<br><br>

## 스크립트 태그
1. 선언문  
<%! 자바 코드; %>  
- class 바로 하부에 멤버로 생성.
- 스크립틀릿 태그보다 나중에 선언되어도 스크립틀릿 태그에서 사용 가능.
- 멤버 변수로 취급되어 전역변수로 사용 가능.
- 메서드 정의 가능.

2. 스크립틀릿  
<% 자바 코드; %>  
- 번역 시 _jspService() 메서드 내부에 복사되는 태그.
    - 내부에 선언된 변수는 모두 지역변수이다.
    - 메서드 내부이므로 메서드는 정의가 불가능하며, 호출은 가능하다.

3. 표현문  
<%=변수명, 메서드 호출 %>
- 번역 시 _jspService() 메서드 내부에 복사되는 태그.
- 자동으로 출력해주는 출력 전용 태그이다.
- 내부적으로 out.print()로 출력해준다.
