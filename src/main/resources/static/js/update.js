// (1) 회원정보 수정
function update(userId) {
    // form id를 이용하여 data에 값 담기
    let data = $("#profileUpdate").serialize();

    $.ajax({
        type:"put",
        url:"/api/user/${userId}}",
        data:data,
        contentType:"application/x-www-form-urlencoded; charset=utf-8",
        dataType:"json"
    }).done(res=> {
        console.log("update 성공");
        location.href=`/user/${userId}`;
    }).fail(error=> {
        console.log("update 실패")
    })

}