jQuery(document).ready(function() {
    $('.ContenedorLogueo form').submit(function(){
        var usuario = $(this).find('.usuario').val();
        var contrasena = $(this).find('.contrasena').val();
        if(usuario == '') {
            $(this).find('.error').fadeOut('fast', function(){
                $(this).css('top', '27px');
            });
            $(this).find('.error').fadeIn('fast', function(){
                $(this).parent().find('.usuario').focus();
            });
            return false;
        }
        if(contrasena == '') {
            $(this).find('.error').fadeOut('fast', function(){
                $(this).css('top', '96px');
            });
            $(this).find('.error').fadeIn('fast', function(){
                $(this).parent().find('.contrasena').focus();
            });
            return false;
        }
    });

    $('.ContenedorLogueo form .usuario, .ContenedorLogueo form .contrasena').keyup(function(){
        $(this).parent().find('.error').fadeOut('fast');
    });
});