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
	<title>CRUD Jogos</title>
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

      <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="modalJogos" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="modalJogos"><b>Editar/Apagar</b></h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>

            <div class="modal-body">
              <b>Id: </b> <input type="text" class="caixaTxt" id="idv"><br><br>

              <b>Curso 1: </b> <select class="caixaTxt" id="cv">
                <option value="2">Edificações</option>
                <option value="6">Eletrotécnica</option>
                <option value="1" selected>Informática</option>
                <option value="4">Mecânica</option>
                <option value="3">Química</option>
                <option value="5">Telecomunicações</option>
              </select><br><br>

              <b>Curso 2: </b> <select class="caixaTxt" id="ccv">
                <option value="2">Edificações</option>
                <option value="6">Eletrotécnica</option>
                <option value="1" selected>Informática</option>
                <option value="4">Mecânica</option>
                <option value="3">Química</option>
                <option value="5">Telecomunicações</option>
              </select><br><br>

              <b>Placar do Curso 1: </b> <input type="text" class="caixaTxt" id="pcv"><br><br>
              <b>Placar do Curso 2: </b> <input type="text" class="caixaTxt" id="pccv"><br><br>
              <b>Localização: </b> <input type="text" class="caixaTxt" id="localizacaov"><br><br>
              <b>Data/hora: </b> <input type="text" class="caixaTxt" id="datahorav"><br><br>

              <b>Rodada: </b> <%
				RodadaDAO rd = new RodadaDAO();
				ArrayList<Rodada> lr = rd.selectAll("order by (idRodada)");
				int c = 0;
				out.println("<select class=\"caixaTxt\" id=\"rdd\" name=\"rdd\">");
				while(c < lr.size()){
					out.println("<option value=\""+lr.get(c).getIdRodada()+"\">"+lr.get(c).getNomeRodada()+"</option>");
					
					c++;
				}
				out.println("</select>");
				%></br>



              
            </div>

            <div class="modal-footer">
              <button type="button" class="btnL_cinza btn btn-secondary" data-dismiss="modal">Fechar</button>
              <a href=""><button type="button" class="btnL_verde btn btn-primary" onclick="editar()">Editar</button></a>
              <a href=""><button type="button" class="btnL_vermelho btn btn-danger" onclick="apagar()">Apagar</button></a>
            </div>

          </div>
        </div>
      </div>


      <div class="container-fixed janelas">
        <div class="row">

          <div class="container col-sm-12 col-lg-8 col-xl-7">
            <h2>INSERIR</h2>
            <div class="janelaCRUD">
              <div class="CRUDdentro">
                <b>Curso 1: </b> <select class="caixaTxt" id="curso1" name="curso1">
                  <option value="2">Edificações</option>
                  <option value="6">Eletrotécnica</option>
                  <option value="1" selected>Informática</option>
                  <option value="4">Mecânica</option>
                  <option value="3">Química</option>
                  <option value="5">Telecomunicações</option>
                </select><br><br>
                
                <b>Curso 2: <select class="caixaTxt" id="curso2" name="curso2">
                  <option value="2">Edificações</option>
                  <option value="6">Eletrotécnica</option>
                  <option value="1" selected>Informática</option>
                  <option value="4">Mecânica</option>
                  <option value="3">Química</option>
                  <option value="5">Telecomunicações</option>
                </select><br><br>
                
                <b>Placar do Curso 1: </b> <input type="text" class="caixaTxt" id="placarc1"><br><br>
                <b>Placar do Curso 2: </b> <input type="text" class="caixaTxt" id="placarc2"><br><br>
                <b>Localização:  </b>  <input type="text" class="caixaTxt" id="local"><br><br>
                <b>Data/hora:  </b> <input type="text" class="caixaTxt" id="dh"><br><br>
                <b>Rodada:  </b> <%
				c = 0;
				out.println("<select class=\"caixaTxt\" id=\"idRodadav\" name=\"rodada\">");
				while(c < lr.size()){
					out.println("<option value="+lr.get(c).getIdRodada()+">"+lr.get(c).getNomeRodada()+"</option>");
					c++;
				}
				out.println("</select>");
				%></b>


              </div>

              <div class="rodapeCRUD">
                <a href=""><button type="button" class="btnL_vermelho btn btn-danger btn-block" onclick="inserirJogo()" >Inserir</button></a>
              </div>


            </div>
          </div>




          <div class="container col-sm-12 col-lg-8 col-xl-7">
            <h2>EDITAR/APAGAR</h2>
			
            <div class="janelaT1">

              <div class="table-responsive">
                <table  cellpadding="5px" cellspacing="0" ID="alter" style= "text-align: center; width: 100%;">
                  <tr class="topo">
                    <th>Curso 1</th>
                    <th>Placar</th>
                    <th>Curso 2</th>
                    <th>Local/Data e hora</th>
                    <th>Rodada</th>
                    <th></th>
                  </tr>
				<%
					
					
					
				%>
				<%
		JogosDAO jd = new JogosDAO();
		ArrayList<Jogos> lj = jd.selectAll("order by (idJogo)");
		c = 0;
		CursoDAO cd = new CursoDAO();
		while(c < lj.size()){
			if(c % 2 == 1){
				out.println("<tr class='dif'>");
			}else{
				out.println("<tr>");
			}
			out.println("<td>"+cd.selectAll("WHERE idCurso = '"+lj.get(c).getCurso1()+"'").get(0).getNomeCurso()+"</td>");
			out.println("<td>"+lj.get(c).getPlacarCurso1()+" X ");
			out.println(lj.get(c).getPlacarCurso2()+"</td>");
			out.println("<td>"+cd.selectAll("WHERE idCurso = '"+lj.get(c).getCurso2()+"'").get(0).getNomeCurso()+"</td>");
			out.println("<td>"+lj.get(c).getLocalizacao());
			out.println(" / "+lj.get(c).getDatahora()+"</td>");
			out.println("<td>"+rd.selectAll("WHERE idRodada = '"+lj.get(c).getIdRodada()+"'").get(0).getNomeRodada()+"</td>");
			out.println("<input type='hidden' class='c' value='"+lj.get(c).getCurso1()+"'>");
			out.println("<input type='hidden' class='cc' value='"+lj.get(c).getCurso2()+"'>");
			out.println("<input type='hidden' class='pc' value='"+lj.get(c).getPlacarCurso1()+"'>");
			out.println("<input type='hidden' class='pcc' value='"+lj.get(c).getPlacarCurso2()+"'>");
			out.println("<input type='hidden' class='id' value='"+lj.get(c).getIdJogo()+"'>");
			out.println("<input type='hidden' class='localizacao' value='"+lj.get(c).getLocalizacao()+"'>");
			out.println("<input type='hidden' class='datahora' value='"+lj.get(c).getDatahora()+"'>");
			out.println("<input type='hidden' class='idRodada' value='"+lj.get(c).getIdRodada()+"'>");
			out.println("<td><button ontype='button' class='btn btn-primary' data-toggle='modal' data-target='#myModal' onclick=\"enviarModal('"+c+"')\">Editar/Apagar</button></td>");
			out.println("</tr>");
			c++;
		}
		rd.closeDataBase();
	%>        
                </table>
              </div>

              <input type='hidden' class='c' value='2'>
              <input type='hidden' class='cc' value='6'>
              <input type='hidden' class='pc' value='2'>
              <input type='hidden' class='pcc' value='3'>
              <input type='hidden' class='id' value='0'>
              <input type='hidden' class='localizacao' value='Quadra do IFCE - Campus Fortaleza'>
              <input type='hidden' class='datahora' value='11/06/2018 as 10:00hrs'>
              <input type='hidden' class='idRodada' value='2'>

              <hr style="height:2px; border:none; background-color:#DCDCDC; margin-top: 0px;  margin-bottom: 5px;"/>

              <div class="rodapeJanelaEscala">
                <a href="crud.jsp">OPÇÕES DE ADMIN</a>
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

  <script>
    function inserirJogo(){
      var curso1 = document.getElementById("curso1").value;
        //alert(curso1);
      var curso2 = document.getElementById("curso2").value;
        //alert(curso2);
      var placar1 = document.getElementById("placarc1").value;
        //alert(placar1);
      var placar2 = document.getElementById("placarc2").value;
      //alert(placar2);
      var local = document.getElementById("local").value;
      //alert(local);
      var dh = document.getElementById("dh").value;
      //alert(dh);
      var rodada = document.getElementById("idRodadav").value;
      //alert(rodada);
      $.get("Crud?opcao=3&operacao=1&curso1="+curso1+"&curso2="+curso2+"&placar1="+placar1+"&placar2="+placar2+"&local="+local+"&dh="+dh+"&rodada="+rodada, function(data) {
        //alert( "Data Loaded: " + data );
      });
    }

    function enviarModal(indice){ 

      var id = document.getElementsByClassName("id");
      document.getElementById("idv").value = id[indice].value;

      var c1 = document.getElementsByClassName("c");
      document.getElementById("cv").value = c1[indice].value;

      var c2 = document.getElementsByClassName("cc");
      document.getElementById("ccv").value = c2[indice].value;

      var pc1 = document.getElementsByClassName("pc");
      document.getElementById("pcv").value = pc1[indice].value;

      var pc2 = document.getElementsByClassName("pcc");
      document.getElementById("pccv").value = pc2[indice].value;

      var localizacao = document.getElementsByClassName("localizacao");
      document.getElementById("localizacaov").value = localizacao[indice].value;

      var datahora = document.getElementsByClassName("datahora");
      document.getElementById("datahorav").value = datahora[indice].value;

      var idRodada = document.getElementsByClassName("idRodada");
      document.getElementById("idRodadav").value = idRodada[indice].value;

    }

    function editar(){
      var idJogo = document.getElementById("idv").value;
      var curso1 = document.getElementById("cv").value;
      var curso2 = document.getElementById("ccv").value;
      var placar1 = document.getElementById("pcv").value;
      var placar2 = document.getElementById("pccv").value;
      var localizacao = document.getElementById("localizacaov").value;
      var datahora = document.getElementById("datahorav").value;
      var idRodada = document.getElementById("rdd").value;
      $.get("Crud?opcao=3&operacao=2&idJogo="+idJogo+"&curso1="+curso1+"&curso2="+curso2+"&placar1="+placar1+"&placar2="+placar2+"&localizacao="+localizacao+"&datahora="+datahora+"&rodada="+idRodada, function(data) {
        //alert( "Data Loaded: " + data );
      });
    }

    function apagar(id){
      var idJogo = document.getElementById("idv").value;
      $.get("Crud?opcao=3&operacao=3&idJogo="+idJogo, function(data) {
          //alert( "Data Loaded: " + data );
        });
    }
  </script>
</body>
</html>