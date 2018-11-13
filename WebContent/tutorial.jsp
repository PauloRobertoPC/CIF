<%@page import="model.*"%>
<%@page import="dao.*"%>
<%@page import="util.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  	<link rel="stylesheet"
  	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
  	<link rel="stylesheet" href="css/style.css">
  	<link rel="shortcut icon" type="image/x-png" href="imagens/favicon.png">
  	<title>Tutorial</title>
</head>
<body>
	<%
		Usuario u = (Usuario) session.getAttribute("usuario");
		String modal = request.getParameter("modal");
		if(modal != null){
			if(modal.equals("3")){
				response.sendRedirect("PaginaInicial.jsp?coisa=1");
			}
		}
	%>
	<!--   MENU   -->
  <div class="bg">

    <div class="container janelasT" style="padding-top: 10px; margin-top: 0px;">
      <div class="row">
        <div class=" container col-sm-12 col-lg-12 col-xl-7 ">

          <div class="janelaTutor" style="opacity: 0.98; padding: 20px 20px 20px 20px; margin-top: 0px; margin-bottom: 30px; margin-right: 0px; margin-left: 0px; background: #fff; border-radius: 5px; border: 1px solid #C0C0C0; border-bottom: solid #808080 2.2px;">   

              <h2 style="color: #006400;"><b>Bem-vindo ao <img src="imagens/Logo.png" style="margin-top: -10px;" width="45px" height="35px">, Cartoleiro!<br> </b></h2><br></center>


              <h2 style="font-size: 20px; font-weight: bold; ">Como funciona o Cartola IF?</h2>
              O cartola funciona por rodada. A cada rodada, um jogador recebe uma pontuação, que depende de sua atuação dentro de quadra.<br><br>

              <h2 style="font-size: 20px; font-weight: bold; ">Qual o objetivo do jogo?</h2>
              O objetivo é conseguir a melhor pontuação com sua escalação, escolhendo os melhores jogadores. Você poderá escalar <b>apenas um time</b> por rodada.<br><br>

              <!--Você poderá escalar <b>apenas um time</b> em cada rodada, com o objetivo de escalar os melhores jogadores e assim receber a melhor pontuação.<br>
              Lembre-se que só é possível escalar um time antes de uma rodada começar ou depois que ela terminar. -->

              <h2 style="font-size: 20px; font-weight: bold; ">Como escalar um time?</h2>
              O CIF tem uma aba no menu chamada "Escalação". Clicando nela, será redirecionado a uma tela com todos os jogadores inscritos para serem escalados. Selecione-os em suas devidas posições, confirmem clicando em "Escalar time" e torça para sua escalação ser a melhor!<br><br>

              <h2 style="font-size: 20px; font-weight: bold; ">Como funcionam as ligas?</h2>
              O Cartoleiro também poderá participar de ligas, onde poderão conferir a pontuação dos outros usuários ingressados. <b>O limite será de 4 ligas</b> por usuário, sendo que duas delas serão a "Liga do Curso" e a "Liga Geral". As outras 2 o cartoleiro poderá escolher em qual entrar, dentre as existentes, ou poderão ser criadas pelo mesmo. O acesso é feito pela aba "Ligas" que se encontra no menu.<br><br>
              
              <!--Cada Cartoleiro poderá participar de quatro ligas, sendo que duas delas você não poderá sair que é a liga do seu curso e a liga Geral<br>
              os cartoleiros tabém podem criar novas ligas e assim competir com seus amigos. Para Acessar as ligas abra o menu e clique em "Ligas".<br>-->
              <h2 style="font-size: 20px; font-weight: bold; ">E quanto ao perfil do usuário?</h2>
              Em seu perfil, você poderá ver as ligas que participa e ver as suas escalações nas rodadas selecionadas. Também poderá realizar operações de troca de senha e exclusão da conta.<br><br>

              <i>O cartoleiro também terá acesso a informações de jogos que aconteceram ou ainda vão acontecer, acessando a aba "Guia" no menu.<br>
              <b>Para mais duvidas, existe a aba "Ajuda" que se encontra no menu. Nela, você encontrará as principais perguntas sobre o Cartola IF.</i></b><br></br>

			<hr style="height:1px; border:none; background-color:#CCCCCC;  margin-right: -20px; margin-left: -20px;"/>
              
              <h2><b>Agora Vamos lá!</b></h2>

              Você precisa dar um nome para seu time e para SEU técnico. <br>
              <b><i>Dica: normalmente um nome/apelido pelo qual você é conhecido.</i></b><br></br>

              <form action="TimeCartoleiro" method="post">
                <b>Nome Time: </b> <input type="text" class="caixaTxt" name="nometime">
                <%	
	        	if(modal != null){
	        		if(modal.equals("1")){
	        			out.println("<span style='color : red;'>Nome do Time Em Uso</span>");
	        		}
	        	}
                %>
                <br><br>        
                <b>Nome Cartoleiro: </b> <input type="text" class="caixaTxt" name="nomecartoleiro">
                <%	
		        	if(modal != null){
		        		if(modal.equals("2")){
		        			out.println("<span style='color: red;'>Nome Cartoleiro Em Uso</span>");
		        		}
		        	}
		        %>
                <br>
                <br>
                <input type='hidden' name='id' id='id' value=<%out.println(u.getIdUsuario());%>>
                <button type="button" class="btnL_cinza btn btn-secondary btn-block" data-toggle="modal" data-target="#exampleModalCenter">
                  Salvar
                </button>
              </div>
            </div>


            <!-- Modal -->
            <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
             <div class="modal-dialog modal-dialog-centered" role="document">
               <div class="modal-content">
                 <div class="modal-header">
                   <h5 class="modal-title" id="exampleModalCenterTitle"><b>Salvar</b></h5>
                   <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                     <span aria-hidden="true">&times;</span>
                   </button>
                 </div>
                 <div class="modal-body">
                  Você deseja realmente botar esses nomes nos respectivos campos?<br><b>(Lembre-se que você não poderá mais mudar)</b>
                </div>
                <div class="modal-footer">
                 <button type="button" class="btnL_cinza btn btn-secondary" data-dismiss="modal">Fechar</button>
                 <button type="submit" class="btnL_verde btn btn-primary">Salvar</button>
               </form>
             </div>
           </div>
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
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
<script src="js/jquery.min.js"></script>
<!--   MENU JS   -->

<script>
  function openSlideMenu(){
    document.getElementById('side-menu').style.width = '250px';
    document.getElementById('main').style.marginLeft = '250px';
  }

  function closeSlideMenu(){
    document.getElementById('side-menu').style.width = '0px';
    document.getElementById('main').style.marginLeft = '0px';
  }

</script>

<!--   FOOTER JS   -->  

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