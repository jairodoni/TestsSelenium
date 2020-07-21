package framework.base;

import static framework.base.Drivers.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {

	/********* TextField e TextArea ************/

	public void write(By by, String texto) {
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);
	}

	public void write(String id_campo, String texto) {
		write(By.id(id_campo), texto);
	}

	public String getValue(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).getAttribute("value");
	}

	/********* Radio e Check ************/

	public void clickRadio(By by) {
		getDriver().findElement(by).click();
	}
	public void clickRadio(String id) {
		clickRadio(By.id(id));
	}

	public boolean isRadioMarked(String id) {
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
	public void clickCheck(String id) {
		getDriver().findElement(By.id(id)).click();
	}
	
	public boolean isCheckMarked(String id){
		return getDriver().findElement(By.id(id)).isSelected();
	}

	/********* Combo ************/

	public void selectCombo(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}

	public void deselectCombo(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}

	public String getValueCombo(String id) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}

	public List<String> getValuesCombo(String id) {
		WebElement element = getDriver().findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		for (WebElement opcao : allSelectedOptions) {
			valores.add(opcao.getText());
		}
		return valores;
	}

	
	public void selectComboPrime(String nice, String valor) {
		clickRadio(By.xpath("//*[@id='"+nice+"_input']/../..//span"));
		clickRadio(By.xpath("//*[@id='"+nice+"_items']//li[.='"+valor+"']"));
	}
	/********* Botão ************/

	public void clickButton(String id) {
		getDriver().findElement(By.id(id)).click();
	}

	public String getValueElementButton(String id) {
		return getDriver().findElement(By.id(id)).getAttribute("value");
	}

	/********* Link ************/

	public void clickLink(String id) {
		getDriver().findElement(By.linkText(id)).click();
	}

	/********* Textos ************/

	public String getTexts(String id) {
		return getDriver().findElement(By.id(id)).getText();
	}

	// By pega Tag
	public String getTexts(By by) {
		return getDriver().findElement(by).getText();
	}

	/********* Alerts ************/

	public String alertGetText() {
		Alert alert = getDriver().switchTo().alert();
		return alert.getText();
	}

	public String alertGetTextAccept() {
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;

	}

	public String alertGetTextDeny() {
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.dismiss();
		return valor;
	}

	public void alertWrite(String valor) {
		Alert alert = getDriver().switchTo().alert();
		alert.sendKeys(valor);
		alert.accept();
	}

	/********* Frames e Janelas ************/

	public void inFrame(String id) {
		getDriver().switchTo().frame(id);
	}

	public void outFrame() {
		getDriver().switchTo().defaultContent();
	}

	public void changeWindows(String id) {
		getDriver().switchTo().window(id);
	}

	/*********** JS ***********/
	public Object useJS(String cmd, Object... param) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		return js.executeScript(cmd, param);
	}

	/*********** Tabela ***********/
	public void clickButtonTable(String colunaBusca, String valor, String colunaBotao, String idTabela) {
		//procurar coluna do registro
		WebElement tabela = getDriver().findElement(By.xpath("//*[@id='elementosForm:tableUsuarios']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);
		
		//encontrar a linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		
		//procurar coluna do botao
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
		
		//clicar no botao da celula encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
		celula.findElement(By.xpath(".//input")).click();
		
	}

	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
		int idLinha = -1;
		for(int i = 0; i < linhas.size(); i++) {
			if(linhas.get(i).getText().equals(valor)) {
				idLinha = i+1;
				break;
			}
		}
		return idLinha;
	}

	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for(int i = 0; i < colunas.size(); i++) {
			if(colunas.get(i).getText().equals(coluna)) {
				idColuna = i+1;
				break;
			}
		}
		return idColuna;
	}

	
}
