<%@page import="model.*"%>
<%@page import="dao.*"%>
<%@page import="util.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">
	<link rel="shortcut icon" type="image/x-png" href="imagens/favicon.png">
<link rel="stylesheet" href="css/style.css">
<title>Guia de Jogos | CIF</title>
<style>
img.fotopequena {
	width: 100px;
	height: 100px;
}
</style>
</head>
<body>
	<%
		Usuario u = (Usuario) session.getAttribute("usuario");
	%>
<!--   MENU   -->
  <div class="bg">
    <div class="container-fixed fixed-top cima">
      <nav class="navbar navbar-light" style= "background-color: #006400;">

        <div class="botaoMenu">
          <a href="#" onclick="openSlideMenu()">
            <svg width="30" height="30">
              <path d="M0,5 30,5" stroke=#fff stroke-width="4" />
              <path d="M0,15 30,15" stroke=#fff stroke-width="4" />
              <path d="M0,25 30,25" stroke=#fff stroke-width="4" />
            </svg>
          </a>
        </div>

        <div id="logo">
          <a href="PaginaInicial.jsp"><img src="imagens/icones/Logo_branca.png" height="40" width="55"></div></a>
        </div>

        <div id="side-menu" class="side-nav" style="z-index: 3000;">
          <a href="#" class="fixed-top btn-close" onclick="closeSlideMenu()"> 
            <svg width="30" height="30">
              <path d="M0,5 30,5" stroke=#006400 stroke-width="4" />
              <path d="M0,15 30,15" stroke=#006400 stroke-width="4" />
              <path d="M0,25 30,25" stroke=#006400 stroke-width="4" />
            </a></svg>
            <b><h1>MENU</h1></b>

            <div class="verdeItems">

              <hr style="height:1px; border:none; background-color:#D8D8D8; margin-top: 0px; "/>
              <div class="iconeMenu"><img src="imagens/icones/Home.png" height="30" width="30"><a href="PaginaInicial.jsp">Início</a></div>

              <hr style="height:1px; border:none; background-color:#F0F0F0;  margin-right: 10px; margin-left: 10px;"/>
              <div class="iconeMenu"><img src="imagens/icones/Perfil.png" height="30" width="30"><a href="MeuPerfil.jsp">Perfil</a></div>

              <hr style="height:1px; border:none; background-color:#F0F0F0;  margin-right: 10px; margin-left: 10px;"/>
              <div class="iconeMenu"><img src="imagens/icones/Ligas.png" height="30" width="30"><a href="Ligas.jsp">Ligas</a></div>

              <hr style="height:1px; border:none; background-color:#F0F0F0;  margin-right: 10px; margin-left: 10px;"/>
              <div class="iconeMenu"><img src="imagens/icones/Escalar.png" height="30" width="30"><a href="MostrarJogadores.jsp">Escalação</a></div>

              <hr style="height:1px; border:none; background-color:#F0F0F0;  margin-right: 10px; margin-left: 10px;"/>
              <div class="iconeMenu"><img src="imagens/icones/Guia.png" height="30" width="30"><a href="GuiaJogos.jsp">Guia</a></div>

            </div>

            <div class="cinzaItems">
              <%
        		if((u.getidTipoUsuario() == 1) || (u.getidTipoUsuario() == 2)){
        			out.println("<hr style='height:1px; border:none; background-color:#F0F0F0;  margin-right: 10px; margin-left: 10px;'/>");
        			out.println("<div class='iconeMenu'><img src='imagens/icones/Admin.png' height='30' width='30'><a href='crud.jsp'>Adminstrador</a></div>");
        		}
        	%>
              <hr style="height:1px; border:none; background-color:#F0F0F0;  margin-right: 10px; margin-left: 10px;"/>
              <div class="iconeMenu"><img src="imagens/icones/Sobre.png" height="30" width="30"><a href="#" data-toggle="modal" data-target="#ajudaModal">Ajuda</a></div>

              <hr style="height:1px; border:none; background-color:#F0F0F0;  margin-right: 10px; margin-left: 10px;"/>
              <div class="iconeMenu"><img src="imagens/icones/Logout.png" height="30" width="30"><a href="Sair">Sair</a></div>

            </div>
            <div class="foot">CIF - v3.0
            </div>
          </nav>
        </a>
      </div>
      <!--   BODY   -->
      <div class="modal fade" id="ajudaModal" tabindex="-1" role="dialog" aria-labelledby="ajudaModal" aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <center><h5 class="modal-title" id="ajudaModal"><b>Ajuda</center></b></h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              O <b>Cartola IF</b> é um sistema de apostas, em que os usuários criam escalações de jogadores e acumulam pontos em cada acerto, com base na avaliação do CIF.<br><br>

              <b style="color: #1a1a1a; font-size: 25px;">Como altero minha senha?</b><br>
              Na aba "Perfil" você terá acesso às suas ligas, suas escalações e poderá fazer alterações em sua conta.<br><br>

              <b style="color: #1a1a1a; font-size: 25px;">Como escalo um time?</b><br>
              Na aba "Escalação" você terá acesso aos jogadores e suas pontuações, podendo selecioná-los para sua escalação, clicando no botão "Escalar Time".<br><br>

              <b style="color: #1a1a1a; font-size: 25px;">Como entro/crio uma liga?</b><br>
              Na aba "Ligas" você terá acesso às suas ligas, ver o nome e pontuações dos usuários da liga, e poderá criar novas ligas.<br><br>

              <b style="color: #1a1a1a; font-size: 25px;">Como acompanho os jogos?</b><br>
              Na aba "Guia" você terá informação de todos os jogos que ocorreram ou ainda vão acontecer, e também visualizar o placar, local e horário.
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Ok</button>
            </div>
          </div>
        </div>
      </div>
	<%
		JogosDAO jgd = new JogosDAO();
        ArrayList<Jogos> jogos = jgd.selectAll();
        jgd.closeDataBase();
        int c = 0;
        if(jogos.size() != 0){
        	out.println("<div class='container janelas'>");
    		out.println("<div class='row'>");
            CursoDAO cd = new CursoDAO();
            RodadaDAO rd = new RodadaDAO();
            out.println("<div class='container col-sm-12 col-lg-12 col-xl-8'>");
            out.println("<h2>JOGOS CONCLUÍDOS</h2>");
            out.println("<div class='janelaGuia'>");
            while(c < jogos.size()){
                // OBS pegar o nome da imagem!
                if(jogos.get(c).getPlacarCurso1() >= 0){
                	out.println("<div class='linhaGuia'><center><h1>");
                	Curso curso1 = cd.selectAll("WHERE idCurso = '" + jogos.get(c).getCurso1() + "'").get(0);
					Curso curso2 = cd.selectAll("WHERE idCurso = '" + jogos.get(c).getCurso2() + "'").get(0);
					out.println("<img class='fotoGuia' src='imagens/cursos/" + curso1.getImagemCurso() + "'> ");
					out.println("<b>"+jogos.get(c).getPlacarCurso1());
					out.println(" X ");
					out.println(jogos.get(c).getPlacarCurso2()+"</b>");
					out.println("<img class='fotoGuia' src='imagens/cursos/" + curso2.getImagemCurso() + "'></h1></center>");
                    out.println("<center><b>Localização:</b> "+jogos.get(c).getLocalizacao());out.println("<br/>");
                    out.println("<b>Data e Hora:</b> "+jogos.get(c).getDatahora());out.println("<br/>");
                    out.println("<b>Rodada:</b> "+rd.selectAll("WHERE idRodada = '"+jogos.get(c).getIdRodada()+"'").get(0).getNomeRodada());out.println("<br/>");
                    out.println("</center>");
                    out.println("</div>");
                }
                c++;
            }
            out.println("</div>");
            out.println("</div>");
      		out.println("<div class='rodapeGuia'><a href='' ></a></div>");
            out.println("<div class=' container col-sm-12 col-lg-12 col-xl-8'>");
            out.println("<h2>JOGOS MARCADOS</h2>");
            out.println("<div class='janelaGuia'>");
            c = 0;
            while(c < jogos.size()){
                // OBS pegar o nome da imagem!
                if(jogos.get(c).getPlacarCurso1() < 0){
                	out.println("<div class='linhaGuia'>");
                	Curso curso1 = cd.selectAll("WHERE idCurso = '" + jogos.get(c).getCurso1() + "'").get(0);
					Curso curso2 = cd.selectAll("WHERE idCurso = '" + jogos.get(c).getCurso2() + "'").get(0);
					out.println("<center><h1><img class='fotoGuia' src='imagens/cursos/" + curso1.getImagemCurso() + "'> ");
					out.println("<b> X </b>");
					out.println("<img class='fotoGuia' src='imagens/cursos/" + curso2.getImagemCurso() + "'></h1></center>");out.println("<br/>");
                    out.println("<center><b>Localização:</b> "+jogos.get(c).getLocalizacao());out.println("<br/>");
                    out.println("<b>Data e Hora:</b> "+jogos.get(c).getDatahora());out.println("<br/>");
                    out.println("<b>Rodada:</b> "+rd.selectAll("WHERE idRodada = '"+jogos.get(c).getIdRodada()+"'").get(0).getNomeRodada());out.println("<br/>");
                    out.println("</center>");
                    out.println("</div>");
                }
                c++;
            }
            out.println("<div class='rodapeGuia'><a href='' ></a></div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            rd.closeDataBase();
            cd.closeDataBase();
        }
        
		%>
	 <div class="footer">
        Todos os direitos reservados.| Desenvolvido por <a href="https://www.instagram.com/douglasm.jpg/" target="_blank">Erick Douglas</a> e <a href="https://www.instagram.com/_paulinc3/" target="_blank">Paulo Roberto.</a>
     </div>
    </div>
	<script>
		function openSlideMenu() {
			document.getElementById('side-menu').style.width = '250px';
			document.getElementById('main').style.marginLeft = '250px';
		}
		function closeSlideMenu() {
			document.getElementById('side-menu').style.width = '0px';
			document.getElementById('main').style.marginLeft = '0px';
		}
	</script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
		integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
		integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
		crossorigin="anonymous"></script>
	<script>
		$(document).ready(
				function() {

					var docHeight = $(window).height();
					var footerHeight = $('.footer').height();
					var footerTop = $('.footer').position().top + footerHeight;

					if (footerTop < docHeight) {
						$('.footer').css('margin-top',
								-25 + (docHeight - footerTop) + 'px');
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
</html>