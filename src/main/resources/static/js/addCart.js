

function insertAlbum (cartId, albumId, userId) {
    $.ajax({
        url:"/cart/insert/" + userId + "/" + cartId + "/" + albumId,
        type:"get"
    }).done(function () {
        console.log(cartId);
        console.log(albumId);
        alert('장바구니에 앨범을 담았습니다.');
        location.href = 'cart';
    });
}


function addCart() {
    var add_alert = confirm('장바구니에 이 앨범을 담으시겠습니까?');
    if (add_alert == true) {
        alert('장바구니에 담기 준비중');
    }
    var url = "/cart/insert/"
    var paramData = {
        cartId : '${cartId}',
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