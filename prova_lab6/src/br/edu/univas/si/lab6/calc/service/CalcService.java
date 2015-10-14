package br.edu.univas.si.lab6.calc.service;

import br.edu.univas.si.lab6.calc.to.ValoresTO;

public class CalcService {

	public ValoresTO doCalc(float salarioBruto){
		ValoresTO vto = new ValoresTO();
		float salarioSemInss = 0;
		float inss = getDescontoInss(salarioBruto);
		
		inss = Math.round(inss * 100)/100.f;
		
		salarioSemInss = salarioBruto - inss;
		double irpf = getDescontoIrpf(salarioSemInss);
		
		vto.setInss(inss);
		vto.setIrpf(Math.round(irpf * 100 )/100.f);
		vto.setLiquidSalary(Math.round((salarioBruto - inss - irpf) * 100) /100.f);
		
		return vto;
	}
	
	public float getDescontoInss(float salarioBruto){
		if(salarioBruto <= 1399.12){
			return salarioBruto * 0.08f;
		}else if(salarioBruto >= 1399.13 && salarioBruto <= 2331.88){
			return salarioBruto * 0.09f;
		}else if(salarioBruto >= 2331.89 && salarioBruto <= 4663.75){
			return salarioBruto * 0.11f;
		}else{
			return 513.02f;
		}
	}
	
	public double getDescontoIrpf(float salarioBruto){
		double aliquota = 0.0f;
		
		if(salarioBruto <= 1903.98){
			return 0.0f;
		}else if(salarioBruto >= 1903.99 && salarioBruto <= 2826.65){
			aliquota =  (salarioBruto * 0.075);
			return aliquota =  (aliquota - 142.80);
		}else if(salarioBruto >= 2826.66 && salarioBruto <= 3751.05){
			aliquota = (salarioBruto * 0.15);
			return aliquota = (aliquota - 354.80);
		}else if(salarioBruto >= 3751.06 && salarioBruto <= 4664.68){
			aliquota =  (salarioBruto * 0.225);
			return aliquota =  (aliquota - 636.13);
		}else{
			aliquota = (salarioBruto * 0.275);
			return aliquota =  (aliquota - 869.36);
		}
	}
}
