<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
	<meta http-equiv="Content-Type" content="text/html;">
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
      <div class="container janela">
        <div class="row">

          <div class="container col-sm-12 col-md-3 col-lg-3 col-xl-4">
          </div>

          <div class="container col-sm-12 col-md-6 col-lg-4 col-xl-4">

            <form class="corpoCadastro" method="post" action="Cadastrar">

              <center><div class="logo"><img src="imagens/Logo.png" height="100" width="130"></div></center>

              <hr style="height:1px; border:none; background-color:#D8D8D8; margin-top: 5px; margin-bottom: 10px;"/>

              <div class="form-group align">

                <label for="exampleFormControlInput1" align>Nome</label>

                <input type="text" class="form-control " id="exampleFormControlInput1" placeholder="Ex: Seu_nome" name="nome">
              </div>

              <div class="form-group align ">
                <label for="exampleFormControlInput1">Login</label>
                <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="Ex: Nome_de_usuario" name="login">
              	<%
              		String modal = request.getParameter("modal");
              		if(modal != null){
              			if(modal.equals("1")){
              				out.println("<span style='color: red;'>Login já existente!</span>");
              			}
              		}
              	%>
              </div>

              <div class="form-group align">
                <label for="inputPassword">Senha</label>
                <input type="password" class="form-control" id="inputPassword" name="senha">
              </div>

              <div class="form-group align">
                <label for="exampleFormControlSelect1">Selecione seu Curso</label>
                <select class="form-control" id="exampleFormControlSelect1" name="curso">
                  <option value="2">Edificações</option>
                  <option value="6">Eletrotécnica</option>
                  <option value="1" selected>Informática</option> 
                  <option value="4">Mecânica</option>
                  <option value="3">Química</option>
                  <option value="5">Telecomunicações</option>
                </select>
              </div>

              <div class="botoes"><button type="submit" class="botaoVerde btn mb-2 btn-block">Cadastrar</button></div>

              <div class="especial"><center> Ou </center></div>

              <div class="botoes"><a href="TelaLogin.jsp"><button type="button" class="botaoCinza btn mb-2 btn-block">Fazer Login</button></a></div>

            </form>
          </div>

          <div class="container col-sm-12 col-md-3 col-lg-3 col-xl-4">
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