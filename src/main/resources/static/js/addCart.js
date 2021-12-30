function addCart() {
    var url = "/cart/insert/"
    var paramData = {
        albumId : $("#albumId").val()
    };
    var param = JSON.stringify(paramData);
    console.log(param);

    $.ajax({
        url      : url,
        type     : "POST",
        contentType : "application/json",
        data     : param,
/*        beforeSend : function(xhr){
            /!* 데이터를 전송하기 전에 헤더에 csrf값을 설정 *!/
            xhr.setRequestHeader(header, token);
        },*/
        dataType : "json",
        cache   : false,
        success  : function(result, status){
            alert("상품을 장바구니에 담았습니다.");
            location.href='/';
        },
        error : function(jqXHR, status, error){

            if(jqXHR.status == '401'){
                alert('로그인 후 이용해주세요');
                location.href='/members/login';
            } else{
                alert(jqXHR.responseText);
            }

        }
    });
}