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
	<title>CRUD Usu�rio</title>
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
              <div class="iconeMenu"><img src="imagens/icones/Home.png" height="30" width="30"><a href="PaginaInicial.jsp">In�cio</a></div>

              <hr style="height:1px; border:none; background-color:#F0F0F0;  margin-right: 10px; margin-left: 10px;"/>
              <div class="iconeMenu"><img src="imagens/icones/Perfil.png" height="30" width="30"><a href="MeuPerfil.jsp">Perfil</a></div>

              <hr style="height:1px; border:none; background-color:#F0F0F0;  margin-right: 10px; margin-left: 10px;"/>
              <div class="iconeMenu"><img src="imagens/icones/Ligas.png" height="30" width="30"><a href="Ligas.jsp">Ligas</a></div>

              <hr style="height:1px; border:none; background-color:#F0F0F0;  margin-right: 10px; margin-left: 10px;"/>
              <div class="iconeMenu"><img src="imagens/icones/Escalar.png" height="30" width="30"><a href="MostrarJogadores.jsp">Escala��o</a></div>

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
              O <b>Cartola IF</b> � um sistema de apostas, em que os usu�rios criam escala��es de jogadores e acumulam pontos em cada acerto, com base na avalia��o do CIF.<br><br>

              <b style="color: #1a1a1a; font-size: 25px;">Como altero minha senha?</b><br>
              Na aba "Perfil" voc� ter� acesso �s suas ligas, suas escala��es e poder� fazer altera��es em sua conta.<br><br>

              <b style="color: #1a1a1a; font-size: 25px;">Como escalo um time?</b><br>
              Na aba "Escala��o" voc� ter� acesso aos jogadores e suas pontua��es, podendo selecion�-los para sua escala��o, clicando no bot�o "Escalar Time".<br><br>

              <b style="color: #1a1a1a; font-size: 25px;">Como entro/crio uma liga?</b><br>
              Na aba "Ligas" voc� ter� acesso �s suas ligas, ver o nome e pontua��es dos usu�rios da liga, e poder� criar novas ligas.<br><br>

              <b style="color: #1a1a1a; font-size: 25px;">Como acompanho os jogos?</b><br>
              Na aba "Guia" voc� ter� informa��o de todos os jogos que ocorreram ou ainda v�o acontecer, e tamb�m visualizar o placar, local e hor�rio.
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Ok</button>
            </div>
          </div>
        </div>
      </div>

      <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="modalRodadaJ" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="modalRodadaJ"><b>Editar/Apagar</b></h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>

            <div class="modal-body">

              <b>Id: </b> <input type="text" class="caixaTxt" id="iduv"><br><br>
              <b>Nome Usu�rio: </b> <input type="text" class="caixaTxt" id="nuv"><br><br>
              <b>Login: </b> <input type="text" class="caixaTxt" id="luv"><br><br>
              <b>Senha: </b> <input type="text" class="caixaTxt" id="suv"><br><br>
              <b>Nome Time: </b> <input type="text" class="caixaTxt" id="ntuv"><br><br>
              <b>Nome Cartoleiro: </b> <input type="text" class="caixaTxt" id="ncuv"><br><br>

              <b>Curso Usu�rio: </b> <select class="caixaTxt" id="cuv">
                <option value="2">Edifica��es</option>
                <option value="6">Eletrot�cnica</option>
                <option value="1" selected>Inform�tica</option>
                <option value="4">Mec�nica</option>
                <option value="3">Qu�mica</option>
                <option value="5">Telecomunica��es</option>
              </select><br><br>

              <b>Tipo Usu�rio: </b> <select class="caixaTxt" id="idtuv">
                <option value="1">Adminstrador</option>
                <option value="2">Organizador</option>
                <option value="3">Comum</option>
              </select><br><br>
              
              <b>Email: </b> <input type="text" class="caixaTxt" id="ncemail"><br>




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

                <b>Nome Usu�rio: </b> <input type="text" class="caixaTxt" id="nomeusuario"><br><br>
                <b>Login: </b> <input type="text" class="caixaTxt" id="loginusuario"><br><br>
                <b>Senha: </b> <input type="text" class="caixaTxt" id="senhausuario"><br><br>

                <b>Curso Usu�rio: </b> <select class="caixaTxt" id="cursousuario">
                  <option value="2">Edifica��es</option>
                  <option value="6">Eletrot�cnica</option>
                  <option value="1" selected>Inform�tica</option>
                  <option value="4">Mec�nica</option>
                  <option value="3">Qu�mica</option>
                  <option value="5">Telecomunica��es</option>
                </select><br><br>

                <b>Tipo Usu�rio: </b> <select class="caixaTxt" id="tipousuario">
                  <option value="1">Adminstrador</option>
                  <option value="2">Organizador</option>
                  <option value="3">Comum</option>
                </select></br><br>

				<b>Email: </b> <input type="text" class="caixaTxt" id="emailusuario"><br>

              </div>

              <div class="rodapeCRUD">
                <a href=""><button type="button" class="btnL_vermelho btn btn-danger btn-block" onclick="inserir()" >Inserir</button></a>
              </div>


            </div>
          </div>


          <div class="container col-sm-12 col-lg-8 col-xl-7">
            <h2>EDITAR/APAGAR</h2>

            <div class="janelaT1">

              <div class="table-responsive">
                <table  cellpadding="5px" cellspacing="0" ID="alter" style= "text-align: center; width: 100%;">
                  <tr class="topo">
                    <th>ID</th>
                    <th>Usu�rio</th>
                    <th>Login</th>
                    <th>Senha</th>
                    <th>Time</th>
                    <th>Cartoleiro</th>
                    <th>Curso</th>
                    <th>Tipo</th>
                    <th>Email</th>
                  </tr>
				<%
					UsuarioDAO ud = new UsuarioDAO();
					ArrayList<Usuario> lu = ud.selectAll("order by (nomeUsuario)");
					ud.closeDataBase();
					CursoDAO cd = new CursoDAO();
					int c = 0;
					while(c < lu.size()){
						if(c % 2 == 1){
							out.println("<tr class='dif'>");
						}else{
							out.println("<tr>");
						}						
						out.println("<td>"+lu.get(c).getIdUsuario());
						out.println("<td>"+lu.get(c).getNomeUsuario()+"</td>");
						out.println("<td>"+lu.get(c).getLogin()+"</td>");
						out.println("<td>"+lu.get(c).getSenha()+"</td>");
						out.println("<td>"+lu.get(c).getNomeTime()+"</td>");
						out.println("<td>"+lu.get(c).getNomeCartoleiro()+"</td>");
						out.println("<td>"+cd.selectAll("WHERE idCurso = '"+lu.get(c).getCursoUsuario()+"'").get(0).getNomeCurso()+"</td>");
						out.println("<td>"+lu.get(c).getidTipoUsuario()+"</td>");
						out.println("<td>"+lu.get(c).getEmail()+"</td>");
						out.println("<input type='hidden' class='idu' value='"+lu.get(c).getIdUsuario()+"'>");
						out.println("<input type='hidden' class='nu' value='"+lu.get(c).getNomeUsuario()+"'>");
						out.println("<input type='hidden' class='lu' value='"+lu.get(c).getLogin()+"'>");
						out.println("<input type='hidden' class='su' value='"+lu.get(c).getSenha()+"'>");
						out.println("<input type='hidden' class='ntu' value='"+lu.get(c).getNomeTime()+"'>");
						out.println("<input type='hidden' class='ncu' value='"+lu.get(c).getNomeCartoleiro()+"'>");
						out.println("<input type='hidden' class='cu' value='"+lu.get(c).getCursoUsuario()+"'>");
						out.println("<input type='hidden' class='idtu' value='"+lu.get(c).getidTipoUsuario()+"'> ");
						out.println("<input type='hidden' class='ide' value='"+lu.get(c).getEmail()+"'> ");
						out.println("<td><button ontype='button' class='btn btn-primary' data-toggle='modal' data-target='#myModal' onclick=\"enviarModal('"+c+"')\">Editar/Apagar</button></td>");
						out.println("</tr>");
						c++;
					}
					cd.closeDataBase();
				%>
                  

                </table>
              </div>

              <hr style="height:2px; border:none; background-color:#DCDCDC; margin-top: 0px;  margin-bottom: 5px;"/>

              <div class="rodapeJanelaEscala">
                <a href="crud.jsp">OP��ES DE ADMIN</a>
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

  <script>
    function inserir(){
      var nomeusuario = document.getElementById("nomeusuario").value;
      var loginusuario = document.getElementById("loginusuario").value;
      var senhausuario = document.getElementById("senhausuario").value;
      var cursousuario = document.getElementById("cursousuario").value;
      var tipousuario = document.getElementById("tipousuario").value;
      var email = document.getElementById("emailusuario").value;
      $.get("Crud?opcao=5&operacao=1&nome="+nomeusuario+"&login="+loginusuario+"&curso="+cursousuario+"&tipousuario="+tipousuario+"&senha="+senhausuario+"&email="+email, function(data) {
        //alert( "Data Loaded: " + data );
      });
    }
    
    function enviarModal(indice){ 
      var nu = document.getElementsByClassName("nu");
      var lu = document.getElementsByClassName("lu");
      var su = document.getElementsByClassName("su");
      var nt = document.getElementsByClassName("ntu");
      var nc = document.getElementsByClassName("ncu");
      var id = document.getElementsByClassName("idu");
      var cu = document.getElementsByClassName("cu");
      var idt = document.getElementsByClassName("idtu");
      var nce = document.getElementsByClassName("ide");
      document.getElementById("nuv").value = nu[indice].value;
      document.getElementById("luv").value = lu[indice].value;
      document.getElementById("suv").value = su[indice].value;
      document.getElementById("ntuv").value = nt[indice].value;
      document.getElementById("ncuv").value = nc[indice].value;
      document.getElementById("iduv").value = id[indice].value;
      document.getElementById("cuv").value = cu[indice].value;
      document.getElementById("idtuv").value = idt[indice].value;
      document.getElementById("ncemail").value = nce[indice].value;
    }
    
    function editar(){
      var nu = document.getElementById("nuv").value;
      var lu = document.getElementById("luv").value;
      var su = document.getElementById("suv").value;
      var nt = document.getElementById("ntuv").value;
      var nc = document.getElementById("ncuv").value;
      var id = document.getElementById("iduv").value;
      var cu = document.getElementById("cuv").value;
      var idt = document.getElementById("idtuv").value;
      var email = document.getElementById("ncemail").value;
      $.get("Crud?opcao=5&operacao=2&nome="+nu+"&login="+lu+"&curso="+cu+"&tipousuario="+idt+"&nometime="+nt+"&nomecartoleiro="+nc+"&id="+id+"&senha="+su+"&email="+email, function(data) {
          //alert( "Data Loaded: " + data );
        });
    }
    
    function apagar(){
      var id = document.getElementById("iduv").value;
      $.get("Crud?opcao=5&operacao=3&id="+id, function(data) {
          //alert( "Data Loaded: " + data );
        });
    }
  </script>
</body>
</html>