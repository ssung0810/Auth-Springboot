var main = {
    init : function() {
        var _this = this;

        $('#signup').on('click', function() {
            _this.save();
        });
    },

    save : function() {
        var id = $('#id').val();
        var pw = $('#pw').val();
        var email = $('#email').val();
        var phone1 = $('#phone1').val();
        var phone2 = $('#phone2').val();
        var phone3 = $('#phone3').val();

        var data = {
            id: id,
            pw: pw,
            email: email,
            phone: phone1+phone2+phone3
        };

        $.ajax({
            type: 'POST',
            url: '/api/signup',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('회원등록되었습니다.');
            window.location.href='/main';
        }).fail(function() {
            alert(JSON.stringify(error));
        });
    }
}

main.init();