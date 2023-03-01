1. 프로젝트 Path만 가져옵니다.

request.getContextPath() 

예)  http://localhost:8080/project/list.jsp

[return]/project 

 

2. 프로젝트 + 파일경로까지 가져옵니다.

request.getRequestURI() 

예)  http://localhost:8080/project/list.jsp

[return]        /project/list.jsp  

String url = request.getRequestURI.split("/");

String Name = url[url.length -1];       // list.jsp

 

3. 전체 경로를 가져옵니다. 

request.getRequestURL()

예) http://localhost:8080/project/list.jsp

[return]   http://localhost:8080/project/list.jsp

 

4. 파일명만 가져옵니다.

request.ServletPath() 

예) http://localhost:8080/project/list.jsp

[return] /list.jsp

 

5. 서버 or 로컬 웹 애플리케이션 절대결로 가져옵니다. 

request.getRealPath() 

예) http://localhost:8080/projectname/list.jsp

[return]         c:\project\webapps\projectname\