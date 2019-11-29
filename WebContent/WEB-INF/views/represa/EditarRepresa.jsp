<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Editar Represa</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Editar Represa</h3>
		<!-- Formulario para alteração de pessoas -->
		<form action="editar_represa" method="post">
			<!-- area de campos do form -->
			<input type="hidden" name="id" value="${ represa.id }" />
			<div class="row">
				<div class="form-group col-md-6">
					<label for="nome">Id</label> <input type="text"
						class="form-control" name="id" id="id" required maxlength="100"
						placeholder="Id" value="${ represa.id }" disabled>
				</div>
				<div class="form-group col-md-6">
					<label for="nome">Indice1</label> <input type="text"
						class="form-control" name="calcIndice1" id="calcIndice1" required maxlength="100"
						placeholder="Indice1" value="${ represa.calcIndice1 }" disabled>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="nome">Indice2</label> <input type="text"
						class="form-control" name="calcIndice2" id="calcIndice2" required maxlength="100"
						placeholder="Indice2" value="${ represa.calcIndice2 }" disabled>
				</div>
				<div class="form-group col-md-6">
					<label for="nome">Indice3</label> <input type="text"
						class="form-control" name="calcIndice3" id="calcIndice3" required maxlength="100"
						placeholder="calcIndice3" value="${ represa.calcIndice3 }" disabled>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="nome">Nome</label> <input type="text"
						class="form-control" name="nome" id="nome"
						value="${represa.nome }" required maxlength="100"
						placeholder="Nome">
				</div>

				<div class="form-group col-md-6">
					<label for="nome">Volume Útil</label> <input type="number"
						step="0.010" class="form-control" name="volumeUtil"
						id="volumeUtil" value="${represa.volumeUtil }" required
						maxlength="100" placeholder="Volume Útil">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="nome">Volume Reserva tecnica</label> <input
						type="number" step="0.010" class="form-control"
						name="volumeReservaTecnica" id="volumeReservaTecnica"
						value="${represa.volumeReservaTecnica }" required maxlength="100"
						placeholder="Volume Reserva">
				</div>

				<div class="form-group col-md-6">
					<label for="nome">Volume Armazenado</label> <input type="number"
						step="0.010" class="form-control" name="volumeArmazenado"
						id="volumeArmazenado" value="${represa.volumeArmazenado }"
						required maxlength="100" placeholder="Volume Armazenado">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="nome">Sistema a qual pertence</label> <input
						type="text" step="0.010" class="form-control"
						name="sistemaPertencente" id="sistemaPertencente"
						value="${represa.sistemaPertencente }" required maxlength="100"
						placeholder="Volume Reserva">
				</div>

				<div class="form-group col-md-6">
					<label for="nome">Data de cadastro</label> <input type="text"
						step="0.010" class="form-control" name="dataAbertura"
						id="dataAbertura" value="${represa.dataAbertura }"
						placeholder="Digitar valor dd-MM-yyyy">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="nome">Pluviometria do dia anterior</label> <input
						type="text" step="0.010" class="form-control"
						name="pluviometriaDiaAnterior" id="pluviometriaDiaAnterior"
						value="${represa.pluviometriaDiaAnterior }" required maxlength="100"
						placeholder="Volume Reserva">
				</div>
			</div>
			<!-- 
            			<div class="row">
                			<div class="form-group col-md-6">
                    			<label for="telefone">Preço</label>
                    			<input type="number" class="form-control" name="preco" id="preco" required maxlength="17" value="${ produto.preco }">
                			</div>
						</div>
						 -->
			<hr />
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary" name="command"
						value="EditarRepresa">Salvar</button>
					<a href="listar_represas" class="btn btn-default">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>