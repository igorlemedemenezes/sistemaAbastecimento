<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Represas</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Represa(s)</h3>
		<div class="row">
			<form  action="buscar_data" method="get">
				<div class="form-group col-md-5">
					<label>Listar por Data</label> <input 
						name="dataAbertura" class="form-control" id="dataAbertura" type="text" 
						required maxlength="100" value="${represa.dataAbertura }"
						placeholder="Nome"> <!-- <input type="text"
						class="form-control" name="nome" id="nome" id="${represa.nome}"
						required maxlength="100" placeholder="Nome"> -->
					<button type="submit" class="btn btn-primary" name="command"
						value="buscar_data">data</button>
				</div>
			</form>
		</div>
		<c:if test="${not empty represas}">
			<div class="table-responsive col-md-12">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>ID</th>
							<th>Nome</th>
							<th>Volume Útil</th>
							<th>Calc indice1</th> 
							<th>Calc indice2</th> 
							<th>Calc indice3</th> 
							<th>Data</th>
							<th>Sistema a qual pertence</th>
							<th class="actions">Ações</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="represa" items="${ represas }">
							<form action="visualizar_represa" method="get">
								<tr>
									<td>${ represa.id }</td>
									<td>${ represa.nome }</td>
									<td>${ represa.volumeUtil }</td>
									<td>${ represa.calcIndice1 } %</td>
									<td>${ represa.calcIndice2 } %</td>
									<td>${ represa.calcIndice3 } %</td>
									<td>${ represa.dataAbertura }</td>
									<td>${ represa.sistemaPertencente }</td>
									<td class="actions">

										<button name="id" value="${ represa.id }"
											class="btn btn-success btn-xs">Visualizar</button>

										<button name="id" formaction="editar_represa_pesquisa"
											value="${ represa.id }" class="btn btn-warning btn-xs">Editar</button>

										<button name="id" formaction="excluir_represa"
											value="${ represa.id }" class="btn btn-danger btn-xs">Excluir</button>

										<button name="id" formaction="relatorio_represa"
											value="${ represa.id }" class="btn btn-light btn-xs">Relatorio</button>

									</td>
								</tr>
							</form>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:if>
		<c:if test="${empty represas}">
			<div class="alert alert-info" role="alert">N&atilde;o h&aacute;
				represas nesta lista.</div>
		</c:if>
		<a href="index" class="btn btn-default">Voltar</a>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>