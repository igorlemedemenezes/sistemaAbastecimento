<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cadastrar Represa</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp"/>
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Cadastrar Represa</h3>
        <!-- Formulario para inclusao de clientes -->
        <form action="nova_represa" method="post">
            <!-- area de campos do form -->
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="nome">Nome</label>
                    <input type="text" class="form-control" name="nome" id="nome" required maxlength="100" placeholder="Nome">
                </div>
            
                <div class="form-group col-md-6">
                    <label for="nome">Volume Útil</label>
                    <input type="number"  step="0.010" class="form-control" name="volumeUtil" id="volumeUtil" required maxlength="100" placeholder="Volume Útil">
                </div>
            </div>    
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="nome">Volume Reserva tecnica</label>
                    <input type="number"  step="0.010" class="form-control" name="volumeReservaTecnica" id="volumeReservaTecnica" required maxlength="100" placeholder="Volume Reserva">
                </div>
            
                <div class="form-group col-md-6">
                    <label for="nome">Volume Armazenado</label>
                    <input type="number"  step="0.010" class="form-control" name="volumeArmazenado" id="volumeArmazenado" required maxlength="100" placeholder="Volume Armazenado">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="nome">Sistema a qual pertence</label>
                    <input type="text"  step="0.010" class="form-control" name="sistemaPertencente" id="sistemaPertencente" required maxlength="100" placeholder="Volume Reserva">
                </div>
            
                <div class="form-group col-md-6">
                    <label for="nome">Data de cadastro</label>
                    <input type="text"  step="0.010" class="form-control" name="dataAbertura" id="dataAbertura" placeholder="Digitar valor dd-MM-yyyy">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="nome">Pluviometria do dia anterior</label>
                    <input type="text"  step="0.010" class="form-control" name="pluviometriaDiaAnterior" id="pluviometriaDiaAnterior" required maxlength="100" placeholder="Volume pluviometria">
                </div>
            </div>
            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="command" value="novaRepresa">Salvar</button>
                    <a href="listar_represas" class="btn btn-default">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
</body>

</html>