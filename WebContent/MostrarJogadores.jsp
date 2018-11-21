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
<title>CIF | Escalar</title>
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
		Util util = new Util();
		TimeRodadaDAO trd = new TimeRodadaDAO();
		int rodada;
		if(!util.terminou()){
			rodada = util.rodadaCorrente();
		}else{
			rodada = (util.rodadaCorrente() - 1);
		}
		ArrayList<TimeRodada> listatr = trd.selectAll("WHERE idUsuario ='" + u.getIdUsuario()/*sessão*/
				+ "' and idRodada = '" + rodada + "'");
		String tecnico = "";
		String goleiro = "";
		String fixo = "";
		String alae = "";
		String alad = "";
		String pivo = "";
		int idt = 0;
		int idg = 0;
		int idf = 0;
		int idae = 0;
		int idad = 0;
		int idp = 0;
		if (listatr.size() != 0) {
			//Quer dizer que o usuário já escalou um time e agora tem que mostrar
			// quem o usuário escalou
			JogadorDAO jd = new JogadorDAO();
			CursoDAO cd = new CursoDAO();
			int c = 0;
			while (c < listatr.size()) {
				Jogador j = jd.selectAll("WHERE idJogador = '" + listatr.get(c).getIdJogador() + "'").get(0);
				String cursos = util.tratarPasta(
						cd.selectAll("WHERE idCurso ='" + j.getCursoJogador() + "'").get(0).getNomeCurso());
				if (j.getPosicao().equals("Técnico")) {
					tecnico = "jogadores/" + cursos + "/" + j.getImagem();
					idt = j.getIdJogador();
				} else if (j.getPosicao().equals("Goleiro")) {
					goleiro = "jogadores/" + cursos + "/" + j.getImagem();
					idg = j.getIdJogador();
				} else if (j.getPosicao().equals("Fixo")) {
					fixo = "jogadores/" + cursos + "/" + j.getImagem();
					idf = j.getIdJogador();
				} else if (j.getPosicao().equals("Ala Esquerda")) {
					alae = "jogadores/" + cursos + "/" + j.getImagem();
					idae = j.getIdJogador();
				} else if (j.getPosicao().equals("Ala Direita")) {
					alad = "jogadores/" + cursos + "/" + j.getImagem();
					idad = j.getIdJogador();
				} else if (j.getPosicao().equals("Pivô")) {
					pivo = "jogadores/" + cursos + "/" + j.getImagem();
					idp = j.getIdJogador();				
				}
				c++;
			}
			jd.closeDataBase();
		} 	
			if(tecnico.equals("")){
				tecnico = "cone.png";
			}
			if(goleiro.equals("")){
				goleiro = "cone.png";
			}
			if(fixo.equals("")){
				fixo = "cone.png";
			}
			if(alae.equals("")){
				alae = "cone.png";	
			}
			if(alad.equals("")){
				alad = "cone.png";	
			}
			if(pivo.equals("")){
				pivo = "cone.png";	
			}
		trd.closeDataBase();
	%>
      <div class="container-fixed janelaEscala">
        <div class="row">

          <div class="col-sm-12 col-lg-4 col-xl-4">
            <h2>SUAS PARCIAIS</h2>
 
            <div class="janelaQuadra">

              <div>
                <img src="imagens/Quadra5.png" style="padding-left:10px; padding-right: 10px; width: 100%; height: 100%;" width="400px" height="600px">
                <img src="imagens/<%out.println(pivo);%>" class="fotopequena" id="pivo">
                <!--<ul><h7>teste</h7></ul>-->

                <img src="imagens/<%out.println(alae);%>" class="fotopequena" id="alae">

                <img src="imagens/<%out.println(alad);%>" class="fotopequena" id="alad">
                
                <img src="imagens/<%out.println(goleiro);%>" class="fotopequena" id="goleiro">


                <img src="imagens/<%out.println(fixo);%>" class="fotopequena" id="fixo">

                <img src="imagens/<%out.println(tecnico);%>" class="fotopequenaT" id="tecnico">
              </div>
            </div>
          </div>

          
                  
        <%
			if ((util.podeEscalar()) && (!util.terminou())) {
		%>
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="myModal">Escalar</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">Você deseja confirmar a escalação?</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Fechar</button>
						<a><button type="button" class="btn btn-success"
							onclick="escalarTime()">Confirmar</button></a>
					</div>
				</div>
			</div>
		</div>
		<div class=" col-sm-12 col-lg-8 col-xl-8">
            <div class="janelaT">

              <div class="tabelaT">

                <div class="table-responsive">
                  <table  cellpadding="5px" cellspacing="0" ID="alter" style= "text-align: center; width: 100%;">
                    <tr class="topo">
                      <th>Jogador</th>
                      <th>Nome</th>
                      <th>Posição</th>
                      <th>Curso</th>
                      <th><div class="botoesT"><a href='#'><button data-toggle="modal" data-target="#myModal" type="submit" class="btnL_cinza btn mb-2" onclick="escalarTime()">Escalar time</button></a></div></th>
                    </tr>
                    
		<%
			//Mostrar botão escalar e a tabela com os jogadores para poder escalar
				ArrayList<Jogador> v = new ArrayList();
				JogadorDAO jdao = new JogadorDAO();
				v = jdao.selectAll("ORDER BY (posicao)");
				jdao.closeDataBase();
				ArrayList<Curso> curso = new ArrayList();
				CursoDAO cdao = new CursoDAO();
				curso = cdao.selectAll();
				int c = 0;
				while (c < v.size()) {
					if(curso.get(v.get(c).getCursoJogador()).getEliminado() != 1){
						
                    	if(c % 2 == 1){
                    		out.println("<tr class='dif'>");	
                    	}else{
                    		out.println("<tr>");
                    	}
						String cursos = util.tratarPasta(cdao
								.selectAll("WHERE idCurso ='" + v.get(c).getCursoJogador() + "'").get(0).getNomeCurso());
						out.println("<td><img class='fotopequena rounded-circle' src='imagens/jogadores/" + cursos + "/"
								+ v.get(c).getImagem() + "'></td>");
						out.println("<td>" + v.get(c).getNomeJogador() + "</td>");
						out.println("<td>" + v.get(c).getPosicao() + "</td>");
						out.println("<td>" + curso.get(v.get(c).getCursoJogador() - 1).getNomeCurso() + "</td>");
						out.println("<td><div class='botoesT'><button class='botaoT btn mb-2' onclick=\"escalar('" + cursos + "/" + v.get(c).getImagem() + "', '"
								+ v.get(c).getPosicao() + "', '" + v.get(c).getIdJogador()
								+ "')\">Selecionar</button></div></td>");
						out.println("</tr>");	
					}
					c++;
				}
				cdao.closeDataBase();
				out.println("</table></div></div></div></div>");
			}
            
		%>
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
  <script>
		function escalar(caminho, pos, jogador) {

			if (pos == "Pivô") {
				document.getElementById("pivo").src = "imagens/jogadores/"
						+ caminho;
				document.getElementById("pivor").value = jogador
			} else if (pos == "Ala Direita") {
				document.getElementById("alad").src = "imagens/jogadores/"
						+ caminho;
				document.getElementById("aladr").value = jogador
			} else if (pos == "Ala Esquerda") {
				document.getElementById("alae").src = "imagens/jogadores/"
						+ caminho;
				document.getElementById("alaer").value = jogador
			} else if (pos == "Fixo") {
				document.getElementById("fixo").src = "imagens/jogadores/"
						+ caminho;
				document.getElementById("fixor").value = jogador
			} else if (pos == "Goleiro") {
				document.getElementById("goleiro").src = "imagens/jogadores/"
						+ caminho;
				document.getElementById("goleiror").value = jogador
			} else {
				document.getElementById("tecnico").src = "imagens/jogadores/"
						+ caminho;
				document.getElementById("tecnicor").value = jogador
			}
			//document.getElementById("jogador").value=jogador;]

		}

		function escalarTime() {

			usuario = document.getElementById("usuarior").value
			tecnico = document.getElementById("tecnicor").value
			goleiro = document.getElementById("goleiror").value
			fixo = document.getElementById("fixor").value
			alae = document.getElementById("alaer").value
			alad = document.getElementById("aladr").value
			pivo = document.getElementById("pivor").value

			$.get("Escalar?usuario=" + usuario + "&tecnico=" + tecnico
					+ "&goleiro=" + goleiro + "&fixo=" + fixo + "&alae=" + alae
					+ "&alad=" + alad + "&pivo=" + pivo, function(data) {
				//alert( "Data Loaded: " + data );
			});
		}
	</script>
	<% 
		if(idt != 0){
			out.println("<input type='hidden' name='tecnicor' id='tecnicor' value='"+idt+"'>");	
		}else{
			out.println("<input type='hidden' name='tecnicor' id='tecnicor'>");	
		}
		if(idg != 0){
			out.println("<input type='hidden' name='goleiror' id='goleiror' value='"+idg+"'>");	
		}else{
			out.println("<input type='hidden' name='goleiror' id='goleiror'>");	
		}
		if(idae != 0){
			out.println("<input type='hidden' name='alaer' id='alaer' value='"+idae+"'>");	
		}else{
			out.println("<input type='hidden' name='alaer' id='alaer'>");	
		}
		if(idad != 0){
			out.println("<input type='hidden' name='aladr' id='aladr' value='"+idad+"'>");	
		}else{
			out.println("<input type='hidden' name='aladr' id='aladr'>");	
		}
		if(idf != 0){
			out.println("<input type='hidden' name='fixor' id='fixor' value='"+idf+"'>");	
		}else{
			out.println("<input type='hidden' name='fixor' id='fixor'>");	
		}
		if(idp != 0){
			out.println("<input type='hidden' name='pivor' id='pivor' value='"+idp+"'>");	
		}else{
			out.println("<input type='hidden' name='pivor' id='pivor'>");	
		}
	%>
	<input type='hidden' name='usuarior' id='usuarior'
		value=<%out.println(u.getIdUsuario());%>>
</body>
</html>