var CalcController = {
	
	init: function() {
		CalcController.setForm();
	},
	
	setForm: function() {
		var form = document.querySelector('form');
		form.addEventListener('submit', function(event) {
			CalcController.calculateSalary(form);
			//it is necessary to avoid form submition
			event.preventDefault();
		});
	},
	
	calculateSalary: function(form) {
		var 
			salarioBruto = parseFloat(form.salaryInput.value),
			result = null;
		
		var callback = function(result) {
			CalcController.showResult(result);			
		};
		
		CalcService.doCalc(salarioBruto, callback);
	},
	
	showResult: function(result) {
		var resultInss = document.querySelector('.resultInss');
		var resultIrpf = document.querySelector('.resultIrpf');
		var resultLiquidSalary = document.querySelector('.resultLiquidSalary');
		
		var resultJson = JSON.parse(result);
		
		resultInss.innerHTML = 'R$ '+resultJson.inss;
		resultIrpf.innerHTML = 'R$ '+resultJson.irpf;
		resultLiquidSalary.innerHTML = 'R$ '+resultJson.liquidSalary;
	}

};

//initialization
CalcController.init();
