let title = "테니스";
let purpose = "테니스";

const action = new URLSearchParams(new URL(location.href).search);
const isWrite = action.get('action');
$('#main_save').click(function (){
    title = $('#main_title').val();
    purpose = $('#main_purpose').val();
    alert("저장하였습니다.");
    window.close();
});
$('#reservation').click(function (){
    $('#writeBtn').click();
})
$(document).on('click', '.action_check', function() {
    const $name = $('#mem_nm').val();
    $('#team_nm').val($name);
    $('#users').val('4');
    $('#title').val(title);
    $('#purpose').val(purpose);
    $('#agree_use1').prop('checked',true);
   $('.nowrap').append($('<button id="reservation" style="width: 50px">예약</button>'))
});
