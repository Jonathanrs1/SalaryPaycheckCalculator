var CalcService = {

	doCalc: function(salarioBruto, callback) {
		$.ajax({
		  url: 'CalcController',
		  data: {'salarioBruto': salarioBruto},
		  success: function(result) {
		  	callback(result);
		  },
		  error: function() {
		  	callback(null);
		  }
		});
	},
};