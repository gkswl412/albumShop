var cartId;
var totalOrderPrice = 0;
var totalMileage = 0;
$(function () {
    cartId = Number.parseInt($(".cartId").val());
    console.log("cartId" + cartId);
    $("input[name^=item]").prop("checked", true);
    getOrderTotalPrice();
    getMileage();
    $("input[name=itemChk]").change(function () {
        getOrderTotalPrice(); // Cart 안에 사용자가 선택한 앨범의 총수량 / 총금액
        getMileage();
    });
    getCartTotalPrice(); // Cart 안에 담겨 있는 앨범의 총수량 / 총금액
});

function checkAll(){
    if($("input[name=checkAll]").prop("checked")){
        $("input[name=itemChk]").prop("checked",true);
    }else{
        $("input[name=itemChk]").prop("checked",false);
    }
    getOrderTotalPrice();
    getMileage();
}

function getOrderTotalPrice() {
    var orderTotalPrice = 0;
    var deliveryFeeString = $("#deliveryFee").text();
    var deliveryFee = Number(deliveryFeeString.substring(0, deliveryFeeString.length-1));
    $("input[name=itemChk]:checked").each(function (){
        var checkedItemId = $(this).val();
        var price = $('#price_' + checkedItemId).attr("data-price");
        var quantity = $('#quantity_' + checkedItemId).val();

        orderTotalPrice += price * quantity;
        totalOrderPrice = orderTotalPrice;
        console.log("totalOrderPrice : " + totalOrderPrice);
    });
    $("#orderTotalPrice").html(orderTotalPrice + '원');
    if (orderTotalPrice == 0) {
        $("#finalOrderTotalPrice").html(orderTotalPrice + '원');
    } else {
        $("#finalOrderTotalPrice").html(orderTotalPrice + deliveryFee + '원');
    }
    getMileage();
};

function getCartTotalPrice() {
    var totalPrice = 0;
    var totalQuantity = 0;
    $("input[name=itemChk]").each(function (){
        var itemId = $(this).val();
        var price = $('#price_' + itemId).attr("data-price");
        var quantity = parseInt($('#quantity_' + itemId).val());

        totalPrice += price * quantity;
        totalQuantity += quantity;

    });
    $("#totalPrice").html(totalPrice + '원');
    $("#totalQuantity").html(totalQuantity + '장');
}
function changeQuantity(obj) {
    var quantity = obj.value;
    var itemId = obj.id.split('_')[1];
    var price = $("#price_" + itemId).data("price");
    var totalPrice = price * quantity;
    $("#total_price_" + itemId).html(totalPrice + '원');
    getCartTotalPrice();
    getOrderTotalPrice();
    getMileage();
    updateCartAlbumCount(cartId, itemId, quantity);
}
function getMileage() {
    var mileage = Math.floor(totalOrderPrice * 0.05);
    if ($('input[name="itemChk"]:checked').length == 0) {
        mileage = totalMileage;
    }

    console.log(mileage);
    $("#mileage").html("적립 예정 마일리지 : " + mileage + "점 (5%)");
}
function deleteCartAlbum (obj) {
    var albumId = parseInt(obj.id);
    var url = "/cart/delete/" + cartId + "/" + albumId;

    console.log("delete id : " + albumId);

    if (confirm("장바구니에서 해당 앨범을 삭제하시겠습니까?") == true) {
        $.ajax({
            url      : url,
            type     : "DELETE",
            /*					beforeSend : function(xhr){
                                    /!* 데이터를 전송하기 전에 헤더에 csrf값을 설정 *!/
                                    xhr.setRequestHeader(header, token);
                                },*/
            dataType : "json",
            cache   : false,
            success  : function(result, status){
                location.href = '/cart';
                showDeleteAlert();
            }/*,
						error : function(jqXHR, status, error){

							if(jqXHR.status == '401'){
								alert('로그인 후 이용해주세요');
								//location.href='/user/';
							} else{
								alert(jqXHR.responseJSON.message);
							}
						}*/
        });
    }
}
function deleteCartAlbumAll() {
    if (confirm("장바구니에서 모든 앨범을 삭제하시겠습니까?") == true) {
        var url = "/cart/delete/" + cartId + "/all";
        $.ajax({
            url      : url,
            type     : "DELETE",
            /*					beforeSend : function(xhr){
                                    /!* 데이터를 전송하기 전에 헤더에 csrf값을 설정 *!/
                                    xhr.setRequestHeader(header, token);
                                },*/
            dataType : "json",
            cache   : false,
            success  : function(result, status){
                location.href = '/cart';
            }/*,
						error : function(jqXHR, status, error){

							if(jqXHR.status == '401'){
								alert('로그인 후 이용해주세요');
								//location.href='/user/';
							} else{
								alert(jqXHR.responseJSON.message);
							}
						}*/
        });
        showDeleteAlert();
    } else {
        alert("장바구니 비우기를 취소했습니다.");
    }

}
function updateCartAlbumCount(cartId, albumId, count) {
    /*var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");*/

    var url = "/cart/update/" + cartId + "/" + albumId + "?count=" + count;

    $.ajax({
        url      : url,
        type     : "PATCH",
        /*					beforeSend : function(xhr){
                                /!* 데이터를 전송하기 전에 헤더에 csrf값을 설정 *!/
                                xhr.setRequestHeader(header, token);
                            },*/
        dataType : "json",
        cache   : false,
        success  : function(result, status){
            console.log("cartItem count update success");
            showQuantityUpdateAlert();
        }/*,
					error : function(jqXHR, status, error){

						if(jqXHR.status == '401'){
							alert('로그인 후 이용해주세요');
							//location.href='/user/';
						} else{
							alert(jqXHR.responseJSON.message);
						}
					}*/
    });
}
function showQuantityUpdateAlert() {
    $("#myAlert").show();
}
function showDeleteAlert() {
    $("#myDeleteAlert").show();
}