window.addEventListener("DOMContentLoaded",function(){
    // DOM 객체(노드, 다큐먼트 객체) 선택
    const menusEl = document.getElementById("menus");
    // li 태그명 DOM 객체 생성.
    const menu1El = document.createElement("li");
    
    // 속성추가
    menu1El.setAttribute("class","menu");
    menu1El.setAttribute("id","menu1");
    console.log(menu1El);
    
});