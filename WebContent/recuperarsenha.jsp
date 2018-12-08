<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

  <link rel="stylesheet" type="text/css" href="css/stylec.css">
  <link rel="shortcut icon" type="image/x-png" href="imagens/favicon.png">

  <title>Cadastro | CIF</title>
</head>
<body>
  <div class="bg">
    <div class="vazio">
      <div class="container janelota">
        <div class="row">

          <div class=" container col-sm-12 col-lg-12 col-xl-8">

            <div class="janelaSenha">

              <div class="tabelaSenha">
                <h6><b>Recupere sua senha</b></h6>
                <div class="form-group align ">
                <form method="post" action="RecuperarSenha">		
                  <label for="exampleFormControlInput1">Insira o e-mail cadastrado para enviarmos sua senha:</label>
                  <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="Email" name="email">
                  <%
                  	String modal = request.getParameter("modal");
                  	if(modal != null){
                  		if(modal.equals("1")){
                  			out.println("<span style='color: red;'>Email não cadastrado!</span><br>");
                  		}
                  	}
                  %>
                </div>
                <button type="submit" class="botaoVerde btn btn-success btn-block" >Enviar</button>
                </form>
              </div>

              <div class="rodapeSenha">
                <a href="TelaLogin.jsp"><button type="button" class="botaoCinza btn btn-secondary btn-block" >Voltar</button></a>
              </div> 

              <hr style="height:2px; border:none; background-color:#DCDCDC;  margin-right: 20px; margin-left: 20px; margin-bottom: -1px;"/>

            </div>

          </div>

        </div>
      </div>

      <div class="footer">
        Todos os direitos reservados.| Desenvolvido por <a href="https://www.instagram.com/douglasm.jpg/" target="_blank">Erick Douglas</a> e <a href="https://www.instagram.com/_paulinc3/" target="_blank">Paulo Roberto.</a>
      </div>
    </div>

    <!-- JAVASCRIPT -->

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    <script>

      $(document).ready(function() {

       var docHeight = $(window).height();
       var footerHeight = $('.footer').height();
       var footerTop = $('.footer').position().top + footerHeight;

       if (footerTop < docHeight) {
        $('.footer').css('margin-top', -25+ (docHeight - footerTop) + 'px');
      }
    });
  </script>

  <script type="text/javascript">
    (function($){
      $.fn.backgroundMove=function(options){
        var defaults={
          movementStrength:'10'
        },
        options=$.extend(defaults,options);

        var $this = $(this);

        var movementStrength = options.movementStrength;
        var height = movementStrength / $(window).height();
        var width = movementStrength / $(window).width();
        $this.mousemove(function(e){
          var pageX = e.pageX - ($(window).width() / 2);
          var pageY = e.pageY - ($(window).height() / 2);
          var newvalueX = width * pageX * -1 - 25;
          var newvalueY = height * pageY * -1 - 50;
          $this.css("background-position", newvalueX+"px "+newvalueY+"px");
        });

      }
    })(jQuery);

    $('.bg').backgroundMove({
      movementStrength:'10'
    });


  </script>

</body>
</html>
