<%@page import="model.*"%>
<%@page import="dao.*"%>
<%@page import="util.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
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
<title>Minha Escalação | CIF</title>
</head>
<body>
	<%
		// Não esquecer de botar a pontuação de cada jogador!
		Usuario u = (Usuario) session.getAttribute("usuario");
		int rodada = Integer.parseInt(request.getParameter("rodada"));
		RodadaDAO rd = new RodadaDAO();
		String nomeRodada = rd.selectAll("WHERE idRodada = '"+rodada+"'").get(0).getNomeRodada();
		UsuarioDAO ud = new UsuarioDAO();
        ArrayList<Top> lista = ud.timeRodada(u.getIdUsuario(), rodada);
        Top tecnico = null;
        Top goleiro = null;
        Top fixo = null;
        Top alae = null;
        Top alad = null;
        Top pivo = null;
        if(lista.size() != 0){
            CursoDAO cd = new CursoDAO();
            Util util = new Util();
            int c = 0;
            while(c < lista.size()){
                String cursos = cd.selectAll("WHERE idCurso = '"+lista.get(c).getIdGuambiarra()+"'").get(0).getNomeCurso();
                String caminho = util.tratarPasta(cursos)+"/"+lista.get(c).getNome();
                if(lista.get(c).getNomeTime().equals("Técnico")){
                    tecnico = new Top(caminho, lista.get(c).getNomeTime(),lista.get(c).getPontuacao());
                }else if(lista.get(c).getNomeTime().equals("Goleiro")){
                    goleiro = new Top(caminho, lista.get(c).getNomeTime(),lista.get(c).getPontuacao());
                }else if(lista.get(c).getNomeTime().equals("Fixo")){
                    fixo = new Top(caminho, lista.get(c).getNomeTime(),lista.get(c).getPontuacao());
                }else if(lista.get(c).getNomeTime().equals("Ala Esquerda")){
                    alae = new Top(caminho, lista.get(c).getNomeTime(),lista.get(c).getPontuacao());
                }else if(lista.get(c).getNomeTime().equals("Ala Direita")){
                    alad = new Top(caminho, lista.get(c).getNomeTime(),lista.get(c).getPontuacao());
                }else if(lista.get(c).getNomeTime().equals("Pivô")){
                    pivo = new Top(caminho, lista.get(c).getNomeTime(),lista.get(c).getPontuacao());
                }
                c++;
            }
            if(tecnico == null){
                tecnico = new Top("dafault.png", 0);
            }
            if(goleiro == null){
                goleiro = new Top("default.png", 0);
            }
            if(fixo == null){
                fixo = new Top("default.png", 0);
            }
            if(alae == null){
                alae = new Top("default.png", 0);
            }
            if(alad == null){
                alad = new Top("default.png", 0);
            }
            if(pivo == null){
                pivo = new Top("default.png", 0);
            }
            ud.closeDataBase();
            cd.closeDataBase();
        }else{
            //O usuário não escalou niguém na rodada!
            tecnico = new Top("default.png", 0);
            goleiro = new Top("default.png", 0);
            fixo = new Top("default.png", 0);
            alae = new Top("default.png", 0);
            alad = new Top("default.png", 0);
            pivo = new Top("default.png", 0);
        }
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
      <div class="container-fixed janelas">
        <div class="row">
          <div class="container col-sm-12 col-lg-8 col-xl-6">
            <h2><%out.println(nomeRodada);%></h2>

            <div class="janelaT1">

              <div class="table-responsive">
                <table  cellpadding="5px" cellspacing="0" ID="alter" style= "text-align: center; width: 100%;">
                  <tr class="topo">
                    <th>Jogador</th>
                    
                    <th>Posição</th>
                    <th>Pontuação</th>
                  </tr>

				<tr class="dif">
                	<td><img class='fotoTabela img-fluid' alt= "Responsive image" src="imagens/jogadores/<%out.println(pivo.getNome());%>"></td>
                	<td><%out.println(pivo.getNomeTime());%></td>
                	<td><%out.println(pivo.getPontuacao());%></td>

				</tr>
					
				<tr>
                 	<td><img class='fotoTabela img-fluid' alt= "Responsive image" src="imagens/jogadores/<%out.println(alae.getNome());%>"></td>
                	<td><%out.println(alae.getNomeTime());%></td>
                	<td><%out.println(alae.getPontuacao());%></td> 
				</tr>
				
				<tr class="dif">
                 	<td><img class='fotoTabela img-fluid' alt= "Responsive image" src="imagens/jogadores/<%out.println(alad.getNome());%>"></td>
                	<td><%out.println(alad.getNomeTime());%></td>
                	<td><%out.println(alad.getPontuacao());%></td> 
				</tr>
				
				<tr>
                 	<td><img class='fotoTabela img-fluid' alt= "Responsive image" src="imagens/jogadores/<%out.println(fixo.getNome());%>"></td>
                	<td><%out.println(fixo.getNomeTime());%></td>
                	<td><%out.println(fixo.getPontuacao());%></td>
				</tr>
				
				<tr class="dif">
                	<td><img class='fotoTabela img-fluid' alt= "Responsive image" src="imagens/jogadores/<%out.println(goleiro.getNome());%>"></td>
                	<td><%out.println(goleiro.getNomeTime());%></td>
                	<td><%out.println(goleiro.getPontuacao());%></td>
				</tr>
				
				<tr>
                	<td><img class='fotoTabela img-fluid' alt= "Responsive image" src="imagens/jogadores/<%out.println(tecnico.getNome());%>"></td>
                	<td><%out.println(tecnico.getNomeTime());%></td>
                	<td><%out.println(tecnico.getPontuacao());%></td>  
				</tr>
				
                </table>
              </div>

              <hr style="height:2px; border:none; background-color:#DCDCDC; margin-top: 0px;  margin-bottom: 5px;"/>

              <div class="rodapeJanelaEscala">
                <a href="MeuPerfil.jsp">VOLTAR PARA PERFIL</a>
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