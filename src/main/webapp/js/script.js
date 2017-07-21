appCad.controller('appctrl', ['$scope', '$http', function($scope, $http, $location) {
	
$scope.contato = {};
var urlContato = 'appAgenda/contatos';

	$scope.carregarDados = function() {
				
		$http({
			method: 'GET',
			url: urlContato
		}).then(function successCallback(response) {
			$scope.contatos = response.data;
			if (!Array.isArray($scope.contatos)) {
				$scope.contatos = [$scope.contato];
			}		
		  }, function errorCallback(response) {
			  alert("response");
		       console.log(response);
		});
		
	} // FIM CARREGAR DADOS
	$scope.carregarDados(); //CHAMA CARREGAMENTO


	$scope.validacao = function(){
		var inputNome = document.getElementById("inputNome").value;
		var inputCelular = document.getElementById("inputCellphone").value;
		var inputResidencial = document.getElementById("inputPhone").value;
		var inputEmail = document.getElementById("inputEmail").value;
		
		if ((inputNome == "") || (inputCelular == "") || (inputEmail == "")) {
			return false;
		} else {
			return true;
		}
	}

	$scope.salvar = function(contato) {
		
		contato.telefoneResidencial = $('#inputPhone').val();
		contato.telefoneCelular = $('#inputCellphone').val();

		if ($scope.validacao()) {
			$http({
				method: 'POST',
				url: urlContato,
				data: JSON.stringify(contato),
				headers : {'Content-Type' : 'application/json'}
			}).then(function successCallback(response) {
			    $scope.contato = {};	
			    alert("Contato salvo com sucesso");	    
			  }, function errorCallback(response) {
			       console.log(response);
			});
			
		} else {
			alert("Verifique se os dados foram preenchidos corretamente!");
		}
		
	} // FIM SALVAR CONTATO
	
	
	$scope.excluir = function(contato){
		var status = confirm("Realmente deseja excluir esse contato? ");
		
		if (status) {
			$http({
				method: 'DELETE',
				url: urlContato + "/" + contato.id
			}).then(function successCallback(response) {
				$scope.carregarDados(); 
				alert("Contato excluido com sucesso");
			  }, function errorCallback(response) {
				  alert("Ops! Ocorreu um erro... ");
			      console.log(response);
			});
		}
	} // FIM DELETAR CONTATO
	
	
	$scope.cancelar = function() {
		$scope.contato = {};
		 window.location = "/appAgenda/home.html";
	} // FIM CANCELAR CADASTRO
	
	
	$scope.addContato = function(){
		 window.location = "/appAgenda/addContato.html";
	} // FIM REDIRECIONAMENTO PARA ADDCONTATO.HTML
	
		
	$scope.editar = function(contato){
		window.location = 'http://localhost:8080/appAgenda/editarContato.html' + "?id=" + contato.id;
	} // FIM CONCLUIR EDITAR CONTATO (GET ID)
	
	
	$scope.concluirEdicao = function() {
		var local = location.href;
		var id = local.slice(-1);
		id = parseInt(id, 10);  
		//alert(id);
		
		$http({
			method: 'GET',
			url: urlContato
		}).then(function successCallback(response) {
			 console.log(response);
		  }, function errorCallback(response) {
		      console.log(response);
		  });
	}
		$scope.concluirEdicao();
		
		
	$scope.carregarDadosEdicao = function() {
		var id = parseInt(location.href.slice(-1), 10);
			$http({
				method: 'GET',
				url: urlContato + "/" + id
			}).then(function successCallback(response) {
				$scope.contato = response.data;	
			  }, function errorCallback(response) {
			       console.log(response);
			});
			
	} // FIM CARREGAR DADOS
		$scope.carregarDadosEdicao(); //CHAMA CARREGAMENTO DE EDICAO
		
	$scope.salvarEdicao = function(contato) {
			
			contato.telefoneResidencial = $('#inputPhone').val();
			contato.telefoneCelular = $('#inputCellphone').val();

		if ($scope.validacao()) {
				$http({
					method: 'PUT',
					url:  urlContato + "/" + contato.id,
					data: JSON.stringify(contato),
					headers : {'Content-Type' : 'application/json'}
				}).then(function successCallback(response) {
				    alert("Contato salvo com sucesso");	 
					 window.location = "/appAgenda/home.html";
				  }, function errorCallback(response) {
				       console.log(response);
				});
				
			} else {
				alert("Verifique se os dados foram preenchidos corretamente!");
			}
			
		} // FIM SALVAR CONTATO
	
}]);