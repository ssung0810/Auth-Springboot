var main = {
    init : function() {
        var _this = this;
        $('#signup').on('click', function() {
            _this.save();
        })
    }

    save : function() {
        var data = {
            id: $('#id').val(),
            pw: $('#pw').val(),
            email: $('#email').val(),
            phone: $('phone').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/',
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