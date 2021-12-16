// 숫자 세 자리마다 콤마(,) 입력
// 필요한 태그에서
// onkeyup="inputNumberFormat(this)"
// 추가
// ex) <input type="text" id="price" onkeyup="inputNumberFormat(this)"/>
function inputNumberFormat(obj) {
    obj.value = comma(uncomma(obj.value));
}

function comma(str) {
    str = String(str);
    return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
}

function uncomma(str) {
    str = String(str);
    return str.replace(/[^\d]+/g, '');
}