package framework.page;

import org.openqa.selenium.By;

import framework.base.BasePage;

public class PageCampoTreinamento extends BasePage{

	/********* GET ************/
	public String getResultadoCadastro() {
		return dsl.getTexts(By.xpath("//*[@id='resultado']/span"));
	}

	public String getCadNome() {
		return dsl.getTexts(By.xpath("//*[@id='descNome']/span"));
	}

	public String getCadSobrenome() {
		return dsl.getTexts(By.xpath("//*[@id='descSobrenome']/span"));
	}

	public String getCadSexo() {
		return dsl.getTexts(By.xpath("//*[@id='descSexo']/span"));
	}

	public String getCadComida() {
		return dsl.getTexts(By.xpath("//*[@id='descComida']/span"));
	}

	public String getCadEscolaridade() {
		return dsl.getTexts(By.xpath("//*[@id='descEscolaridade']/span"));
	}

	public String getCadEsportes() {
		return dsl.getTexts(By.xpath("//*[@id='descEsportes']/span"));
	}

	/********* SET ************/

	/********* TextField e TextArea ************/
	public void setNome(String nome) {
		dsl.write("elementosForm:nome", nome);
	}

	public void setSobrenome(String sobrenome) {
		dsl.write("elementosForm:sobrenome", sobrenome);
	}

	/********* Radio e Check ************/

	public void setSexoMasculino() {
		dsl.clickRadio("elementosForm:sexo:0");
	}

	public void setSexoFeminino() {
		dsl.clickRadio("elementosForm:sexo:1");
	}

	public void setComidaCarne() {
		dsl.clickButton("elementosForm:comidaFavorita:0");
	}

	public void setComidaFrango() {
		dsl.clickButton("elementosForm:comidaFavorita:1");
	}

	public void setComidaPizza() {
		dsl.clickButton("elementosForm:comidaFavorita:2");
	}

	public void setComidaVegetariano() {
		dsl.clickButton("elementosForm:comidaFavorita:3");
	}

	/********* Combo ************/

	public void setEscolaridade(String valor) {
		dsl.selectCombo("elementosForm:escolaridade", valor);
	}

	public void setEsporte(String... valores) {
		for (String valor : valores)
			dsl.selectCombo("elementosForm:esportes", valor);
	}

	/********* Botão ************/

	public void Cadastro() {
		dsl.clickButton("elementosForm:cadastrar");
	}

}
