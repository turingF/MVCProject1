/*
 *
 * login-register modal
 * Autor: Creative Tim
 * Web-autor: creative.tim
 * Web script: #
 * 
 */
function showRegisterForm(){
    $('.loginBox').fadeOut('fast',function(){
        $('.registerBox').fadeIn('fast');
        $('.login-footer').fadeOut('fast',function(){
            $('.register-footer').fadeIn('fast');
        });
        $('.modal-title').html('注册');
    }); 
    $('.error').removeClass('alert alert-danger').html('');
       
}
function showLoginForm(){
    $('#loginModal .registerBox').fadeOut('fast',function(){
        $('.loginBox').fadeIn('fast');
        $('.register-footer').fadeOut('fast',function(){
            $('.login-footer').fadeIn('fast');    
        });
        
        $('.modal-title').html('登录');
    });       
     $('.error').removeClass('alert alert-danger').html(''); 
}

function openLoginModal(){
    showLoginForm();
    setTimeout(function(){
        $('#loginModal').modal('show');    
    }, 230);
    
}
function openRegisterModal(){
    showRegisterForm();
    setTimeout(function(){
        $('#loginModal').modal('show');    
    }, 230);
    
}

function loginAjax(){
    /*   Remove this comments when moving to server
    $.post( "/login", function( data ) {
            if(data == 1){
                window.location.replace("/home");            
            } else {
                 shakeModal(); 
            }
        });
    */
    if(document.getElementById("email1").value==false||document.getElementById("password1").value==false)
    {
        shakeModal();
        return false;
    }

/*   Simulate error message from the server   */
     //shakeModal();
}
function registerAjax(){
    /*   Remove this comments when moving to server
    $.post( "/login", function( data ) {
            if(data == 1){
                window.location.replace("/home");            
            } else {
                 shakeModal(); 
            }
        });
    */

        var password1 = document.getElementById("password").value;
        var password2 = document.getElementById("password_confirmation").value;
        if(password1 != password2  ){
            shakeModal1();
            return false;
        }
        if(document.getElementById("email").value==false||document.getElementById("password").value==false||document.getElementById("password_confirmation").value==false)
        {
            shakeModal();
            return false;
        }
       // document.getElementById("register").submit();

/*   Simulate error message from the server   */

}
function shakeModal(){
    $('#loginModal .modal-dialog').addClass('shake');
             $('.error').addClass('alert alert-danger').html("输入的用户名或密码不合法");
             $('input[type="password"]').val('');
             setTimeout( function(){ 
                $('#loginModal .modal-dialog').removeClass('shake'); 
    }, 1000 ); 
}
function shakeModal1(){
    $('#loginModal .modal-dialog').addClass('shake');
    $('.error').addClass('alert alert-danger').html("两次输入密码不一致");
    $('input[type="password"]').val('');
    setTimeout( function(){
        $('#loginModal .modal-dialog').removeClass('shake');
    }, 1000 );
}
   