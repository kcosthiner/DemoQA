package demoqa.steps;

import demoqa.elementos.Elementos;
import demoqa.metodos.Metodos;
import demoqa.runner.Executa;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class CadastroFormularioTeste {

	Elementos el = new Elementos();
	Metodos metodos = new Metodos();

	@Before
	public void iniciaTeste() {
		Executa.abrirNavegador();

	}
	
	@After
	public void finalizarTeste() {
		metodos.fecharNavegador();
	}

	@Dado("que o usuario esteja no formulario de cadastro")
	public void queOUsuarioEstejaNoFormularioDeCadastro() {

		metodos.scroll(0, 350);
		metodos.clicar(el.menuElements);
		metodos.clicar(el.btnTextBox);

	}

	@Quando("preencher todos os campos obrigatorios")
	public void preencherTodosOsCamposObrigatorios() {

		metodos.escrever(el.userName, "teste");
		metodos.escrever(el.userEmail, "teste@teste.yk");
		metodos.escrever(el.currentAddress, "teste st. 15800");
		metodos.escrever(el.permAdress, "teste st. 15800");

	}

	@Quando("enviar os dados")
	public void enviarOsDados() {
		metodos.scroll(0, 300);
		metodos.clicar(el.btnSubmit);
	}

	@Entao("validamos os dados cadastrados")
	public void validamosOsDadosCadastrados() {
		metodos.validarTexto(el.nameCapturado, "teste");
		metodos.tirarEvidencia("CT01 - Cadastrar usuario");
	}

}
