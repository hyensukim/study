// 조건식이 true -> 중괄호 내 실행, false -> 줄괄호 내부 실행 X
int age = 10;
if(age > 8){
    System.out.println("자이로드롭을 탈수 있어!");
}

// 조건식이 true -> 중괄호 내 실행, false -> else 중괄호 내부 실행.
if(age > 8){
    System.out.println("통과");
}else{
    System.out.println("실패");
}

//if-else if-else 구문
	int age = -1;
		if(age > 10){
		    System.out.println("10초과");
		}else if(age > 0 && age <= 10){
		    System.out.println("10이하");
		}else {
		    System.out.println("음수");
		}

//switch-case 구문
int rank = 1;
String  medalcolor;
switch(rank){
    case 1 : 
    System.out.println("금메달입니다.");
    break;
    case 2 :
    System.out.println("은메달입니다.");
    break;
    case 3 :
    System.out.println("동메달입니다.");
    break;
    default :
    System.out.println("메달권이 아닙니다.");
}
