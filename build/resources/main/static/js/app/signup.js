var main = {
    init : function() {
        var _this = this;

        $('#signup').on('click', function() {
            _this.save();
        });
    },

    save : function() {
        var nickname = $('#nickname').val();
        var password = $('#password').val();
        var email = $('#email').val();
        var phone = $('#phone').val();

        var data = {
            nickname: nickname,
            password: password,
            email: email,
            phone: phone
        };

        $.ajax({
            type: 'POST',
            url: '/api/s1/member',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('회원등록되었습니다.');
            window.location.href='/';
        }).fail(function() {
            alert(JSON.stringify(error));
        });
    }
}

main.init();